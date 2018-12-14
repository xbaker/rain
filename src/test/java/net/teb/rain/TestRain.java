/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:36 AM.
 */

package net.teb.rain;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class TestRain {


    private List<User> data() {
        List<User> data = new ArrayList<>();
        data.add(new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption")));
        data.add(new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption")));
        data.add(new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption")));
        data.add(new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption")));
        data.add(new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption")));
        data.add(new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption")));
        return data;
    }

    @Test
    public void testCreation() {
        List<User> data = this.data();
        RainSheet<User> rainSheet = new RainSheet.RainSheetBuilder<User>()
                .target(User.class)
                .name("test")
                .insertDateInName(false)
                .rowContent(data)
                .build();

        WorkBookGenerator<User> workBookGenerator = new WorkBookGenerator<>(rainSheet);
        Workbook workbook = workBookGenerator.render();
        Assert.assertEquals(workbook.getSheetAt(0).getSheetName(), "test");
        rainSheet.toString();
    }
}
