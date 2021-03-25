package vtpr.projects.dino;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vtpr.projects.dino.ui.list.Dino;

public class DinoAdapter extends RecyclerView.Adapter<DinoAdapter.MyViewHolder> {

    private List<Dino> dinoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        ImageView eat, img;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            eat = (ImageView) view.findViewById(R.id.eat);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }


    public DinoAdapter(List<Dino> moviesList) {
        this.dinoList = moviesList;
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
        if (dino.getEat()==1)
        {
            holder.eat.setImageResource(R.drawable.meat);
        }
        else if (dino.getEat()==2)
        {
            holder.eat.setImageResource(R.drawable.vegan);
        }
        else if (dino.getEat()==3)
        {
            holder.eat.setImageResource(R.drawable.all);
        }
    }

    @Override
    public int getItemCount() {
        return dinoList.size();
    }
}
