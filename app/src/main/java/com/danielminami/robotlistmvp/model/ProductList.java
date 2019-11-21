package com.danielminami.robotlistmvp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProductList {

    @SerializedName("products")
    private List<Product> products;

    /**
     * Retrieve the list of Products
     *
     * @return list of Products
     */
    public List<Product> getProducts() {
        return products;
    }

}
