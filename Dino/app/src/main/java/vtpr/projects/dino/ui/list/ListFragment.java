package vtpr.projects.dino.ui.list;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import vtpr.projects.dino.DatabaseHelper;
import vtpr.projects.dino.DinoAdapter;
import vtpr.projects.dino.R;

public class ListFragment extends Fragment {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private List<Dino> dinoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DinoAdapter dAdapter;
    private DinoAdapter.RecyclerViewClickListener listener;
    private String text;
    public EditText editText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);
        setOnClickListener();
        recyclerView = (RecyclerView) view.findViewById(R.id.rec_view);
        dAdapter = new DinoAdapter(dinoList, listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(dAdapter);
        mDBHelper = new DatabaseHelper(getContext());
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        prepareDinoData();
        editText = (EditText) view.findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            text = s.toString();
                filter(s.toString());
            }
        });
        return view;
    }

    private void setOnClickListener() {
        listener = new DinoAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {

                Intent intent = new Intent(getContext(), DinoInfoFragment.class);
                List<Dino> list = dAdapter.getlist();
                intent.putExtra("name", position);
                intent.putExtra("text", list.get(position).getName());
                startActivity(intent);
            }
        };
    }

    private void filter (String text)
    {
        ArrayList<Dino> filteredlist = new ArrayList<>();
        for(Dino item:dinoList)
        {
            if(item.getName().toLowerCase().contains(text.toLowerCase()))
            {
                filteredlist.add(item);
            }
        }
        dAdapter.filterlist(filteredlist);
    }


    private void prepareDinoData() {

        int i=0;
        while(i<50) {
            dinoList.add(getInfo(i));
            i++;
        }
        dAdapter.notifyDataSetChanged();
    }

    private Dino getInfo(int id)
    {
        String name ="";
        String weight ="";
        String period ="";
        String dino_eat="";
        int eat = 1;
        int img = 1;
        Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
        cursor.moveToFirst();
        int i=0;
        while (i<id)
        {
            cursor.moveToNext();
            i++;
        }
        name= cursor.getString(1);
        weight=cursor.getString(2);
        period=cursor.getString(4);
        dino_eat = cursor.getString(3);
        switch(dino_eat)
        {
            case("м'ясо"):
                eat=1 ;
                break;
            case("вег"):
                eat=2 ;
                break;
            case("все"):
                eat=3 ;
                break;
        }
        img=cursor.getInt(5);
        cursor.close();
        Dino dino = new Dino(name, weight, period, eat, img);
        return dino;
    }

}