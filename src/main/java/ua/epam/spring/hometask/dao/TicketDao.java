package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/12/2016.
 */
public interface TicketDao {

    void saveTicket(Ticket ticket);

    List<Ticket> findTickets(User user);

    List<Ticket> findAll();

    Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);

    double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats);

    void bookTickets(Set<Ticket> tickets);
}
