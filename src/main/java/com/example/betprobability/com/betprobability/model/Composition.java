package com.example.betprobability.com.betprobability.model;

public class Composition {

    private int id;
    private String joueur;
    private String importance;
    private String equipeTitu;
    private String presence;
    private Equipe equipe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoueur() {
        return joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getEquipeTitu() {
        return equipeTitu;
    }

    public void setEquipeTitu(String equipeTitu) {
        this.equipeTitu = equipeTitu;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", joueur='" + joueur + '\'' +
                ", importance='" + importance + '\'' +
                ", equipeTitu='" + equipeTitu + '\'' +
                ", presence='" + presence + '\'' +
                ", equipe=" + equipe +
                '}';
    }
}
