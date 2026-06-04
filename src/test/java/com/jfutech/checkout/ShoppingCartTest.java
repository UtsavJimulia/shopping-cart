package com.jfutech.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void shouldReturnZeroForEmptyCart() {
        assertEquals("£0.00", shoppingCart.calculatePrice(List.of()));
    }

    @Test
    void shouldReturn60pForSingleApple() {
        assertEquals("£0.60", shoppingCart.calculatePrice(List.of("Apple")));
    }

    @Test
    void shouldReturn25pForSingleOrange() {
        assertEquals("£0.25", shoppingCart.calculatePrice(List.of("Orange")));
    }

    @Test
    void shouldCalculateMultipleItems() {
        assertEquals("£1.45", shoppingCart.calculatePrice(
                List.of("Apple", "Apple", "Orange", "Apple")));
    }

    @Test
    void shouldThrowExceptionForUnknownItem() {
        assertThrows(IllegalArgumentException.class,
                () -> shoppingCart.calculatePrice(List.of("Banana")));
    }

    @Test
    void shouldThrowExceptionForNullCart() {
        assertThrows(IllegalArgumentException.class,
                () -> shoppingCart.calculatePrice(null));
    }

    @Test
    void shouldApplyBogoOfferForApples() {
        assertEquals("£0.60", shoppingCart.calculatePrice(List.of("Apple", "Apple")));
    }

    @Test
    void shouldApply3For2OfferForOranges() {
        assertEquals("£0.50", shoppingCart.calculatePrice(
                List.of("Orange", "Orange", "Orange")));
    }

}
