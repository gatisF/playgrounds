package io.swedbank.playgrounds.services;

import io.swedbank.playgrounds.dto.KidDto;

public interface KidService {

    void add(KidDto kidDto);
    boolean remove(String name, Long ticketNumber);
}
