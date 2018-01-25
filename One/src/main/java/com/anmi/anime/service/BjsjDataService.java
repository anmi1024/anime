package com.anmi.anime.service;

import java.util.List;

/**
 * Created by wangjue on 2017/11/29.
 */
public interface BjsjDataService {
    void imageProcess(List<String> imageUrl);

    void imagesProcessByGAFIS(List<String> imagesUrl);

    void imagesProcessByGAFISSingle(List<String> imagesUrl);
}
