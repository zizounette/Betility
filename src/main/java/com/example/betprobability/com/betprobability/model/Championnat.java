package com.example.betprobability.com.betprobability.model;

public class Championnat {

    private int id;
    private String championnat;
    private int imageId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChampionnat() {
        return championnat;
    }

    public void setChampionnat(String championnat) {
        this.championnat = championnat;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Championnat{" +
                "id=" + id +
                ", championnat='" + championnat + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
