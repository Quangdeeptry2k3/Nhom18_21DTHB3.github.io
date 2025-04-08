package com.nhom18.fashionshop.controller;

import com.nhom18.fashionshop.model.CartItem;
import com.nhom18.fashionshop.model.Order;
import com.nhom18.fashionshop.service.CartService;
import com.nhom18.fashionshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @GetMapping("/checkout")
    public String checkout() {
        return "cart/checkout";
    }

    @PostMapping("/submit")
    public String submitOrder(@RequestParam("customerName") String customerName,
                              @RequestParam("address") String address,
                              @RequestParam("phone") String phone) {
        List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart"; // Redirect if cart is empty
        }
        orderService.createOrder(customerName, address, phone, cartItems);
        return "redirect:/order/confirmation";
    }

    @GetMapping("/confirmation")
    public String orderConfirmation(Model model) {
        model.addAttribute("message", "Your order has been successfully placed.");
        return "cart/order-confirmation";
    }

//    @GetMapping("/history")
//    public String viewOrderHistory(Model model, Principal principal) {
//        String customerName = principal.getName(); // Assuming you use Spring Security and user names are unique
//        List<Order> orders = orderService.getOrdersByCustomerName(customerName);
//        model.addAttribute("orders", orders);
//        return "order-history";
//    }
    @GetMapping("/history")
    public String showOrderHistory(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders/order-history";
    }
}
