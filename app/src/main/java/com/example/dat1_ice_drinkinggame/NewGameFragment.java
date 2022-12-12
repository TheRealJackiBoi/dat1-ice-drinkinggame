package com.example.dat1_ice_drinkinggame;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class NewGameFragment extends Fragment {

    Button add;
    ArrayList<String> playerArr = new ArrayList<>();
    EditText txt;
    ListView show;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static NewGameFragment newInstance(String param1, String param2) {
        NewGameFragment fragment = new NewGameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.new_game_fragment, container, false);

        Button b = (Button) v.findViewById(R.id.new_game_startGame);
        b.setOnClickListener((View.OnClickListener) this);
        return v;
    }
}