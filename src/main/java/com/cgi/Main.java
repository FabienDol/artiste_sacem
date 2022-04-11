package com.cgi;

import com.cgi.model.*;
import jakarta.persistence.*;

import java.util.ArrayList;
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
        //em.persist(art1); // persister après avoir setté les clé étrangères
        Artist art2 = new Artist("Prénom2", "Nom2", "YMCK", 4, "Corée");
        //em.persist(art2);
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
        SacemRegistration sacem3= new SacemRegistration("C486552");
        em.persist(sacem3);
        SacemRegistration sacem4= new SacemRegistration("D116552");
        em.persist(sacem4);

        // pour setter les clés étrangères : todo : faire aussi pour les autres classes
        art1.setSacem(sacem1);
        art2.setSacem(sacem2);
        art3.setSacem(sacem3);
        art4.setSacem(sacem4);

        art1.setFavoriteInstrument(instru1);
        art1.setMng(man1);
        art2.setFavoriteInstrument(instru4);
        art2.setMng(man1);
        art3.setFavoriteInstrument(instru3);
        art3.setMng(man1);
        art4.setFavoriteInstrument(instru1);
        art4.setMng(man2);

        ArrayList<Media> mediasArt1 = new ArrayList<>();
        mediasArt1.add(med1);
        mediasArt1.add(med2);
        mediasArt1.add(med2);
        art1.setMedias(mediasArt1);

        art1.setFavoriteInstrument(instru2);

        // fill artist_instrument table
        ArrayList<Instrument> instrusPlayer1 = new ArrayList<>();
        instrusPlayer1.add(instru1);
        instrusPlayer1.add(instru2);
        instrusPlayer1.add(instru3);
        instrusPlayer1.add(instru4);
        art1.setPlayableInstruments(instrusPlayer1);

        ArrayList<Instrument> instrusPlayer2 = new ArrayList<>();
        instrusPlayer2.add(instru2);
        instrusPlayer2.add(instru3);
        art2.setPlayableInstruments(instrusPlayer2);


        em.persist(art1);
        em.persist(art2);


        // fill art_id in instrument table todo : rename this field

//art1.setInstruments(instrusPlayer1);


        em.getTransaction().commit();

        Manager m = em.find(Manager.class, 1);
        System.out.println(m);

        emf.close();
        em.close();

    }
}
