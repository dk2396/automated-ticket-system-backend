package com.app.delivery.tracking.repository;




import com.app.delivery.tracking.Entity.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail, Integer> {
}

