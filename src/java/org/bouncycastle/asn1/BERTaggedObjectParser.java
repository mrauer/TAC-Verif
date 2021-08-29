/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  org.bouncycastle.asn1.ASN1Primitive
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.InMemoryRepresentable;

public class BERTaggedObjectParser
implements ASN1Encodable,
InMemoryRepresentable {
    public boolean _constructed;
    public ASN1StreamParser _parser;
    public int _tagNumber;

    public BERTaggedObjectParser(boolean bl, int n2, ASN1StreamParser aSN1StreamParser) {
        this._constructed = bl;
        this._tagNumber = n2;
        this._parser = aSN1StreamParser;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.readTaggedObject(this._constructed, this._tagNumber);
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            ASN1Primitive aSN1Primitive = this.getLoadedObject();
            return aSN1Primitive;
        }
        catch (IOException iOException) {
            throw new ASN1ParsingException(iOException.getMessage());
        }
    }
}

