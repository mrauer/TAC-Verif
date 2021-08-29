/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.List
 */
package joptsimple;

import java.util.Collections;
import java.util.List;
import joptsimple.OptionException;

public class IllegalOptionSpecificationException
extends OptionException {
    public IllegalOptionSpecificationException(String string) {
        super((List<String>)Collections.singletonList((Object)string));
    }

    @Override
    public Object[] messageArguments() {
        Object[] arrobject = new Object[]{this.singleOptionString()};
        return arrobject;
    }
}

