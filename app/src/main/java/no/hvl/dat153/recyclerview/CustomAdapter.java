package no.hvl.dat153.recyclerview;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import no.hvl.dat153.Person;
import no.hvl.dat153.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements RecyclerInterface {

    private final RecyclerInterface recyclerInterface;

    List<Person> personList;
    CustomAdapter adapter;
    /**
     * Initialize the dataset of the adapter
     *
     * @param personList containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(List<Person> personList, RecyclerInterface recyclerInterface){
        this.personList = personList;
        this.recyclerInterface = recyclerInterface;
        System.out.println("adapter constructor");

    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom viewholder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        FrameLayout buttonView;

        public ViewHolder(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);
            //Define click listener for the ViewHolders view
            textView = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView2);
            buttonView = itemView.findViewById(R.id.frameItem);
            buttonView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (recyclerInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerInterface.onItemLongClick(pos);
                        }
                    }
                    return true;
                }
            });
        }
    }


    //Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType){
        //Create new view, which defines the UI of the list item
       LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
       View view = inflater.inflate(R.layout.db_row_item, viewGroup, false);

        return new ViewHolder(view, recyclerInterface);
    }

    //Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){

        //Get elements from you dataset at this position and replace the
        //the contents of the view with that element
        holder.textView.setText(personList.get(position).getName());
        holder.imageView.setImageURI(personList.get(position).getPath());
        holder.buttonView.setBackgroundColor(personList.get(position).getCurrentColor());
    }

    //Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return personList.size();
    }

    @Override
    public void onItemLongClick(int position) {
        personList.remove(position);
        adapter.notifyItemRemoved(position);

    }



}

