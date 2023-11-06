package com.codewithsj.views;

import com.codewithsj.models.Order;
import com.codewithsj.models.User;
import com.codewithsj.utils.StringUtil;

import java.util.ArrayList;

import static com.codewithsj.utils.AppOutput.println;
import static com.codewithsj.utils.UserUtil.getLoggedInUser;

public class OrderPage {
    public void printOrders(ArrayList<Order> orders) {
        println(StringUtil.ORDER_MESSAGE);

        User user = getLoggedInUser();
        for(Order order:orders)
        {
            if(order.getUser().getId()==user.getId())
            {
                println(order.getId()+". " + order.getProduct().getProductName() +", "+ order.getDate() +", ₹."+order.getProduct().getPrice());
            }
        }
    }
}
