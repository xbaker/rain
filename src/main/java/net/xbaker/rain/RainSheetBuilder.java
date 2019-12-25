package net.xbaker.rain;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;

import java.util.List;

public class RainSheetBuilder<T> {
    private String name;
    private Font font;
    private CellStyle cellStyle;
    private Boolean insertChildRowName;
    private MultipleRowSeparator multipleRowSeparator;
    private Integer sheetIndex;
    private Boolean insertDateInName;
    private Class target;
    private List<T> rowContent;
    private Boolean headerStyleApplied;
    private Short foregroundColor;
    private Integer columnWidth;
    private String fontName;
    private Short fontColor;
    private Boolean fontBold;
    private FillPatternType fillPatternType;

    public RainSheetBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RainSheetBuilder font(Font font) {
        this.font = font;
        return this;
    }

    public RainSheetBuilder cellStyle(CellStyle cellStyle) {
        this.cellStyle = cellStyle;
        return this;
    }

    public RainSheetBuilder insertChildRowName(Boolean insertChildRowName) {
        this.insertChildRowName = insertChildRowName;
        return this;
    }

    public RainSheetBuilder multipleRowSeparator(MultipleRowSeparator multipleRowSeparator) {
        this.multipleRowSeparator = multipleRowSeparator;
        return this;
    }

    public RainSheetBuilder sheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
        return this;
    }

    public RainSheetBuilder insertDateInName(Boolean insertDateInName) {
        this.insertDateInName = insertDateInName;
        return this;
    }

    public RainSheetBuilder target(Class target) {
        this.target = target;
        return this;
    }

    public RainSheetBuilder rowContent(List<T> rowContent) {
        this.rowContent = rowContent;
        return this;
    }

    public RainSheetBuilder headerStyleApplied(Boolean headerStyleApplied) {
        this.headerStyleApplied = headerStyleApplied;
        return this;
    }

    public RainSheetBuilder foregroundColor(Short foregroundColor) {
        this.foregroundColor = foregroundColor;
        return this;
    }

    public RainSheetBuilder columnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
        return this;
    }

    public RainSheetBuilder fontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    public RainSheetBuilder fontColor(Short fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    public RainSheetBuilder fontBold(Boolean fontBold) {
        this.fontBold = fontBold;
        return this;
    }

    public RainSheetBuilder fillPatternType(FillPatternType fillPatternType) {
        this.fillPatternType = fillPatternType;
        return this;
    }

    public RainSheet build() {
        return new RainSheet(name, font, cellStyle, insertChildRowName, multipleRowSeparator, sheetIndex, insertDateInName, target, rowContent, headerStyleApplied, foregroundColor, columnWidth, fontName, fontColor, fontBold, fillPatternType);
    }
}