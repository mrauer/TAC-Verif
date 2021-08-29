/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.math.BigInteger
 *  org.bouncycastle.math.ec.ECFieldElement
 */
package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.endo.GLVTypeBParameters;

public class GLVTypeBEndomorphism {
    public GLVTypeBEndomorphism(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        eCCurve.fromBigInteger(gLVTypeBParameters.beta);
    }
}

