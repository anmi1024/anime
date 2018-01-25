package com.anmi.anime.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangjue on 2017/9/21.
 */
@Component
@ConfigurationProperties(prefix = "spring.fpt")
public class FPTConfig {

    private String imageUrl;
    private String extractorUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExtractorUrl() {
        return extractorUrl;
    }

    public void setExtractorUrl(String extractorUrl) {
        this.extractorUrl = extractorUrl;
    }
}
