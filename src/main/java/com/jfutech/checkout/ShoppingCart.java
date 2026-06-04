package com.jfutech.checkout;

import java.util.List;

public class ShoppingCart {

    public String calculatePrice(List<String> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        validateItems(items);
        long appleCount = items.stream().filter("Apple"::equals).count();
        long orangeCount = items.stream().filter("Orange"::equals).count();

        int appleOfferPrice = (int) (appleCount + 1) / 2;
        int orangeOfferPrice = (int) (orangeCount - (orangeCount / 3));

        int totalPence = appleOfferPrice * getPrice("Apple")
                + orangeOfferPrice * getPrice("Orange");
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

    private void validateItems(List<String> items) {
        items.forEach(item -> {
            if (!item.equals("Apple") && !item.equals("Orange")) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
        });
    }
}
