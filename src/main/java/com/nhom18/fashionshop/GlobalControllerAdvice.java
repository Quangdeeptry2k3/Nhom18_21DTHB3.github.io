package com.nhom18.fashionshop;

import com.nhom18.fashionshop.model.CartItem;
import com.nhom18.fashionshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private CartService cartService;

    @ModelAttribute("cartItems")
    public List<CartItem> cartItems() {
        return cartService.getCartItems();
    }

    @ModelAttribute("total")
    public double total() {
        return cartService.calculateTotalPrice();
    }
}
