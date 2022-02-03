package com.apidimed.backend.repositories;

import com.apidimed.backend.models.BusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<BusModel, Long> {
}
