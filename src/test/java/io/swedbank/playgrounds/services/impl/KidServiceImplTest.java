package io.swedbank.playgrounds.services.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.swedbank.playgrounds.domain.Equipment;
import io.swedbank.playgrounds.domain.Kid;
import io.swedbank.playgrounds.domain.PlaySite;
import io.swedbank.playgrounds.dto.KidDto;
import io.swedbank.playgrounds.repos.KidRepository;
import io.swedbank.playgrounds.repos.PlaySiteRepository;
import io.swedbank.playgrounds.services.UtilizationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {KidServiceImpl.class})
@ExtendWith(SpringExtension.class)
class KidServiceImplTest {
    @MockBean
    private KidRepository kidRepository;

    @Autowired
    private KidServiceImpl kidServiceImpl;

    @MockBean
    private PlaySiteRepository playSiteRepository;

    @MockBean
    private UtilizationService utilizationService;

    /**
     * Method under test: {@link KidServiceImpl#add(KidDto)}
     */
    @Test
    void testAdd() {
        PlaySite playSite = new PlaySite();
        playSite.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite.setEquipments(new ArrayList<>());
        playSite.setId(1L);
        playSite.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite.setName("Name");
        playSite.setTotalEquipmentCount(3);
        playSite.setTotalVisitors(1);
        playSite.setUtilization(1);
        playSite.setVisitors(1);
        when(playSiteRepository.findByName(Mockito.<String>any())).thenReturn(playSite);

        PlaySite playsite = new PlaySite();
        playsite.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playsite.setEquipments(new ArrayList<>());
        playsite.setId(1L);
        playsite.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playsite.setName("Name");
        playsite.setTotalEquipmentCount(3);
        playsite.setTotalVisitors(1);
        playsite.setUtilization(1);
        playsite.setVisitors(1);

        Kid kid = new Kid();
        kid.setAge(1);
        kid.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        kid.setId(1L);
        kid.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        kid.setName("Name");
        kid.setPlaysite(playsite);
        kid.setTicketNumber(1L);
        when(kidRepository.save(Mockito.<Kid>any())).thenReturn(kid);
        when(utilizationService.calculate(Mockito.<Integer>any(), Mockito.<Integer>any(), anyBoolean())).thenReturn(1);

        KidDto kidDto = new KidDto();
        kidDto.setAge(1);
        kidDto.setName("Name");
        kidDto.setPlaySiteName("Play Site Name");
        kidDto.setTicketNumber(1L);
        kidServiceImpl.add(kidDto);
        verify(playSiteRepository).findByName(Mockito.<String>any());
        verify(kidRepository).save(Mockito.<Kid>any());
        verify(utilizationService).calculate(Mockito.<Integer>any(), Mockito.<Integer>any(), anyBoolean());
    }

    /**
     * Method under test: {@link KidServiceImpl#remove(String, Long)}
     */
    @Test
    void testRemove() {
        PlaySite playSite = new PlaySite();
        playSite.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite.setEquipments(new ArrayList<>());
        playSite.setId(1L);
        playSite.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite.setName("Name");
        playSite.setTotalEquipmentCount(3);
        playSite.setTotalVisitors(1);
        playSite.setUtilization(1);
        playSite.setVisitors(1);
        Optional<PlaySite> ofResult = Optional.of(playSite);

        PlaySite playSite2 = new PlaySite();
        playSite2.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite2.setEquipments(new ArrayList<>());
        playSite2.setId(1L);
        playSite2.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite2.setName("Name");
        playSite2.setTotalEquipmentCount(3);
        playSite2.setTotalVisitors(1);
        playSite2.setUtilization(1);
        playSite2.setVisitors(1);
        when(playSiteRepository.save(Mockito.<PlaySite>any())).thenReturn(playSite2);
        when(playSiteRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        PlaySite playsite = new PlaySite();
        playsite.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playsite.setEquipments(new ArrayList<>());
        playsite.setId(1L);
        playsite.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playsite.setName("Name");
        playsite.setTotalEquipmentCount(3);
        playsite.setTotalVisitors(1);
        playsite.setUtilization(1);
        playsite.setVisitors(1);

        Kid kid = new Kid();
        kid.setAge(1);
        kid.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        kid.setId(1L);
        kid.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        kid.setName("Name");
        kid.setPlaysite(playsite);
        kid.setTicketNumber(1L);
        doNothing().when(kidRepository).deleteById(Mockito.<Long>any());
        when(kidRepository.findByNameAndTicketNumber(Mockito.<String>any(), Mockito.<Long>any())).thenReturn(kid);
        assertTrue(kidServiceImpl.remove("Name", 1L));
        verify(playSiteRepository).save(Mockito.<PlaySite>any());
        verify(playSiteRepository).findById(Mockito.<Long>any());
        verify(kidRepository).findByNameAndTicketNumber(Mockito.<String>any(), Mockito.<Long>any());
        verify(kidRepository).deleteById(Mockito.<Long>any());
    }

}

