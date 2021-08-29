/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.util.Encodable;

public final class XMSSMTPrivateKeyParameters
extends XMSSMTKeyParameters
implements Encodable {
    public volatile BDSStateMap bdsState;
    public volatile long index;
    public final XMSSMTParameters params;
    public final byte[] publicSeed;
    public final byte[] root;
    public final byte[] secretKeyPRF;
    public final byte[] secretKeySeed;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public XMSSMTPrivateKeyParameters(Builder builder, 1 var2_2) {
        XMSSMTParameters xMSSMTParameters = builder.params;
        XMSSParameters xMSSParameters = xMSSMTParameters.xmssParams;
        super(true, xMSSParameters.treeDigest);
        this.params = xMSSMTParameters;
        int n2 = xMSSParameters.treeDigestSize;
        this.index = builder.index;
        byte[] arrby = builder.secretKeySeed;
        if (arrby != null) {
            if (arrby.length != n2) throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            this.secretKeySeed = arrby;
        } else {
            this.secretKeySeed = new byte[n2];
        }
        byte[] arrby2 = builder.secretKeyPRF;
        if (arrby2 != null) {
            if (arrby2.length != n2) throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            this.secretKeyPRF = arrby2;
        } else {
            this.secretKeyPRF = new byte[n2];
        }
        byte[] arrby3 = builder.publicSeed;
        if (arrby3 != null) {
            if (arrby3.length != n2) throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            this.publicSeed = arrby3;
        } else {
            this.publicSeed = new byte[n2];
        }
        byte[] arrby4 = builder.root;
        if (arrby4 != null) {
            if (arrby4.length != n2) throw new IllegalArgumentException("size of root needs to be equal size of digest");
            this.root = arrby4;
        } else {
            this.root = new byte[n2];
        }
        BDSStateMap bDSStateMap = builder.bdsState;
        if (bDSStateMap == null) {
            long l2 = builder.index;
            if (Nat576.isIndexValid(xMSSMTParameters.height, l2) && arrby3 != null && arrby != null) {
                long l3 = builder.index;
                bDSStateMap = new BDSStateMap(xMSSMTParameters, l3, arrby3, arrby);
            } else {
                bDSStateMap = new BDSStateMap(1L + builder.maxIndex);
            }
        }
        this.bdsState = bDSStateMap;
        long l4 = builder.maxIndex;
        if (l4 < 0L) return;
        if (l4 != this.bdsState.maxIndex) throw new IllegalArgumentException("maxIndex set but not reflected in state");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public byte[] getEncoded() throws IOException {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this;
        synchronized (xMSSMTPrivateKeyParameters) {
            return this.toByteArray();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] toByteArray() {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this;
        synchronized (xMSSMTPrivateKeyParameters) {
            XMSSMTParameters xMSSMTParameters = this.params;
            int n2 = xMSSMTParameters.xmssParams.treeDigestSize;
            int n3 = (7 + xMSSMTParameters.height) / 8;
            byte[] arrby = new byte[n2 + (n2 + (n2 + (n3 + n2)))];
            Nat576.copyBytesAtOffset(arrby, Nat576.toBytesBigEndian(this.index, n3), 0);
            int n4 = n3 + 0;
            Nat576.copyBytesAtOffset(arrby, this.secretKeySeed, n4);
            int n5 = n4 + n2;
            Nat576.copyBytesAtOffset(arrby, this.secretKeyPRF, n5);
            int n6 = n5 + n2;
            Nat576.copyBytesAtOffset(arrby, this.publicSeed, n6);
            int n7 = n6 + n2;
            Nat576.copyBytesAtOffset(arrby, this.root, n7);
            try {
                BDSStateMap bDSStateMap = this.bdsState;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream((OutputStream)byteArrayOutputStream);
                objectOutputStream.writeObject((Object)bDSStateMap);
                objectOutputStream.flush();
                return Nat576.concatenate(arrby, byteArrayOutputStream.toByteArray());
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error serializing bds state: ");
                stringBuilder.append(iOException.getMessage());
                throw new IllegalStateException(stringBuilder.toString(), (Throwable)iOException);
            }
        }
    }

}

