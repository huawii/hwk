package com.huawii.mebatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @author hua
 * @create 2020/5/14
 */
public class hConfiguration {
    private static final ResourceBundle bundle;


    static {
        bundle = ResourceBundle.getBundle("hua");
    }

    public String getSql(String statementId){
        return bundle.getString(statementId);
    }

    public <T> T getMapper(Class clazz, hSqlSession hSqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new ProxyHandler(hSqlSession));
    }

}
