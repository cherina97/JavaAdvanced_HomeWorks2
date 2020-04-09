package org.example.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Participant participant = new Participant("Part1");
        InfoReport report = new InfoReport("Rep1");

        participant.setReport(report);

        session.persist(report);
        session.persist(participant);


        transaction.commit();
//        session.close();
    }
}
