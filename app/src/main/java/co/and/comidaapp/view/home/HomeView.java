package co.and.comidaapp.view.home;

import java.util.List;

import co.and.comidaapp.modelo.Categories;
import co.and.comidaapp.modelo.Meals;

public interface HomeView {

    void showLoading();
    void hideLoading();
    void setCategory(List<Categories.Category>category);
    void onErrorLoading(String massage);
}
