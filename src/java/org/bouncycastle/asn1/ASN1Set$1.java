/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Enumeration
 *  java.util.NoSuchElementException
 *  org.bouncycastle.asn1.ASN1Set
 */
package org.bouncycastle.asn1;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Set;

public class ASN1Set$1
implements Enumeration {
    public int pos = 0;
    public final /* synthetic */ ASN1Set this$0;

    public ASN1Set$1(ASN1Set aSN1Set) {
        this.this$0 = aSN1Set;
    }

    public boolean hasMoreElements() {
        return this.pos < this.this$0.elements.length;
    }

    public Object nextElement() {
        int n2 = this.pos;
        ASN1Encodable[] arraSN1Encodable = this.this$0.elements;
        if (n2 < arraSN1Encodable.length) {
            this.pos = n2 + 1;
            return arraSN1Encodable[n2];
        }
        throw new NoSuchElementException();
    }
}

