package it.pietrantuono.skyitaly.network.model;

import java.util.List;

public class PlantsList extends BaseResponse{

    private List<Plant> plants;

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
