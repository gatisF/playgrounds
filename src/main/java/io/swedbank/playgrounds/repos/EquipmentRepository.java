package io.swedbank.playgrounds.repos;

import io.swedbank.playgrounds.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
