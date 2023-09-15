package io.swedbank.playgrounds.enums;

import java.util.Arrays;

public enum Equipment {

    DOUBLE_SWINGS("Double swings"),
    CAROUSEL("Carousel"),
    SLIDE("Slide"),
    BALL_PIT("Ball pit");

    private final String name;

    Equipment(String name) { this.name = name; }

    public String getName() { return name; }

    public static Equipment fromName(String name) {
        return Arrays.stream(Equipment.values())
                .filter(equipment -> equipment.getName().equals(name))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("No equipment with name '%s'", name)));
    }
}
