package com.mc.grocery;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String itemName;
    private int quantity;

    @ManyToMany()
    private Set<Product>products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
