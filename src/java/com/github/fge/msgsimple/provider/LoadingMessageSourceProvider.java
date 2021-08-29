/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.FutureTask
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.github.fge.msgsimple.provider;

import com.github.fge.msgsimple.InternalBundle;
import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider;
import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider$2;
import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider$3;
import com.github.fge.msgsimple.provider.MessageSourceLoader;
import com.github.fge.msgsimple.provider.MessageSourceProvider;
import com.github.fge.msgsimple.source.MessageSource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LoadingMessageSourceProvider
implements MessageSourceProvider {
    public static final InternalBundle BUNDLE;
    public static final ThreadFactory THREAD_FACTORY;
    public final long expiryDuration;
    public final AtomicBoolean expiryEnabled;
    public final TimeUnit expiryUnit;
    public final MessageSourceLoader loader;
    public final ExecutorService service = Executors.newFixedThreadPool((int)3, (ThreadFactory)THREAD_FACTORY);
    public final Map<Locale, FutureTask<MessageSource>> sources = new HashMap();
    public final long timeoutDuration;
    public final TimeUnit timeoutUnit;

    public static {
        THREAD_FACTORY = new ThreadFactory(){
            public final ThreadFactory factory;
            {
                this.factory = Executors.defaultThreadFactory();
            }

            public Thread newThread(Runnable runnable) {
                Thread thread = this.factory.newThread(runnable);
                thread.setDaemon(true);
                return thread;
            }
        };
        BUNDLE = InternalBundle.INSTANCE;
    }

    public LoadingMessageSourceProvider(Builder builder, 1 var2_2) {
        long l;
        this.loader = builder.loader;
        this.timeoutDuration = builder.timeoutDuration;
        this.timeoutUnit = builder.timeoutUnit;
        this.expiryDuration = l = builder.expiryDuration;
        this.expiryUnit = builder.expiryUnit;
        boolean bl = l == 0L;
        this.expiryEnabled = new AtomicBoolean(bl);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public MessageSource getMessageSource(Locale locale) {
        Map<Locale, FutureTask<MessageSource>> map;
        if (!this.expiryEnabled.getAndSet(true)) {
            long l = this.expiryDuration;
            TimeUnit timeUnit = this.expiryUnit;
            LoadingMessageSourceProvider$3 loadingMessageSourceProvider$3 = new LoadingMessageSourceProvider$3(this);
            Executors.newScheduledThreadPool((int)1, (ThreadFactory)THREAD_FACTORY).scheduleAtFixedRate((Runnable)loadingMessageSourceProvider$3, l, l, timeUnit);
        }
        Map<Locale, FutureTask<MessageSource>> map2 = map = this.sources;
        // MONITORENTER : map2
        FutureTask futureTask = (FutureTask)this.sources.get((Object)locale);
        if (futureTask == null) {
            futureTask = new FutureTask((Callable)new LoadingMessageSourceProvider$2(this, locale));
            this.sources.put((Object)locale, (Object)futureTask);
            this.service.execute((Runnable)futureTask);
        }
        // MONITOREXIT : map2
        MessageSource messageSource = null;
        try {
            MessageSource messageSource2 = (MessageSource)futureTask.get(this.timeoutDuration, this.timeoutUnit);
            if (messageSource2 != null) return messageSource2;
            return null;
        }
        catch (CancellationException | ExecutionException | TimeoutException throwable) {}
        return messageSource;
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

}

