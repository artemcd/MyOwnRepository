import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;

public class SQLTest {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();


        Session session = sessionFactory.openSession();
        Students student = session.get(Students.class, 2);
        System.out.println("ИМЯ:\t" + student.getName() + "\nВОЗРАСТ:\t" + student.getAge() + "\nЗАРЕГИСТРИРОВАЛСЯ:\t" + student.getDate());
        sessionFactory.close();
    }
    }

