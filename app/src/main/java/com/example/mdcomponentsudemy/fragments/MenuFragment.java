package com.example.mdcomponentsudemy.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public static final String TAG = "MenuView";
    private static Component mInstance;
    Unbinder mUnbinder;
    @BindView(R.id.btnMenuPop)
    MaterialButton btnPop;
    @BindView(R.id.autoTV)
    AutoCompleteTextView auto;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.menu);
        mInstance.setType(Constants.STATIC);
        return mInstance;

    }

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        btnPop.setOnClickListener(v -> {

            PopupMenu popUpMenu = new PopupMenu(getActivity(), v);
            popUpMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popUpMenu.getMenu());
            popUpMenu.show();

        });

        String[] course = new String[]{"Experto en FireBase para Android +MVP curso Completo +30 horas",
        "Material Design curso/theming profesional para Android", "Android: fundamentos calidad", "Kotlin 2020"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_menu_dropdown, course);
        auto.setAdapter(adapter);
        auto.setOnClickListener(v -> {

            Toast.makeText(getContext(), "ID: ", Toast.LENGTH_LONG).show();

        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
