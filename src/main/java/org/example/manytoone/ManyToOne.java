package org.example.manytoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToOne {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Person person = new Person("Max");
        Phone phone1 = new Phone("333-222-1111");

        phone1.setPerson(person);

        session.persist(person);
        session.persist(phone1);




        transaction.commit();
        session.close();
    }
}
