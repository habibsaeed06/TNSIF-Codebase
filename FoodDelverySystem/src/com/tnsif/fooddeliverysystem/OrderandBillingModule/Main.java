package com.tnsif.fooddeliverysystem.OrderandBillingModule;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // Simulate adding items
        orderService.addItemToOrder("Veg Biryani", 2, 150);
        orderService.addItemToOrder("Paneer Tikka", 1, 180);
        orderService.addItemToOrder("Cold Coffee", 2, 70);

        // Print final bill
        orderService.printFinalBill();
    }
}
