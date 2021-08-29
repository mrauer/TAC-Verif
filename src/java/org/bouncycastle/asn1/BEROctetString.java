/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Enumeration
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BEROctetString;

public class BEROctetString
extends ASN1OctetString {
    public final int chunkSize;
    public final ASN1OctetString[] octs;

    public BEROctetString(byte[] arrby) {
        super(arrby);
        this.octs = null;
        this.chunkSize = 1000;
    }

    public BEROctetString(ASN1OctetString[] arraSN1OctetString) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 != arraSN1OctetString.length; ++i2) {
            try {
                byteArrayOutputStream.write(arraSN1OctetString[i2].string);
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"exception converting octets ");
                stringBuilder.append(iOException.toString());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        super(byteArrayOutputStream.toByteArray());
        this.octs = arraSN1OctetString;
        this.chunkSize = 1000;
    }

    public static BEROctetString fromSequence(ASN1Sequence aSN1Sequence) {
        int n2 = aSN1Sequence.size();
        ASN1OctetString[] arraSN1OctetString = new ASN1OctetString[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arraSN1OctetString[i2] = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i2));
        }
        return new BEROctetString(arraSN1OctetString);
    }

    @Override
    public void encode(ASN1OutputStream aSN1OutputStream, boolean bl) throws IOException {
        Enumeration enumeration = this.getObjects();
        if (bl) {
            aSN1OutputStream.os.write(36);
        }
        aSN1OutputStream.os.write(128);
        aSN1OutputStream.writeElements(enumeration);
        aSN1OutputStream.os.write(0);
        aSN1OutputStream.os.write(0);
    }

    @Override
    public int encodedLength() throws IOException {
        Enumeration enumeration = this.getObjects();
        int n2 = 0;
        while (enumeration.hasMoreElements()) {
            n2 += ((ASN1Encodable)enumeration.nextElement()).toASN1Primitive().encodedLength();
        }
        return 2 + (n2 + 2);
    }

    public Enumeration getObjects() {
        if (this.octs == null) {
            return new Enumeration(this){
                public int pos;
                public final /* synthetic */ BEROctetString this$0;
                {
                    this.this$0 = bEROctetString;
                    this.pos = 0;
                }

                public boolean hasMoreElements() {
                    return this.pos < this.this$0.string.length;
                }

                public Object nextElement() {
                    int n2 = this.pos;
                    BEROctetString bEROctetString = this.this$0;
                    byte[] arrby = bEROctetString.string;
                    if (n2 < arrby.length) {
                        int n3 = java.lang.Math.min((int)(arrby.length - n2), (int)bEROctetString.chunkSize);
                        byte[] arrby2 = new byte[n3];
                        java.lang.System.arraycopy((Object)this.this$0.string, (int)this.pos, (Object)arrby2, (int)0, (int)n3);
                        this.pos = n3 + this.pos;
                        return new org.bouncycastle.asn1.DEROctetString(arrby2);
                    }
                    throw new java.util.NoSuchElementException();
                }
            };
        }
        return new Enumeration(this){
            public int counter;
            public final /* synthetic */ BEROctetString this$0;
            {
                this.this$0 = bEROctetString;
                this.counter = 0;
            }

            public boolean hasMoreElements() {
                return this.counter < this.this$0.octs.length;
            }

            public Object nextElement() {
                int n2 = this.counter;
                ASN1OctetString[] arraSN1OctetString = this.this$0.octs;
                if (n2 < arraSN1OctetString.length) {
                    this.counter = n2 + 1;
                    return arraSN1OctetString[n2];
                }
                throw new java.util.NoSuchElementException();
            }
        };
    }

    @Override
    public boolean isConstructed() {
        return true;
    }
}

