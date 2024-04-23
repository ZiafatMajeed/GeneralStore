package com.ziafat_majeed.generalstore.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Products {
	private int maxQtyInRoom;
	private int HasExpiry;
	private int Price;
	private String name;
	@PrimaryKey
	private int id;
	private int orderr;
	private String barcode;
	private String picture;

	public int getMaxQtyInRoom() {
		return maxQtyInRoom;
	}

	public void setMaxQtyInRoom(int maxQtyInRoom) {
		this.maxQtyInRoom = maxQtyInRoom;
	}

	public int getHasExpiry() {
		return HasExpiry;
	}

	public void setHasExpiry(int hasExpiry) {
		HasExpiry = hasExpiry;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderr() {
		return orderr;
	}

	public void setOrderr(int orderr) {
		this.orderr = orderr;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
