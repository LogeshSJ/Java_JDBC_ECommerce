package com.codewithsj.controllers;

import com.codewithsj.dao.CartDao;
import com.codewithsj.dao.OrderDao;
import com.codewithsj.models.Cart;
import com.codewithsj.models.Order;
import com.codewithsj.models.User;
import com.codewithsj.utils.AppException;
import com.codewithsj.utils.StringUtil;
import com.codewithsj.views.OrderPage;

import java.util.ArrayList;

import static com.codewithsj.utils.AppInput.enterInteger;
import static com.codewithsj.utils.AppOutput.println;
import static com.codewithsj.utils.UserUtil.getLoggedInUser;

public class OrderController {

    private final OrderPage orderPage;
    private final OrderDao orderDao;

    private final CartDao cartDao;

    private final HomeController homeController;

    public OrderController(HomeController homeController) {
        this.orderPage = new OrderPage();
        this.orderDao = new OrderDao();
        this.cartDao = new CartDao();
        this.homeController= homeController;
    }

    private static ArrayList<Cart> carts = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    public void orderedItems() {
        User user = getLoggedInUser();
        carts=orderDao.getUserCartItems(user.getId());
        orderDao.AddUserOrders(carts);
        cartDao.updateCart(user.getId());
        println(StringUtil.ORDER_SUCCESSFUL);
    }

    public void OrderedItemsList() {
        User user = getLoggedInUser();
        orders=orderDao.getOrders(user.getId());
        if(!orders.isEmpty())
        {
            orderPage.printOrders(orders);
            println(StringUtil.BACK);
            int choice;
            try {
                choice = enterInteger(StringUtil.CHOICE);
                if (choice == 100) {
                    homeController.printMenu();
                } else {
                    invalidException(new AppException(StringUtil.INVALID_CHOICE));
                }
            } catch (AppException e) {
                invalidException(e);
            }
        }
        else
        {
            println(StringUtil.ORDER_EMPTY);
            homeController.printMenu();
        }

    }
    private void invalidException(AppException e) {
        println(e.getMessage());
        OrderedItemsList();
    }
}
