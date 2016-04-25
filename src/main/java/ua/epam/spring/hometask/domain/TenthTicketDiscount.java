package ua.epam.spring.hometask.domain;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Maksym_Mazurkevych on 4/21/2016.
 */
public class TenthTicketDiscount implements DiscountStrategy {

    private static final byte DISCOUNT_PERCENT = 50;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {

        if ((user.getTickets().iterator().equals(10)) && (numberOfTickets >= 10))
            return DISCOUNT_PERCENT;
        else
            return 0;
    }
}
