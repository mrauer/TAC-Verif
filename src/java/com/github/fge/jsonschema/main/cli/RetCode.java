/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.main.cli;

public final class RetCode
extends Enum<RetCode> {
    private static final /* synthetic */ RetCode[] $VALUES;
    public static final /* enum */ RetCode ALL_OK;
    public static final /* enum */ RetCode CMD_ERROR;
    public static final /* enum */ RetCode SCHEMA_SYNTAX_ERROR;
    public static final /* enum */ RetCode VALIDATION_FAILURE;
    private final int retCode;

    public static {
        RetCode retCode;
        RetCode retCode2;
        RetCode retCode3;
        RetCode retCode4;
        ALL_OK = retCode4 = new RetCode(0);
        CMD_ERROR = retCode3 = new RetCode(2);
        VALIDATION_FAILURE = retCode = new RetCode(100);
        SCHEMA_SYNTAX_ERROR = retCode2 = new RetCode(101);
        $VALUES = new RetCode[]{retCode4, retCode3, retCode, retCode2};
    }

    private RetCode(int n4) {
        this.retCode = n4;
    }

    public static RetCode valueOf(String string) {
        return (RetCode)Enum.valueOf(RetCode.class, (String)string);
    }

    public static RetCode[] values() {
        return (RetCode[])$VALUES.clone();
    }

    public int get() {
        return this.retCode;
    }
}

