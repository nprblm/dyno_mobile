package vtpr.projects.dino.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vtpr.projects.dino.R;
import vtpr.projects.dino.Site;
import vtpr.projects.dino.ui.list.Dino;


public class HomeFragment extends Fragment {
    private static List<News> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HomeAdapter hAdapter;
    private HomeAdapter.RecyclerViewClickListener listener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        setOnClickListener();
        recyclerView = (RecyclerView) view.findViewById(R.id.news);
        newsList.clear();
        hAdapter = new HomeAdapter(newsList, listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(hAdapter);
        prepareDinoData();
        return view;
    }

    private void setOnClickListener() {
        listener = new HomeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getContext(), Site.class);
                List<News> list = hAdapter.getlist();
                intent.putExtra("position", position);
                startActivity(intent);
            }
        };
    }

    private void prepareDinoData() {

        News news0 = new News( "Динозаври - Вікіпедія", 0, 0);
        newsList.add(news0);
        News news1 = new News( "Новини про динозаврів", 1, 1);
        newsList.add(news1);
        News news2 = new News( "Енциклопедія динозаврів", 2, 2);
        newsList.add(news2);
        News news3 = new News( "Сайт про динозаврів", 3, 3);
        newsList.add(news3);
        News news4 = new News( "Фільми про динозаврів", 4, 4);
        newsList.add(news4);
        hAdapter.notifyDataSetChanged();
    }

}