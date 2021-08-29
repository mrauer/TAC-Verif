/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedList
 *  java.util.List
 */
package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.LinkedList;
import java.util.List;

public final class TrieParser {
    public static final Joiner PREFIX_JOINER = new Joiner("");

    public static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, int n3, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int n4;
        String string;
        int n5 = charSequence.length();
        char c4 = '\u0000';
        for (n4 = n3; n4 < n5 && (c4 = charSequence.charAt(n4)) != '&' && c4 != '?' && c4 != '!' && c4 != ':' && c4 != ','; ++n4) {
        }
        list.add(0, (Object)new StringBuilder(charSequence.subSequence(n3, n4)).reverse());
        if ((c4 == '!' || c4 == '?' || c4 == ':' || c4 == ',') && (string = PREFIX_JOINER.join(list)).length() > 0) {
            builder.put((Object)string, (Object)PublicSuffixType.fromCode(c4));
        }
        int n6 = n4 + 1;
        if (c4 != '?' && c4 != ',') {
            while (n6 < n5) {
                if (charSequence.charAt(n6 += TrieParser.doParseTrieToBuilder(list, charSequence, n6, builder)) != '?' && charSequence.charAt(n6) != ',') continue;
                ++n6;
                break;
            }
        }
        list.remove(0);
        return n6 - n3;
    }

    public static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int n3 = charSequence.length();
        for (int i3 = 0; i3 < n3; i3 += TrieParser.doParseTrieToBuilder((List<CharSequence>)new LinkedList(), (CharSequence)charSequence, (int)i3, (ImmutableMap.Builder<String, PublicSuffixType>)builder)) {
        }
        return builder.build();
    }
}

