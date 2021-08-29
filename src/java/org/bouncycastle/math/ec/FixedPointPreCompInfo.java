/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

public class FixedPointPreCompInfo
implements PreCompInfo {
    public AbstractECLookupTable lookupTable = null;
    public ECPoint offset = null;
    public int width = -1;
}

