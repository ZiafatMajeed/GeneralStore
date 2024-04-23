package com.ziafat_majeed.generalstore.data.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziafat_majeed.generalstore.R;
import com.ziafat_majeed.generalstore.databinding.SampleProductBinding;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    public SampleProductBinding binding;

    public ItemViewHolder(SampleProductBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
