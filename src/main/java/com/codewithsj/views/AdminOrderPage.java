package com.codewithsj.views;

import com.codewithsj.models.Order;
import com.codewithsj.utils.StringUtil;

import java.util.ArrayList;

import static com.codewithsj.utils.AppOutput.println;

public class AdminOrderPage {
    public void viewOrders(ArrayList<Order> orders) {
        println(StringUtil.ORDER_MESSAGE);

        for (Order order : orders) {

            println(order.getId() + ". " + order.getProduct().getProductName() + ", "+"Ordered By: "+order.getUser().getEmail()+ ", " + order.getDate() + ", ₹." + order.getProduct().getPrice());

        }
    }
}
