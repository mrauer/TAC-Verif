/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.DLSet
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.DLSet;
import org.bouncycastle.asn1.InMemoryRepresentable;

public class DLSetParser
implements ASN1Encodable,
InMemoryRepresentable {
    public ASN1StreamParser _parser;

    public DLSetParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DLSet(this._parser.readVector());
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            DLSet dLSet = new DLSet(this._parser.readVector());
            return dLSet;
        }
        catch (IOException iOException) {
            throw new ASN1ParsingException(iOException.getMessage(), iOException);
        }
    }
}

