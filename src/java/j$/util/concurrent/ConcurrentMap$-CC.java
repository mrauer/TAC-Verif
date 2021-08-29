/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  java.util.concurrent.ConcurrentMap
 */
package j$.util.concurrent;

import j$.util.concurrent.ConcurrentMap;
import j$.util.concurrent.a;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Objects;

public final class ConcurrentMap$-CC {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static Object $default$compute(java.util.concurrent.ConcurrentMap var0, Object var1_1, BiFunction var2_2) {
        Objects.requireNonNull((Object)var2_2);
        block0 : do lbl-1000: // 3 sources:
        {
            var4_3 = var0.get(var1_1);
            do {
                block3 : {
                    if ((var5_4 = var2_2.apply(var1_1, var4_3)) != null) break block3;
                    if (var4_3 == null) {
                        if (var0.containsKey(var1_1) == false) return null;
                    }
                    if (!var0.remove(var1_1, var4_3)) ** GOTO lbl-1000
                    return null;
                }
                if (var4_3 == null) continue;
                if (!var0.replace(var1_1, var4_3, var5_4)) continue block0;
                return var5_4;
            } while ((var4_3 = var0.putIfAbsent(var1_1, var5_4)) != null);
            break;
        } while (true);
        return var5_4;
    }

    public static Object $default$computeIfAbsent(java.util.concurrent.ConcurrentMap concurrentMap, Object object, Function function) {
        Object object2;
        Objects.requireNonNull((Object)function);
        Object object3 = concurrentMap.get(object);
        if (object3 == null && (object2 = function.apply(object)) != null && (object3 = concurrentMap.putIfAbsent(object, object2)) == null) {
            object3 = object2;
        }
        return object3;
    }

    public static Object $default$computeIfPresent(java.util.concurrent.ConcurrentMap concurrentMap, Object object, BiFunction biFunction) {
        Object object2;
        Objects.requireNonNull((Object)biFunction);
        while ((object2 = concurrentMap.get(object)) != null) {
            Object object3 = biFunction.apply(object, object2);
            if (object3 != null) {
                if (!concurrentMap.replace(object, object2, object3)) continue;
                return object3;
            }
            if (!concurrentMap.remove(object, object2)) continue;
            return null;
        }
        return object2;
    }

    /*
     * Exception decompiling
     */
    public static void $default$forEach(java.util.concurrent.ConcurrentMap var0, BiConsumer var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public static Object $default$getOrDefault(java.util.concurrent.ConcurrentMap concurrentMap, Object object, Object object2) {
        Object object3 = concurrentMap.get(object);
        if (object3 != null) {
            object2 = object3;
        }
        return object2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static Object $default$merge(java.util.concurrent.ConcurrentMap var0, Object var1_1, Object var2_2, BiFunction var3_3) {
        Objects.requireNonNull((Object)var3_3);
        Objects.requireNonNull((Object)var2_2);
        block0 : do lbl-1000: // 3 sources:
        {
            var6_4 = var0.get(var1_1);
            do {
                block2 : {
                    if (var6_4 == null) continue;
                    var7_5 = var3_3.apply(var6_4, var2_2);
                    if (var7_5 == null) break block2;
                    if (!var0.replace(var1_1, var6_4, var7_5)) ** GOTO lbl-1000
                    return var7_5;
                }
                if (!var0.remove(var1_1, var6_4)) continue block0;
                return null;
            } while ((var6_4 = var0.putIfAbsent(var1_1, var2_2)) != null);
            break;
        } while (true);
        return var2_2;
    }

    public static void $default$replaceAll(java.util.concurrent.ConcurrentMap concurrentMap, BiFunction biFunction) {
        Objects.requireNonNull((Object)biFunction);
        a a2 = new a(concurrentMap, biFunction);
        if (concurrentMap instanceof ConcurrentMap) {
            ((ConcurrentMap)concurrentMap).forEach(a2);
            return;
        }
        ConcurrentMap$-CC.$default$forEach(concurrentMap, a2);
    }
}

