package it.pietrantuono.skyitaly.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.pietrantuono.skyitaly.R;
import it.pietrantuono.skyitaly.databinding.SkiResortItemBinding;
import it.pietrantuono.skyitaly.network.model.SkiResort;
import it.pietrantuono.skyitaly.ui.SkiResortDetail;

public class SkiResortListAdapter extends RecyclerView.Adapter<SkiResortListAdapter.SkiResortViewHolder> {

    private SkiResortItemBinding itemBinding;
    private List<SkiResort> listResort = new ArrayList<>();
    private SkiResortAdapterInterface actionInterface;


    @NonNull
    @Override
    public SkiResortViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SkiResortItemBinding skiResortListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.ski_resort_item, parent, false);
        return new SkiResortViewHolder(skiResortListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SkiResortViewHolder holder, int position) {
        SkiResort resort = listResort.get(position);
        holder.listItemBinding.txtProv.setText(resort.getRegion());
        holder.listItemBinding.txtCity.setText(resort.getLocation());
        holder.listItemBinding.setSkiResort(resort);
    }

    @Override
    public int getItemCount() {
        if (listResort != null) {
            return listResort.size();
        } else {
            return 0;
        }
    }
    public void setSkiResortList(List<SkiResort> list) {
        this.listResort = list;
        notifyDataSetChanged();
    }

    class SkiResortViewHolder extends RecyclerView.ViewHolder {

        private SkiResortItemBinding listItemBinding;

        public SkiResortViewHolder(@NonNull SkiResortItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;

            listItemBinding.skiItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (actionInterface != null){
                        actionInterface.onItemClick(listResort.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

    public interface SkiResortAdapterInterface {
        void onItemClick(SkiResort sr);
    }

    public void setActionInterface(SkiResortAdapterInterface actionInterface){

        this.actionInterface = actionInterface;
    }
}
