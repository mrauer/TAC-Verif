/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.util.Encodable;

public final class XMSSMTPublicKeyParameters
extends XMSSMTKeyParameters
implements Encodable {
    public final int oid;
    public final XMSSMTParameters params;
    public final byte[] publicSeed;
    public final byte[] root;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public XMSSMTPublicKeyParameters(Builder builder, 1 var2_2) {
        XMSSMTParameters xMSSMTParameters = builder.params;
        XMSSParameters xMSSParameters = xMSSMTParameters.xmssParams;
        super(false, xMSSParameters.treeDigest);
        this.params = xMSSMTParameters;
        int n2 = xMSSParameters.treeDigestSize;
        byte[] arrby = builder.publicKey;
        if (arrby != null) {
            if (arrby.length == n2 + n2) {
                this.oid = 0;
                this.root = Nat576.extractBytesAtOffset(arrby, 0, n2);
                this.publicSeed = Nat576.extractBytesAtOffset(arrby, n2 + 0, n2);
                return;
            }
            int n3 = arrby.length;
            int n4 = n2 + 4;
            if (n3 != n4 + n2) throw new IllegalArgumentException("public key has wrong size");
            this.oid = Nat576.bigEndianToInt(arrby, 0);
            this.root = Nat576.extractBytesAtOffset(arrby, 4, n2);
            this.publicSeed = Nat576.extractBytesAtOffset(arrby, n4, n2);
            return;
        }
        XMSSOid xMSSOid = xMSSMTParameters.oid;
        this.oid = xMSSOid != null ? xMSSOid.getOid() : 0;
        byte[] arrby2 = builder.root;
        if (arrby2 != null) {
            if (arrby2.length != n2) throw new IllegalArgumentException("length of root must be equal to length of digest");
            this.root = arrby2;
        } else {
            this.root = new byte[n2];
        }
        byte[] arrby3 = builder.publicSeed;
        if (arrby3 != null) {
            if (arrby3.length != n2) throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            this.publicSeed = arrby3;
            return;
        }
        this.publicSeed = new byte[n2];
    }

    @Override
    public byte[] getEncoded() throws IOException {
        return this.toByteArray();
    }

    public byte[] toByteArray() {
        byte[] arrby;
        int n2 = this.params.xmssParams.treeDigestSize;
        int n3 = 0;
        int n4 = this.oid;
        if (n4 != 0) {
            arrby = new byte[n2 + (n2 + 4)];
            Nat576.intToBigEndian(n4, arrby, 0);
            n3 = 4;
        } else {
            arrby = new byte[n2 + n2];
        }
        Nat576.copyBytesAtOffset(arrby, this.root, n3);
        int n5 = n3 + n2;
        Nat576.copyBytesAtOffset(arrby, this.publicSeed, n5);
        return arrby;
    }

}

