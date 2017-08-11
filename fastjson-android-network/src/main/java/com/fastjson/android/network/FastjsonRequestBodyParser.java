package com.fastjson.android.network;

import com.alibaba.fastjson.JSON;
import com.androidnetworking.interfaces.Parser;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Author:JsonLu
 * DateTime:17/8/6 23:32
 * Email:luxd@sumpay.com
 * Desc:
 **/
final class FastjsonRequestBodyParser<T> implements Parser<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    @Override
    public RequestBody convert(T value) {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value));
    }
}
