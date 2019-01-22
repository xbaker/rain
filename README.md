# Rain
### Object to excel spreed sheet

This is an object-oriented java library for writing Microsoft Office Excel spreadsheets.
Based on apache POI library and the power of java reflexion.

#### mvn repo
```xml
<dependency>
  <groupId>net.xfantome</groupId>
  <artifactId>rain</artifactId>
  <version>1.0.4</version>
</dependency>
```
#### Create spreadsheet 
let's give the User.java class
```java
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
     
     // getters and setters
 
 }
```
City.java class
```java
// lombok way ;)
 @Data
 @RequiredArgsConstructor
 @AllArgsConstructor
 public class City {
     private String label;
     private String description;
 }
```    
Test example

```java
 public class MySpreadSheetRender {
     public MySpreadSheetRender() throws IOException {
          List<User> data = this.data();
           RainSheet<User> rainSheet = new RainSheet.RainSheetBuilder<User>()
                         .target(User.class)
                                         .multipleRowSeparator(MultipleRowSeparator.SPACE)
                                         .name("test")
                                         .insertChildRowName(true)
                                         .insertDateInName(false)
                                         .rowContent(data)
                                         .build();
         
           WorkBookGenerator<User> workBookGenerator = new WorkBookGenerator<>(rainSheet);
           Workbook workbook = workBookGenerator.render();
           FileOutputStream out = new FileOutputStream("example.xls");
                   workbook.write(out);
                   out.close();
     }
 }
```  
My test result
<img src="https://i.imgur.com/QjFE4aY.png"/>



