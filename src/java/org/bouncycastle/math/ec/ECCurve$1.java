/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.math.BigInteger
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public class ECCurve$1
extends AbstractECLookupTable {
    public final /* synthetic */ ECCurve this$0;
    public final /* synthetic */ int val$FE_BYTES;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ byte[] val$table;

    public ECCurve$1(ECCurve eCCurve, int n2, int n3, byte[] arrby) {
        this.this$0 = eCCurve;
        this.val$len = n2;
        this.val$FE_BYTES = n3;
        this.val$table = arrby;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int n3 = this.val$FE_BYTES;
        byte[] arrby = new byte[n3];
        byte[] arrby2 = new byte[n3];
        int n4 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n5;
            int n6 = (i2 ^ n2) - 1 >> 31;
            for (int i3 = 0; i3 < (n5 = this.val$FE_BYTES); ++i3) {
                byte by = arrby[i3];
                byte[] arrby3 = this.val$table;
                arrby[i3] = (byte)(by ^ n6 & arrby3[n4 + i3]);
                arrby2[i3] = (byte)(arrby2[i3] ^ n6 & arrby3[i3 + (n5 + n4)]);
            }
            n4 += n5 * 2;
        }
        ECCurve eCCurve = this.this$0;
        return eCCurve.createRawPoint(eCCurve.fromBigInteger(new BigInteger(1, arrby)), this.this$0.fromBigInteger(new BigInteger(1, arrby2)));
    }
}

