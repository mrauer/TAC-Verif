/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayInputStream
 *  java.io.EOFException
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.bouncycastle.asn1.ASN1OctetString
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.BERApplicationSpecific
 *  org.bouncycastle.asn1.BEROctetString
 *  org.bouncycastle.asn1.BERSequence
 *  org.bouncycastle.asn1.BERSet
 *  org.bouncycastle.asn1.DLApplicationSpecific
 *  org.bouncycastle.asn1.DLExternal
 *  org.bouncycastle.asn1.DLSequence
 *  org.bouncycastle.asn1.DLSet
 *  org.bouncycastle.asn1.DefiniteLengthInputStream
 *  org.bouncycastle.asn1.IndefiniteLengthInputStream
 *  org.bouncycastle.asn1.LazyEncodedSequence
 */
package org.bouncycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.ConstructedOctetStream;
import org.bouncycastle.asn1.DLApplicationSpecific;
import org.bouncycastle.asn1.DLExternal;
import org.bouncycastle.asn1.DLFactory;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLSet;
import org.bouncycastle.asn1.DefiniteLengthInputStream;
import org.bouncycastle.asn1.IndefiniteLengthInputStream;
import org.bouncycastle.asn1.LazyEncodedSequence;
import org.bouncycastle.asn1.LimitedInputStream;
import org.bouncycastle.asn1.StreamUtil;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream
extends FilterInputStream {
    public final boolean lazyEvaluate;
    public final int limit;
    public final byte[][] tmpBuffers;

    public ASN1InputStream(InputStream inputStream) {
        int n2 = StreamUtil.findLimit(inputStream);
        super(inputStream);
        this.limit = n2;
        this.lazyEvaluate = false;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1InputStream(byte[] arrby) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        int n2 = arrby.length;
        super((InputStream)byteArrayInputStream);
        this.limit = n2;
        this.lazyEvaluate = false;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1InputStream(byte[] arrby, boolean bl) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        int n2 = arrby.length;
        super((InputStream)byteArrayInputStream);
        this.limit = n2;
        this.lazyEvaluate = bl;
        this.tmpBuffers = new byte[11][];
    }

    /*
     * Exception decompiling
     */
    public static ASN1Primitive createPrimitiveDERObject(int var0, DefiniteLengthInputStream var1_1, byte[][] var2_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 8[SWITCH]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public static byte[] getBuffer(DefiniteLengthInputStream definiteLengthInputStream, byte[][] arrby) throws IOException {
        int n2 = definiteLengthInputStream._remaining;
        if (n2 >= arrby.length) {
            return definiteLengthInputStream.toByteArray();
        }
        byte[] arrby2 = arrby[n2];
        if (arrby2 == null) {
            arrby2 = new byte[n2];
            arrby[n2] = arrby2;
        }
        if (n2 == arrby2.length) {
            if (n2 == 0) {
                return arrby2;
            }
            int n3 = definiteLengthInputStream._limit;
            if (n2 < n3) {
                int n4;
                definiteLengthInputStream._remaining = n4 = n2 - Streams.readFully(definiteLengthInputStream._in, arrby2, 0, arrby2.length);
                if (n4 == 0) {
                    definiteLengthInputStream.setParentEofDetect(true);
                    return arrby2;
                }
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DEF length ");
                stringBuilder.append(definiteLengthInputStream._originalLength);
                stringBuilder.append(" object truncated by ");
                stringBuilder.append(definiteLengthInputStream._remaining);
                throw new EOFException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"corrupted stream - out of bounds length found: ");
            stringBuilder.append(definiteLengthInputStream._remaining);
            stringBuilder.append(" >= ");
            stringBuilder.append(n3);
            throw new IOException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("buffer length not right for data");
    }

    public static int readLength(InputStream inputStream, int n2, boolean bl) throws IOException {
        int n3 = inputStream.read();
        if (n3 >= 0) {
            if (n3 == 128) {
                return -1;
            }
            if (n3 > 127) {
                int n4 = n3 & 127;
                if (n4 <= 4) {
                    int n5 = 0;
                    for (int i2 = 0; i2 < n4; ++i2) {
                        int n6 = inputStream.read();
                        if (n6 >= 0) {
                            n5 = n6 + (n5 << 8);
                            continue;
                        }
                        throw new EOFException("EOF found reading length");
                    }
                    if (n5 >= 0) {
                        if (n5 >= n2 && !bl) {
                            throw new IOException(GeneratedOutlineSupport.outline13((String)"corrupted stream - out of bounds length found: ", (int)n5, (String)" >= ", (int)n2));
                        }
                        return n5;
                    }
                    throw new IOException("corrupted stream - negative length found");
                }
                throw new IOException(GeneratedOutlineSupport.outline11((String)"DER length more than 4 bytes: ", (int)n4));
            }
            return n3;
        }
        throw new EOFException("EOF found when length expected");
    }

    public static int readTagNumber(InputStream inputStream, int n2) throws IOException {
        int n3 = n2 & 31;
        if (n3 == 31) {
            int n4 = inputStream.read();
            int n5 = n4 & 127;
            int n6 = 0;
            if (n5 != 0) {
                while (n4 >= 0 && (n4 & 128) != 0) {
                    n6 = (n6 | n4 & 127) << 7;
                    n4 = inputStream.read();
                }
                if (n4 >= 0) {
                    return n6 | n4 & 127;
                }
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        return n3;
    }

    public ASN1Primitive buildObject(int n2, int n3, int n4) throws IOException {
        int n5 = n2 & 32;
        boolean bl = n5 != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream((InputStream)this, n4, this.limit);
        if ((n2 & 64) != 0) {
            return new DLApplicationSpecific(bl, n3, definiteLengthInputStream.toByteArray());
        }
        if ((n2 & 128) != 0) {
            return new ASN1StreamParser((InputStream)definiteLengthInputStream).readTaggedObject(bl, n3);
        }
        if (bl) {
            if (n3 != 4) {
                if (n3 != 8) {
                    if (n3 != 16) {
                        if (n3 == 17) {
                            ASN1EncodableVector aSN1EncodableVector = this.readVector(definiteLengthInputStream);
                            if (aSN1EncodableVector.elementCount < 1) {
                                return DLFactory.EMPTY_SET;
                            }
                            return new DLSet(aSN1EncodableVector);
                        }
                        throw new IOException(GeneratedOutlineSupport.outline12((String)"unknown tag ", (int)n3, (String)" encountered"));
                    }
                    if (this.lazyEvaluate) {
                        return new LazyEncodedSequence(definiteLengthInputStream.toByteArray());
                    }
                    ASN1EncodableVector aSN1EncodableVector = this.readVector(definiteLengthInputStream);
                    if (aSN1EncodableVector.elementCount < 1) {
                        return DLFactory.EMPTY_SEQUENCE;
                    }
                    return new DLSequence(aSN1EncodableVector);
                }
                return new DLExternal(this.readVector(definiteLengthInputStream));
            }
            ASN1EncodableVector aSN1EncodableVector = this.readVector(definiteLengthInputStream);
            int n6 = aSN1EncodableVector.elementCount;
            ASN1OctetString[] arraSN1OctetString = new ASN1OctetString[n6];
            for (int i2 = 0; i2 != n6; ++i2) {
                ASN1Encodable aSN1Encodable = aSN1EncodableVector.get(i2);
                if (aSN1Encodable instanceof ASN1OctetString) {
                    arraSN1OctetString[i2] = (ASN1OctetString)aSN1Encodable;
                    continue;
                }
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unknown object encountered in constructed OCTET STRING: ");
                stringBuilder.append((Object)aSN1Encodable.getClass());
                throw new ASN1Exception(stringBuilder.toString());
            }
            return new BEROctetString(arraSN1OctetString);
        }
        return ASN1InputStream.createPrimitiveDERObject(n3, definiteLengthInputStream, this.tmpBuffers);
    }

    public ASN1Primitive readObject() throws IOException {
        int n2 = this.read();
        if (n2 <= 0) {
            if (n2 != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int n3 = ASN1InputStream.readTagNumber((InputStream)this, n2);
        boolean bl = (n2 & 32) != 0;
        int n4 = ASN1InputStream.readLength((InputStream)this, this.limit, false);
        if (n4 < 0) {
            if (bl) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser((InputStream)new IndefiniteLengthInputStream((InputStream)this, this.limit), this.limit);
                if ((n2 & 64) != 0) {
                    return new BERApplicationSpecific(n3, aSN1StreamParser.readVector());
                }
                if ((n2 & 128) != 0) {
                    return aSN1StreamParser.readTaggedObject(true, n3);
                }
                if (n3 != 4) {
                    if (n3 != 8) {
                        if (n3 != 16) {
                            if (n3 == 17) {
                                return new BERSet(aSN1StreamParser.readVector());
                            }
                            throw new IOException("unknown BER object encountered");
                        }
                        return new BERSequence(aSN1StreamParser.readVector());
                    }
                    try {
                        DLExternal dLExternal = new DLExternal(aSN1StreamParser.readVector());
                        return dLExternal;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new ASN1Exception(illegalArgumentException.getMessage(), illegalArgumentException);
                    }
                }
                return new BEROctetString(Streams.readAll(new ConstructedOctetStream(aSN1StreamParser)));
            }
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        try {
            ASN1Primitive aSN1Primitive = this.buildObject(n2, n3, n4);
            return aSN1Primitive;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ASN1Exception("corrupted stream detected", illegalArgumentException);
        }
    }

    public ASN1EncodableVector readVector(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        ASN1Primitive aSN1Primitive;
        if (definiteLengthInputStream._remaining < 1) {
            return new ASN1EncodableVector(0);
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream)definiteLengthInputStream);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        while ((aSN1Primitive = aSN1InputStream.readObject()) != null) {
            aSN1EncodableVector.add((ASN1Encodable)aSN1Primitive);
        }
        return aSN1EncodableVector;
    }
}

