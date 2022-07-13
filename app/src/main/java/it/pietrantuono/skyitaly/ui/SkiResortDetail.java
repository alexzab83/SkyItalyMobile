package it.pietrantuono.skyitaly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import it.pietrantuono.skyitaly.databinding.ActivityDetailSkiresortBinding;
import it.pietrantuono.skyitaly.databinding.ActivitySkymapBinding;
import it.pietrantuono.skyitaly.network.SkiResortCaller;
import it.pietrantuono.skyitaly.network.model.SkiResort;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;
import it.pietrantuono.skyitaly.utils.PreferencesUtils;

public class SkiResortDetail extends BaseActivity{

    private ActivityDetailSkiresortBinding binding;
    private SkiResort skiResort;
    private SkiResortViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityDetailSkiresortBinding.inflate(getLayoutInflater());
       getDataIntent();
       viewModel = new SkiResortViewModel(this);
       setTitle(skiResort.getLocation());
       binding.setSkiresort(skiResort);
       setContentView(binding.getRoot());
       Picasso.get().load(skiResort.getUrl().trim()).into(binding.imgSkiresort);
       binding.btnPlantList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), PlantActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idSkiMap", skiResort.getIdSkiMap());
                i.putExtras(bundle);
                startActivity(i);
            }
        });
       binding.cbFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               SkiResortCaller caller = new SkiResortCaller(SkiResortDetail.this);
               caller.addRemoveFavorite(PreferencesUtils.getUser(SkiResortDetail.this).getId(), skiResort.getIdSkiMap(), b);
           }
       });
       binding.cbFavorite.setChecked(skiResort.isFavorite());
    }

    private void getDataIntent(){
        Bundle b = getIntent().getExtras();
        String jsonParam = b.getString("skiresort");
        skiResort = new Gson().fromJson(jsonParam, SkiResort.class);
    }
}
