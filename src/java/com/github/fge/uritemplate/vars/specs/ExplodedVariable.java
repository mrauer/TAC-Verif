/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.github.fge.uritemplate.vars.specs;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.uritemplate.vars.specs.VariableSpec;
import com.github.fge.uritemplate.vars.specs.VariableSpecType;

public final class ExplodedVariable
extends VariableSpec {
    public ExplodedVariable(String string) {
        super(VariableSpecType.EXPLODED, string);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (ExplodedVariable.class != object.getClass()) {
            return false;
        }
        ExplodedVariable explodedVariable = (ExplodedVariable)object;
        return this.name.equals((Object)explodedVariable.name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return GeneratedOutlineSupport.outline21((StringBuilder)new StringBuilder(), (String)this.name, (String)" (exploded)");
    }
}

