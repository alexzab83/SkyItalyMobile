package it.pietrantuono.skyitaly.network.model;

import java.util.List;

public class Plant {

    private int idPlant;
    private String name;
    private int skiMap;
    private List<SkiSlope> listSkiSlope;

    public int getIdPlant() {
        return idPlant;
    }

    public void setIdPlant(int idPlant) {
        this.idPlant = idPlant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkiMap() {
        return skiMap;
    }

    public void setSkiMap(int skiMap) {
        this.skiMap = skiMap;
    }

    public List<SkiSlope> getListSkiSlope() {
        return listSkiSlope;
    }

    public void setListSkiSlope(List<SkiSlope> listSkiSlope) {
        this.listSkiSlope = listSkiSlope;
    }
}
