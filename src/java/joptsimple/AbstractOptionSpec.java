/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  joptsimple.NonOptionArgumentSpec
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import joptsimple.ArgumentList;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionDescriptor;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import joptsimple.ValueConverter;

public abstract class AbstractOptionSpec<V>
implements OptionSpec<V>,
OptionDescriptor {
    public final String description;
    public boolean forHelp;
    public final List<String> options;

    public AbstractOptionSpec(List<String> list, String string) {
        ArrayList arrayList;
        this.options = arrayList = new ArrayList();
        if (list.size() == 1) {
            arrayList.addAll(list);
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (String string2 : list) {
                if (string2.length() == 1) {
                    arrayList2.add((Object)string2);
                    continue;
                }
                arrayList3.add((Object)string2);
            }
            Collections.sort((List)arrayList2);
            Collections.sort((List)arrayList3);
            this.options.addAll((Collection)arrayList2);
            this.options.addAll((Collection)arrayList3);
        }
        this.description = string;
    }

    public String argumentTypeIndicatorFrom(ValueConverter<V> valueConverter) {
        return null;
    }

    public abstract V convert(String var1);

    @Override
    public String description() {
        return this.description;
    }

    public boolean equals(Object object) {
        if (!(object instanceof AbstractOptionSpec)) {
            return false;
        }
        AbstractOptionSpec abstractOptionSpec = (AbstractOptionSpec)object;
        return this.options.equals(abstractOptionSpec.options);
    }

    public abstract void handleOption(OptionParser var1, ArgumentList var2, OptionSet var3, String var4);

    public int hashCode() {
        return this.options.hashCode();
    }

    @Override
    public final List<String> options() {
        return Collections.unmodifiableList(this.options);
    }

    @Override
    public boolean representsNonOptions() {
        return this instanceof NonOptionArgumentSpec;
    }

    public String toString() {
        return this.options.toString();
    }
}

