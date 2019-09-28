/*
 * Tarik El Bannany  Copyright (c) 1/22/19 4:40 PM.
 */

package net.xbaker.rain;

public enum MultipleRowSeparator {
    SPACE(" "),
    NOTHING(""),
    COMMA(" ; "),
    PIPE(" | ");

    private String separator;

    MultipleRowSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
