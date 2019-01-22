/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:36 AM.
 */

package net.xfantome.rain;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Test
public class TestRain {


    private List<User> data() {
        List<User> data = new ArrayList<>();
        User u = new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption"));
        u.setCountryName("c1");
        data.add(u);

        User u1 = new User("amin", "said", "address", "email@gmail.net",
                "4512785946", new City("city2", "descrtiption2"));
        u1.setCountryName("c2");
        data.add(u1);

        data.add(new User("issam", "mohammed", "address address", "email2@gmail.net",
                "0688559945", new City("city3", "descrtiption5")));

        data.add(new User("pierre", "rachid", "address5", "email5@gmail.net",
                "0559752156", new City("city5", "descrtiption5")));
        return data;
    }

    @Test
    public void testCreation() throws IOException {
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

        FileOutputStream out = new FileOutputStream("example.xls");
        workbook.write(out);
        out.close();

    }
}
