/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package joptsimple;

import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionParserState;
import joptsimple.OptionSet;
import joptsimple.internal.OptionNameMap;

public final class OptionParserState$1
extends OptionParserState {
    @Override
    public void handleArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
        String string = argumentList.next();
        optionParser.recognizedOptions.get("[arguments]").handleOption(optionParser, argumentList, optionSet, string);
    }
}

