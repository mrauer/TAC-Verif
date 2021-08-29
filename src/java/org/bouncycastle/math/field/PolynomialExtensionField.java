/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.bouncycastle.math.field;

import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.GF2Polynomial;

public interface PolynomialExtensionField
extends FiniteField {
    public GF2Polynomial getMinimalPolynomial();
}

