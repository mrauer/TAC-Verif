/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import j$.lang.Iterable$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DLSet;
import org.bouncycastle.util.Arrays$Iterator;

public abstract class ASN1Set
extends ASN1Primitive
implements j$.lang.Iterable {
    public final ASN1Encodable[] elements;
    public final boolean isSorted;

    public ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    public ASN1Set(ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull((Object)aSN1Encodable, (String)"'element' cannot be null");
        this.elements = new ASN1Encodable[]{aSN1Encodable};
        this.isSorted = true;
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean bl) {
        boolean bl2;
        block8 : {
            block7 : {
                int n2;
                ASN1Encodable[] arraSN1Encodable;
                Objects.requireNonNull((Object)aSN1EncodableVector, (String)"'elementVector' cannot be null");
                if (bl && (n2 = aSN1EncodableVector.elementCount) >= 2) {
                    if (n2 == 0) {
                        arraSN1Encodable = ASN1EncodableVector.EMPTY_ELEMENTS;
                    } else {
                        ASN1Encodable[] arraSN1Encodable2 = new ASN1Encodable[n2];
                        System.arraycopy((Object)aSN1EncodableVector.elements, (int)0, (Object)arraSN1Encodable2, (int)0, (int)n2);
                        arraSN1Encodable = arraSN1Encodable2;
                    }
                    ASN1Set.sort(arraSN1Encodable);
                } else {
                    arraSN1Encodable = aSN1EncodableVector.takeElements();
                }
                this.elements = arraSN1Encodable;
                if (bl) break block7;
                int n3 = arraSN1Encodable.length;
                bl2 = false;
                if (n3 >= 2) break block8;
            }
            bl2 = true;
        }
        this.isSorted = bl2;
    }

    public ASN1Set(boolean bl, ASN1Encodable[] arraSN1Encodable) {
        this.elements = arraSN1Encodable;
        boolean bl2 = bl || arraSN1Encodable.length < 2;
        this.isSorted = bl2;
    }

    public static byte[] getDEREncoded(ASN1Encodable aSN1Encodable) {
        try {
            byte[] arrby = aSN1Encodable.toASN1Primitive().getEncoded("DER");
            return arrby;
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static boolean lessThanOrEqual(byte[] arrby, byte[] arrby2) {
        int n2 = -33 & arrby[0];
        int n3 = -33 & arrby2[0];
        if (n2 != n3) {
            boolean bl = false;
            if (n2 < n3) {
                bl = true;
            }
            return bl;
        }
        int n4 = Math.min((int)arrby.length, (int)arrby2.length) - 1;
        for (int i2 = 1; i2 < n4; ++i2) {
            if (arrby[i2] == arrby2[i2]) continue;
            int n5 = 255 & arrby[i2];
            int n6 = 255 & arrby2[i2];
            boolean bl = false;
            if (n5 < n6) {
                bl = true;
            }
            return bl;
        }
        int n7 = 255 & arrby[n4];
        int n8 = 255 & arrby2[n4];
        boolean bl = false;
        if (n7 <= n8) {
            bl = true;
        }
        return bl;
    }

    public static void sort(ASN1Encodable[] arraSN1Encodable) {
        int n2 = arraSN1Encodable.length;
        int n3 = 2;
        if (n2 < n3) {
            return;
        }
        ASN1Encodable aSN1Encodable = arraSN1Encodable[0];
        ASN1Encodable aSN1Encodable2 = arraSN1Encodable[1];
        byte[] arrby = ASN1Set.getDEREncoded(aSN1Encodable);
        byte[] arrby2 = ASN1Set.getDEREncoded(aSN1Encodable2);
        if (ASN1Set.lessThanOrEqual(arrby2, arrby)) {
            ASN1Encodable aSN1Encodable3 = aSN1Encodable2;
            aSN1Encodable2 = aSN1Encodable;
            aSN1Encodable = aSN1Encodable3;
        } else {
            byte[] arrby3 = arrby2;
            arrby2 = arrby;
            arrby = arrby3;
        }
        while (n3 < n2) {
            ASN1Encodable aSN1Encodable4 = arraSN1Encodable[n3];
            byte[] arrby4 = ASN1Set.getDEREncoded(aSN1Encodable4);
            if (ASN1Set.lessThanOrEqual(arrby, arrby4)) {
                arraSN1Encodable[n3 - 2] = aSN1Encodable;
                aSN1Encodable = aSN1Encodable2;
                arrby2 = arrby;
                aSN1Encodable2 = aSN1Encodable4;
                arrby = arrby4;
            } else if (ASN1Set.lessThanOrEqual(arrby2, arrby4)) {
                arraSN1Encodable[n3 - 2] = aSN1Encodable;
                aSN1Encodable = aSN1Encodable4;
                arrby2 = arrby4;
            } else {
                ASN1Encodable aSN1Encodable5;
                int n4 = n3 - 1;
                while (--n4 > 0 && !ASN1Set.lessThanOrEqual(ASN1Set.getDEREncoded(aSN1Encodable5 = arraSN1Encodable[n4 - 1]), arrby4)) {
                    arraSN1Encodable[n4] = aSN1Encodable5;
                }
                arraSN1Encodable[n4] = aSN1Encodable4;
            }
            ++n3;
        }
        arraSN1Encodable[n2 - 2] = aSN1Encodable;
        arraSN1Encodable[n2 - 1] = aSN1Encodable2;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set)aSN1Primitive;
        int n2 = this.elements.length;
        if (aSN1Set.elements.length != n2) {
            return false;
        }
        DERSet dERSet = (DERSet)this.toDERObject();
        DERSet dERSet2 = (DERSet)aSN1Set.toDERObject();
        for (int i2 = 0; i2 < n2; ++i2) {
            ASN1Primitive aSN1Primitive2;
            ASN1Primitive aSN1Primitive3 = dERSet.elements[i2].toASN1Primitive();
            if (aSN1Primitive3 == (aSN1Primitive2 = dERSet2.elements[i2].toASN1Primitive()) || aSN1Primitive3.asn1Equals(aSN1Primitive2)) continue;
            return false;
        }
        return true;
    }

    @Override
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable$-CC.$default$forEach((Iterable)this, consumer);
    }

    @Override
    public int hashCode() {
        int n2 = this.elements.length;
        int n3 = n2 + 1;
        while (--n2 >= 0) {
            n3 += this.elements[n2].toASN1Primitive().hashCode();
        }
        return n3;
    }

    @Override
    public boolean isConstructed() {
        return true;
    }

    public Iterator<ASN1Encodable> iterator() {
        ASN1Encodable[] arraSN1Encodable = this.elements;
        ASN1Encodable[] arraSN1Encodable2 = arraSN1Encodable.length < 1 ? ASN1EncodableVector.EMPTY_ELEMENTS : (ASN1Encodable[])arraSN1Encodable.clone();
        return new Arrays$Iterator<ASN1Encodable>(arraSN1Encodable2);
    }

    @Override
    public /* synthetic */ Spliterator spliterator() {
        return Iterable$-CC.$default$spliterator((Iterable)this);
    }

    @Override
    public ASN1Primitive toDERObject() {
        ASN1Encodable[] arraSN1Encodable;
        if (this.isSorted) {
            arraSN1Encodable = this.elements;
        } else {
            arraSN1Encodable = (ASN1Encodable[])this.elements.clone();
            ASN1Set.sort(arraSN1Encodable);
        }
        return new DERSet(true, arraSN1Encodable);
    }

    @Override
    public ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
    }

    public String toString() {
        int n2 = this.elements.length;
        if (n2 == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int n3 = 0;
        do {
            stringBuffer.append((Object)this.elements[n3]);
            if (++n3 >= n2) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        } while (true);
    }
}

