/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.BERApplicationSpecific
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.InMemoryRepresentable;

public class BERApplicationSpecificParser
implements ASN1Encodable,
InMemoryRepresentable {
    public final ASN1StreamParser parser;
    public final int tag;

    public BERApplicationSpecificParser(int n2, ASN1StreamParser aSN1StreamParser) {
        this.tag = n2;
        this.parser = aSN1StreamParser;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        return new BERApplicationSpecific(this.tag, this.parser.readVector());
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            ASN1Primitive aSN1Primitive = this.getLoadedObject();
            return aSN1Primitive;
        }
        catch (IOException iOException) {
            throw new ASN1ParsingException(iOException.getMessage(), iOException);
        }
    }
}

