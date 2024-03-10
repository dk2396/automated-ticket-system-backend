package com.app.delivery.tracking.services;




import com.app.delivery.tracking.Entity.DeliveryDetail;
import com.app.delivery.tracking.Entity.Ticket;
import com.app.delivery.tracking.repository.DeliveryDetailRepository;
import com.app.delivery.tracking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TicketService {
    private final String CUSTOMER_TYPE="VIP";
    private final String DELIVERY_DONE="DD";
    @Autowired
    private DeliveryDetailRepository deliveryDetailRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void checkDeliveriesAndCreateTickets() {
        List<DeliveryDetail> deliveries = deliveryDetailRepository.findAll();
        for (DeliveryDetail delivery : deliveries) {
            int priority = calculatePriority(delivery);
            if (priority > 0) { // Assuming priority 0 means no ticket needed
                Ticket ticket = new Ticket();
                ticket.setDeliveryId(delivery.getDeliveryId());
                ticket.setPriority(priority);
                ticket.setDescription("Auto-generated ticket");
                ticket.setCreatedTime(new Timestamp(System.currentTimeMillis()));
                ticketRepository.save(ticket);
            }
        }
    }

    private int calculatePriority(DeliveryDetail delivery) {
        int priority = 0;

        // VIP customers get higher priority
        if (CUSTOMER_TYPE.equals(delivery.getCustomerType()) && !DELIVERY_DONE.equals(delivery.getDeliveryStatus())) {
            priority += 10;
        }

        // Orders not delivered by the expected time get higher priority
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (delivery.getExpectedDeliveryTime().before(now) && !DELIVERY_DONE.equals(delivery.getDeliveryStatus())) {
            priority += 5;
        }

        // Calculate the estimated time of delivery and compare
        // Assuming we have access to 'meanTimeToPrepareFood' in minutes (this field might need to be added or calculated)
        long meanTimeToPrepareFood = 20; // This should be dynamically determined based on actual data
        long estimatedTimeInMinutes = meanTimeToPrepareFood + (delivery.getTimeToReachDestination().getTime() - now.getTime()) / (60 * 1000);

        long expectedTimeInMinutes = (delivery.getExpectedDeliveryTime().getTime() - now.getTime()) / (60 * 1000);
        if (estimatedTimeInMinutes > expectedTimeInMinutes && !DELIVERY_DONE.equals(delivery.getDeliveryStatus())) {
            priority += 5;
        }

        // Further customizations can be added here based on other business rules

        return priority;
    }
}

