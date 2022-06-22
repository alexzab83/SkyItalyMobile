package it.pietrantuono.skyitaly.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import it.pietrantuono.skyitaly.ui.SkiMapFragment;

public class SkyResortPagerAdapter extends FragmentStateAdapter {



    public SkyResortPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new SkiMapFragment("all");
        }
        return new SkiMapFragment("prefer");
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
