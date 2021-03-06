package com.example.aqi.travelapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Fragment which shows a gridview of all the user's itineraries
 * and allows the user to select an itinerary to go to
 */
public class ItineraryPlannerFragment extends Fragment {

    public ItineraryPlannerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_itinerary_planner, container, false);

        GridView gridview = (GridView) root.findViewById(R.id.fragment_itgridview);
        gridview.setAdapter(new ImageAdapter(getActivity(),ItineraryManager
        .saveditineraries.size()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Transition to new fragment showing the selected itinerary
                Fragment fragment = ItineraryFragment.newInstance(position);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.relative, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        return root;
    }

}
