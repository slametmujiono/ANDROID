
package id.slamet_mujiono.covninfo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.slamet_mujiono.covninfo.model.WorldSummaryModel;
import id.slamet_mujiono.covninfo.service.ApiEndpoint;
import id.slamet_mujiono.covninfo.service.RetrofitServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WorldSummaryViewModel extends ViewModel {
    private final MutableLiveData<WorldSummaryModel> mutableLiveData = new MutableLiveData<>();

    public void setSummaryWorldData() {
        Retrofit retrofit = RetrofitServiceApi.getRetrofitService();
        ApiEndpoint apiEndpoint = retrofit.create(ApiEndpoint.class);
        Call<WorldSummaryModel> call = apiEndpoint.getSummaryWorld();
        call.enqueue(new Callback<WorldSummaryModel>() {
            @Override
            public void onResponse(Call<WorldSummaryModel> call, Response<WorldSummaryModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WorldSummaryModel> call, Throwable t) {

            }
        });


    }

    public LiveData<WorldSummaryModel> getSummaryWorldData() {
        return mutableLiveData;
    }
}
