/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.pqc.crypto.xmss.OTSHashAddress
 *  org.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder
 */
package org.bouncycastle.pqc.crypto.xmss;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.KeyedHashFunctions;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusParameters;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;

public final class WOTSPlus {
    public final KeyedHashFunctions khf;
    public final WOTSPlusParameters params;
    public byte[] publicSeed;
    public byte[] secretKeySeed;

    public WOTSPlus(WOTSPlusParameters wOTSPlusParameters) {
        Objects.requireNonNull((Object)wOTSPlusParameters, (String)"params == null");
        this.params = wOTSPlusParameters;
        int n2 = wOTSPlusParameters.digestSize;
        this.khf = new KeyedHashFunctions(wOTSPlusParameters.treeDigest, n2);
        this.secretKeySeed = new byte[n2];
        this.publicSeed = new byte[n2];
    }

    public final byte[] chain(byte[] arrby, int n2, int n3, OTSHashAddress oTSHashAddress) {
        int n4 = this.params.digestSize;
        if (arrby.length == n4) {
            oTSHashAddress.toByteArray();
            int n5 = n2 + n3;
            if (n5 <= this.params.winternitzParameter - 1) {
                if (n3 == 0) {
                    return arrby;
                }
                byte[] arrby2 = this.chain(arrby, n2, n3 - 1, oTSHashAddress);
                OTSHashAddress.Builder builder = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress);
                builder.otsAddress = oTSHashAddress.otsAddress;
                builder.chainAddress = oTSHashAddress.chainAddress;
                builder.hashAddress = n5 - 1;
                OTSHashAddress oTSHashAddress2 = (OTSHashAddress)((OTSHashAddress.Builder)builder.withKeyAndMask(0)).build();
                byte[] arrby3 = this.khf.PRF(this.publicSeed, oTSHashAddress2.toByteArray());
                OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress2.layerAddress)).withTreeAddress(oTSHashAddress2.treeAddress);
                builder2.otsAddress = oTSHashAddress2.otsAddress;
                builder2.chainAddress = oTSHashAddress2.chainAddress;
                builder2.hashAddress = oTSHashAddress2.hashAddress;
                OTSHashAddress oTSHashAddress3 = (OTSHashAddress)((OTSHashAddress.Builder)builder2.withKeyAndMask(1)).build();
                byte[] arrby4 = this.khf.PRF(this.publicSeed, oTSHashAddress3.toByteArray());
                byte[] arrby5 = new byte[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    arrby5[i2] = (byte)(arrby2[i2] ^ arrby4[i2]);
                }
                KeyedHashFunctions keyedHashFunctions = this.khf;
                Objects.requireNonNull((Object)keyedHashFunctions);
                int n6 = arrby3.length;
                int n7 = keyedHashFunctions.digestSize;
                if (n6 == n7) {
                    if (n4 == n7) {
                        return keyedHashFunctions.coreDigest(0, arrby3, arrby5);
                    }
                    throw new IllegalArgumentException("wrong in length");
                }
                throw new IllegalArgumentException("wrong key length");
            }
            throw new IllegalArgumentException("max chain length must not be greater than w");
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline12((String)"startHash needs to be ", (int)n4, (String)"bytes"));
    }

    public WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress oTSHashAddress) {
        WOTSPlusParameters wOTSPlusParameters;
        byte[][] arrarrby;
        block1 : {
            arrarrby = new byte[this.params.len][];
            int n2 = 0;
            do {
                wOTSPlusParameters = this.params;
                if (n2 >= wOTSPlusParameters.len) break block1;
                OTSHashAddress.Builder builder = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress);
                builder.otsAddress = oTSHashAddress.otsAddress;
                builder.chainAddress = n2;
                builder.hashAddress = oTSHashAddress.hashAddress;
                oTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)builder.withKeyAndMask(oTSHashAddress.keyAndMask)).build();
                if (n2 < 0 || n2 >= this.params.len) break;
                arrarrby[n2] = this.chain(this.khf.PRF(this.secretKeySeed, Nat576.toBytesBigEndian(n2, 32)), 0, -1 + this.params.winternitzParameter, oTSHashAddress);
                ++n2;
            } while (true);
            throw new IllegalArgumentException("index out of bounds");
        }
        return new WOTSPlusPublicKeyParameters(wOTSPlusParameters, arrarrby);
    }

    public byte[] getWOTSPlusSecretKey(byte[] arrby, OTSHashAddress oTSHashAddress) {
        OTSHashAddress.Builder builder = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress);
        builder.otsAddress = oTSHashAddress.otsAddress;
        OTSHashAddress oTSHashAddress2 = (OTSHashAddress)builder.build();
        return this.khf.PRF(arrby, oTSHashAddress2.toByteArray());
    }

    public void importKeys(byte[] arrby, byte[] arrby2) {
        int n2 = arrby.length;
        int n3 = this.params.digestSize;
        if (n2 == n3) {
            Objects.requireNonNull((Object)arrby2, (String)"publicSeed == null");
            if (arrby2.length == n3) {
                this.secretKeySeed = arrby;
                this.publicSeed = arrby2;
                return;
            }
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }
}

