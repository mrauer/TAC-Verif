/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.IdentityHashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  joptsimple.AbstractOptionSpec
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import joptsimple.AbstractOptionSpec;
import joptsimple.OptionSpec;

public class OptionSet {
    public final Map<String, List<?>> defaultValues;
    public final Map<String, AbstractOptionSpec<?>> detectedOptions = new HashMap();
    public final List<OptionSpec<?>> detectedSpecs = new ArrayList();
    public final Map<AbstractOptionSpec<?>, List<String>> optionsToArguments = new IdentityHashMap();
    public final Map<String, AbstractOptionSpec<?>> recognizedSpecs;

    public OptionSet(Map<String, AbstractOptionSpec<?>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey(), ((AbstractOptionSpec)entry.getValue()).defaultValues());
        }
        this.defaultValues = hashMap;
        this.recognizedSpecs = map;
    }

    public void addWithArgument(AbstractOptionSpec<?> abstractOptionSpec, String string) {
        this.detectedSpecs.add(abstractOptionSpec);
        for (String string2 : abstractOptionSpec.options()) {
            this.detectedOptions.put((Object)string2, abstractOptionSpec);
        }
        List list = (List)this.optionsToArguments.get(abstractOptionSpec);
        if (list == null) {
            list = new ArrayList();
            this.optionsToArguments.put(abstractOptionSpec, (Object)list);
        }
        if (string != null) {
            list.add((Object)string);
        }
    }

    public final <V> List<V> defaultValuesFor(String string) {
        if (this.defaultValues.containsKey((Object)string)) {
            return Collections.unmodifiableList((List)((List)this.defaultValues.get((Object)string)));
        }
        return Collections.emptyList();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (!OptionSet.class.equals((Object)object.getClass())) {
                return false;
            }
            OptionSet optionSet = (OptionSet)object;
            HashMap hashMap = new HashMap(this.optionsToArguments);
            HashMap hashMap2 = new HashMap(optionSet.optionsToArguments);
            return this.detectedOptions.equals(optionSet.detectedOptions) && hashMap.equals((Object)hashMap2);
        }
        return false;
    }

    public boolean has(OptionSpec<?> optionSpec) {
        return this.optionsToArguments.containsKey(optionSpec);
    }

    public int hashCode() {
        HashMap hashMap = new HashMap(this.optionsToArguments);
        return this.detectedOptions.hashCode() ^ hashMap.hashCode();
    }

    public <V> List<V> valuesOf(OptionSpec<V> optionSpec) {
        Objects.requireNonNull(optionSpec);
        List list = (List)this.optionsToArguments.get(optionSpec);
        if (list != null && !list.isEmpty()) {
            AbstractOptionSpec abstractOptionSpec = (AbstractOptionSpec)optionSpec;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add(abstractOptionSpec.convert((String)iterator.next()));
            }
            return Collections.unmodifiableList((List)arrayList);
        }
        return this.defaultValuesFor((String)optionSpec.options().iterator().next());
    }
}

