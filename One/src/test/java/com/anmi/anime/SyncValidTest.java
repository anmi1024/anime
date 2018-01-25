package com.anmi.anime;

import com.anmi.anime.utils.ProtoHttpClientUtil;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wangjue on 2017/10/23.
 */
public class SyncValidTest {

    @Test
    public void test_validSync() {
        String  http = "http://10.1.7.204:10010/GetSyncData?data_type=template_finger&sid=2995711&fgp=1&is_ridge=false";
        byte[] sync = ProtoHttpClientUtil.download(http);
        String s = new String(sync);
        try {
            JSONObject jsonObject = new JSONObject(s);
            Object o = jsonObject.get("status");
            System.out.println(o.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(sync.length > 0);
    }
}
