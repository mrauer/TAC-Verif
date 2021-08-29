/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.File
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.CoroutineSingletons
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.SuspendLambda
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlinx.coroutines.CoroutineScope
 */
package com.ingroupe.verify.anticovid.synchronization.elements;

import android.content.Context;
import com.google.android.material.R;
import com.ingroupe.verify.anticovid.synchronization.elements.Analytics;
import com.ingroupe.verify.anticovid.synchronization.elements.Analytics$writeStringToFile$1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c="com.ingroupe.verify.anticovid.synchronization.elements.Analytics$reportVerifEvent$1", f="Analytics.kt", l={45}, m="invokeSuspend")
public final class Analytics$reportVerifEvent$1
extends SuspendLambda
implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $verifEvent;
    public Object L$0;
    public int label;

    public Analytics$reportVerifEvent$1(Context context, String string, Continuation<? super Analytics$reportVerifEvent$1> continuation) {
        this.$context = context;
        this.$verifEvent = string;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
        return new Analytics$reportVerifEvent$1(this.$context, this.$verifEvent, continuation);
    }

    public Object invoke(Object object, Object object2) {
        (CoroutineScope)object;
        Continuation continuation = (Continuation)object2;
        return new Analytics$reportVerifEvent$1(this.$context, this.$verifEvent, (Continuation<? super Analytics$reportVerifEvent$1>)continuation).invokeSuspend((Object)Unit.INSTANCE);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        File file;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int n2 = this.label;
        if (n2 != 0) {
            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            file = (File)this.L$0;
            R.style.throwOnFailure((Object)object);
        } else {
            R.style.throwOnFailure((Object)object);
            File file2 = new File(new File(this.$context.getFilesDir(), "TacVerifAnalytics"), "verif_events");
            Analytics analytics = Analytics.INSTANCE;
            Context context = this.$context;
            this.L$0 = file2;
            this.label = 1;
            Object object2 = analytics.getVerifEvents(context, (Continuation<? super List<String>>)this);
            if (object2 == coroutineSingletons) {
                return coroutineSingletons;
            }
            file = file2;
            object = object2;
        }
        List list = ArraysKt___ArraysJvmKt.toMutableList((Collection)((Collection)object));
        String string = this.$verifEvent;
        ((ArrayList)list).add((Object)string);
        Analytics.INSTANCE.executeActionOnAtomicFile(new Analytics$writeStringToFile$1(file, (List<String>)list));
        return Unit.INSTANCE;
    }
}

