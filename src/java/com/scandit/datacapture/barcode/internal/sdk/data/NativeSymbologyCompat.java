/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.barcode.internal.sdk.data.NativeSymbologyCompat$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.barcode.internal.sdk.data;

import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeSymbologyCompat;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSymbologyCompat {
    public NativeSymbologyCompat() {
    }

    public static ArrayList<Symbology> all() {
        return CppProxy.all();
    }

    public static String symbologyToString(Symbology symbology) {
        return CppProxy.symbologyToString((Symbology)symbology);
    }
}

