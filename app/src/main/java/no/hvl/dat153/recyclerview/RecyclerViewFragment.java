package no.hvl.dat153.recyclerview;



import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observer;
import java.util.Random;

import no.hvl.dat153.MainViewModel;
import no.hvl.dat153.Person;
import no.hvl.dat153.R;


public class RecyclerViewFragment extends Fragment implements RecyclerInterface {
    protected MainViewModel mViewModel;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Person> localDataSet;
    private List<Person> personList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getAllPerson().observe(getViewLifecycleOwner(), (List<Person> personList) -> {
            mAdapter = new CustomAdapter(personList, this);
            mRecyclerView.setAdapter(mAdapter);
        });

        final Button sortAlpha = rootView.findViewById(R.id.sortButton);
        sortAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortAsc();
            }
        });

        final Button sortRevAlpha = rootView.findViewById(R.id.sortButton2);
        sortRevAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortDesc();
            }
        });
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        return rootView;
    }

    private void initDataset() {
        localDataSet = personList;
    }

    public void sortDesc() {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getAllPersonsDesc().observe(getViewLifecycleOwner(), (List<Person> personList) -> {
            mAdapter = new CustomAdapter(personList, this);
            mRecyclerView.setAdapter(mAdapter);
        });
    }

    public void sortAsc() {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getAllPersonsAsc().observe(getViewLifecycleOwner(), (List<Person> personList) -> {
            mAdapter = new CustomAdapter(personList, this);
            mRecyclerView.setAdapter(mAdapter);
        });
    }

    @Override
    public void onItemLongClick(int position) {
        Person p = mViewModel.getAllPerson().getValue().get(position);
        mViewModel.delete(p);

    }
}

