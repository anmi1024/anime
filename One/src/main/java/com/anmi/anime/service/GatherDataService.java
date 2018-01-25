package com.anmi.anime.service;


import java.util.List;
import java.util.Vector;

/**
 * Created by wangjue on 2017/9/21.
 */
public interface GatherDataService {
    void singleProcessFPT(String flag, String fptName, byte[] data, String coverFPT);

    void multiProcessFPT(String fileServer, List<String> fptPaths, String coverFPT);

    /*错误计数*/
    Long getErrorMsgCount();

    Vector<String> getProcessErrorMessage();

    Vector<String> getProcessMessageRate();

    //重置记录
    void setClearCollect();

    /**
     * 验证底库数据
     * @param keysList
     * @param dataType
     * @return
     */
    List<String> getValidSyncErrorList(List<String> keysList, String dataType, String url, boolean isRidge);

    String reSync(String syncType, List<String> reSyncList);

}
