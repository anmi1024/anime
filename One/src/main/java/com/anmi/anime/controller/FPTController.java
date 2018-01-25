package com.anmi.anime.controller;

import com.anmi.anime.service.FPTService;
import com.anmi.anime.service.GatherDataService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.directory.api.util.CharConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by wangjue on 2017/9/25.
 */
@Controller
@RequestMapping("/fpt")
public class FPTController {
    @Autowired
    private GatherDataService gatherDataService;
    @Autowired
    private FPTService fptService;

    @RequestMapping("/export")
    public void downloadFPT(@RequestParam("keyFile") MultipartFile multipartFile, @RequestParam("fptPathServer") String fptPathServer,@RequestParam("fptType") String fptType,  HttpServletResponse response) {
        String fileName = multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().lastIndexOf("."));
        long flag = System.currentTimeMillis();
        response.addCookie(new Cookie("fileDownloadToken", "done"));
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"-"+flag+".zip\"");
        try {
            List<String> keys = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
            String error = "";
            try (ZipOutputStream out = new ZipOutputStream(response.getOutputStream())) {
                Set<String> sets = new HashSet<>(keys);
                for (String key : sets) {
                    byte[] fpt = fptService.downloadFPTByKeyId(key, fptType, fptPathServer);
                    if (fpt == null) error += key +"\r\n";
                    else {
                        out.putNextEntry(new ZipEntry(key+".FPT"));
                        out.write(fpt);
                    }
                }
                if (!error.isEmpty()) {
                    out.putNextEntry(new ZipEntry("export-error"+"-"+flag+".txt"));
                    out.write(IOUtils.toByteArray(IOUtils.toInputStream(error)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.flushBuffer();
                } catch (Exception e){}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("inputfile") MultipartFile multipartFile, @RequestParam("fileServer") String fileServer,@RequestParam("coverFPT") String coverFPT, HttpServletRequest request) {
        if (request.getCharacterEncoding() == null) {
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {}
        }
        String fptPath = multipartFile.getOriginalFilename();
        if (fptPath == null || "".equals(fptPath)) {
            request.setAttribute("message","未选择文件！");
            return new ModelAndView("redirect:/index/fpt/0/10");
        }
        String fileSuffix = fptPath.substring(fptPath.lastIndexOf("."));
        try {
            if (".txt".equals(fileSuffix)) {
                List<String> paths = IOUtils.readLines(multipartFile.getInputStream(),"GBK");
                gatherDataService.setClearCollect();
                gatherDataService.multiProcessFPT(fileServer, paths, coverFPT);
            } else if (".fpt".equals(fileSuffix) || ".FPT".equals(fileSuffix)) {
                byte[] fpt = multipartFile.getBytes();
                gatherDataService.singleProcessFPT("1_1", fptPath, fpt, coverFPT);
            } else {
                request.setAttribute("message","valid file :"+fptPath+" , 仅支持txt和fpt或FPT结尾的文件！");
            }
            List<String> processMessage = gatherDataService.getProcessErrorMessage();
            request.setAttribute("result",processMessage == null || processMessage.size()==0 ? "" : processMessage.get(0));
            request.setAttribute("message","正在处理 : "+multipartFile.getOriginalFilename());
        } catch (IOException e) {
            request.setAttribute("message",e.getMessage());
        }
        return new ModelAndView("redirect:/index/fpt/0/10");
    }

    @RequestMapping(value = "/upload/result",method = RequestMethod.GET)
    public @ResponseBody String sendQueryResult() {
        List<String> processMessageRateGet = gatherDataService.getProcessMessageRate();
        List<String> processMessageRate = processMessageRateGet;
        if (processMessageRate != null && processMessageRate.size() > 1) {
            Collections.sort(processMessageRate, (s1, s2) -> {
                String[] array1 = s1.toString().split("\\|")[0].split(":");
                int current1 = Integer.valueOf(array1[1].trim());
                String[] array2 = s2.toString().split("\\|")[0].split(":");
                int current2 = Integer.valueOf(array2[1].trim());
                return current1 > current2 ? -1 : 1;
            });
        }
        return processMessageRate == null || processMessageRate.size() == 0 ? "" : processMessageRate.get(0);
    }

    @RequestMapping(value = "/upload/error",method = RequestMethod.GET)
    public @ResponseBody List getErrorResult() {
        List resultProcessErrorMessage = new ArrayList();
        Vector<String> processErrorMessage = gatherDataService.getProcessErrorMessage();
        long totalError = gatherDataService.getErrorMsgCount();
        if (processErrorMessage!=null && processErrorMessage.size() > 8) {
            Vector<String> vector = new Vector<>();
            for (int t=0;t<processErrorMessage.size()-8;t++) {
                vector.add(processErrorMessage.get(t));
            }
            processErrorMessage.removeAll(vector);
        }
        resultProcessErrorMessage.add(totalError);
        resultProcessErrorMessage.add(processErrorMessage);
        return resultProcessErrorMessage;
    }

}
