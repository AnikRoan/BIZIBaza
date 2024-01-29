package org.example.config;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.util.Properties;

public class HibConfig {
    private  static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration();
            Properties setting = new Properties();
            setting.put(Environment.DRIVER,"org.postgresql.Driver");
            setting.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
            setting.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
            setting.put(Environment.SHOW_SQL,true);
            setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            setting.put(Environment.HBM2DDL_AUTO,"validate");

            configuration.setProperties(setting);
            configuration.addAnnotatedClass(City.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            sessionFactory=configuration.buildSessionFactory(serviceRegistry);



        }
        return sessionFactory;
    }
}
