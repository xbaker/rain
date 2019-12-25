/*
 * Tarik El Bannany  Copyright (c) 12/14/18 11:36 AM.
 */

package rain;

import net.xbaker.rain.MultipleRowSeparator;
import net.xbaker.rain.RainSheet;
import net.xbaker.rain.RainSheetBuilder;
import net.xbaker.rain.WorkBookGenerator;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TestRain {


    private List<User> data() {
        List<User> data = new ArrayList<>();
        User u = new User("tarik", "tarik2", "address", "tarik.elbannany@gmail.net",
                "0688559945", new City("city1", "descrtiption"), LocalDateTime.now());
        u.setCountry(new Country("SIDI BENNOUR"));
        data.add(u);

        User u1 = new User("amin", "said", "address", "email@gmail.net",
                "4512785946", new City("city2", "descrtiption2"), LocalDateTime.now());
        u1.setCountry(new Country("MAROC"));
        data.add(u1);

        data.add(new User("issam", "mohammed", "address address", "email2@gmail.net",
                "0688559945", new City("city3", "descrtiption5"), LocalDateTime.now()));

        data.add(new User("pierre", "rachid", "address5", "email5@gmail.net",
                "0559752156", new City("city5", "descrtiption5"), LocalDateTime.now()));
        return data;
    }

    @Test
    public void testCreation() throws IOException {
        List<User> data = this.data();

        RainSheet<User> rainSheet =  new RainSheetBuilder<User>()
                .target(User.class)
                .multipleRowSeparator(MultipleRowSeparator.SPACE)
                .name("test")
                .insertChildRowName(true)
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
