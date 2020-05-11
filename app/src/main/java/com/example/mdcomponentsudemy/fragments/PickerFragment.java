package com.example.mdcomponentsudemy.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PickerFragment extends Fragment {

    public static final String TAG = "Picker";
    private static Component mInstance;
    Unbinder mUnbinder;
    @BindView(R.id.containerMain)
    LinearLayout linearLayout;
    @BindView(R.id.btnFull)
    MaterialButton btnFull;
    @BindView(R.id.btnDialog)
    MaterialButton btnDialog;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.picker);
        mInstance.setType(Constants.STATIC);
        return mInstance;

    }

    public PickerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.btnDialog, R.id.btnFull})
    public void onClicked(View view){

        MaterialDatePicker.Builder<Long> buldier = MaterialDatePicker.Builder.datePicker();
        buldier.setTitleText(R.string.picker_title);
        buldier.setSelection(System.currentTimeMillis());

        switch (view.getId()){

            case R.id.btnDialog:
                buldier.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
                break;
            case R.id.btnFull:
                //buldier.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);
                buldier.setTheme(R.style.FullScreenPicker);
                break;

        }

        MaterialDatePicker<?> picker = buldier.build();
        picker.addOnPositiveButtonClickListener(selection -> {

            //Snackbar.make(linearLayout, R.string.message_action_success, Snackbar.LENGTH_LONG).show();
            Snackbar.make(linearLayout, picker.getHeaderText(), Snackbar.LENGTH_LONG).show();

        });
        picker.addOnNegativeButtonClickListener(dialog -> {

            Snackbar.make(linearLayout, R.string.dialog_negative, Snackbar.LENGTH_LONG).show();

        });
        picker.addOnCancelListener(dialogInterface -> {

            Snackbar.make(linearLayout, R.string.dialog_cancel, Snackbar.LENGTH_LONG).show();

        });
        picker.show(getFragmentManager(), picker.toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
