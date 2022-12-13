package com.example.dat1_ice_drinkinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GameFragment extends Fragment {




    public GameFragment() {
        // Required empty public constructor
    }


    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        Button endButton = view.findViewById(R.id.endButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, ScoreFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("ScoreFragment") // name can be null
                        .commit();

            }
        });

    }

}