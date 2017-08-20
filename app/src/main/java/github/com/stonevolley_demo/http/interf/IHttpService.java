package github.com.stonevolley_demo.http.interf;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public interface IHttpService {


    void setUrl(String url);

    void setHttpResponseListener(IHttpResponseListener httpResponseListener);

    void excute();

    void setRequestData(byte[] data);



}
