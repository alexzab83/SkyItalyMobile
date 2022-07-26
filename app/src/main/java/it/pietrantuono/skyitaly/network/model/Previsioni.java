package it.pietrantuono.skyitaly.network.model;

public class Previsioni {

    private String codiceBolletino;
    private String neveVillage;
    private int neveTopMountain;
    private String descrizione;

    public String getCodiceBolletino() {
        return codiceBolletino;
    }

    public void setCodiceBolletino(String codiceBolletino) {
        this.codiceBolletino = codiceBolletino;
    }

    public String getNeveVillage() {
        return neveVillage;
    }

    public void setNeveVillage(String neveVillage) {
        this.neveVillage = neveVillage;
    }

    public int getNeveTopMountain() {
        return neveTopMountain;
    }

    public void setNeveTopMountain(int neveTopMountain) {
        this.neveTopMountain = neveTopMountain;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
