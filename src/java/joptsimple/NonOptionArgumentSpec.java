/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 */
package joptsimple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.ValueConverter;

public class NonOptionArgumentSpec<V>
extends AbstractOptionSpec<V> {
    public String argumentDescription = "";

    public NonOptionArgumentSpec() {
        super((List<String>)Arrays.asList((Object[])new String[]{"[arguments]"}), "");
    }

    @Override
    public boolean acceptsArguments() {
        return false;
    }

    @Override
    public String argumentDescription() {
        return this.argumentDescription;
    }

    @Override
    public String argumentTypeIndicator() {
        return this.argumentTypeIndicatorFrom(null);
    }

    @Override
    public final V convert(String string) {
        return (V)string;
    }

    @Override
    public List<?> defaultValues() {
        return Collections.emptyList();
    }

    @Override
    public void handleOption(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet, String string) {
        optionSet.addWithArgument(this, string);
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public boolean requiresArgument() {
        return false;
    }
}

