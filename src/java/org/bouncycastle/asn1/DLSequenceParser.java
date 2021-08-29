/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.DLSequence;

public class DLSequenceParser
implements ASN1SequenceParser {
    public ASN1StreamParser _parser;

    public DLSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DLSequence(this._parser.readVector());
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            DLSequence dLSequence = new DLSequence(this._parser.readVector());
            return dLSequence;
        }
        catch (IOException iOException) {
            throw new IllegalStateException(iOException.getMessage());
        }
    }
}

