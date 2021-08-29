/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.upokecenter.numbers.EInteger
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package com.upokecenter.cbor;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import com.upokecenter.cbor.CBOREncodeOptions;
import com.upokecenter.cbor.CBORException;
import com.upokecenter.cbor.CBORObject;
import com.upokecenter.cbor.StringRefs;
import com.upokecenter.numbers.EInteger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class CBORReader {
    public int depth;
    public final CBOREncodeOptions options;
    public final InputStream stream;
    public StringRefs stringRefs;

    public CBORReader(InputStream inputStream, CBOREncodeOptions cBOREncodeOptions) {
        this.stream = inputStream;
        this.options = cBOREncodeOptions;
    }

    /*
     * Exception decompiling
     */
    public static byte[] ReadByteData(InputStream var0, long var1, OutputStream var3) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public static long ReadDataLength(InputStream inputStream, int n2, int n3) throws IOException {
        return CBORReader.ReadDataLength(inputStream, n2, n3, true);
    }

    public static long ReadDataLength(InputStream inputStream, int n2, int n3, boolean bl) throws IOException {
        if (n2 >= 0) {
            if ((7 & n2 >> 5) == n3) {
                int n4 = n2 & 31;
                if (n4 < 24) {
                    return n4;
                }
                byte[] arrby = new byte[8];
                switch (n4) {
                    default: {
                        return n4;
                    }
                    case 31: {
                        throw new CBORException("Indefinite-length data not allowed here");
                    }
                    case 28: 
                    case 29: 
                    case 30: {
                        throw new CBORException("Unexpected data encountered");
                    }
                    case 27: {
                        if (inputStream.read(arrby, 0, 8) == 8) {
                            long l2 = (255L & (long)arrby[0]) << 56 | (255L & (long)arrby[1]) << 48 | (255L & (long)arrby[2]) << 40 | (255L & (long)arrby[3]) << 32 | (255L & (long)arrby[4]) << 24 | (255L & (long)arrby[5]) << 16 | (255L & (long)arrby[6]) << 8 | 255L & (long)arrby[7];
                            if (!bl) {
                                if (l2 >> 32 != 0L) {
                                    return l2;
                                }
                                throw new CBORException("Non-shortest CBOR form");
                            }
                            return l2;
                        }
                        throw new CBORException("Premature end of data");
                    }
                    case 26: {
                        if (inputStream.read(arrby, 0, 4) == 4) {
                            long l3 = (255L & (long)arrby[0]) << 24 | (255L & (long)arrby[1]) << 16 | (255L & (long)arrby[2]) << 8 | 255L & (long)arrby[3];
                            if (!bl) {
                                if (l3 >> 16 != 0L) {
                                    return l3;
                                }
                                throw new CBORException("Non-shortest CBOR form");
                            }
                            return l3;
                        }
                        throw new CBORException("Premature end of data");
                    }
                    case 25: {
                        if (inputStream.read(arrby, 0, 2) == 2) {
                            int n5 = (255 & arrby[0]) << 8 | 255 & arrby[1];
                            if (!bl && n5 < 256) {
                                throw new CBORException("Non-shortest CBOR form");
                            }
                            return n5;
                        }
                        throw new CBORException("Premature end of data");
                    }
                    case 24: 
                }
                int n6 = inputStream.read();
                if (n6 >= 0) {
                    if (!bl && n6 < 24) {
                        throw new CBORException("Non-shortest CBOR form");
                    }
                    return n6;
                }
                throw new CBORException("Premature end of data");
            }
            throw new CBORException("Unexpected data encountered");
        }
        throw new CBORException("Unexpected data encountered");
    }

    public static EInteger ToUnsignedEInteger(long l2) {
        EInteger eInteger = EInteger.FromInt64((long)(Long.MAX_VALUE & l2));
        if (l2 >> 63 != 0L) {
            eInteger = eInteger.Add(EInteger.FromInt32((int)1).ShiftLeft(63));
        }
        return eInteger;
    }

    /*
     * Exception decompiling
     */
    public CBORObject ReadForFirstByte(int var1) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public final CBORObject ReadInternal() throws IOException {
        if (this.depth <= 500) {
            int n2 = this.stream.read();
            if (n2 >= 0) {
                return this.ReadForFirstByte(n2);
            }
            throw new CBORException("Premature end of data");
        }
        throw new CBORException("Too deeply nested");
    }

    public final CBORObject ReadStringArrayMap(int n2, long l2) throws IOException {
        long l3;
        Objects.requireNonNull((Object)this.options);
        int n3 = Integer.MAX_VALUE;
        if (n2 == 2) {
            if (l2 >> 31 == l3) {
                if (l2 <= Integer.MAX_VALUE && l2 >> 63 == l3) {
                    n3 = (int)l2;
                }
                CBORObject cBORObject = new CBORObject(2, CBORReader.ReadByteData(this.stream, l2, null));
                StringRefs stringRefs = this.stringRefs;
                if (stringRefs != null) {
                    stringRefs.AddStringIfNeeded(cBORObject, n3);
                }
                return cBORObject;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Length of ");
            stringBuilder.append(CBORReader.ToUnsignedEInteger(l2).toString());
            stringBuilder.append(" is bigger than supported");
            throw new CBORException(stringBuilder.toString());
        }
        if (n2 == 3) {
            if (l2 >> 31 == l3) {
                InputStream inputStream = this.stream;
                int n4 = (int)l2;
                StringBuilder stringBuilder = new StringBuilder();
                int n5 = R.style.ReadUtf8((InputStream)inputStream, (int)n4, (StringBuilder)stringBuilder, (boolean)false);
                if (n5 != -2) {
                    if (n5 != -1) {
                        CBORObject cBORObject = new CBORObject(3, stringBuilder.toString());
                        StringRefs stringRefs = this.stringRefs;
                        if (stringRefs != null) {
                            if (l2 <= Integer.MAX_VALUE && l2 >> 63 == l3) {
                                n3 = n4;
                            }
                            stringRefs.AddStringIfNeeded(cBORObject, n3);
                        }
                        return cBORObject;
                    }
                    throw new CBORException("Invalid UTF-8");
                }
                throw new CBORException("Premature end of data");
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Length of ");
            stringBuilder.append(CBORReader.ToUnsignedEInteger(l2).toString());
            stringBuilder.append(" is bigger than supported");
            throw new CBORException(stringBuilder.toString());
        }
        if (n2 == 4) {
            Objects.requireNonNull((Object)this.options);
            CBORObject cBORObject = CBORObject.NewArray();
            if (l2 >> 31 == l3) {
                this.depth = 1 + this.depth;
                for (l3 = 0L; l3 < l2; ++l3) {
                    cBORObject.Add(this.ReadInternal());
                }
                this.depth = -1 + this.depth;
                return cBORObject;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Length of ");
            stringBuilder.append(CBORReader.ToUnsignedEInteger(l2).toString());
            stringBuilder.append(" is bigger than supported");
            throw new CBORException(stringBuilder.toString());
        }
        if (n2 == 5) {
            Objects.requireNonNull((Object)this.options);
            CBORObject cBORObject = CBORObject.NewMap();
            if (l2 >> 31 == l3) {
                while (l3 < l2) {
                    this.depth = 1 + this.depth;
                    CBORObject cBORObject2 = this.ReadInternal();
                    CBORObject cBORObject3 = this.ReadInternal();
                    this.depth = -1 + this.depth;
                    Objects.requireNonNull((Object)this.options);
                    Objects.requireNonNull((Object)this.options);
                    if (!cBORObject.ContainsKey(cBORObject2)) {
                        cBORObject.set(cBORObject2, cBORObject3);
                        ++l3;
                        continue;
                    }
                    throw new CBORException("Duplicate key already exists");
                }
                return cBORObject;
            }
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Length of ");
            stringBuilder.append(CBORReader.ToUnsignedEInteger(l2).toString());
            stringBuilder.append(" is bigger than supported");
            throw new CBORException(stringBuilder.toString());
        }
        return null;
    }
}

