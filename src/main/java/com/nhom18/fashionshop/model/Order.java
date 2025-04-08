package com.nhom18.fashionshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String address;  // New field for address
    private String phone;   // New field for phone

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

}
