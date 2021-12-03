/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
public class ClubTest {

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
    ArrayList lesplongees;

    public ClubTest() {
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
        site = new Site("Calanques", "Marseille");
        plongee = new Plongee(site, president, delivrance2, 20, 2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of plongeesNonConformes method, of class Club.
     */
    @Test
    public void testPlongeesNonConformes() {
        HashSet<Plongee> plongee2 = new HashSet<>();
        president.ajouterlicence("10", date, club);
        p1.ajouterlicence("12", delivrance2, club);
        plongee.ajouteParticipant(p1);
        plongee.ajouteParticipant(president);
        plongee2.add(plongee);
        club.organisePlongee(plongee);
        assertEquals(plongee2, club.plongeesNonConformes(), "Les plongees sont conformes");
        
    }

    /**
     * Test of organisePlongee method, of class Club.
     */
    @Test
    public void testOrganisePlongee() {
        
    }
    
}
