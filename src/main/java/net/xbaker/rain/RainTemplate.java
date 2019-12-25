/*
 * Tarik El Bannany  Copyright (c) 12/13/18 5:16 PM.
 */

package net.xbaker.rain;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class RainTemplate {

    protected RainTemplate(){}

    static CellStyle headerStyle(XSSFWorkbook workbook, RainSheet rainSheet) {
        Sheet sheet = workbook.createSheet(rainSheet.getName());

        sheet.setDefaultColumnWidth(rainSheet.getColumnWidth());

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName(rainSheet.getFontName());
        style.setFillForegroundColor(rainSheet.getForegroundColor());
        font.setColor(rainSheet.getFontColor());
        style.setFillPattern(rainSheet.getFillPatternType());
        font.setBold(rainSheet.isFontBold());
        style.setFont(font);
        return style;
    }
}
