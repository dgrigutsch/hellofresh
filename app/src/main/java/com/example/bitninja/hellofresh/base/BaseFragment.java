package com.example.bitninja.hellofresh.base;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by Bitninja on 30.10.2015.
 */
public class BaseFragment<P extends BasePresenter> extends Fragment {
    /**
     * The presenter for this view. Will be instantiated with {@link #getPresenter()}
     */
    protected P presenter;
    private String title = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            getActivity().setTitle(title);
        }
        if (context instanceof BaseActivity) {
            presenter = (P) ((BaseActivity) context).getPresenter();
        }
    }

    @NonNull
    protected P getPresenter() {
        return presenter;
    }

    public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

    public BaseActivity getPresenterActivity() {
        if (getActivity() instanceof BaseActivity)
            return (BaseActivity) getActivity();
        else
            throw new ClassCastException("getActivity is not be an instance of PresenterActivity");
    }

    public void setTitle(String title) {
        this.title = title;
        if (getActivity() != null)
            getActivity().setTitle(title);
    }

    public String getStringTag() {
        return getClass().getSimpleName();
    }


}
