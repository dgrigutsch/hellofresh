package com.example.bitninja.hellofrashtest.receipes.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.receipes.adapter.ReceipeAdapter;
import com.example.bitninja.hellofrashtest.receipes.model.ReceipesModel;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinder;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinderBase;
import com.example.bitninja.hellofrashtest.ui.binder.RecyclerViewBindings;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReceipesActivityFragment extends Fragment {

    private RecyclerView recyclerView;

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

    public void onUpdateReceipes(List<ReceipesModel> model) {
        ReceipeAdapter adapter = new ReceipeAdapter(model);
        recyclerView.setAdapter(adapter);

    }
}
