/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERExternal;
import org.bouncycastle.asn1.DLExternal;

public abstract class ASN1External
extends ASN1Primitive {
    public ASN1Primitive dataValueDescriptor;
    public ASN1ObjectIdentifier directReference;
    public int encoding;
    public ASN1Primitive externalContent;
    public ASN1Integer indirectReference;

    public ASN1External(ASN1EncodableVector aSN1EncodableVector) {
        ASN1Primitive aSN1Primitive = this.getObjFromVector(aSN1EncodableVector, 0);
        boolean bl = aSN1Primitive instanceof ASN1ObjectIdentifier;
        int n2 = 0;
        if (bl) {
            this.directReference = (ASN1ObjectIdentifier)aSN1Primitive;
            aSN1Primitive = this.getObjFromVector(aSN1EncodableVector, 1);
            n2 = 1;
        }
        if (aSN1Primitive instanceof ASN1Integer) {
            this.indirectReference = (ASN1Integer)aSN1Primitive;
            aSN1Primitive = this.getObjFromVector(aSN1EncodableVector, ++n2);
        }
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            this.dataValueDescriptor = aSN1Primitive;
            aSN1Primitive = this.getObjFromVector(aSN1EncodableVector, ++n2);
        }
        if (aSN1EncodableVector.elementCount == n2 + 1) {
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject)aSN1Primitive;
                this.setEncoding(aSN1TaggedObject.tagNo);
                this.externalContent = aSN1TaggedObject.getObject();
                return;
            }
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
        throw new IllegalArgumentException("input vector too large");
    }

    public ASN1External(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Primitive aSN1Primitive, int n2, ASN1Primitive aSN1Primitive2) {
        this.directReference = aSN1ObjectIdentifier;
        this.indirectReference = aSN1Integer;
        this.dataValueDescriptor = aSN1Primitive;
        this.setEncoding(n2);
        Objects.requireNonNull((Object)aSN1Primitive2);
        this.externalContent = aSN1Primitive2;
    }

    @Override
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1Integer aSN1Integer;
        ASN1Primitive aSN1Primitive2;
        if (!(aSN1Primitive instanceof ASN1External)) {
            return false;
        }
        if (this == aSN1Primitive) {
            return true;
        }
        ASN1External aSN1External = (ASN1External)aSN1Primitive;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = this.directReference;
        if (!(aSN1ObjectIdentifier2 == null || (aSN1ObjectIdentifier = aSN1External.directReference) != null && aSN1ObjectIdentifier.equals(aSN1ObjectIdentifier2))) {
            return false;
        }
        ASN1Integer aSN1Integer2 = this.indirectReference;
        if (!(aSN1Integer2 == null || (aSN1Integer = aSN1External.indirectReference) != null && aSN1Integer.equals(aSN1Integer2))) {
            return false;
        }
        ASN1Primitive aSN1Primitive3 = this.dataValueDescriptor;
        if (!(aSN1Primitive3 == null || (aSN1Primitive2 = aSN1External.dataValueDescriptor) != null && aSN1Primitive2.equals(aSN1Primitive3))) {
            return false;
        }
        return this.externalContent.equals(aSN1External.externalContent);
    }

    @Override
    public int encodedLength() throws IOException {
        return this.getEncoded().length;
    }

    public final ASN1Primitive getObjFromVector(ASN1EncodableVector aSN1EncodableVector, int n2) {
        if (aSN1EncodableVector.elementCount > n2) {
            return aSN1EncodableVector.get(n2).toASN1Primitive();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    @Override
    public int hashCode() {
        ASN1Primitive aSN1Primitive;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        int n2 = aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier.hashCode() : 0;
        ASN1Integer aSN1Integer = this.indirectReference;
        if (aSN1Integer != null) {
            n2 ^= aSN1Integer.hashCode();
        }
        if ((aSN1Primitive = this.dataValueDescriptor) != null) {
            n2 ^= aSN1Primitive.hashCode();
        }
        return n2 ^ this.externalContent.hashCode();
    }

    @Override
    public boolean isConstructed() {
        return true;
    }

    public final void setEncoding(int n2) {
        if (n2 >= 0 && n2 <= 2) {
            this.encoding = n2;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline11((String)"invalid encoding value: ", (int)n2));
    }

    @Override
    public ASN1Primitive toDERObject() {
        DERExternal dERExternal = new DERExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
        return dERExternal;
    }

    @Override
    public ASN1Primitive toDLObject() {
        DLExternal dLExternal = new DLExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
        return dLExternal;
    }
}

