package com.tnsif.fooddeliverysystem.OrderandBillingModule;

public class OrderService {
    private Order currentOrder;

    public OrderService() {
        this.currentOrder = new Order();
    }

    public void addItemToOrder(String itemName, int quantity, double price) {
        OrderItem item = new OrderItem(itemName, quantity, price);
        currentOrder.addItem(item);
    }

    public void printFinalBill() {
        currentOrder.generateReceipt();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
