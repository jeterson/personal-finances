package com.jmg.personal.finances.common.domain.valueobject;

import java.util.Arrays;

public enum Color {

    //White
    WHITE("#FFF"),

    //Purple
    PURPLE_1("#FFF")
    ;

    private String colorHex;
    Color(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getColorHex() {
        return colorHex;
    }
    public static Color of(String colorHex) {
        var colors = Arrays.stream(Color.values()).toList();
        var colorOptional = colors.stream().filter(c -> c.getColorHex().equals(colorHex)).findFirst();

        if(colorOptional.isPresent())
            return colorOptional.get();
        else
            return Color.WHITE;
    }
}
