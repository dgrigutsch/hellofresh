package com.example.bitninja.hellofresh.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * BindingUtils.
 */
public class BindingUtils {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(final ImageView view, final String url) {
        Picasso.with(view.getContext())
                .load(url)
                .into(view);
    }
}
