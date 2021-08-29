/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TreeSet
 */
package joptsimple;

import com.google.android.material.R;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import joptsimple.BuiltinHelpFormatter;
import joptsimple.HelpFormatter;
import joptsimple.OptionDescriptor;
import joptsimple.ParserRules;
import joptsimple.internal.Row;
import joptsimple.internal.Rows;
import joptsimple.internal.Strings;

public class BuiltinHelpFormatter
implements HelpFormatter {
    public final Rows nonOptionRows = new Rows(160, 0);
    public final Rows optionRows = new Rows(80, 2);

    public void addOptionRow(String string, String string2) {
        this.optionRows.add(new Row(string, string2));
    }

    public void appendTypeIndicator(StringBuilder stringBuilder, String string, String string2, char c2, char c3) {
        stringBuilder.append(' ');
        stringBuilder.append(c2);
        if (string != null) {
            stringBuilder.append(string);
        }
        if (!Strings.isNullOrEmpty(string2)) {
            if (string != null) {
                stringBuilder.append(": ");
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append(c3);
    }

    @Override
    public String format(Map<String, ? extends OptionDescriptor> map) {
        this.optionRows.reset();
        this.nonOptionRows.reset();
        TreeSet treeSet = new TreeSet((Comparator)new Comparator<OptionDescriptor>(this){

            public int compare(Object object, Object object2) {
                OptionDescriptor optionDescriptor = (OptionDescriptor)object;
                OptionDescriptor optionDescriptor2 = (OptionDescriptor)object2;
                return ((String)optionDescriptor.options().iterator().next()).compareTo((String)optionDescriptor2.options().iterator().next());
            }

            public /* synthetic */ Comparator reversed() {
                return j$.util.Comparator$-CC.$default$reversed(this);
            }

            public /* synthetic */ Comparator thenComparing(j$.util.function.Function function) {
                return j$.util.Comparator$-CC.$default$thenComparing((Comparator)this, function);
            }

            public /* synthetic */ Comparator thenComparing(j$.util.function.Function function, Comparator comparator) {
                return j$.util.Comparator$-CC.$default$thenComparing(this, function, comparator);
            }

            public /* synthetic */ Comparator thenComparing(Comparator comparator) {
                return j$.util.Comparator$-CC.$default$thenComparing((Comparator)this, comparator);
            }

            public /* synthetic */ Comparator thenComparingDouble(j$.util.function.ToDoubleFunction toDoubleFunction) {
                return j$.util.Comparator$-CC.$default$thenComparingDouble(this, toDoubleFunction);
            }

            public /* synthetic */ Comparator thenComparingInt(j$.util.function.ToIntFunction toIntFunction) {
                return j$.util.Comparator$-CC.$default$thenComparingInt(this, toIntFunction);
            }

            public /* synthetic */ Comparator thenComparingLong(j$.util.function.ToLongFunction toLongFunction) {
                return j$.util.Comparator$-CC.$default$thenComparingLong(this, toLongFunction);
            }
        });
        treeSet.addAll(map.values());
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            OptionDescriptor optionDescriptor = (OptionDescriptor)iterator.next();
            if (!optionDescriptor.representsNonOptions()) continue;
            iterator.remove();
            boolean bl = !(Strings.isNullOrEmpty(optionDescriptor.description()) && Strings.isNullOrEmpty(optionDescriptor.argumentTypeIndicator()) && Strings.isNullOrEmpty(optionDescriptor.argumentDescription()));
            if (bl) {
                String string = this.message("non.option.arguments.header", new Object[0]);
                this.nonOptionRows.add(new Row(string, ""));
                StringBuilder stringBuilder = new StringBuilder();
                this.maybeAppendOptionInfo(stringBuilder, optionDescriptor);
                String string2 = stringBuilder.length() > 0 && !Strings.isNullOrEmpty(optionDescriptor.description()) ? " -- " : "";
                stringBuilder.append(string2);
                stringBuilder.append(optionDescriptor.description());
                String string3 = stringBuilder.toString();
                this.nonOptionRows.add(new Row(string3, ""));
            }
            if (treeSet.isEmpty()) {
                String string = this.message("no.options.specified", new Object[0]);
                this.optionRows.add(new Row(string, ""));
            } else {
                boolean bl2;
                block13 : {
                    Iterator iterator2 = treeSet.iterator();
                    while (iterator2.hasNext()) {
                        if (!((OptionDescriptor)iterator2.next()).isRequired()) continue;
                        bl2 = true;
                        break block13;
                    }
                    bl2 = false;
                }
                if (bl2) {
                    this.addOptionRow(this.message("option.header.with.required.indicator", new Object[0]), this.message("description.header", new Object[0]));
                    this.addOptionRow(this.message("option.divider.with.required.indicator", new Object[0]), this.message("description.divider", new Object[0]));
                } else {
                    this.addOptionRow(this.message("option.header", new Object[0]), this.message("description.header", new Object[0]));
                    this.addOptionRow(this.message("option.divider", new Object[0]), this.message("description.divider", new Object[0]));
                }
                for (OptionDescriptor optionDescriptor2 : treeSet) {
                    String string;
                    if (optionDescriptor2.representsNonOptions()) continue;
                    String string4 = optionDescriptor2.isRequired() ? "* " : "";
                    StringBuilder stringBuilder = new StringBuilder(string4);
                    Iterator iterator3 = optionDescriptor2.options().iterator();
                    while (iterator3.hasNext()) {
                        String string5 = (String)iterator3.next();
                        String string6 = string5.length() > 1 ? "--" : ParserRules.HYPHEN;
                        stringBuilder.append(string6);
                        stringBuilder.append(string5);
                        if (!iterator3.hasNext()) continue;
                        stringBuilder.append(", ");
                    }
                    this.maybeAppendOptionInfo(stringBuilder, optionDescriptor2);
                    String string7 = stringBuilder.toString();
                    Object object = optionDescriptor2.defaultValues();
                    if (object.isEmpty()) {
                        string = optionDescriptor2.description();
                    } else {
                        if (object.size() == 1) {
                            object = object.get(0);
                        }
                        String string8 = object.toString();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(optionDescriptor2.description());
                        stringBuilder2.append(' ');
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(this.message("default.value.header", new Object[0]));
                        stringBuilder3.append(' ');
                        stringBuilder3.append(string8);
                        String string9 = stringBuilder3.toString();
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append('(');
                        stringBuilder4.append(string9);
                        stringBuilder4.append(')');
                        stringBuilder2.append(stringBuilder4.toString());
                        string = stringBuilder2.toString().trim();
                    }
                    this.addOptionRow(string7, string);
                }
            }
            this.nonOptionRows.fitToWidth();
            this.optionRows.fitToWidth();
            StringBuilder stringBuilder = new StringBuilder();
            String string = this.nonOptionRows.render();
            if (!Strings.isNullOrEmpty(string)) {
                stringBuilder.append(string);
                stringBuilder.append(Strings.LINE_SEPARATOR);
            }
            stringBuilder.append(this.optionRows.render());
            return stringBuilder.toString();
        }
        throw new AssertionError((Object)"no non-options argument spec");
    }

    public void maybeAppendOptionInfo(StringBuilder stringBuilder, OptionDescriptor optionDescriptor) {
        String string = optionDescriptor.argumentTypeIndicator();
        String string2 = !Strings.isNullOrEmpty(string) && !String.class.getName().equals((Object)string) ? string.substring(1 + string.lastIndexOf(46)) : "String";
        String string3 = string2;
        String string4 = optionDescriptor.argumentDescription();
        if (optionDescriptor.acceptsArguments() || !Strings.isNullOrEmpty(string4) || optionDescriptor.representsNonOptions()) {
            if (optionDescriptor.requiresArgument()) {
                this.appendTypeIndicator(stringBuilder, string3, string4, '<', '>');
                return;
            }
            this.appendTypeIndicator(stringBuilder, string3, string4, '[', ']');
        }
    }

    public /* varargs */ String message(String string, Object ... arrobject) {
        return R.style.message((Locale)Locale.getDefault(), (String)"joptsimple.HelpFormatterMessages", BuiltinHelpFormatter.class, (String)string, (Object[])arrobject);
    }
}

