package com.jfutech.checkout;

import java.util.List;

public class ShoppingCart {

    public String calculatePrice(List<String> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        int totalPence = items.stream()
                .mapToInt(this::getPrice)
                .sum();
        return formatPrice(totalPence);
    }

    private String formatPrice(int pence) {
        return String.format("£%.2f", pence / 100.0);
    }

    private int getPrice(String item) {
        return switch (item) {
            case "Apple" -> 60;
            case "Orange" -> 25;
            default -> throw new IllegalArgumentException("Unknown item: " + item);
        };
    }
}
