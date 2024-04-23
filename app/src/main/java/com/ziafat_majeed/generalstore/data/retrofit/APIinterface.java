package com.ziafat_majeed.generalstore.data.retrofit;


import com.ziafat_majeed.generalstore.data.Products;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIinterface {
    @GET("loadProducts.php")
    Call<List<Products>> loadProducts();

}