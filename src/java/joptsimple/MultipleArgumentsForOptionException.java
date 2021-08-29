/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 */
package joptsimple;

import java.util.Collection;
import java.util.Collections;
import joptsimple.OptionException;
import joptsimple.OptionSpec;

public class MultipleArgumentsForOptionException
extends OptionException {
    public MultipleArgumentsForOptionException(OptionSpec<?> optionSpec) {
        super((Collection<? extends OptionSpec<?>>)Collections.singleton(optionSpec));
    }

    @Override
    public Object[] messageArguments() {
        Object[] arrobject = new Object[]{this.singleOptionString()};
        return arrobject;
    }
}

