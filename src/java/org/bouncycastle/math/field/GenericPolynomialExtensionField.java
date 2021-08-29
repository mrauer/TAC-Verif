/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.bouncycastle.math.field;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.GF2Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;

public class GenericPolynomialExtensionField
implements PolynomialExtensionField {
    public final GF2Polynomial minimalPolynomial;
    public final FiniteField subfield;

    public GenericPolynomialExtensionField(FiniteField finiteField, GF2Polynomial gF2Polynomial) {
        this.subfield = finiteField;
        this.minimalPolynomial = gF2Polynomial;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField)object;
        return this.subfield.equals((Object)genericPolynomialExtensionField.subfield) && this.minimalPolynomial.equals(genericPolynomialExtensionField.minimalPolynomial);
    }

    @Override
    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    @Override
    public int getDimension() {
        return this.subfield.getDimension() * this.minimalPolynomial.getDegree();
    }

    @Override
    public GF2Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    public int hashCode() {
        return this.subfield.hashCode() ^ Integer.rotateLeft((int)this.minimalPolynomial.hashCode(), (int)16);
    }
}

