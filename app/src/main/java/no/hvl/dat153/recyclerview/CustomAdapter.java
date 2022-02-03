package no.hvl.dat153.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat153.Person;
import no.hvl.dat153.R;
import no.hvl.dat153.MainActivity;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<Person> personList = MainActivity.personList;



    /**
     * Provide a reference to the type of views that you are using
     * (custom viewholder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            //Define click listener for the ViewHolders view
            textView = view.findViewById(R.id.textView2);
            imageView = view.findViewById(R.id.imageView2);
        }

    }

    /**
     * Initialize the dataset of the adapter
     *
     * @param personList containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(List<Person> personList){
        this.personList = personList;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        //Create new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.db_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    //Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position){

        //Get elements from you dataset at this position and replace the
        //the contents of the view with that element
        viewHolder.textView.setText(personList.get(position).getName());
        viewHolder.imageView.setImageResource(personList.get(position).getPath());

    }

    //Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return personList.size();
    }
}
