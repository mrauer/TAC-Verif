/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import org.bouncycastle.asn1.ASN1Primitive;

public abstract class ASN1Null
extends ASN1Primitive {
    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive instanceof ASN1Null;
    }

    @Override
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}

