package com.example.betprobability.com.betprobability.model;

import java.io.Serializable;

public class Equipe implements Serializable {

    private int id;
    private String equipe;
    private Integer classement;
    private Integer classementDom;
    private Integer classementExt;
    private String championnat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public Integer getClassement() {
        return classement;
    }

    public void setClassement(Integer classement) {
        this.classement = classement;
    }

    public Integer getClassementDom() {
        return classementDom;
    }

    public void setClassementDom(Integer classementDom) {
        this.classementDom = classementDom;
    }

    public Integer getClassementExt() {
        return classementExt;
    }

    public void setClassementExt(Integer classementExt) {
        this.classementExt = classementExt;
    }

    public String getChampionnat() {
        return championnat;
    }

    public void setChampionnat(String championnat) {
        this.championnat = championnat;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", equipe='" + equipe + '\'' +
                ", classement='" + classement + '\'' +
                ", classementDom='" + classementDom + '\'' +
                ", classementExt='" + classementExt + '\'' +
                ", championnat='" + championnat + '\'' +
                '}';
    }
}
