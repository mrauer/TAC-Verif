/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package joptsimple.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import joptsimple.internal.Columns;
import joptsimple.internal.Row;
import joptsimple.internal.Strings;

public class Rows {
    public final int columnSeparatorWidth;
    public final int overallWidth;
    public final List<Row> rows = new ArrayList();
    public int widthOfWidestDescription;
    public int widthOfWidestOption;

    public Rows(int n2, int n3) {
        this.overallWidth = n2;
        this.columnSeparatorWidth = n3;
    }

    public final void add(Row row) {
        this.rows.add((Object)row);
        this.widthOfWidestOption = Math.max((int)this.widthOfWidestOption, (int)row.option.length());
        this.widthOfWidestDescription = Math.max((int)this.widthOfWidestDescription, (int)row.description.length());
    }

    public void fitToWidth() {
        Columns columns = new Columns(this.optionWidth(), Math.min((int)(this.overallWidth - this.optionWidth() - this.columnSeparatorWidth), (int)this.widthOfWidestDescription));
        ArrayList arrayList = new ArrayList();
        for (Row row : this.rows) {
            ArrayList arrayList2;
            ArrayList arrayList3;
            int n2;
            List<String> list = columns.piecesOf(row.option, columns.optionWidth);
            List<String> list2 = columns.piecesOf(row.description, columns.descriptionWidth);
            ArrayList arrayList4 = new ArrayList();
            for (int i2 = 0; i2 < Math.max((int)(n2 = (arrayList2 = (ArrayList)list).size()), (int)(arrayList3 = (ArrayList)list2).size()); ++i2) {
                int n3 = arrayList2.size();
                String string = "";
                String string2 = i2 >= n3 ? string : (String)arrayList2.get(i2);
                if (i2 < arrayList3.size()) {
                    string = (String)arrayList3.get(i2);
                }
                arrayList4.add((Object)new Row(string2, string));
            }
            arrayList.addAll((Collection)arrayList4);
        }
        this.reset();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            this.add((Row)iterator.next());
        }
    }

    public final int optionWidth() {
        return Math.min((int)((this.overallWidth - this.columnSeparatorWidth) / 2), (int)this.widthOfWidestOption);
    }

    public String render() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : this.rows) {
            String string = row.option;
            int n2 = this.optionWidth();
            stringBuilder.append(string);
            stringBuilder.append(Strings.repeat(' ', n2 - string.length()));
            stringBuilder.append(Strings.repeat(' ', this.columnSeparatorWidth));
            String string2 = row.description;
            int n3 = Math.min((int)(this.overallWidth - this.optionWidth() - this.columnSeparatorWidth), (int)this.widthOfWidestDescription);
            stringBuilder.append(string2);
            stringBuilder.append(Strings.repeat(' ', n3 - string2.length()));
            stringBuilder.append(Strings.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    public void reset() {
        this.rows.clear();
        this.widthOfWidestOption = 0;
        this.widthOfWidestDescription = 0;
    }
}

