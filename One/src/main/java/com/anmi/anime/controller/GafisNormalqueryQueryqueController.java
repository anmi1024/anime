package com.anmi.anime.controller;

import com.anmi.anime.model.GafisDakuQueryqueEntity;
import com.anmi.anime.model.vo.AnalyzeVO;
import com.anmi.anime.model.vo.QueryQueueVO;
import com.anmi.anime.service.GafisNormalqueryQueryqueService;
import com.anmi.anime.service.GatherDataService;
import com.anmi.anime.utils.ZipUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipOutputStream;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by wangjue on 2017/9/20.
 */
@Controller
@RequestMapping("/match")
public class GafisNormalqueryQueryqueController {

    @Autowired
    GafisNormalqueryQueryqueService gafisNormalqueryQueryqueService;

    @Autowired
    GatherDataService gatherDataService;

    @RequestMapping("/reSync")
    public ModelAndView reSync(@RequestParam("syncFile") MultipartFile multipartFile, @RequestParam("syncType") String syncType, HttpServletRequest request) {
        try {
            List<String> keys = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
            String reSyncResult = gatherDataService.reSync(syncType, keys);
            request.setAttribute("reSyncResult",reSyncResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/index/match/0/10");
    }

    @RequestMapping("/validSync")
    public void getValidSync(@RequestParam("validSyncFile") MultipartFile multipartFile, @RequestParam("dataType") String dataType,@RequestParam("syncUrl") String syncUrl,@RequestParam("isRidge") String isRidge,HttpServletResponse response) {
        String fileName = multipartFile.getOriginalFilename();
        response.addCookie(new Cookie("fileDownloadToken", "done"));
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"valid_result_"+fileName+"\"");
        try {
            List<String> keys = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
            List<String> syncInvalidList = gatherDataService.getValidSyncErrorList(keys, dataType, syncUrl, "true".equals(isRidge) ? true : false);
            IOUtils.writeLines(syncInvalidList, null ,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/validKeys")
    public void getValidKeys(@RequestParam("validFile") MultipartFile multipartFile, QueryQueueVO queryQueueVO, HttpServletResponse response) {
        String fileName = multipartFile.getOriginalFilename();
        response.addCookie(new Cookie("fileDownloadToken", "done"));
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
        try {
            List<String> keys = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
            List<String> validKeys = gafisNormalqueryQueryqueService.getValidSuccessList(keys, queryQueueVO);
            IOUtils.writeLines(validKeys, null ,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/produce")
    public void getMatchResult(@RequestParam("zipName") String zipName, QueryQueueVO queryQueueVO, HttpServletResponse response) {
        response.addCookie(new Cookie("fileDownloadToken", "done"));
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+zipName+".zip\"");
        try(ZipOutputStream out = new ZipOutputStream(response.getOutputStream())) {
            queryQueueVO.setMatchResultSavePath("/matchResult/"+ LocalDate.now()+"/exportFile");
            if (queryQueueVO.getCandMinScore() == null) queryQueueVO.setCandMinScore(0);
            if (queryQueueVO.getCandMaxScore() == null) {
                if (queryQueueVO.getQueryType() == 0) queryQueueVO.setCandMaxScore(100);
                else queryQueueVO.setCandMaxScore(1000);
            }
            String matchResultDir = gafisNormalqueryQueryqueService.getMatchResult(queryQueueVO);
            ZipUtil.compress(new File(matchResultDir),out,"");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.flushBuffer();
            } catch (Exception e){}
        }
    }

    @RequestMapping("/produceMatchResultFromQuery")
    public void getMatchResultFormQueryQue(@RequestParam("pkid") String pkid, HttpServletResponse response) {
        response.addCookie(new Cookie("fileDownloadToken", "done"));
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+pkid+".zip\"");
        try(ZipOutputStream out = new ZipOutputStream(response.getOutputStream())) {
            GafisDakuQueryqueEntity queryqueEntity = gafisNormalqueryQueryqueService.getGafisDakuQueryqueEntity(pkid);
            /*导出文件记录表中，如果已经导出，则直接使用---本地调试暂时注释掉*/
            //String matchResultDir = queryqueEntity.getQueryCandListDir();
            String matchResultDir = null;
            if (matchResultDir == null || matchResultDir.isEmpty()) {
                QueryQueueVO queryQueueVO = new QueryQueueVO();
                queryQueueVO.setMatchResultSavePath("/matchResult/" + LocalDate.now()+"/exportFile");
                queryQueueVO.setQueryType(queryqueEntity.getQuerytype().intValue());
                if (queryQueueVO.getQueryType() == 0)
                    queryQueueVO.setCandMinScore(queryqueEntity.getThreshold().intValue());
                else {
                    if (queryQueueVO.getCandMinScore() == null) queryQueueVO.setCandMinScore(0);
                }
                if (queryQueueVO.getCandMaxScore() == null) {
                    if (queryQueueVO.getQueryType() == 0) queryQueueVO.setCandMaxScore(100);
                    else queryQueueVO.setCandMaxScore(1000);
                }
                queryQueueVO.setOraSidS(queryqueEntity.getOrasidStart().intValue());
                queryQueueVO.setOraSidE(queryqueEntity.getOrasidEnd().intValue());
                matchResultDir = gafisNormalqueryQueryqueService.getMatchResult(queryQueueVO);
                String queryCandListDir = matchResultDir;
                if (queryQueueVO.getQueryType() == 0) queryCandListDir += "/tt";
                else if (queryQueueVO.getQueryType() == 2) queryCandListDir += "/lt";
                gafisNormalqueryQueryqueService.modifyQueryCandListDirByPkId(queryCandListDir, pkid);
            }
            ZipUtil.compress(new File(matchResultDir),out,"");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.flushBuffer();
            } catch (Exception e){}
        }
    }


    @RequestMapping(value = {"/send"})
    public ModelAndView sendQuery(@RequestParam("queryFile") MultipartFile multipartFile,@RequestParam("keyId") String keyId, QueryQueueVO queryQueueVO, HttpServletRequest request) {
        List<String> keyIds_template = new ArrayList<>();
        if (!keyId.isEmpty()) {
            keyIds_template.add(keyId);
            request.setAttribute("queryMessage","正在处理 : "+keyId);
        } else if (!multipartFile.isEmpty()) {
            try {
                List<String> lines = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
                for (String line : lines) {
                    if (line.isEmpty()) continue;
                    keyIds_template.add(line);
                }
                gafisNormalqueryQueryqueService.setClearCollect();
            } catch (IOException e) {
                request.setAttribute("queryMessage",e.getMessage());
            }
            request.setAttribute("queryMessage","正在处理 : "+multipartFile.getOriginalFilename());
        } else {
            request.setAttribute("queryMessage","未选择文件或发送比对卡号！");
            return new ModelAndView("redirect:/index/query/0/10");
        }
        queryQueueVO.setKeyId(keyIds_template);
        queryQueueVO.setFileName(multipartFile.getOriginalFilename());
        gafisNormalqueryQueryqueService.sendQuery(queryQueueVO);
        List<String> processMessage = gafisNormalqueryQueryqueService.getProcessMessage();
        request.setAttribute("queryResult",processMessage == null || processMessage.size()==0 ? "" : processMessage.get(0));
        request.setAttribute("queryMessage","正在处理 : "+multipartFile.getOriginalFilename());
        return new ModelAndView("redirect:/index/query/0/10");
    }

    @RequestMapping(value = "/send/result",method = RequestMethod.GET)
    public @ResponseBody String sendQueryResult() {
        List<String> processMessageGet = gafisNormalqueryQueryqueService.getProcessMessage();
        List<String> processMessage = processMessageGet;
        if (processMessage != null && processMessage.size() > 1) {
            Collections.sort(processMessage, (s1, s2) -> {
                //100:10:1 , xxx
                //总数:当前处理:oraSid ,xxx
                if (s1 != null && s2 != null) {
                    String[] array1 = s1.toString().split(":");
                    int current1 = Integer.valueOf(array1[1].trim());
                    String[] array2 = s2.toString().split(":");
                    int current2 = Integer.valueOf(array2[1].trim());
                    return current1 > current2 ? -1 : 1;
                }
                return 1;
            });
        }
        return processMessage == null || processMessage.size() == 0 ? "" : processMessage.get(0);
    }

    @RequestMapping(value = "/send/error",method = RequestMethod.GET)
    public @ResponseBody List getErrorResult() {
        List resultProcessErrorMessage = new ArrayList();
        List<String> processErrorMessage = gafisNormalqueryQueryqueService.getProcessErrorMessage();
        if (processErrorMessage!=null && processErrorMessage.size() > 8) {
            for (Iterator<String> iter = processErrorMessage.iterator(); iter.hasNext();) {
                iter.next();
                iter.remove();
                if (processErrorMessage.size() <= 8) break;
            }
        }
        long totalError = gafisNormalqueryQueryqueService.getErrorMsgCount();
        resultProcessErrorMessage.add(totalError);
        resultProcessErrorMessage.add(processErrorMessage);
        return resultProcessErrorMessage;
    }

    @RequestMapping(value = "/analyze/download", method = RequestMethod.GET)
    public void getAnalyzeFilePath(@RequestParam("analyzeFilePath") String analyzeFilePath, HttpServletResponse response) {
        response.addCookie(new Cookie("fileDownloadToken", "done"));
        response.setContentType("application/x-msdownload;charset=utf-8");
        try {
            File analyzeFile = new File(analyzeFilePath);
            if (analyzeFile.exists()) {
                response.setHeader("Content-Disposition", "attachment; filename=\""+analyzeFile.getName()+"\"");
                List<String> list = FileUtils.readLines(analyzeFile);
                IOUtils.writeLines(list, null, response.getOutputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/analyze",method = RequestMethod.POST)
    public String getAnalyzeResult1(@RequestParam("truePairFile") MultipartFile multipartFile, @RequestParam("analyzePkId") String analyzePkId, HttpServletRequest request) {
        try {
            List<String> truePairs = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
            AnalyzeVO analyzeVO = gafisNormalqueryQueryqueService.getAnalyzeResult(truePairs, analyzePkId);
            request.setAttribute("viewResult","true");
            request.setAttribute("analyzePkId",analyzePkId);
            request.setAttribute("analyzeVO",analyzeVO);
            if (analyzeVO.getQueryType() == 0) return "match/matchAnalyzeTTResult";
            else if (analyzeVO.getQueryType() == 2) return "match/matchAnalyzeLTResult";
            else {
                request.setAttribute("message","queryType : "+analyzeVO.getQueryType() +" , is not support!");
                return "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("message",e.getMessage());
            return "error";
        }

    }

    @RequestMapping(value = "/toAnalyzePage")
    public String toTTAnalyzeResultPage(HttpServletRequest request, @RequestParam("analyzePkIdWithQueryType") String analyzePkIdWithQueryType) {
        String analyzePkId = analyzePkIdWithQueryType.split("-")[0].trim();
        String queryType = analyzePkIdWithQueryType.split("-")[1].trim();
        request.setAttribute("analyzeVO",new AnalyzeVO());
        request.setAttribute("analyzePkId",analyzePkId);
        request.setAttribute("viewResult","false");
        if (Integer.valueOf(queryType) == 0) return "match/matchAnalyzeTTResult";
        else if (Integer.valueOf(queryType) == 2) return "match/matchAnalyzeLTResult";
        else {
            request.setAttribute("message","queryType : "+queryType +" , is not support!");
            return "error";
        }
    }



}
