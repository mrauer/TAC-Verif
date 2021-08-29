/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.framesave;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class FileFormat
extends Enum<FileFormat> {
    public static final /* enum */ FileFormat JPEG;
    public static final /* enum */ FileFormat PNG;
    public static final /* enum */ FileFormat SC_RAW;
    private static final /* synthetic */ FileFormat[] a;

    public static {
        FileFormat fileFormat;
        FileFormat fileFormat2;
        FileFormat fileFormat3;
        JPEG = fileFormat2 = new FileFormat();
        PNG = fileFormat3 = new FileFormat();
        SC_RAW = fileFormat = new FileFormat();
        a = new FileFormat[]{fileFormat2, fileFormat3, fileFormat};
    }

    public static FileFormat valueOf(String string) {
        return (FileFormat)Enum.valueOf(FileFormat.class, (String)string);
    }

    public static FileFormat[] values() {
        return (FileFormat[])a.clone();
    }
}

