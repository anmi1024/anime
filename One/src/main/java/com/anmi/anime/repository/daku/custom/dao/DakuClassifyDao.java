package com.anmi.anime.repository.daku.custom.dao;

import com.anmi.anime.model.vo.PairsClassifyVO;

import java.util.List;

/**
 * Created by wangjue on 2017/12/7.
 */
public interface DakuClassifyDao {
    List<String> findTemplateCard(PairsClassifyVO pairsClassifyVO);

    List<String> findLatentCard(PairsClassifyVO pairsClassifyVO);
}
