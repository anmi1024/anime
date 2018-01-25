package com.anmi.anime.controller;

import com.anmi.anime.model.GafisDakuQueryqueEntity;
import com.anmi.anime.service.GafisNormalqueryQueryqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangjue on 2017/10/10.
 */
@Controller
@RequestMapping("/index")
public class LoginController {

    @Autowired
    GafisNormalqueryQueryqueService normalqueryQueryqueService;

    @RequestMapping("/bjsj")
    public String index_bjsj() {
        return "bjsj/index";
    }

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("redirect:/index/query/0/10");
    }

    @RequestMapping("/{showTab}/{page}/{size}")
    public String index(HttpServletRequest request,@PathVariable String showTab,@PathVariable Integer page,@PathVariable Integer size) {
        Page<GafisDakuQueryqueEntity> queryqueEntityList = normalqueryQueryqueService.getPageQueryqueue(page,size);
        request.setAttribute("queryqueList",queryqueEntityList);
        request.setAttribute("showTab", showTab);
        return "index";
    }
}
