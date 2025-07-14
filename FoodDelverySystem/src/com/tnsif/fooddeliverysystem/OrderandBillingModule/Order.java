package com.tnsif.fooddeliverysystem.OrderandBillingModule;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private List<OrderItem> items;
    private double totalAmount;

    public Order() {
        this.orderId = UUID.randomUUID().toString().substring(0, 8); // short unique ID
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalAmount += item.getTotalPrice();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void generateReceipt() {
        System.out.println("🧾 Order Receipt - ID: " + orderId);
        for (OrderItem item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("---------------------------------");
        System.out.printf("Total Amount: ₹%.2f%n", totalAmount);
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}