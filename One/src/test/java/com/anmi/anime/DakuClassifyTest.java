package com.anmi.anime;

import com.anmi.anime.model.vo.PairsClassifyVO;
import com.anmi.anime.service.DakuClassifyService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjue on 2017/11/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DakuClassifyTest {

    @Autowired
    private DakuClassifyService dakuClassifyService;

    @Test
    public void test_classify() throws IOException{
        List<String> cards = new ArrayList<>();
        cards.add("P1201606301467272659724");
        List<String> cardsFromFileT = FileUtils.readLines(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\classify\\tt-pairs.txt"));
        List<String> cardsFromFileL = FileUtils.readLines(new File("C:\\Users\\wangjue\\Desktop\\测试平台\\classify\\lt-pairs.txt"));
        dakuClassifyService.classify(cardsFromFileL,"lt");
    }

    @Test
    public void test_pairsClassify() {
        PairsClassifyVO pairsClassifyVO = new PairsClassifyVO();
        pairsClassifyVO.setPairType("lt");
        pairsClassifyVO.setMntCount(20);
        pairsClassifyVO.setMntCountLess(80);
        dakuClassifyService.findPairsClassify(pairsClassifyVO);
    }
}
