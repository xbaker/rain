/*
 * Tarik El Bannany  Copyright (c) 1/22/19 1:15 PM.
 */

package rain;

import net.xbaker.rain.RainRow;

public class Country {
    @RainRow(name = "country Name")
    private String countryName;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
