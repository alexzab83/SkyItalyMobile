package it.pietrantuono.skyitaly.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SkyResortListAdapter extends RecyclerView.Adapter<SkyResortListAdapter.SkiResortViewHolder> {


    @NonNull
    @Override
    public SkiResortViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SkiResortViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SkiResortViewHolder extends RecyclerView.ViewHolder {

        public SkiResortViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
