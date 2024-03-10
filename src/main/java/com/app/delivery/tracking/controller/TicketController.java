package com.app.delivery.tracking.controller;




import com.app.delivery.tracking.Entity.Ticket;
import com.app.delivery.tracking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tickets")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/priority")
    public List<Ticket> getTicketsByPriority() {
        return ticketRepository.findAllByOrderByPriorityDesc();
    }
}

