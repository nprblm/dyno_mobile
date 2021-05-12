package vtpr.projects.dino;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Site extends AppCompatActivity {
    private WebView web;
    private int position=0;
    private String site_url="https://google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            position = extras.getInt("position");
        }
        switch (position)
        {
            case(0):
                 site_url="https://uk.wikipedia.org/wiki/%D0%94%D0%B8%D0%BD%D0%BE%D0%B7%D0%B0%D0%B2%D1%80%D0%B8";
                break;
            case(1):
                 site_url="https://www.ukrinform.ua/tag-dinozavr";
                break;
            case(2):
                 site_url="https://discover.in.ua/dinosaurs/";
                break;
            case(3):
                 site_url="http://dinosaurs.afly.ru/";
                break;
            case(4):
                 site_url="https://www.ivi.ru/collections/movies-dinosaurs";
                break;
        }
        web = (WebView) findViewById(R.id.web_view);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl(site_url);
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack())
            web.goBack();
        else
            super.onBackPressed();
    }
}
