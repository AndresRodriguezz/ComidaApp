package co.and.comidaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.and.comidaapp.R;
import co.and.comidaapp.modelo.Categories;

public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.RecyclerViewHolder> {
    private List<Categories.Category> categories;
    private Context context;
    private static ClickListener clickListener;
    View view;

    public RecyclerViewHomeAdapter(List<Categories.Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerViewHomeAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category,parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHomeAdapter.RecyclerViewHolder holder, int position) {

        String strCategoryThum =categories.get(position).getStrCategoryThumb();
        Picasso.get()
                .load(strCategoryThum)
                .placeholder(R.drawable.ic_circle)
                .into(holder.categoryThumb);
        String strCategoryName = categories.get(position).getStrCategory();
        holder.categoryNames.setText(strCategoryName);

    }

    @Override
    public int getItemCount() {

        return categories.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView categoryThumb;
        TextView categoryNames;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryThumb = itemView.findViewById(R.id.categoryThumb);
            categoryNames = itemView.findViewById(R.id.categoryName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v,getAdapterPosition());

        }
    }
    public interface ClickListener {
        void onClick(View view, int position);
    }
}
