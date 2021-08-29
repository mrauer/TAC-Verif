/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.service.document;

import com.ingroupe.verify.anticovid.service.document.BarcodeService;
import com.ingroupe.verify.anticovid.service.document.model.DocumentFieldResult;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public abstract class DatamatrixService
extends BarcodeService {
    public static final String getField(List<DocumentFieldResult> list, String string) {
        DocumentFieldResult documentFieldResult;
        if (list == null) {
            documentFieldResult = null;
        } else {
            Object object2;
            block5 : {
                for (Object object2 : list) {
                    DocumentFieldResult documentFieldResult2 = (DocumentFieldResult)object2;
                    int n2 = string.length();
                    boolean bl = true;
                    boolean bl2 = n2 > 0 ? bl : false;
                    if (!bl2 || !Intrinsics.areEqual((Object)string, (Object)documentFieldResult2.getName())) {
                        bl = false;
                    }
                    if (!bl) continue;
                    break block5;
                }
                object2 = null;
            }
            documentFieldResult = (DocumentFieldResult)object2;
        }
        if (documentFieldResult == null) {
            return null;
        }
        return documentFieldResult.getValue();
    }
}

