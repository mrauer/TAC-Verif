/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc;
import com.google.i18n.phonenumbers.internal.RegexCache;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexBasedMatcher {
    public final RegexCache regexCache = new RegexCache(100);

    public boolean matchNationalNumber(CharSequence charSequence, Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc, boolean bl) {
        String string = phonemetadata$PhoneNumberDesc.nationalNumberPattern_;
        if (string.length() == 0) {
            return false;
        }
        Matcher matcher = this.regexCache.getPatternForRegex(string).matcher(charSequence);
        if (!matcher.lookingAt()) {
            return false;
        }
        if (matcher.matches()) {
            bl = true;
        }
        return bl;
    }
}

