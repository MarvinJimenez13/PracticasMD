package com.example.mdcomponentsudemy.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppBarFragment extends Fragment {

    public static final String TAG = "AppBarView";
    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getmInstance(){

        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.bar);
        mInstance.setType(Constants.STATIC);
        return mInstance;

    }
    public AppBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        return view;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        mUnbinder.unbind();

    }

    @OnClick({R.id.topBTN, R.id.bottomBTN})
    public void OnClick(View view){

        switch (view.getId()){

            case R.id.topBTN:
                AppBarTopFragment dialog = new AppBarTopFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                dialog.show(transaction, AppBarTopFragment.TAG);
                break;

            case R.id.bottomBTN:
                AppBarBottomFragment dialogBottom = new AppBarBottomFragment();
                FragmentTransaction transactionBottom = getFragmentManager().beginTransaction();
                dialogBottom.show(transactionBottom, AppBarBottomFragment.TAG);
                break;

        }

    }

}
