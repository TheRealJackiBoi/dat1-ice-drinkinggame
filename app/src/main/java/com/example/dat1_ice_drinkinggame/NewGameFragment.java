package com.example.dat1_ice_drinkinggame;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dat1_ice_drinkinggame.databinding.ActivityMainBinding;
import com.example.dat1_ice_drinkinggame.databinding.GameFragmentBinding;
import com.example.dat1_ice_drinkinggame.databinding.NewGameFragmentBinding;

import java.util.ArrayList;

public class NewGameFragment extends Fragment {

    private NewGameFragmentBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText txt;
    ListView show;
    Button add;
    ArrayList<String> playerArr = new ArrayList<>();

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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.newGameStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NewGameFragment.this)
                        .navigate(R.id.action_NewGameFragment_to_GameFragment);
            }
        });
        view.findViewById(R.id.new_game_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
        txt = (EditText) view.findViewById(R.id.playerName);
        show = (ListView) view.findViewById(R.id.listPlayers);
        add = (Button) view.findViewById(R.id.new_game_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput = txt.getText().toString();

                if(playerArr.contains(getInput)) {
                    Toast.makeText(getActivity(), "Username already exists", Toast.LENGTH_SHORT).show();
                }

                else if(getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getActivity(), "Input field cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    playerArr.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, playerArr);
                    show.setAdapter(adapter);
                    ((EditText)view.findViewById(R.id.playerName)).setText("");
                }
            }
        });

    }
}