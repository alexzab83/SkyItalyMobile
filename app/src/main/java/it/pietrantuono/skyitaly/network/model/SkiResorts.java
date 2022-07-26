package it.pietrantuono.skyitaly.network.model;

import java.util.List;

public class SkiResorts {

    // inserire il campo immagine(proprio di ogni ski_location) //
    private int id;
    private String city;
    private String regione;
    private String altitude;
    private int countLifts;
    private int kmTrack;
    private int halfPipes;
    private int terrainParks;
    private Previsioni previsioni;
    private List<Plant> listPlant;

    public SkiResorts(){

    }

    public SkiResorts(String city, String province, String altitude, int countResorts, int kmTrack, int halfPipes, int terrainParks, List<Plant> listPlant) {
        this.city = city;
        this.regione = province;
        this.altitude = altitude;
       // this.countResorts = countResorts;
        this.kmTrack = kmTrack;
        this.halfPipes = halfPipes;
        this.terrainParks = terrainParks;
        this.listPlant = listPlant;
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
        return regione;
    }

    public void setProvince(String province) {
        this.regione = province;
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

    public Previsioni getPrevisioni() {
        return previsioni;
    }

    public void setPrevisioni(Previsioni previsioni) {
        this.previsioni = previsioni;
    }
}
