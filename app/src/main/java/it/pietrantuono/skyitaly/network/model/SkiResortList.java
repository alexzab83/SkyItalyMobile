package it.pietrantuono.skyitaly.network.model;

import java.util.List;

public class SkiResortList extends BaseResponse{

    private List<SkiResort> listSkiMap;

    public List<SkiResort> getListSkiMap() {
        return listSkiMap;
    }

    public void setListSkiMap(List<SkiResort> listSkiMap) {
        this.listSkiMap = listSkiMap;
    }
}
