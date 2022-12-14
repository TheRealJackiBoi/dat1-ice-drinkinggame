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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    ListView listView;
    Button continueB;
    Game game = Game.getInstance();

    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.score_fragment, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.scorePlayers);
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, game.sortPlayersForScoreBoard());
        listView.setAdapter(adapter);

        //Continue button
        //Change button to go to home instead... and clear players array in game, if game is finished
        //else create onClickListener to go back to GameFragment
        continueB = (Button) view.findViewById(R.id.scoreContinue);
        if (Game.getInstance().isGameEnded()) {

            continueB.setText("Home");

            continueB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //clear players
                    Game game = Game.getInstance();
                    game.getPlayers().clear();
                    game.setGameEnded(false);
                    //Switch fragment
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView3, HomeFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("Home") // name can be null
                            .commit();
                }
            });
        }
        else {

            continueB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    continueB.setText("Continue");

                    //Switch fragment
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView3, GameFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("GameFragment") // name can be null
                            .commit();
                }
            });
        }
    }
}