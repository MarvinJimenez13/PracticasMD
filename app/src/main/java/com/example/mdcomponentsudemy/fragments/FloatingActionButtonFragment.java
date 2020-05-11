package com.example.mdcomponentsudemy.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FloatingActionButtonFragment extends Fragment {

    public static final String TAG = "Floating Action Button";

    private static Component mInstance;
    @BindView(R.id.fabCustom)
    FloatingActionButton fabCustom;
    @BindView(R.id.fabLegacy)
    FloatingActionButton fabLegacy;
    @BindView(R.id.fabDefault)
    FloatingActionButton fabDefault;
    @BindView(R.id.tvLegacy)
    TextView tvLegacy;

    Unbinder mUnbinder;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_fab_default);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public FloatingActionButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floating_action_button, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        fabDefault.setOnClickListener(view1 ->{
            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_LONG).show();
        });
        fabLegacy.setOnClickListener(view1 ->{
            fabLegacy.setVisibility(View.GONE);
            tvLegacy.setVisibility(View.GONE);
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
