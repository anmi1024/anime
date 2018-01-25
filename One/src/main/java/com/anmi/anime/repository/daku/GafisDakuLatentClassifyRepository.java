package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisDakuLatentClassifyEntity;
import com.anmi.anime.repository.daku.custom.dao.DakuClassifyDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangjue on 2017/11/28.
 */
public interface GafisDakuLatentClassifyRepository extends JpaRepository<GafisDakuLatentClassifyEntity,Long>,DakuClassifyDao {

    List<GafisDakuLatentClassifyEntity> findByCardid(String cardId);

}
