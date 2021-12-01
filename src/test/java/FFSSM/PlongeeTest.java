/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Manon
 */
public class PlongeeTest {

    LocalDate date;
    LocalDate delivrance2;
    Moniteur president;
    Licence licence2;
    Club club;
    Plongeur p1;
    Licence licence;
    Plongee plongee;
    Site site;
    Plongee plongee2;
    Plongee plongee3;
    LocalDate date2;

    public PlongeeTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        date = LocalDate.of(2002, 03, 13);
        delivrance2 = LocalDate.of(2021, 03, 13);
        date2 = LocalDate.of(2021, 03, 14);
        president = new Moniteur("123456", "Jacqui", "Jacques", "7 rue du loup", "0593849133", date, 2);
        club = new Club(president, "Au fil de l'eau", "0569783211");
        p1 = new Plongeur("123456", "Pierri", "Jacques", "5 rue du Mas", "0613783211", date);
        licence = new Licence(p1, "2", delivrance2, club);
        site = new Site("Calanques", "Marseille");
        plongee = new Plongee(site, president, delivrance2, 20, 2);

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ajouteParticipant method, of class Plongee.
     */
    @Test
    public void testAjouteParticipant() {
        ArrayList<Plongeur> lesplongeurs = new ArrayList<>();
        lesplongeurs.add(p1);
        plongee.ajouteParticipant(p1);
        assertEquals(lesplongeurs, plongee.getParticipants(), "Les particpants ne correspondent pas aux participants ajoutés");
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme() {
        p1.ajouterlicence("12", delivrance2);
        president.ajouterlicence("12", delivrance2);
        plongee3 = new Plongee(site, president, delivrance2, 20, 2);
        assertTrue(plongee3.estConforme(), "Les deux dates sont sensées être conformes");
    }

    @Test
    public void testNEstpasConforme() {
        p1.ajouterlicence("12", delivrance2);
        president.ajouterlicence("10", date);
        plongee2 = new Plongee(site, president, delivrance2, 20, 2);
        assertFalse(plongee2.estConforme(), "La date du président est sensée ne pas être conforme");
    }

    @Test
    public void testNEstpasConforme2() {
        p1.ajouterlicence("11", date);
        president.ajouterlicence("10", date2);
        assertFalse(plongee.estConforme(), "Les dates sont sensées ne pas être conforme");
    }
}
