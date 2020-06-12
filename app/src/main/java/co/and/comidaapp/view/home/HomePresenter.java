package co.and.comidaapp.view.home;

import co.and.comidaapp.Utils;
import co.and.comidaapp.adapter.RecyclerViewHomeAdapter;
import co.and.comidaapp.api.FoodApi;
import co.and.comidaapp.api.FoodClient;
import co.and.comidaapp.modelo.Categories;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getCategories(){
        view.showLoading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();

        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() != null){
                    view.setCategory(response.body().getCategories());
                } else{
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());

            }
        });
    }
}
