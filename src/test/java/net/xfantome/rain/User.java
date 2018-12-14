/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:32 AM.
 */

package net.xfantome.rain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @RainRow
    private String firstName;
    @RainRow(include = false)
    private String secondName;
    @RainRow
    private String address;
    @RainRow
    private String email;
    @RainRow(name = "PHONE")
    private String phone;
    @RainRow(child = {"label"})
    private City city;

}
