package io.swedbank.playgrounds.utils;

import io.swedbank.playgrounds.domain.Equipment;
import io.swedbank.playgrounds.domain.PlaySite;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class Utils {

    public static List<Equipment> createEquipmentList(List<io.swedbank.playgrounds.enums.Equipment> equipmentList, PlaySite playSite) {
        List<Equipment> equipments = new ArrayList<>();
        equipmentList.forEach(equipment -> equipments.add(new Equipment()
                .setName(equipment.getName())
                .setPlaysite(playSite)));

        return equipments;
    }

    public static List<io.swedbank.playgrounds.enums.Equipment> createEquipmentEnumList(List<Equipment> equipmentList) {
        return StreamSupport.stream(equipmentList.spliterator(), false)
                .map(equipment -> io.swedbank.playgrounds.enums.Equipment.fromName(equipment.getName()))
                .toList();
    }

    private Utils() {
        throw new IllegalStateException("Utility class");
    }
}
