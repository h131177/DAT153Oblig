package no.hvl.dat153.recyclerview;



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

import no.hvl.dat153.MainViewModel;
import no.hvl.dat153.Person;
import no.hvl.dat153.R;


public class RecyclerViewFragment extends Fragment implements RecyclerInterface {

    protected MainViewModel mViewModel;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Person> localDataSet;

    //private PersonDao dao = new PersonDao();
    //private List<Person> personList = PersonDao.getInstance().getAllPersons();
    private List<Person> personList;
    /**
     * called to do initial creation of the fragment
     * @param savedInstanceState
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Initialize dataset
        initDataset();
    }
    /**
     *
     * @return the view hierarchy associated with the fragment
     */
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

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager will layout the elements in a similar fashion
        // to the way ListView would layout elements. Linear/Horizontal

        mLayoutManager = new LinearLayoutManager(getActivity());


        mRecyclerView.setLayoutManager(mLayoutManager);

        //setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        // Set CustomAdapter as the adapter for RecyclerView.
        //mAdapter = new CustomAdapter(localDataSet, this);

        //mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    /**
     * Generating the strings for RecyclerViews adapter
     */
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
        mAdapter.notifyItemRemoved(position);

    }



}

