/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.ui;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class LogoStyle
extends Enum<LogoStyle> {
    public static final /* enum */ LogoStyle EXTENDED;
    public static final /* enum */ LogoStyle MINIMAL;
    private static final /* synthetic */ LogoStyle[] a;

    public static {
        LogoStyle logoStyle;
        LogoStyle logoStyle2;
        EXTENDED = logoStyle = new LogoStyle();
        MINIMAL = logoStyle2 = new LogoStyle();
        a = new LogoStyle[]{logoStyle, logoStyle2};
    }

    public static LogoStyle valueOf(String string) {
        return (LogoStyle)Enum.valueOf(LogoStyle.class, (String)string);
    }

    public static LogoStyle[] values() {
        return (LogoStyle[])a.clone();
    }
}

