package org.example.onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OneToManyAppBi {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Post post = new Post("Post1");
        Comment comment1 = new Comment("Pavlo");
        Comment comment2 = new Comment("Vasyl");
        Comment comment3 = new Comment("Olga");

        comment1.setPost(post);
        comment2.setPost(post);
        comment3.setPost(post);

        Set<Comment> comments = new HashSet<>(Arrays.asList(comment1, comment2, comment3));
        post.setComments(comments);
        session.persist(post);

        transaction.commit();

        System.out.println();
        Post post1 = session.find(Post.class, 1);
        System.out.println(post1);

        session.close();
    }
}
