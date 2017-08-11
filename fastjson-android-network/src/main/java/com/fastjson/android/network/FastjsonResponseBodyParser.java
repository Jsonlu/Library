package com.fastjson.android.network;

import com.alibaba.fastjson.JSON;
import com.androidnetworking.interfaces.Parser;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;

/**
 * Author:JsonLu
 * DateTime:17/8/6 23:32
 * Email:luxd@sumpay.com
 * Desc:
 **/
final class FastjsonResponseBodyParser<T> implements Parser<ResponseBody, T> {

    private Type type;

    public FastjsonResponseBodyParser(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            return JSON.parseObject(value.bytes(), type);
        } finally {
            value.close();
        }
    }

}