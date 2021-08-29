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

public final class QTESLAPrivateKeyParameters
extends AsymmetricKeyParameter {
    public byte[] privateKey;
    public int securityCategory;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public QTESLAPrivateKeyParameters(int n2, byte[] arrby) {
        int n3;
        super(true);
        int n4 = arrby.length;
        if (n2 != 5) {
            if (n2 != 6) throw new IllegalArgumentException(GeneratedOutlineSupport.outline11((String)"unknown security category: ", (int)n2));
            n3 = 12392;
        } else {
            n3 = 5224;
        }
        if (n4 != n3) throw new IllegalArgumentException("invalid key size for security category");
        this.securityCategory = n2;
        this.privateKey = Nat576.clone(arrby);
    }

    public byte[] getSecret() {
        return Nat576.clone(this.privateKey);
    }
}

