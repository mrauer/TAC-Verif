/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.NoSuchElementException
 *  java.util.Objects
 */
package j$.util;

import j$.time.e;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional<T> {
    private static final Optional a = new Optional<T>();
    private final Object b;

    private Optional() {
        this.b = null;
    }

    private Optional(Object object) {
        Objects.requireNonNull((Object)object);
        this.b = object;
    }

    public static Optional a() {
        return a;
    }

    public static Optional d(Object object) {
        return new Optional<T>(object);
    }

    public static Optional ofNullable(Object object) {
        if (object == null) {
            return a;
        }
        return new Optional<T>(object);
    }

    public Object b() {
        Object object = this.b;
        if (object != null) {
            return object;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Optional)) {
            return false;
        }
        Optional optional = (Optional)object;
        return e.x(this.b, optional.b);
    }

    public int hashCode() {
        Object object = this.b;
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object object = this.b;
        if (object != null) {
            return String.format((String)"Optional[%s]", (Object[])new Object[]{object});
        }
        return "Optional.empty";
    }
}

