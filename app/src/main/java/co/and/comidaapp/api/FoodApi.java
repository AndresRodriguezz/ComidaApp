package co.and.comidaapp.api;

import co.and.comidaapp.modelo.Categories;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("categories.php")
    Call<Categories>getCategories();
}
