package vtpr.projects.dino.ui.list;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
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
    private SearchView searchView;

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
        EditText editText = (EditText) view.findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            filter(s.toString());
            }
        });
        return view;
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
            Dino dino = new Dino(getName(i), getWeight(i), getPeriod(i), getEat(i), getImg(i));
            dinoList.add(dino);
            i++;
        }
        dAdapter.notifyDataSetChanged();
    }

    private String getName(int id)
    {
        String name ="";
        Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
        cursor.moveToFirst();
        int i=0;
        while (i<id)
        {
            cursor.moveToNext();
            i++;
        }
        name=cursor.getString(1);
        cursor.close();
        return name;
    }

    private String getWeight(int id)
    {
        String weight ="";
        Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
        cursor.moveToFirst();
        int i=0;
        while (i<id)
        {
            cursor.moveToNext();
            i++;
        }
        weight=cursor.getString(2);
        cursor.close();
        return weight;
    }

    private String getPeriod(int id)
    {
        String period ="";
        Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
        cursor.moveToFirst();
        int i=0;
        while (i<id)
        {
            cursor.moveToNext();
            i++;
        }
        period=cursor.getString(4);
        cursor.close();
        return period;
    }

    private int getEat(int id)
    {
        int eat = 1;
        String dino_eat ="";
        Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
        cursor.moveToFirst();
        int i=0;
        while (i<id)
        {
            cursor.moveToNext();
            i++;
        }
        dino_eat = cursor.getString(3);
       switch(dino_eat)
       {
           case("вег"):
               eat=1 ;
           break;
           case("м'ясо"):
               eat=2 ;
           break;
           case("все"):
               eat=3 ;
           break;
       }
        cursor.close();
        return eat;
    }
    private int getImg(int id)
    {
        int img = 1;
        Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
        cursor.moveToFirst();
        int i=0;
        while (i<id)
        {
            cursor.moveToNext();
            i++;
        }
        img=cursor.getInt(5);
        cursor.close();
        return img;
    }

}