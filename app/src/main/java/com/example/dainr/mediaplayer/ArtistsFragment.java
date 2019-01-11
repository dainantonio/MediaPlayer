package com.example.dainr.mediaplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ArtistsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout,container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Create an ArrayList of Songs; instantiated here
        final ArrayList<RecyclerViewModel> songs = new ArrayList<RecyclerViewModel>();

        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));
        songs.add(new RecyclerViewModel("Black is Beautiful"));


        final RecyclerViewAdapter itemsAdapter = new RecyclerViewAdapter(ArtistsFragment.this.getActivity(), songs, null);
        final RecyclerView clv = (RecyclerView) view.findViewById(R.id.clist);
        clv.setLayoutManager(new LinearLayoutManager(ArtistsFragment.this.getActivity()));
        clv.setHasFixedSize(true);
        clv.setAdapter(itemsAdapter);

    }
}