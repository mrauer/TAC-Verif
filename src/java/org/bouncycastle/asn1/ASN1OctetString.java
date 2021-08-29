/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString
extends ASN1Primitive
implements ASN1OctetStringParser {
    public byte[] string;

    public ASN1OctetString(byte[] arrby) {
        Objects.requireNonNull((Object)arrby, (String)"'string' cannot be null");
        this.string = arrby;
    }

    public static ASN1OctetString getInstance(Object object) {
        if (object != null && !(object instanceof ASN1OctetString)) {
            ASN1Primitive aSN1Primitive;
            if (object instanceof byte[]) {
                try {
                    ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance(ASN1Primitive.fromByteArray((byte[])object));
                    return aSN1OctetString;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"failed to construct OCTET STRING from byte[]: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            if (object instanceof ASN1Encodable && (aSN1Primitive = ((ASN1Encodable)object).toASN1Primitive()) instanceof ASN1OctetString) {
                return (ASN1OctetString)aSN1Primitive;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"illegal object in getInstance: ");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (ASN1OctetString)object;
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean bl) {
        if (bl) {
            if (aSN1TaggedObject.explicit) {
                return ASN1OctetString.getInstance(aSN1TaggedObject.getObject());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
        ASN1Primitive aSN1Primitive = aSN1TaggedObject.getObject();
        if (aSN1TaggedObject.explicit) {
            ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance(aSN1Primitive);
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BEROctetString(new ASN1OctetString[]{aSN1OctetString});
            }
            return (ASN1OctetString)new BEROctetString(new ASN1OctetString[]{aSN1OctetString}).toDLObject();
        }
        if (aSN1Primitive instanceof ASN1OctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString)aSN1Primitive;
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return aSN1OctetString;
            }
            return (ASN1OctetString)aSN1OctetString.toDLObject();
        }
        if (aSN1Primitive instanceof ASN1Sequence) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence)aSN1Primitive;
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return BEROctetString.fromSequence(aSN1Sequence);
            }
            return (ASN1OctetString)BEROctetString.fromSequence(aSN1Sequence).toDLObject();
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown object in getInstance: ");
        stringBuilder.append(aSN1TaggedObject.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return false;
        }
        ASN1OctetString aSN1OctetString = (ASN1OctetString)aSN1Primitive;
        return Arrays.equals((byte[])this.string, (byte[])aSN1OctetString.string);
    }

    @Override
    public ASN1Primitive getLoadedObject() {
        return this;
    }

    @Override
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    @Override
    public int hashCode() {
        return Nat576.hashCode(this.string);
    }

    @Override
    public ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    @Override
    public ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"#");
        byte[] arrby = this.string;
        stringBuilder.append(Strings.fromByteArray(Hex.encode(arrby, 0, arrby.length)));
        return stringBuilder.toString();
    }
}

