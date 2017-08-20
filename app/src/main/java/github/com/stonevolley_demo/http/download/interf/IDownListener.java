package github.com.stonevolley_demo.http.download.interf;


import github.com.stonevolley_demo.http.interf.IHttpResponseListener;
import github.com.stonevolley_demo.http.interf.IHttpService;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public interface IDownListener extends IHttpResponseListener {

    void setHttpService(IHttpService httpService);

    void setPause();

    void setCancle();
}
