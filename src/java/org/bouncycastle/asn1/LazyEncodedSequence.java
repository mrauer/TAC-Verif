/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Enumeration
 *  java.util.Iterator
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.LazyConstructionEnumeration;
import org.bouncycastle.asn1.StreamUtil;

public class LazyEncodedSequence
extends ASN1Sequence {
    public byte[] encoded;

    public LazyEncodedSequence(byte[] arrby) throws IOException {
        this.encoded = arrby;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            byte[] arrby = this.encoded;
            if (arrby != null) {
                aSN1OutputStream.writeEncoded(bl, 48, arrby);
            } else {
                super.toDLObject().encode(aSN1OutputStream, bl);
            }
            return;
        }
    }

    @Override
    public int encodedLength() throws IOException {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            block5 : {
                byte[] arrby = this.encoded;
                if (arrby == null) break block5;
                int n2 = 1 + StreamUtil.calculateBodyLength(arrby.length);
                int n3 = this.encoded.length;
                int n4 = n2 + n3;
                return n4;
            }
            int n5 = super.toDLObject().encodedLength();
            return n5;
        }
    }

    public final void force() {
        byte[] arrby = this.encoded;
        if (arrby != null) {
            ASN1Encodable[] arraSN1Encodable = new ASN1Encodable[10];
            LazyConstructionEnumeration lazyConstructionEnumeration = new LazyConstructionEnumeration(arrby);
            int n2 = 0;
            while (lazyConstructionEnumeration.hasMoreElements()) {
                ASN1Primitive aSN1Primitive = (ASN1Primitive)lazyConstructionEnumeration.nextElement();
                Objects.requireNonNull((Object)aSN1Primitive, (String)"'element' cannot be null");
                int n3 = arraSN1Encodable.length;
                int n4 = n2 + 1;
                boolean bl = n4 > n3;
                if (bl | false) {
                    ASN1Encodable[] arraSN1Encodable2 = new ASN1Encodable[java.lang.Math.max((int)arraSN1Encodable.length, (int)(n4 + (n4 >> 1)))];
                    System.arraycopy((Object)arraSN1Encodable, (int)0, (Object)arraSN1Encodable2, (int)0, (int)n2);
                    arraSN1Encodable = arraSN1Encodable2;
                }
                arraSN1Encodable[n2] = aSN1Primitive;
                n2 = n4;
            }
            if (n2 == 0) {
                arraSN1Encodable = ASN1EncodableVector.EMPTY_ELEMENTS;
            } else if (arraSN1Encodable.length != n2) {
                ASN1Encodable[] arraSN1Encodable3 = new ASN1Encodable[n2];
                System.arraycopy((Object)arraSN1Encodable, (int)0, (Object)arraSN1Encodable3, (int)0, (int)n2);
                arraSN1Encodable = arraSN1Encodable3;
            }
            this.elements = arraSN1Encodable;
            this.encoded = null;
        }
    }

    @Override
    public ASN1Encodable getObjectAt(int n2) {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            this.force();
            ASN1Encodable aSN1Encodable = this.elements[n2];
            return aSN1Encodable;
        }
    }

    @Override
    public Enumeration getObjects() {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            block5 : {
                byte[] arrby = this.encoded;
                if (arrby == null) break block5;
                LazyConstructionEnumeration lazyConstructionEnumeration = new LazyConstructionEnumeration(arrby);
                return lazyConstructionEnumeration;
            }
            Enumeration enumeration = new Enumeration(this){
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
            return enumeration;
        }
    }

    @Override
    public int hashCode() {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            this.force();
            int n2 = super.hashCode();
            return n2;
        }
    }

    @Override
    public Iterator<ASN1Encodable> iterator() {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            this.force();
            Iterator<ASN1Encodable> iterator = super.iterator();
            return iterator;
        }
    }

    @Override
    public int size() {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            this.force();
            int n2 = this.elements.length;
            return n2;
        }
    }

    @Override
    public ASN1Encodable[] toArrayInternal() {
        this.force();
        return this.elements;
    }

    @Override
    public ASN1Primitive toDERObject() {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            this.force();
            ASN1Primitive aSN1Primitive = super.toDERObject();
            return aSN1Primitive;
        }
    }

    @Override
    public ASN1Primitive toDLObject() {
        LazyEncodedSequence lazyEncodedSequence = this;
        synchronized (lazyEncodedSequence) {
            this.force();
            ASN1Primitive aSN1Primitive = super.toDLObject();
            return aSN1Primitive;
        }
    }
}

