package io.swedbank.playgrounds.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.swedbank.playgrounds.domain.PlaySite;
import io.swedbank.playgrounds.dto.PlaySiteDto;
import io.swedbank.playgrounds.dto.out.PlaySiteDtoOut;
import io.swedbank.playgrounds.repos.EquipmentRepository;
import io.swedbank.playgrounds.repos.PlaySiteRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlaySiteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PlaySiteServiceImplTest {
    @MockBean
    private EquipmentRepository equipmentRepository;

    @MockBean
    private PlaySiteRepository playSiteRepository;

    @Autowired
    private PlaySiteServiceImpl playSiteServiceImpl;

    /**
     * Method under test: {@link PlaySiteServiceImpl#create(PlaySiteDto)}
     */
    @Test
    void testCreate() {
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
        when(playSiteRepository.findByName(Mockito.<String>any())).thenReturn(playSite);
        when(playSiteRepository.saveAndFlush(Mockito.<PlaySite>any())).thenReturn(playSite2);
        when(equipmentRepository.saveAll(Mockito.<Iterable<io.swedbank.playgrounds.domain.Equipment>>any()))
                .thenReturn(new ArrayList<>());

        PlaySiteDto playSite3 = new PlaySiteDto();
        playSite3.setEquipmentList(new ArrayList<>());
        playSite3.setName("Name");
        playSite3.setTotalEquipmentCount(3);
        playSite3.setTotalVisitors(1);
        playSiteServiceImpl.create(playSite3);
        verify(playSiteRepository).findByName(Mockito.<String>any());
        verify(playSiteRepository).saveAndFlush(Mockito.<PlaySite>any());
        verify(equipmentRepository).saveAll(Mockito.<Iterable<io.swedbank.playgrounds.domain.Equipment>>any());
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#create(PlaySiteDto)}
     */
    @Test
    void testCreate2() {
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
        when(playSiteRepository.findByName(Mockito.<String>any())).thenReturn(playSite);
        when(playSiteRepository.saveAndFlush(Mockito.<PlaySite>any())).thenReturn(playSite2);
        when(equipmentRepository.saveAll(Mockito.<Iterable<io.swedbank.playgrounds.domain.Equipment>>any()))
                .thenReturn(new ArrayList<>());

        ArrayList<io.swedbank.playgrounds.enums.Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(io.swedbank.playgrounds.enums.Equipment.DOUBLE_SWINGS);

        PlaySiteDto playSite3 = new PlaySiteDto();
        playSite3.setEquipmentList(equipmentList);
        playSite3.setName("Name");
        playSite3.setTotalEquipmentCount(3);
        playSite3.setTotalVisitors(1);
        playSiteServiceImpl.create(playSite3);
        verify(playSiteRepository).findByName(Mockito.<String>any());
        verify(playSiteRepository).saveAndFlush(Mockito.<PlaySite>any());
        verify(equipmentRepository).saveAll(Mockito.<Iterable<io.swedbank.playgrounds.domain.Equipment>>any());
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#create(PlaySiteDto)}
     */
    @Test
    void testCreate3() {
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
        when(playSiteRepository.findByName(Mockito.<String>any())).thenReturn(playSite);
        when(playSiteRepository.saveAndFlush(Mockito.<PlaySite>any())).thenReturn(playSite2);
        when(equipmentRepository.saveAll(Mockito.<Iterable<io.swedbank.playgrounds.domain.Equipment>>any()))
                .thenReturn(new ArrayList<>());

        ArrayList<io.swedbank.playgrounds.enums.Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(io.swedbank.playgrounds.enums.Equipment.CAROUSEL);
        equipmentList.add(io.swedbank.playgrounds.enums.Equipment.DOUBLE_SWINGS);

        PlaySiteDto playSite3 = new PlaySiteDto();
        playSite3.setEquipmentList(equipmentList);
        playSite3.setName("Name");
        playSite3.setTotalEquipmentCount(3);
        playSite3.setTotalVisitors(1);
        playSiteServiceImpl.create(playSite3);
        verify(playSiteRepository).findByName(Mockito.<String>any());
        verify(playSiteRepository).saveAndFlush(Mockito.<PlaySite>any());
        verify(equipmentRepository).saveAll(Mockito.<Iterable<io.swedbank.playgrounds.domain.Equipment>>any());
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#findAll()}
     */
    @Test
    void testFindAll() {
        when(playSiteRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(playSiteServiceImpl.findAll().isEmpty());
        verify(playSiteRepository).findAll();
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#findAll()}
     */
    @Test
    void testFindAll2() {
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

        ArrayList<PlaySite> playSiteList = new ArrayList<>();
        playSiteList.add(playSite);
        when(playSiteRepository.findAll()).thenReturn(playSiteList);
        List<PlaySiteDtoOut> actualFindAllResult = playSiteServiceImpl.findAll();
        assertEquals(1, actualFindAllResult.size());
        PlaySiteDtoOut getResult = actualFindAllResult.get(0);
        assertTrue(getResult.getEquipmentList().isEmpty());
        assertEquals(1, getResult.getVisitors().intValue());
        assertEquals(1, getResult.getUtilization().intValue());
        assertEquals("Name", getResult.getName());
        verify(playSiteRepository).findAll();
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#findAll()}
     */
    @Test
    void testFindAll3() {
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

        PlaySite playSite2 = new PlaySite();
        playSite2.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite2.setEquipments(new ArrayList<>());
        playSite2.setId(2L);
        playSite2.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite2.setName("Test");
        playSite2.setTotalEquipmentCount(1);
        playSite2.setTotalVisitors(0);
        playSite2.setUtilization(0);
        playSite2.setVisitors(0);

        ArrayList<PlaySite> playSiteList = new ArrayList<>();
        playSiteList.add(playSite2);
        playSiteList.add(playSite);
        when(playSiteRepository.findAll()).thenReturn(playSiteList);
        List<PlaySiteDtoOut> actualFindAllResult = playSiteServiceImpl.findAll();
        assertEquals(2, actualFindAllResult.size());
        PlaySiteDtoOut getResult = actualFindAllResult.get(0);
        assertEquals(0, getResult.getVisitors().intValue());
        PlaySiteDtoOut getResult2 = actualFindAllResult.get(1);
        assertEquals(1, getResult2.getVisitors().intValue());
        assertEquals(1, getResult2.getUtilization().intValue());
        assertEquals("Name", getResult2.getName());
        assertTrue(getResult2.getEquipmentList().isEmpty());
        assertEquals(0, getResult.getUtilization().intValue());
        assertEquals("Test", getResult.getName());
        assertTrue(getResult.getEquipmentList().isEmpty());
        verify(playSiteRepository).findAll();
    }


    /**
     * Method under test: {@link PlaySiteServiceImpl#count()}
     */
    @Test
    void testCount() {
        when(playSiteRepository.findAll()).thenReturn(new ArrayList<>());
        assertEquals(0, playSiteServiceImpl.count().intValue());
        verify(playSiteRepository).findAll();
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#count()}
     */
    @Test
    void testCount2() {
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

        ArrayList<PlaySite> playSiteList = new ArrayList<>();
        playSiteList.add(playSite);
        when(playSiteRepository.findAll()).thenReturn(playSiteList);
        assertEquals(1, playSiteServiceImpl.count().intValue());
        verify(playSiteRepository).findAll();
    }

    /**
     * Method under test: {@link PlaySiteServiceImpl#count()}
     */
    @Test
    void testCount3() {
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

        PlaySite playSite2 = new PlaySite();
        playSite2.setDateCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite2.setEquipments(new ArrayList<>());
        playSite2.setId(2L);
        playSite2.setLastUpdated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        playSite2.setName("Test");
        playSite2.setTotalEquipmentCount(1);
        playSite2.setTotalVisitors(3);
        playSite2.setUtilization(0);
        playSite2.setVisitors(2);

        ArrayList<PlaySite> playSiteList = new ArrayList<>();
        playSiteList.add(playSite2);
        playSiteList.add(playSite);
        when(playSiteRepository.findAll()).thenReturn(playSiteList);
        assertEquals(3, playSiteServiceImpl.count().intValue());
        verify(playSiteRepository).findAll();
    }
}

