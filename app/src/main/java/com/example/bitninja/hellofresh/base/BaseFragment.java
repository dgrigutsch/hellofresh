package com.example.bitninja.hellofresh.base;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * BaseFragment.
 */
public class BaseFragment<P extends BasePresenter> extends Fragment {
    /**
     * The presenter for this view. Will be instantiated with {@link #getPresenter()}
     */
    protected P presenter;
    private String title;

    /**
     * onAttach the title will be set automatically
     * an the presenter will be set automatically from the activity
     * @param context context
     */
    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            getActivity().setTitle(title);
        }
        if (context instanceof BaseActivity) {
            presenter = (P) ((BaseActivity) context).getPresenter();
        }
    }

    /**
     * returns the Presenter
     * @return P
     */
    @NonNull
    protected P getPresenter() {
        return presenter;
    }

    /**
     * sets the Presenter
     * @param presenter presenter
     */
    public void setPresenter(@NonNull final P presenter) {
        this.presenter = presenter;
    }

    /**
     * returns the BaseActivity class, if the activity of the fragments based on it
     * @return BaseActivity
     */
    public BaseActivity getPresenterActivity() {
        if (getActivity() instanceof BaseActivity)
            return (BaseActivity) getActivity();
        else
            throw new ClassCastException("getActivity is not be an instance of PresenterActivity");
    }

    /**
     * sets the Title
     * @param title title
     */
    protected void setTitle(final String title) {
        this.title = title;
        if (getActivity() != null)
            getActivity().setTitle(title);
    }

    /**
     * returns the default class name as string
     * @return String
     */
    public String getStringTag() {
        return getClass().getSimpleName();
    }


}
