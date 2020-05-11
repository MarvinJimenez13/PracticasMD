package com.example.mdcomponentsudemy.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponentsudemy.R;
import com.example.mdcomponentsudemy.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AppBarBottomFragment extends DialogFragment {

    Unbinder mUnbinder;
    public static final String TAG = "AppBarBottomView";
    private boolean isCentered;
    @BindView(R.id.floatingbtn)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.bottomBar)
    BottomAppBar bottomAppBar;
    @BindView(R.id.containerMain)
    CoordinatorLayout coordinatorLayout;

    public AppBarBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(androidx.fragment.app.DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottomAppBar.setOnMenuItemClickListener(v ->{

            int resMessage;
            switch (v.getItemId()){

                case R.id.action_favorites:
                    resMessage = R.string.menu_favorites;
                    break;
                case R.id.action_profile:
                    resMessage = R.string.menu_profile;
                    break;
                default:
                    resMessage = R.string.menu_start;
                    break;

            }

            Snackbar.make(coordinatorLayout, resMessage, Snackbar.LENGTH_LONG).setAnchorView(floatingActionButton).show();
            return true;

        });

        bottomAppBar.setNavigationOnClickListener(v ->{

            Snackbar.make(coordinatorLayout, R.string.message_action_success, Snackbar.LENGTH_LONG).setAnchorView(floatingActionButton).show();

        });

        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(bottomAppBar.getFabCradleMargin(), bottomAppBar.getFabCradleRoundedCornerRadius(), bottomAppBar.getCradleVerticalOffset());
        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable) bottomAppBar.getBackground();
        shapeDrawable.setShapeAppearanceModel(shapeDrawable.getShapeAppearanceModel().toBuilder().setTopEdge(topEdge).build());

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.floatingbtn)
    public void OnClick(View view){

        if(isCentered){

            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);

        }else{

            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);

        }

        isCentered = !isCentered;
    }

}
