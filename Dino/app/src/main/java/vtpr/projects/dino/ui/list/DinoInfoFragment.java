package vtpr.projects.dino.ui.list;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import vtpr.projects.dino.DinoAdapter;
import vtpr.projects.dino.R;

public class DinoInfoFragment extends AppCompatActivity {
    String dino_name="";
    String dino_weight="";
    String dino_period="";
    int dino_eat=0;
    int dino_img=0;
    int dino_id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dino);
        TextView name = findViewById(R.id.dino_name);
        ImageView img_dino = (ImageView) findViewById(R.id.dino_img);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            dino_name = extras.getString("name");
            dino_weight = extras.getString("weight");
            dino_period = extras.getString("period");
            dino_eat = extras.getInt("eat");
            dino_img = extras.getInt("img");
            dino_id = extras.getInt("id");
        }
        name.setText(dino_name);
        switch(dino_id) {
            case (1):
                img_dino.setImageResource(R.drawable.d1);
                break;
            case (2):
                img_dino.setImageResource(R.drawable.d2);
                break;
            case (3):
                img_dino.setImageResource(R.drawable.d3);
                break;
            case (4):
                img_dino.setImageResource(R.drawable.d4);
                break;
            case (5):
                img_dino.setImageResource(R.drawable.d5);
                break;
            case (6):
                img_dino.setImageResource(R.drawable.d6);
                break;
            case (7):
                img_dino.setImageResource(R.drawable.d7);
                break;
            case (8):
                img_dino.setImageResource(R.drawable.d8);
                break;
            case (9):
                img_dino.setImageResource(R.drawable.d9);
                break;
            case (10):
                img_dino.setImageResource(R.drawable.d10);
                break;
            case (11):
                img_dino.setImageResource(R.drawable.d11);
                break;
            case (12):
                img_dino.setImageResource(R.drawable.d12);
                break;
            case (13):
                img_dino.setImageResource(R.drawable.d13);
                break;
            case (14):
                img_dino.setImageResource(R.drawable.d14);
                break;
        }

    }
}