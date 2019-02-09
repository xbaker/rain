/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:32 AM.
 */

package net.xfantome.rain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User extends Country {

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
    @RainRow(child = {"label", "description"})
    private City city;

    @RainRow(dateTimeFormat = "dd/MM/yyyy")
    private LocalDateTime date;

}
