package ua.epam.spring.hometask.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.domain.*;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Maksym_Mazurkevych on 4/15/2016.
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    private DiscountStrategy temp;

    @Bean
    public DiscountStrategy birthdayDiscount()
    {
        return new BirthdayDiscount();
    }

    @Bean
    public DiscountStrategy tenthTicketDiscount()
    {
        return new TenthTicketDiscount();
    }

    @Bean
    public Random luckyRandom()
    {
        return new Random();
    }

    @Bean
    public List<DiscountStrategy> strategyList()
    {
        List<DiscountStrategy> strategies = new ArrayList<>();
        strategies.add( birthdayDiscount() );
        strategies.add( tenthTicketDiscount() );
        return strategies;
    }

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {

        for (int i=0; i<strategyList().size(); i ++){

            if(strategyList().get(i).getDiscount(user, event, airDateTime, numberOfTickets) > temp.getDiscount(user, event, airDateTime, numberOfTickets)) {
                temp = strategyList().get(i);
            }
        }

       return temp.getDiscount(user, event, airDateTime, numberOfTickets);
    }
}
