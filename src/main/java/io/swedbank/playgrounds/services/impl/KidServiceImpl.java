package io.swedbank.playgrounds.services.impl;

import io.swedbank.playgrounds.domain.Equipment;
import io.swedbank.playgrounds.domain.Kid;
import io.swedbank.playgrounds.domain.PlaySite;
import io.swedbank.playgrounds.dto.KidDto;
import io.swedbank.playgrounds.repos.KidRepository;
import io.swedbank.playgrounds.repos.PlaySiteRepository;
import io.swedbank.playgrounds.services.KidService;
import io.swedbank.playgrounds.services.UtilizationService;
import io.swedbank.playgrounds.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class KidServiceImpl implements KidService {

    private final PlaySiteRepository playSiteRepository;
    private final KidRepository kidRepository;

    private final UtilizationService utilizationService;

    public KidServiceImpl(PlaySiteRepository playSiteRepository, KidRepository kidRepository,
                          UtilizationService utilizationService) {
        this.playSiteRepository = Objects.requireNonNull(playSiteRepository);
        this.kidRepository = Objects.requireNonNull(kidRepository);
        this.utilizationService = Objects.requireNonNull(utilizationService);
    }

    @Override
    @Transactional
    public void add(KidDto kidDto) {
        PlaySite playSite = playSiteRepository.findByName(kidDto.getPlaySiteName());
        List<Equipment> equipments = playSite.getEquipments();
        playSite.setVisitors(playSite.getVisitors() + 1);
        playSite.setUtilization((utilizationService.calculate(playSite.getVisitors(), playSite.getUtilization(),
                Utils.createEquipmentEnumList(equipments).stream().anyMatch(e -> e.equals(io.swedbank.playgrounds.enums.Equipment.DOUBLE_SWINGS)))));
        kidRepository.save(new Kid()
                .setName(kidDto.getName())
                .setAge(kidDto.getAge())
                .setTicketNumber(kidDto.getTicketNumber()))
                .setPlaysite(playSite);

    }

    @Override
    @Transactional
    public boolean remove(String name, Long ticketNumber) {
        Kid kid = kidRepository.findByNameAndTicketNumber(name, ticketNumber);
        if (Objects.nonNull(kid)) {
            PlaySite playSite = playSiteRepository.findById(kid.getPlaysite().getId()).get();
            playSite.setVisitors(playSite.getVisitors() - 1);
            playSiteRepository.save(playSite);
            kidRepository.deleteById(kid.getId());
            return true;
        }
        return false;
//        return kidRepository.deleteByNameAndTicketNumber(name, ticketNumber) == 1;
    }
}
