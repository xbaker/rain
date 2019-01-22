/*
 * Tarik El Bannany  Copyright (c) 1/22/19 1:15 PM.
 */

package net.xfantome.rain;

import lombok.Data;

@Data
public class Country {
    @RainRow(name = "country Name")
    private String countryName;
}
