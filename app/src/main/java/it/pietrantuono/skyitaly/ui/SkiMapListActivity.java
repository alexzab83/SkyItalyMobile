package it.pietrantuono.skyitaly.ui;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import it.pietrantuono.skyitaly.R;
import it.pietrantuono.skyitaly.databinding.ActivitySkymapBinding;
import it.pietrantuono.skyitaly.ui.adapter.SkyResortPagerAdapter;

public class SkiMapListActivity extends BaseActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySkymapBinding binding;
    private SkyResortPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySkymapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tutti"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Preferiti"));
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new SkyResortPagerAdapter(fragmentManager , getLifecycle());
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

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sky_map_list);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}