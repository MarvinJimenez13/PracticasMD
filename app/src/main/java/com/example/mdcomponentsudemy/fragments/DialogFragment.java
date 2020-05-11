package com.example.mdcomponentsudemy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends Fragment {

    public static final String TAG = "FragmentDialogView";
    private static Component mInstance;
    Unbinder mUnbinder;
    @BindView(R.id.btnChooser)
    MaterialButton btnChooser;
    @BindView(R.id.btnConfirm)
    MaterialButton btnConfirm;
    @BindView(R.id.btnFullScreen)
    MaterialButton btnFull;
    @BindView(R.id.btnInfo)
    MaterialButton btnInfo;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return mInstance;

    }
    public DialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;

    }

    @OnClick(R.id.btnInfo)
    public void onInfoClicked(){

        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_ok, null)
                .show();

    }

    @OnClick(R.id.btnConfirm)
    public void onConfirmClicked(){
        //new MaterialAlertDialogBuilder(getActivity())
        //new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_Dialog)
        new MaterialAlertDialogBuilder(getActivity(), R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                .setTitle(R.string.dialog_confirm_title)
                .setMessage(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_confirm, (dialog, which) -> Toast.makeText(getActivity(),
                        R.string.message_action_success, Toast.LENGTH_LONG).show())
                .setNegativeButton(R.string.dialog_cancel, null)
                .show();

    }

    @OnClick(R.id.btnChooser)
    public void onChooserClicked(){

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.select_dialog_item);
        adapter.add("Opcion 1");
        adapter.add("Opcion 2");
        adapter.add("Opcion 3");

        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.dialog_chooser)
                .setAdapter(adapter, (dialog, which) -> Toast.makeText(getActivity(),
                        adapter.getItem(which), Toast.LENGTH_LONG).show())
                .show();

    }

    @OnClick(R.id.btnFullScreen)
    public void onFullClicked(){

        FullScreenFragment dialog = new FullScreenFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        dialog.show(transaction, FullScreenFragment.TAG);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
