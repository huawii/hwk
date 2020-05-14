package com.huawii.mebatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hua
 * @create 2020/5/14
 */
public class ProxyHandler implements InvocationHandler {

    private final hSqlSession hSqlSession;

    public ProxyHandler(hSqlSession hSqlSession) {
        this.hSqlSession = hSqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        return hSqlSession.selectOne(statementId, args);
    }

}
