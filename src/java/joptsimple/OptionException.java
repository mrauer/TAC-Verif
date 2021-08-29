/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Locale
 */
package joptsimple;

import com.google.android.material.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import joptsimple.OptionSpec;

public abstract class OptionException
extends RuntimeException {
    public static final /* synthetic */ int $r8$clinit;
    public final List<String> options;

    public OptionException(Collection<? extends OptionSpec<?>> collection) {
        ArrayList arrayList;
        this.options = arrayList = new ArrayList();
        arrayList.addAll(this.specsToStrings(collection));
    }

    public OptionException(List<String> list) {
        ArrayList arrayList;
        this.options = arrayList = new ArrayList();
        arrayList.addAll(list);
    }

    public final String getMessage() {
        return R.style.message((Locale)Locale.getDefault(), (String)"joptsimple.ExceptionMessages", (Class)this.getClass(), (String)"message", (Object[])this.messageArguments());
    }

    public abstract Object[] messageArguments();

    public final String multipleOptionString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Iterator iterator = new LinkedHashSet(this.options).iterator();
        while (iterator.hasNext()) {
            stringBuilder.append((String)iterator.next());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final String singleOptionString() {
        return (String)this.options.get(0);
    }

    public final List<String> specsToStrings(Collection<? extends OptionSpec<?>> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ArrayList arrayList2 = new ArrayList(((OptionSpec)iterator.next()).options());
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator2 = arrayList2.iterator();
            while (iterator2.hasNext()) {
                stringBuilder.append((String)iterator2.next());
                if (!iterator2.hasNext()) continue;
                stringBuilder.append("/");
            }
            arrayList.add((Object)stringBuilder.toString());
        }
        return arrayList;
    }
}

