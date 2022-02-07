package no.hvl.dat153.recyclerview;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import no.hvl.dat153.Person;
import no.hvl.dat153.PersonDao;
import no.hvl.dat153.R;


public class RecyclerViewFragment extends Fragment implements RecyclerInterface {

    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Person> localDataSet;

    //private PersonDao dao = new PersonDao();
    private List<Person> personList = PersonDao.getInstance().getAllPersons();

    /**
     * called to do initial creation of the fragment
     * @param savedInstanceState
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
       //personList =  b.get("personList");



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

        System.out.println("recycler oncreateview");


        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager will layout the elements in a similar fashion
        // to the way ListView would layout elements. Linear/Horizontal

        mLayoutManager = new LinearLayoutManager(getActivity());


        mRecyclerView.setLayoutManager(mLayoutManager);

        //setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        // Set CustomAdapter as the adapter for RecyclerView.
        mAdapter = new CustomAdapter(localDataSet, this);

        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    /**
     * Generating the strings for RecyclerViews adapter
     */
    private void initDataset() {
        localDataSet = personList;
        System.out.println("recycler initdataset");

    }

    @Override
    public void onItemLongClick(int position) {
        System.out.println("recycler remove");
        personList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    public void onClickSort() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                System.out.println("onClickSort");
                return (person.getName().compareTo(t1.getName()));
            }


        });
        refresh();
    }
    @Override
    public void refresh(){
        System.out.println("refresh");
        mAdapter.notifyDataSetChanged();
    }

}

