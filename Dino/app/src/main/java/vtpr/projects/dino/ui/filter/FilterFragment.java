package vtpr.projects.dino.ui.filter;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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
import vtpr.projects.dino.ui.list.Dino;
import vtpr.projects.dino.ui.list.DinoInfoFragment;


public class FilterFragment extends Fragment {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private static List<Dino> dinoList = new ArrayList<>();
    ArrayList<Dino> filteredlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private DinoAdapter dAdapter;
    private DinoAdapter.RecyclerViewClickListener listener;
    private String text_max, text_min;
    private float text_float_min = 0, text_float_max = 1000000;
    private Float weight_float;
    private int eat_int=0;
    private String period_string="Не обрано";
    public EditText editText_min;
    public EditText editText_max;
    private String[] data_eat = {"Не обрано","М'ясоїдні", "Рослиноїдні", "Всеядні"};
    private String[] data_period = {"Не обрано","Крейдовий", "Юрський", "Тріасовий"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_2, container,false);
        setOnClickListener();
        recyclerView = (RecyclerView) view.findViewById(R.id.rec_view);
        dinoList.clear();
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
        editText_min = (EditText) view.findViewById(R.id.search_min);
        editText_min.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    text_float_min = 0;
                }
                else
                {
                    text_min = s.toString();
                    text_float_min = Float.parseFloat(text_min);
                }
                filter();
            }
        });

        editText_max = (EditText) view.findViewById(R.id.search_max);
        editText_max.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    text_float_max = 1000000;
                }
                else
                {
                    text_max = s.toString();
                    text_float_max = Float.parseFloat(text_max);
                }
                filter();
            }
        });

        ArrayAdapter<String> adapter_eat = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, data_eat);
        adapter_eat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_eat = view.findViewById(R.id.spinner_eat);
        spinner_eat.setAdapter(adapter_eat);
        spinner_eat.setSelection(0);
        spinner_eat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                eat_select(position);
                filter();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        ArrayAdapter<String> adapter_period = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, data_period);
        adapter_period.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_period = view.findViewById(R.id.spinner_period);
        spinner_period.setAdapter(adapter_period);
        spinner_period.setSelection(0);
        spinner_period.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                period_select(position);
                filter();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
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
                intent.putExtra("position", position);
                intent.putExtra("name", list.get(position).getName());
                intent.putExtra("weight", list.get(position).getWeight());
                intent.putExtra("period", list.get(position).getPeriod());
                intent.putExtra("eat", list.get(position).getEat());
                intent.putExtra("img", list.get(position).getImg());
                intent.putExtra("id", list.get(position).getId());
                startActivity(intent);
            }
        };
    }

    private void filter () {
        filteredlist.clear();
        for (Dino item : dinoList) {
            String weight = item.getWeight();
            Integer eat = item.getEat();
            String per = item.getPeriod();
            weight_float = Float.parseFloat(weight);
            if(eat_int==0)
            {
                eat=eat_int;
            }
            if(period_string.equals("Не обрано"))
            {
                per = period_string.toLowerCase();
            }
            if ((weight_float <= text_float_max) && (weight_float >= text_float_min) && (eat == eat_int) && (per.equals(period_string.toLowerCase()))) {
                filteredlist.add(item);
            }
            dAdapter.filterlist(filteredlist);
        }
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
            int dino_id = 0;
            Cursor cursor = mDb.rawQuery("SELECT * FROM dino ORDER BY dino_name", null);
            cursor.moveToFirst();
            int i=0;
            while (i<id)
            {
                cursor.moveToNext();
                i++;
            }
            dino_id =cursor.getInt(0);
            name = cursor.getString(1);
            weight = cursor.getString(2);
            period = cursor.getString(4);
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
            Dino dino = new Dino(name, weight, period, eat, img, dino_id);
            return dino;
        }

        private void eat_select(int eat_select)
        {
            eat_int=eat_select;
        }

        private void period_select(int period_select)
        {
            switch(period_select)
            {
                case(0):
                    period_string="Не обрано";
                    break;
                case(1):
                    period_string="Крейдовий";
                    break;
                case(2):
                    period_string="Юрський";
                    break;
                case(3):
                    period_string="Тріасовий";
                    break;
            }

        }


    }
