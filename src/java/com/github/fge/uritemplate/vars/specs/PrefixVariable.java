/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.uritemplate.vars.specs;

import com.github.fge.uritemplate.vars.specs.VariableSpec;
import com.github.fge.uritemplate.vars.specs.VariableSpecType;

public final class PrefixVariable
extends VariableSpec {
    public final int length;

    public PrefixVariable(String string, int n) {
        super(VariableSpecType.PREFIX, string);
        this.length = n;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (PrefixVariable.class != object.getClass()) {
            return false;
        }
        PrefixVariable prefixVariable = (PrefixVariable)object;
        boolean bl = this.name.equals((Object)prefixVariable.name);
        boolean bl2 = false;
        if (bl) {
            int n = this.length;
            int n2 = prefixVariable.length;
            bl2 = false;
            if (n == n2) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * this.name.hashCode() + this.length;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(" (prefix length: ");
        stringBuilder.append(this.length);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

