package com.anmi.anime.utils;

import com.anmi.anime.fpt.FPT3File;
import com.anmi.anime.fpt.FPT4File;
import com.anmi.anime.fpt.FPTProperties;
import com.google.protobuf.ByteString;
import monad.rpc.protocol.CommandProto;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.gfpt4lib.fpt4code;
import nirvana.hall.c.services.gloclib.glocdef;
import nirvana.hall.protocol.extract.ExtractProto;
import nirvana.hall.protocol.extract.FeatureDisplayProto;
import nirvana.hall.protocol.extract.LatentConverterExtractProto;
import nirvana.hall.protocol.image.FirmImageDecompressProto;
import nirvana.hall.protocol.image.ImageCompressProto;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjue on 2017/9/6.
 */
public class ProcessImageAndFeatureUtil {

    private static Logger logger = Logger.getLogger(ProcessImageAndFeatureUtil.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 图像解压缩
     * @param gafisImg
     * @return
     * @throws Exception
     */
    public static ByteString decompress(glocdef.GAFISIMAGESTRUCT gafisImg, String personId, int fgp, int times,String imageURL,byte compressMethod) throws Exception {
        byte WSQCompressMethod = (byte)102;
        //gafisImg.stHead().nCompressMethod_$eq(compressMethod);
        ByteString in = null;
        FirmImageDecompressProto.FirmImageDecompressRequest.Builder request =  FirmImageDecompressProto.FirmImageDecompressRequest.newBuilder();
        request.setCprData(ByteString.copyFrom(gafisImg.toByteArray(AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN)));
        CommandProto.BaseCommand baseResponse = ProtoHttpClientUtil.call(imageURL, FirmImageDecompressProto.FirmImageDecompressRequest.cmd, request.build());
        if (baseResponse.getStatus().equals(CommandProto.CommandStatus.OK)) {
            if(baseResponse.hasExtension(FirmImageDecompressProto.FirmImageDecompressResponse.cmd)){
                FirmImageDecompressProto.FirmImageDecompressResponse response = baseResponse.getExtension(FirmImageDecompressProto.FirmImageDecompressResponse.cmd);
                in = response.getOriginalData();
                glocdef.GAFISIMAGESTRUCT img = new glocdef.GAFISIMAGESTRUCT();
                img.fromByteArray(in.toByteArray(), AncientConstants.UTF8_ENCODING(),ByteOrder.BIG_ENDIAN);
            } else {
                logger.error(sdf.format(new Date())+"| "+personId+"_"+fgp+":fail to decompress: response haven't FirmImageDecompressResponse");
            }
        } else if (baseResponse.getStatus().equals(CommandProto.CommandStatus.FAIL)) {
            if (times == 2) {
                throw new Exception(sdf.format(new Date())+"| "+personId+"_"+fgp+":fail to decompress "+ baseResponse.getMsg()+"&");
            } else {
                in = decompress(gafisImg, personId, fgp, times + 1, imageURL, WSQCompressMethod);
            }

        }
        return in;
    }

    /**
     * 图像压缩为WSQ格式
     * @param gafisImg
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     */
    public static ByteString compressWSQ(ByteString gafisImg,String personId,int fgp,String imageURL) throws Exception{
        ByteString in = null;
        ImageCompressProto.ImageCompressRequest.Builder request = ImageCompressProto.ImageCompressRequest.newBuilder();
        request.setOriginalData(gafisImg);
        request.setCompressMethod(ImageCompressProto.ImageCompressRequest.CompressMethod.WSQ);
        CommandProto.BaseCommand baseResponse = ProtoHttpClientUtil.call(imageURL, ImageCompressProto.ImageCompressRequest.cmd, request.build());
        if (baseResponse.getStatus().equals(CommandProto.CommandStatus.OK)) {
            if(baseResponse.hasExtension(ImageCompressProto.ImageCompressResponse.cmd)){
                ImageCompressProto.ImageCompressResponse response = baseResponse.getExtension(ImageCompressProto.ImageCompressResponse.cmd);
                in = response.getCprData();
            } else {
                logger.error(sdf.format(new Date())+"| "+personId+"_"+fgp+":fail to decompress wsq: response haven't ImageCompressResponse");
            }
        } else if (baseResponse.getStatus().equals(CommandProto.CommandStatus.FAIL)) {
            throw new Exception(sdf.format(new Date())+"| "+personId+"_"+fgp+":fail to decompress wsq"+ baseResponse.getMsg());
        }
        return in;
    }

    /**
     * 图像提特征（捺印）
     * @param gafisImg
     * @return
     * @throws Exception
     */
    public static ByteString[] extractor(glocdef.GAFISIMAGESTRUCT gafisImg, String personId, int fgp,int imgType, String extractorURL) throws Exception {
        ByteString mnt = null;
        ByteString bin = null;
        ExtractProto.ExtractRequest.Builder request = ExtractProto.ExtractRequest.newBuilder();
        request.setFeatureTry(ExtractProto.NewFeatureTry.V1);
        request.setImgData(ByteString.copyFrom(gafisImg.toByteArray(AncientConstants.UTF8_ENCODING(),ByteOrder.BIG_ENDIAN)));
        if (imgType == 1) request.setMntType(ExtractProto.ExtractRequest.FeatureType.FingerTemplate);
        else request.setMntType(ExtractProto.ExtractRequest.FeatureType.PalmTemplate);
        request.setPosition(getFingerPosition(fgp));
        CommandProto.BaseCommand baseResponse = ProtoHttpClientUtil.call(extractorURL, ExtractProto.ExtractRequest.cmd, request.build());
        if (baseResponse.getStatus().equals(CommandProto.CommandStatus.OK)) {
            if(baseResponse.hasExtension(ExtractProto.ExtractResponse.cmd)) {
                ExtractProto.ExtractResponse response = baseResponse.getExtension(ExtractProto.ExtractResponse.cmd);
                mnt = response.getMntData();
                bin = response.getBinData();
            } else {
                logger.error(sdf.format(new Date())+"| fail to extractor: response haven't ExtractResponse");
            }
        } else if (baseResponse.getStatus().equals(CommandProto.CommandStatus.FAIL)) {
            throw new Exception(sdf.format(new Date())+"| "+personId+"_"+fgp+":fail to extractor"+ baseResponse.getMsg());
        }
        return new ByteString[]{mnt,bin};
    }

    public static byte[] imageWithHead(byte[] image) {
        glocdef.GAFISIMAGESTRUCT gafisImg = new glocdef.GAFISIMAGESTRUCT();
        gafisImg.stHead().nWidth_$eq((short)512);
        gafisImg.stHead().nHeight_$eq((short)512);
        gafisImg.stHead().nBits_$eq((byte)8);
        gafisImg.stHead().nResolution_$eq((short)500);
        gafisImg.stHead().nCaptureMethod_$eq((byte)0);
        gafisImg.stHead().bIsCompressed_$eq((byte)0);
        gafisImg.stHead().nCompressMethod_$eq((byte)0);
        gafisImg.stHead().nImageType_$eq((byte)glocdef.GAIMG_IMAGETYPE_FINGER());
        gafisImg.stHead().nImgSize_$eq(image.length);
        gafisImg.bnData_$eq(image);
        return gafisImg.toByteArray(AncientConstants.UTF8_ENCODING(),ByteOrder.BIG_ENDIAN);
    }


    public static ByteString latentConverterExtractorForFPT3(FPT3File.LogicLPFinger fingerData, String caseId, String cardId, String extractorURL) throws Exception {
        LatentConverterExtractProto.LatentConverterExtractRequest.FingerLData.Builder data = LatentConverterExtractProto.LatentConverterExtractRequest.FingerLData.newBuilder();
        data.setPattern(fingerData.getPattern().trim());
        data.setFingerDirection(fingerData.getFingerDirection().trim());
        data.setFeatureCount(String.valueOf(fingerData.getFeatureCount()).trim());
        data.setFgp(fingerData.getFgp().trim());
        data.setCenterPoint(fingerData.getCenterPoint().trim());
        data.setSubCenterPoint(fingerData.getSubCenterPoint().trim());
        data.setLeftTriangle(fingerData.getLeftTriangle().trim());
        data.setRightTriangle(fingerData.getRightTriangle().trim());
        data.setFeature(fingerData.getFeature());
        data.setImgHorizontalLength(String.valueOf(fingerData.getImgHorizontalLength()).trim());
        data.setImgVerticalLength(String.valueOf(fingerData.getImgVerticalLength()).trim());
        data.setDpi(String.valueOf(fingerData.getDpi()).trim());
        ByteString latentMnt = latentConverterExtractor(data,caseId,cardId,extractorURL);
        return latentMnt;

    }

    public static ByteString latentConverterExtractorForFPT4(FPT4File.LogicLPFinger fingerData, String caseId, String cardId, String extractorURL) throws Exception {
        LatentConverterExtractProto.LatentConverterExtractRequest.FingerLData.Builder data = LatentConverterExtractProto.LatentConverterExtractRequest.FingerLData.newBuilder();
        data.setPattern(fingerData.getPattern().trim());
        data.setFingerDirection(fingerData.getFingerDirection().trim());
        data.setFeatureCount(String.valueOf(fingerData.getFeatureCount()).trim());
        data.setFgp(fingerData.getFgp().trim());
        data.setCenterPoint(fingerData.getCenterPoint().trim());
        data.setSubCenterPoint(fingerData.getSubCenterPoint().trim());
        data.setLeftTriangle(fingerData.getLeftTriangle().trim());
        data.setRightTriangle(fingerData.getRightTriangle().trim());
        data.setFeature(fingerData.getFeature());
        data.setImgHorizontalLength(String.valueOf(fingerData.getImgHorizontalLength()).trim());
        data.setImgVerticalLength(String.valueOf(fingerData.getImgVerticalLength()).trim());
        data.setDpi(String.valueOf(fingerData.getDpi()).trim());
        return latentConverterExtractor(data,caseId,cardId,extractorURL);
    }
    /**
     * 现场特征转换
     * @return
     * @throws Exception
     */
    public static ByteString latentConverterExtractor(LatentConverterExtractProto.LatentConverterExtractRequest.FingerLData.Builder data, String caseId, String cardId, String extractorURL) throws Exception {
        ByteString mnt = null;
        LatentConverterExtractProto.LatentConverterExtractRequest.Builder request = LatentConverterExtractProto.LatentConverterExtractRequest.newBuilder();
        request.setFingerLData(data);

        CommandProto.BaseCommand baseResponse = ProtoHttpClientUtil.call(extractorURL, LatentConverterExtractProto.LatentConverterExtractRequest.cmd, request.build());
        if (baseResponse.getStatus().equals(CommandProto.CommandStatus.OK)) {
            if(baseResponse.hasExtension(LatentConverterExtractProto.LatentConverterExtractResponse.cmd)) {
                LatentConverterExtractProto.LatentConverterExtractResponse response = baseResponse.getExtension(LatentConverterExtractProto.LatentConverterExtractResponse.cmd);
                mnt = response.getMntData();
            } else {
                logger.error(sdf.format(new Date())+"| "+caseId+"_"+cardId+":fail to converter extractor: response haven't LatentConverterExtractResponse");
            }
        } else if (baseResponse.getStatus().equals(CommandProto.CommandStatus.FAIL)) {
            throw new Exception(sdf.format(new Date())+"| "+caseId+"_"+cardId+":fail to converter extractor"+ baseResponse.getMsg());
        }
        return mnt;
    }

    /**
     * 合并图像特征，显示可见图像
     * @param gafisImg
     * @param gafisMnt
     * @param extractorURL
     * @return
     * @throws Exception
     */
    public static ByteString display(byte[] gafisImg,byte[] gafisMnt,String extractorURL) throws Exception {
        ByteString displayImage = null;
        FeatureDisplayProto.FeatureDisplayRequest.Builder request = FeatureDisplayProto.FeatureDisplayRequest.newBuilder();
        request.setDecompressImageData(ByteString.copyFrom(gafisImg));
        request.setMntDispData(ByteString.copyFrom(gafisMnt));
        CommandProto.BaseCommand baseResponse = ProtoHttpClientUtil.call(extractorURL, FeatureDisplayProto.FeatureDisplayRequest.cmd, request.build());
        if (baseResponse.getStatus().equals(CommandProto.CommandStatus.OK)) {
            if (baseResponse.hasExtension(FeatureDisplayProto.FeatureDisplayResponse.cmd)) {
                FeatureDisplayProto.FeatureDisplayResponse response = baseResponse.getExtension(FeatureDisplayProto.FeatureDisplayResponse.cmd);
                displayImage = response.getDisplayData();
            } else {
                logger.error(sdf.format(sdf.format(new Date())+"| fail to display: response haven't FeatureDisplayResponse"));

            }
        } else if (baseResponse.getStatus().equals(CommandProto.CommandStatus.FAIL)) {
            throw new Exception(sdf.format(new Date())+"| fail to display:" + baseResponse.getMsg());
        }
        return displayImage;
    }


    /**
     * fpg to FingerPosition
     * @param fgp
     * @return
     */
    public static ExtractProto.FingerPosition getFingerPosition(int fgp) {
        ExtractProto.FingerPosition position = ExtractProto.FingerPosition.FINGER_R_THUMB;
        switch (fgp) {
            case 1 : position = ExtractProto.FingerPosition.FINGER_R_THUMB; break;
            case 2 : position = ExtractProto.FingerPosition.FINGER_R_INDEX; break;
            case 3 : position = ExtractProto.FingerPosition.FINGER_R_MIDDLE;break;
            case 4 : position = ExtractProto.FingerPosition.FINGER_R_RING;  break;
            case 5 : position = ExtractProto.FingerPosition.FINGER_R_LITTLE;break;
            case 6 : position = ExtractProto.FingerPosition.FINGER_L_THUMB; break;
            case 7 : position = ExtractProto.FingerPosition.FINGER_L_INDEX; break;
            case 8 : position = ExtractProto.FingerPosition.FINGER_L_MIDDLE;break;
            case 9 : position = ExtractProto.FingerPosition.FINGER_L_RING; break;
            case 10 : position = ExtractProto.FingerPosition.FINGER_L_LITTLE;break;
        }
        return position;
    }

    /**
     * fpt4code to glocdef
     * @param codeFromFpt
     */
    public static int getCodeFromGAFISImage(String codeFromFpt) {
        if (codeFromFpt.length() < 4) throw new UnsupportedOperationException("【%s】 compress not supported".format(codeFromFpt));
        String prefixCodeFromFpt = codeFromFpt.substring(0,3);
        int code;
        if (fpt4code.GAIMG_CPRMETHOD_NOCPR_CODE().startsWith(prefixCodeFromFpt)) {
            code = glocdef.GAIMG_CPRMETHOD_DEFAULT();
        } else if (fpt4code.GAIMG_CPRMETHOD_GA10_CODE().startsWith(prefixCodeFromFpt)) {				// 公安部10倍压缩方法
            code = glocdef.GAIMG_CPRMETHOD_GA10();
        } else if (fpt4code.GAIMG_CPRMETHOD_EGFS_CODE().startsWith(prefixCodeFromFpt)) {		// 东方金指
            code = glocdef.GAIMG_CPRMETHOD_GFS();
        } else if (fpt4code.GAIMG_CPRMETHOD_EGFS_WSQ_CODE().endsWith("31")) {                   // 东方金指WSQ3.1压缩
            code = glocdef.GAIMG_CPRMETHOD_GFS();
        } else if (fpt4code.GAIMG_CPRMETHOD_PKU_CODE().startsWith(prefixCodeFromFpt)) {			// 北大高科
            code = glocdef.GAIMG_CPRMETHOD_PKU();
        } else if (fpt4code.GAIMG_CPRMETHOD_COGENT_CODE().startsWith(prefixCodeFromFpt)) {		// 北京海鑫
            code = glocdef.GAIMG_CPRMETHOD_COGENT();
        } else if (fpt4code.GAIMG_CPRMETHOD_WSQ_CODE().startsWith(prefixCodeFromFpt)) {			// WSQ压缩方法
            code = glocdef.GAIMG_CPRMETHOD_WSQ();
        } else if (fpt4code.GAIMG_CPRMETHOD_NEC_CODE().startsWith(prefixCodeFromFpt)) {			// 日本NEC
            code = glocdef.GAIMG_CPRMETHOD_NEC();
        } else if (fpt4code.GAIMG_CPRMETHOD_TSINGHUA_CODE().startsWith(prefixCodeFromFpt)) {	// 清华
            code = glocdef.GAIMG_CPRMETHOD_TSINGHUA();
        } else if (fpt4code.GAIMG_CPRMETHOD_BUPT_CODE().startsWith(prefixCodeFromFpt)) {		// 北京邮电大学
            code = glocdef.GAIMG_CPRMETHOD_BUPT();
        } else if (fpt4code.GAIMG_CPRMETHOD_MORPHO_CODE().startsWith(prefixCodeFromFpt)) {		// MORPHO
            code = glocdef.GAIMG_CPRMETHOD_MORPHO();
        } else if (fpt4code.GAIMG_CPRMETHOD_HLXT_CODE().startsWith(prefixCodeFromFpt)) {		//汉林信通
            code = glocdef.GAIMG_CPRMETHOD_HLXT();
        }else {
            throw new UnsupportedOperationException("【%s】 compress not supported".format(codeFromFpt));
        }
        return code;
    }

    public static glocdef.GAFISIMAGESTRUCT FPTFingerDataToGafisImage(FPTProperties properties) {
        glocdef.GAFISIMAGESTRUCT gafisImg = new glocdef.GAFISIMAGESTRUCT();
        gafisImg.stHead().bIsCompressed_$eq((byte)1);

        gafisImg.stHead().nCompressMethod_$eq((byte)getCodeFromGAFISImage(properties.getImgCompressMethod()));
        if (gafisImg.stHead().nCompressMethod() == 0) //no compress
            gafisImg.stHead().bIsCompressed_$eq((byte)0);

        gafisImg.stHead().nImageType_$eq((byte)glocdef.GAIMG_IMAGETYPE_FINGER());
        gafisImg.stHead().nWidth_$eq(Short.valueOf(properties.getImgHorizontalLength()));
        gafisImg.stHead().nHeight_$eq(Short.valueOf(properties.getImgVerticalLength()));
        gafisImg.stHead().nBits_$eq((byte)8);
        gafisImg.stHead().nResolution_$eq(Short.valueOf(properties.getDpi()));
        gafisImg.bnData_$eq(properties.getImgData());
        gafisImg.stHead().nImgSize_$eq(gafisImg.bnData().length);
        int positionInt = Integer.valueOf(properties.getFgp());
        if (positionInt > 10)
            gafisImg.stHead().bIsPlain_$eq((byte)1);

        return gafisImg;
    }

}
