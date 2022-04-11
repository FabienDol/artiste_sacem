package com.cgi;

import com.cgi.model.*;
import jakarta.persistence.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("artiste_sacem");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // crée manager
        Manager man1 = new Manager(70000);
        em.persist(man1);
        Manager man2 = new Manager(10000);
        em.persist(man2);
        Manager man3 = new Manager(300);
        em.persist(man3);

        // crée artist
        Artist art1 = new Artist("Prénom1", "Nom1", "X-Japan", 6, "Japon");
        em.persist(art1);
        Artist art2 = new Artist("Prénom2", "Nom2", "YMCK", 4, "Corée");
        em.persist(art2);
        Artist art3 = new Artist("Jimi", "Hendrix", "Exp Band", 3, "USA");
        em.persist(art3);
        Artist art4 = new Artist("Keith", "Richard", "Stones", 5, "UK");
        em.persist(art4);

        // crée type d'instrument
        em.persist(InstrumentType.STRING);
        em.persist(InstrumentType.BRASS);
        em.persist(InstrumentType.PERCUSSION);
        em.persist(InstrumentType.WIND);
        em.persist(InstrumentType.WOODWIND);

        // crée instrument
        Instrument instru1 = new Instrument("Piano", InstrumentType.STRING);
        em.persist(instru1);
        Instrument instru2 = new Instrument("Guitare", InstrumentType.STRING);
        em.persist(instru2);
        Instrument instru3 = new Instrument("Batterie", InstrumentType.PERCUSSION);
        em.persist(instru3);
        Instrument instru4 = new Instrument("Sax", InstrumentType.WIND);
        em.persist(instru4);

        // crée media
        Media med1 = new Media("Vinyl", new Date());
        em.persist(med1);
        Media med2 = new Media("CD", new Date());
        em.persist(med2);
        Media med3 = new Media("K7", new Date());
        em.persist(med3);

        // crée un code sacem
        SacemRegistration sacem1 = new SacemRegistration("A12345");
        em.persist(sacem1);
        SacemRegistration sacem2 = new SacemRegistration("B568452");
        em.persist(sacem2);
        SacemRegistration sacem3= new SacemRegistration("c486552");
        em.persist(sacem3);

        em.getTransaction().commit();

        Manager m = em.find(Manager.class, 1);
        System.out.println(m);

        emf.close();

    }
}
