package github.com.stonevolley_demo.http.download;

import android.util.Log;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import github.com.stonevolley_demo.http.interf.IHttpResponseListener;
import github.com.stonevolley_demo.http.interf.IHttpService;


/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/3
 * Version  1.0
 * Description:
 */

public class DownFileHttpService implements IHttpService {


    private static String  TAG = "DownFileHttpService";

    private HttpClient mHttpClient = new DefaultHttpClient();

    private String url;
    HttpPost mHttpPost;
    private byte[] requestData;


    private Map<String,String> headerMap = Collections.synchronizedMap(new HashMap<String, String>());

    private IHttpResponseListener httpResponseListener;

    CustomResponseHandler responseHandler = new CustomResponseHandler();

    @Override
    public void setUrl(String url) {
        this.url = url;

    }

    @Override
    public void setHttpResponseListener(IHttpResponseListener httpResponseListener) {
        this.httpResponseListener = httpResponseListener;

    }

    @Override
    public void excute() {


        mHttpPost = new HttpPost();
        initHeader();
        mHttpPost.setEntity(new ByteArrayEntity(requestData));

        mHttpPost.setURI(URI.create(url));
        try {
            mHttpClient.execute(mHttpPost,responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
            if(httpResponseListener != null){
                httpResponseListener.onFail(e.toString());
            }
        }

    }


    private  void initHeader() {
        Set<Map.Entry<String, String>> entries = headerMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.e(TAG,"key===>"+key+" , value=====>"+value);

            mHttpPost.addHeader(key,value);

        }
    }


    @Override
    public void setRequestData(byte[] data) {
        this.requestData = data;
    }


    private  class  CustomResponseHandler extends BasicResponseHandler {
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
