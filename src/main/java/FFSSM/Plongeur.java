package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne {

    public int niveau;
    public GroupeSanguin groupe;
    public ArrayList<Licence> licences = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
    }

    public void ajouterlicence(String numero, LocalDate delivrance, Club club) {
        licences.add(new Licence(this, numero, delivrance, club));
    }

    public Licence derniereLicence() {
        return licences.get(licences.size() - 1);

    }

}
