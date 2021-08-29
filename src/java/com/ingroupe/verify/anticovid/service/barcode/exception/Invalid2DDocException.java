/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.ingroupe.verify.anticovid.service.barcode.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

public final class Invalid2DDocException
extends Exception {
    public Invalid2DDocException(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        super(StringsKt__IndentKt.replace$default((String)string, (String)"{}", (String)string2, (boolean)false, (int)4));
    }
}

