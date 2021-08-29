/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.TreeMap
 */
package joptsimple.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import joptsimple.internal.OptionNameMap;

public class AbbreviationMap<V>
implements OptionNameMap<V> {
    public final Map<Character, AbbreviationMap<V>> children = new TreeMap();
    public String key;
    public int keysBeyond;
    public V value;

    public final boolean add(char[] arrc, V v2, int n2, int n3) {
        boolean bl;
        if (n2 == n3) {
            this.value = v2;
            boolean bl2 = this.key != null;
            this.key = new String(arrc);
            return bl2 ^ true;
        }
        char c2 = arrc[n2];
        AbbreviationMap<V> abbreviationMap = (AbbreviationMap<V>)this.children.get((Object)Character.valueOf((char)c2));
        if (abbreviationMap == null) {
            abbreviationMap = new AbbreviationMap<V>();
            this.children.put((Object)Character.valueOf((char)c2), abbreviationMap);
        }
        if (bl = abbreviationMap.add(arrc, v2, n2 + 1, n3)) {
            this.keysBeyond = 1 + this.keysBeyond;
        }
        if (this.key == null) {
            if (this.keysBeyond > 1) {
                v2 = null;
            }
            this.value = v2;
        }
        return bl;
    }

    public final void addToMappings(Map<String, V> map) {
        String string = this.key;
        if (string != null) {
            map.put((Object)string, this.value);
        }
        Iterator iterator = this.children.values().iterator();
        while (iterator.hasNext()) {
            ((AbbreviationMap)iterator.next()).addToMappings(map);
        }
    }

    @Override
    public boolean contains(String string) {
        return this.get(string) != null;
    }

    @Override
    public V get(String string) {
        int n2 = string.length();
        char[] arrc = new char[n2];
        int n3 = string.length();
        string.getChars(0, n3, arrc, 0);
        AbbreviationMap abbreviationMap = this;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = arrc[i2];
            abbreviationMap = (AbbreviationMap)abbreviationMap.children.get((Object)Character.valueOf((char)c2));
            if (abbreviationMap != null) continue;
            return null;
        }
        return abbreviationMap.value;
    }

    @Override
    public void putAll(Iterable<String> iterable, V v2) {
        for (String string : iterable) {
            if (string.length() != 0) {
                int n2 = string.length();
                char[] arrc = new char[n2];
                string.getChars(0, string.length(), arrc, 0);
                this.add(arrc, v2, 0, n2);
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Map<String, V> toJavaUtilMap() {
        TreeMap treeMap = new TreeMap();
        this.addToMappings((Map<String, V>)treeMap);
        return treeMap;
    }
}

