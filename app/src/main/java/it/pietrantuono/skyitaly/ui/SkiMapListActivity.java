package it.pietrantuono.skyitaly.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import it.pietrantuono.skyitaly.R;
import it.pietrantuono.skyitaly.databinding.ActivitySkymapBinding;
import it.pietrantuono.skyitaly.network.model.SkiResort;
import it.pietrantuono.skyitaly.ui.adapter.SkiResortPagerAdapter;
import it.pietrantuono.skyitaly.ui.callbacks.ISkiResortCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;
import it.pietrantuono.skyitaly.utils.PreferencesUtils;

public class SkiMapListActivity extends BaseActivity  {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySkymapBinding binding;
    private SkiResortPagerAdapter adapter;
    private SkiResortViewModel viewModel;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySkymapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new SkiResortViewModel(this);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tutti"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Preferiti"));
        setActionBar();
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new SkiResortPagerAdapter(fragmentManager , getLifecycle());
        binding.viewPager2.setAdapter(adapter);
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });
     //   viewModel.getSkiResort(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sky_map_list);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.skiresort_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                builder = new AlertDialog.Builder(this);
                builder.setMessage("Vuoi effettuare il logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                PreferencesUtils.deleteUser(SkiMapListActivity.this);
                                finish();
                                startActivity(new Intent(SkiMapListActivity.this, LoginActivity.class));

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Logout");
                alert.show();
                break;
            case R.id.change:
                startActivity(new Intent(this, CambioPassword.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}