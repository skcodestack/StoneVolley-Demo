package github.com.stonevolley_demo.http;


import github.com.stonevolley_demo.http.interf.IHttpResponseListener;
import github.com.stonevolley_demo.http.interf.IHttpService;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class RequestHolder <T> {

    IHttpService httpService ;

    IHttpResponseListener httpResponseListener;


    T requestInfo;

    String url;


    public IHttpService getHttpService() {
        return httpService;
    }

    public void setHttpService(IHttpService httpService) {
        this.httpService = httpService;
    }

    public IHttpResponseListener getHttpResponseListener() {
        return httpResponseListener;
    }

    public void setHttpResponseListener(IHttpResponseListener httpResponseListener) {
        this.httpResponseListener = httpResponseListener;
    }

    public T getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(T requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
