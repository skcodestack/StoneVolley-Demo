package github.com.stonevolley_demo.http.interf;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public interface ICallBackListener<T> {

    void onSuccess(T data);

    void onFail(String error);


}
