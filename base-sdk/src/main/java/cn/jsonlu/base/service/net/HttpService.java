package cn.jsonlu.base.service.net;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import cn.jsonlu.base.model.param.BaseParam;
import cn.jsonlu.base.model.vo.BaseVo;

/**
 * Author:JsonLu
 * DateTime:17/8/11 10:16
 * Email:luxd@sumpay.com
 * Desc:
 **/
public class HttpService {

    public <P extends BaseParam, V extends BaseVo> void request(P p, Class<V> v) {
        
        AndroidNetworking.post("")
                .addJSONObjectBody(p)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(v, new ParsedRequestListener<V>() {
                    @Override
                    public void onResponse(V response) {

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
