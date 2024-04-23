package com.ziafat_majeed.generalstore.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.ziafat_majeed.generalstore.data.Products;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM Products")
    List<Products> getAll();
    @Query("SELECT * FROM Products limit 500")
    LiveData<List<Products>> liveGetAll();

    @Query("SELECT * FROM Products where id=:ProductsId")
    Products getProductsById(int ProductsId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOrReplace(Products Products);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceAll(List<Products> Productss);

    @Delete
    void delete(Products blogPost);

    @Update
    void update(Products blogPost);

    @Query("DELETE FROM Products")
    void deleteAll();

}
