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

public final class SimpleVariable
extends VariableSpec {
    public SimpleVariable(String string) {
        super(VariableSpecType.SIMPLE, string);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (SimpleVariable.class != object.getClass()) {
            return false;
        }
        SimpleVariable simpleVariable = (SimpleVariable)object;
        return this.name.equals((Object)simpleVariable.name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return GeneratedOutlineSupport.outline21((StringBuilder)new StringBuilder(), (String)this.name, (String)" (simple)");
    }
}

