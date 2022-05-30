package it.pietrantuono.skyitaly.network.model;

public class Weather {
    private double lat;
    private double lon;
    private int alt_m;
    private String wx_desc;
    private double temp_c;
    private double feelslike_c;
    private double humid_pct;
    private double windspd_kmh;
    private String winddir_compass;
    private double cloudtotal_pct;
    private double dewpoint_c;



    // METODI GET
    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getAlt_m() {
        return alt_m;
    }

    public String getWx_desc() {
        return wx_desc;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public double getHumid_pct() {
        return humid_pct;
    }

    public double getWindspd_kmh() {
        return windspd_kmh;
    }

    public String getWinddir_compass() {
        return winddir_compass;
    }

    public double getCloudtotal_pct() {
        return cloudtotal_pct;
    }

    public double getDewpoint_c() {
        return dewpoint_c;
    }


    // METODI SET
    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setAlt_m(int alt_m) {
        this.alt_m = alt_m;
    }

    public void setWx_desc(String wx_desc) {
        this.wx_desc = wx_desc;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public void setHumid_pct(double humid_pct) {
        this.humid_pct = humid_pct;
    }

    public void setWindspd_kmh(double windspd_kmh) {
        this.windspd_kmh = windspd_kmh;
    }

    public void setWinddir_compass(String winddir_compass) {
        this.winddir_compass = winddir_compass;
    }

    public void setCloudtotal_pct(double cloudtotal_pct) {
        this.cloudtotal_pct = cloudtotal_pct;
    }

    public void setDewpoint_c(double dewpoint_c) {
        this.dewpoint_c = dewpoint_c;
    }


}