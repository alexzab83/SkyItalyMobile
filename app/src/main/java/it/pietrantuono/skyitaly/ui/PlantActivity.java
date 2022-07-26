package it.pietrantuono.skyitaly.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

import it.pietrantuono.skyitaly.databinding.ActivityPlantBinding;
import it.pietrantuono.skyitaly.databinding.ActivityPlantBindingImpl;
import it.pietrantuono.skyitaly.network.model.Plant;
import it.pietrantuono.skyitaly.ui.adapter.PlantExpandableAdapter;
import it.pietrantuono.skyitaly.ui.callbacks.IListPlantCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;

public class PlantActivity extends BaseActivity implements IListPlantCallback {

    private SkiResortViewModel viewModel;
    private ActivityPlantBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlantBinding.inflate(getLayoutInflater());   // accesso a tute le risorse grafiche inserite nel activity log_in xml
        View view = binding.getRoot();
        setContentView(view);
        setActionBar();
        setTitle("Impianti e piste");

        viewModel = new SkiResortViewModel(this);
        viewModel.getPlantList(this, getIntent().getExtras().getInt("idSkiMap"));
    }

    @Override
    public void onListPlant(List<Plant> list) {
        PlantExpandableAdapter adapter = new PlantExpandableAdapter(list);
        binding.expandableListView.setAdapter(adapter);
        Log.e("Plant", ""+list.size());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
