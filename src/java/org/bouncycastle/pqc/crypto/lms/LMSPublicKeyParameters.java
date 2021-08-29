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
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;
import org.bouncycastle.util.io.Streams;

public class LMSPublicKeyParameters
extends LMSKeyParameters {
    public final byte[] I;
    public final byte[] T1;
    public final LMOtsParameters lmOtsType;
    public final LMSigParameters parameterSet;

    public LMSPublicKeyParameters(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, byte[] arrby, byte[] arrby2) {
        super(false);
        this.parameterSet = lMSigParameters;
        this.lmOtsType = lMOtsParameters;
        this.I = Nat576.clone(arrby2);
        this.T1 = Nat576.clone(arrby);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static LMSPublicKeyParameters getInstance(Object object) throws IOException {
        DataInputStream dataInputStream;
        void var3_11;
        block7 : {
            LMSPublicKeyParameters lMSPublicKeyParameters;
            if (object instanceof LMSPublicKeyParameters) {
                return (LMSPublicKeyParameters)object;
            }
            if (object instanceof DataInputStream) {
                DataInputStream dataInputStream2 = (DataInputStream)object;
                LMSigParameters lMSigParameters = LMSigParameters.getParametersForType(dataInputStream2.readInt());
                LMOtsParameters lMOtsParameters = LMOtsParameters.getParametersForType(dataInputStream2.readInt());
                byte[] arrby = new byte[16];
                dataInputStream2.readFully(arrby);
                byte[] arrby2 = new byte[lMSigParameters.m];
                dataInputStream2.readFully(arrby2);
                return new LMSPublicKeyParameters(lMSigParameters, lMOtsParameters, arrby2, arrby);
            }
            if (!(object instanceof byte[])) {
                if (!(object instanceof InputStream)) throw new IllegalArgumentException(GeneratedOutlineSupport.outline17((String)"cannot parse ", (Object)object));
                return LMSPublicKeyParameters.getInstance(Streams.readAll((InputStream)object));
            }
            dataInputStream = null;
            DataInputStream dataInputStream2 = new DataInputStream((InputStream)new ByteArrayInputStream((byte[])object));
            try {
                lMSPublicKeyParameters = LMSPublicKeyParameters.getInstance((Object)dataInputStream2);
            }
            catch (Throwable throwable) {
                dataInputStream = dataInputStream2;
                break block7;
            }
            dataInputStream2.close();
            return lMSPublicKeyParameters;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dataInputStream == null) throw var3_11;
        dataInputStream.close();
        throw var3_11;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (LMSPublicKeyParameters.class != object.getClass()) {
                return false;
            }
            LMSPublicKeyParameters lMSPublicKeyParameters = (LMSPublicKeyParameters)object;
            if (!this.parameterSet.equals((Object)lMSPublicKeyParameters.parameterSet)) {
                return false;
            }
            if (!this.lmOtsType.equals((Object)lMSPublicKeyParameters.lmOtsType)) {
                return false;
            }
            if (!Arrays.equals((byte[])this.I, (byte[])lMSPublicKeyParameters.I)) {
                return false;
            }
            return Arrays.equals((byte[])this.T1, (byte[])lMSPublicKeyParameters.T1);
        }
        return false;
    }

    @Override
    public byte[] getEncoded() throws IOException {
        byte[] arrby;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = this.parameterSet.type;
        byteArrayOutputStream.write((int)((byte)(n2 >>> 24)));
        byteArrayOutputStream.write((int)((byte)(n2 >>> 16)));
        byteArrayOutputStream.write((int)((byte)(n2 >>> 8)));
        byteArrayOutputStream.write((int)((byte)n2));
        int n3 = this.lmOtsType.type;
        byteArrayOutputStream.write((int)((byte)(n3 >>> 24)));
        byteArrayOutputStream.write((int)((byte)(n3 >>> 16)));
        byteArrayOutputStream.write((int)((byte)(n3 >>> 8)));
        byteArrayOutputStream.write((int)((byte)n3));
        byte[] arrby2 = this.I;
        try {
            byteArrayOutputStream.write(arrby2);
            arrby = this.T1;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
        try {
            byteArrayOutputStream.write(arrby);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return 31 * (31 * (31 * this.parameterSet.hashCode() + this.lmOtsType.hashCode()) + Nat576.hashCode(this.I)) + Nat576.hashCode(this.T1);
    }
}

