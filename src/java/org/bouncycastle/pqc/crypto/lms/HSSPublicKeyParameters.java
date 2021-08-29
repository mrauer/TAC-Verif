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
 */
package org.bouncycastle.pqc.crypto.lms;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import org.bouncycastle.util.io.Streams;

public class HSSPublicKeyParameters
extends LMSKeyParameters {
    public final int l;
    public final LMSPublicKeyParameters lmsPublicKey;

    public HSSPublicKeyParameters(int n2, LMSPublicKeyParameters lMSPublicKeyParameters) {
        super(false);
        this.l = n2;
        this.lmsPublicKey = lMSPublicKeyParameters;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static HSSPublicKeyParameters getInstance(Object object) throws IOException {
        void var3_6;
        DataInputStream dataInputStream;
        block7 : {
            HSSPublicKeyParameters hSSPublicKeyParameters;
            if (object instanceof HSSPublicKeyParameters) {
                return (HSSPublicKeyParameters)object;
            }
            if (object instanceof DataInputStream) {
                return new HSSPublicKeyParameters(((DataInputStream)object).readInt(), LMSPublicKeyParameters.getInstance(object));
            }
            if (!(object instanceof byte[])) {
                if (!(object instanceof InputStream)) throw new IllegalArgumentException(GeneratedOutlineSupport.outline17((String)"cannot parse ", (Object)object));
                return HSSPublicKeyParameters.getInstance(Streams.readAll((InputStream)object));
            }
            dataInputStream = null;
            DataInputStream dataInputStream2 = new DataInputStream((InputStream)new ByteArrayInputStream((byte[])object));
            try {
                hSSPublicKeyParameters = HSSPublicKeyParameters.getInstance((Object)dataInputStream2);
            }
            catch (Throwable throwable) {
                dataInputStream = dataInputStream2;
                break block7;
            }
            dataInputStream2.close();
            return hSSPublicKeyParameters;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dataInputStream == null) throw var3_6;
        dataInputStream.close();
        throw var3_6;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (HSSPublicKeyParameters.class != object.getClass()) {
                return false;
            }
            HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters)object;
            if (this.l != hSSPublicKeyParameters.l) {
                return false;
            }
            return this.lmsPublicKey.equals(hSSPublicKeyParameters.lmsPublicKey);
        }
        return false;
    }

    @Override
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = this.l;
        byteArrayOutputStream.write((int)((byte)(n2 >>> 24)));
        byteArrayOutputStream.write((int)((byte)(n2 >>> 16)));
        byteArrayOutputStream.write((int)((byte)(n2 >>> 8)));
        byteArrayOutputStream.write((int)((byte)n2));
        byte[] arrby = this.lmsPublicKey.getEncoded();
        try {
            byteArrayOutputStream.write(arrby);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return 31 * this.l + this.lmsPublicKey.hashCode();
    }
}

