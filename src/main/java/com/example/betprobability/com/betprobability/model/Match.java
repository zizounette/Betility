package com.example.betprobability.com.betprobability.model;

import java.io.Serializable;

public class Match implements Serializable {

    private int id;
    private Equipe equipe1;
    private Equipe equipe2;
    private int scoredom;
    private int scoreext;
    private String saison;
    private String resultat;
    private String importance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public int getScoredom() {
        return scoredom;
    }

    public void setScoredom(int scoredom) {
        this.scoredom = scoredom;
    }

    public int getScoreext() {
        return scoreext;
    }

    public void setScoreext(int scoreext) {
        this.scoreext = scoreext;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", equipe1=" + equipe1 +
                ", equipe2=" + equipe2 +
                ", scoredom=" + scoredom +
                ", scoreext=" + scoreext +
                ", saison='" + saison + '\'' +
                ", resultat='" + resultat + '\'' +
                ", importance='" + importance + '\'' +
                '}';
    }
}
