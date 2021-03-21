package vtpr.projects.myapplication.ui.home_fr;

import android.webkit.WebView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Головна");
    }

    public LiveData<String> getText() {
        return mText;
    }
}