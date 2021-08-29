/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.upokecenter.cbor;

public final class URIUtility$ParseMode
extends Enum<URIUtility$ParseMode> {
    private static final /* synthetic */ URIUtility$ParseMode[] $VALUES;
    public static final /* enum */ URIUtility$ParseMode IRILenient;
    public static final /* enum */ URIUtility$ParseMode IRIStrict;
    public static final /* enum */ URIUtility$ParseMode IRISurrogateLenient;
    public static final /* enum */ URIUtility$ParseMode URILenient;
    public static final /* enum */ URIUtility$ParseMode URIStrict;

    public static {
        URIUtility$ParseMode uRIUtility$ParseMode;
        URIUtility$ParseMode uRIUtility$ParseMode2;
        URIUtility$ParseMode uRIUtility$ParseMode3;
        URIUtility$ParseMode uRIUtility$ParseMode4;
        URIUtility$ParseMode uRIUtility$ParseMode5;
        IRIStrict = uRIUtility$ParseMode5 = new URIUtility$ParseMode();
        URIStrict = uRIUtility$ParseMode4 = new URIUtility$ParseMode();
        IRILenient = uRIUtility$ParseMode3 = new URIUtility$ParseMode();
        URILenient = uRIUtility$ParseMode = new URIUtility$ParseMode();
        IRISurrogateLenient = uRIUtility$ParseMode2 = new URIUtility$ParseMode();
        $VALUES = new URIUtility$ParseMode[]{uRIUtility$ParseMode5, uRIUtility$ParseMode4, uRIUtility$ParseMode3, uRIUtility$ParseMode, uRIUtility$ParseMode2};
    }

    public static URIUtility$ParseMode valueOf(String string) {
        return (URIUtility$ParseMode)Enum.valueOf(URIUtility$ParseMode.class, (String)string);
    }

    public static URIUtility$ParseMode[] values() {
        return (URIUtility$ParseMode[])$VALUES.clone();
    }
}

