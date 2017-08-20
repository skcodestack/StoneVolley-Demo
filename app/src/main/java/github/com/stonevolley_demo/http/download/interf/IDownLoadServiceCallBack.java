package github.com.stonevolley_demo.http.download.interf;


import github.com.stonevolley_demo.http.download.DownLoadItemInfo;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/3
 * Version  1.0
 * Description:
 */

public interface IDownLoadServiceCallBack {

    void onDownLoadStatusChanged(DownLoadItemInfo downLoadItemInfo);

    void onTotalLengthReceived(DownLoadItemInfo downLoadItemInfo);

    void onCurrentSizeChanged(DownLoadItemInfo downLoadItemInfo, double downLength, long speed);

    void onDownLoadSuccess(DownLoadItemInfo downLoadItemInfo);

    void onDownLoadPause(DownLoadItemInfo downLoadItemInfo);

    void onDownLoadError(DownLoadItemInfo downLoadItemInfo, int v, String vv);
}
