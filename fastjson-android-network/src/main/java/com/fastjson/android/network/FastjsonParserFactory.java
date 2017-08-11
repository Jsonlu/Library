package com.fastjson.android.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.androidnetworking.interfaces.Parser;

import java.lang.reflect.Type;
import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Author:JsonLu
 * DateTime:17/8/6 23:32
 * Email:luxd@sumpay.com
 * Desc:
 **/
public final class FastjsonParserFactory extends Parser.Factory {


    @Override
    public Parser<ResponseBody, ?> responseBodyParser(Type type) {
        return new FastjsonResponseBodyParser<>(type);
    }

    @Override
    public Parser<?, RequestBody> requestBodyParser(Type type) {
        return new FastjsonRequestBodyParser<>();
    }

    @Override
    public Object getObject(String string, Type type) {
        return JSON.parseObject(string, type);
    }

    @Override
    public String getString(Object object) {
        return JSON.toJSONString(object);
    }

    @Override
    public HashMap<String, String> getStringMap(Object object) {
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };
        return JSON.parseObject(JSON.toJSONString(object), typeRef);
    }
}
