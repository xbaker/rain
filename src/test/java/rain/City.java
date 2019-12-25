/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:33 AM.
 */

package rain;

public class City {
    private String label;
    private String description;

    public City(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
