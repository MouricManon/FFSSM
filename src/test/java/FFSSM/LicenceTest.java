/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
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
public class LicenceTest {
    LocalDate date;
    LocalDate delivrance2;
    Moniteur president;
    Club club;
    Plongeur p1;
    Licence licence;
    
    public LicenceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() { 
         date = LocalDate.of(2002,03,13);
          delivrance2 = LocalDate.of(2021,03,13);
         president = new Moniteur("123456", "Jacqui", "Jacques", "7 rue du loup","0593849133", date, 2);
        club = new Club(president, "Au fil de l'eau", "0569783211");
        p1=new Plongeur("123456", "Pierri", "Jacques", "5 rue du Mas", "0613783211", date);
         licence = new  Licence(p1, "2", delivrance2, club);
    }
    
    @AfterEach
    public void tearDown() {
    }

   
    /**
     * Test of estValide method, of class Licence.
     */
          @Test
    public void testEstValide() {
      LocalDate date1 = LocalDate.of(2021,04,13);
      assertTrue(licence.estValide(date1),"La licence n'est pas valide");
    }
        @Test
    public void testEstPasValide() {
      LocalDate date1 = LocalDate.of(2022,05,13);
      assertFalse(licence.estValide(date1),"La licence apparaît valide alors qu'elle ne l'est pas");
    }
    @Test
     public void testEstPasValide2() {
      LocalDate date1 = LocalDate.of(2020,01,13);
      assertFalse(licence.estValide(date1),"La licence apparaît valide alors qu'elle ne l'est pas");
    }
    
}
