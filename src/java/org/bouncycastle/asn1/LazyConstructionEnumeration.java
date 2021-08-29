/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Enumeration
 *  java.util.NoSuchElementException
 *  org.bouncycastle.asn1.ASN1Primitive
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;

public class LazyConstructionEnumeration
implements Enumeration {
    public ASN1InputStream aIn;
    public Object nextObj;

    public LazyConstructionEnumeration(byte[] arrby) {
        this.aIn = new ASN1InputStream(arrby, true);
        this.nextObj = this.readObject();
    }

    public boolean hasMoreElements() {
        return this.nextObj != null;
    }

    public Object nextElement() {
        Object object = this.nextObj;
        if (object != null) {
            this.nextObj = this.readObject();
            return object;
        }
        throw new NoSuchElementException();
    }

    public final Object readObject() {
        try {
            ASN1Primitive aSN1Primitive = this.aIn.readObject();
            return aSN1Primitive;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("malformed DER construction: ");
            stringBuilder.append((Object)iOException);
            throw new ASN1ParsingException(stringBuilder.toString(), iOException);
        }
    }
}

