package io.swedbank.playgrounds.repos;

import io.swedbank.playgrounds.domain.Kid;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KidRepository extends JpaRepository<Kid, Long> {
    Integer deleteByNameAndTicketNumber(String name, Long ticketNumber);

    Kid findByNameAndTicketNumber(String name, Long ticketNumber);
}
