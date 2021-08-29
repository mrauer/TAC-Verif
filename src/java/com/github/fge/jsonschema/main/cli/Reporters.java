/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.main.cli.Reporters$1
 *  com.github.fge.jsonschema.main.cli.Reporters$2
 *  com.github.fge.jsonschema.main.cli.Reporters$3
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.main.cli;

import com.github.fge.jsonschema.main.cli.Reporter;
import com.github.fge.jsonschema.main.cli.Reporters;

public abstract class Reporters
extends Enum<Reporters>
implements Reporter {
    private static final /* synthetic */ Reporters[] $VALUES;
    public static final /* enum */ Reporters BRIEF;
    public static final /* enum */ Reporters DEFAULT;
    public static final /* enum */ Reporters QUIET;

    public static {
        1 var0 = new 1("DEFAULT", 0);
        DEFAULT = var0;
        2 var1_1 = new 2("BRIEF", 1);
        BRIEF = var1_1;
        3 var2_2 = new 3("QUIET", 2);
        QUIET = var2_2;
        $VALUES = new Reporters[]{var0, var1_1, var2_2};
    }

    private Reporters() {
    }

    public /* synthetic */ Reporters(String string, int n, 1 var3_3) {
        this();
    }

    public static Reporters valueOf(String string) {
        return (Reporters)Enum.valueOf(Reporters.class, (String)string);
    }

    public static Reporters[] values() {
        return (Reporters[])$VALUES.clone();
    }
}

