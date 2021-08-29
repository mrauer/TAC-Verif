/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  j
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.util.Enumeration
 *  java.util.Iterator
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import j$.lang.Iterable;
import j$.lang.Iterable$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.util.Arrays$Iterator;

public abstract class ASN1Sequence
extends ASN1Primitive
implements Iterable {
    public ASN1Encodable[] elements;

    public ASN1Sequence() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    public ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        Objects.requireNonNull((Object)aSN1EncodableVector, (String)"'elementVector' cannot be null");
        this.elements = aSN1EncodableVector.takeElements();
    }

    public ASN1Sequence(ASN1Encodable[] arraSN1Encodable, boolean bl) {
        if (bl) {
            arraSN1Encodable = arraSN1Encodable.length < 1 ? ASN1EncodableVector.EMPTY_ELEMENTS : (ASN1Encodable[])arraSN1Encodable.clone();
        }
        this.elements = arraSN1Encodable;
    }

    public static ASN1Sequence getInstance(Object object) {
        if (object != null && !(object instanceof ASN1Sequence)) {
            ASN1Primitive aSN1Primitive;
            if (object instanceof ASN1SequenceParser) {
                return ASN1Sequence.getInstance(((ASN1SequenceParser)object).toASN1Primitive());
            }
            if (object instanceof byte[]) {
                try {
                    ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(ASN1Primitive.fromByteArray((byte[])object));
                    return aSN1Sequence;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"failed to construct sequence from byte[]: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            if (object instanceof ASN1Encodable && (aSN1Primitive = ((ASN1Encodable)object).toASN1Primitive()) instanceof ASN1Sequence) {
                return (ASN1Sequence)aSN1Primitive;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown object in getInstance: ");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (ASN1Sequence)object;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence)aSN1Primitive;
        int n2 = this.size();
        if (aSN1Sequence.size() != n2) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            ASN1Primitive aSN1Primitive2;
            ASN1Primitive aSN1Primitive3 = this.elements[i2].toASN1Primitive();
            if (aSN1Primitive3 == (aSN1Primitive2 = aSN1Sequence.elements[i2].toASN1Primitive()) || aSN1Primitive3.asn1Equals(aSN1Primitive2)) continue;
            return false;
        }
        return true;
    }

    @Override
    public /* synthetic */ void forEach(j.Consumer consumer) {
        Iterable$-CC.$default$forEach((java.lang.Iterable)this, consumer);
    }

    public ASN1Encodable getObjectAt(int n2) {
        return this.elements[n2];
    }

    public Enumeration getObjects() {
        return new Enumeration(this){
            public int pos;
            public final /* synthetic */ ASN1Sequence this$0;
            {
                this.this$0 = aSN1Sequence;
                this.pos = 0;
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
                throw new java.util.NoSuchElementException();
            }
        };
    }

    @Override
    public int hashCode() {
        int n2 = this.elements.length;
        int n3 = n2 + 1;
        while (--n2 >= 0) {
            n3 = n3 * 257 ^ this.elements[n2].toASN1Primitive().hashCode();
        }
        return n3;
    }

    @Override
    public boolean isConstructed() {
        return true;
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays$Iterator<ASN1Encodable>(this.elements);
    }

    public int size() {
        return this.elements.length;
    }

    @Override
    public /* synthetic */ j.Spliterator spliterator() {
        return Iterable$-CC.$default$spliterator((java.lang.Iterable)this);
    }

    public ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    @Override
    public ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    @Override
    public ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
    }

    public String toString() {
        int n2 = this.size();
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

