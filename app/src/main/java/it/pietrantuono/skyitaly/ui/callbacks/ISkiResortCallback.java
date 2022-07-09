package it.pietrantuono.skyitaly.ui.callbacks;

import java.util.List;

import it.pietrantuono.skyitaly.network.model.Plant;
import it.pietrantuono.skyitaly.network.model.PlantsList;
import it.pietrantuono.skyitaly.network.model.SkiResort;

public interface ISkiResortCallback {

    List<SkiResort> getSkiResorts(List<SkiResort> skiResortList);

}
