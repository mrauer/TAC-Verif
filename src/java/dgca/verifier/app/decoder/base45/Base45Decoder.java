/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  dalvik.annotation.SourceDebugExtension
 *  dgca.verifier.app.decoder.base45.Base45Decoder$decodeThreeChars
 *  dgca.verifier.app.decoder.base45.Base45Decoder$decodeThreeChars$1
 *  dgca.verifier.app.decoder.base45.Base45Decoder$generateSequenceByDivRem
 *  dgca.verifier.app.decoder.base45.Base45Decoder$generateSequenceByDivRem$1
 *  dgca.verifier.app.decoder.base45.Base45Decoder$generateSequenceByDivRem$2
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  kotlin.UByte
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt___SequencesKt
 *  kotlin.text.StringsKt__IndentKt
 *  kotlin.text.StringsKt___StringsKt
 *  kotlin.text.StringsKt___StringsKt$windowed
 *  kotlin.text.StringsKt___StringsKt$windowed$1
 */
package dgca.verifier.app.decoder.base45;

import com.google.android.material.R;
import dalvik.annotation.SourceDebugExtension;
import dgca.verifier.app.decoder.base45.Base45Decoder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt___StringsKt;

@SourceDebugExtension(value="SMAP\nBase45Decoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base45Decoder.kt\ndgca/verifier/app/decoder/base45/Base45Decoder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,67:1\n1517#2:68\n1588#2,3:69\n1517#2:72\n1588#2,3:73\n1093#3,4:76\n*S KotlinDebug\n*F\n+ 1 Base45Decoder.kt\ndgca/verifier/app/decoder/base45/Base45Decoder\n*L\n39#1:68\n39#1:69,3\n40#1:72\n40#1:73,3\n55#1:76,4\n*E\n")
public final class Base45Decoder {
    public final BigInteger int45 = BigInteger.valueOf((long)45L);

    public final byte[] decode(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"input");
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$chunked");
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$windowed");
        StringsKt___StringsKt.windowed.1 var2_2 = StringsKt___StringsKt.windowed.1.INSTANCE;
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$windowed");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"transform");
        int n2 = string.length();
        int n3 = n2 / 3;
        int n4 = n2 % 3;
        int n5 = 0;
        int n6 = n4 == 0 ? 0 : 1;
        ArrayList arrayList = new ArrayList(n3 + n6);
        int n7 = 0;
        while (n7 >= 0 && n2 > n7) {
            int n8 = n7 + 3;
            int n9 = n8 >= 0 && n8 <= n2 ? n8 : n2;
            arrayList.add(var2_2.invoke((Object)string.subSequence(n7, n9)));
            n7 = n8;
        }
        ArrayList arrayList2 = new ArrayList(R.style.collectionSizeOrDefault((Iterable)arrayList, (int)10));
        for (String string2 : arrayList) {
            List list;
            long l2 = 0L;
            int n10 = 0;
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                char c2 = string2.charAt(i2);
                int n11 = n10 + 1;
                if (StringsKt__IndentKt.contains$default((CharSequence)"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:", (char)c2, (boolean)false, (int)2)) {
                    BigInteger bigInteger = this.int45;
                    Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"int45");
                    l2 += bigInteger.pow(n10).longValue() * (long)StringsKt__IndentKt.indexOf$default((CharSequence)"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:", (char)c2, (int)0, (boolean)false, (int)6);
                    n10 = n11;
                    continue;
                }
                throw new IllegalArgumentException();
            }
            List list2 = ArraysKt___ArraysJvmKt.toMutableList((Collection)SequencesKt___SequencesKt.toList((Sequence)SequencesKt___SequencesKt.map((Sequence)SequencesKt___SequencesKt.map((Sequence)R.style.generateSequence((Object)l2, (Function1)generateSequenceByDivRem.1.INSTANCE), (Function1)generateSequenceByDivRem.2.INSTANCE), (Function1)decodeThreeChars.1.INSTANCE)));
            if (string2.length() == 3) {
                ArrayList arrayList3;
                while ((arrayList3 = (ArrayList)list2).size() < 2) {
                    arrayList3.add((Object)new UByte(0));
                }
            }
            Intrinsics.checkNotNullParameter((Object)list2, (String)"$this$reversed");
            if (((ArrayList)list2).size() <= 1) {
                list = ArraysKt___ArraysJvmKt.toList((Iterable)list2);
            } else {
                list = ArraysKt___ArraysJvmKt.toMutableList((Iterable)list2);
                Intrinsics.checkNotNullParameter((Object)list, (String)"$this$reverse");
                Collections.reverse((List)list);
            }
            arrayList2.add((Object)list);
        }
        Intrinsics.checkNotNullParameter((Object)arrayList2, (String)"$this$flatten");
        ArrayList arrayList4 = new ArrayList();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            ArraysKt___ArraysJvmKt.addAll((Collection)arrayList4, (Iterable)((Iterable)iterator.next()));
        }
        ArrayList arrayList5 = new ArrayList(R.style.collectionSizeOrDefault((Iterable)arrayList4, (int)10));
        Iterator iterator2 = arrayList4.iterator();
        while (iterator2.hasNext()) {
            arrayList5.add((Object)((UByte)iterator2.next()).data);
        }
        Intrinsics.checkNotNullParameter((Object)arrayList5, (String)"$this$toByteArray");
        byte[] arrby = new byte[arrayList5.size()];
        Iterator iterator3 = arrayList5.iterator();
        while (iterator3.hasNext()) {
            byte by = ((Number)iterator3.next()).byteValue();
            int n12 = n5 + 1;
            arrby[n5] = by;
            n5 = n12;
        }
        return arrby;
    }
}

