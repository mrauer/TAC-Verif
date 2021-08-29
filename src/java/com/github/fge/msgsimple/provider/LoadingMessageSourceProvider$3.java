/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.msgsimple.provider.LoadingMessageSourceProvider
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.concurrent.FutureTask
 */
package com.github.fge.msgsimple.provider;

import com.github.fge.msgsimple.provider.LoadingMessageSourceProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.FutureTask;

public class LoadingMessageSourceProvider$3
implements Runnable {
    public final /* synthetic */ LoadingMessageSourceProvider this$0;

    public LoadingMessageSourceProvider$3(LoadingMessageSourceProvider loadingMessageSourceProvider) {
        this.this$0 = loadingMessageSourceProvider;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Map map;
        ArrayList arrayList;
        Map map2 = map = this.this$0.sources;
        synchronized (map2) {
            arrayList = new ArrayList(this.this$0.sources.values());
            this.this$0.sources.clear();
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((FutureTask)iterator.next()).cancel(true);
        }
        return;
    }
}

