package vtpr.projects.dino;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import vtpr.projects.dino.ui.list.Dino;
import vtpr.projects.dino.ui.list.ListFragment;

public class DinoAdapter extends RecyclerView.Adapter<DinoAdapter.MyViewHolder> {

    private List<Dino> dinoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, weight, period;
        ImageView eat, img;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            eat = (ImageView) view.findViewById(R.id.eat);
            img = (ImageView) view.findViewById(R.id.img);
            weight = (TextView) view.findViewById(R.id.weight);
            period = (TextView) view.findViewById(R.id.period);
        }
    }


    public DinoAdapter(List<Dino> dinoList) {
        this.dinoList = dinoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dino_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Dino dino = dinoList.get(position);
        holder.name.setText(dino.getName());
        holder.weight.setText("Вага: "+dino.getWeight()+" кг");
        holder.period.setText("Період: "+dino.getPeriod());
        switch (dino.getEat()) {
            case (1):
                holder.eat.setImageResource(R.drawable.meat);
                break;
            case (2):
                holder.eat.setImageResource(R.drawable.vegan);
                break;
            case (3):
                holder.eat.setImageResource(R.drawable.all);
                break;

        }
        switch(dino.getImg())
        {
            case(1):
                holder.img.setImageResource(R.drawable.dino1);
                break;
            case(2):
                holder.img.setImageResource(R.drawable.dino2);
                break;
            case(3):
                holder.img.setImageResource(R.drawable.dino3);
                break;
            case(4):
                holder.img.setImageResource(R.drawable.dino4);
                break;
            case(5):
                holder.img.setImageResource(R.drawable.dino5);
                break;
            case(6):
                holder.img.setImageResource(R.drawable.dino6);
                break;
            case(7):
                holder.img.setImageResource(R.drawable.dino7);
                break;
            case(8):
                holder.img.setImageResource(R.drawable.dino8);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dinoList.size();
    }

    public void filterlist(ArrayList<Dino> filteredlist)
    {
        dinoList=filteredlist;
        notifyDataSetChanged();
    }

}
