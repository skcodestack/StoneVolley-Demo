package github.com.stonevolley_demo.http;

import java.io.UnsupportedEncodingException;

import github.com.stonevolley_demo.http.interf.IHttpService;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class HttpTask<T> implements Runnable {


    private IHttpService httpService ;



    public HttpTask(RequestHolder<T> requestHolder){

        httpService= requestHolder.getHttpService();
        httpService.setHttpResponseListener(requestHolder.getHttpResponseListener());
        httpService.setUrl(requestHolder.getUrl());

        T info = requestHolder.getRequestInfo();
        String json= "";
        if(info != null) {
            json = GsonUtil.toJson(info);

        }
        try {
            httpService.setRequestData(json.getBytes("utf-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void run() {
        if(httpService != null) {
            httpService.excute();
        }
    }
}
