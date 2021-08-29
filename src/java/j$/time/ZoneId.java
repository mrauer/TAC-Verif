/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 *  java.util.TimeZone
 */
package j$.time;

import j$.time.ZoneOffset;
import j$.time.g;
import j$.time.m;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.i;
import j$.time.zone.c;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

public abstract class ZoneId
implements Serializable {
    public static final Map a;

    static {
        HashMap hashMap = new HashMap(64);
        hashMap.put((Object)"ACT", (Object)"Australia/Darwin");
        hashMap.put((Object)"AET", (Object)"Australia/Sydney");
        hashMap.put((Object)"AGT", (Object)"America/Argentina/Buenos_Aires");
        hashMap.put((Object)"ART", (Object)"Africa/Cairo");
        hashMap.put((Object)"AST", (Object)"America/Anchorage");
        hashMap.put((Object)"BET", (Object)"America/Sao_Paulo");
        hashMap.put((Object)"BST", (Object)"Asia/Dhaka");
        hashMap.put((Object)"CAT", (Object)"Africa/Harare");
        hashMap.put((Object)"CNT", (Object)"America/St_Johns");
        hashMap.put((Object)"CST", (Object)"America/Chicago");
        hashMap.put((Object)"CTT", (Object)"Asia/Shanghai");
        hashMap.put((Object)"EAT", (Object)"Africa/Addis_Ababa");
        hashMap.put((Object)"ECT", (Object)"Europe/Paris");
        hashMap.put((Object)"IET", (Object)"America/Indiana/Indianapolis");
        hashMap.put((Object)"IST", (Object)"Asia/Kolkata");
        hashMap.put((Object)"JST", (Object)"Asia/Tokyo");
        hashMap.put((Object)"MIT", (Object)"Pacific/Apia");
        hashMap.put((Object)"NET", (Object)"Asia/Yerevan");
        hashMap.put((Object)"NST", (Object)"Pacific/Auckland");
        hashMap.put((Object)"PLT", (Object)"Asia/Karachi");
        hashMap.put((Object)"PNT", (Object)"America/Phoenix");
        hashMap.put((Object)"PRT", (Object)"America/Puerto_Rico");
        hashMap.put((Object)"PST", (Object)"America/Los_Angeles");
        hashMap.put((Object)"SST", (Object)"Pacific/Guadalcanal");
        hashMap.put((Object)"VST", (Object)"Asia/Ho_Chi_Minh");
        hashMap.put((Object)"EST", (Object)"-05:00");
        hashMap.put((Object)"MST", (Object)"-07:00");
        hashMap.put((Object)"HST", (Object)"-10:00");
        a = Collections.unmodifiableMap((Map)hashMap);
    }

    ZoneId() {
        if (this.getClass() != ZoneOffset.class) {
            if (this.getClass() == m.class) {
                return;
            }
            throw new AssertionError((Object)"Invalid subclass");
        }
    }

    public static ZoneId F(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId)temporalAccessor.t(i.a);
        if (zoneId != null) {
            return zoneId;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain ZoneId from TemporalAccessor: ");
        stringBuilder.append((Object)temporalAccessor);
        stringBuilder.append(" of type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new g(stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ZoneId H(String string) {
        int n2;
        Objects.requireNonNull((Object)string, (String)"zoneId");
        if (string.length() <= 1 || string.startsWith("+") || string.startsWith("-")) return ZoneOffset.M(string);
        if (!string.startsWith("UTC") && !string.startsWith("GMT")) {
            if (!string.startsWith("UT")) return m.K(string, true);
            n2 = 2;
            return ZoneId.J(string, n2, true);
        } else {
            n2 = 3;
        }
        return ZoneId.J(string, n2, true);
    }

    private static ZoneId J(String string, int n2, boolean bl) {
        String string2 = string.substring(0, n2);
        if (string.length() == n2) {
            return ZoneId.ofOffset(string2, ZoneOffset.UTC);
        }
        if (string.charAt(n2) != '+' && string.charAt(n2) != '-') {
            return m.K(string, bl);
        }
        try {
            ZoneOffset zoneOffset = ZoneOffset.M(string.substring(n2));
            if (zoneOffset == ZoneOffset.UTC) {
                return ZoneId.ofOffset(string2, zoneOffset);
            }
            ZoneId zoneId = ZoneId.ofOffset(string2, zoneOffset);
            return zoneId;
        }
        catch (g g2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid ID for offset-based ZoneId: ");
            stringBuilder.append(string);
            throw new g(stringBuilder.toString(), (Throwable)g2);
        }
    }

    public static ZoneId ofOffset(String string, ZoneOffset zoneOffset) {
        Objects.requireNonNull((Object)string, (String)"prefix");
        Objects.requireNonNull((Object)zoneOffset, (String)"offset");
        if (string.length() == 0) {
            return zoneOffset;
        }
        if (!(string.equals((Object)"GMT") || string.equals((Object)"UTC") || string.equals((Object)"UT"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("prefix should be GMT, UTC or UT, is: ");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (zoneOffset.L() != 0) {
            string = string.concat(zoneOffset.m());
        }
        return new m(string, c.j(zoneOffset));
    }

    public static ZoneId systemDefault() {
        String string = TimeZone.getDefault().getID();
        Map map = a;
        Objects.requireNonNull((Object)string, (String)"zoneId");
        Objects.requireNonNull((Object)map, (String)"aliasMap");
        String string2 = (String)map.get((Object)string);
        if (string2 != null) {
            string = string2;
        }
        return ZoneId.H(string);
    }

    public abstract c G();

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ZoneId) {
            ZoneId zoneId = (ZoneId)object;
            return this.m().equals((Object)zoneId.m());
        }
        return false;
    }

    public int hashCode() {
        return this.m().hashCode();
    }

    public abstract String m();

    /*
     * Exception decompiling
     */
    public ZoneId normalized() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public String toString() {
        return this.m();
    }
}

