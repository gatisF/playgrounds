package io.swedbank.playgrounds.repos;

import io.swedbank.playgrounds.domain.PlaySite;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaySiteRepository extends JpaRepository<PlaySite, Long> {
    PlaySite findByName(String name);
}
