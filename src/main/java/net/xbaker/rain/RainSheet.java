/*
 * Tarik El Bannany  Copyright (c) 12/13/18 3:59 PM.
 */

package net.xbaker.rain;

import com.sun.istack.internal.NotNull;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;

import java.io.Serializable;
import java.util.List;

public class RainSheet<T> implements Serializable {
    /**
     * Excel sheet name with default "Document"
     */
    private String name;
    /**
     * Cell font
     * with default font
     */
    private Font font;
    /**
     * Cell style
     */
    private CellStyle cellStyle;

    /**
     * Cell style
     */

    private Boolean insertChildRowName;

    /**
     * Multiple Row Separator
     */
    private MultipleRowSeparator multipleRowSeparator ;
    /**
     * sheet working index
     * with default true
     */

    private Integer sheetIndex;

    /**
     * Insert date in name
     * with default true
     */

    private Boolean insertDateInName;
    /**
     * Target class
     */
    @NotNull
    private Class target;
    /**
     * Target list class
     * list must be the same class of T
     */
    @NotNull
    private List<T> rowContent;
    /**
     * Header style
     * with default true
     */

    private Boolean headerStyleApplied;

    /**
     * @see org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined
     * with default HSSFColor.HSSFColorPredefined.DARK_GREEN.getIndex()
     */

    private Short foregroundColor;

    /**
     * indicate column width
     * with default 40
     */

    private Integer columnWidth;

    /**
     * header font color with default "Arial"
     */

    private String fontName;

    /**
     * font color
     *
     * @see org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined
     * with default HSSFColor.HSSFColorPredefined.WHITE.getIndex()
     */

    private Short fontColor;

    /**
     * Font header is bold
     * with default true
     */

    private Boolean fontBold;

    /**
     * fillPattern
     *
     * @see org.apache.poi.ss.usermodel.FillPatternType
     * with default FillPatternType.SOLID_FOREGROUND
     */

    private FillPatternType fillPatternType;

    protected RainSheet(String name, Font font, CellStyle cellStyle, Boolean insertChildRowName, MultipleRowSeparator multipleRowSeparator, Integer sheetIndex,
                        Boolean insertDateInName, @NotNull Class target, @NotNull List<T> rowContent,
                        Boolean headerStyleApplied, Short foregroundColor, Integer columnWidth, String fontName, Short fontColor, Boolean fontBold, FillPatternType fillPatternType) {
        if (target == null) {
            throw new NullPointerException("target is marked non-null but is null");
        } else if (rowContent == null) {
            throw new NullPointerException("rowContent is marked non-null but is null");
        } else {
            this.name = name;
            this.font = font;
            this.cellStyle = cellStyle;
            this.insertChildRowName = insertChildRowName;
            this.multipleRowSeparator = multipleRowSeparator;
            this.sheetIndex = sheetIndex;
            this.insertDateInName = insertDateInName;
            this.target = target;
            this.rowContent = rowContent;
            this.headerStyleApplied = headerStyleApplied;
            this.foregroundColor = foregroundColor;
            this.columnWidth = columnWidth;
            this.fontName = fontName;
            this.fontColor = fontColor;
            this.fontBold = fontBold;
            this.fillPatternType = fillPatternType;

            if(multipleRowSeparator == null){
                this.multipleRowSeparator  = MultipleRowSeparator.COMMA;
            }

            if(fillPatternType == null){
                this.fillPatternType =  FillPatternType.SOLID_FOREGROUND;
            }
            if(fontBold == null){
                this.fontBold = true;
            }

            if(fontColor == null){
                this.fontColor =  HSSFColor.HSSFColorPredefined.WHITE.getIndex();
            }

            if(fontName == null){
                this.fontName = "Arial";
            }

            if(columnWidth == null){
                this.columnWidth = 40;
            }

            if(foregroundColor == null){
                this.foregroundColor = HSSFColor.HSSFColorPredefined.DARK_GREEN.getIndex();
            }

            if(headerStyleApplied == null){
                this.headerStyleApplied = true;
            }

            if(insertDateInName == null){
                this.insertDateInName = true;
            }

            if(sheetIndex == null){
                this.sheetIndex = 0;
            }

            if(insertChildRowName == null){
                this.insertChildRowName = true;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Font getFont() {
        return this.font;
    }

    public CellStyle getCellStyle() {
        return this.cellStyle;
    }

    public Boolean isInsertChildRowName() {
        return this.insertChildRowName;
    }

    public MultipleRowSeparator getMultipleRowSeparator() {
        return this.multipleRowSeparator;
    }

    public Integer getSheetIndex() {
        return this.sheetIndex;
    }

    public Boolean isInsertDateInName() {
        return this.insertDateInName;
    }

    @NotNull
    public Class getTarget() {
        return this.target;
    }

    @NotNull
    public List<T> getRowContent() {
        return this.rowContent;
    }

    public Boolean isHeaderStyleApplied() {
        return this.headerStyleApplied;
    }

    public Short getForegroundColor() {
        return this.foregroundColor;
    }

    public Integer getColumnWidth() {
        return this.columnWidth;
    }

    public String getFontName() {
        return this.fontName;
    }

    public Short getFontColor() {
        return this.fontColor;
    }

    public Boolean isFontBold() {
        return this.fontBold;
    }

    public FillPatternType getFillPatternType() {
        return this.fillPatternType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setCellStyle(CellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public void setInsertChildRowName(Boolean insertChildRowName) {
        this.insertChildRowName = insertChildRowName;
    }

    public void setMultipleRowSeparator(MultipleRowSeparator multipleRowSeparator) {
        this.multipleRowSeparator = multipleRowSeparator;
    }

    public void setSheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public void setInsertDateInName(Boolean insertDateInName) {
        this.insertDateInName = insertDateInName;
    }

    public void setTarget(@NotNull Class target) {
        if (target == null) {
            throw new NullPointerException("target is marked non-null but is null");
        } else {
            this.target = target;
        }
    }

    public void setRowContent(@NotNull List<T> rowContent) {
        if (rowContent == null) {
            throw new NullPointerException("rowContent is marked non-null but is null");
        } else {
            this.rowContent = rowContent;
        }
    }

    public void setHeaderStyleApplied(Boolean headerStyleApplied) {
        this.headerStyleApplied = headerStyleApplied;
    }

    public void setForegroundColor(Short foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontColor(Short fontColor) {
        this.fontColor = fontColor;
    }

    public void setFontBold(Boolean fontBold) {
        this.fontBold = fontBold;
    }

    public void setFillPatternType(FillPatternType fillPatternType) {
        this.fillPatternType = fillPatternType;
    }



    @Override
    public String toString() {
        return "RainSheet{" +
                "name='" + name + '\'' +
                ", font=" + font +
                ", cellStyle=" + cellStyle +
                ", insertChildRowName=" + insertChildRowName +
                ", multipleRowSeparator=" + multipleRowSeparator +
                ", sheetIndex=" + sheetIndex +
                ", insertDateInName=" + insertDateInName +
                ", target=" + target +
                ", rowContent=" + rowContent +
                ", headerStyleApplied=" + headerStyleApplied +
                ", foregroundColor=" + foregroundColor +
                ", columnWidth=" + columnWidth +
                ", fontName='" + fontName + '\'' +
                ", fontColor=" + fontColor +
                ", fontBold=" + fontBold +
                ", fillPatternType=" + fillPatternType +
                '}';
    }
}
