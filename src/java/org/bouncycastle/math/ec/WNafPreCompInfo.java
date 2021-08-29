/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

public class WNafPreCompInfo
implements PreCompInfo {
    public int confWidth = -1;
    public ECPoint[] preComp = null;
    public ECPoint[] preCompNeg = null;
    public ECPoint twice = null;
    public int width = -1;
}

