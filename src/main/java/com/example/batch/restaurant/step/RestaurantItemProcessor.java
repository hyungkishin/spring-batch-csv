package com.example.batch.restaurant.step;

import com.example.batch.restaurant.dto.RestaurantDto;
import com.example.batch.restaurant.entity.Restaurant;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class RestaurantItemProcessor implements ItemProcessor<RestaurantDto, Restaurant> {

    @Override
    public Restaurant process(RestaurantDto item) {
        return item.toEntity();
    }

}