package com.app.delivery.tracking.config;

import com.app.delivery.tracking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduledTasks {

    @Autowired
    private TicketService ticketService;

    @Scheduled(fixedRate = 900000) // Example: run every minute
    public void checkAndGenerateTickets() {
        ticketService.checkDeliveriesAndCreateTickets();
    }
}

