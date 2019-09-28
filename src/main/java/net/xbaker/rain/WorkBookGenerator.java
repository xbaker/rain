/*
 * Tarik El Bannany  Copyright (c) 12/13/18 5:14 PM.
 */

package net.xbaker.rain;

import lombok.Getter;
import lombok.extern.java.Log;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

@Getter
@Log
public class WorkBookGenerator<T> {

    private CellStyle style;
    private List<Field> fields = new ArrayList<>();
    private RainSheet<T> rainSheet;
    private List<String> headers;
    private String name;
    private String creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh mm ss"));
    private XSSFWorkbook workbook;

    public WorkBookGenerator(RainSheet<T> rainSheet) {
        this.rainSheet = rainSheet;
        this.headers = new ArrayList<>();
        this.rowsName();
        this.name = sheetName();
        this.workbook = new XSSFWorkbook();
        this.rainSheet.setName(getName());
        this.style = RainTemplate.headerStyle(this.workbook, this.rainSheet);
    }

    private static String upperCaseFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private String sheetName() {
        if (rainSheet.isInsertDateInName()) {
            return this.creationDate + "_" + name();
        }
        return name();
    }

    private String name() {
        return rainSheet.getName() == null ? rainSheet.getTarget().getSimpleName() : rainSheet.getName();
    }

    public Workbook render() {
        Sheet sheet = createHeader(this.headers);
        Content(sheet);
        return workbook;
    }

    private Sheet createHeader(List<String> rowNames) {
        Sheet sheet = this.workbook.getSheetAt(0);
        Row header = sheet.createRow(0);
        for (int i = 0; i < rowNames.size(); i++) {
            header.createCell(i).setCellValue(rowNames.get(i));
            if (this.rainSheet.isHeaderStyleApplied()) {
                header.getCell(i).setCellStyle(style);
            }
        }
        return sheet;
    }

    private void supperClassFields(Class clazz) {
        if (clazz.getSuperclass() == null) {
            return;
        }
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        supperClassFields(clazz.getSuperclass());
    }

    private List<String> rowsName() {
        fields.addAll(Arrays.asList(this.rainSheet.getTarget().getDeclaredFields()));
        supperClassFields(this.rainSheet.getTarget().getSuperclass());
        for (Field field : fields) {
            RainRow rowName = field.getAnnotation(RainRow.class);
            if (rowName != null && rowName.include()) {
                String name = upperCaseFirstLetter(rowName.name().trim().equals("") ? field.getName() : rowName.name());
                headers.add(name);
            }
        }
        return headers;
    }

    private List<Field> itemField(Class clazz) {
        List<Field> f = new ArrayList<>();
        f.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Class superClass = clazz.getSuperclass();
        while (superClass != null) {
            f.addAll(Arrays.asList(superClass.getDeclaredFields()));
            superClass = superClass.getSuperclass();
        }
        return f;
    }

    private void Content(Sheet sheet) {
        int[] rowCount = new int[]{1};
        rowCount[0] = 1;
        this.rainSheet.getRowContent().stream().forEach((c) -> {
            try {
                Row row = sheet.createRow(rowCount[0]++);
                List<Field> fields = itemField(c.getClass());
                BeanInfo info = Introspector.getBeanInfo(c.getClass(), Object.class);
                PropertyDescriptor[] props = info.getPropertyDescriptors();
                int k = 0;
                for (Field field : fields) {
                    RainRow annotation = field.getAnnotation(RainRow.class);
                    field.setAccessible(true);
                    if (annotation != null && annotation.include()) {
                        Object value;
                        if (annotation.child().length > 0) {
                            value = child(annotation.child(), (T) c, props, field.getName());
                        } else {
                            value = getFiledValue((T) c, props, field.getName());
                        }
                        row.createCell(k).setCellValue(value != null ? convert(value, annotation) : "");
                        k++;
                    }
                }
            } catch (IntrospectionException e) {
                log.info(e.getMessage());
            }
        });
    }
    
    private String convert(Object value, RainRow annotation) {
    	if(value instanceof LocalDateTime) {
        	return ((LocalDateTime)value).format(DateTimeFormatter.ofPattern(annotation.dateTimeFormat()));
        }else {
        	return String.valueOf(value);
        }
    }

    private Object child(String[] childName, T c, PropertyDescriptor[] props, String fieldName) {
        Object value = getFiledValue(c, props, fieldName);
        if(value == null){
            return "";
        }
        Object result = "";
        try {
            BeanInfo info = Introspector.getBeanInfo(value.getClass(), Object.class);
            PropertyDescriptor[] pp = info.getPropertyDescriptors();
            for (String aChildName : childName) {
                String prefix = this.rainSheet.isInsertChildRowName() ? aChildName + " : " : "";
                result += prefix + getFiledValue((T) value, pp, aChildName) + this.rainSheet.getMultipleRowSeparator().getSeparator();
            }
        } catch (IntrospectionException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
        return result;
    }

    private Object getFiledValue(T c, PropertyDescriptor[] props, String fieldName) {
        Object value = null;
        try {
            for (PropertyDescriptor pd : props) {
                String name = pd.getName();
                if (name.equals(fieldName)) {
                    Method getter = pd.getReadMethod();
                    value = getter.invoke(c);
                    break;
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.info(e.getMessage());
        }
        return value;
    }
}
