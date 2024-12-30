package pl.springacademy.sptest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("Plus")
public class ShopPlus {

    @Value("{$prod.vat.tax}")
    private int vatTax;

    private ShopStart shopStart;

    public float getGrossCart() {
        List<Float> netCart = shopStart.getProductsPrices();
        int cartSum = 0;
        for (Float product : netCart) {
            cartSum += product;
        }
        return (float) (cartSum * vatTax);
    }
}
