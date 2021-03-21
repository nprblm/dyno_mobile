package vtpr.projects.myapplication.ui.filter_fr;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FilterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FilterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Фільтр");
    }

    public LiveData<String> getText() {
        return mText;
    }
}