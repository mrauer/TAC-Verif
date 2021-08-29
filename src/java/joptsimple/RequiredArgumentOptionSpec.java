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
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionMissingRequiredArgumentException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

public class RequiredArgumentOptionSpec<V>
extends ArgumentAcceptingOptionSpec<V> {
    public RequiredArgumentOptionSpec(List<String> list, String string) {
        super(list, true, string);
    }

    @Override
    public void detectOptionArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
        boolean bl = argumentList.currentIndex < argumentList.arguments.length;
        if (bl) {
            this.addArguments(optionSet, argumentList.next());
            return;
        }
        throw new OptionMissingRequiredArgumentException(this);
    }
}

