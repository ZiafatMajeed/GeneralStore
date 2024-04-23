package com.ziafat_majeed.generalstore.data;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ziafat_majeed.generalstore.R;
import com.ziafat_majeed.generalstore.data.Adapters.itemAdapter;
import com.ziafat_majeed.generalstore.data.Adapters.itemAdapter;
import com.ziafat_majeed.generalstore.data.Products;
import com.ziafat_majeed.generalstore.data.retrofit.APIClient;
import com.ziafat_majeed.generalstore.data.retrofit.APIinterface;
import com.ziafat_majeed.generalstore.data.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    itemAdapter adapter;
    List<Products> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new itemAdapter(this, data);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        refresh();

        APIinterface apiInterface = APIClient.getClient().create(APIinterface.class);
        Call<List<Products>> call1 = apiInterface.loadProducts();
        call1.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (response.code() == 200) {
                    List<Products> products = response.body();
                    AppDatabase.getDatabase(MainActivity.this).productDao().deleteAll();
                    AppDatabase.getDatabase(MainActivity.this).productDao().insertOrReplaceAll(products);
                    Toast.makeText(MainActivity.this, "Success: "+products.size(), Toast.LENGTH_SHORT).show();
                    refresh();
                } else {
                    Toast.makeText(MainActivity.this, "Error: "+response.message(), Toast.LENGTH_SHORT).show();
                };

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void refresh(){
        data.clear();
        data.addAll(AppDatabase.getDatabase(this).productDao().getAll());
        adapter.notifyDataSetChanged();
    }

}