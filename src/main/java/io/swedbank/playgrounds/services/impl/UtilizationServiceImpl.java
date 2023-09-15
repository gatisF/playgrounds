package io.swedbank.playgrounds.services.impl;

import io.swedbank.playgrounds.services.UtilizationService;
import org.springframework.stereotype.Service;


@Service
public class UtilizationServiceImpl implements UtilizationService {
    @Override
    public Integer calculate(Integer totalVisitors, Integer visitor, boolean containsSwings) {
        if (containsSwings ) {
            if ((totalVisitors > visitor)) {
                return 0;
            }
            return 100;
        }
        return visitor / totalVisitors * 100;
    }
}
