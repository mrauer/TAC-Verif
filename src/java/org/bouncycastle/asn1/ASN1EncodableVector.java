/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;

public class ASN1EncodableVector {
    public static final ASN1Encodable[] EMPTY_ELEMENTS = new ASN1Encodable[0];
    public boolean copyOnWrite;
    public int elementCount;
    public ASN1Encodable[] elements;

    public ASN1EncodableVector(int n2) {
        if (n2 >= 0) {
            ASN1Encodable[] arraSN1Encodable = n2 == 0 ? EMPTY_ELEMENTS : new ASN1Encodable[n2];
            this.elements = arraSN1Encodable;
            this.elementCount = 0;
            this.copyOnWrite = false;
            return;
        }
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    public void add(ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull((Object)aSN1Encodable, (String)"'element' cannot be null");
        ASN1Encodable[] arraSN1Encodable = this.elements;
        int n2 = arraSN1Encodable.length;
        int n3 = this.elementCount;
        int n4 = 1;
        int n5 = n3 + n4;
        if (n5 <= n2) {
            n4 = 0;
        }
        if ((n4 | this.copyOnWrite) != 0) {
            ASN1Encodable[] arraSN1Encodable2 = new ASN1Encodable[java.lang.Math.max((int)arraSN1Encodable.length, (int)(n5 + (n5 >> 1)))];
            System.arraycopy((Object)this.elements, (int)0, (Object)arraSN1Encodable2, (int)0, (int)this.elementCount);
            this.elements = arraSN1Encodable2;
            this.copyOnWrite = false;
        }
        this.elements[this.elementCount] = aSN1Encodable;
        this.elementCount = n5;
    }

    public ASN1Encodable get(int n2) {
        if (n2 < this.elementCount) {
            return this.elements[n2];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n2);
        stringBuilder.append(" >= ");
        stringBuilder.append(this.elementCount);
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    public ASN1Encodable[] takeElements() {
        int n2 = this.elementCount;
        if (n2 == 0) {
            return EMPTY_ELEMENTS;
        }
        ASN1Encodable[] arraSN1Encodable = this.elements;
        if (arraSN1Encodable.length == n2) {
            this.copyOnWrite = true;
            return arraSN1Encodable;
        }
        ASN1Encodable[] arraSN1Encodable2 = new ASN1Encodable[n2];
        System.arraycopy((Object)arraSN1Encodable, (int)0, (Object)arraSN1Encodable2, (int)0, (int)n2);
        return arraSN1Encodable2;
    }
}

