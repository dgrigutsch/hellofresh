package com.example.bitninja.hellofresh.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bitninja.hellofresh.ui.binder.ItemBinder;

import java.lang.ref.WeakReference;
import java.util.Collection;

/**
 * BindingRecyclerViewAdapter.
 */
@SuppressWarnings("unused")
public class BindingRecyclerViewAdapter<T> extends RecyclerView.Adapter<BindingRecyclerViewAdapter.ViewHolder> {
    private final WeakReferenceOnListChangedCallback onListChangedCallback;
    private final ItemBinder<T> itemBinder;
    private ObservableList<T> items;
    private LayoutInflater inflater;

    /**
     *
     * @param itemBinder itemBinder
     * @param items items
     */
    public BindingRecyclerViewAdapter(final ItemBinder<T> itemBinder, @Nullable final Collection<T> items) {
        this.itemBinder = itemBinder;
        this.onListChangedCallback = new WeakReferenceOnListChangedCallback<>(this);
        setItems(items);
    }

    /**
     *
     * @return ObservableList
     */
    public ObservableList<T> getItems() {
        return items;
    }

    /**
     *
     * @param items items
     */
    public void setItems(@Nullable final Collection<T> items) {
        if (this.items == items) {
            return;
        }

        if (this.items != null) {
            this.items.removeOnListChangedCallback(onListChangedCallback);
            notifyItemRangeRemoved(0, this.items.size());
        }

        if (items instanceof ObservableList) {
            this.items = (ObservableList<T>) items;
            notifyItemRangeInserted(0, this.items.size());
            this.items.addOnListChangedCallback(onListChangedCallback);
        } else if (items != null) {
            this.items = new ObservableArrayList<>();
            this.items.addOnListChangedCallback(onListChangedCallback);
            this.items.addAll(items);
        } else {
            this.items = null;
        }
    }

    /**
     *
     * @param recyclerView recyclerView
     */
    @Override
    public void onDetachedFromRecyclerView(final RecyclerView recyclerView) {
        if (items != null) {
            items.removeOnListChangedCallback(onListChangedCallback);
        }
    }

    /**
     *
     * @param viewGroup viewGroup
     * @param layoutId layoutId
     * @return ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int layoutId) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }

        final ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, viewGroup, false);
        return new ViewHolder(binding);
    }

    /**
     *
     * @param viewHolder viewHolder
     * @param position position
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final T item = items.get(position);
        viewHolder.binding.setVariable(itemBinder.getBindingVariable(item), item);
        viewHolder.binding.executePendingBindings();
    }

    /**
     *
     * @param position position
     * @return int
     */
    @Override
    public int getItemViewType(final int position) {
        return itemBinder.getLayoutRes(items.get(position));
    }

    /**
     *
     * @return int
     */
    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    /**
     * ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        ViewHolder(final ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static class WeakReferenceOnListChangedCallback<T> extends ObservableList.OnListChangedCallback {

        private final WeakReference<BindingRecyclerViewAdapter<T>> adapterReference;

        public WeakReferenceOnListChangedCallback(final BindingRecyclerViewAdapter<T> bindingRecyclerViewAdapter) {
            this.adapterReference = new WeakReference<>(bindingRecyclerViewAdapter);
        }

        @Override
        public void onChanged(final ObservableList sender) {
            final RecyclerView.Adapter<ViewHolder> adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onItemRangeChanged(final ObservableList sender, final int positionStart, final int itemCount) {
            final RecyclerView.Adapter<ViewHolder> adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(positionStart, itemCount);
            }
        }

        @Override
        public void onItemRangeInserted(final ObservableList sender, final int positionStart, final int itemCount) {
            final RecyclerView.Adapter<ViewHolder> adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemRangeInserted(positionStart, itemCount);
            }
        }

        @Override
        public void onItemRangeMoved(final ObservableList sender, final int fromPosition, final int toPosition, final int itemCount) {
            final RecyclerView.Adapter<ViewHolder> adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemMoved(fromPosition, toPosition);
            }
        }

        @Override
        public void onItemRangeRemoved(final ObservableList sender, final int positionStart, final int itemCount) {
            final RecyclerView.Adapter<ViewHolder> adapter = adapterReference.get();
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(positionStart, itemCount);
            }
        }
    }
}