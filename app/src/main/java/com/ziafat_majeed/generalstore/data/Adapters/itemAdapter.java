package com.ziafat_majeed.generalstore.data.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ziafat_majeed.generalstore.R;
import com.ziafat_majeed.generalstore.data.Products;
import com.ziafat_majeed.generalstore.data.ViewHolders.ItemViewHolder;
import com.ziafat_majeed.generalstore.databinding.SampleProductBinding;

import java.util.List;

 public class itemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    Context context;
    List<Products> data;

    public itemAdapter(Context context, List<Products> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SampleProductBinding binding;
        binding = SampleProductBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Products product = data.get(position);
        holder.binding.name.setText(product.getName());

        // Convert boolean to string
        holder.binding.expire.setText(product.getName());

        Picasso.get().load("http://192.168.137.1/FoodOrdering/images/" + product.getPicture())
                .placeholder(R.drawable.image5)
                .into(holder.binding.image);
    }


     @Override
    public int getItemCount() {
        return data.size();
    }
}
