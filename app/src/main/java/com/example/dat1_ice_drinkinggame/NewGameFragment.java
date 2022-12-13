package com.example.dat1_ice_drinkinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dat1_ice_drinkinggame.databinding.NewGameFragmentBinding;

import java.util.ArrayList;

public class NewGameFragment extends Fragment {

    private NewGameFragmentBinding binding;


    EditText txt;
    ListView show;
    Button add;

    public static NewGameFragment newInstance(String param1, String param2) {
        NewGameFragment fragment = new NewGameFragment();
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

        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO: switch fragment
        view.findViewById(R.id.new_game_startGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Game.getInstance().getPlayers().size() != 0) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragmentContainerView3, GameFragment.class, null)
                                    .setReorderingAllowed(true)
                                    .addToBackStack("GameFragment") // name can be null
                                    .commit();

                } else {
                    Toast.makeText(getContext(),"Add players to start game", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt = (EditText) view.findViewById(R.id.playerName);
        show = (ListView) view.findViewById(R.id.listPlayers);
        add = (Button) view.findViewById(R.id.new_game_add);
        Game game = Game.getInstance();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = txt.getText().toString();

                if(game.getPlayers().contains(input)) {
                    Toast.makeText(getActivity(), "Username already exists", Toast.LENGTH_SHORT).show();
                }
                else if(input == null || input.trim().equals("")) {
                    Toast.makeText(getActivity(), "Input field cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    game.addPlayer(new Player(input,0));
                    ArrayList<String> strings = new ArrayList<>();
                    for (Player p :
                            game.getPlayers()) {
                        strings.add(p.getName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
                    show.setAdapter(adapter);
                    txt.setText("");
                }
            }
        });
    }
}