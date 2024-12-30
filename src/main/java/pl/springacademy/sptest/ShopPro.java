package pl.springacademy.sptest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
public class ShopPro {

    @Value("${pro.client.discount}")
    private int discount;

    private ShopPlus shopPlus;

    public float getDiscountedPrice(){
        float discountedSum = shopPlus.getGrossCart()*discount;
        return discountedSum;
    }
}
