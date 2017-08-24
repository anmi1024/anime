package com.anmi.anime.fpt.fpt5.reflect;

/**
 * Created by wangjue on 2017/7/5.
 */
public class FPT5Base {
    public enum XXLY { //信息来源
        XZ("XZ"),     //刑专系统
        JZ("JZ"),     //警综平台
        AFIS("AFIS"),   //指掌纹自动识别系统
        RYCJ("RYCJ");   //人员一体化采集系统

        private String name;
        XXLY(String name) {
            this.name = name;
        }
    }

    public static final String UTF8_ENCODEING = "UTF-8";
}
