package com.example.bitninja.hellofrashtest.receipes.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.receipes.model.ReceipesModel;

import java.util.List;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.BindingHolder> {

    private List<ReceipesModel> receipes;

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public ReceipeAdapter(List<ReceipesModel> receipes) {
        this.receipes = receipes;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receipe, parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final ReceipesModel aReceipe = receipes.get(position);
//        holder.getBinding().setVariable(BR.movie, aMovie);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return receipes.size();
    }
}
