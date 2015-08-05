package com.lbbento.blogsamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lbbento on 03/08/15.
 */


public class Action2Fragment extends android.support.v4.app.Fragment {

    private static final String PARAM_TITLE = "title";

    public static Action2Fragment newInstance(String title) {

        Action2Fragment f = new Action2Fragment();
        Bundle args = new Bundle();
        args.putSerializable(PARAM_TITLE, title);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Title
        Bundle args = getArguments();
        if (args != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle((String)args.getSerializable(PARAM_TITLE));
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_action_2, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //bind views
    }

}
