package it.pietrantuono.skyitaly.network.model;

import java.util.List;

public class SkiResorts {

    // inserire il campo immagine(proprio di ogni ski_location) //
    private int id;
    private String city;
    private String province;
    private String altitude;
    private int countLifts;
    private int kmTrack;
    private int halfPipes;
    private int terrainParks;
    private List<Plant> listPlant;

    public SkiResorts(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public int getCountLifts() {
        return countLifts;
    }

    public void setCountLifts(int countResorts) {
        this.countLifts = countLifts;
    }

    public int getKmTrack() {
        return kmTrack;
    }

    public void setKmTrack(int kmTrack) {
        this.kmTrack = kmTrack;
    }

    public int getHalfPipes() {
        return halfPipes;
    }

    public void setHalfPipes(int halfPipes) {
        this.halfPipes = halfPipes;
    }

    public int getTerrainParks() {
        return terrainParks;
    }

    public void setTerrainParks(int terrainParks) {
        this.terrainParks = terrainParks;
    }

    public List<Plant> getListPlant() {
        return listPlant;
    }

    public void setListPlant(List<Plant> listPlant) {
        this.listPlant = listPlant;
    }
}