package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisDakuTemplateClassifyEntity;
import com.anmi.anime.repository.daku.custom.dao.DakuClassifyDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangjue on 2017/11/28.
 */
public interface GafisDakuTemplateClassifyRepository extends JpaRepository<GafisDakuTemplateClassifyEntity,Long>, DakuClassifyDao{

    List<GafisDakuTemplateClassifyEntity> findByCardidAndFgp(String cardId, long fgp);

    //Page<GafisDakuTemplateClassifyEntity> findCardidDistinct(Pageable pageable);


}
