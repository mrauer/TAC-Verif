/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.BreakIterator
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package joptsimple.internal;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import joptsimple.internal.Strings;

public class Columns {
    public final int descriptionWidth;
    public final int optionWidth;

    public Columns(int n2, int n3) {
        this.optionWidth = n2;
        this.descriptionWidth = n3;
    }

    public final List<String> piecesOf(String string, int n2) {
        ArrayList arrayList = new ArrayList();
        for (String string2 : string.trim().split(Strings.LINE_SEPARATOR)) {
            int n3;
            ArrayList arrayList2 = new ArrayList();
            BreakIterator breakIterator = BreakIterator.getLineInstance();
            breakIterator.setText(string2);
            StringBuilder stringBuilder = new StringBuilder();
            int n4 = breakIterator.first();
            while ((n3 = breakIterator.next()) != -1) {
                String string3 = string2.substring(n4, n3);
                if (stringBuilder.length() + string3.length() > n2) {
                    arrayList2.add((Object)stringBuilder.toString().replaceAll("\\s+$", ""));
                    stringBuilder = new StringBuilder(Strings.repeat(' ', 2));
                    stringBuilder.append(string3);
                } else {
                    stringBuilder.append(string3);
                }
                n4 = n3;
            }
            if (stringBuilder.length() > 0) {
                arrayList2.add((Object)stringBuilder.toString());
            }
            arrayList.addAll((Collection)arrayList2);
        }
        return arrayList;
    }
}

