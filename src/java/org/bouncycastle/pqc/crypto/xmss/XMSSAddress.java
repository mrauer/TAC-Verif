/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.math.raw.Nat576;

public abstract class XMSSAddress {
    public final int keyAndMask;
    public final int layerAddress;
    public final long treeAddress;
    public final int type;

    public XMSSAddress(Builder builder) {
        this.layerAddress = builder.layerAddress;
        this.treeAddress = builder.treeAddress;
        this.type = builder.type;
        this.keyAndMask = builder.keyAndMask;
    }

    public byte[] toByteArray() {
        byte[] arrby = new byte[32];
        Nat576.intToBigEndian(this.layerAddress, arrby, 0);
        Nat576.longToBigEndian(this.treeAddress, arrby, 4);
        Nat576.intToBigEndian(this.type, arrby, 12);
        Nat576.intToBigEndian(this.keyAndMask, arrby, 28);
        return arrby;
    }

    public static abstract class Builder<T extends Builder> {
        public int keyAndMask = 0;
        public int layerAddress = 0;
        public long treeAddress = 0L;
        public final int type;

        public Builder(int n2) {
            this.type = n2;
        }

        public abstract T getThis();

        public T withKeyAndMask(int n2) {
            this.keyAndMask = n2;
            return this.getThis();
        }

        public T withLayerAddress(int n2) {
            this.layerAddress = n2;
            return this.getThis();
        }

        public T withTreeAddress(long l2) {
            this.treeAddress = l2;
            return this.getThis();
        }
    }

}

