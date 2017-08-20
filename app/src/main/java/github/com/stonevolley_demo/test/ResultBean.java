package github.com.stonevolley_demo.test;

import java.util.List;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class ResultBean {


    private List<List<String>> result;

    public List<List<String>> getResult() {
        return result;
    }

    public void setResult(List<List<String>> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "result=" + result +
                '}';
    }
}
