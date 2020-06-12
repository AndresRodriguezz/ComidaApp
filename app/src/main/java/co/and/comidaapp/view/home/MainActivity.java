package co.and.comidaapp.view.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.and.comidaapp.R;
import co.and.comidaapp.Utils;
import co.and.comidaapp.adapter.RecyclerViewHomeAdapter;
import co.and.comidaapp.modelo.Categories;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeView {
    RecyclerView recyclerViewCategory;

    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory = (RecyclerView)findViewById(R.id.recyclerCategory);

        presenter = new HomePresenter(this);
        presenter.getCategories();
    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);
    }

    @Override
    public void setCategory(List<Categories.Category> category) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(category, this);
        recyclerViewCategory.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3,
        GridLayoutManager.VERTICAL,false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onErrorLoading(String massage) {
        Utils.showDialogMessage(this,"Title",massage);

    }
}
