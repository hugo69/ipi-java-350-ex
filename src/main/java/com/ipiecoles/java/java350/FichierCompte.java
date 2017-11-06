package com.ipiecoles.java.java350;

import java.io.*;

public class FichierCompte {
    private String nomDuFichier = "Compte.dat";
    private ObjectOutputStream fWo;
    private ObjectInputStream fRo;
    private char mode;

    public boolean ouvrir(String s) {
        try {
            mode = (s.toUpperCase()).charAt(0);
            if (mode == 'R' || mode == 'L')
                fRo = new ObjectInputStream(new FileInputStream(nomDuFichier));
            else if (mode == 'W' || mode == 'E')
                fWo = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String getNomDuFichier() {
        return nomDuFichier;
    }

    public ObjectOutputStream getfWo() {
        return fWo;
    }

    public ObjectInputStream getfRo() {
        return fRo;
    }

    public char getMode() {
        return mode;
    }

    public void fermer() {
        try {
            if (mode == 'R' || mode == 'L') fRo.close();
            else if (mode == 'W' || mode == 'E') fWo.close();
        } catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur à la fermeture ");
        }
    }

    public ListeCompte lire() {
        try {
            ListeCompte tmp = (ListeCompte) fRo.readObject();
            return tmp;
        } catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur  de lecture ");
        } catch (ClassNotFoundException e) {
            System.out.println(nomDuFichier + " n'est pas du bon format ");
        }
        return null;
    }

    public void ecrire(ListeCompte tmp) {
        try {
            if (tmp != null) fWo.writeObject(tmp);
        } catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur en cours d'écriture ");
        }
    }
}