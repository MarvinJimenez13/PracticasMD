package com.example.mdcomponentsudemy.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mdcomponentsudemy.fragments.AppBarFragment;
import com.example.mdcomponentsudemy.fragments.CardFragment;
import com.example.mdcomponentsudemy.fragments.CheckboxFragment;
import com.example.mdcomponentsudemy.fragments.DialogFragment;
import com.example.mdcomponentsudemy.fragments.FloatingActionButtonFragment;
import com.example.mdcomponentsudemy.fragments.FullScreenFragment;
import com.example.mdcomponentsudemy.fragments.MenuFragment;
import com.example.mdcomponentsudemy.fragments.PickerFragment;
import com.example.mdcomponentsudemy.fragments.SnackBarFragment;
import com.example.mdcomponentsudemy.fragments.ButtonFragment;
import com.example.mdcomponentsudemy.fragments.BottomNavigationBarFragment;
import com.example.mdcomponentsudemy.fragments.TextFieldFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case CheckboxFragment.TAG:
                fragment = new CheckboxFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;
            case DialogFragment.TAG:
                fragment = new DialogFragment();
                break;
            case AppBarFragment.TAG:
                fragment = new AppBarFragment();
                break;
            case PickerFragment.TAG:
                fragment = new PickerFragment();
                break;

        }

        return fragment;
    }
}
