package vtpr.projects.dino.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vtpr.projects.dino.R;
import vtpr.projects.dino.ui.list.Dino;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>  {

    private List<News> newsList;
    private RecyclerViewClickListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            img = (ImageView) view.findViewById(R.id.img);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                listener.onClick(view, getAdapterPosition());
        }
    }


    public HomeAdapter(List<News> dinoList, RecyclerViewClickListener listener) {
        this.newsList = dinoList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.site_info, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.text.setText(news.getText());
        switch(news.getImg())
        {
            case(0):
                holder.img.setImageResource(R.drawable.news0);
                break;
            case(1):
                holder.img.setImageResource(R.drawable.news1);
                break;
            case(2):
                holder.img.setImageResource(R.drawable.news2);
                break;
            case(3):
                holder.img.setImageResource(R.drawable.news3);
                break;
            case(4):
                holder.img.setImageResource(R.drawable.news4);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public List<News> getlist()
    {
        return newsList;
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
