/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.service.barcode;

import com.ingroupe.verify.anticovid.service.barcode.enums.OperationEnum;

public final class OperationService$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    public static {
        OperationEnum.values();
        int[] arrn = new int[8];
        arrn[OperationEnum.CONVERT_HEX_TO_DATE.ordinal()] = 1;
        arrn[OperationEnum.CONVERT_STRING_TO_DATE.ordinal()] = 2;
        arrn[OperationEnum.DECODE_BASE16.ordinal()] = 3;
        arrn[OperationEnum.DECODE_BASE32.ordinal()] = 4;
        arrn[OperationEnum.DECODE_BASE36.ordinal()] = 5;
        arrn[OperationEnum.GET_COUNTRY.ordinal()] = 6;
        arrn[OperationEnum.REMOVE_SLASH.ordinal()] = 7;
        arrn[OperationEnum.TRANSLATE_BOOLEAN.ordinal()] = 8;
        $EnumSwitchMapping$0 = arrn;
    }
}

