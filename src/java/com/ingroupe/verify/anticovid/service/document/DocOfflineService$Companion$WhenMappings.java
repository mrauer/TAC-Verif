/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ingroupe.verify.anticovid.service.document.model.DocumentStaticDccResult
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.service.document;

import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticDccResult;

public final class DocOfflineService$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    public static {
        DocumentStaticDccResult.DccType.values();
        int[] arrn = new int[3];
        arrn[DocumentStaticDccResult.DccType.DCC_VACCINATION.ordinal()] = 1;
        arrn[DocumentStaticDccResult.DccType.DCC_TEST.ordinal()] = 2;
        arrn[DocumentStaticDccResult.DccType.DCC_RECOVERY.ordinal()] = 3;
        $EnumSwitchMapping$0 = arrn;
    }
}

