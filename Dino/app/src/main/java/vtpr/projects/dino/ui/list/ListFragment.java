package vtpr.projects.dino.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vtpr.projects.dino.DinoAdapter;
import vtpr.projects.dino.R;

public class ListFragment extends Fragment {
    private List<Dino> dinoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DinoAdapter dAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rec_view);
        dAdapter = new DinoAdapter(dinoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(dAdapter);

        prepareMovieData();
        return view;
    }
    private void prepareMovieData() {
        Dino dino = new Dino("Барапазавр", 1, 1);
        dinoList.add(dino);
         dino = new Dino("Омейзавр", 2, 1);
        dinoList.add(dino);
         dino = new Dino("Брахіозавр", 3, 1);
        dinoList.add(dino);
         dino = new Dino("Камаразавр", 2, 1);
        dinoList.add(dino);
         dino = new Dino("Апатозавр", 1, 1);
        dinoList.add(dino);
        dino = new Dino("Барозавр", 2, 1);
        dinoList.add(dino);
        dino = new Dino("Дикреозавр", 2, 1);
        dinoList.add(dino);
        dino = new Dino("Диплодок", 3, 1);
        dinoList.add(dino);
        dino = new Dino("Маменчізавр", 1, 1);
        dinoList.add(dino);
        dAdapter.notifyDataSetChanged();
    }
}