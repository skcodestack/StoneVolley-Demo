package github.com.stonevolley_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import github.com.stonevolley_demo.http.StoneVolley;
import github.com.stonevolley_demo.http.interf.ICallBackListener;
import github.com.stonevolley_demo.test.ResultBean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void requestJson(View view){



        String url = "https://suggest.taobao.com/sug?code=utf-8&q=%E5%8D%AB%E8%A1%A3";

        for (int i = 0; i < 20; i++) {
            StoneVolley.sendRequest(null, url, ResultBean.class, new ICallBackListener<ResultBean>() {
                @Override
                public void onSuccess(ResultBean data) {
                    Log.e("tag","====>"+data.toString());
                }

                @Override
                public void onFail(String error) {
                    Log.e("tag","====>"+error);
                }
            });
        }



    }

}
