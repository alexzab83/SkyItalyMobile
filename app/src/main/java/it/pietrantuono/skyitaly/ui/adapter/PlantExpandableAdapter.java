package it.pietrantuono.skyitaly.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import androidx.databinding.DataBindingUtil;

import java.util.List;

import it.pietrantuono.skyitaly.R;
import it.pietrantuono.skyitaly.databinding.ItemPlantSlopeBinding;
import it.pietrantuono.skyitaly.network.model.Plant;

public class PlantExpandableAdapter extends BaseExpandableListAdapter {

    private List<Plant> listPlant;
    private ItemPlantSlopeBinding binding;
    private ItemPlantSlopeBinding binding2;

    public PlantExpandableAdapter(List<Plant> listPlant) {
        this.listPlant = listPlant;
    }

    @Override
    public int getGroupCount() {
        return listPlant.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listPlant.get(i).getListSkiSlope().size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_plant_slope, viewGroup, false);
            view = binding.getRoot();
        }else {
            binding = (ItemPlantSlopeBinding) view.getTag();
        }

        binding.setName(listPlant.get(i).getName());
        view.setTag(binding);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null){
            binding2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_plant_slope, viewGroup, false);
            view = binding2.getRoot();
        }else {
            binding = (ItemPlantSlopeBinding) view.getTag();
        }

        binding2.setName(listPlant.get(i).getListSkiSlope().get(i1).getName());
        view.setTag(binding2);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
