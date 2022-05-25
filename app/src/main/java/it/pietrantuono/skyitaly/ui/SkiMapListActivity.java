package it.pietrantuono.skyitaly.ui;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import it.pietrantuono.skyitaly.R;
import it.pietrantuono.skyitaly.databinding.ActivitySkymapBinding;

public class SkiMapListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySkymapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySkymapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sky_map_list);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}