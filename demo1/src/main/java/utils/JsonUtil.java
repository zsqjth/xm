package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiuziang
 */
public class JsonUtil {


    public static <T> String toJsonMap(Integer code ,String msg, T t) {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", t);
        return JSON.toJSONString(map);
    }
}