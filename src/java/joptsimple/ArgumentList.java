/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package joptsimple;

public class ArgumentList {
    public final String[] arguments;
    public int currentIndex;

    public /* varargs */ ArgumentList(String ... arrstring) {
        this.arguments = (String[])arrstring.clone();
    }

    public String next() {
        String[] arrstring = this.arguments;
        int n2 = this.currentIndex;
        this.currentIndex = n2 + 1;
        return arrstring[n2];
    }
}

