package net.tonimatasdev.sellchest.upgrade;

import java.util.HashMap;
import java.util.Map;

public enum Tier {
    BASIC,
    NORMAL,
    ADVANCED;

    private static final Map<String, Tier> BY_NAME = new HashMap<>();

    static {
        for (Tier tier : values()) {
            BY_NAME.put(tier.name(), tier);
        }
    }

    public static Tier getTier(String name){
        return BY_NAME.get(name);
    }
}
