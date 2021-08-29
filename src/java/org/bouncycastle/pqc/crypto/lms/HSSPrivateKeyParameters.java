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
 *  java.lang.CloneNotSupportedException
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package org.bouncycastle.pqc.crypto.lms;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.pqc.crypto.lms.Composer;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSSignature;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

public class HSSPrivateKeyParameters
extends LMSKeyParameters {
    public long index = 0L;
    public final long indexLimit;
    public final boolean isShard;
    public List<LMSPrivateKeyParameters> keys;
    public final int l;
    public List<LMSSignature> sig;

    public HSSPrivateKeyParameters(int n2, List<LMSPrivateKeyParameters> list, List<LMSSignature> list2, long l2, long l3, boolean bl) {
        super(true);
        this.l = n2;
        this.keys = Collections.unmodifiableList(list);
        this.sig = Collections.unmodifiableList(list2);
        this.index = l2;
        this.indexLimit = l3;
        this.isShard = bl;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static HSSPrivateKeyParameters getInstance(Object object) throws IOException {
        DataInputStream dataInputStream;
        void var3_16;
        block10 : {
            HSSPrivateKeyParameters hSSPrivateKeyParameters;
            if (object instanceof HSSPrivateKeyParameters) {
                return (HSSPrivateKeyParameters)object;
            }
            if (object instanceof DataInputStream) {
                int i2;
                DataInputStream dataInputStream2 = (DataInputStream)object;
                if (dataInputStream2.readInt() != 0) throw new IllegalStateException("unknown version for hss private key");
                int n2 = dataInputStream2.readInt();
                long l2 = dataInputStream2.readLong();
                long l3 = dataInputStream2.readLong();
                boolean bl = dataInputStream2.readBoolean();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int n3 = 0;
                do {
                    i2 = 0;
                    if (n3 >= n2) break;
                    arrayList.add((Object)LMSPrivateKeyParameters.getInstance(object));
                    ++n3;
                } while (true);
                do {
                    if (i2 >= n2 - 1) {
                        return new HSSPrivateKeyParameters(n2, (List<LMSPrivateKeyParameters>)arrayList, (List<LMSSignature>)arrayList2, l2, l3, bl);
                    }
                    arrayList2.add((Object)LMSSignature.getInstance(object));
                    ++i2;
                } while (true);
            }
            if (!(object instanceof byte[])) {
                if (!(object instanceof InputStream)) throw new IllegalArgumentException(GeneratedOutlineSupport.outline17((String)"cannot parse ", (Object)object));
                return HSSPrivateKeyParameters.getInstance(Streams.readAll((InputStream)object));
            }
            dataInputStream = null;
            DataInputStream dataInputStream2 = new DataInputStream((InputStream)new ByteArrayInputStream((byte[])object));
            try {
                hSSPrivateKeyParameters = HSSPrivateKeyParameters.getInstance((Object)dataInputStream2);
            }
            catch (Throwable throwable) {
                dataInputStream = dataInputStream2;
                break block10;
            }
            dataInputStream2.close();
            return hSSPrivateKeyParameters;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (dataInputStream == null) throw var3_16;
        dataInputStream.close();
        throw var3_16;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            HSSPrivateKeyParameters hSSPrivateKeyParameters = HSSPrivateKeyParameters.getInstance(this.getEncoded());
            return hSSPrivateKeyParameters;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage(), (Throwable)exception);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (HSSPrivateKeyParameters.class != object.getClass()) {
                return false;
            }
            HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters)object;
            if (this.l != hSSPrivateKeyParameters.l) {
                return false;
            }
            if (this.isShard != hSSPrivateKeyParameters.isShard) {
                return false;
            }
            if (this.indexLimit != hSSPrivateKeyParameters.indexLimit) {
                return false;
            }
            if (this.index != hSSPrivateKeyParameters.index) {
                return false;
            }
            if (!this.keys.equals(hSSPrivateKeyParameters.keys)) {
                return false;
            }
            return this.sig.equals(hSSPrivateKeyParameters.sig);
        }
        return false;
    }

    @Override
    public byte[] getEncoded() throws IOException {
        HSSPrivateKeyParameters hSSPrivateKeyParameters = this;
        synchronized (hSSPrivateKeyParameters) {
            Composer composer = new Composer();
            composer.u32str(0);
            composer.u32str(this.l);
            long l2 = this.index;
            composer.u32str((int)(l2 >>> 32));
            composer.u32str((int)l2);
            long l3 = this.indexLimit;
            composer.u32str((int)(l3 >>> 32));
            composer.u32str((int)l3);
            int n2 = this.isShard;
            composer.bos.write(n2);
            Iterator iterator = this.keys.iterator();
            while (iterator.hasNext()) {
                composer.bytes((LMSPrivateKeyParameters)iterator.next());
            }
            Iterator iterator2 = this.sig.iterator();
            while (iterator2.hasNext()) {
                composer.bytes((LMSSignature)iterator2.next());
            }
            byte[] arrby = composer.build();
            return arrby;
        }
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * this.l + this.isShard) + this.keys.hashCode()) + this.sig.hashCode());
        long l2 = this.indexLimit;
        int n3 = 31 * (n2 + (int)(l2 ^ l2 >>> 32));
        long l3 = this.index;
        return n3 + (int)(l3 ^ l3 >>> 32);
    }
}

