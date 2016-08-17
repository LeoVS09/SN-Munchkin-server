package ru.rmades.rest;

/**
 * Created by Администратор on 17.08.2016.
 */

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.concretepage.dao.PersonDao;
import ru.rmades.rest.controller.User;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {
    @Bean
    public IUserDao userDao(){
        return new UserDao();
    }
    @Bean
    public HibernateTemplate hibernateTemplate(){
        return new HibernateTemplate(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory(){
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(User.class)
                .buildSessionFactory();
    }
    @Bean
    public DateSource getDateSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3333/experiment_schema");
        dataSource.setUsername("root");
        dataSource.setPassword("LVS63590");
        return dataSource;
    }
    @Bean
    private HibernateTransactionManager hinTransMan(){
        return new HibernateTransactionManager(sessionFactory());
    }
}
