/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.HashTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;

public final class HashTreeAddress
extends XMSSAddress {
    public final int treeHeight;
    public final int treeIndex;

    public HashTreeAddress(Builder builder, 1 var2_2) {
        super(builder);
        this.treeHeight = builder.treeHeight;
        this.treeIndex = builder.treeIndex;
    }

    @Override
    public byte[] toByteArray() {
        byte[] arrby = super.toByteArray();
        Nat576.intToBigEndian(0, arrby, 16);
        Nat576.intToBigEndian(this.treeHeight, arrby, 20);
        Nat576.intToBigEndian(this.treeIndex, arrby, 24);
        return arrby;
    }

    public static class Builder
    extends XMSSAddress.Builder<Builder> {
        public int treeHeight = 0;
        public int treeIndex = 0;

        public Builder() {
            super(2);
        }

        public XMSSAddress build() {
            return new HashTreeAddress(this, null);
        }

        @Override
        public XMSSAddress.Builder getThis() {
            return this;
        }
    }

}

