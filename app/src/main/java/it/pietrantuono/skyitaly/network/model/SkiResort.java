package it.pietrantuono.skyitaly.network.model;

import java.util.List;

public class SkiResort {
    private int idSkiMap;
    private String url;
    private String location;
    private String region;
    private String altitudine;
    private String numeroImpiantiSciistici;
    private String kmPiste;
    private String halfPipe;
    private String terraInParks;
    private boolean favorite;
    private Previsioni previsioni;

    public int getIdSkiMap() {
        return idSkiMap;
    }

    public void setIdSkiMap(int idSkiMap) {
        this.idSkiMap = idSkiMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAltitudine() {
        return altitudine;
    }

    public void setAltitudine(String altitudine) {
        this.altitudine = altitudine;
    }

    public String getNumeroImpiantiSciistici() {
        return numeroImpiantiSciistici;
    }

    public void setNumeroImpiantiSciistici(String numeroImpiantiSciistici) {
        this.numeroImpiantiSciistici = numeroImpiantiSciistici;
    }

    public String getKmPiste() {
        return kmPiste;
    }

    public void setKmPiste(String kmPiste) {
        this.kmPiste = kmPiste;
    }

    public String getHalfPipe() {
        return halfPipe;
    }

    public void setHalfPipe(String halfPipe) {
        this.halfPipe = halfPipe;
    }

    public String getTerraInParks() {
        return terraInParks;
    }

    public void setTerraInParks(String terraInParks) {
        this.terraInParks = terraInParks;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Previsioni getPrevisioni() {
        return previsioni;
    }

    public void setPrevisioni(Previsioni previsioni) {
        this.previsioni = previsioni;
    }
}
