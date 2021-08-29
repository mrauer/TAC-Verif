/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DefiniteLengthInputStream;

public class DEROctetStringParser
implements ASN1OctetStringParser {
    public DefiniteLengthInputStream stream;

    public DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.stream = definiteLengthInputStream;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DEROctetString(this.stream.toByteArray());
    }

    @Override
    public InputStream getOctetStream() {
        return this.stream;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            DEROctetString dEROctetString = new DEROctetString(this.stream.toByteArray());
            return dEROctetString;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"IOException converting stream to byte array: ");
            stringBuilder.append(iOException.getMessage());
            throw new ASN1ParsingException(stringBuilder.toString(), iOException);
        }
    }
}

