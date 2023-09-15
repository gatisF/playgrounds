package io.swedbank.playgrounds.services.impl;

import io.swedbank.playgrounds.domain.Equipment;
import io.swedbank.playgrounds.domain.PlaySite;
import io.swedbank.playgrounds.dto.PlaySiteDto;
import io.swedbank.playgrounds.dto.out.PlaySiteDtoOut;
import io.swedbank.playgrounds.repos.EquipmentRepository;
import io.swedbank.playgrounds.repos.PlaySiteRepository;
import io.swedbank.playgrounds.services.PlaySiteService;
import io.swedbank.playgrounds.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PlaySiteServiceImpl implements PlaySiteService {

    private final PlaySiteRepository repository;
    private final EquipmentRepository equipmentRepository;

    public PlaySiteServiceImpl(PlaySiteRepository repository, EquipmentRepository equipmentRepository) {
        this.repository = Objects.requireNonNull(repository);
        this.equipmentRepository = Objects.requireNonNull(equipmentRepository);
    }


    @Override
    @Transactional
    public void create(PlaySiteDto playSite) {
        repository.saveAndFlush(new PlaySite()
                .setName(playSite.getName())
                .setTotalVisitors(playSite.getTotalVisitors())
                .setTotalEquipmentCount(playSite.getTotalEquipmentCount()));
        PlaySite name = repository.findByName(playSite.getName());
        List<Equipment> equipmentList = Utils.createEquipmentList(playSite.getEquipmentList(), name);
        
        equipmentRepository.saveAll(equipmentList);
    }

    @Override
    @Transactional
    public List<PlaySiteDtoOut> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(playSite -> new PlaySiteDtoOut()
                        .setName(playSite.getName())
                        .setVisitors(playSite.getVisitors())
                        .setUtilization(playSite.getUtilization())
                        .setEquipmentList(Utils.createEquipmentEnumList(playSite.getEquipments())))
                .toList();
    }

    @Override
    @Transactional
    public Integer count() {
        return findAll().stream().map(PlaySiteDtoOut::getVisitors).flatMap(Stream::ofNullable).mapToInt(Integer::intValue).sum();
    }


}
