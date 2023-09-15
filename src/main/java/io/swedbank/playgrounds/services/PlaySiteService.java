package io.swedbank.playgrounds.services;

import io.swedbank.playgrounds.dto.PlaySiteDto;
import io.swedbank.playgrounds.dto.out.PlaySiteDtoOut;

import java.util.List;

public interface PlaySiteService {
    void create(PlaySiteDto playSiteDto);
    List<PlaySiteDtoOut> findAll();

    Integer count();
}
