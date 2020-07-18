package com.lzx.getbookinfo.service.impl;

import com.lzx.getbookinfo.service.GetContentService;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
@Service
public class GetBookInfoServiceImpl implements GetContentService {

    OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    public String getContent(String url, Map<String, String> params) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        //post方式提交的数据
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        FormBody formBody = builder.build();
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1")
                .post(formBody)
                .build();
        String content = null;
        //创建/Call
        Call call = okHttpClient.newCall(request);
        try {
            content  = call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
