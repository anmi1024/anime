package com.anmi.anime.service;

import java.util.List;

/**
 * Created by wangjue on 2017/10/24.
 */
public interface FPTService {

    void export(List<String> kId);

    byte[] downloadFPTByKeyId(String keyId, String type, String fptPathServer);
}
