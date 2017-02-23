package assignment.android.acadgild.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import assignment.android.acadgild.models.DataHandler;
import assignment.android.acadgild.movie.R;

/**
 * Created by DivyaVipin on 2/22/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

        Context context;
        List<DataHandler> data;//Data Handler object is adding to a list and then passed to adapter
        ClickListener clickListener;

public DataAdapter(Context context, List<DataHandler> data){
        this.context=context;
        this.data=data;
        }



public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_row, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

        }


@Override
public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText("Name: "+data.get(position).getName());
         holder.vote_count.setText("Vote Count:"+data.get(position).getVote_count());
        holder.id.setText("Id: "+data.get(position).getId()+"\n");
        holder.parent.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        if(clickListener!=null){
        clickListener.ItemClicked(v,position);
        }
        }
        });
        }

@Override
public int getItemCount() {
        return data.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{

    TextView name;
    TextView id;
    TextView vote_count;
    LinearLayout parent;

    public ViewHolder(View itemView) {
        super(itemView);
        name= (TextView)itemView.findViewById(R.id.name);

        id=(TextView)itemView.findViewById(R.id.Id);

        vote_count=(TextView)itemView.findViewById(R.id.voteCount);
        parent= (LinearLayout)itemView.findViewById(R.id.parent);
    }
}

public interface ClickListener{
    void ItemClicked(View v, int position);
}
    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }
}
