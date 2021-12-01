/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class MoniteurTest {
    
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
    ArrayList lesEmbauches;
    public MoniteurTest() {
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
        plongee=new Plongee(site, president, delivrance2, 20, 2);
            
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    @Test
    public void testEmployeurActuel() {
        president.nouvelleEmbauche(club, date);
        assertEquals(president.employeurActuel(),Optional.of(club),"l'employeur ne correspond pas");
    }
    
    @Test
    public void testEmployeurActuelVide() {
       assertEquals(president.employeurActuel(),Optional.empty(),"Est sensé être vide");
    }

   
    /**
     * Test of emplois method, of class Moniteur.
     */
    @Test
    public void testEmplois() {
       lesEmbauches = new ArrayList<>();
       Embauche e = new Embauche(date, president, club);
       lesEmbauches.add(e);
         president.nouvelleEmbauche(club, date);
         assertEquals(lesEmbauches,president.emplois(),"Les embauches ne correspondent pas");
         
    }
    
}
