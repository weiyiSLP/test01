package com.wei1.work.crm.sqlSessionUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SessionUtil {
    private SessionUtil() {
    }

    //一开始就创建一个SQLFactory
    private static String resource = "E:\\IDEA_Projects\\CRM\\crm\\src\\main\\resource\\mybatis-config";
    private static InputStream inputStream = null;
    private static  SqlSessionFactory sqlSessionFactory = null;
    static{
        try {
            inputStream = new FileInputStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private static ThreadLocal<SqlSession> local = new ThreadLocal();//用来存放SqlSession线程池

    public static SqlSession getSqlSession(){
        //为了使用同一个SqlSession需要进行一个判断
        SqlSession session = local.get();
        if (session == null){
            session = sqlSessionFactory.openSession();
        }
        return session;
    }
    public static void closeSqlSession(SqlSession session){
        if (session !=null){
            session.close();
            local.remove();//去除local中存放的sqlsession以便下一次使用
        }
    }
}
