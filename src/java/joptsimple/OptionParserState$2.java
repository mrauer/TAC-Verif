/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package joptsimple;

import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionParserState;
import joptsimple.OptionParserState$1;
import joptsimple.OptionSet;
import joptsimple.ParserRules;
import joptsimple.UnrecognizedOptionException;
import joptsimple.internal.OptionNameMap;
import joptsimple.util.KeyValuePair;

public final class OptionParserState$2
extends OptionParserState {
    public final /* synthetic */ boolean val$posixlyCorrect;

    public OptionParserState$2(boolean bl) {
        this.val$posixlyCorrect = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void handleArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
        String string;
        block6 : {
            string = argumentList.next();
            if ("--".equals((Object)string)) {
                optionParser.state = new OptionParserState$1();
                return;
            }
            if (ParserRules.isLongOptionToken(string)) {
                KeyValuePair keyValuePair = KeyValuePair.valueOf(string.substring(2));
                if (optionParser.isRecognized(keyValuePair.key)) {
                    optionParser.specFor(keyValuePair.key).handleOption(optionParser, argumentList, optionSet, keyValuePair.value);
                    return;
                }
                String string2 = keyValuePair.key;
                throw new UnrecognizedOptionException(string2);
            }
            String string3 = ParserRules.HYPHEN;
            boolean bl = string.startsWith(string3) && !string3.equals((Object)string) && !ParserRules.isLongOptionToken(string);
            if (bl) {
                optionParser.handleShortOptionToken(string, argumentList, optionSet);
                return;
            }
            if (!this.val$posixlyCorrect) break block6;
            optionParser.state = new OptionParserState$1();
        }
        optionParser.recognizedOptions.get("[arguments]").handleOption(optionParser, argumentList, optionSet, string);
    }
}

