package github.com.stonevolley_demo.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;

import github.com.stonevolley_demo.http.interf.IHttpResponseListener;
import github.com.stonevolley_demo.http.interf.IHttpService;


/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class JsonHttpService implements IHttpService {

    private String mUrl;

    private IHttpResponseListener httpResponseListener ;

    private byte[] requestData;

    HttpClient mHttpClient = new DefaultHttpClient();
    HttpPost mHttpPost;

    CustomResponseHandler responseHandler = new CustomResponseHandler();

    @Override
    public void setUrl(String url) {
        this.mUrl = url;
    }

    @Override
    public void setHttpResponseListener(IHttpResponseListener httpResponseListener) {
        this.httpResponseListener = httpResponseListener;
    }

    @Override
    public void excute() {
        mHttpPost = new HttpPost();

        mHttpPost.setEntity(new ByteArrayEntity(requestData));

        mHttpPost.setURI(URI.create(mUrl));
        try {
            mHttpClient.execute(mHttpPost,responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
            if(httpResponseListener != null){
                httpResponseListener.onFail(e.toString());
            }
        }
    }

    @Override
    public void setRequestData(byte[] data) {
        requestData = data;
    }


    private  class  CustomResponseHandler extends BasicResponseHandler{
        @Override
        public String handleResponse(HttpResponse response) throws HttpResponseException, ClientProtocolException {

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == 200){
                HttpEntity entity = response.getEntity();

                if(httpResponseListener != null){
                    httpResponseListener.onSuccess(entity);
                }
            }else {
                //其他处理方式，300 400 500 ，这里直接报错

                if(httpResponseListener != null){
                    httpResponseListener.onFail("request data is faild : "+response.getStatusLine().toString());
                }

            }


            return null;


        }
    }
}
