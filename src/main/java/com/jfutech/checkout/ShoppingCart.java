package com.jfutech.checkout;

import java.util.List;

public class ShoppingCart {

    public String calculatePrice(List<String> items) {
        int totalPence = items.stream()
                .mapToInt(this::getPrice)
                .sum();
        return String.format("£%.2f", totalPence / 100.0);
    }

    private int getPrice(String item) {
        return switch (item) {
            case "Apple" -> 60;
            case "Orange" -> 25;
            default -> 0;
        };
    }
}
