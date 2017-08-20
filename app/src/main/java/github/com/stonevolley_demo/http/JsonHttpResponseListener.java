package github.com.stonevolley_demo.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.apache.http.HttpEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import github.com.stonevolley_demo.http.interf.ICallBackListener;
import github.com.stonevolley_demo.http.interf.IHttpResponseListener;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class JsonHttpResponseListener<T> implements IHttpResponseListener {


    private Class<T> clazz;
    private ICallBackListener callBackListener;

    //主线程
    Handler mHandler = new Handler(Looper.getMainLooper());

    public JsonHttpResponseListener(Class<T> clazz , ICallBackListener<T> callBackListener){
        this.callBackListener = callBackListener;
        this.clazz = clazz;

    }




    @Override
    public void onSuccess(HttpEntity httpEntity) {
        InputStream inputStream = null;
        try {
            inputStream =
                    httpEntity.getContent();

            String content =  getContent(inputStream);

            if(content == null){
                return;
            }
            Log.e("tag","===>"+content);
            final T t = GsonUtil.fromJson(content, clazz);

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if(callBackListener != null){
                        callBackListener.onSuccess(t);
                    }
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
            onFail(e.toString());
        }finally {
            try{
                if(inputStream != null){
                    inputStream.close();
                    inputStream = null;
                }
            }catch (Exception ex){

            }

        }
    }

    private String getContent(InputStream inputStream) {

        BufferedReader bufferedReader = null;
        String line = "";
        StringBuffer sb = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine()) != null){
                sb.append(line).append("\n");
            }

            return  sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            onFail(e.toString());

            return null;
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                    bufferedReader = null;
                }

            }catch (Exception ex){

            }
        }


    }

    @Override
    public void onFail(final String error) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if(callBackListener != null){
                    callBackListener.onFail(error);
                }
            }
        });

    }


}
