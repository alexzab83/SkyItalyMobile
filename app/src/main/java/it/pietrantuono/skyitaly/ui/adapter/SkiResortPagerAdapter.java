package it.pietrantuono.skyitaly.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import it.pietrantuono.skyitaly.ui.SkiMapFragment;

public class SkiResortPagerAdapter extends FragmentStateAdapter {



    public SkiResortPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new SkiMapFragment(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
