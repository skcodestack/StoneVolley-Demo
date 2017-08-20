package github.com.stonevolley_demo.http;


import github.com.stonevolley_demo.http.interf.ICallBackListener;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class StoneVolley {

    public  static  <T,M>  void  sendRequest(T request , String url , Class<M> mClass , ICallBackListener<M> callBackListener){

        RequestHolder requestHolder = new RequestHolder();
        requestHolder.setUrl(url);
        requestHolder.setRequestInfo(request);
        JsonHttpService httpService = new JsonHttpService();
        requestHolder.setHttpService(httpService);

        JsonHttpResponseListener<M> responseListener = new JsonHttpResponseListener(mClass,callBackListener);
        requestHolder.setHttpResponseListener(responseListener);


        try {
            ThreadPoolManager.getInstance().execute(new HttpTask<T>(requestHolder));
        } catch (InterruptedException e) {
            e.printStackTrace();
            callBackListener.onFail(e.toString());
        }

    }

}
