package it.pietrantuono.skyitaly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import it.pietrantuono.skyitaly.databinding.FragmentSkymapBinding;
import it.pietrantuono.skyitaly.network.model.SkiResort;
import it.pietrantuono.skyitaly.ui.adapter.SkiResortListAdapter;
import it.pietrantuono.skyitaly.ui.callbacks.ISkiResortCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;

public class SkiMapFragment extends BaseFragment implements ISkiResortCallback, SkiResortListAdapter.SkiResortAdapterInterface{

    private FragmentSkymapBinding binding;
    private int type;
    private SkiResortViewModel viewModel;
    private List<SkiResort> skiResortList = new ArrayList<>();

    private SkiResortListAdapter adapter;

    public SkiMapFragment(int type){
        this.type = type;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSkymapBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new SkiResortViewModel(getContext());
        adapter = new SkiResortListAdapter();
        adapter.setSkiResortList(skiResortList);
        binding.skiResortRecycle.setAdapter(adapter);
        binding.skiResortRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getSkiResort(this, type);
        adapter.setActionInterface(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public List<SkiResort> getSkiResorts(List<SkiResort> skiResortList) {
        this.skiResortList = skiResortList;
        adapter.setSkiResortList(this.skiResortList);
        return null;
    }

    @Override
    public void onItemClick(SkiResort sr) {
        String jsonParam = new Gson().toJson(sr);
        Bundle b = new Bundle();
        b.putString("skiresort", jsonParam);
        Intent intent = new Intent(getContext(), SkiResortDetail.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}