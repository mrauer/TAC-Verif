/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.PreCompInfo;

public class ValidityPrecompInfo
implements PreCompInfo {
    public boolean curveEquationPassed = false;
    public boolean failed = false;
    public boolean orderPassed = false;
}

