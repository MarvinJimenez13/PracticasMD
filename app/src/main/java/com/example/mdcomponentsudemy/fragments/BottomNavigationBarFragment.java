package com.example.mdcomponentsudemy.fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomNavigationBarFragment extends Fragment {

    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;
    private static Component mInstance;
    public static final String TAG = "Bottom Navigation";
    Unbinder mUnbinder;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;

    }

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottomNavigation.getOrCreateBadge(R.id.action_start);

        //bottomNavigation.removeBadge(R.id.action_start);

        BadgeDrawable favoriteBadge = bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(1000);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();

    }
}
