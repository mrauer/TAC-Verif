/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.text.DecimalFormat
 */
package com.github.mikephil.charting.formatter;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.text.DecimalFormat;

public class DefaultAxisValueFormatter
extends ValueFormatter {
    public int digits;
    public DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int n) {
        this.digits = n;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"###,###,###,##0");
        stringBuilder.append(stringBuffer.toString());
        this.mFormat = new DecimalFormat(stringBuilder.toString());
    }

    @Override
    public String getFormattedValue(float f) {
        return this.mFormat.format((double)f);
    }
}

