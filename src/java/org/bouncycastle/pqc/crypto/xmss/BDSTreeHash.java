/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import org.bouncycastle.pqc.crypto.xmss.XMSSNode;

public class BDSTreeHash
implements Serializable,
Cloneable {
    public boolean finished;
    public int height;
    public final int initialHeight;
    public boolean initialized;
    public int nextIndex;
    public XMSSNode tailNode;

    public BDSTreeHash(int n2) {
        this.initialHeight = n2;
        this.initialized = false;
        this.finished = false;
    }

    public BDSTreeHash clone() {
        BDSTreeHash bDSTreeHash = new BDSTreeHash(this.initialHeight);
        bDSTreeHash.tailNode = this.tailNode;
        bDSTreeHash.height = this.height;
        bDSTreeHash.nextIndex = this.nextIndex;
        bDSTreeHash.initialized = this.initialized;
        bDSTreeHash.finished = this.finished;
        return bDSTreeHash;
    }

    public int getHeight() {
        if (this.initialized && !this.finished) {
            return this.height;
        }
        return Integer.MAX_VALUE;
    }
}

