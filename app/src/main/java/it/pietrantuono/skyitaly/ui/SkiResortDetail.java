package it.pietrantuono.skyitaly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import it.pietrantuono.skyitaly.databinding.ActivityDetailSkiresortBinding;
import it.pietrantuono.skyitaly.databinding.ActivitySkymapBinding;
import it.pietrantuono.skyitaly.network.model.SkiResort;

public class SkiResortDetail extends BaseActivity{

    private ActivityDetailSkiresortBinding binding;

    private SkiResort skiResort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityDetailSkiresortBinding.inflate(getLayoutInflater());
       getDataIntent();
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
    }

    private void getDataIntent(){
        Bundle b = getIntent().getExtras();
        String jsonParam = b.getString("skiresort");
        skiResort = new Gson().fromJson(jsonParam, SkiResort.class);
    }
}
