/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.bouncycastle.asn1.x9;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x9.X9ECParameters;

public class X962Parameters
extends ASN1Object {
    public ASN1Primitive params = null;

    public X962Parameters(ASN1Null aSN1Null) {
        this.params = aSN1Null;
    }

    public X962Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.params = aSN1ObjectIdentifier;
    }

    public X962Parameters(ASN1Primitive aSN1Primitive) {
        this.params = aSN1Primitive;
    }

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.params = x9ECParameters.toASN1Primitive();
    }

    public static X962Parameters getInstance(Object object) {
        if (object != null && !(object instanceof X962Parameters)) {
            if (object instanceof ASN1Primitive) {
                return new X962Parameters((ASN1Primitive)object);
            }
            if (object instanceof byte[]) {
                try {
                    X962Parameters x962Parameters = new X962Parameters(ASN1Primitive.fromByteArray((byte[])object));
                    return x962Parameters;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unable to parse encoded data: ");
                    stringBuilder.append(exception.getMessage());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
        return (X962Parameters)object;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        return this.params;
    }
}

