/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.DLExternal
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.DLExternal;
import org.bouncycastle.asn1.InMemoryRepresentable;

public class DERExternalParser
implements ASN1Encodable,
InMemoryRepresentable {
    public ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    @Override
    public ASN1Primitive getLoadedObject() throws IOException {
        try {
            DLExternal dLExternal = new DLExternal(this._parser.readVector());
            return dLExternal;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ASN1Exception(illegalArgumentException.getMessage(), illegalArgumentException);
        }
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        try {
            ASN1Primitive aSN1Primitive = this.getLoadedObject();
            return aSN1Primitive;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ASN1ParsingException("unable to get DER object", illegalArgumentException);
        }
        catch (IOException iOException) {
            throw new ASN1ParsingException("unable to get DER object", iOException);
        }
    }
}

