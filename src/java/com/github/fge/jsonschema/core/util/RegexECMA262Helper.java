/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  javax.script.Invocable
 *  javax.script.ScriptException
 *  org.mozilla.javascript.Context
 *  org.mozilla.javascript.Function
 *  org.mozilla.javascript.Scriptable
 */
package com.github.fge.jsonschema.core.util;

import javax.script.Invocable;
import javax.script.ScriptException;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public final class RegexECMA262Helper {
    private static final Invocable PRIMARY_SCRIPT_ENGINE;
    private static final Function REGEX_IS_VALID;
    private static final String REGEX_IS_VALID_FUNCTION_NAME = "regexIsValid";
    private static final Function REG_MATCH;
    private static final String REG_MATCH_FUNCTION_NAME = "regMatch";
    private static final Scriptable SCOPE;
    private static final String jsAsString = "function regexIsValid(re){    try {         new RegExp(re);         return true;    } catch (e) {        return false;    }}function regMatch(re, input){    return new RegExp(re).test(input);}";

    /*
     * Exception decompiling
     */
    public static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl32 : GETSTATIC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private RegexECMA262Helper() {
    }

    private static /* varargs */ boolean invokeFallbackEngine(Function function, Object ... arrobject) {
        Context context = Context.enter();
        try {
            Scriptable scriptable = SCOPE;
            boolean bl = (Boolean)function.call(context, scriptable, scriptable, arrobject);
            return bl;
        }
        finally {
            Context.exit();
        }
    }

    private static /* varargs */ boolean invokeScriptEngine(String string, Object ... arrobject) {
        try {
            boolean bl = (Boolean)PRIMARY_SCRIPT_ENGINE.invokeFunction(string, arrobject);
            return bl;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new IllegalStateException("Unexpected error on invoking Script.", (Throwable)noSuchMethodException);
        }
        catch (ScriptException scriptException) {
            throw new IllegalStateException("Unexpected error on invoking Script.", (Throwable)scriptException);
        }
    }

    public static boolean regMatch(String string, String string2) {
        if (PRIMARY_SCRIPT_ENGINE != null) {
            return RegexECMA262Helper.invokeScriptEngine(REG_MATCH_FUNCTION_NAME, string, string2);
        }
        return RegexECMA262Helper.invokeFallbackEngine(REG_MATCH, string, string2);
    }

    public static boolean regexIsValid(String string) {
        if (PRIMARY_SCRIPT_ENGINE != null) {
            return RegexECMA262Helper.invokeScriptEngine(REGEX_IS_VALID_FUNCTION_NAME, string);
        }
        return RegexECMA262Helper.invokeFallbackEngine(REGEX_IS_VALID, string);
    }

    /*
     * Exception decompiling
     */
    private static Invocable tryResolvePrimaryEngine() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18.1 : ACONST_NULL : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }
}

