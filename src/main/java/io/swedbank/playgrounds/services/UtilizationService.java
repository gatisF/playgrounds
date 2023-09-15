package io.swedbank.playgrounds.services;

public interface UtilizationService {

    Integer calculate(Integer totalVisitors, Integer visitor, boolean containsSwings);
}
