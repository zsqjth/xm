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
    public static JSONObject getJson(HttpServletRequest request) {
        // 从前端获取输入字节流
        ServletInputStream requestInputStream = null;
        try {
            requestInputStream = request.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 将字节流转换为字符流,并设置字符编码为utf-8
        InputStreamReader ir = null;
        try {
            ir = new InputStreamReader(requestInputStream, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // 使用字符缓冲流进行读取
        BufferedReader br = new BufferedReader(ir);
        // 开始拼装json字符串
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 解析JSON字符串为JSONObject对象
        JSONObject json = JSONObject.parseObject(sb.toString());

        return json;
    }

    public static <T> String toJsonMap(Integer code ,String msg, T t) {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", t);
        return JSON.toJSONString(map);
    }
}