package org.example.manytomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ManyToManyBi {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Project project1 = new Project("Project1");
        Project project2 = new Project("Project2");

        User user1 = new User("User1", 20);
        User user2 = new User("User2", 30);

        project1.setUsers(new HashSet<>(Arrays.asList(user1, user2)));
        project2.setUsers(new HashSet<>(Collections.singletonList(user2)));

        user1.setProjects(Collections.singleton(project1));
        user2.setProjects(new HashSet<>(Arrays.asList(project1, project2)));

        session.persist(project1);
        session.persist(project2);

        transaction.commit();
//        session.close();
    }
}
