package ua.epam.spring.hometask.domain;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Maksym_Mazurkevych on 4/22/2016.
 */
public interface DiscountStrategy {

    byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets);

}
