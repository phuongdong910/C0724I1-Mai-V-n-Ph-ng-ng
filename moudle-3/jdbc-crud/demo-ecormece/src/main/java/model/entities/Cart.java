package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public Cart() {}

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    public void addItem(CartItem item) { this.items.add(item); }

    public void removeItem(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getProduct().getPrice().doubleValue() * item.getQuantity()).sum();
    }
}


