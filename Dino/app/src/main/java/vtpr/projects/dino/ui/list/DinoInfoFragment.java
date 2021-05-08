package vtpr.projects.dino.ui.list;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import vtpr.projects.dino.R;

public class DinoInfoFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dino);
        TextView name = findViewById(R.id.dino_name);

        int position=0;
        String dino_name = "";
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            dino_name=extras.getString("text");
        }
        name.setText(dino_name);
    }
}