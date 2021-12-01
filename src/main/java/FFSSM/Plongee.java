/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Plongee {

    public Site lieu;
    public Moniteur chefDePalanquee;
    public LocalDate date;
    public int profondeur;
    public int duree;
    public ArrayList<Plongeur> participants = new ArrayList<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public Plongee(Moniteur chefDePalanquee) {
        this.chefDePalanquee = chefDePalanquee;
    }

    public void ajouteParticipant(Plongeur participant) {
        participants.add(participant);
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Plongeur> getParticipants() {
        return participants;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean estConforme = true;
        for (Plongeur p : participants) {
            if (p.derniereLicence().estValide(date) == false) {
                return estConforme = false;
            }
        }
        if (chefDePalanquee.derniereLicence().estValide(date) == false) {
            return estConforme = false;
        }
        return estConforme;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.lieu);
        hash = 29 * hash + Objects.hashCode(this.chefDePalanquee);
        hash = 29 * hash + Objects.hashCode(this.date);
        hash = 29 * hash + this.profondeur;
        hash = 29 * hash + this.duree;
        hash = 29 * hash + Objects.hashCode(this.participants);
        return hash;
    }
}
