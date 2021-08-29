/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.BERApplicationSpecificParser
 *  org.bouncycastle.asn1.BEROctetStringParser
 *  org.bouncycastle.asn1.BERSequence
 *  org.bouncycastle.asn1.BERSequenceParser
 *  org.bouncycastle.asn1.BERSetParser
 *  org.bouncycastle.asn1.BERTaggedObject
 *  org.bouncycastle.asn1.BERTaggedObjectParser
 *  org.bouncycastle.asn1.DERExternalParser
 *  org.bouncycastle.asn1.DEROctetString
 *  org.bouncycastle.asn1.DEROctetStringParser
 *  org.bouncycastle.asn1.DLApplicationSpecific
 *  org.bouncycastle.asn1.DLSequence
 *  org.bouncycastle.asn1.DLSequenceParser
 *  org.bouncycastle.asn1.DLSetParser
 *  org.bouncycastle.asn1.DLTaggedObject
 *  org.bouncycastle.asn1.DefiniteLengthInputStream
 *  org.bouncycastle.asn1.IndefiniteLengthInputStream
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERApplicationSpecificParser;
import org.bouncycastle.asn1.BERFactory;
import org.bouncycastle.asn1.BEROctetStringParser;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSequenceParser;
import org.bouncycastle.asn1.BERSetParser;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.BERTaggedObjectParser;
import org.bouncycastle.asn1.DERExternalParser;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROctetStringParser;
import org.bouncycastle.asn1.DLApplicationSpecific;
import org.bouncycastle.asn1.DLFactory;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLSequenceParser;
import org.bouncycastle.asn1.DLSetParser;
import org.bouncycastle.asn1.DLTaggedObject;
import org.bouncycastle.asn1.DefiniteLengthInputStream;
import org.bouncycastle.asn1.InMemoryRepresentable;
import org.bouncycastle.asn1.IndefiniteLengthInputStream;
import org.bouncycastle.asn1.StreamUtil;

public class ASN1StreamParser {
    public final InputStream _in;
    public final int _limit;
    public final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream inputStream) {
        int n2 = StreamUtil.findLimit(inputStream);
        this._in = inputStream;
        this._limit = n2;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1StreamParser(InputStream inputStream, int n2) {
        this._in = inputStream;
        this._limit = n2;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1Encodable readObject() throws IOException {
        boolean bl;
        InputStream inputStream;
        boolean bl2;
        int n2;
        int n3;
        int n4;
        int n5;
        block24 : {
            block23 : {
                n5 = this._in.read();
                if (n5 == -1) {
                    return null;
                }
                InputStream inputStream2 = this._in;
                if (inputStream2 instanceof IndefiniteLengthInputStream) {
                    IndefiniteLengthInputStream indefiniteLengthInputStream = (IndefiniteLengthInputStream)inputStream2;
                    indefiniteLengthInputStream._eofOn00 = false;
                    indefiniteLengthInputStream.checkForEof();
                }
                n3 = ASN1InputStream.readTagNumber(this._in, n5);
                bl2 = (n5 & 32) != 0;
                inputStream = this._in;
                n4 = this._limit;
                if (n3 == 4 || n3 == 16 || n3 == 17) break block23;
                bl = false;
                if (n3 != 8) break block24;
            }
            bl = true;
        }
        if ((n2 = ASN1InputStream.readLength(inputStream, n4, bl)) < 0) {
            if (bl2) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser((InputStream)new IndefiniteLengthInputStream(this._in, this._limit), this._limit);
                if ((n5 & 64) != 0) {
                    return new BERApplicationSpecificParser(n3, aSN1StreamParser);
                }
                if ((n5 & 128) != 0) {
                    return new BERTaggedObjectParser(true, n3, aSN1StreamParser);
                }
                if (n3 != 4) {
                    if (n3 != 8) {
                        if (n3 != 16) {
                            if (n3 == 17) {
                                return new BERSetParser(aSN1StreamParser);
                            }
                            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown BER object encountered: 0x");
                            stringBuilder.append(Integer.toHexString((int)n3));
                            throw new ASN1Exception(stringBuilder.toString());
                        }
                        return new BERSequenceParser(aSN1StreamParser);
                    }
                    return new DERExternalParser(aSN1StreamParser);
                }
                return new BEROctetStringParser(aSN1StreamParser);
            }
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this._in, n2, this._limit);
        if ((n5 & 64) != 0) {
            return new DLApplicationSpecific(bl2, n3, definiteLengthInputStream.toByteArray());
        }
        if ((n5 & 128) != 0) {
            return new BERTaggedObjectParser(bl2, n3, new ASN1StreamParser((InputStream)definiteLengthInputStream));
        }
        if (bl2) {
            if (n3 != 4) {
                if (n3 != 8) {
                    if (n3 != 16) {
                        if (n3 == 17) {
                            return new DLSetParser(new ASN1StreamParser((InputStream)definiteLengthInputStream));
                        }
                        throw new IOException(GeneratedOutlineSupport.outline12((String)"unknown tag ", (int)n3, (String)" encountered"));
                    }
                    return new DLSequenceParser(new ASN1StreamParser((InputStream)definiteLengthInputStream));
                }
                return new DERExternalParser(new ASN1StreamParser((InputStream)definiteLengthInputStream));
            }
            return new BEROctetStringParser(new ASN1StreamParser((InputStream)definiteLengthInputStream));
        }
        if (n3 != 4) {
            try {
                ASN1Primitive aSN1Primitive = ASN1InputStream.createPrimitiveDERObject(n3, definiteLengthInputStream, this.tmpBuffers);
                return aSN1Primitive;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new ASN1Exception("corrupted stream detected", illegalArgumentException);
            }
        }
        return new DEROctetStringParser(definiteLengthInputStream);
    }

    public ASN1Primitive readTaggedObject(boolean bl, int n2) throws IOException {
        if (!bl) {
            return new DLTaggedObject(false, n2, (ASN1Encodable)new DEROctetString(((DefiniteLengthInputStream)this._in).toByteArray()));
        }
        ASN1EncodableVector aSN1EncodableVector = this.readVector();
        if (this._in instanceof IndefiniteLengthInputStream) {
            int n3 = aSN1EncodableVector.elementCount;
            if (n3 == 1) {
                return new BERTaggedObject(true, n2, aSN1EncodableVector.get(0));
            }
            BERSequence bERSequence = n3 < 1 ? BERFactory.EMPTY_SEQUENCE : new BERSequence(aSN1EncodableVector);
            return new BERTaggedObject(false, n2, (ASN1Encodable)bERSequence);
        }
        int n4 = aSN1EncodableVector.elementCount;
        if (n4 == 1) {
            return new DLTaggedObject(true, n2, aSN1EncodableVector.get(0));
        }
        Object object = n4 < 1 ? DLFactory.EMPTY_SEQUENCE : new DLSequence(aSN1EncodableVector);
        return new DLTaggedObject(false, n2, (ASN1Encodable)object);
    }

    public ASN1EncodableVector readVector() throws IOException {
        ASN1Encodable aSN1Encodable = this.readObject();
        if (aSN1Encodable == null) {
            return new ASN1EncodableVector(0);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        do {
            ASN1Primitive aSN1Primitive = aSN1Encodable instanceof InMemoryRepresentable ? ((InMemoryRepresentable)((Object)aSN1Encodable)).getLoadedObject() : aSN1Encodable.toASN1Primitive();
            aSN1EncodableVector.add((ASN1Encodable)aSN1Primitive);
        } while ((aSN1Encodable = this.readObject()) != null);
        return aSN1EncodableVector;
    }
}

