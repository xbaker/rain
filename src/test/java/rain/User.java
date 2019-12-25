/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:32 AM.
 */

package rain;

import net.xbaker.rain.RainRow;

import java.time.LocalDateTime;
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
    @RainRow(child = {"label", "description"})
    private City city;

    @RainRow(dateTimeFormat = "dd/MM/yyyy")
    private LocalDateTime date;

    private Country country;

    public User(String firstName, String secondName, String address, String email, String phone, City city, LocalDateTime date) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.date = date;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
