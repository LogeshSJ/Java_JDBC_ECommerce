package com.codewithsj.views;

import com.codewithsj.models.Product;
import com.codewithsj.utils.StringUtil;

import java.util.ArrayList;

import static com.codewithsj.utils.AppOutput.println;

public class AdminProductPage {
    public void viewProducts(ArrayList<Product> products) {
        println(StringUtil.PRODUCT_MESSAGE);
        for (Product product : products) {

            println(product.getId() + ". " + product.getProductName() + ", ₹." + product.getPrice());

        }
    }

    public void productChoices() {
        println(StringUtil.ADMIN_PRODUCT_CHOICE);
    }
}
