/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  joptsimple.AbstractOptionSpec
 *  joptsimple.BuiltinHelpFormatter
 *  joptsimple.IllegalOptionSpecificationException
 *  joptsimple.MissingRequiredOptionsException
 *  joptsimple.NonOptionArgumentSpec
 *  joptsimple.OptionParserState$2
 *  joptsimple.OptionSpecBuilder
 *  joptsimple.UnavailableOptionException
 *  joptsimple.UnrecognizedOptionException
 *  joptsimple.internal.AbbreviationMap
 */
package joptsimple;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.BuiltinHelpFormatter;
import joptsimple.HelpFormatter;
import joptsimple.IllegalOptionSpecificationException;
import joptsimple.MissingRequiredOptionsException;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionDescriptor;
import joptsimple.OptionParserState;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import joptsimple.OptionSpecBuilder;
import joptsimple.ParserRules;
import joptsimple.UnavailableOptionException;
import joptsimple.UnrecognizedOptionException;
import joptsimple.internal.AbbreviationMap;
import joptsimple.internal.OptionNameMap;
import joptsimple.util.KeyValuePair;

public class OptionParser {
    public final Map<List<String>, Set<OptionSpec<?>>> availableIf;
    public final Map<List<String>, Set<OptionSpec<?>>> availableUnless;
    public HelpFormatter helpFormatter = new BuiltinHelpFormatter();
    public final OptionNameMap<AbstractOptionSpec<?>> recognizedOptions;
    public final Map<List<String>, Set<OptionSpec<?>>> requiredIf;
    public final Map<List<String>, Set<OptionSpec<?>>> requiredUnless;
    public OptionParserState state;
    public final ArrayList<AbstractOptionSpec<?>> trainingOrder;

    public OptionParser() {
        AbbreviationMap abbreviationMap;
        ArrayList arrayList;
        this.trainingOrder = arrayList = new ArrayList();
        this.requiredIf = new HashMap();
        this.requiredUnless = new HashMap();
        this.availableIf = new HashMap();
        this.availableUnless = new HashMap();
        this.state = new OptionParserState.2(false);
        this.recognizedOptions = abbreviationMap = new AbbreviationMap();
        NonOptionArgumentSpec nonOptionArgumentSpec = new NonOptionArgumentSpec();
        abbreviationMap.putAll((Iterable<String>)nonOptionArgumentSpec.options(), nonOptionArgumentSpec);
        arrayList.add((Object)nonOptionArgumentSpec);
    }

    public OptionSpecBuilder accepts(String string, String string2) {
        return this.acceptsAll((List<String>)Collections.singletonList((Object)string), string2);
    }

    public OptionSpecBuilder acceptsAll(List<String> list, String string) {
        if (!list.isEmpty()) {
            for (String string2 : list) {
                if (!string2.startsWith(ParserRules.HYPHEN)) {
                    for (int i2 = 0; i2 < string2.length(); ++i2) {
                        boolean bl;
                        char c2 = string2.charAt(i2);
                        if (Character.isLetterOrDigit((char)c2) || (bl = "?._-".indexOf((int)c2) != -1)) continue;
                        throw new IllegalOptionSpecificationException(String.valueOf((char)c2));
                    }
                    continue;
                }
                throw new IllegalOptionSpecificationException(string2);
            }
            return new OptionSpecBuilder(this, list, string);
        }
        throw new IllegalArgumentException("need at least one option");
    }

    public void handleShortOptionToken(String string, ArgumentList argumentList, OptionSet optionSet) {
        char[] arrc;
        int n2;
        int n3;
        block5 : {
            String string2;
            KeyValuePair keyValuePair = KeyValuePair.valueOf(string.substring(1));
            if (this.isRecognized(keyValuePair.key)) {
                this.specFor(keyValuePair.key).handleOption(this, argumentList, optionSet, keyValuePair.value);
                return;
            }
            n2 = string.length() - 1;
            arrc = new char[n2];
            string.getChars(1, string.length(), arrc, 0);
            int n4 = 0;
            do {
                n3 = 0;
                if (n4 >= n2) break block5;
                string2 = String.valueOf((char)arrc[n4]);
                if (!this.isRecognized(string2)) break;
                if (this.specFor(string2).acceptsArguments()) {
                    n3 = 0;
                    break block5;
                }
                ++n4;
            } while (true);
            throw new UnrecognizedOptionException(string2);
        }
        while (n3 < n2) {
            int n5;
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor(String.valueOf((char)arrc[n3]));
            if (abstractOptionSpec.acceptsArguments() && n2 > (n5 = n3 + 1)) {
                abstractOptionSpec.handleOption(this, argumentList, optionSet, String.valueOf((char[])arrc, (int)n5, (int)(n2 - 1 - n3)));
                return;
            }
            abstractOptionSpec.handleOption(this, argumentList, optionSet, null);
            ++n3;
        }
    }

    public final boolean isHelpOptionPresent(OptionSet optionSet) {
        for (AbstractOptionSpec abstractOptionSpec : this.recognizedOptions.toJavaUtilMap().values()) {
            if (!abstractOptionSpec.forHelp || !optionSet.optionsToArguments.containsKey((Object)abstractOptionSpec)) continue;
            return true;
        }
        return false;
    }

    public boolean isRecognized(String string) {
        return this.recognizedOptions.contains(string);
    }

    public final boolean optionsHasAnyOf(OptionSet optionSet, Collection<OptionSpec<?>> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!optionSet.has((OptionSpec)iterator.next())) continue;
            return true;
        }
        return false;
    }

    public /* varargs */ OptionSet parse(String ... arrstring) {
        boolean bl;
        ArgumentList argumentList = new ArgumentList(arrstring);
        OptionSet optionSet = new OptionSet(this.recognizedOptions.toJavaUtilMap());
        optionSet.addWithArgument(this.recognizedOptions.get("[arguments]"), null);
        while (bl = argumentList.currentIndex < argumentList.arguments.length) {
            this.state.handleArgument(this, argumentList, optionSet);
        }
        this.state = new OptionParserState.2(false);
        ArrayList arrayList = new ArrayList();
        for (AbstractOptionSpec abstractOptionSpec : this.recognizedOptions.toJavaUtilMap().values()) {
            if (!abstractOptionSpec.isRequired() || optionSet.optionsToArguments.containsKey((Object)abstractOptionSpec)) continue;
            arrayList.add((Object)abstractOptionSpec);
        }
        for (Map.Entry entry : this.requiredIf.entrySet()) {
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor((String)((List)entry.getKey()).iterator().next());
            if (!this.optionsHasAnyOf(optionSet, (Collection)entry.getValue()) || optionSet.has((OptionSpec<?>)abstractOptionSpec)) continue;
            arrayList.add(abstractOptionSpec);
        }
        for (Map.Entry entry : this.requiredUnless.entrySet()) {
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor((String)((List)entry.getKey()).iterator().next());
            if (this.optionsHasAnyOf(optionSet, (Collection)entry.getValue()) || optionSet.has((OptionSpec<?>)abstractOptionSpec)) continue;
            arrayList.add(abstractOptionSpec);
        }
        boolean bl2 = this.isHelpOptionPresent(optionSet);
        if (!arrayList.isEmpty() && !bl2) {
            throw new MissingRequiredOptionsException((List)arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : this.availableIf.entrySet()) {
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor((String)((List)entry.getKey()).iterator().next());
            if (this.optionsHasAnyOf(optionSet, (Collection)entry.getValue()) || !optionSet.has((OptionSpec<?>)abstractOptionSpec)) continue;
            arrayList2.add(abstractOptionSpec);
        }
        for (Map.Entry entry : this.availableUnless.entrySet()) {
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor((String)((List)entry.getKey()).iterator().next());
            if (!this.optionsHasAnyOf(optionSet, (Collection)entry.getValue()) || !optionSet.has((OptionSpec<?>)abstractOptionSpec)) continue;
            arrayList2.add(abstractOptionSpec);
        }
        boolean bl3 = this.isHelpOptionPresent(optionSet);
        if (!arrayList2.isEmpty()) {
            if (bl3) {
                return optionSet;
            }
            throw new UnavailableOptionException((List)arrayList2);
        }
        return optionSet;
    }

    public void printHelpOn(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        HelpFormatter helpFormatter = this.helpFormatter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AbstractOptionSpec abstractOptionSpec : this.trainingOrder) {
            Iterator iterator = abstractOptionSpec.options().iterator();
            while (iterator.hasNext()) {
                linkedHashMap.put((Object)((String)iterator.next()), (Object)abstractOptionSpec);
            }
        }
        outputStreamWriter.write(helpFormatter.format((Map<String, ? extends OptionDescriptor>)linkedHashMap));
        outputStreamWriter.flush();
    }

    public final AbstractOptionSpec<?> specFor(String string) {
        return this.recognizedOptions.get(string);
    }
}

