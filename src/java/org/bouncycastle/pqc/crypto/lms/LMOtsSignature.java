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
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

public class LMOtsSignature
implements Encodable {
    public final byte[] C;
    public final LMOtsParameters type;
    public final byte[] y;

    public LMOtsSignature(LMOtsParameters lMOtsParameters, byte[] arrby, byte[] arrby2) {
        this.type = lMOtsParameters;
        this.C = arrby;
        this.y = arrby2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static LMOtsSignature getInstance(Object object) throws IOException {
        void var3_10;
        DataInputStream dataInputStream;
        block7 : {
            LMOtsSignature lMOtsSignature;
            if (object instanceof LMOtsSignature) {
                return (LMOtsSignature)object;
            }
            if (object instanceof DataInputStream) {
                DataInputStream dataInputStream2 = (DataInputStream)object;
                LMOtsParameters lMOtsParameters = LMOtsParameters.getParametersForType(dataInputStream2.readInt());
                byte[] arrby = new byte[lMOtsParameters.n];
                dataInputStream2.readFully(arrby);
                byte[] arrby2 = new byte[lMOtsParameters.p * lMOtsParameters.n];
                dataInputStream2.readFully(arrby2);
                return new LMOtsSignature(lMOtsParameters, arrby, arrby2);
            }
            if (!(object instanceof byte[])) {
                if (!(object instanceof InputStream)) throw new IllegalArgumentException(GeneratedOutlineSupport.outline17((String)"cannot parse ", (Object)object));
                return LMOtsSignature.getInstance(Streams.readAll((InputStream)object));
            }
            dataInputStream = null;
            DataInputStream dataInputStream2 = new DataInputStream((InputStream)new ByteArrayInputStream((byte[])object));
            try {
                lMOtsSignature = LMOtsSignature.getInstance((Object)dataInputStream2);
            }
            catch (Throwable throwable) {
                dataInputStream = dataInputStream2;
                break block7;
            }
            dataInputStream2.close();
            return lMOtsSignature;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dataInputStream == null) throw var3_10;
        dataInputStream.close();
        throw var3_10;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (LMOtsSignature.class != object.getClass()) {
                return false;
            }
            LMOtsSignature lMOtsSignature = (LMOtsSignature)object;
            LMOtsParameters lMOtsParameters = this.type;
            if (lMOtsParameters != null ? !lMOtsParameters.equals((Object)lMOtsSignature.type) : lMOtsSignature.type != null) {
                return false;
            }
            if (!Arrays.equals((byte[])this.C, (byte[])lMOtsSignature.C)) {
                return false;
            }
            return Arrays.equals((byte[])this.y, (byte[])lMOtsSignature.y);
        }
        return false;
    }

    @Override
    public byte[] getEncoded() throws IOException {
        byte[] arrby;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = this.type.type;
        byteArrayOutputStream.write((int)((byte)(n2 >>> 24)));
        byteArrayOutputStream.write((int)((byte)(n2 >>> 16)));
        byteArrayOutputStream.write((int)((byte)(n2 >>> 8)));
        byteArrayOutputStream.write((int)((byte)n2));
        byte[] arrby2 = this.C;
        try {
            byteArrayOutputStream.write(arrby2);
            arrby = this.y;
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
        LMOtsParameters lMOtsParameters = this.type;
        int n2 = lMOtsParameters != null ? lMOtsParameters.hashCode() : 0;
        return 31 * (n2 * 31 + Arrays.hashCode((byte[])this.C)) + Arrays.hashCode((byte[])this.y);
    }
}

