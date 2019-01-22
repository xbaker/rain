/*
 * Tarik El Bannany  Copyright (c) 12/13/18 3:59 PM.
 */

package net.xfantome.rain;

import lombok.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
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
    private boolean insertChildRowName = true;

    /**
     * Multiple Row Separator
     */
    private MultipleRowSeparator multipleRowSeparator = MultipleRowSeparator.COMMA;
    /**
     * sheet working index
     * with default true
     */
    @Builder.Default
    private int sheetIndex = 0;

    /**
     * Insert date in name
     * with default true
     */
    @Builder.Default
    private boolean insertDateInName = true;
    /**
     * Target class
     */
    @NonNull
    private Class target;
    /**
     * Target list class
     * list must be the same class of T
     */
    @NonNull
    private List<T> rowContent;
    /**
     * Header style
     * with default true
     */
    @Builder.Default
    private boolean headerStyleApplied = true;

    /**
     * @see org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined
     * with default HSSFColor.HSSFColorPredefined.DARK_GREEN.getIndex()
     */
    @Builder.Default
    private short foregroundColor = HSSFColor.HSSFColorPredefined.DARK_GREEN.getIndex();

    /**
     * indicate column width
     * with default 40
     */
    @Builder.Default
    private int columnWidth = 40;

    /**
     * header font color with default "Arial"
     */
    @Builder.Default
    private String fontName = "Arial";

    /**
     * font color
     *
     * @see org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined
     * with default HSSFColor.HSSFColorPredefined.WHITE.getIndex()
     */
    @Builder.Default
    private short fontColor = HSSFColor.HSSFColorPredefined.WHITE.getIndex();

    /**
     * Font header is bold
     * with default true
     */
    @Builder.Default
    private boolean fontBold = true;

    /**
     * fillPattern
     *
     * @see org.apache.poi.ss.usermodel.FillPatternType
     * with default FillPatternType.SOLID_FOREGROUND
     */
    @Builder.Default
    private FillPatternType fillPatternType = FillPatternType.SOLID_FOREGROUND;


}
