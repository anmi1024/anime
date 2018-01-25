package com.anmi.anime.controller;

import com.anmi.anime.serviceImpl.BjsjDataServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangjue on 2017/12/1.
 */
@Controller
@RequestMapping("/bjsj")
public class BjsjDataController {
    @Autowired
    private BjsjDataServiceImpl bjsjDataService;

    @RequestMapping("/gz_palm")
    public String reExtractorFeaturePalm(@RequestParam("gzPalmKeyFile") MultipartFile multipartFile, HttpServletRequest request) {
        try {
            List<String> paths = IOUtils.readLines(multipartFile.getInputStream(), "GBK");
            bjsjDataService.imagesProcessByGAFIS(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "bjsj/index";
    }
}
