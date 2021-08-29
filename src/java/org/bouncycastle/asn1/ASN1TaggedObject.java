/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DLTaggedObject;
import org.bouncycastle.asn1.InMemoryRepresentable;
import org.bouncycastle.asn1.x9.X962Parameters;

public abstract class ASN1TaggedObject
extends ASN1Primitive
implements ASN1Encodable,
InMemoryRepresentable {
    public final boolean explicit;
    public final ASN1Encodable obj;
    public final int tagNo;

    public ASN1TaggedObject(boolean bl, int n2, ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull((Object)aSN1Encodable, (String)"'obj' cannot be null");
        this.tagNo = n2;
        boolean bl2 = bl || aSN1Encodable instanceof X962Parameters;
        this.explicit = bl2;
        this.obj = aSN1Encodable;
    }

    public static ASN1TaggedObject getInstance(Object object) {
        if (object != null && !(object instanceof ASN1TaggedObject)) {
            if (object instanceof byte[]) {
                try {
                    ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(ASN1Primitive.fromByteArray((byte[])object));
                    return aSN1TaggedObject;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"failed to construct tagged object from byte[]: ");
                    stringBuilder.append(iOException.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown object in getInstance: ");
            stringBuilder.append(object.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (ASN1TaggedObject)object;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        boolean bl;
        block5 : {
            block6 : {
                ASN1Primitive aSN1Primitive2;
                if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
                    return false;
                }
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject)aSN1Primitive;
                int n2 = this.tagNo;
                int n3 = aSN1TaggedObject.tagNo;
                bl = false;
                if (n2 != n3) break block5;
                if (this.explicit != aSN1TaggedObject.explicit) {
                    return false;
                }
                ASN1Primitive aSN1Primitive3 = this.obj.toASN1Primitive();
                if (aSN1Primitive3 == (aSN1Primitive2 = aSN1TaggedObject.obj.toASN1Primitive())) break block6;
                boolean bl2 = aSN1Primitive3.asn1Equals(aSN1Primitive2);
                bl = false;
                if (!bl2) break block5;
            }
            bl = true;
        }
        return bl;
    }

    @Override
    public ASN1Primitive getLoadedObject() {
        return this;
    }

    public ASN1Primitive getObject() {
        return this.obj.toASN1Primitive();
    }

    @Override
    public int hashCode() {
        int n2 = this.tagNo;
        int n3 = this.explicit ? 15 : 240;
        return n2 ^ n3 ^ this.obj.toASN1Primitive().hashCode();
    }

    @Override
    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    @Override
    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"[");
        stringBuilder.append(this.tagNo);
        stringBuilder.append("]");
        stringBuilder.append((Object)this.obj);
        return stringBuilder.toString();
    }
}

