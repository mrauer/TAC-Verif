/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;

public final class OTSHashAddress
extends XMSSAddress {
    public final int chainAddress;
    public final int hashAddress;
    public final int otsAddress;

    public OTSHashAddress(Builder builder, 1 var2_2) {
        super(builder);
        this.otsAddress = builder.otsAddress;
        this.chainAddress = builder.chainAddress;
        this.hashAddress = builder.hashAddress;
    }

    @Override
    public byte[] toByteArray() {
        byte[] arrby = super.toByteArray();
        Nat576.intToBigEndian(this.otsAddress, arrby, 16);
        Nat576.intToBigEndian(this.chainAddress, arrby, 20);
        Nat576.intToBigEndian(this.hashAddress, arrby, 24);
        return arrby;
    }

    public static class Builder
    extends XMSSAddress.Builder<Builder> {
        public int chainAddress = 0;
        public int hashAddress = 0;
        public int otsAddress = 0;

        public Builder() {
            super(0);
        }

        public XMSSAddress build() {
            return new OTSHashAddress(this, null);
        }

        @Override
        public XMSSAddress.Builder getThis() {
            return this;
        }
    }

}

