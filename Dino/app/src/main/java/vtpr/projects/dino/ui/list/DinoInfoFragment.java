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
        TextView weight = findViewById(R.id.dino_weight);
        TextView period = findViewById(R.id.dino_period);
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
        weight.setText("Вага: " + dino_weight + " кг");
        period.setText("Період: " + dino_period);
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
            case (15):
                img_dino.setImageResource(R.drawable.d15);
                break;
            case (16):
                img_dino.setImageResource(R.drawable.d16);
                break;
            case (17):
                img_dino.setImageResource(R.drawable.d17);
                break;
            case (18):
                img_dino.setImageResource(R.drawable.d18);
                break;
            case (19):
                img_dino.setImageResource(R.drawable.d19);
                break;
            case (20):
                img_dino.setImageResource(R.drawable.d20);
                break;
            case (21):
                img_dino.setImageResource(R.drawable.d21);
                break;
            case (22):
                img_dino.setImageResource(R.drawable.d22);
                break;
            case (23):
                img_dino.setImageResource(R.drawable.d23);
                break;
            case (24):
                img_dino.setImageResource(R.drawable.d24);
                break;
            case (25):
                img_dino.setImageResource(R.drawable.d25);
                break;
            case (26):
                img_dino.setImageResource(R.drawable.d26);
                break;
            case (27):
                img_dino.setImageResource(R.drawable.d27);
                break;
            case (28):
                img_dino.setImageResource(R.drawable.d28);
                break;
            case (29):
                img_dino.setImageResource(R.drawable.d29);
                break;
            case (30):
                img_dino.setImageResource(R.drawable.d30);
                break;
            case (31):
                img_dino.setImageResource(R.drawable.d31);
                break;
            case (32):
                img_dino.setImageResource(R.drawable.d32);
                break;
            case (33):
                img_dino.setImageResource(R.drawable.d33);
                break;
            case (34):
                img_dino.setImageResource(R.drawable.d34);
                break;
            case (35):
                img_dino.setImageResource(R.drawable.d35);
                break;
            case (36):
                img_dino.setImageResource(R.drawable.d36);
                break;
            case (37):
                img_dino.setImageResource(R.drawable.d37);
                break;
            case (38):
                img_dino.setImageResource(R.drawable.d38);
                break;
            case (39):
                img_dino.setImageResource(R.drawable.d39);
                break;
            case (40):
                img_dino.setImageResource(R.drawable.d40);
                break;
            case (41):
                img_dino.setImageResource(R.drawable.d41);
                break;
            case (42):
                img_dino.setImageResource(R.drawable.d42);
                break;
            case (43):
                img_dino.setImageResource(R.drawable.d43);
                break;
            case (44):
                img_dino.setImageResource(R.drawable.d44);
                break;
            case (45):
                img_dino.setImageResource(R.drawable.d45);
                break;
            case (46):
                img_dino.setImageResource(R.drawable.d46);
                break;
            case (47):
                img_dino.setImageResource(R.drawable.d47);
                break;
            case (48):
                img_dino.setImageResource(R.drawable.d48);
                break;
            case (49):
                img_dino.setImageResource(R.drawable.d49);
                break;
             case (50):
                img_dino.setImageResource(R.drawable.d50);
                 break;
        }

    }
}