package github.com.stonevolley_demo.http.download;

import org.apache.http.HttpEntity;

import github.com.stonevolley_demo.http.download.interf.IDownListener;
import github.com.stonevolley_demo.http.interf.IHttpService;


/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/3
 * Version  1.0
 * Description:
 */

public class DownLoadListener implements IDownListener {

    @Override
    public void setHttpService(IHttpService httpService) {

    }

    @Override
    public void setPause() {

    }

    @Override
    public void setCancle() {

    }

    @Override
    public void onSuccess(HttpEntity httpEntity) {

    }

    @Override
    public void onFail(String error) {

    }
}
