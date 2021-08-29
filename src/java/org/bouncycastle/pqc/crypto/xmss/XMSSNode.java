/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import org.bouncycastle.math.raw.Nat576;

public final class XMSSNode
implements Serializable {
    public final int height;
    public final byte[] value;

    public XMSSNode(int n2, byte[] arrby) {
        this.height = n2;
        this.value = arrby;
    }

    public byte[] getValue() {
        return Nat576.cloneArray(this.value);
    }
}

