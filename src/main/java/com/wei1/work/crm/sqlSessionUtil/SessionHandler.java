package com.wei1.work.crm.sqlSessionUtil;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SessionHandler implements InvocationHandler {
    Object target ;

    public SessionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        SqlSession session = null;
        try {
            session = SessionUtil.getSqlSession();
            object = method.invoke(target,args);
            session.commit();
        } catch (IllegalAccessException e) {
            session.rollback();
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            session.rollback();
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            SessionUtil.closeSqlSession(session);
        }
        return object;
    }
    public Object getProxy(){
        //返回代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

}
