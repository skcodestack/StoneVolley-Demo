package github.com.stonevolley_demo.http;

import com.google.gson.Gson;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/8/2
 * Version  1.0
 * Description:
 */

public class GsonUtil {

    private static Gson gson = new Gson();

    public static <T > T  fromJson (String json,Class<T> clazz){

        return  gson.fromJson(json , clazz);

    }
    public static String toJson (Object obj){

        return  gson.toJson(obj );

    }




}
