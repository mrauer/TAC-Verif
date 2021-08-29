/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package joptsimple;

import java.util.List;

public interface OptionDescriptor {
    public boolean acceptsArguments();

    public String argumentDescription();

    public String argumentTypeIndicator();

    public List<?> defaultValues();

    public String description();

    public boolean isRequired();

    public List<String> options();

    public boolean representsNonOptions();

    public boolean requiresArgument();
}

