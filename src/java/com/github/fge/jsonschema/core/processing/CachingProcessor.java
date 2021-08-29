/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.github.fge.jsonschema.core.report.ListProcessingReport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.common.base.Equivalence
 *  com.google.common.base.Equivalence$Wrapper
 *  com.google.common.cache.CacheBuilder
 *  com.google.common.cache.CacheLoader
 *  com.google.common.cache.LoadingCache
 *  com.google.common.cache.LocalCache
 *  com.google.common.cache.LocalCache$LocalLoadingCache
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.ExecutionException
 */
package com.github.fge.jsonschema.core.processing;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.messages.JsonSchemaCoreMessageBundle;
import com.github.fge.jsonschema.core.processing.ProcessingResult;
import com.github.fge.jsonschema.core.processing.Processor;
import com.github.fge.jsonschema.core.report.ListProcessingReport;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.MessageProvider;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.util.equivalence.Equivalences;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import com.google.android.material.R;
import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import java.util.concurrent.ExecutionException;

public final class CachingProcessor<IN extends MessageProvider, OUT extends MessageProvider>
implements Processor<IN, OUT> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaCoreMessageBundle.class);
    private static final int DEFAULT_CACHE_SIZE = 512;
    private final LoadingCache<Equivalence.Wrapper<IN>, ProcessingResult<OUT>> cache;
    private final Equivalence<IN> equivalence;
    private final Processor<IN, OUT> processor;

    public CachingProcessor(Processor<IN, OUT> processor) {
        this(processor, Equivalences.equals());
    }

    public CachingProcessor(Processor<IN, OUT> processor, Equivalence<IN> equivalence) {
        this(processor, equivalence, 512);
    }

    public CachingProcessor(Processor<IN, OUT> processor, Equivalence<IN> equivalence, int n) {
        MessageBundle messageBundle = BUNDLE;
        messageBundle.checkNotNull(processor, "processing.nullProcessor");
        messageBundle.checkNotNull(equivalence, "processing.nullEquivalence");
        boolean bl = n >= -1;
        messageBundle.checkArgument(bl, "processing.invalidCacheSize");
        this.processor = processor;
        this.equivalence = equivalence;
        CacheBuilder cacheBuilder = new CacheBuilder();
        if (n != -1) {
            cacheBuilder.maximumSize((long)n);
        }
        CacheLoader<Equivalence.Wrapper<IN>, ProcessingResult<OUT>> cacheLoader = this.loader();
        R.style.checkState((boolean)true, (Object)"maximumWeight requires weigher");
        this.cache = new LocalCache.LocalLoadingCache(cacheBuilder, cacheLoader);
    }

    private CacheLoader<Equivalence.Wrapper<IN>, ProcessingResult<OUT>> loader() {
        return new CacheLoader<Equivalence.Wrapper<IN>, ProcessingResult<OUT>>(){

            public ProcessingResult<OUT> load(Equivalence.Wrapper<IN> wrapper) throws ProcessingException {
                MessageProvider messageProvider = (MessageProvider)wrapper.reference;
                ListProcessingReport listProcessingReport = new ListProcessingReport(LogLevel.DEBUG, LogLevel.NONE);
                return ProcessingResult.of(CachingProcessor.this.processor, (ProcessingReport)listProcessingReport, messageProvider);
            }
        };
    }

    @Override
    public OUT process(ProcessingReport processingReport, IN IN) throws ProcessingException {
        ProcessingResult processingResult;
        try {
            LoadingCache<Equivalence.Wrapper<IN>, ProcessingResult<OUT>> loadingCache = this.cache;
            Equivalence.Wrapper wrapper = this.equivalence.wrap(IN);
            processingResult = (ProcessingResult)((LocalCache.LocalLoadingCache)loadingCache).get((Object)wrapper);
        }
        catch (ExecutionException executionException) {
            throw (ProcessingException)executionException.getCause();
        }
        processingReport.mergeWith(processingResult.getReport());
        return (OUT)processingResult.getResult();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"CACHED[");
        stringBuilder.append(this.processor);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}

