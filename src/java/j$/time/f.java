/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package j$.time;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Serializable;

public abstract class f {
    protected f() {
    }

    public static f d() {
        return new a(ZoneId.systemDefault());
    }

    public static f e() {
        return new a(ZoneOffset.UTC);
    }

    public abstract ZoneId a();

    public abstract Instant b();

    public abstract long c();

    static final class a
    extends f
    implements Serializable {
        private final ZoneId a;

        a(ZoneId zoneId) {
            this.a = zoneId;
        }

        @Override
        public ZoneId a() {
            return this.a;
        }

        @Override
        public Instant b() {
            return Instant.M(System.currentTimeMillis());
        }

        @Override
        public long c() {
            return System.currentTimeMillis();
        }

        public boolean equals(Object object) {
            if (object instanceof a) {
                return this.a.equals(((a)object).a);
            }
            return false;
        }

        public int hashCode() {
            return 1 + this.a.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = j$.com.android.tools.r8.a.b("SystemClock[");
            stringBuilder.append((Object)this.a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

}

