package com.example.betprobability.com.betprobability.model;

import java.io.Serializable;
import java.util.List;

public class StatsFinales implements Serializable {

    private Match match;

    private double probabilityVictoryDom;
    private double probabilityDraw;
    private double probabilityVictoryExt;

    private List<String> formeFiveMatchsEquipeDom;
    private List<String> formeFiveMatchsEquipeExt;
    private List<String> formeFiveMatchsDomEquipeDom;
    private List<String> formeFiveMatchsExtEquipeDom;
    private List<String> formeFiveMatchsDomEquipeExt;
    private List<String> formeFiveMatchsExtEquipeExt;

    private List<String> formeTenMatchsEquipeDom;
    private List<String> formeTenMatchsEquipeExt;
    private List<String> formeTenMatchsDomEquipeDom;
    private List<String> formeTenMatchsExtEquipeDom;
    private List<String> formeTenMatchsDomEquipeExt;
    private List<String> formeTenMatchsExtEquipeExt;

    private List<String> joueursImportantsAbsentsDom;
    private List<String> joueursImportantsAbsentsExt;

    private String classementEquipeDom;
    private String classementDomEquipeDom;
    private String classementExtEquipeDom;
    private String classementEquipeExt;
    private String classementDomEquipeExt;
    private String classementExtEquipeExt;

    private List<Match> historiqueConfrontation;
    private List<Match> historiqueConfrontationDom;
    private List<Match> historiqueConfrontationExt;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public double getProbabilityVictoryDom() {
        return probabilityVictoryDom;
    }

    public void setProbabilityVictoryDom(double probabilityVictoryDom) {
        this.probabilityVictoryDom = probabilityVictoryDom;
    }

    public double getProbabilityDraw() {
        return probabilityDraw;
    }

    public void setProbabilityDraw(double probabilityDraw) {
        this.probabilityDraw = probabilityDraw;
    }

    public double getProbabilityVictoryExt() {
        return probabilityVictoryExt;
    }

    public void setProbabilityVictoryExt(double probabilityVictoryExt) {
        this.probabilityVictoryExt = probabilityVictoryExt;
    }

    public List<String> getFormeFiveMatchsEquipeDom() {
        return formeFiveMatchsEquipeDom;
    }

    public void setFormeFiveMatchsEquipeDom(List<String> formeFiveMatchsEquipeDom) {
        this.formeFiveMatchsEquipeDom = formeFiveMatchsEquipeDom;
    }

    public List<String> getFormeFiveMatchsEquipeExt() {
        return formeFiveMatchsEquipeExt;
    }

    public void setFormeFiveMatchsEquipeExt(List<String> formeFiveMatchsEquipeExt) {
        this.formeFiveMatchsEquipeExt = formeFiveMatchsEquipeExt;
    }

    public List<String> getFormeFiveMatchsDomEquipeDom() {
        return formeFiveMatchsDomEquipeDom;
    }

    public void setFormeFiveMatchsDomEquipeDom(List<String> formeFiveMatchsDomEquipeDom) {
        this.formeFiveMatchsDomEquipeDom = formeFiveMatchsDomEquipeDom;
    }

    public List<String> getFormeFiveMatchsExtEquipeDom() {
        return formeFiveMatchsExtEquipeDom;
    }

    public void setFormeFiveMatchsExtEquipeDom(List<String> formeFiveMatchsExtEquipeDom) {
        this.formeFiveMatchsExtEquipeDom = formeFiveMatchsExtEquipeDom;
    }

    public List<String> getFormeFiveMatchsDomEquipeExt() {
        return formeFiveMatchsDomEquipeExt;
    }

    public void setFormeFiveMatchsDomEquipeExt(List<String> formeFiveMatchsDomEquipeExt) {
        this.formeFiveMatchsDomEquipeExt = formeFiveMatchsDomEquipeExt;
    }

    public List<String> getFormeFiveMatchsExtEquipeExt() {
        return formeFiveMatchsExtEquipeExt;
    }

    public void setFormeFiveMatchsExtEquipeExt(List<String> formeFiveMatchsExtEquipeExt) {
        this.formeFiveMatchsExtEquipeExt = formeFiveMatchsExtEquipeExt;
    }

    public List<String> getFormeTenMatchsEquipeDom() {
        return formeTenMatchsEquipeDom;
    }

    public void setFormeTenMatchsEquipeDom(List<String> formeTenMatchsEquipeDom) {
        this.formeTenMatchsEquipeDom = formeTenMatchsEquipeDom;
    }

    public List<String> getFormeTenMatchsEquipeExt() {
        return formeTenMatchsEquipeExt;
    }

    public void setFormeTenMatchsEquipeExt(List<String> formeTenMatchsEquipeExt) {
        this.formeTenMatchsEquipeExt = formeTenMatchsEquipeExt;
    }

    public List<String> getFormeTenMatchsDomEquipeDom() {
        return formeTenMatchsDomEquipeDom;
    }

    public void setFormeTenMatchsDomEquipeDom(List<String> formeTenMatchsDomEquipeDom) {
        this.formeTenMatchsDomEquipeDom = formeTenMatchsDomEquipeDom;
    }

    public List<String> getFormeTenMatchsExtEquipeDom() {
        return formeTenMatchsExtEquipeDom;
    }

    public void setFormeTenMatchsExtEquipeDom(List<String> formeTenMatchsExtEquipeDom) {
        this.formeTenMatchsExtEquipeDom = formeTenMatchsExtEquipeDom;
    }

    public List<String> getFormeTenMatchsDomEquipeExt() {
        return formeTenMatchsDomEquipeExt;
    }

    public void setFormeTenMatchsDomEquipeExt(List<String> formeTenMatchsDomEquipeExt) {
        this.formeTenMatchsDomEquipeExt = formeTenMatchsDomEquipeExt;
    }

    public List<String> getFormeTenMatchsExtEquipeExt() {
        return formeTenMatchsExtEquipeExt;
    }

    public void setFormeTenMatchsExtEquipeExt(List<String> formeTenMatchsExtEquipeExt) {
        this.formeTenMatchsExtEquipeExt = formeTenMatchsExtEquipeExt;
    }

    public List<String> getJoueursImportantsAbsentsDom() {
        return joueursImportantsAbsentsDom;
    }

    public void setJoueursImportantsAbsentsDom(List<String> joueursImportantsAbsentsDom) {
        this.joueursImportantsAbsentsDom = joueursImportantsAbsentsDom;
    }

    public List<String> getJoueursImportantsAbsentsExt() {
        return joueursImportantsAbsentsExt;
    }

    public void setJoueursImportantsAbsentsExt(List<String> joueursImportantsAbsentsExt) {
        this.joueursImportantsAbsentsExt = joueursImportantsAbsentsExt;
    }

    public String getClassementEquipeDom() {
        return classementEquipeDom;
    }

    public void setClassementEquipeDom(String classementEquipeDom) {
        this.classementEquipeDom = classementEquipeDom;
    }

    public String getClassementDomEquipeDom() {
        return classementDomEquipeDom;
    }

    public void setClassementDomEquipeDom(String classementDomEquipeDom) {
        this.classementDomEquipeDom = classementDomEquipeDom;
    }

    public String getClassementExtEquipeDom() {
        return classementExtEquipeDom;
    }

    public void setClassementExtEquipeDom(String classementExtEquipeDom) {
        this.classementExtEquipeDom = classementExtEquipeDom;
    }

    public String getClassementEquipeExt() {
        return classementEquipeExt;
    }

    public void setClassementEquipeExt(String classementEquipeExt) {
        this.classementEquipeExt = classementEquipeExt;
    }

    public String getClassementDomEquipeExt() {
        return classementDomEquipeExt;
    }

    public void setClassementDomEquipeExt(String classementDomEquipeExt) {
        this.classementDomEquipeExt = classementDomEquipeExt;
    }

    public String getClassementExtEquipeExt() {
        return classementExtEquipeExt;
    }

    public void setClassementExtEquipeExt(String classementExtEquipeExt) {
        this.classementExtEquipeExt = classementExtEquipeExt;
    }

    public List<Match> getHistoriqueConfrontation() {
        return historiqueConfrontation;
    }

    public void setHistoriqueConfrontation(List<Match> historiqueConfrontation) {
        this.historiqueConfrontation = historiqueConfrontation;
    }

    public List<Match> getHistoriqueConfrontationDom() {
        return historiqueConfrontationDom;
    }

    public void setHistoriqueConfrontationDom(List<Match> historiqueConfrontationDom) {
        this.historiqueConfrontationDom = historiqueConfrontationDom;
    }

    public List<Match> getHistoriqueConfrontationExt() {
        return historiqueConfrontationExt;
    }

    public void setHistoriqueConfrontationExt(List<Match> historiqueConfrontationExt) {
        this.historiqueConfrontationExt = historiqueConfrontationExt;
    }

    @Override
    public String toString() {
        return "StatsFinales{" +
                "match=" + match +
                ", probabilityVictoryDom=" + probabilityVictoryDom +
                ", probabilityDraw=" + probabilityDraw +
                ", probabilityVictoryExt=" + probabilityVictoryExt +
                ", formeFiveMatchsEquipeDom=" + formeFiveMatchsEquipeDom +
                ", formeFiveMatchsEquipeExt=" + formeFiveMatchsEquipeExt +
                ", formeFiveMatchsDomEquipeDom=" + formeFiveMatchsDomEquipeDom +
                ", formeFiveMatchsExtEquipeDom=" + formeFiveMatchsExtEquipeDom +
                ", formeFiveMatchsDomEquipeExt=" + formeFiveMatchsDomEquipeExt +
                ", formeFiveMatchsExtEquipeExt=" + formeFiveMatchsExtEquipeExt +
                ", formeTenMatchsEquipeDom=" + formeTenMatchsEquipeDom +
                ", formeTenMatchsEquipeExt=" + formeTenMatchsEquipeExt +
                ", formeTenMatchsDomEquipeDom=" + formeTenMatchsDomEquipeDom +
                ", formeTenMatchsExtEquipeDom=" + formeTenMatchsExtEquipeDom +
                ", formeTenMatchsDomEquipeExt=" + formeTenMatchsDomEquipeExt +
                ", formeTenMatchsExtEquipeExt=" + formeTenMatchsExtEquipeExt +
                ", joueursImportantsAbsentsDom=" + joueursImportantsAbsentsDom +
                ", joueursImportantsAbsentsExt=" + joueursImportantsAbsentsExt +
                ", classementEquipeDom='" + classementEquipeDom + '\'' +
                ", classementDomEquipeDom='" + classementDomEquipeDom + '\'' +
                ", classementExtEquipeDom='" + classementExtEquipeDom + '\'' +
                ", classementEquipeExt='" + classementEquipeExt + '\'' +
                ", classementDomEquipeExt='" + classementDomEquipeExt + '\'' +
                ", classementExtEquipeExt='" + classementExtEquipeExt + '\'' +
                ", historiqueConfrontation=" + historiqueConfrontation +
                ", historiqueConfrontationDom=" + historiqueConfrontationDom +
                ", historiqueConfrontationExt=" + historiqueConfrontationExt +
                '}';
    }
}
