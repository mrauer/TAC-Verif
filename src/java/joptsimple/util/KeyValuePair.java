/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package joptsimple.util;

public final class KeyValuePair {
    public final String key;
    public final String value;

    public KeyValuePair(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public static KeyValuePair valueOf(String string) {
        int n2 = string.indexOf(61);
        if (n2 == -1) {
            return new KeyValuePair(string, null);
        }
        String string2 = string.substring(0, n2);
        String string3 = n2 == -1 + string.length() ? "" : string.substring(n2 + 1);
        return new KeyValuePair(string2, string3);
    }

    public boolean equals(Object object) {
        if (!(object instanceof KeyValuePair)) {
            return false;
        }
        KeyValuePair keyValuePair = (KeyValuePair)object;
        boolean bl = this.key.equals((Object)keyValuePair.key);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.value.equals((Object)keyValuePair.value);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.key);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}

