package com.anmi.anime.service;

import com.anmi.anime.model.GafisDakuLatentClassifyEntity;
import com.anmi.anime.model.GafisDakuPairsClassifyEntity;
import com.anmi.anime.model.GafisDakuTemplateClassifyEntity;
import com.anmi.anime.model.vo.PairsClassifyVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by wangjue on 2017/11/28.
 */
public interface DakuClassifyService {
    void classify(List<String> cards,String cardType,String http);

    void classify(List<String> cards,String cardType);

    Page<GafisDakuLatentClassifyEntity> findLatentClassify(int page, int size);

    Page<GafisDakuTemplateClassifyEntity> findTemplateClassify(int page, int size);

    List<GafisDakuPairsClassifyEntity> findPairsClassify(PairsClassifyVO pairsClassifyVO);
}
