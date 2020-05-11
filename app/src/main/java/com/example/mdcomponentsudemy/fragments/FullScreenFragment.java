package com.example.mdcomponentsudemy.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.google.android.material.button.MaterialButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullScreenFragment extends DialogFragment {

    public static final String TAG = "FullScreenFragmentView";
    private static Component mInstance;
    Unbinder mUnbinder;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btnSave)
    MaterialButton btnSave;

    public FullScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_screen, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        toolbar.setNavigationIcon(R.drawable.ic_close);
        toolbar.setNavigationOnClickListener(v -> dismiss());
        toolbar.setTitle(R.string.dialog_full_screen);
        btnSave.setOnClickListener(v -> {

            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show();

        });

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
