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
        Manager man2 = new Manager(10000);
        Manager man3 = new Manager(300);

        // crée artist
        Artist art1 = new Artist("Prénom1", "Nom1", "X-Japan", 6, "Japon");
        Artist art2 = new Artist("Prénom2", "Nom2", "YMCK", 4, "Corée");
        Artist art3 = new Artist("Jimi", "Hendrix", "Exp Band", 3, "USA");
        Artist art4 = new Artist("Keith", "Richard", "Stones", 5, "UK");

        // crée type d'instrument
        em.persist(InstrumentType.STRING);
        em.persist(InstrumentType.BRASS);
        em.persist(InstrumentType.PERCUSSION);
        em.persist(InstrumentType.WIND);
        em.persist(InstrumentType.WOODWIND);

        // crée instrument
        Instrument instru1 = new Instrument("Piano", InstrumentType.STRING);
        Instrument instru2 = new Instrument("Guitare", InstrumentType.STRING);
        Instrument instru3 = new Instrument("Batterie", InstrumentType.PERCUSSION);
        Instrument instru4 = new Instrument("Sax", InstrumentType.WIND);

        // crée media
        Media med1 = new Media("Vinyl", new Date());
        Media med2 = new Media("CD", new Date());
        Media med3 = new Media("K7", new Date());

        // crée un code sacem
        SacemRegistration sacem1 = new SacemRegistration("A12345");
        SacemRegistration sacem2 = new SacemRegistration("B568452");
        SacemRegistration sacem3= new SacemRegistration("C486552");
        SacemRegistration sacem4= new SacemRegistration("D116552");

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

        // set le lien artiste / media todo : fix this link
        ArrayList<Media> mediasArt1 = new ArrayList<>();
        mediasArt1.add(med1);
        mediasArt1.add(med2);
        mediasArt1.add(med3);
        art1.setMedias(mediasArt1);

        ArrayList<Media> mediasArt2 = new ArrayList<>();
        mediasArt1.add(med1);
        mediasArt1.add(med2);
        art2.setMedias(mediasArt2);

        ArrayList<Media> mediasArt3 = new ArrayList<>();
        mediasArt1.add(med3);
        art3.setMedias(mediasArt3);

        art1.setMedias(mediasArt1);
        art2.setMedias(mediasArt1);
        art3.setMedias(mediasArt1);

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

        // fill art_id in instrument table todo : rename this field

//art1.setInstruments(instrusPlayer1);


        em.persist(med1);
        em.persist(med2);
        em.persist(med3);
        em.persist(sacem1);
        em.persist(sacem2);
        em.persist(sacem3);
        em.persist(sacem4);
        em.persist(man1);
        em.persist(man2);
        em.persist(man3);
        em.persist(instru1);
        em.persist(instru2);
        em.persist(instru3);
        em.persist(instru4);
        em.persist(art1);
        em.persist(art2);
        em.persist(art3);
        em.persist(art4);


        em.getTransaction().commit();

        Manager m = em.find(Manager.class, 1);
        System.out.println(m);

        emf.close();
        em.close();

    }
}
