/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 */
package joptsimple;

import java.util.Collection;
import java.util.List;
import joptsimple.OptionException;
import joptsimple.OptionSpec;

public class UnavailableOptionException
extends OptionException {
    public UnavailableOptionException(List<? extends OptionSpec<?>> list) {
        super((Collection<? extends OptionSpec<?>>)list);
    }

    @Override
    public Object[] messageArguments() {
        Object[] arrobject = new Object[]{this.multipleOptionString()};
        return arrobject;
    }
}

