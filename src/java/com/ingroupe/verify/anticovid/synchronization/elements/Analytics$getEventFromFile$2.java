/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.SuspendLambda
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Lambda
 *  kotlinx.coroutines.CoroutineScope
 */
package com.ingroupe.verify.anticovid.synchronization.elements;

import com.google.android.material.R;
import com.ingroupe.verify.anticovid.synchronization.elements.Analytics;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c="com.ingroupe.verify.anticovid.synchronization.elements.Analytics$getEventFromFile$2", f="Analytics.kt", l={}, m="invokeSuspend")
public final class Analytics$getEventFromFile$2
extends SuspendLambda
implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    public final /* synthetic */ File $file;

    public Analytics$getEventFromFile$2(File file, Continuation<? super Analytics$getEventFromFile$2> continuation) {
        this.$file = file;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
        return new Analytics$getEventFromFile$2(this.$file, continuation);
    }

    public Object invoke(Object object, Object object2) {
        (CoroutineScope)object;
        Continuation continuation = (Continuation)object2;
        File file = this.$file;
        new Analytics$getEventFromFile$2(file, (Continuation<? super Analytics$getEventFromFile$2>)continuation);
        R.style.throwOnFailure((Object)Unit.INSTANCE);
        return Analytics.INSTANCE.executeActionOnAtomicFile(new Function0<List<? extends String>>(file){
            public final /* synthetic */ File $file;
            {
                this.$file = file;
                super(0);
            }

            /*
             * Exception decompiling
             */
            public Object invoke() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl109 : ALOAD : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        });
    }

    public final Object invokeSuspend(Object object) {
        R.style.throwOnFailure((Object)object);
        return Analytics.INSTANCE.executeActionOnAtomicFile(new /* invalid duplicate definition of identical inner class */);
    }

}

