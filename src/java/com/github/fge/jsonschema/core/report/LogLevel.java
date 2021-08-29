/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.core.report;

public final class LogLevel
extends Enum<LogLevel> {
    private static final /* synthetic */ LogLevel[] $VALUES;
    public static final /* enum */ LogLevel DEBUG;
    public static final /* enum */ LogLevel ERROR;
    public static final /* enum */ LogLevel FATAL;
    public static final /* enum */ LogLevel INFO;
    public static final /* enum */ LogLevel NONE;
    public static final /* enum */ LogLevel WARNING;
    private final String s;

    public static {
        LogLevel logLevel;
        LogLevel logLevel2;
        LogLevel logLevel3;
        LogLevel logLevel4;
        LogLevel logLevel5;
        LogLevel logLevel6;
        DEBUG = logLevel = new LogLevel("debug");
        INFO = logLevel5 = new LogLevel("info");
        WARNING = logLevel3 = new LogLevel("warning");
        ERROR = logLevel2 = new LogLevel("error");
        FATAL = logLevel6 = new LogLevel("fatal");
        NONE = logLevel4 = new LogLevel("none");
        $VALUES = new LogLevel[]{logLevel, logLevel5, logLevel3, logLevel2, logLevel6, logLevel4};
    }

    private LogLevel(String string2) {
        this.s = string2;
    }

    public static LogLevel valueOf(String string) {
        return (LogLevel)Enum.valueOf(LogLevel.class, (String)string);
    }

    public static LogLevel[] values() {
        return (LogLevel[])$VALUES.clone();
    }

    public String toString() {
        return this.s;
    }
}

