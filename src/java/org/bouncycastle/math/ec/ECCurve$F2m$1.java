/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  org.bouncycastle.math.ec.ECCurve$F2m
 *  org.bouncycastle.math.ec.ECFieldElement$F2m
 *  org.bouncycastle.math.ec.ECPoint$F2m
 */
package org.bouncycastle.math.ec;

import java.util.Objects;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.LongArray;

/*
 * Exception performing whole class analysis.
 */
public class ECCurve$F2m$1
extends AbstractECLookupTable {
    public final /* synthetic */ ECCurve.F2m this$0;
    public final /* synthetic */ int val$FE_LONGS;
    public final /* synthetic */ int[] val$ks;
    public final /* synthetic */ int val$len;
    public final /* synthetic */ long[] val$table;

    public ECCurve$F2m$1(ECCurve.F2m f2m, int n2, int n3, long[] arrl, int[] arrn) {
        this.this$0 = f2m;
        this.val$len = n2;
        this.val$FE_LONGS = n3;
        this.val$table = arrl;
        this.val$ks = arrn;
    }

    @Override
    public int getSize() {
        return this.val$len;
    }

    @Override
    public ECPoint lookup(int n2) {
        int n3 = this.val$FE_LONGS;
        long[] arrl = new long[n3];
        long[] arrl2 = new long[n3];
        int n4 = 0;
        for (int i2 = 0; i2 < this.val$len; ++i2) {
            int n5;
            long l2 = -1 + (i2 ^ n2) >> 31;
            for (int i3 = 0; i3 < (n5 = this.val$FE_LONGS); ++i3) {
                long l3 = arrl[i3];
                long[] arrl3 = this.val$table;
                arrl[i3] = l3 ^ l2 & arrl3[n4 + i3];
                arrl2[i3] = arrl2[i3] ^ l2 & arrl3[i3 + (n5 + n4)];
            }
            n4 += n5 * 2;
        }
        ECFieldElement.F2m f2m = new /* Unavailable Anonymous Inner Class!! */;
        ECFieldElement.F2m f2m2 = new /* Unavailable Anonymous Inner Class!! */;
        ECCurve.F2m f2m3 = this.this$0;
        Objects.requireNonNull((Object)f2m3);
        return new /* Unavailable Anonymous Inner Class!! */;
    }
}

