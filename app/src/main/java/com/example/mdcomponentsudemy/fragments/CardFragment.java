package com.example.mdcomponentsudemy.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.chip.Chip;

import java.io.BufferedReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    public static final String TAG = "CardView";
    private static Component mInstance;
    @BindView(R.id.imgCardLarge)
    AppCompatImageView imgCardLarge;
    @BindView(R.id.chipSecond)
    Chip chipSecond;
    @BindView(R.id.chipThird)
    Chip chipThird;
    Unbinder mUnbinder;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;

    }

    public CardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop();

        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg")
                .apply(options)
                .into(imgCardLarge);

        chipSecond.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if(isChecked){

                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();

            }

        });

        chipThird.setOnCloseIconClickListener(v -> chipThird.setVisibility(View.GONE));

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.chipFirst)
    public void onViewClicked(){

        Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();

    }

}
