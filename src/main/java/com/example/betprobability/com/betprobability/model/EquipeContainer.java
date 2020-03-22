package com.example.betprobability.com.betprobability.model;

import java.io.Serializable;
import java.util.List;

public class EquipeContainer implements Serializable {

    private List<Equipe> equipe;

    public List<Equipe> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Equipe> equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "EquipeContainer{" +
                "equipe=" + equipe +
                '}';
    }
}
