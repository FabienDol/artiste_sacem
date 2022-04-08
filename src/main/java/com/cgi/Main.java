package com.cgi;

import com.cgi.model.Artist;
import com.cgi.model.Manager;
import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("artiste_sacem");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // crée un manager
        Manager m1 = new Manager(70000);
        em.persist(m1);

        // crée un artist
        Artist a1 = new Artist("Prénom1", "Nom1", "X-Japan", 5, "Japon");
        em.persist(a1);


        // note : pas la bonne manière de créer un artist et un manager

        em.getTransaction().commit();

        Manager m = em.find(Manager.class, 1);
        System.out.println(m);

        emf.close();

    }
}
