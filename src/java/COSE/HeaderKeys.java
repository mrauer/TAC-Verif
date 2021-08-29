/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.upokecenter.cbor.CBORObject
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package COSE;

import com.upokecenter.cbor.CBORObject;

public final class HeaderKeys
extends Enum<HeaderKeys> {
    private static final /* synthetic */ HeaderKeys[] $VALUES;
    public static final /* enum */ HeaderKeys Algorithm;
    public static final /* enum */ HeaderKeys CONTENT_TYPE;
    public static final /* enum */ HeaderKeys CounterSignature;
    public static final /* enum */ HeaderKeys CounterSignature0;
    public static final /* enum */ HeaderKeys CriticalHeaders;
    public static final /* enum */ HeaderKeys ECDH_EPK;
    public static final /* enum */ HeaderKeys ECDH_SKID;
    public static final /* enum */ HeaderKeys ECDH_SPK;
    public static final /* enum */ HeaderKeys HKDF_Context_PartyU_ID;
    public static final /* enum */ HeaderKeys HKDF_Context_PartyU_Other;
    public static final /* enum */ HeaderKeys HKDF_Context_PartyU_nonce;
    public static final /* enum */ HeaderKeys HKDF_Context_PartyV_ID;
    public static final /* enum */ HeaderKeys HKDF_Context_PartyV_Other;
    public static final /* enum */ HeaderKeys HKDF_Context_PartyV_nonce;
    public static final /* enum */ HeaderKeys HKDF_Salt;
    public static final /* enum */ HeaderKeys HKDF_SuppPriv_Other;
    public static final /* enum */ HeaderKeys HKDF_SuppPub_Other;
    public static final /* enum */ HeaderKeys IV;
    public static final /* enum */ HeaderKeys KID;
    public static final /* enum */ HeaderKeys PARTIAL_IV;
    private CBORObject value;

    public static {
        HeaderKeys headerKeys;
        HeaderKeys headerKeys2;
        HeaderKeys headerKeys3;
        HeaderKeys headerKeys4;
        HeaderKeys headerKeys5;
        HeaderKeys headerKeys6;
        HeaderKeys headerKeys7;
        HeaderKeys headerKeys8;
        HeaderKeys headerKeys9;
        HeaderKeys headerKeys10;
        HeaderKeys headerKeys11;
        HeaderKeys headerKeys12;
        HeaderKeys headerKeys13;
        HeaderKeys headerKeys14;
        HeaderKeys headerKeys15;
        HeaderKeys headerKeys16;
        HeaderKeys headerKeys17;
        HeaderKeys headerKeys18;
        HeaderKeys headerKeys19;
        HeaderKeys headerKeys20;
        Algorithm = headerKeys13 = new HeaderKeys(1);
        CONTENT_TYPE = headerKeys17 = new HeaderKeys(3);
        KID = headerKeys7 = new HeaderKeys(4);
        IV = headerKeys12 = new HeaderKeys(5);
        CriticalHeaders = headerKeys18 = new HeaderKeys(2);
        CounterSignature = headerKeys5 = new HeaderKeys(7);
        PARTIAL_IV = headerKeys9 = new HeaderKeys(6);
        CounterSignature0 = headerKeys = new HeaderKeys(9);
        ECDH_EPK = headerKeys11 = new HeaderKeys(-1);
        ECDH_SPK = headerKeys6 = new HeaderKeys(-2);
        ECDH_SKID = headerKeys19 = new HeaderKeys(-3);
        HKDF_Salt = headerKeys16 = new HeaderKeys(-20);
        HKDF_Context_PartyU_ID = headerKeys10 = new HeaderKeys(-21);
        HKDF_Context_PartyU_nonce = headerKeys8 = new HeaderKeys(-22);
        HKDF_Context_PartyU_Other = headerKeys2 = new HeaderKeys(-23);
        HKDF_Context_PartyV_ID = headerKeys15 = new HeaderKeys(-24);
        HKDF_Context_PartyV_nonce = headerKeys20 = new HeaderKeys(-25);
        HKDF_Context_PartyV_Other = headerKeys14 = new HeaderKeys(-26);
        HKDF_SuppPub_Other = headerKeys3 = new HeaderKeys(-999);
        HKDF_SuppPriv_Other = headerKeys4 = new HeaderKeys(-998);
        $VALUES = new HeaderKeys[]{headerKeys13, headerKeys17, headerKeys7, headerKeys12, headerKeys18, headerKeys5, headerKeys9, headerKeys, headerKeys11, headerKeys6, headerKeys19, headerKeys16, headerKeys10, headerKeys8, headerKeys2, headerKeys15, headerKeys20, headerKeys14, headerKeys3, headerKeys4};
    }

    public HeaderKeys(int n4) {
        this.value = CBORObject.FromObject((int)n4);
    }

    public static HeaderKeys valueOf(String string) {
        return (HeaderKeys)Enum.valueOf(HeaderKeys.class, (String)string);
    }

    public static HeaderKeys[] values() {
        return (HeaderKeys[])$VALUES.clone();
    }

    public CBORObject AsCBOR() {
        return this.value;
    }
}

