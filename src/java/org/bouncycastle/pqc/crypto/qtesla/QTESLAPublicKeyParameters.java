/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package org.bouncycastle.pqc.crypto.qtesla;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.math.raw.Nat576;

public final class QTESLAPublicKeyParameters
extends AsymmetricKeyParameter {
    public byte[] publicKey;
    public int securityCategory;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public QTESLAPublicKeyParameters(int n2, byte[] arrby) {
        int n3;
        super(false);
        int n4 = arrby.length;
        if (n2 != 5) {
            if (n2 != 6) throw new IllegalArgumentException(GeneratedOutlineSupport.outline11((String)"unknown security category: ", (int)n2));
            n3 = 38432;
        } else {
            n3 = 14880;
        }
        if (n4 != n3) throw new IllegalArgumentException("invalid key size for security category");
        this.securityCategory = n2;
        this.publicKey = Nat576.clone(arrby);
    }

    public byte[] getPublicData() {
        return Nat576.clone(this.publicKey);
    }
}

