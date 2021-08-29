/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  java.util.TreeMap
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.pqc.crypto.xmss.OTSHashAddress
 *  org.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlus;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;

public class BDSStateMap
implements Serializable {
    public final Map<Integer, BDS> bdsState;
    public transient long maxIndex;

    public BDSStateMap(long l2) {
        this.bdsState = new TreeMap();
        this.maxIndex = l2;
    }

    public BDSStateMap(BDSStateMap bDSStateMap, long l2) {
        this.bdsState = new TreeMap();
        for (Integer n2 : bDSStateMap.bdsState.keySet()) {
            this.bdsState.put((Object)n2, (Object)new BDS((BDS)bDSStateMap.bdsState.get((Object)n2)));
        }
        this.maxIndex = l2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public BDSStateMap(XMSSMTParameters var1_1, long var2_2, byte[] var4_3, byte[] var5_4) {
        var6_5 = var1_1;
        super();
        this.bdsState = new TreeMap();
        var7_6 = var6_5.height;
        var8_7 = 1L;
        this.maxIndex = (var8_7 << var7_6) - var8_7;
        var10_8 = 0L;
        while (var10_8 < var2_2) {
            var12_9 = var6_5.xmssParams;
            var13_10 = var12_9.height;
            var14_11 = var10_8 >> var13_10;
            var16_12 = (var8_7 << var13_10) - var8_7;
            var18_13 = (int)(var10_8 & var16_12);
            var19_14 = (OTSHashAddress.Builder)new OTSHashAddress.Builder().withTreeAddress(var14_11);
            var19_14.otsAddress = var18_13;
            var20_15 = (OTSHashAddress)var19_14.build();
            var21_16 = 1 << var13_10;
            var22_17 = var21_16 - 1;
            if (var18_13 < var22_17) {
                var56_44 = this.bdsState;
                var24_19 = var22_17;
                if ((BDS)var56_44.get((Object)0) != null && var18_13 != 0) {
                    var23_18 = var12_9;
                } else {
                    var57_45 = var12_9.getWOTSPlus();
                    var58_46 = var12_9.height;
                    var59_47 = var12_9.k;
                    var60_48 = 1 << var58_46;
                    var23_18 = var12_9;
                    var61_49 = new BDS(var57_45, var58_46, var59_47, var60_48 - 1);
                    var61_49.initialize(var4_3, var5_4, var20_15);
                    this.bdsState.put((Object)0, (Object)var61_49);
                }
                this.update(0, var4_3, var5_4, var20_15);
            } else {
                var23_18 = var12_9;
                var24_19 = var22_17;
            }
            var26_21 = var14_11;
            for (var25_20 = 1; var25_20 < var6_5.layers; ++var25_20) {
                block12 : {
                    block11 : {
                        block9 : {
                            block10 : {
                                var28_22 = (int)(var26_21 & var16_12);
                                var29_23 = var26_21 >> var13_10;
                                var31_24 = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(var25_20)).withTreeAddress(var29_23);
                                var31_24.otsAddress = var28_22;
                                var32_25 = (OTSHashAddress)var31_24.build();
                                if (this.bdsState.get((Object)var25_20) == null) break block9;
                                if (var10_8 != 0L) break block10;
                                var33_26 = var13_10;
                                var34_27 = var29_23;
                                var36_28 = var16_12;
                                ** GOTO lbl-1000
                            }
                            var33_26 = var13_10;
                            var34_27 = var29_23;
                            var52_41 = var21_16;
                            var54_42 = var25_20 + 1;
                            var36_28 = var16_12;
                            if (var10_8 % (long)Math.pow((double)var52_41, (double)var54_42) == 0L) {
                                var55_43 = true;
                            } else lbl-1000: // 2 sources:
                            {
                                var55_43 = false;
                            }
                            if (var55_43) break block11;
                            var43_34 = var33_26;
                            var49_39 = var24_19;
                            var46_37 = var23_18;
                            break block12;
                        }
                        var33_26 = var13_10;
                        var34_27 = var29_23;
                        var36_28 = var16_12;
                    }
                    var38_29 = this.bdsState;
                    var39_30 = var25_20;
                    var40_31 = var23_18.getWOTSPlus();
                    var41_32 = var23_18;
                    var42_33 = var41_32.height;
                    var43_34 = var33_26;
                    var44_35 = var41_32.k;
                    var45_36 = 1 << var42_33;
                    var46_37 = var41_32;
                    var47_38 = new BDS(var40_31, var42_33, var44_35, var45_36 - 1);
                    var47_38.initialize(var4_3, var5_4, var32_25);
                    var38_29.put((Object)var39_30, (Object)var47_38);
                    var49_39 = var24_19;
                }
                if (var28_22 < var49_39 && (var50_40 = var10_8 != 0L && (var10_8 + 1L) % (long)Math.pow((double)var21_16, (double)var25_20) == 0L)) {
                    this.update(var25_20, var4_3, var5_4, var32_25);
                }
                var24_19 = var49_39;
                var26_21 = var34_27;
                var13_10 = var43_34;
                var16_12 = var36_28;
                var23_18 = var46_37;
                var6_5 = var1_1;
            }
            ++var10_8;
            var6_5 = var1_1;
            var8_7 = 1L;
        }
    }

    public BDS update(int n2, byte[] arrby, byte[] arrby2, OTSHashAddress oTSHashAddress) {
        return (BDS)this.bdsState.put((Object)n2, (Object)new BDS((BDS)this.bdsState.get((Object)n2), arrby, arrby2, oTSHashAddress));
    }

    public BDSStateMap withWOTSDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        BDSStateMap bDSStateMap = new BDSStateMap(this.maxIndex);
        for (Integer n2 : this.bdsState.keySet()) {
            Map<Integer, BDS> map = bDSStateMap.bdsState;
            BDS bDS = (BDS)this.bdsState.get((Object)n2);
            Objects.requireNonNull((Object)bDS);
            map.put((Object)n2, (Object)new BDS(bDS, aSN1ObjectIdentifier));
        }
        return bDSStateMap;
    }
}

