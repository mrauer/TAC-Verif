/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlus;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.util.Encodable;

public final class XMSSPrivateKeyParameters
extends XMSSKeyParameters
implements Encodable {
    public volatile BDS bdsState;
    public final XMSSParameters params;
    public final byte[] publicSeed;
    public final byte[] root;
    public final byte[] secretKeyPRF;
    public final byte[] secretKeySeed;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public XMSSPrivateKeyParameters(Builder builder, 1 var2_2) {
        block12 : {
            int n2;
            int n3;
            XMSSParameters xMSSParameters;
            block11 : {
                BDS bDS;
                block10 : {
                    xMSSParameters = builder.params;
                    super(true, xMSSParameters.treeDigest);
                    this.params = xMSSParameters;
                    int n4 = xMSSParameters.treeDigestSize;
                    byte[] arrby = builder.secretKeySeed;
                    if (arrby != null) {
                        if (arrby.length != n4) throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
                        this.secretKeySeed = arrby;
                    } else {
                        this.secretKeySeed = new byte[n4];
                    }
                    byte[] arrby2 = builder.secretKeyPRF;
                    if (arrby2 != null) {
                        if (arrby2.length != n4) throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
                        this.secretKeyPRF = arrby2;
                    } else {
                        this.secretKeyPRF = new byte[n4];
                    }
                    byte[] arrby3 = builder.publicSeed;
                    if (arrby3 != null) {
                        if (arrby3.length != n4) throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
                        this.publicSeed = arrby3;
                    } else {
                        this.publicSeed = new byte[n4];
                    }
                    byte[] arrby4 = builder.root;
                    if (arrby4 != null) {
                        if (arrby4.length != n4) throw new IllegalArgumentException("size of root needs to be equal size of digest");
                        this.root = arrby4;
                    } else {
                        this.root = new byte[n4];
                    }
                    bDS = builder.bdsState;
                    if (bDS != null) break block10;
                    n2 = builder.index;
                    n3 = 1 << xMSSParameters.height;
                    if (n2 < n3 - 2 && arrby3 != null && arrby != null) {
                        OTSHashAddress oTSHashAddress = (OTSHashAddress)new OTSHashAddress.Builder().build();
                        int n5 = builder.index;
                        WOTSPlus wOTSPlus = xMSSParameters.getWOTSPlus();
                        int n6 = xMSSParameters.height;
                        bDS = new BDS(wOTSPlus, n6, xMSSParameters.k, (1 << n6) - 1);
                        bDS.initialize(arrby3, arrby, oTSHashAddress);
                        while (bDS.index < n5) {
                            bDS.nextAuthenticationPath(arrby3, arrby, oTSHashAddress);
                            bDS.used = false;
                        }
                    }
                    break block11;
                }
                this.bdsState = bDS;
                break block12;
            }
            int n7 = n3 - 1;
            BDS bDS = new BDS(xMSSParameters.getWOTSPlus(), xMSSParameters.height, xMSSParameters.k, n2);
            bDS.maxIndex = n7;
            bDS.index = n2;
            bDS.used = true;
            this.bdsState = bDS;
        }
        int n8 = builder.maxIndex;
        if (n8 < 0) return;
        if (n8 != this.bdsState.maxIndex) throw new IllegalArgumentException("maxIndex set but not reflected in state");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public byte[] getEncoded() throws IOException {
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this;
        synchronized (xMSSPrivateKeyParameters) {
            return this.toByteArray();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] toByteArray() {
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this;
        synchronized (xMSSPrivateKeyParameters) {
            byte[] arrby;
            int n2 = this.params.treeDigestSize;
            int n3 = n2 + 4;
            int n4 = n3 + n2;
            int n5 = n4 + n2;
            byte[] arrby2 = new byte[n2 + n5];
            Nat576.intToBigEndian(this.bdsState.index, arrby2, 0);
            Nat576.copyBytesAtOffset(arrby2, this.secretKeySeed, 4);
            Nat576.copyBytesAtOffset(arrby2, this.secretKeyPRF, n3);
            Nat576.copyBytesAtOffset(arrby2, this.publicSeed, n4);
            Nat576.copyBytesAtOffset(arrby2, this.root, n5);
            try {
                BDS bDS = this.bdsState;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream((OutputStream)byteArrayOutputStream);
                objectOutputStream.writeObject((Object)bDS);
                objectOutputStream.flush();
                arrby = byteArrayOutputStream.toByteArray();
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error serializing bds state: ");
                stringBuilder.append(iOException.getMessage());
                throw new RuntimeException(stringBuilder.toString());
            }
            return Nat576.concatenate(arrby2, arrby);
        }
    }

}

