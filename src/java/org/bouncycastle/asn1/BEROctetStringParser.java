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
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.ConstructedOctetStream;
import org.bouncycastle.util.io.Streams;

public class BEROctetStringParser
implements ASN1OctetStringParser {
    public ASN1StreamParser _parser;

    public BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        return new BEROctetString(Streams.readAll(this.getOctetStream()));
    }

    @Override
    public InputStream getOctetStream() {
        return new ConstructedOctetStream(this._parser);
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            ASN1Primitive aSN1Primitive = this.getLoadedObject();
            return aSN1Primitive;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"IOException converting stream to byte array: ");
            stringBuilder.append(iOException.getMessage());
            throw new ASN1ParsingException(stringBuilder.toString(), iOException);
        }
    }
}

