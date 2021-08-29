/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package joptsimple.internal;

public class Row {
    public final String description;
    public final String option;

    public Row(String string, String string2) {
        this.option = string;
        this.description = string2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null) {
            if (!Row.class.equals((Object)object.getClass())) {
                return false;
            }
            Row row = (Row)object;
            return this.option.equals((Object)row.option) && this.description.equals((Object)row.description);
        }
        return false;
    }

    public int hashCode() {
        return this.option.hashCode() ^ this.description.hashCode();
    }
}

