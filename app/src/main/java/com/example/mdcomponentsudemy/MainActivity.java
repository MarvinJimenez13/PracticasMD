package com.example.mdcomponentsudemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.mdcomponentsudemy.adapters.ComponentAdapter;
import com.example.mdcomponentsudemy.fragments.AppBarFragment;
import com.example.mdcomponentsudemy.fragments.BottomNavigationBarFragment;
import com.example.mdcomponentsudemy.fragments.ButtonFragment;
import com.example.mdcomponentsudemy.fragments.CardFragment;
import com.example.mdcomponentsudemy.fragments.CheckboxFragment;
import com.example.mdcomponentsudemy.fragments.DialogFragment;
import com.example.mdcomponentsudemy.fragments.FloatingActionButtonFragment;
import com.example.mdcomponentsudemy.fragments.MenuFragment;
import com.example.mdcomponentsudemy.fragments.PickerFragment;
import com.example.mdcomponentsudemy.fragments.SnackBarFragment;
import com.example.mdcomponentsudemy.fragments.TextFieldFragment;
import com.example.mdcomponentsudemy.utils.Component;
import com.example.mdcomponentsudemy.utils.Constants;
import com.example.mdcomponentsudemy.utils.OnClickListener;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckboxFragment.getmInstance());
        mAdapter.add(CardFragment.getmInstance());
        mAdapter.add(MenuFragment.getmInstance());
        mAdapter.add(DialogFragment.getmInstance());
        mAdapter.add(AppBarFragment.getmInstance());
        mAdapter.add(PickerFragment.getmInstance());
        mAdapter.reverse();
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    /*
     * OnClickListener
     * */
    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollActivity.class);
        } else { //STATIC
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}
