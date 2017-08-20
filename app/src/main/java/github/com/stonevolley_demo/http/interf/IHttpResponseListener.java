package github.com.stonevolley_demo.http.interf;

import org.apache.http.HttpEntity;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public interface IHttpResponseListener {

    void onSuccess(HttpEntity httpEntity);

    void onFail(String error);
}
