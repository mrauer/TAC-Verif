/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.Runtime
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
    public static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();

    public static int calculateBodyLength(int n2) {
        int n3 = 1;
        if (n2 > 127) {
            int n4 = n3;
            while ((n2 >>>= 8) != 0) {
                ++n4;
            }
            for (int i2 = 8 * (n4 - n3); i2 >= 0; i2 -= 8) {
                ++n3;
            }
        }
        return n3;
    }

    public static int calculateTagLength(int n2) throws IOException {
        int n3 = 1;
        if (n2 >= 31) {
            if (n2 < 128) {
                return 2;
            }
            byte[] arrby = new byte[5];
            int n4 = 4;
            do {
                arrby[--n4] = (byte)(128 | (n2 >>= 7) & 127);
            } while (n2 > 127);
            n3 += 5 - n4;
        }
        return n3;
    }

    /*
     * Exception decompiling
     */
    public static int findLimit(InputStream var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl44.1 : GETSTATIC : trying to set 1 previously set to 0
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

