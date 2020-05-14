package com.huawii.mebatis;

/**
 * @author hua
 * @create 2020/5/14
 */
public class hSqlSession {

    private final hConfiguration configuration;
    private final hExcutor excutor;

    public hSqlSession(hConfiguration hConfiguration, hExcutor hExcutor) {
        this.configuration = hConfiguration;
        this.excutor = hExcutor;
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz, this);
    }

    public Object selectOne(String statementId, Object[] args) {
        String sql = configuration.getSql(statementId);
        return excutor.query(sql, args);
    }

}
