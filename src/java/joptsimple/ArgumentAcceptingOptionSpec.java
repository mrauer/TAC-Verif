/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.StringTokenizer
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.ValueConverter;

public abstract class ArgumentAcceptingOptionSpec<V>
extends AbstractOptionSpec<V> {
    public String argumentDescription = "";
    public final boolean argumentRequired;
    public final List<V> defaultValues = new ArrayList();
    public String valueSeparator = String.valueOf((char)'\u0000');

    public ArgumentAcceptingOptionSpec(List<String> list, boolean bl, String string) {
        super(list, string);
        this.argumentRequired = bl;
    }

    @Override
    public boolean acceptsArguments() {
        return true;
    }

    public void addArguments(OptionSet optionSet, String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, this.valueSeparator);
        if (!stringTokenizer.hasMoreTokens()) {
            optionSet.addWithArgument(this, string);
            return;
        }
        while (stringTokenizer.hasMoreTokens()) {
            optionSet.addWithArgument(this, stringTokenizer.nextToken());
        }
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

    public List<V> defaultValues() {
        return Collections.unmodifiableList(this.defaultValues);
    }

    public abstract void detectOptionArgument(OptionParser var1, ArgumentList var2, OptionSet var3);

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec = (ArgumentAcceptingOptionSpec)object;
        boolean bl = this.argumentRequired;
        boolean bl2 = argumentAcceptingOptionSpec.argumentRequired;
        boolean bl3 = false;
        if (bl == bl2) {
            bl3 = true;
        }
        return bl3;
    }

    @Override
    public final void handleOption(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet, String string) {
        if (string == null) {
            this.detectOptionArgument(optionParser, argumentList, optionSet);
            return;
        }
        this.addArguments(optionSet, string);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ (true ^ this.argumentRequired);
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public boolean requiresArgument() {
        return this.argumentRequired;
    }
}

