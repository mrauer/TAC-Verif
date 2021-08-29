/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 */
package joptsimple;

import java.util.Arrays;
import java.util.Collection;
import joptsimple.OptionException;
import joptsimple.OptionSpec;

public class OptionMissingRequiredArgumentException
extends OptionException {
    public OptionMissingRequiredArgumentException(OptionSpec<?> optionSpec) {
        super((Collection<? extends OptionSpec<?>>)Arrays.asList((Object[])new OptionSpec[]{optionSpec}));
    }

    @Override
    public Object[] messageArguments() {
        Object[] arrobject = new Object[]{this.singleOptionString()};
        return arrobject;
    }
}

