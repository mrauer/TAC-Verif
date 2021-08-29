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
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package org.bouncycastle.pqc.crypto.lms;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.crypto.lms.LMOtsSignature;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

public class LMSSignature
implements Encodable {
    public final LMOtsSignature otsSignature;
    public final LMSigParameters parameter;
    public final int q;
    public final byte[][] y;

    public LMSSignature(int n2, LMOtsSignature lMOtsSignature, LMSigParameters lMSigParameters, byte[][] arrby) {
        this.q = n2;
        this.otsSignature = lMOtsSignature;
        this.parameter = lMSigParameters;
        this.y = arrby;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static LMSSignature getInstance(Object object) throws IOException {
        DataInputStream dataInputStream;
        void var3_13;
        block8 : {
            LMSSignature lMSSignature;
            if (object instanceof LMSSignature) {
                return (LMSSignature)object;
            }
            if (object instanceof DataInputStream) {
                DataInputStream dataInputStream2 = (DataInputStream)object;
                int n2 = dataInputStream2.readInt();
                LMOtsSignature lMOtsSignature = LMOtsSignature.getInstance(object);
                LMSigParameters lMSigParameters = LMSigParameters.getParametersForType(dataInputStream2.readInt());
                int n3 = lMSigParameters.h;
                byte[][] arrarrby = new byte[n3][];
                int i2 = 0;
                while (i2 < n3) {
                    arrarrby[i2] = new byte[lMSigParameters.m];
                    dataInputStream2.readFully(arrarrby[i2]);
                    ++i2;
                }
                return new LMSSignature(n2, lMOtsSignature, lMSigParameters, arrarrby);
            }
            if (!(object instanceof byte[])) {
                if (!(object instanceof InputStream)) throw new IllegalArgumentException(GeneratedOutlineSupport.outline17((String)"cannot parse ", (Object)object));
                return LMSSignature.getInstance(Streams.readAll((InputStream)object));
            }
            dataInputStream = null;
            DataInputStream dataInputStream2 = new DataInputStream((InputStream)new ByteArrayInputStream((byte[])object));
            try {
                lMSSignature = LMSSignature.getInstance((Object)dataInputStream2);
            }
            catch (Throwable throwable) {
                dataInputStream = dataInputStream2;
                break block8;
            }
            dataInputStream2.close();
            return lMSSignature;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dataInputStream == null) throw var3_13;
        dataInputStream.close();
        throw var3_13;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (LMSSignature.class != object.getClass()) {
                return false;
            }
            LMSSignature lMSSignature = (LMSSignature)object;
            if (this.q != lMSSignature.q) {
                return false;
            }
            LMOtsSignature lMOtsSignature = this.otsSignature;
            if (lMOtsSignature != null ? !lMOtsSignature.equals(lMSSignature.otsSignature) : lMSSignature.otsSignature != null) {
                return false;
            }
            LMSigParameters lMSigParameters = this.parameter;
            if (lMSigParameters != null ? !lMSigParameters.equals((Object)lMSSignature.parameter) : lMSSignature.parameter != null) {
                return false;
            }
            return Arrays.deepEquals((Object[])this.y, (Object[])lMSSignature.y);
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public byte[] getEncoded() throws IOException {
        int n2;
        int n4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n3 = this.q;
        byteArrayOutputStream.write((int)((byte)(n3 >>> 24)));
        byteArrayOutputStream.write((int)((byte)(n3 >>> 16)));
        byteArrayOutputStream.write((int)((byte)(n3 >>> 8)));
        byteArrayOutputStream.write((int)((byte)n3));
        byte[] arrby = this.otsSignature.getEncoded();
        try {
            byteArrayOutputStream.write(arrby);
            n4 = this.parameter.type;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
        byteArrayOutputStream.write((int)((byte)(n4 >>> 24)));
        byteArrayOutputStream.write((int)((byte)(n4 >>> 16)));
        byteArrayOutputStream.write((int)((byte)(n4 >>> 8)));
        byteArrayOutputStream.write((int)((byte)n4));
        byte[][] arrby2 = this.y;
        try {
            n2 = arrby2.length;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            byteArrayOutputStream.write(arrby2[i2]);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        int n2 = 31 * this.q;
        LMOtsSignature lMOtsSignature = this.otsSignature;
        int n3 = lMOtsSignature != null ? lMOtsSignature.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        LMSigParameters lMSigParameters = this.parameter;
        int n5 = 0;
        if (lMSigParameters != null) {
            n5 = lMSigParameters.hashCode();
        }
        return 31 * (n4 + n5) + Arrays.deepHashCode((Object[])this.y);
    }
}

