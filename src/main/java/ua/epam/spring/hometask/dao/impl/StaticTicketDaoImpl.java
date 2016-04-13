package ua.epam.spring.hometask.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.TicketDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Maksym_Mazurkevych on 4/12/2016.
 */
@Component
public class StaticTicketDaoImpl implements TicketDao {

    private static Map<User, List<Ticket>> tickets = new HashMap<>();

    @Override
    public void saveTicket(Ticket ticket) {
        User user = ticket.getUser();
        List<Ticket> ticketList = StaticTicketDaoImpl.tickets.get(user);
        if (ticketList == null)
            ticketList = new ArrayList<>();
        ticketList.add(ticket);
        StaticTicketDaoImpl.tickets.put(user, ticketList);
    }

    @Override
    public List<Ticket> findTickets(User user) {
        return tickets.get(user);
    }

    @Override
    public List<Ticket> findAll() {
        return tickets.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return null;
    }

    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {
        return 0;
    }

    @Override
    public void bookTickets(Set<Ticket> tickets) {
    }


}
