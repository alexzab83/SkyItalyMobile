package it.pietrantuono.skyitaly.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;

import it.pietrantuono.skyitaly.network.model.Plant;
import it.pietrantuono.skyitaly.ui.callbacks.IListPlantCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;

public class PlantActivity extends BaseActivity implements IListPlantCallback {

    private SkiResortViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new SkiResortViewModel(this);
        viewModel.getPlantList(this, getIntent().getExtras().getInt("idSkiMap"));
    }

    @Override
    public void onListPlant(List<Plant> list) {
        Log.e("Plant", ""+list.size());
    }
}
