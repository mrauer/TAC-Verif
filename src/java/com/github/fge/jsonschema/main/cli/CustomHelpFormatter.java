/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.common.base.Joiner
 *  com.google.common.collect.ImmutableCollection
 *  com.google.common.collect.ImmutableCollection$ArrayBasedBuilder
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 */
package com.github.fge.jsonschema.main.cli;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import joptsimple.HelpFormatter;
import joptsimple.OptionDescriptor;

public final class CustomHelpFormatter
implements HelpFormatter {
    private static final ImmutableList<String> HELP_POST;
    private static final ImmutableList<String> HELP_PREAMBLE;
    private static final Joiner JOINER;
    private static final String LINE_SEPARATOR;
    public static final Joiner OPTIONS_JOINER;
    private final List<String> lines = new ArrayList();

    public static {
        String string;
        HELP_PREAMBLE = ImmutableList.construct((Object[])new Object[]{"Syntax:", "    java -jar jsonschema.jar [options] schema file [file...]", "    java -jar jsonschema.jar --syntax [options] schema [schema...]", "", "Options: "});
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.add((Object)"");
        builder.add((Object)"Exit codes:");
        builder.add((Object)"    0: validation successful;");
        builder.add((Object)"    1: exception occurred (appears on stderr)");
        builder.add((Object)"    2: command line syntax error (missing argument, etc)");
        builder.add((Object)"  100: one or more file(s) failed validation");
        builder.add((Object)"  101: one or more schema(s) is/are invalid");
        builder.add((Object)"");
        builder.add((Object)"Note: by default, the URI of schemas you use in validation mode");
        builder.add((Object)"(that is, when you don't use --syntax) is considered to be the");
        builder.add((Object)"current working directory plus the filename. If your schemas");
        builder.add((Object)"all have a common URI prefix in a top level \"id\", you can fake");
        builder.add((Object)"that the current directory is that prefix using --fakeroot.");
        HELP_POST = builder.build();
        LINE_SEPARATOR = string = System.getProperty((String)"line.separator", (String)"\n");
        JOINER = new Joiner(string);
        OPTIONS_JOINER = new Joiner(", ");
    }

    private static String optionsToString(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        for (String string : collection) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = string.length() == 1 ? "-" : "--";
            stringBuilder.append(string2);
            stringBuilder.append(string);
            arrayList.add((Object)stringBuilder.toString());
        }
        return OPTIONS_JOINER.join((Iterable)arrayList);
    }

    @Override
    public String format(Map<String, ? extends OptionDescriptor> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(map.values());
        this.lines.addAll(HELP_PREAMBLE);
        int n = this.lines.size();
        for (OptionDescriptor optionDescriptor : linkedHashSet) {
            if (optionDescriptor.representsNonOptions()) continue;
            List<String> list = optionDescriptor.options();
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"    ");
            stringBuilder.append(CustomHelpFormatter.optionsToString(list));
            if (optionDescriptor.requiresArgument()) {
                stringBuilder.append(" uri");
            }
            stringBuilder.append(": ");
            stringBuilder.append(optionDescriptor.description());
            if (list.contains((Object)"help")) {
                this.lines.add(n, (Object)stringBuilder.toString());
                continue;
            }
            this.lines.add((Object)stringBuilder.toString());
        }
        this.lines.addAll(HELP_POST);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JOINER.join(this.lines));
        stringBuilder.append(LINE_SEPARATOR);
        return stringBuilder.toString();
    }
}

