/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  B
 *  I
 *  S
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.DataInput
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.PrintStream
 *  java.lang.ArithmeticException
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.math.BigInteger
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1BitString
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.asn1.ASN1OctetString
 *  org.bouncycastle.asn1.ASN1Primitive
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.DERNull
 *  org.bouncycastle.asn1.DEROctetString
 *  org.bouncycastle.asn1.pkcs.PrivateKeyInfo
 *  org.bouncycastle.asn1.x509.AlgorithmIdentifier
 *  org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
 *  org.bouncycastle.crypto.digests.SHA1Digest
 *  org.bouncycastle.crypto.digests.SHA224Digest
 *  org.bouncycastle.crypto.digests.SHA256Digest
 *  org.bouncycastle.crypto.digests.SHA384Digest
 *  org.bouncycastle.crypto.digests.SHA512Digest
 *  org.bouncycastle.pqc.asn1.SPHINCS256KeyParams
 *  org.bouncycastle.pqc.asn1.XMSSKeyParams
 *  org.bouncycastle.pqc.asn1.XMSSMTKeyParams
 *  org.bouncycastle.pqc.asn1.XMSSMTPrivateKey
 *  org.bouncycastle.pqc.asn1.XMSSMTPublicKey
 *  org.bouncycastle.pqc.asn1.XMSSPrivateKey
 *  org.bouncycastle.pqc.asn1.XMSSPublicKey
 *  org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters
 *  org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters
 *  org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters
 *  org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.HashTreeAddress
 *  org.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
 *  org.bouncycastle.pqc.crypto.xmss.LTreeAddress
 *  org.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder
 *  org.bouncycastle.pqc.crypto.xmss.XMSSKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters
 *  org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters
 *  org.joda.time.DateTimeField
 *  org.joda.time.DateTimeFieldType
 *  org.joda.time.DateTimeZone
 *  org.joda.time.IllegalFieldValueException
 *  org.joda.time.field.BaseDateTimeField
 *  org.joda.time.format.DateTimeFormatter
 *  org.joda.time.format.ISODateTimeFormat
 *  org.joda.time.format.ISODateTimeFormat$Constants
 *  org.joda.time.tz.CachedDateTimeZone
 *  org.joda.time.tz.DateTimeZoneBuilder
 *  org.joda.time.tz.DateTimeZoneBuilder$PrecalculatedZone
 *  org.joda.time.tz.FixedDateTimeZone
 */
package org.bouncycastle.math.raw;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.asn1.XMSSKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTPrivateKey;
import org.bouncycastle.pqc.asn1.XMSSMTPublicKey;
import org.bouncycastle.pqc.asn1.XMSSPrivateKey;
import org.bouncycastle.pqc.asn1.XMSSPublicKey;
import org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.Utils;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.DigestUtil;
import org.bouncycastle.pqc.crypto.xmss.HashTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.KeyedHashFunctions;
import org.bouncycastle.pqc.crypto.xmss.LTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlus;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusParameters;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSNode;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSUtil$CheckingStream;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.tz.CachedDateTimeZone;
import org.joda.time.tz.DateTimeZoneBuilder;
import org.joda.time.tz.FixedDateTimeZone;

public abstract class Nat576 {
    public static void I2OSP(int n2, byte[] arrby, int n3) {
        int n4 = n3 + 1;
        arrby[n3] = (byte)n2;
        int n5 = n4 + 1;
        arrby[n4] = (byte)(n2 >>> 8);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(n2 >>> 16);
        arrby[n6] = (byte)(n2 >>> 24);
    }

    public static int OS2IP(byte[] arrby, int n2) {
        int n3 = n2 + 1;
        int n4 = 255 & arrby[n2];
        int n5 = n3 + 1;
        int n6 = n4 | (255 & arrby[n3]) << 8;
        int n7 = n5 + 1;
        return n6 | (255 & arrby[n5]) << 16 | (255 & arrby[n7]) << 24;
    }

    public static int add(int n2, int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = l2 + ((0xFFFFFFFFL & (long)arrn[i2]) + (0xFFFFFFFFL & (long)arrn2[i2]));
            arrn3[i2] = (int)l3;
            l2 = l3 >>> 32;
        }
        return (int)l2;
    }

    public static int add33To(int n2, int n3, int[] arrn) {
        long l2 = (0xFFFFFFFFL & (long)arrn[0]) + (0xFFFFFFFFL & (long)n3);
        arrn[0] = (int)l2;
        long l3 = (l2 >>> 32) + (1L + (0xFFFFFFFFL & (long)arrn[1]));
        arrn[1] = (int)l3;
        if (l3 >>> 32 == 0L) {
            return 0;
        }
        return Nat576.incAt(n2, arrn, 2);
    }

    public static int addBothTo(int n2, int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = l2 + ((0xFFFFFFFFL & (long)arrn[i2]) + (0xFFFFFFFFL & (long)arrn2[i2]) + (0xFFFFFFFFL & (long)arrn3[i2]));
            arrn3[i2] = (int)l3;
            l2 = l3 >>> 32;
        }
        return (int)l2;
    }

    public static int addTo(int n2, int[] arrn, int n3, int[] arrn2, int n4) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = 0xFFFFFFFFL & (long)arrn[n3 + i2];
            int n5 = n4 + i2;
            long l4 = l2 + (l3 + (0xFFFFFFFFL & (long)arrn2[n5]));
            arrn2[n5] = (int)l4;
            l2 = l4 >>> 32;
        }
        return (int)l2;
    }

    public static int addTo(int n2, int[] arrn, int[] arrn2) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = l2 + ((0xFFFFFFFFL & (long)arrn[i2]) + (0xFFFFFFFFL & (long)arrn2[i2]));
            arrn2[i2] = (int)l3;
            l2 = l3 >>> 32;
        }
        return (int)l2;
    }

    public static int addWordAt(int n2, int n3, int[] arrn, int n4) {
        long l2 = (0xFFFFFFFFL & (long)n3) + (0xFFFFFFFFL & (long)arrn[n4]);
        arrn[n4] = (int)l2;
        if (l2 >>> 32 == 0L) {
            return 0;
        }
        return Nat576.incAt(n2, arrn, n4 + 1);
    }

    public static int addWordTo(int n2, int n3, int[] arrn) {
        long l2 = (0xFFFFFFFFL & (long)n3) + (0xFFFFFFFFL & (long)arrn[0]);
        arrn[0] = (int)l2;
        if (l2 >>> 32 == 0L) {
            return 0;
        }
        return Nat576.incAt(n2, arrn, 1);
    }

    public static int bigEndianToInt(byte[] arrby, int n2) {
        int n3 = arrby[n2] << 24;
        int n4 = n2 + 1;
        int n5 = n3 | (255 & arrby[n4]) << 16;
        int n6 = n4 + 1;
        return n5 | (255 & arrby[n6]) << 8 | 255 & arrby[n6 + 1];
    }

    public static void byteArray(byte[] arrby, Digest digest) {
        digest.update(arrby, 0, arrby.length);
    }

    public static long bytesToXBigEndian(byte[] arrby, int n2, int n3) {
        Objects.requireNonNull((Object)arrby, (String)"in == null");
        long l2 = 0L;
        for (int i2 = n2; i2 < n2 + n3; ++i2) {
            l2 = l2 << 8 | (long)(255 & arrby[i2]);
        }
        return l2;
    }

    public static byte[] clone(byte[] arrby) {
        if (arrby == null) {
            return null;
        }
        return (byte[])arrby.clone();
    }

    public static int[] clone(int[] arrn) {
        int[] arrn2 = new int[arrn.length];
        System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
        return arrn2;
    }

    public static short[] clone(short[] arrs) {
        if (arrs == null) {
            return null;
        }
        return (short[])arrs.clone();
    }

    public static byte[] cloneArray(byte[] arrby) {
        Objects.requireNonNull((Object)arrby, (String)"in == null");
        byte[] arrby2 = new byte[arrby.length];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)arrby.length);
        return arrby2;
    }

    public static byte[][] cloneArray(byte[][] arrby) {
        if (!Nat576.hasNullPointer(arrby)) {
            byte[][] arrarrby = new byte[arrby.length][];
            for (int i2 = 0; i2 < arrby.length; ++i2) {
                arrarrby[i2] = new byte[arrby[i2].length];
                System.arraycopy((Object)arrby[i2], (int)0, (Object)arrarrby[i2], (int)0, (int)arrby[i2].length);
            }
            return arrarrby;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static byte[] concatenate(byte[] arrby, byte[] arrby2) {
        if (arrby == null) {
            return Nat576.clone(arrby2);
        }
        if (arrby2 == null) {
            return Nat576.clone(arrby);
        }
        byte[] arrby3 = new byte[arrby.length + arrby2.length];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby3, (int)0, (int)arrby.length);
        System.arraycopy((Object)arrby2, (int)0, (Object)arrby3, (int)arrby.length, (int)arrby2.length);
        return arrby3;
    }

    public static byte[] convertArray(short[] arrs) {
        byte[] arrby = new byte[arrs.length];
        for (int i2 = 0; i2 < arrs.length; ++i2) {
            arrby[i2] = (byte)arrs[i2];
        }
        return arrby;
    }

    public static short[] convertArray(byte[] arrby) {
        short[] arrs = new short[arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            arrs[i2] = (short)(255 & arrby[i2]);
        }
        return arrs;
    }

    public static byte[][] convertArray(short[][] arrs) {
        int n2 = arrs.length;
        int n3 = arrs[0].length;
        int[] arrn = new int[2];
        arrn[1] = n3;
        arrn[0] = n2;
        byte[][] arrby = (byte[][])Array.newInstance(B.class, (int[])arrn);
        for (int i2 = 0; i2 < arrs.length; ++i2) {
            for (int i3 = 0; i3 < arrs[0].length; ++i3) {
                arrby[i2][i3] = (byte)arrs[i2][i3];
            }
        }
        return arrby;
    }

    public static short[][] convertArray(byte[][] arrby) {
        int n2 = arrby.length;
        int n3 = arrby[0].length;
        int[] arrn = new int[2];
        arrn[1] = n3;
        arrn[0] = n2;
        short[][] arrs = (short[][])Array.newInstance(S.class, (int[])arrn);
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            for (int i3 = 0; i3 < arrby[0].length; ++i3) {
                arrs[i2][i3] = (short)(255 & arrby[i2][i3]);
            }
        }
        return arrs;
    }

    public static byte[][][] convertArray(short[][][] arrs) {
        int n2 = arrs.length;
        int n3 = arrs[0].length;
        int n4 = arrs[0][0].length;
        int[] arrn = new int[3];
        arrn[2] = n4;
        arrn[1] = n3;
        arrn[0] = n2;
        byte[][][] arrby = (byte[][][])Array.newInstance(B.class, (int[])arrn);
        for (int i2 = 0; i2 < arrs.length; ++i2) {
            for (int i3 = 0; i3 < arrs[0].length; ++i3) {
                for (int i4 = 0; i4 < arrs[0][0].length; ++i4) {
                    arrby[i2][i3][i4] = (byte)arrs[i2][i3][i4];
                }
            }
        }
        return arrby;
    }

    public static short[][][] convertArray(byte[][][] arrby) {
        int n2 = arrby.length;
        int n3 = arrby[0].length;
        int n4 = arrby[0][0].length;
        int[] arrn = new int[3];
        arrn[2] = n4;
        arrn[1] = n3;
        arrn[0] = n2;
        short[][][] arrs = (short[][][])Array.newInstance(S.class, (int[])arrn);
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            for (int i3 = 0; i3 < arrby[0].length; ++i3) {
                for (int i4 = 0; i4 < arrby[0][0].length; ++i4) {
                    arrs[i2][i3][i4] = (short)(255 & arrby[i2][i3][i4]);
                }
            }
        }
        return arrs;
    }

    public static void copy64(long[] arrl, int n2, long[] arrl2, int n3) {
        arrl2[n3 + 0] = arrl[n2 + 0];
        arrl2[n3 + 1] = arrl[n2 + 1];
        arrl2[n3 + 2] = arrl[n2 + 2];
        arrl2[n3 + 3] = arrl[n2 + 3];
        arrl2[n3 + 4] = arrl[n2 + 4];
        arrl2[n3 + 5] = arrl[n2 + 5];
        arrl2[n3 + 6] = arrl[n2 + 6];
        arrl2[n3 + 7] = arrl[n2 + 7];
        arrl2[n3 + 8] = arrl[n2 + 8];
    }

    public static void copyBytesAtOffset(byte[] arrby, byte[] arrby2, int n2) {
        Objects.requireNonNull((Object)arrby2, (String)"src == null");
        if (n2 >= 0) {
            if (n2 + arrby2.length <= arrby.length) {
                for (int i2 = 0; i2 < arrby2.length; ++i2) {
                    arrby[n2 + i2] = arrby2[i2];
                }
                return;
            }
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        throw new IllegalArgumentException("offset hast to be >= 0");
    }

    public static byte[] copyOfRange(byte[] arrby, int n2, int n3) {
        int n4 = Nat576.getLength(n2, n3);
        byte[] arrby2 = new byte[n4];
        System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)Math.min((int)(arrby.length - n2), (int)n4));
        return arrby2;
    }

    public static GF2Matrix createCanonicalCheckMatrix(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int n2 = gF2mField.degree;
        int n3 = 1 << n2;
        int n4 = polynomialGF2mSmallM.getDegree();
        int[] arrn = new int[2];
        arrn[1] = n3;
        arrn[0] = n4;
        int[][] arrn2 = (int[][])Array.newInstance(I.class, (int[])arrn);
        int[] arrn3 = new int[2];
        arrn3[1] = n3;
        arrn3[0] = n4;
        int[][] arrn4 = (int[][])Array.newInstance(I.class, (int[])arrn3);
        for (int i2 = 0; i2 < n3; ++i2) {
            int[] arrn5 = arrn4[0];
            int[] arrn6 = polynomialGF2mSmallM.coefficients;
            int n5 = polynomialGF2mSmallM.degree;
            int n6 = arrn6[n5];
            while (--n5 >= 0) {
                n6 = polynomialGF2mSmallM.field.mult(n6, i2) ^ polynomialGF2mSmallM.coefficients[n5];
            }
            arrn5[i2] = gF2mField.inverse(n6);
        }
        for (int i3 = 1; i3 < n4; ++i3) {
            for (int i4 = 0; i4 < n3; ++i4) {
                arrn4[i3][i4] = gF2mField.mult(arrn4[i3 - 1][i4], i4);
            }
        }
        for (int i5 = 0; i5 < n4; ++i5) {
            for (int i6 = 0; i6 < n3; ++i6) {
                for (int i7 = 0; i7 <= i5; ++i7) {
                    arrn2[i5][i6] = arrn2[i5][i6] ^ gF2mField.mult(arrn4[i7][i6], polynomialGF2mSmallM.getCoefficient(n4 + i7 - i5));
                }
            }
        }
        int n7 = n4 * n2;
        int n8 = n3 + 31 >>> 5;
        int[] arrn7 = new int[2];
        arrn7[1] = n8;
        arrn7[0] = n7;
        int[][] arrn8 = (int[][])Array.newInstance(I.class, (int[])arrn7);
        for (int i8 = 0; i8 < n3; ++i8) {
            int n9 = i8 >>> 5;
            int n10 = 1 << (i8 & 31);
            for (int i9 = 0; i9 < n4; ++i9) {
                int n11 = arrn2[i9][i8];
                for (int i10 = 0; i10 < n2; ++i10) {
                    if ((1 & n11 >>> i10) == 0) continue;
                    int[] arrn9 = arrn8[n2 * (i9 + 1) - i10 - 1];
                    arrn9[n9] = n10 ^ arrn9[n9];
                }
            }
        }
        return new GF2Matrix(n3, arrn8);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AsymmetricKeyParameter createKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.privateKeyAlgorithm.algorithm;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.qTESLA;
        String string = aSN1ObjectIdentifier.identifier;
        String string2 = aSN1ObjectIdentifier2.identifier;
        int n2 = string.length();
        int n3 = string2.length();
        int n4 = 0;
        boolean bl = n2 > n3 && string.charAt(string2.length()) == '.' && string.startsWith(string2);
        if (bl) {
            ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance((Object)privateKeyInfo.parsePrivateKey());
            AlgorithmIdentifier algorithmIdentifier = privateKeyInfo.privateKeyAlgorithm;
            return new QTESLAPrivateKeyParameters(((Integer)Utils.categories.get((Object)algorithmIdentifier.algorithm)).intValue(), aSN1OctetString.string);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)BCObjectIdentifiers.sphincs256)) {
            return new SPHINCSPrivateKeyParameters(ASN1OctetString.getInstance((Object)privateKeyInfo.parsePrivateKey()).string, Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance((Object)privateKeyInfo.privateKeyAlgorithm.parameters)));
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)BCObjectIdentifiers.newHope)) {
            byte[] arrby = ASN1OctetString.getInstance((Object)privateKeyInfo.parsePrivateKey()).string;
            int n5 = arrby.length / 2;
            short[] arrs = new short[n5];
            do {
                if (n4 == n5) {
                    return new NHPrivateKeyParameters(arrs);
                }
                int n6 = n4 * 2;
                arrs[n4] = (short)(255 & arrby[n6] | (255 & arrby[n6 + 1]) << 8);
                ++n4;
            } while (true);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)PKCSObjectIdentifiers.id_alg_hss_lms_hashsig)) {
            byte[] arrby = ASN1OctetString.getInstance((Object)privateKeyInfo.parsePrivateKey()).string;
            ASN1BitString aSN1BitString = privateKeyInfo.publicKey;
            if (Nat576.bigEndianToInt(arrby, 0) == 1) {
                if (aSN1BitString == null) return LMSPrivateKeyParameters.getInstance((Object)Nat576.copyOfRange(arrby, 4, arrby.length));
                byte[] arrby2 = aSN1BitString.getOctets();
                byte[] arrby3 = Nat576.copyOfRange(arrby, 4, arrby.length);
                byte[] arrby4 = Nat576.copyOfRange(arrby2, 4, arrby2.length);
                LMSPrivateKeyParameters lMSPrivateKeyParameters = LMSPrivateKeyParameters.getInstance((Object)arrby3);
                lMSPrivateKeyParameters.publicKey = LMSPublicKeyParameters.getInstance((Object)arrby4);
                return lMSPrivateKeyParameters;
            }
            if (aSN1BitString == null) return HSSPrivateKeyParameters.getInstance((Object)Nat576.copyOfRange(arrby, 4, arrby.length));
            byte[] arrby5 = aSN1BitString.getOctets();
            HSSPrivateKeyParameters hSSPrivateKeyParameters = HSSPrivateKeyParameters.getInstance((Object)Nat576.copyOfRange(arrby, 4, arrby.length));
            HSSPublicKeyParameters.getInstance((Object)arrby5);
            Objects.requireNonNull((Object)hSSPrivateKeyParameters);
            return hSSPrivateKeyParameters;
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive)BCObjectIdentifiers.xmss)) {
            XMSSKeyParams xMSSKeyParams = XMSSKeyParams.getInstance((Object)privateKeyInfo.privateKeyAlgorithm.parameters);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = xMSSKeyParams.treeDigest.algorithm;
            ASN1Encodable aSN1Encodable = privateKeyInfo.parsePrivateKey();
            if (aSN1Encodable instanceof XMSSPrivateKey) {
                XMSSPrivateKey xMSSPrivateKey = (XMSSPrivateKey)aSN1Encodable;
            } else if (aSN1Encodable != null) {
                XMSSPrivateKey xMSSPrivateKey = new XMSSPrivateKey(ASN1Sequence.getInstance((Object)aSN1Encodable));
            } else {
                Object var23_28 = null;
            }
            try {
                void var23_29;
                XMSSPrivateKeyParameters.Builder builder = new XMSSPrivateKeyParameters.Builder(new XMSSParameters(xMSSKeyParams.height, DigestUtil.getDigestOID(Utils.getDigest(aSN1ObjectIdentifier3).getAlgorithmName())));
                builder.index = var23_29.index;
                builder.secretKeySeed = Nat576.cloneArray(Nat576.clone(var23_29.secretKeySeed));
                builder.secretKeyPRF = Nat576.cloneArray(Nat576.clone(var23_29.secretKeyPRF));
                builder.publicSeed = Nat576.cloneArray(Nat576.clone(var23_29.publicSeed));
                builder.root = Nat576.cloneArray(Nat576.clone(var23_29.root));
                if (var23_29.version != 0) {
                    builder.maxIndex = var23_29.maxIndex;
                }
                if (Nat576.clone(var23_29.bdsState) == null) return new XMSSPrivateKeyParameters(builder, null);
                BDS bDS = (BDS)Nat576.deserialize(Nat576.clone(var23_29.bdsState), BDS.class);
                Objects.requireNonNull((Object)bDS);
                builder.bdsState = new BDS(bDS, aSN1ObjectIdentifier3);
                return new XMSSPrivateKeyParameters(builder, null);
            }
            catch (ClassNotFoundException classNotFoundException) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"ClassNotFoundException processing BDS state: ");
                stringBuilder.append(classNotFoundException.getMessage());
                throw new IOException(stringBuilder.toString());
            }
        }
        if (!aSN1ObjectIdentifier.equals((ASN1Primitive)PQCObjectIdentifiers.xmss_mt)) {
            throw new RuntimeException("algorithm identifier in private key not recognised");
        }
        XMSSMTKeyParams xMSSMTKeyParams = XMSSMTKeyParams.getInstance((Object)privateKeyInfo.privateKeyAlgorithm.parameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = xMSSMTKeyParams.treeDigest.algorithm;
        try {
            ASN1Encodable aSN1Encodable = privateKeyInfo.parsePrivateKey();
            Object object = aSN1Encodable instanceof XMSSMTPrivateKey ? (XMSSMTPrivateKey)aSN1Encodable : (aSN1Encodable != null ? new XMSSMTPrivateKey(ASN1Sequence.getInstance((Object)aSN1Encodable)) : null);
            int n7 = xMSSMTKeyParams.height;
            XMSSMTPrivateKeyParameters.Builder builder = new XMSSMTPrivateKeyParameters.Builder(new XMSSMTParameters(n7, xMSSMTKeyParams.layers, DigestUtil.getDigestOID(Utils.getDigest(aSN1ObjectIdentifier4).getAlgorithmName())));
            builder.index = object.index;
            builder.secretKeySeed = Nat576.cloneArray(Nat576.clone(object.secretKeySeed));
            builder.secretKeyPRF = Nat576.cloneArray(Nat576.clone(object.secretKeyPRF));
            builder.publicSeed = Nat576.cloneArray(Nat576.clone(object.publicSeed));
            builder.root = Nat576.cloneArray(Nat576.clone(object.root));
            if (object.version != 0) {
                builder.maxIndex = object.maxIndex;
            }
            if (Nat576.clone(object.bdsState) == null) return new XMSSMTPrivateKeyParameters(builder, null);
            BDSStateMap bDSStateMap = ((BDSStateMap)Nat576.deserialize(Nat576.clone(object.bdsState), BDSStateMap.class)).withWOTSDigest(aSN1ObjectIdentifier4);
            builder.bdsState = bDSStateMap.maxIndex == 0L ? new BDSStateMap(bDSStateMap, (1L << n7) - 1L) : bDSStateMap;
            return new XMSSMTPrivateKeyParameters(builder, null);
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"ClassNotFoundException processing BDS state: ");
            stringBuilder.append(classNotFoundException.getMessage());
            throw new IOException(stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter, ASN1Set aSN1Set) throws IOException {
        long l2;
        XMSSMTPrivateKey xMSSMTPrivateKey;
        if (asymmetricKeyParameter instanceof QTESLAPrivateKeyParameters) {
            QTESLAPrivateKeyParameters qTESLAPrivateKeyParameters = (QTESLAPrivateKeyParameters)asymmetricKeyParameter;
            return new PrivateKeyInfo(Utils.qTeslaLookupAlgID(qTESLAPrivateKeyParameters.securityCategory), (ASN1Encodable)new DEROctetString(qTESLAPrivateKeyParameters.getSecret()), aSN1Set, null);
        }
        if (asymmetricKeyParameter instanceof SPHINCSPrivateKeyParameters) {
            SPHINCSPrivateKeyParameters sPHINCSPrivateKeyParameters = (SPHINCSPrivateKeyParameters)asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, (ASN1Encodable)new SPHINCS256KeyParams(Utils.sphincs256LookupTreeAlgID(sPHINCSPrivateKeyParameters.treeDigest))), (ASN1Encodable)new DEROctetString(sPHINCSPrivateKeyParameters.getKeyData()), null, null);
        }
        boolean bl = asymmetricKeyParameter instanceof NHPrivateKeyParameters;
        int i2 = 0;
        if (bl) {
            NHPrivateKeyParameters nHPrivateKeyParameters = (NHPrivateKeyParameters)asymmetricKeyParameter;
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.newHope);
            short[] arrs = nHPrivateKeyParameters.getSecData();
            byte[] arrby = new byte[2 * arrs.length];
            while (i2 != arrs.length) {
                short s = arrs[i2];
                int n2 = i2 * 2;
                arrby[n2] = (byte)s;
                arrby[n2 + 1] = (byte)(s >>> 8);
                ++i2;
            }
            return new PrivateKeyInfo(algorithmIdentifier, (ASN1Encodable)new DEROctetString(arrby), null, null);
        }
        if (asymmetricKeyParameter instanceof LMSPrivateKeyParameters) {
            LMSPrivateKeyParameters lMSPrivateKeyParameters = (LMSPrivateKeyParameters)asymmetricKeyParameter;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte by = (byte)(false ? 1 : 0);
            byteArrayOutputStream.write((int)by);
            byte by2 = (byte)(false ? 1 : 0);
            byteArrayOutputStream.write((int)by2);
            byte by3 = (byte)(false ? 1 : 0);
            byteArrayOutputStream.write((int)by3);
            byte by4 = (byte)(true ? 1 : 0);
            byteArrayOutputStream.write((int)by4);
            try {
                byteArrayOutputStream.write(lMSPrivateKeyParameters.getEncoded());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byte[] arrby = byteArrayOutputStream.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write((int)by);
            byteArrayOutputStream2.write((int)by2);
            byteArrayOutputStream2.write((int)by3);
            byteArrayOutputStream2.write((int)by4);
            LMSPublicKeyParameters lMSPublicKeyParameters = lMSPrivateKeyParameters.getPublicKey();
            try {
                byteArrayOutputStream2.write(lMSPublicKeyParameters.getEncoded());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byte[] arrby2 = byteArrayOutputStream2.toByteArray();
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), (ASN1Encodable)new DEROctetString(arrby), aSN1Set, arrby2);
        }
        if (asymmetricKeyParameter instanceof HSSPrivateKeyParameters) {
            LMSPublicKeyParameters lMSPublicKeyParameters;
            HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters)asymmetricKeyParameter;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int n3 = hSSPrivateKeyParameters.l;
            byteArrayOutputStream.write((int)((byte)(n3 >>> 24)));
            byteArrayOutputStream.write((int)((byte)(n3 >>> 16)));
            byteArrayOutputStream.write((int)((byte)(n3 >>> 8)));
            byteArrayOutputStream.write((int)((byte)n3));
            try {
                byteArrayOutputStream.write(hSSPrivateKeyParameters.getEncoded());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byte[] arrby = byteArrayOutputStream.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int n4 = hSSPrivateKeyParameters.l;
            byteArrayOutputStream3.write((int)((byte)(n4 >>> 24)));
            byteArrayOutputStream3.write((int)((byte)(n4 >>> 16)));
            byteArrayOutputStream3.write((int)((byte)(n4 >>> 8)));
            byteArrayOutputStream3.write((int)((byte)n4));
            HSSPrivateKeyParameters hSSPrivateKeyParameters2 = hSSPrivateKeyParameters;
            synchronized (hSSPrivateKeyParameters2) {
                lMSPublicKeyParameters = ((LMSPrivateKeyParameters)hSSPrivateKeyParameters.keys.get(0)).getPublicKey();
            }
            try {
                byteArrayOutputStream3.write(lMSPublicKeyParameters.getEncoded());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byte[] arrby3 = byteArrayOutputStream3.toByteArray();
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), (ASN1Encodable)new DEROctetString(arrby), aSN1Set, arrby3);
        }
        if (asymmetricKeyParameter instanceof XMSSPrivateKeyParameters) {
            XMSSPrivateKey xMSSPrivateKey;
            int n2;
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters)asymmetricKeyParameter;
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, (ASN1Encodable)new XMSSKeyParams(xMSSPrivateKeyParameters.params.height, Utils.xmssLookupTreeAlgID(xMSSPrivateKeyParameters.treeDigest)));
            byte[] arrby = xMSSPrivateKeyParameters.getEncoded();
            XMSSParameters xMSSParameters = xMSSPrivateKeyParameters.params;
            int n3 = xMSSParameters.treeDigestSize;
            int n4 = xMSSParameters.height;
            int n5 = (int)Nat576.bytesToXBigEndian(arrby, 0, 4);
            if (!Nat576.isIndexValid(n4, n5)) throw new IllegalArgumentException("index out of bounds");
            byte[] arrby2 = Nat576.extractBytesAtOffset(arrby, 4, n3);
            int n6 = n3 + 4;
            byte[] arrby3 = Nat576.extractBytesAtOffset(arrby, n6, n3);
            int n7 = n6 + n3;
            byte[] arrby4 = Nat576.extractBytesAtOffset(arrby, n7, n3);
            int n8 = n7 + n3;
            byte[] arrby5 = Nat576.extractBytesAtOffset(arrby, n8, n3);
            int n9 = n8 + n3;
            byte[] arrby6 = Nat576.extractBytesAtOffset(arrby, n9, arrby.length - n9);
            try {
                BDS bDS = (BDS)Nat576.deserialize(arrby6, BDS.class);
                n2 = bDS.maxIndex;
            }
            catch (ClassNotFoundException classNotFoundException) {
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"cannot parse BDS: ");
                stringBuilder.append(classNotFoundException.getMessage());
                throw new IOException(stringBuilder.toString());
            }
            if (n2 != (1 << n4) - 1) {
                xMSSPrivateKey = new XMSSPrivateKey(n5, arrby2, arrby3, arrby4, arrby5, arrby6, n2);
                return new PrivateKeyInfo(algorithmIdentifier, (ASN1Encodable)xMSSPrivateKey, aSN1Set, null);
            }
            xMSSPrivateKey = new XMSSPrivateKey(n5, arrby2, arrby3, arrby4, arrby5, arrby6);
            return new PrivateKeyInfo(algorithmIdentifier, (ASN1Encodable)xMSSPrivateKey, aSN1Set, null);
        }
        if (!(asymmetricKeyParameter instanceof XMSSMTPrivateKeyParameters)) throw new IOException("key parameters not recognized");
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters)asymmetricKeyParameter;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.xmss_mt;
        XMSSMTParameters xMSSMTParameters = xMSSMTPrivateKeyParameters.params;
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(aSN1ObjectIdentifier, (ASN1Encodable)new XMSSMTKeyParams(xMSSMTParameters.height, xMSSMTParameters.layers, Utils.xmssLookupTreeAlgID(xMSSMTPrivateKeyParameters.treeDigest)));
        byte[] arrby = xMSSMTPrivateKeyParameters.getEncoded();
        XMSSMTParameters xMSSMTParameters2 = xMSSMTPrivateKeyParameters.params;
        int n10 = xMSSMTParameters2.xmssParams.treeDigestSize;
        int n11 = xMSSMTParameters2.height;
        int n12 = (n11 + 7) / 8;
        long l3 = (int)Nat576.bytesToXBigEndian(arrby, 0, n12);
        if (!Nat576.isIndexValid(n11, l3)) throw new IllegalArgumentException("index out of bounds");
        int n13 = n12 + 0;
        byte[] arrby7 = Nat576.extractBytesAtOffset(arrby, n13, n10);
        int n14 = n13 + n10;
        byte[] arrby8 = Nat576.extractBytesAtOffset(arrby, n14, n10);
        int n15 = n14 + n10;
        byte[] arrby9 = Nat576.extractBytesAtOffset(arrby, n15, n10);
        int n16 = n15 + n10;
        byte[] arrby10 = Nat576.extractBytesAtOffset(arrby, n16, n10);
        int n17 = n16 + n10;
        byte[] arrby11 = Nat576.extractBytesAtOffset(arrby, n17, arrby.length - n17);
        try {
            BDSStateMap bDSStateMap = (BDSStateMap)Nat576.deserialize(arrby11, BDSStateMap.class);
            l2 = bDSStateMap.maxIndex;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"cannot parse BDSStateMap: ");
            stringBuilder.append(classNotFoundException.getMessage());
            throw new IOException(stringBuilder.toString());
        }
        if (l2 != (1L << n11) - 1L) {
            xMSSMTPrivateKey = new XMSSMTPrivateKey(l3, arrby7, arrby8, arrby9, arrby10, arrby11, l2);
            return new PrivateKeyInfo(algorithmIdentifier, (ASN1Encodable)xMSSMTPrivateKey, aSN1Set, null);
        }
        xMSSMTPrivateKey = new XMSSMTPrivateKey(l3, arrby7, arrby8, arrby9, arrby10, arrby11);
        return new PrivateKeyInfo(algorithmIdentifier, (ASN1Encodable)xMSSMTPrivateKey, aSN1Set, null);
    }

    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        if (asymmetricKeyParameter instanceof QTESLAPublicKeyParameters) {
            QTESLAPublicKeyParameters qTESLAPublicKeyParameters = (QTESLAPublicKeyParameters)asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(Utils.qTeslaLookupAlgID(qTESLAPublicKeyParameters.securityCategory), qTESLAPublicKeyParameters.getPublicData());
        }
        if (asymmetricKeyParameter instanceof SPHINCSPublicKeyParameters) {
            SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters = (SPHINCSPublicKeyParameters)asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, (ASN1Encodable)new SPHINCS256KeyParams(Utils.sphincs256LookupTreeAlgID(sPHINCSPublicKeyParameters.treeDigest))), sPHINCSPublicKeyParameters.getKeyData());
        }
        if (asymmetricKeyParameter instanceof NHPublicKeyParameters) {
            NHPublicKeyParameters nHPublicKeyParameters = (NHPublicKeyParameters)asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), nHPublicKeyParameters.getPubData());
        }
        if (asymmetricKeyParameter instanceof LMSPublicKeyParameters) {
            LMSPublicKeyParameters lMSPublicKeyParameters = (LMSPublicKeyParameters)asymmetricKeyParameter;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write((int)((byte)(false ? 1 : 0)));
            byteArrayOutputStream.write((int)((byte)(false ? 1 : 0)));
            byteArrayOutputStream.write((int)((byte)(false ? 1 : 0)));
            byteArrayOutputStream.write((int)((byte)(true ? 1 : 0)));
            try {
                byteArrayOutputStream.write(lMSPublicKeyParameters.getEncoded());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byte[] arrby = byteArrayOutputStream.toByteArray();
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), (ASN1Encodable)new DEROctetString(arrby));
        }
        if (asymmetricKeyParameter instanceof HSSPublicKeyParameters) {
            HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters)asymmetricKeyParameter;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int n2 = hSSPublicKeyParameters.l;
            byteArrayOutputStream.write((int)((byte)(n2 >>> 24)));
            byteArrayOutputStream.write((int)((byte)(n2 >>> 16)));
            byteArrayOutputStream.write((int)((byte)(n2 >>> 8)));
            byteArrayOutputStream.write((int)((byte)n2));
            LMSPublicKeyParameters lMSPublicKeyParameters = hSSPublicKeyParameters.lmsPublicKey;
            try {
                byteArrayOutputStream.write(lMSPublicKeyParameters.getEncoded());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byte[] arrby = byteArrayOutputStream.toByteArray();
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), (ASN1Encodable)new DEROctetString(arrby));
        }
        if (asymmetricKeyParameter instanceof XMSSPublicKeyParameters) {
            XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters)asymmetricKeyParameter;
            byte[] arrby = Nat576.cloneArray(xMSSPublicKeyParameters.publicSeed);
            byte[] arrby2 = Nat576.cloneArray(xMSSPublicKeyParameters.root);
            byte[] arrby3 = xMSSPublicKeyParameters.getEncoded();
            if (arrby3.length > arrby.length + arrby2.length) {
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmss), (ASN1Encodable)new DEROctetString(arrby3));
            }
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, (ASN1Encodable)new XMSSKeyParams(xMSSPublicKeyParameters.params.height, Utils.xmssLookupTreeAlgID(xMSSPublicKeyParameters.treeDigest))), (ASN1Encodable)new XMSSPublicKey(arrby, arrby2));
        }
        if (asymmetricKeyParameter instanceof XMSSMTPublicKeyParameters) {
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters)asymmetricKeyParameter;
            byte[] arrby = Nat576.cloneArray(xMSSMTPublicKeyParameters.publicSeed);
            byte[] arrby4 = Nat576.cloneArray(xMSSMTPublicKeyParameters.root);
            byte[] arrby5 = xMSSMTPublicKeyParameters.toByteArray();
            if (arrby5.length > arrby.length + arrby4.length) {
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmssmt), (ASN1Encodable)new DEROctetString(arrby5));
            }
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.xmss_mt;
            XMSSMTParameters xMSSMTParameters = xMSSMTPublicKeyParameters.params;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, (ASN1Encodable)new XMSSMTKeyParams(xMSSMTParameters.height, xMSSMTParameters.layers, Utils.xmssLookupTreeAlgID(xMSSMTPublicKeyParameters.treeDigest))), (ASN1Encodable)new XMSSMTPublicKey(Nat576.cloneArray(xMSSMTPublicKeyParameters.publicSeed), Nat576.cloneArray(xMSSMTPublicKeyParameters.root)));
        }
        throw new IOException("key parameters not recognized");
    }

    public static DateTimeFormatter date() {
        return ISODateTimeFormat.Constants.ymd;
    }

    public static int decAt(int n2, int[] arrn, int n3) {
        while (n3 < n2) {
            int n4;
            arrn[n3] = n4 = -1 + arrn[n3];
            if (n4 != -1) {
                return 0;
            }
            ++n3;
        }
        return -1;
    }

    public static int degree(int n2) {
        int n3 = -1;
        while (n2 != 0) {
            ++n3;
            n2 >>>= 1;
        }
        return n3;
    }

    public static Object deserialize(byte[] arrby, Class class_) throws IOException, ClassNotFoundException {
        XMSSUtil$CheckingStream xMSSUtil$CheckingStream = new XMSSUtil$CheckingStream(class_, (InputStream)new ByteArrayInputStream(arrby));
        Object object = xMSSUtil$CheckingStream.readObject();
        if (xMSSUtil$CheckingStream.available() == 0) {
            if (class_.isInstance(object)) {
                return object;
            }
            throw new IOException("unexpected class found in ObjectInputStream");
        }
        throw new IOException("unexpected data found at end of ObjectInputStream");
    }

    public static boolean eq(int n2, int[] arrn, int[] arrn2) {
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            if (arrn[i2] == arrn2[i2]) continue;
            return false;
        }
        return true;
    }

    public static boolean equals(Object object, Object object2) {
        if (object == object2) {
            return true;
        }
        if (object != null && object2 != null) {
            return object.equals(object2);
        }
        return false;
    }

    public static boolean equals(int[] arrn, int[] arrn2) {
        if (arrn.length != arrn2.length) {
            return false;
        }
        boolean bl = true;
        for (int i2 = arrn.length - 1; i2 >= 0; --i2) {
            boolean bl2 = arrn[i2] == arrn2[i2];
            bl &= bl2;
        }
        return bl;
    }

    public static boolean equals(short[] arrs, short[] arrs2) {
        if (arrs.length != arrs2.length) {
            return false;
        }
        boolean bl = true;
        for (int i2 = arrs.length - 1; i2 >= 0; --i2) {
            boolean bl2 = arrs[i2] == arrs2[i2];
            bl &= bl2;
        }
        return bl;
    }

    public static boolean equals(short[][] arrs, short[][] arrs2) {
        if (arrs.length != arrs2.length) {
            return false;
        }
        int n2 = arrs.length;
        boolean bl = true;
        for (int i2 = n2 - bl; i2 >= 0; --i2) {
            bl &= Nat576.equals(arrs[i2], arrs2[i2]);
        }
        return bl;
    }

    public static boolean equals(short[][][] arrs, short[][][] arrs2) {
        if (arrs.length != arrs2.length) {
            return false;
        }
        int n2 = arrs.length;
        boolean bl = true;
        for (int i2 = n2 - bl; i2 >= 0; --i2) {
            bl &= Nat576.equals(arrs[i2], arrs2[i2]);
        }
        return bl;
    }

    public static byte[] extractBytesAtOffset(byte[] arrby, int n2, int n3) {
        if (n2 >= 0) {
            if (n3 >= 0) {
                if (n2 + n3 <= arrby.length) {
                    byte[] arrby2 = new byte[n3];
                    for (int i2 = 0; i2 < n3; ++i2) {
                        arrby2[i2] = arrby[n2 + i2];
                    }
                    return arrby2;
                }
                throw new IllegalArgumentException("offset + length must not be greater then size of source array");
            }
            throw new IllegalArgumentException("length hast to be >= 0");
        }
        throw new IllegalArgumentException("offset hast to be >= 0");
    }

    public static int[] fromBigInteger(int n2, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= n2) {
            int n3 = n2 + 31 >> 5;
            int[] arrn = new int[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                arrn[i2] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
            }
            return arrn;
        }
        throw new IllegalArgumentException();
    }

    public static long[] fromBigInteger64(int n2, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= n2) {
            int n3 = n2 + 63 >> 6;
            long[] arrl = new long[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                arrl[i2] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
            }
            return arrl;
        }
        throw new IllegalArgumentException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int getBit(int[] arrn, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = arrn[0];
            do {
                return n3 & 1;
                break;
            } while (true);
        }
        int n4 = n2 >> 5;
        if (n4 < 0) return 0;
        if (n4 >= arrn.length) {
            return 0;
        }
        int n5 = n2 & 31;
        n3 = arrn[n4] >>> n5;
        return n3 & 1;
    }

    public static AlgorithmIdentifier getDigAlgId(String string) {
        if (string.equals((Object)"SHA-1")) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, (ASN1Encodable)DERNull.INSTANCE);
        }
        if (string.equals((Object)"SHA-224")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, (ASN1Encodable)DERNull.INSTANCE);
        }
        if (string.equals((Object)"SHA-256")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, (ASN1Encodable)DERNull.INSTANCE);
        }
        if (string.equals((Object)"SHA-384")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, (ASN1Encodable)DERNull.INSTANCE);
        }
        if (string.equals((Object)"SHA-512")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, (ASN1Encodable)DERNull.INSTANCE);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline18((String)"unrecognised digest algorithm: ", (String)string));
    }

    public static Digest getDigest(AlgorithmIdentifier algorithmIdentifier) {
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)OIWObjectIdentifiers.idSHA1)) {
            return new SHA1Digest();
        }
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)NISTObjectIdentifiers.id_sha224)) {
            return new SHA224Digest();
        }
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)NISTObjectIdentifiers.id_sha384)) {
            return new SHA384Digest();
        }
        if (algorithmIdentifier.algorithm.equals((ASN1Primitive)NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"unrecognised OID in digest algorithm identifier: ");
        stringBuilder.append((Object)algorithmIdentifier.algorithm);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static ASN1ObjectIdentifier getDigestOID(String string) {
        if (string.equals((Object)"SHA-256")) {
            return NISTObjectIdentifiers.id_sha256;
        }
        if (string.equals((Object)"SHA-512")) {
            return NISTObjectIdentifiers.id_sha512;
        }
        if (string.equals((Object)"SHAKE128")) {
            return NISTObjectIdentifiers.id_shake128;
        }
        if (string.equals((Object)"SHAKE256")) {
            return NISTObjectIdentifiers.id_shake256;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline18((String)"unrecognized digest: ", (String)string));
    }

    public static int getLength(int n2, int n3) {
        int n4 = n3 - n2;
        if (n4 >= 0) {
            return n4;
        }
        StringBuffer stringBuffer = new StringBuffer(n2);
        stringBuffer.append(" > ");
        stringBuffer.append(n3);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static String getName(int n2) {
        if (n2 != 5) {
            if (n2 == 6) {
                return "qTESLA-p-III";
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline11((String)"unknown security category: ", (int)n2));
        }
        return "qTESLA-p-I";
    }

    public static boolean gte(int n2, int[] arrn, int[] arrn2) {
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            int n3 = Integer.MIN_VALUE ^ arrn[i2];
            int n4 = Integer.MIN_VALUE ^ arrn2[i2];
            if (n3 < n4) {
                return false;
            }
            if (n3 <= n4) continue;
            return true;
        }
        return true;
    }

    public static boolean hasNullPointer(byte[][] arrby) {
        if (arrby == null) {
            return true;
        }
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            if (arrby[i2] != null) continue;
            return true;
        }
        return false;
    }

    public static int hashCode(byte[] arrby) {
        if (arrby == null) {
            return 0;
        }
        int n2 = arrby.length;
        int n3 = n2 + 1;
        while (--n2 >= 0) {
            n3 = n3 * 257 ^ arrby[n2];
        }
        return n3;
    }

    public static int hashCode(int[] arrn) {
        if (arrn == null) {
            return 0;
        }
        int n2 = arrn.length;
        int n3 = n2 + 1;
        while (--n2 >= 0) {
            n3 = n3 * 257 ^ arrn[n2];
        }
        return n3;
    }

    public static int hashCode(int[] arrn, int n2, int n3) {
        if (arrn == null) {
            return 0;
        }
        int n4 = n3 + 1;
        while (--n3 >= 0) {
            n4 = n4 * 257 ^ arrn[n2 + n3];
        }
        return n4;
    }

    public static int hashCode(long[] arrl, int n2, int n3) {
        if (arrl == null) {
            return 0;
        }
        int n4 = n3 + 1;
        while (--n3 >= 0) {
            long l2 = arrl[n2 + n3];
            n4 = 257 * (n4 * 257 ^ (int)l2) ^ (int)(l2 >>> 32);
        }
        return n4;
    }

    public static int hashCode(short[] arrs) {
        if (arrs == null) {
            return 0;
        }
        int n2 = arrs.length;
        int n3 = n2 + 1;
        while (--n2 >= 0) {
            n3 = n3 * 257 ^ 255 & arrs[n2];
        }
        return n3;
    }

    public static int hashCode(short[][] arrs) {
        int n2 = 0;
        for (int i2 = 0; i2 != arrs.length; ++i2) {
            n2 = n2 * 257 + Nat576.hashCode(arrs[i2]);
        }
        return n2;
    }

    public static int hashCode(short[][][] arrs) {
        int n2 = 0;
        for (int i2 = 0; i2 != arrs.length; ++i2) {
            n2 = n2 * 257 + Nat576.hashCode(arrs[i2]);
        }
        return n2;
    }

    public static int inc(int n2, int[] arrn) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            arrn[i2] = n3 = 1 + arrn[i2];
            if (n3 == 0) continue;
            return 0;
        }
        return 1;
    }

    public static int inc(int n2, int[] arrn, int[] arrn2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            arrn2[i2] = n3 = 1 + arrn[i2];
            if (n3 == 0) continue;
            while (i2 < n2) {
                arrn2[i2] = arrn[i2];
                ++i2;
            }
            return 0;
        }
        return 1;
    }

    public static int incAt(int n2, int[] arrn, int n3) {
        while (n3 < n2) {
            int n4;
            arrn[n3] = n4 = 1 + arrn[n3];
            if (n4 != 0) {
                return 0;
            }
            ++n3;
        }
        return 1;
    }

    public static int incAt(int n2, int[] arrn, int n3, int n4) {
        while (n4 < n2) {
            int n5;
            int n6 = n3 + n4;
            arrn[n6] = n5 = 1 + arrn[n6];
            if (n5 != 0) {
                return 0;
            }
            ++n4;
        }
        return 1;
    }

    public static void intToBigEndian(int n2, byte[] arrby, int n3) {
        arrby[n3] = (byte)(n2 >>> 24);
        int n4 = n3 + 1;
        arrby[n4] = (byte)(n2 >>> 16);
        int n5 = n4 + 1;
        arrby[n5] = (byte)(n2 >>> 8);
        arrby[n5 + 1] = (byte)n2;
    }

    public static void intToLittleEndian(int n2, byte[] arrby, int n3) {
        arrby[n3] = (byte)n2;
        int n4 = n3 + 1;
        arrby[n4] = (byte)(n2 >>> 8);
        int n5 = n4 + 1;
        arrby[n5] = (byte)(n2 >>> 16);
        arrby[n5 + 1] = (byte)(n2 >>> 24);
    }

    public static boolean isIndexValid(int n2, long l2) {
        if (l2 >= 0L) {
            return l2 < 1L << n2;
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean isOne(int n2, int[] arrn) {
        if (arrn[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < n2; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero(int n2, int[] arrn) {
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isZero64(long[] arrl) {
        for (int i2 = 0; i2 < 9; ++i2) {
            if (arrl[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public static XMSSNode lTree(WOTSPlus wOTSPlus, WOTSPlusPublicKeyParameters wOTSPlusPublicKeyParameters, LTreeAddress lTreeAddress) {
        int n2 = wOTSPlus.params.len;
        byte[][] arrby = Nat576.cloneArray(wOTSPlusPublicKeyParameters.publicKey);
        XMSSNode[] arrxMSSNode = new XMSSNode[arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            arrxMSSNode[i2] = new XMSSNode(0, arrby[i2]);
        }
        LTreeAddress.Builder builder = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress.layerAddress)).withTreeAddress(lTreeAddress.treeAddress);
        builder.lTreeAddress = lTreeAddress.lTreeAddress;
        builder.treeHeight = 0;
        builder.treeIndex = lTreeAddress.treeIndex;
        Object t = builder.withKeyAndMask(lTreeAddress.keyAndMask);
        do {
            double d2;
            LTreeAddress lTreeAddress2 = (LTreeAddress)((LTreeAddress.Builder)t).build();
            if (n2 <= 1) break;
            for (int i3 = 0; i3 < (int)Math.floor((double)(d2 = (double)(n2 / 2))); ++i3) {
                LTreeAddress.Builder builder2 = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.layerAddress)).withTreeAddress(lTreeAddress2.treeAddress);
                builder2.lTreeAddress = lTreeAddress2.lTreeAddress;
                builder2.treeHeight = lTreeAddress2.treeHeight;
                builder2.treeIndex = i3;
                lTreeAddress2 = (LTreeAddress)((LTreeAddress.Builder)builder2.withKeyAndMask(lTreeAddress2.keyAndMask)).build();
                int n3 = i3 * 2;
                arrxMSSNode[i3] = Nat576.randomizeHash(wOTSPlus, arrxMSSNode[n3], arrxMSSNode[n3 + 1], (XMSSAddress)lTreeAddress2);
            }
            if (n2 % 2 == 1) {
                arrxMSSNode[(int)Math.floor((double)d2)] = arrxMSSNode[n2 - 1];
            }
            n2 = (int)Math.ceil((double)((double)n2 / 2.0));
            LTreeAddress.Builder builder3 = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress2.layerAddress)).withTreeAddress(lTreeAddress2.treeAddress);
            builder3.lTreeAddress = lTreeAddress2.lTreeAddress;
            builder3.treeHeight = 1 + lTreeAddress2.treeHeight;
            builder3.treeIndex = lTreeAddress2.treeIndex;
            t = builder3.withKeyAndMask(lTreeAddress2.keyAndMask);
        } while (true);
        return arrxMSSNode[0];
    }

    public static int lessThan(int n2, int[] arrn, int[] arrn2) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            l2 = l2 + ((0xFFFFFFFFL & (long)arrn[i2]) - (0xFFFFFFFFL & (long)arrn2[i2])) >> 32;
        }
        return (int)l2;
    }

    public static int littleEndianToInt(byte[] arrby, int n2) {
        int n3 = 255 & arrby[n2];
        int n4 = n2 + 1;
        int n5 = n3 | (255 & arrby[n4]) << 8;
        int n6 = n4 + 1;
        return n5 | (255 & arrby[n6]) << 16 | arrby[n6 + 1] << 24;
    }

    public static void littleEndianToInt(byte[] arrby, int n2, int[] arrn, int n3, int n4) {
        for (int i2 = 0; i2 < n4; ++i2) {
            arrn[n3 + i2] = Nat576.littleEndianToInt(arrby, n2);
            n2 += 4;
        }
    }

    public static long littleEndianToLong(byte[] arrby, int n2) {
        int n3 = Nat576.littleEndianToInt(arrby, n2);
        return (0xFFFFFFFFL & (long)Nat576.littleEndianToInt(arrby, n2 + 4)) << 32 | 0xFFFFFFFFL & (long)n3;
    }

    public static int log2(int n2) {
        int n3 = 0;
        while ((n2 >>= 1) != 0) {
            ++n3;
        }
        return n3;
    }

    public static void longToBigEndian(long l2, byte[] arrby, int n2) {
        Nat576.intToBigEndian((int)(l2 >>> 32), arrby, n2);
        Nat576.intToBigEndian((int)(l2 & 0xFFFFFFFFL), arrby, n2 + 4);
    }

    public static int modMultiply(int n2, int n3, int n4) {
        int n5 = Nat576.remainder(n3, n4);
        int n6 = 0;
        if (n5 != 0) {
            int n7 = 1 << Nat576.degree(n4);
            for (int i2 = Nat576.remainder((int)n2, (int)n4); i2 != 0; i2 >>>= 1) {
                if ((byte)(i2 & 1) != 1) continue;
                n6 ^= n5;
                if ((n5 <<= 1) < n7) continue;
                n5 ^= n4;
            }
        }
        return n6;
    }

    public static XMSSNode randomizeHash(WOTSPlus wOTSPlus, XMSSNode xMSSNode, XMSSNode xMSSNode2, XMSSAddress xMSSAddress) {
        Objects.requireNonNull((Object)xMSSNode, (String)"left == null");
        Objects.requireNonNull((Object)xMSSNode2, (String)"right == null");
        if (xMSSNode.height == xMSSNode2.height) {
            byte[] arrby = Nat576.clone(wOTSPlus.publicSeed);
            if (xMSSAddress instanceof LTreeAddress) {
                LTreeAddress lTreeAddress = (LTreeAddress)xMSSAddress;
                LTreeAddress.Builder builder = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress.layerAddress)).withTreeAddress(lTreeAddress.treeAddress);
                builder.lTreeAddress = lTreeAddress.lTreeAddress;
                builder.treeHeight = lTreeAddress.treeHeight;
                builder.treeIndex = lTreeAddress.treeIndex;
                xMSSAddress = (LTreeAddress)((LTreeAddress.Builder)builder.withKeyAndMask(0)).build();
            } else if (xMSSAddress instanceof HashTreeAddress) {
                HashTreeAddress hashTreeAddress = (HashTreeAddress)xMSSAddress;
                HashTreeAddress.Builder builder = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.layerAddress)).withTreeAddress(hashTreeAddress.treeAddress);
                builder.treeHeight = hashTreeAddress.treeHeight;
                builder.treeIndex = hashTreeAddress.treeIndex;
                xMSSAddress = (HashTreeAddress)((HashTreeAddress.Builder)builder.withKeyAndMask(0)).build();
            }
            byte[] arrby2 = wOTSPlus.khf.PRF(arrby, xMSSAddress.toByteArray());
            if (xMSSAddress instanceof LTreeAddress) {
                LTreeAddress lTreeAddress = (LTreeAddress)xMSSAddress;
                LTreeAddress.Builder builder = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress.layerAddress)).withTreeAddress(lTreeAddress.treeAddress);
                builder.lTreeAddress = lTreeAddress.lTreeAddress;
                builder.treeHeight = lTreeAddress.treeHeight;
                builder.treeIndex = lTreeAddress.treeIndex;
                xMSSAddress = (LTreeAddress)((LTreeAddress.Builder)builder.withKeyAndMask(1)).build();
            } else if (xMSSAddress instanceof HashTreeAddress) {
                HashTreeAddress hashTreeAddress = (HashTreeAddress)xMSSAddress;
                HashTreeAddress.Builder builder = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.layerAddress)).withTreeAddress(hashTreeAddress.treeAddress);
                builder.treeHeight = hashTreeAddress.treeHeight;
                builder.treeIndex = hashTreeAddress.treeIndex;
                xMSSAddress = (HashTreeAddress)((HashTreeAddress.Builder)builder.withKeyAndMask(1)).build();
            }
            byte[] arrby3 = wOTSPlus.khf.PRF(arrby, xMSSAddress.toByteArray());
            if (xMSSAddress instanceof LTreeAddress) {
                LTreeAddress lTreeAddress = (LTreeAddress)xMSSAddress;
                LTreeAddress.Builder builder = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress.layerAddress)).withTreeAddress(lTreeAddress.treeAddress);
                builder.lTreeAddress = lTreeAddress.lTreeAddress;
                builder.treeHeight = lTreeAddress.treeHeight;
                builder.treeIndex = lTreeAddress.treeIndex;
                xMSSAddress = (LTreeAddress)((LTreeAddress.Builder)builder.withKeyAndMask(2)).build();
            } else if (xMSSAddress instanceof HashTreeAddress) {
                HashTreeAddress hashTreeAddress = (HashTreeAddress)xMSSAddress;
                HashTreeAddress.Builder builder = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.layerAddress)).withTreeAddress(hashTreeAddress.treeAddress);
                builder.treeHeight = hashTreeAddress.treeHeight;
                builder.treeIndex = hashTreeAddress.treeIndex;
                xMSSAddress = (HashTreeAddress)((HashTreeAddress.Builder)builder.withKeyAndMask(2)).build();
            }
            byte[] arrby4 = wOTSPlus.khf.PRF(arrby, xMSSAddress.toByteArray());
            int n2 = wOTSPlus.params.digestSize;
            int n3 = n2 * 2;
            byte[] arrby5 = new byte[n3];
            int n4 = 0;
            do {
                if (n4 >= n2) break;
                arrby5[n4] = (byte)(xMSSNode.getValue()[n4] ^ arrby3[n4]);
                ++n4;
            } while (true);
            for (int i2 = 0; i2 < n2; ++i2) {
                arrby5[i2 + n2] = (byte)(xMSSNode2.getValue()[i2] ^ arrby4[i2]);
            }
            KeyedHashFunctions keyedHashFunctions = wOTSPlus.khf;
            Objects.requireNonNull((Object)keyedHashFunctions);
            int n5 = arrby2.length;
            int n6 = keyedHashFunctions.digestSize;
            if (n5 == n6) {
                if (n3 == n6 * 2) {
                    byte[] arrby6 = keyedHashFunctions.coreDigest(1, arrby2, arrby5);
                    return new XMSSNode(xMSSNode.height, arrby6);
                }
                throw new IllegalArgumentException("wrong in length");
            }
            throw new IllegalArgumentException("wrong key length");
        }
        throw new IllegalStateException("height of both nodes must be equal");
    }

    public static DateTimeZone readFrom(DataInput dataInput, String string) throws IOException {
        int n2 = dataInput.readUnsignedByte();
        if (n2 != 67) {
            DateTimeZone dateTimeZone;
            if (n2 != 70) {
                if (n2 == 80) {
                    return DateTimeZoneBuilder.PrecalculatedZone.readFrom((DataInput)dataInput, (String)string);
                }
                throw new IOException("Invalid encoding");
            }
            FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(string, dataInput.readUTF(), (int)Nat576.readMillis(dataInput), (int)Nat576.readMillis(dataInput));
            if (fixedDateTimeZone.equals((Object)(dateTimeZone = DateTimeZone.UTC))) {
                fixedDateTimeZone = dateTimeZone;
            }
            return fixedDateTimeZone;
        }
        DateTimeZoneBuilder.PrecalculatedZone precalculatedZone = DateTimeZoneBuilder.PrecalculatedZone.readFrom((DataInput)dataInput, (String)string);
        if (precalculatedZone instanceof CachedDateTimeZone) {
            return (CachedDateTimeZone)precalculatedZone;
        }
        return new CachedDateTimeZone((DateTimeZone)precalculatedZone);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long readMillis(DataInput dataInput) throws IOException {
        long l2;
        long l3;
        int n2 = dataInput.readUnsignedByte();
        int n3 = n2 >> 6;
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 == 3) return dataInput.readLong();
                l2 = n2 << 26 >> 26;
                l3 = 1800000L;
                do {
                    return l2 * l3;
                    break;
                } while (true);
            }
            l2 = (long)n2 << 58 >> 26 | (long)(dataInput.readUnsignedByte() << 24) | (long)(dataInput.readUnsignedByte() << 16) | (long)(dataInput.readUnsignedByte() << 8) | (long)dataInput.readUnsignedByte();
            l3 = 1000L;
            return l2 * l3;
        }
        l2 = n2 << 26 >> 2 | dataInput.readUnsignedByte() << 16 | dataInput.readUnsignedByte() << 8 | dataInput.readUnsignedByte();
        l3 = 60000L;
        return l2 * l3;
    }

    public static int remainder(int n2, int n3) {
        if (n3 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (Nat576.degree(n2) >= Nat576.degree(n3)) {
            n2 ^= n3 << Nat576.degree(n2) - Nat576.degree(n3);
        }
        return n2;
    }

    public static int[] reverse(int[] arrn) {
        int n2 = 0;
        int n3 = arrn.length;
        int[] arrn2 = new int[n3];
        while (--n3 >= 0) {
            int n4 = n2 + 1;
            arrn2[n3] = arrn[n2];
            n2 = n4;
        }
        return arrn2;
    }

    public static long safeAdd(long l2, long l3) {
        long l4 = l2 + l3;
        if ((l2 ^ l4) < 0L) {
            if ((l2 ^ l3) < 0L) {
                return l4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The calculation caused an overflow: ");
            stringBuilder.append(l2);
            stringBuilder.append(" + ");
            stringBuilder.append(l3);
            throw new ArithmeticException(stringBuilder.toString());
        }
        return l4;
    }

    public static int safeToInt(long l2) {
        if (Integer.MIN_VALUE <= l2 && l2 <= Integer.MAX_VALUE) {
            return (int)l2;
        }
        throw new ArithmeticException(GeneratedOutlineSupport.outline15((String)"Value cannot fit in an int: ", (long)l2));
    }

    public static int shiftUpBit(int n2, int[] arrn, int n3, int[] arrn2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = arrn[i2];
            arrn2[i2] = n4 << 1 | n3 >>> 31;
            n3 = n4;
        }
        return n3 >>> 31;
    }

    public static int shiftUpBits(int n2, int[] arrn, int n3, int n4) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = arrn[i2];
            arrn[i2] = n5 << n3 | n4 >>> -n3;
            n4 = n5;
        }
        return n4 >>> -n3;
    }

    public static int shiftUpBits(int n2, int[] arrn, int n3, int n4, int[] arrn2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = arrn[i2];
            arrn2[i2] = n5 << n3 | n4 >>> -n3;
            n4 = n5;
        }
        return n4 >>> -n3;
    }

    public static long shiftUpBits64(int n2, long[] arrl, int n3, int n4, long l2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = n3 + i2;
            long l3 = arrl[n5];
            arrl[n5] = l3 << n4 | l2 >>> -n4;
            l2 = l3;
        }
        return l2 >>> -n4;
    }

    public static int sub(int n2, int[] arrn, int[] arrn2, int[] arrn3) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = l2 + ((0xFFFFFFFFL & (long)arrn[i2]) - (0xFFFFFFFFL & (long)arrn2[i2]));
            arrn3[i2] = (int)l3;
            l2 = l3 >> 32;
        }
        return (int)l2;
    }

    public static int sub33From(int n2, int n3, int[] arrn) {
        long l2 = (0xFFFFFFFFL & (long)arrn[0]) - (0xFFFFFFFFL & (long)n3);
        arrn[0] = (int)l2;
        long l3 = (l2 >> 32) + ((0xFFFFFFFFL & (long)arrn[1]) - 1L);
        arrn[1] = (int)l3;
        if (l3 >> 32 == 0L) {
            return 0;
        }
        return Nat576.decAt(n2, arrn, 2);
    }

    public static int subFrom(int n2, int[] arrn, int n3, int[] arrn2, int n4) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = n4 + i2;
            long l3 = l2 + ((0xFFFFFFFFL & (long)arrn2[n5]) - (0xFFFFFFFFL & (long)arrn[n3 + i2]));
            arrn2[n5] = (int)l3;
            l2 = l3 >> 32;
        }
        return (int)l2;
    }

    public static int subFrom(int n2, int[] arrn, int[] arrn2) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = l2 + ((0xFFFFFFFFL & (long)arrn2[i2]) - (0xFFFFFFFFL & (long)arrn[i2]));
            arrn2[i2] = (int)l3;
            l2 = l3 >> 32;
        }
        return (int)l2;
    }

    public static BigInteger toBigInteger(int n2, int[] arrn) {
        byte[] arrby = new byte[n2 << 2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = arrn[i2];
            if (n3 == 0) continue;
            Nat576.intToBigEndian(n3, arrby, n2 - 1 - i2 << 2);
        }
        return new BigInteger(1, arrby);
    }

    public static byte[] toBytesBigEndian(long l2, int n2) {
        byte[] arrby = new byte[n2];
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            arrby[i2] = (byte)l2;
            l2 >>>= 8;
        }
        return arrby;
    }

    public static void u32str(int n2, Digest digest) {
        digest.update((byte)(n2 >>> 24));
        digest.update((byte)(n2 >>> 16));
        digest.update((byte)(n2 >>> 8));
        digest.update((byte)n2);
    }

    public static void verifyValueBounds(DateTimeField dateTimeField, int n2, int n3, int n4) {
        if (n2 >= n3 && n2 <= n4) {
            return;
        }
        throw new IllegalFieldValueException(((BaseDateTimeField)dateTimeField).iType, (Number)n2, (Number)n3, (Number)n4);
    }
}

