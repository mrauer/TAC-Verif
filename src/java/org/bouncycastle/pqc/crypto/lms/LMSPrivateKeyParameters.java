/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.DataInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Map
 *  java.util.WeakHashMap
 */
package org.bouncycastle.pqc.crypto.lms;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.lms.Composer;
import org.bouncycastle.pqc.crypto.lms.DigestUtil;
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;
import org.bouncycastle.util.io.Streams;

public class LMSPrivateKeyParameters
extends LMSKeyParameters {
    public static CacheKey T1;
    public static CacheKey[] internedKeys;
    public final byte[] I;
    public final byte[] masterSecret;
    public final int maxCacheR;
    public final int maxQ;
    public final LMOtsParameters otsParameters;
    public final LMSigParameters parameters;
    public LMSPublicKeyParameters publicKey;
    public int q;
    public final Map<CacheKey, byte[]> tCache;
    public final Digest tDigest;

    public static {
        CacheKey[] arrcacheKey;
        Object object = new Object(1){
            public final int index;
            {
                this.index = n2;
            }

            public boolean equals(Object object) {
                boolean bl = object instanceof CacheKey;
                boolean bl2 = false;
                if (bl) {
                    int n2 = (object).index;
                    int n3 = this.index;
                    bl2 = false;
                    if (n2 == n3) {
                        bl2 = true;
                    }
                }
                return bl2;
            }

            public int hashCode() {
                return this.index;
            }
        };
        T1 = object;
        CacheKey[] arrcacheKey2 = new CacheKey[129];
        internedKeys = arrcacheKey2;
        arrcacheKey2[1] = object;
        for (int i2 = 2; i2 < (arrcacheKey = internedKeys).length; ++i2) {
            arrcacheKey[i2] = new /* invalid duplicate definition of identical inner class */;
        }
    }

    public LMSPrivateKeyParameters(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int n2, byte[] arrby, int n3, byte[] arrby2) {
        super(true);
        this.parameters = lMSigParameters;
        this.otsParameters = lMOtsParameters;
        this.q = n2;
        this.I = Nat576.clone(arrby);
        this.maxQ = n3;
        this.masterSecret = Nat576.clone(arrby2);
        this.maxCacheR = 1 << 1 + lMSigParameters.h;
        this.tCache = new WeakHashMap();
        this.tDigest = DigestUtil.getDigest(lMSigParameters.digestOid);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static LMSPrivateKeyParameters getInstance(Object object) throws IOException {
        DataInputStream dataInputStream;
        void var3_16;
        block8 : {
            LMSPrivateKeyParameters lMSPrivateKeyParameters;
            if (object instanceof LMSPrivateKeyParameters) {
                return (LMSPrivateKeyParameters)object;
            }
            if (object instanceof DataInputStream) {
                DataInputStream dataInputStream2 = (DataInputStream)object;
                if (dataInputStream2.readInt() != 0) throw new IllegalStateException("expected version 0 lms private key");
                LMSigParameters lMSigParameters = LMSigParameters.getParametersForType(dataInputStream2.readInt());
                LMOtsParameters lMOtsParameters = LMOtsParameters.getParametersForType(dataInputStream2.readInt());
                byte[] arrby = new byte[16];
                dataInputStream2.readFully(arrby);
                int n2 = dataInputStream2.readInt();
                int n3 = dataInputStream2.readInt();
                int n4 = dataInputStream2.readInt();
                if (n4 < 0) throw new IllegalStateException("secret length less than zero");
                if (n4 <= dataInputStream2.available()) {
                    byte[] arrby2 = new byte[n4];
                    dataInputStream2.readFully(arrby2);
                    return new LMSPrivateKeyParameters(lMSigParameters, lMOtsParameters, n2, arrby, n3, arrby2);
                }
                StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"secret length exceeded ");
                stringBuilder.append(dataInputStream2.available());
                throw new IOException(stringBuilder.toString());
            }
            if (!(object instanceof byte[])) {
                if (!(object instanceof InputStream)) throw new IllegalArgumentException(GeneratedOutlineSupport.outline17((String)"cannot parse ", (Object)object));
                return LMSPrivateKeyParameters.getInstance(Streams.readAll((InputStream)object));
            }
            dataInputStream = null;
            DataInputStream dataInputStream2 = new DataInputStream((InputStream)new ByteArrayInputStream((byte[])object));
            try {
                lMSPrivateKeyParameters = LMSPrivateKeyParameters.getInstance((Object)dataInputStream2);
            }
            catch (Throwable throwable) {
                dataInputStream = dataInputStream2;
                break block8;
            }
            dataInputStream2.close();
            return lMSPrivateKeyParameters;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dataInputStream == null) throw var3_16;
        dataInputStream.close();
        throw var3_16;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final byte[] calcT(int n2) {
        Digest digest3;
        Digest digest2;
        byte[] arrby2;
        byte[] arrby;
        byte by4;
        byte by3;
        byte by2;
        LMOtsParameters lMOtsParameters;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte by;
        block10 : {
            int n3 = 1 << this.parameters.h;
            if (n2 < n3) {
                int n16 = n2 * 2;
                byte[] arrby3 = this.findT(n16);
                byte[] arrby7 = this.findT(n16 + 1);
                Nat576.byteArray(this.getI(), this.tDigest);
                Nat576.u32str(n2, this.tDigest);
                Digest digest = this.tDigest;
                digest.update((byte)16777091);
                digest.update((byte)-31869);
                Nat576.byteArray(arrby3, this.tDigest);
                Nat576.byteArray(arrby7, this.tDigest);
                byte[] arrby8 = new byte[this.tDigest.getDigestSize()];
                this.tDigest.doFinal(arrby8, 0);
                return arrby8;
            }
            Nat576.byteArray(this.getI(), this.tDigest);
            Nat576.u32str(n2, this.tDigest);
            Digest digest = this.tDigest;
            digest.update((byte)16777090);
            digest.update((byte)-32126);
            lMOtsParameters = this.otsParameters;
            arrby = this.getI();
            int n4 = n2 - n3;
            arrby2 = Nat576.clone(this.masterSecret);
            digest2 = DigestUtil.getDigest(lMOtsParameters.digestOID);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(arrby);
            by = (byte)(n4 >>> 24);
            byteArrayOutputStream.write((int)by);
            by2 = (byte)(n4 >>> 16);
            byteArrayOutputStream.write((int)by2);
            by3 = (byte)(n4 >>> 8);
            byteArrayOutputStream.write((int)by3);
            by4 = (byte)n4;
            byteArrayOutputStream.write((int)by4);
            byteArrayOutputStream.write((int)((byte)128));
            byteArrayOutputStream.write((int)((byte)32896));
            while (byteArrayOutputStream.size() < 22) {
                byteArrayOutputStream.write(0);
            }
            byte[] arrby3 = byteArrayOutputStream.toByteArray();
            digest2.update(arrby3, 0, arrby3.length);
            digest3 = DigestUtil.getDigest(lMOtsParameters.digestOID);
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream2.write(arrby);
            }
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
            byteArrayOutputStream2.write((int)by);
            byteArrayOutputStream2.write((int)by2);
            byteArrayOutputStream2.write((int)by3);
            byteArrayOutputStream2.write((int)by4);
            int n5 = 23 + digest3.getDigestSize();
            while (byteArrayOutputStream2.size() < n5) {
                byteArrayOutputStream2.write(0);
            }
            break block10;
            catch (Exception exception) {
                throw new RuntimeException(exception.getMessage(), (Throwable)exception);
            }
        }
        byte[] arrby4 = byteArrayOutputStream2.toByteArray();
        Digest digest4 = DigestUtil.getDigest(lMOtsParameters.digestOID);
        int n6 = lMOtsParameters.p;
        int n7 = lMOtsParameters.n;
        int n8 = (1 << lMOtsParameters.w) - 1;
        int i2 = 0;
        int n9 = 0;
        do {
            if (i2 >= n6) {
                int n15 = digest2.getDigestSize();
                byte[] arrby5 = new byte[n15];
                digest2.doFinal(arrby5, 0);
                this.tDigest.update(arrby5, 0, n15);
                byte[] arrby6 = new byte[this.tDigest.getDigestSize()];
                this.tDigest.doFinal(arrby6, 0);
                return arrby6;
            }
            int n10 = n6 - 1;
            int n11 = n6;
            boolean bl = i2 < n10;
            if (arrby4.length < digest4.getDigestSize()) throw new IllegalArgumentException("target length is less than digest size.");
            digest4.update(arrby, 0, arrby.length);
            digest4.update(by);
            digest4.update(by2);
            digest4.update(by3);
            digest4.update(by4);
            int n12 = n9;
            digest4.update((byte)(n12 >>> 8));
            digest4.update((byte)n12);
            digest4.update((byte)-1);
            int n13 = arrby2.length;
            byte by5 = by4;
            digest4.update(arrby2, 0, n13);
            digest4.doFinal(arrby4, 23);
            int n14 = bl ? n12 + 1 : n12;
            short s2 = (short)i2;
            arrby4[20] = (byte)(s2 >>> 8);
            arrby4[21] = (byte)s2;
            for (int i3 = 0; i3 < n8; ++i3) {
                arrby4[22] = (byte)i3;
                digest3.update(arrby4, 0, arrby4.length);
                digest3.doFinal(arrby4, 23);
            }
            digest2.update(arrby4, 23, n7);
            ++i2;
            n6 = n11;
            n9 = n14;
            by4 = by5;
        } while (true);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            LMSPublicKeyParameters lMSPublicKeyParameters;
            if (LMSPrivateKeyParameters.class != object.getClass()) {
                return false;
            }
            LMSPrivateKeyParameters lMSPrivateKeyParameters = (LMSPrivateKeyParameters)object;
            if (this.q != lMSPrivateKeyParameters.q) {
                return false;
            }
            if (this.maxQ != lMSPrivateKeyParameters.maxQ) {
                return false;
            }
            if (!Arrays.equals((byte[])this.I, (byte[])lMSPrivateKeyParameters.I)) {
                return false;
            }
            LMSigParameters lMSigParameters = this.parameters;
            if (lMSigParameters != null ? !lMSigParameters.equals((Object)lMSPrivateKeyParameters.parameters) : lMSPrivateKeyParameters.parameters != null) {
                return false;
            }
            LMOtsParameters lMOtsParameters = this.otsParameters;
            if (lMOtsParameters != null ? !lMOtsParameters.equals((Object)lMSPrivateKeyParameters.otsParameters) : lMSPrivateKeyParameters.otsParameters != null) {
                return false;
            }
            if (!Arrays.equals((byte[])this.masterSecret, (byte[])lMSPrivateKeyParameters.masterSecret)) {
                return false;
            }
            LMSPublicKeyParameters lMSPublicKeyParameters2 = this.publicKey;
            if (lMSPublicKeyParameters2 != null && (lMSPublicKeyParameters = lMSPrivateKeyParameters.publicKey) != null) {
                return lMSPublicKeyParameters2.equals(lMSPublicKeyParameters);
            }
            return true;
        }
        return false;
    }

    public byte[] findT(int n2) {
        if (n2 < this.maxCacheR) {
            CacheKey[] arrcacheKey = internedKeys;
            Object object = n2 < arrcacheKey.length ? arrcacheKey[n2] : new /* invalid duplicate definition of identical inner class */;
            return this.findT(object);
        }
        return this.calcT(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] findT(CacheKey cacheKey) {
        Map<CacheKey, byte[]> map;
        Map<CacheKey, byte[]> map2 = map = this.tCache;
        synchronized (map2) {
            byte[] arrby = (byte[])this.tCache.get((Object)cacheKey);
            if (arrby != null) {
                return arrby;
            }
            byte[] arrby2 = this.calcT(cacheKey.index);
            this.tCache.put((Object)cacheKey, (Object)arrby2);
            return arrby2;
        }
    }

    @Override
    public byte[] getEncoded() throws IOException {
        Composer composer = new Composer();
        composer.u32str(0);
        composer.u32str(this.parameters.type);
        composer.u32str(this.otsParameters.type);
        composer.bytes(this.I);
        composer.u32str(this.q);
        composer.u32str(this.maxQ);
        composer.u32str(this.masterSecret.length);
        composer.bytes(this.masterSecret);
        return composer.build();
    }

    public byte[] getI() {
        return Nat576.clone(this.I);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LMSPublicKeyParameters getPublicKey() {
        LMSPrivateKeyParameters lMSPrivateKeyParameters = this;
        synchronized (lMSPrivateKeyParameters) {
            if (this.publicKey != null) return this.publicKey;
            this.publicKey = new LMSPublicKeyParameters(this.parameters, this.otsParameters, this.findT(T1), this.I);
            return this.publicKey;
        }
    }

    public int hashCode() {
        int n2 = 31 * (31 * this.q + Nat576.hashCode(this.I));
        LMSigParameters lMSigParameters = this.parameters;
        int n3 = lMSigParameters != null ? lMSigParameters.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        LMOtsParameters lMOtsParameters = this.otsParameters;
        int n5 = lMOtsParameters != null ? lMOtsParameters.hashCode() : 0;
        int n6 = 31 * (31 * (31 * (n4 + n5) + this.maxQ) + Nat576.hashCode(this.masterSecret));
        LMSPublicKeyParameters lMSPublicKeyParameters = this.publicKey;
        int n7 = 0;
        if (lMSPublicKeyParameters != null) {
            n7 = lMSPublicKeyParameters.hashCode();
        }
        return n6 + n7;
    }

}

