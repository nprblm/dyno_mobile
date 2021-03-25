package vtpr.projects.dino.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import vtpr.projects.dino.R;
import vtpr.projects.dino.ui.info.InfoViewModel;

public class HomeFragment extends Fragment {
    private ListView list;
    private String[] dino_list;
    private ArrayAdapter <String> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        list = (ListView) view.findViewById(R.id.listview);
        dino_list = getResources().getStringArray(R.array.dino);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,dino_list);
        list.setAdapter(adapter);
        return view;
    }
}