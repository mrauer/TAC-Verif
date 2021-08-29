/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.uritemplate.vars.specs;

public final class VariableSpecType
extends Enum<VariableSpecType> {
    private static final /* synthetic */ VariableSpecType[] $VALUES;
    public static final /* enum */ VariableSpecType EXPLODED;
    public static final /* enum */ VariableSpecType PREFIX;
    public static final /* enum */ VariableSpecType SIMPLE;

    public static {
        VariableSpecType variableSpecType;
        VariableSpecType variableSpecType2;
        VariableSpecType variableSpecType3;
        SIMPLE = variableSpecType = new VariableSpecType();
        PREFIX = variableSpecType2 = new VariableSpecType();
        EXPLODED = variableSpecType3 = new VariableSpecType();
        $VALUES = new VariableSpecType[]{variableSpecType, variableSpecType2, variableSpecType3};
    }

    public static VariableSpecType valueOf(String string) {
        return (VariableSpecType)Enum.valueOf(VariableSpecType.class, (String)string);
    }

    public static VariableSpecType[] values() {
        return (VariableSpecType[])$VALUES.clone();
    }
}

