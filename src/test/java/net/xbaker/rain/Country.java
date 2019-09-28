/*
 * Tarik El Bannany  Copyright (c) 1/22/19 1:15 PM.
 */

package net.xbaker.rain;

import lombok.Data;
import net.xbaker.rain.RainRow;

@Data
public class Country {
    @RainRow(name = "country Name")
    private String countryName;
}
