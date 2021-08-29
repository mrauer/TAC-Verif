/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package com.ingroupe.verify.anticovid.service.barcode.enums;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class CharacterEnum
extends Enum<CharacterEnum> {
    private static final /* synthetic */ CharacterEnum[] $VALUES;
    public static final Companion Companion;
    public static final /* enum */ CharacterEnum GS;
    public static final /* enum */ CharacterEnum RS;
    public static final /* enum */ CharacterEnum US;
    private final String unicode;

    public static {
        CharacterEnum characterEnum;
        CharacterEnum characterEnum2;
        CharacterEnum characterEnum3;
        GS = characterEnum3 = new CharacterEnum("\u001d");
        RS = characterEnum2 = new CharacterEnum("\u001e");
        US = characterEnum = new CharacterEnum("\u001f");
        $VALUES = new CharacterEnum[]{characterEnum3, characterEnum2, characterEnum};
        Companion = new Companion(null);
    }

    public CharacterEnum(String string2) {
        this.unicode = string2;
    }

    public static CharacterEnum valueOf(String string) {
        return (CharacterEnum)Enum.valueOf(CharacterEnum.class, (String)string);
    }

    public static CharacterEnum[] values() {
        return (CharacterEnum[])$VALUES.clone();
    }

    public final String getUnicode() {
        return this.unicode;
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

}

