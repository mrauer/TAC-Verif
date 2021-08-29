/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.i18n.phonenumbers;

import com.android.tools.r8.GeneratedOutlineSupport;

public class NumberParseException
extends Exception {
    public ErrorType errorType;
    public String message;

    public NumberParseException(ErrorType errorType, String string) {
        super(string);
        this.message = string;
        this.errorType = errorType;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Error type: ");
        stringBuilder.append((Object)this.errorType);
        stringBuilder.append(". ");
        stringBuilder.append(this.message);
        return stringBuilder.toString();
    }

    public static final class ErrorType
    extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES;
        public static final /* enum */ ErrorType INVALID_COUNTRY_CODE;
        public static final /* enum */ ErrorType NOT_A_NUMBER;
        public static final /* enum */ ErrorType TOO_LONG;
        public static final /* enum */ ErrorType TOO_SHORT_AFTER_IDD;
        public static final /* enum */ ErrorType TOO_SHORT_NSN;

        public static {
            ErrorType errorType;
            ErrorType errorType2;
            ErrorType errorType3;
            ErrorType errorType4;
            ErrorType errorType5;
            INVALID_COUNTRY_CODE = errorType5 = new ErrorType();
            NOT_A_NUMBER = errorType3 = new ErrorType();
            TOO_SHORT_AFTER_IDD = errorType2 = new ErrorType();
            TOO_SHORT_NSN = errorType4 = new ErrorType();
            TOO_LONG = errorType = new ErrorType();
            $VALUES = new ErrorType[]{errorType5, errorType3, errorType2, errorType4, errorType};
        }

        public static ErrorType valueOf(String string) {
            return (ErrorType)Enum.valueOf(ErrorType.class, (String)string);
        }

        public static ErrorType[] values() {
            return (ErrorType[])$VALUES.clone();
        }
    }

}

