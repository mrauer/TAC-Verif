/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Collections2
 *  com.google.common.collect.RegularImmutableSet
 *  com.google.common.collect.UnmodifiableIterator
 *  j
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.core.report;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.google.common.collect.Collections2;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import j$.lang.Iterable$-CC;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractProcessingReport
implements ProcessingReport {
    private LogLevel currentLevel = LogLevel.DEBUG;
    private final LogLevel exceptionThreshold;
    private final LogLevel logLevel;

    public AbstractProcessingReport() {
        this(LogLevel.INFO, LogLevel.FATAL);
    }

    public AbstractProcessingReport(LogLevel logLevel) {
        this(logLevel, LogLevel.FATAL);
    }

    public AbstractProcessingReport(LogLevel logLevel, LogLevel logLevel2) {
        this.logLevel = logLevel;
        this.exceptionThreshold = logLevel2;
    }

    @Override
    public final void debug(ProcessingMessage processingMessage) throws ProcessingException {
        this.dispatch(processingMessage.setLogLevel(LogLevel.DEBUG));
    }

    public final void dispatch(ProcessingMessage processingMessage) throws ProcessingException {
        LogLevel logLevel = processingMessage.getLogLevel();
        if (logLevel.compareTo((Enum)this.exceptionThreshold) < 0) {
            if (logLevel.compareTo((Enum)this.currentLevel) > 0) {
                this.currentLevel = logLevel;
            }
            if (logLevel.compareTo((Enum)this.logLevel) >= 0) {
                this.log(logLevel, processingMessage);
            }
            return;
        }
        throw processingMessage.asException();
    }

    @Override
    public final void error(ProcessingMessage processingMessage) throws ProcessingException {
        this.dispatch(processingMessage.setLogLevel(LogLevel.ERROR));
    }

    @Override
    public final void fatal(ProcessingMessage processingMessage) throws ProcessingException {
        this.dispatch(processingMessage.setLogLevel(LogLevel.FATAL));
    }

    @Override
    public /* synthetic */ void forEach(j.Consumer consumer) {
        Iterable$-CC.$default$forEach(this, consumer);
    }

    @Override
    public final LogLevel getExceptionThreshold() {
        return this.exceptionThreshold;
    }

    @Override
    public final LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override
    public final void info(ProcessingMessage processingMessage) throws ProcessingException {
        this.dispatch(processingMessage.setLogLevel(LogLevel.INFO));
    }

    @Override
    public final boolean isSuccess() {
        return this.currentLevel.compareTo((Enum)LogLevel.ERROR) < 0;
    }

    public Iterator<ProcessingMessage> iterator() {
        return RegularImmutableSet.EMPTY.iterator();
    }

    public abstract void log(LogLevel var1, ProcessingMessage var2);

    @Override
    public final void mergeWith(ProcessingReport processingReport) throws ProcessingException {
        LogLevel logLevel;
        LogLevel logLevel2;
        if (!processingReport.isSuccess() && (logLevel = this.currentLevel).compareTo((Enum)(logLevel2 = LogLevel.ERROR)) < 0) {
            this.currentLevel = logLevel2;
        }
        Iterator iterator = processingReport.iterator();
        while (iterator.hasNext()) {
            this.dispatch((ProcessingMessage)iterator.next());
        }
    }

    @Override
    public /* synthetic */ j.Spliterator spliterator() {
        return Iterable$-CC.$default$spliterator(this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getCanonicalName());
        stringBuilder.append(": ");
        String string = this.isSuccess() ? "success" : "failure";
        stringBuilder.append(string);
        stringBuilder.append('\n');
        ArrayList arrayList = Collections2.newArrayList((Iterable)this);
        if (!arrayList.isEmpty()) {
            stringBuilder.append("--- BEGIN MESSAGES ---\n");
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                stringBuilder.append((Object)((ProcessingMessage)iterator.next()));
            }
            stringBuilder.append("---  END MESSAGES  ---\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public final void warn(ProcessingMessage processingMessage) throws ProcessingException {
        this.dispatch(processingMessage.setLogLevel(LogLevel.WARNING));
    }
}

