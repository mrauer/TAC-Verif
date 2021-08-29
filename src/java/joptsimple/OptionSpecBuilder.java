/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.internal.OptionNameMap;

public class OptionSpecBuilder
extends AbstractOptionSpec {
    public final OptionParser parser;

    public OptionSpecBuilder(OptionParser optionParser, List<String> list, String string) {
        super(list, string);
        this.parser = optionParser;
        optionParser.recognizedOptions.putAll((Iterable<String>)this.options(), this);
        optionParser.trainingOrder.add((Object)this);
    }

    public List defaultValues() {
        return Collections.emptyList();
    }

    @Override
    public void handleOption(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet, String string) {
        optionSet.addWithArgument(this, null);
    }
}

