package com.example.dat1_ice_drinkinggame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


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

        //Set card Strings
        TextView playerName = view.findViewById(R.id.card_player_name_textview);
        TextView challenge = view.findViewById(R.id.challengeTextView);
        TextView sips = view.findViewById(R.id.sipsTextView);

        Player player = Game.getInstance().getNewPlayer();
        Card card = Game.getInstance().getNewCard();

        playerName.setText(player.getName());
        challenge.setText(card.getChallenge());
        sips.setText(Integer.toString(card.getSips()));


        //NextButton onClickListener -> go to ScoreFragment
        Button nextButton = view.findViewById(R.id.next_card_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Switch fragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, ScoreFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("ScoreFragment") // name can be null
                        .commit();
            }
        });

        //DrinkButton onClickListener -> add sips to player and go to ScoreFragment
        Button drinkButton = view.findViewById(R.id.concequence_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add sips to player
                player.addSips(card.getSips());

                //Switch fragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, ScoreFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("ScoreFragment") // name can be null
                        .commit();
            }
        });

        //EndGameButton onClickListener
        Button endButton = view.findViewById(R.id.endButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Game finished, set GameEnded to true
                Game.getInstance().setGameEnded(true);

                //Switch fragment
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