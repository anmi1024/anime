package com.anmi.anime.controller;

import com.anmi.anime.model.GafisDakuPairsClassifyEntity;
import com.anmi.anime.model.GafisDakuTemplateClassifyEntity;
import com.anmi.anime.model.vo.PairsClassifyVO;
import com.anmi.anime.service.DakuClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangjue on 2017/12/6.
 */
@Controller
public class DakuClassifyController {

    @Autowired
    private DakuClassifyService dakuClassifyService;

    @RequestMapping("/classify")
    public String toTTClassifyPage(HttpServletRequest request) {
        PairsClassifyVO pairsClassifyVO = new PairsClassifyVO();
        pairsClassifyVO.setPairType("tt");
        List<GafisDakuPairsClassifyEntity> list = dakuClassifyService.findPairsClassify(pairsClassifyVO);
        request.setAttribute("pairsClassifyList",list);
        request.setAttribute("pairsClassifyVO",pairsClassifyVO);
        return "match/pairsClassifyTT";
    }

    @RequestMapping("/classify/classifyTT")
    public String listTemplateClassify(HttpServletRequest request, PairsClassifyVO pairsClassifyVO) {
        pairsClassifyVO.setPairType("tt");
        List<GafisDakuPairsClassifyEntity> list = dakuClassifyService.findPairsClassify(pairsClassifyVO);
        request.setAttribute("pairsClassifyVO",pairsClassifyVO);
        request.setAttribute("pairsClassifyList",list);
        return "match/pairsClassifyTT";
    }

    public String listLatentClassify(HttpServletRequest request, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {

        return "";
    }
}
