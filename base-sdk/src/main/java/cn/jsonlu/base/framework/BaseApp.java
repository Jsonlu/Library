package cn.jsonlu.base.framework;

import android.app.Application;

import cn.jsonlu.base.service.init.InitService;

/**
 * Author:JsonLu
 * DateTime:17/8/11 10:19
 * Email:luxd@sumpay.com
 * Desc:
 **/
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new InitService().db().push().crash();
    }
}
