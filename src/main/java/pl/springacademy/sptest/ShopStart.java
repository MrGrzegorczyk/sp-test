package pl.springacademy.sptest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
@Profile("Start")
public class ShopStart {

    private Random random = new Random();
    private Map<String, Float> cart = new HashMap<>();
    private Map<String, Float> products = new HashMap<>();

    public ShopStart() {
        // Initialize products map with random prices
        products.put("water", getRandomPrice(50, 300));
        products.put("ice", getRandomPrice(50, 300));
        products.put("cheese", getRandomPrice(50, 300));
        products.put("tea", getRandomPrice(50, 300));
        products.put("coffee", getRandomPrice(50, 300));
    }

    public List<Float> getProductsPrices() {
        return new LinkedList<>(products.values());
    }

    public void addToCart(String product, int quantity) {
        if (products.containsKey(product)) {
            float price = products.get(product);
            cart.put(product, cart.getOrDefault(product, 0f) + price * quantity);
            printTotalCartSum();
        } else {
            System.out.println("Product not available.");
        }
    }

    public void printTotalCartSum() {
        float totalSum = 0;
        for (Map.Entry<String, Float> entry : cart.entrySet()) {
            totalSum += entry.getValue();
        }
        System.out.println("Total sum of all products in the cart: " + totalSum);
    }

    private float getRandomPrice(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public Map<String, Float> getCart() {
        return cart;
    }
}

