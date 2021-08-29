/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.uritemplate.vars.specs;

import com.github.fge.uritemplate.vars.specs.VariableSpecType;

public abstract class VariableSpec {
    public final String name;

    public VariableSpec(VariableSpecType variableSpecType, String string) {
        this.name = string;
    }
}

