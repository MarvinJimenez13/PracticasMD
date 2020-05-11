package com.example.mdcomponentsudemy.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFieldFragment extends Fragment {

    private static Component mInstance;
    public static final String TAG = "TextField";
    Unbinder mUnbinder;
    @BindView(R.id.etPrice)
    TextInputEditText etPrice;
    @BindView(R.id.etCapitalLetter)
    TextInputEditText etCapitalLetter;
    @BindView(R.id.tiCapitalLetter)
    TextInputLayout tiCapitalLetter;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);
        return mInstance;

    }
    public TextFieldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_field, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        tiCapitalLetter.setEndIconOnClickListener(view1 ->{

            if(etCapitalLetter.getText() != null){

                String contentStr = etCapitalLetter.getText().toString();
                etCapitalLetter.setText(contentStr.toUpperCase());

            }

        });

        etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty() && Integer.valueOf(s.toString()) <5){

                    etPrice.setError(getString(R.string.error_price_min));

                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

}
