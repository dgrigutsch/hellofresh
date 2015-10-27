package com.example.bitninja.hellofrashtest.receipes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.databinding.FragmentReceipesBinding;
import com.example.bitninja.hellofrashtest.receipes.model.ReceipeViewModel;
import com.example.bitninja.hellofrashtest.receipes.model.ReceipesModel;
import com.example.bitninja.hellofrashtest.receipes.presenter.ReceipesPresenter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReceipesActivityFragment extends Fragment implements ReceipesPresenter.ReceipesListener {

    private RecyclerView recyclerView;
    private ReceipeViewModel receipeViewModel;
    private FragmentReceipesBinding binding;

    public ReceipesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_receipes, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.activity_users_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    @Override
    public void onLoadedFromFile(List<ReceipesModel> model) {
        receipeViewModel = new ReceipeViewModel();
        receipeViewModel.receipes.addAll(model);

        binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_receipes);
        binding.setReceipeModel(receipeViewModel);
        binding.activityUsersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
