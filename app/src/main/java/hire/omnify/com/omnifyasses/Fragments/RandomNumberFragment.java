package hire.omnify.com.omnifyasses.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hire.omnify.com.omnifyasses.Activities.SortingActivity;
import hire.omnify.com.omnifyasses.Adapters.RandomNumberAdapter;
import hire.omnify.com.omnifyasses.R;

/**
 * Created by Dell on 20-01-2018.
 */

public class RandomNumberFragment extends Fragment {
    RecyclerView recyclerView;
    Button button, sortButton;
    List<Integer> randomNumbersArrayList;
    RandomNumberAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        button = view.findViewById(R.id.push_button);
        sortButton = view.findViewById(R.id.sort_button);
        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        perform_action(view);
        recyclerView.setLayoutManager(layoutManager);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform_action(v);


            }
        });

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SortingActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }


    public void perform_action(View v) {
        randomNumbersArrayList = new ArrayList<>();


        for (int i = 0; i < 20; ) {
            Random random = new Random();
            int min = 10;
            int max = 98;
            int rand = random.nextInt((max - min) + 1) + min;
            if (!randomNumbersArrayList.contains(rand)) {
                randomNumbersArrayList.add(rand);
                i++;
            }
        }

        mAdapter = new RandomNumberAdapter(randomNumbersArrayList);
        recyclerView.setAdapter(mAdapter);


    }

}
