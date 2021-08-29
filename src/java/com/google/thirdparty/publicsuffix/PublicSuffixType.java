/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.thirdparty.publicsuffix;

public final class PublicSuffixType
extends Enum<PublicSuffixType> {
    private static final /* synthetic */ PublicSuffixType[] $VALUES;
    public static final /* enum */ PublicSuffixType PRIVATE;
    public static final /* enum */ PublicSuffixType REGISTRY;
    private final char innerNodeCode;
    private final char leafNodeCode;

    public static {
        PublicSuffixType publicSuffixType;
        PublicSuffixType publicSuffixType2;
        PRIVATE = publicSuffixType = new PublicSuffixType(':', ',');
        REGISTRY = publicSuffixType2 = new PublicSuffixType('!', '?');
        $VALUES = new PublicSuffixType[]{publicSuffixType, publicSuffixType2};
    }

    public PublicSuffixType(char c4, char c5) {
        this.innerNodeCode = c4;
        this.leafNodeCode = c5;
    }

    public static PublicSuffixType fromCode(char c4) {
        PublicSuffixType[] arrpublicSuffixType = PublicSuffixType.values();
        for (int i3 = 0; i3 < 2; ++i3) {
            PublicSuffixType publicSuffixType = arrpublicSuffixType[i3];
            if (publicSuffixType.innerNodeCode != c4) {
                if (publicSuffixType.leafNodeCode != c4) continue;
                return publicSuffixType;
            }
            return publicSuffixType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No enum corresponding to given code: ");
        stringBuilder.append(c4);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static PublicSuffixType valueOf(String string) {
        return (PublicSuffixType)Enum.valueOf(PublicSuffixType.class, (String)string);
    }

    public static PublicSuffixType[] values() {
        return (PublicSuffixType[])$VALUES.clone();
    }
}

