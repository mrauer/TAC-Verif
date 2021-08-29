/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.google.i18n.phonenumbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.MultiFileMetadataSourceImpl;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;
import com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.internal.RegexCache;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    public static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    public static final Map<Character, Character> ALPHA_MAPPINGS;
    public static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    public static final Pattern CAPTURING_DIGIT_PATTERN;
    public static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    public static final Pattern EXTN_PATTERN;
    public static final String EXTN_PATTERNS_FOR_PARSING;
    public static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    public static final Pattern PLUS_CHARS_PATTERN;
    public static final Pattern SECOND_NUMBER_START_PATTERN;
    public static final Pattern UNWANTED_END_CHAR_PATTERN;
    public static final String VALID_ALPHA;
    public static final Pattern VALID_ALPHA_PHONE_PATTERN;
    public static final String VALID_PHONE_NUMBER;
    public static final Pattern VALID_PHONE_NUMBER_PATTERN;
    public static final Pattern VALID_START_CHAR_PATTERN;
    public static PhoneNumberUtil instance;
    public static final Logger logger;
    public final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    public final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
    public final RegexBasedMatcher matcherApi = new RegexBasedMatcher();
    public final MultiFileMetadataSourceImpl metadataSource;
    public final Set<String> nanpaRegions = new HashSet(35);
    public final RegexCache regexCache = new RegexCache(100);
    public final Set<String> supportedRegions = new HashSet(320);

    public static {
        Map map;
        String string;
        String string2;
        String string3;
        logger = Logger.getLogger((String)PhoneNumberUtil.class.getName());
        HashMap hashMap = new HashMap();
        Integer n3 = 54;
        Character c4 = Character.valueOf((char)'6');
        hashMap.put((Object)n3, (Object)"9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap((Map)hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add((Object)86);
        Collections.unmodifiableSet((Set)hashSet);
        HashSet hashSet2 = new HashSet();
        Character c5 = Character.valueOf((char)'4');
        hashSet2.add((Object)52);
        hashSet2.add((Object)n3);
        Character c6 = Character.valueOf((char)'7');
        hashSet2.add((Object)55);
        hashSet2.add((Object)62);
        hashSet2.addAll((Collection)hashSet);
        Collections.unmodifiableSet((Set)hashSet2);
        HashMap hashMap2 = new HashMap();
        Character c7 = Character.valueOf((char)'0');
        hashMap2.put((Object)c7, (Object)c7);
        Character c8 = Character.valueOf((char)'1');
        hashMap2.put((Object)c8, (Object)c8);
        Character c9 = Character.valueOf((char)'2');
        hashMap2.put((Object)c9, (Object)c9);
        Character c10 = Character.valueOf((char)'3');
        hashMap2.put((Object)c10, (Object)c10);
        hashMap2.put((Object)c5, (Object)c5);
        Character c11 = Character.valueOf((char)'5');
        hashMap2.put((Object)c11, (Object)c11);
        hashMap2.put((Object)c4, (Object)c4);
        hashMap2.put((Object)c6, (Object)c6);
        Character c12 = Character.valueOf((char)'8');
        hashMap2.put((Object)c12, (Object)c12);
        Character c13 = Character.valueOf((char)'9');
        hashMap2.put((Object)c13, (Object)c13);
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put((Object)Character.valueOf((char)'A'), (Object)c9);
        hashMap3.put((Object)Character.valueOf((char)'B'), (Object)c9);
        hashMap3.put((Object)Character.valueOf((char)'C'), (Object)c9);
        hashMap3.put((Object)Character.valueOf((char)'D'), (Object)c10);
        hashMap3.put((Object)Character.valueOf((char)'E'), (Object)c10);
        hashMap3.put((Object)Character.valueOf((char)'F'), (Object)c10);
        hashMap3.put((Object)Character.valueOf((char)'G'), (Object)c5);
        hashMap3.put((Object)Character.valueOf((char)'H'), (Object)c5);
        hashMap3.put((Object)Character.valueOf((char)'I'), (Object)c5);
        hashMap3.put((Object)Character.valueOf((char)'J'), (Object)c11);
        hashMap3.put((Object)Character.valueOf((char)'K'), (Object)c11);
        hashMap3.put((Object)Character.valueOf((char)'L'), (Object)c11);
        hashMap3.put((Object)Character.valueOf((char)'M'), (Object)c4);
        hashMap3.put((Object)Character.valueOf((char)'N'), (Object)c4);
        hashMap3.put((Object)Character.valueOf((char)'O'), (Object)c4);
        hashMap3.put((Object)Character.valueOf((char)'P'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'Q'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'R'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'S'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'T'), (Object)c12);
        hashMap3.put((Object)Character.valueOf((char)'U'), (Object)c12);
        hashMap3.put((Object)Character.valueOf((char)'V'), (Object)c12);
        hashMap3.put((Object)Character.valueOf((char)'W'), (Object)c13);
        hashMap3.put((Object)Character.valueOf((char)'X'), (Object)c13);
        hashMap3.put((Object)Character.valueOf((char)'Y'), (Object)c13);
        hashMap3.put((Object)Character.valueOf((char)'Z'), (Object)c13);
        ALPHA_MAPPINGS = map = Collections.unmodifiableMap((Map)hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(map);
        hashMap4.putAll((Map)hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap((Map)hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll((Map)hashMap2);
        Character c14 = Character.valueOf((char)'+');
        hashMap5.put((Object)c14, (Object)c14);
        Character c15 = Character.valueOf((char)'*');
        hashMap5.put((Object)c15, (Object)c15);
        Character c16 = Character.valueOf((char)'#');
        hashMap5.put((Object)c16, (Object)c16);
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap((Map)hashMap5);
        HashMap hashMap6 = new HashMap();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            char c17 = ((Character)iterator.next()).charValue();
            hashMap6.put((Object)Character.valueOf((char)Character.toLowerCase((char)c17)), (Object)Character.valueOf((char)c17));
            hashMap6.put((Object)Character.valueOf((char)c17), (Object)Character.valueOf((char)c17));
        }
        hashMap6.putAll((Map)hashMap2);
        hashMap6.put((Object)Character.valueOf((char)'-'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0d'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2010'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2011'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2012'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2013'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2014'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2015'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2212'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'/'), (Object)Character.valueOf((char)'/'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0f'), (Object)Character.valueOf((char)'/'));
        hashMap6.put((Object)Character.valueOf((char)' '), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'\u3000'), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'\u2060'), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'.'), (Object)Character.valueOf((char)'.'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0e'), (Object)Character.valueOf((char)'.'));
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap((Map)hashMap6);
        Pattern.compile((String)"[\\d]+(?:[~\u2053\u223c\uff5e][\\d]+)?");
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Character> map2 = ALPHA_MAPPINGS;
        stringBuilder.append(Arrays.toString((Object[])map2.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        stringBuilder.append(Arrays.toString((Object[])map2.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        VALID_ALPHA = string3 = stringBuilder.toString();
        PLUS_CHARS_PATTERN = Pattern.compile((String)"[+\uff0b]+");
        Pattern.compile((String)"[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile((String)"(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile((String)"[+\uff0b\\p{Nd}]");
        SECOND_NUMBER_START_PATTERN = Pattern.compile((String)"[\\\\/] *x");
        UNWANTED_END_CHAR_PATTERN = Pattern.compile((String)"[[\\P{N}&&\\P{L}]&&[^#]]+$");
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile((String)"(?:.*?[A-Za-z]){3}.*");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\\p{Nd}{2}|[+\uff0b]*+(?:[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*]*\\p{Nd}){3,}[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*");
        stringBuilder2.append(string3);
        stringBuilder2.append("\\p{Nd}");
        stringBuilder2.append("]*");
        VALID_PHONE_NUMBER = string2 = stringBuilder2.toString();
        EXTN_PATTERNS_FOR_PARSING = string = PhoneNumberUtil.createExtnPattern(",;x\uff58#\uff03~\uff5e");
        PhoneNumberUtil.createExtnPattern("x\uff58#\uff03~\uff5e");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("(?:");
        stringBuilder3.append(string);
        stringBuilder3.append(")$");
        EXTN_PATTERN = Pattern.compile((String)stringBuilder3.toString(), (int)66);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(string2);
        stringBuilder4.append("(?:");
        stringBuilder4.append(string);
        stringBuilder4.append(")?");
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile((String)stringBuilder4.toString(), (int)66);
        Pattern.compile((String)"(\\D+)");
        Pattern.compile((String)"(\\$\\d)");
        Pattern.compile((String)"\\(?\\$1\\)?");
        instance = null;
    }

    public PhoneNumberUtil(MultiFileMetadataSourceImpl multiFileMetadataSourceImpl, Map<Integer, List<String>> map) {
        this.metadataSource = multiFileMetadataSourceImpl;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Map.Entry entry : map.entrySet()) {
            List list = (List)entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
                continue;
            }
            this.supportedRegions.addAll((Collection)list);
        }
        if (this.supportedRegions.remove((Object)"001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll((Collection)map.get((Object)1));
    }

    public static String createExtnPattern(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(";ext=(\\p{Nd}{1,7})|[ \u00a0\\t,]*(?:e?xt(?:ensi(?:o\u0301?|\u00f3))?n?|\uff45?\uff58\uff54\uff4e?|\u0434\u043e\u0431|[");
        stringBuilder.append(string);
        stringBuilder.append("]|int|anexo|\uff49\uff4e\uff54)[:\\.\uff0e]?[ \u00a0\\t,-]*");
        stringBuilder.append("(\\p{Nd}{1,7})");
        stringBuilder.append("#?|[- ]+(");
        return GeneratedOutlineSupport.outline21((StringBuilder)stringBuilder, (String)"\\p{Nd}", (String)"{1,5})#");
    }

    public static boolean descHasPossibleNumberData(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        boolean bl;
        block3 : {
            block2 : {
                if (phonemetadata$PhoneNumberDesc.possibleLength_.size() != 1) break block2;
                int n3 = (Integer)phonemetadata$PhoneNumberDesc.possibleLength_.get(0);
                bl = false;
                if (n3 == -1) break block3;
            }
            bl = true;
        }
        return bl;
    }

    public static boolean isViablePhoneNumber(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(charSequence).matches();
    }

    public static StringBuilder normalize(StringBuilder stringBuilder) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher((CharSequence)stringBuilder).matches()) {
            int n3 = stringBuilder.length();
            Map<Character, Character> map = ALPHA_PHONE_MAPPINGS;
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.length());
            for (int i3 = 0; i3 < stringBuilder.length(); ++i3) {
                Character c4 = (Character)map.get((Object)Character.valueOf((char)Character.toUpperCase((char)stringBuilder.charAt(i3))));
                if (c4 == null) continue;
                stringBuilder2.append((Object)c4);
            }
            stringBuilder.replace(0, n3, stringBuilder2.toString());
            return stringBuilder;
        }
        stringBuilder.replace(0, stringBuilder.length(), PhoneNumberUtil.normalizeDigitsOnly((CharSequence)stringBuilder));
        return stringBuilder;
    }

    public static String normalizeDigitsOnly(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(charSequence.length());
        for (int i3 = 0; i3 < charSequence.length(); ++i3) {
            int n3 = Character.digit((char)charSequence.charAt(i3), (int)10);
            if (n3 == -1) continue;
            stringBuilder.append(n3);
        }
        return stringBuilder.toString();
    }

    public Phonemetadata$PhoneMetadata getMetadataForRegion(String string) {
        boolean bl = string != null && this.supportedRegions.contains((Object)string);
        if (!bl) {
            return null;
        }
        MultiFileMetadataSourceImpl multiFileMetadataSourceImpl = this.metadataSource;
        return MetadataManager.getMetadataFromMultiFilePrefix(string, multiFileMetadataSourceImpl.geographicalRegions, multiFileMetadataSourceImpl.phoneNumberMetadataFilePrefix, multiFileMetadataSourceImpl.metadataLoader);
    }

    public Phonemetadata$PhoneNumberDesc getNumberDescByType(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        switch (phoneNumberType.ordinal()) {
            default: {
                break;
            }
            case 10: {
                return phonemetadata$PhoneMetadata.voicemail_;
            }
            case 9: {
                return phonemetadata$PhoneMetadata.uan_;
            }
            case 8: {
                return phonemetadata$PhoneMetadata.pager_;
            }
            case 7: {
                return phonemetadata$PhoneMetadata.personalNumber_;
            }
            case 6: {
                return phonemetadata$PhoneMetadata.voip_;
            }
            case 5: {
                return phonemetadata$PhoneMetadata.sharedCost_;
            }
            case 0: 
            case 2: {
                return phonemetadata$PhoneMetadata.fixedLine_;
            }
            case 1: {
                return phonemetadata$PhoneMetadata.mobile_;
            }
            case 3: {
                return phonemetadata$PhoneMetadata.tollFree_;
            }
            case 4: {
                return phonemetadata$PhoneMetadata.premiumRate_;
            }
        }
        return phonemetadata$PhoneMetadata.generalDesc_;
    }

    public int maybeExtractCountryCode(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder stringBuilder, boolean bl, Phonenumber$PhoneNumber phonenumber$PhoneNumber) throws NumberParseException {
        Phonenumber$PhoneNumber.CountryCodeSource countryCodeSource;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder stringBuilder2 = new StringBuilder(charSequence);
        String string = phonemetadata$PhoneMetadata != null ? phonemetadata$PhoneMetadata.internationalPrefix_ : "NonMatch";
        int n3 = stringBuilder2.length();
        int n4 = 1;
        if (n3 == 0) {
            countryCodeSource = Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        } else {
            Matcher matcher = PLUS_CHARS_PATTERN.matcher((CharSequence)stringBuilder2);
            if (matcher.lookingAt()) {
                stringBuilder2.delete(0, matcher.end());
                PhoneNumberUtil.normalize(stringBuilder2);
                countryCodeSource = Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            } else {
                int n5;
                int n6;
                Matcher matcher2;
                Pattern pattern = this.regexCache.getPatternForRegex(string);
                PhoneNumberUtil.normalize(stringBuilder2);
                Matcher matcher3 = pattern.matcher((CharSequence)stringBuilder2);
                if (!(!matcher3.lookingAt() || (matcher2 = CAPTURING_DIGIT_PATTERN.matcher((CharSequence)stringBuilder2.substring(n5 = matcher3.end()))).find() && PhoneNumberUtil.normalizeDigitsOnly(matcher2.group(n4)).equals((Object)"0"))) {
                    stringBuilder2.delete(0, n5);
                    n6 = n4;
                } else {
                    n6 = 0;
                }
                countryCodeSource = n6 != 0 ? Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD : Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
            }
        }
        if (bl) {
            Objects.requireNonNull((Object)phonenumber$PhoneNumber);
            Objects.requireNonNull((Object)((Object)countryCodeSource));
            phonenumber$PhoneNumber.hasCountryCodeSource = n4;
            phonenumber$PhoneNumber.countryCodeSource_ = countryCodeSource;
        }
        if (countryCodeSource != Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (stringBuilder2.length() > 2) {
                int n7 = stringBuilder2.length();
                int n8 = 0;
                if (n7 != 0) {
                    if (stringBuilder2.charAt(0) == '0') {
                        n8 = 0;
                    } else {
                        int n9 = stringBuilder2.length();
                        do {
                            n8 = 0;
                            if (n4 > 3) break;
                            n8 = 0;
                            if (n4 > n9) break;
                            int n10 = Integer.parseInt((String)stringBuilder2.substring(0, n4));
                            if (this.countryCallingCodeToRegionCodeMap.containsKey((Object)n10)) {
                                stringBuilder.append(stringBuilder2.substring(n4));
                                n8 = n10;
                                break;
                            }
                            ++n4;
                        } while (true);
                    }
                }
                if (n8 != 0) {
                    phonenumber$PhoneNumber.countryCode_ = n8;
                    return n8;
                }
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
        if (phonemetadata$PhoneMetadata != null) {
            int n11 = phonemetadata$PhoneMetadata.countryCode_;
            String string2 = String.valueOf((int)n11);
            String string3 = stringBuilder2.toString();
            if (string3.startsWith(string2)) {
                StringBuilder stringBuilder3 = new StringBuilder(string3.substring(string2.length()));
                Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = phonemetadata$PhoneMetadata.generalDesc_;
                this.maybeStripNationalPrefixAndCarrierCode(stringBuilder3, phonemetadata$PhoneMetadata, null);
                if (!this.matcherApi.matchNationalNumber((CharSequence)stringBuilder2, phonemetadata$PhoneNumberDesc, false) && this.matcherApi.matchNationalNumber((CharSequence)stringBuilder3, phonemetadata$PhoneNumberDesc, false) || this.testNumberLength((CharSequence)stringBuilder2, phonemetadata$PhoneMetadata, PhoneNumberType.UNKNOWN) == ValidationResult.TOO_LONG) {
                    stringBuilder.append((CharSequence)stringBuilder3);
                    if (bl) {
                        Phonenumber$PhoneNumber.CountryCodeSource countryCodeSource2 = Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN;
                        Objects.requireNonNull((Object)phonenumber$PhoneNumber);
                        Objects.requireNonNull((Object)((Object)countryCodeSource2));
                        phonenumber$PhoneNumber.hasCountryCodeSource = n4;
                        phonenumber$PhoneNumber.countryCodeSource_ = countryCodeSource2;
                    }
                    phonenumber$PhoneNumber.countryCode_ = n11;
                    return n11;
                }
            }
        }
        phonenumber$PhoneNumber.countryCode_ = 0;
        return 0;
    }

    public boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder stringBuilder, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder stringBuilder2) {
        int n3 = stringBuilder.length();
        String string = phonemetadata$PhoneMetadata.nationalPrefixForParsing_;
        if (n3 != 0) {
            if (string.length() == 0) {
                return false;
            }
            Matcher matcher = this.regexCache.getPatternForRegex(string).matcher((CharSequence)stringBuilder);
            if (matcher.lookingAt()) {
                Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = phonemetadata$PhoneMetadata.generalDesc_;
                boolean bl = this.matcherApi.matchNationalNumber((CharSequence)stringBuilder, phonemetadata$PhoneNumberDesc, false);
                int n4 = matcher.groupCount();
                String string2 = phonemetadata$PhoneMetadata.nationalPrefixTransformRule_;
                if (string2 != null && string2.length() != 0 && matcher.group(n4) != null) {
                    StringBuilder stringBuilder3 = new StringBuilder((CharSequence)stringBuilder);
                    stringBuilder3.replace(0, n3, matcher.replaceFirst(string2));
                    if (bl && !this.matcherApi.matchNationalNumber(stringBuilder3.toString(), phonemetadata$PhoneNumberDesc, false)) {
                        return false;
                    }
                    if (stringBuilder2 != null && n4 > 1) {
                        stringBuilder2.append(matcher.group(1));
                    }
                    stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
                    return true;
                }
                if (bl && !this.matcherApi.matchNationalNumber(stringBuilder.substring(matcher.end()), phonemetadata$PhoneNumberDesc, false)) {
                    return false;
                }
                if (stringBuilder2 != null && n4 > 0 && matcher.group(n4) != null) {
                    stringBuilder2.append(matcher.group(1));
                }
                stringBuilder.delete(0, matcher.end());
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Phonenumber$PhoneNumber parse(CharSequence var1_1, String var2_2) throws NumberParseException {
        block23 : {
            block22 : {
                block24 : {
                    var3_3 = new Phonenumber$PhoneNumber();
                    if (var1_1.length() > 250) throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
                    var4_4 = new StringBuilder();
                    var5_5 = var1_1.toString();
                    var6_6 = var5_5.indexOf(";phone-context=");
                    var7_7 = "";
                    if (var6_6 >= 0) {
                        var44_8 = var6_6 + 15;
                        if (var44_8 < -1 + var5_5.length() && var5_5.charAt(var44_8) == '+') {
                            var48_9 = var5_5.indexOf(59, var44_8);
                            if (var48_9 > 0) {
                                var4_4.append(var5_5.substring(var44_8, var48_9));
                            } else {
                                var4_4.append(var5_5.substring(var44_8));
                            }
                        }
                        var46_11 = (var45_10 = var5_5.indexOf("tel:")) >= 0 ? var45_10 + 4 : 0;
                        var4_4.append(var5_5.substring(var46_11, var6_6));
                    } else {
                        var8_12 = PhoneNumberUtil.VALID_START_CHAR_PATTERN.matcher((CharSequence)var5_5);
                        if (var8_12.find()) {
                            var9_13 = var5_5.subSequence(var8_12.start(), var5_5.length());
                            var42_14 = PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN.matcher((CharSequence)var9_13);
                            if (var42_14.find()) {
                                var9_13 = var9_13.subSequence(0, var42_14.start());
                            }
                            if ((var43_15 = PhoneNumberUtil.SECOND_NUMBER_START_PATTERN.matcher((CharSequence)var9_13)).find()) {
                                var9_13 = var9_13.subSequence(0, var43_15.start());
                            }
                        } else {
                            var9_13 = var7_7;
                        }
                        var4_4.append((CharSequence)var9_13);
                    }
                    var11_16 = var4_4.indexOf(";isub=");
                    if (var11_16 > 0) {
                        var4_4.delete(var11_16, var4_4.length());
                    }
                    if (PhoneNumberUtil.isViablePhoneNumber((CharSequence)var4_4) == false) throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
                    var12_17 = this.supportedRegions.contains((Object)var2_2) != false;
                    var13_18 = var12_17 != false || var4_4.length() != 0 && PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher((CharSequence)var4_4).lookingAt() != false;
                    if (var13_18 == false) throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                    var14_19 = PhoneNumberUtil.EXTN_PATTERN.matcher((CharSequence)var4_4);
                    if (var14_19.find() && PhoneNumberUtil.isViablePhoneNumber(var4_4.substring(0, var14_19.start()))) {
                        var38_20 = var14_19.groupCount();
                        for (var39_21 = 1; var39_21 <= var38_20; ++var39_21) {
                            if (var14_19.group(var39_21) == null) continue;
                            var7_7 = var14_19.group(var39_21);
                            var4_4.delete(var14_19.start(), var4_4.length());
                            break;
                        }
                    }
                    if (var7_7.length() > 0) {
                        var3_3.hasExtension = true;
                        var3_3.extension_ = var7_7;
                    }
                    var15_22 = this.getMetadataForRegion(var2_2);
                    var16_23 = new StringBuilder();
                    var17_24 = var15_22;
                    var18_25 = var16_23;
                    try {
                        var21_26 = this.maybeExtractCountryCode((CharSequence)var4_4, var17_24, var18_25, false, var3_3);
                    }
                    catch (NumberParseException var19_27) {
                        var20_28 = PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher((CharSequence)var4_4);
                        if (var19_27.errorType != NumberParseException.ErrorType.INVALID_COUNTRY_CODE) throw new NumberParseException(var19_27.errorType, var19_27.getMessage());
                        if (var20_28.lookingAt() == false) throw new NumberParseException(var19_27.errorType, var19_27.getMessage());
                        var21_26 = this.maybeExtractCountryCode(var4_4.substring(var20_28.end()), var15_22, var16_23, false, var3_3);
                        if (var21_26 == 0) throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                    }
                    if (var21_26 == 0) break block22;
                    var30_29 = (List)this.countryCallingCodeToRegionCodeMap.get((Object)var21_26);
                    var31_30 = var30_29 == null ? "ZZ" : (String)var30_29.get(0);
                    if (var31_30.equals((Object)var2_2)) break block23;
                    if (!"001".equals((Object)var31_30)) break block24;
                    if (!this.countryCallingCodeToRegionCodeMap.containsKey((Object)var21_26)) ** GOTO lbl-1000
                    var32_31 = this.metadataSource;
                    Objects.requireNonNull((Object)var32_31);
                    var34_32 = R.style.getCountryCodeToRegionCodeMap();
                    var35_33 = var21_26;
                    var36_34 = (List)((HashMap)var34_32).get((Object)var35_33);
                    var37_35 = var36_34.size() == 1 && "001".equals(var36_34.get(0)) != false;
                    if (!var37_35) lbl-1000: // 2 sources:
                    {
                        var15_22 = null;
                    } else {
                        var15_22 = MetadataManager.getMetadataFromMultiFilePrefix((int)var21_26, var32_31.nonGeographicalRegions, var32_31.phoneNumberMetadataFilePrefix, var32_31.metadataLoader);
                    }
                    break block23;
                }
                var15_22 = this.getMetadataForRegion(var31_30);
                break block23;
            }
            PhoneNumberUtil.normalize(var4_4);
            var16_23.append((CharSequence)var4_4);
            var3_3.countryCode_ = var15_22.countryCode_;
        }
        if (var16_23.length() < 2) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        if (var15_22 != null) {
            var24_36 = new StringBuilder();
            var25_37 = new StringBuilder((CharSequence)var16_23);
            this.maybeStripNationalPrefixAndCarrierCode(var25_37, var15_22, var24_36);
            var27_38 = this.testNumberLength((CharSequence)var25_37, var15_22, PhoneNumberType.UNKNOWN);
            if (var27_38 != ValidationResult.TOO_SHORT && var27_38 != ValidationResult.IS_POSSIBLE_LOCAL_ONLY && var27_38 != ValidationResult.INVALID_LENGTH) {
                var16_23 = var25_37;
            }
        }
        if ((var28_39 = var16_23.length()) < 2) throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        if (var28_39 > 17) throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
        if (var16_23.length() > 1 && var16_23.charAt(0) == '0') {
            var3_3.hasItalianLeadingZero = true;
            var3_3.italianLeadingZero_ = true;
            for (var29_40 = 1; var29_40 < var16_23.length() - 1 && var16_23.charAt(var29_40) == '0'; ++var29_40) {
            }
            if (var29_40 != 1) {
                var3_3.hasNumberOfLeadingZeros = true;
                var3_3.numberOfLeadingZeros_ = var29_40;
            }
        }
        var3_3.nationalNumber_ = Long.parseLong((String)var16_23.toString());
        return var3_3;
    }

    public final ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = this.getNumberDescByType(phonemetadata$PhoneMetadata, phoneNumberType);
        Object object = phonemetadata$PhoneNumberDesc.possibleLength_.isEmpty() ? phonemetadata$PhoneMetadata.generalDesc_.possibleLength_ : phonemetadata$PhoneNumberDesc.possibleLength_;
        ArrayList arrayList = phonemetadata$PhoneNumberDesc.possibleLengthLocalOnly_;
        if (phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            if (!PhoneNumberUtil.descHasPossibleNumberData(this.getNumberDescByType(phonemetadata$PhoneMetadata, PhoneNumberType.FIXED_LINE))) {
                return this.testNumberLength(charSequence, phonemetadata$PhoneMetadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc2 = this.getNumberDescByType(phonemetadata$PhoneMetadata, PhoneNumberType.MOBILE);
            if (PhoneNumberUtil.descHasPossibleNumberData(phonemetadata$PhoneNumberDesc2)) {
                ArrayList arrayList2 = new ArrayList(object);
                List<Integer> list = phonemetadata$PhoneNumberDesc2.possibleLength_.size() == 0 ? phonemetadata$PhoneMetadata.generalDesc_.possibleLength_ : phonemetadata$PhoneNumberDesc2.possibleLength_;
                arrayList2.addAll(list);
                Collections.sort((List)arrayList2);
                if (arrayList.isEmpty()) {
                    arrayList = phonemetadata$PhoneNumberDesc2.possibleLengthLocalOnly_;
                } else {
                    ArrayList arrayList3 = new ArrayList(arrayList);
                    arrayList3.addAll(phonemetadata$PhoneNumberDesc2.possibleLengthLocalOnly_);
                    Collections.sort((List)arrayList3);
                    arrayList = arrayList3;
                }
                object = arrayList2;
            }
        }
        if ((Integer)object.get(0) == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int n3 = charSequence.length();
        if (arrayList.contains((Object)n3)) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int n4 = (Integer)object.get(0);
        if (n4 == n3) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (n4 > n3) {
            return ValidationResult.TOO_SHORT;
        }
        if ((Integer)object.get(object.size() - 1) < n3) {
            return ValidationResult.TOO_LONG;
        }
        if (object.subList(1, object.size()).contains((Object)n3)) {
            return ValidationResult.IS_POSSIBLE;
        }
        return ValidationResult.INVALID_LENGTH;
    }

    public static final class PhoneNumberType
    extends Enum<PhoneNumberType> {
        private static final /* synthetic */ PhoneNumberType[] $VALUES;
        public static final /* enum */ PhoneNumberType FIXED_LINE;
        public static final /* enum */ PhoneNumberType FIXED_LINE_OR_MOBILE;
        public static final /* enum */ PhoneNumberType MOBILE;
        public static final /* enum */ PhoneNumberType PAGER;
        public static final /* enum */ PhoneNumberType PERSONAL_NUMBER;
        public static final /* enum */ PhoneNumberType PREMIUM_RATE;
        public static final /* enum */ PhoneNumberType SHARED_COST;
        public static final /* enum */ PhoneNumberType TOLL_FREE;
        public static final /* enum */ PhoneNumberType UAN;
        public static final /* enum */ PhoneNumberType UNKNOWN;
        public static final /* enum */ PhoneNumberType VOICEMAIL;
        public static final /* enum */ PhoneNumberType VOIP;

        public static {
            PhoneNumberType phoneNumberType;
            PhoneNumberType phoneNumberType2;
            PhoneNumberType phoneNumberType3;
            PhoneNumberType phoneNumberType4;
            PhoneNumberType phoneNumberType5;
            PhoneNumberType phoneNumberType6;
            PhoneNumberType phoneNumberType7;
            PhoneNumberType phoneNumberType8;
            PhoneNumberType phoneNumberType9;
            PhoneNumberType phoneNumberType10;
            PhoneNumberType phoneNumberType11;
            PhoneNumberType phoneNumberType12;
            FIXED_LINE = phoneNumberType10 = new PhoneNumberType();
            MOBILE = phoneNumberType12 = new PhoneNumberType();
            FIXED_LINE_OR_MOBILE = phoneNumberType6 = new PhoneNumberType();
            TOLL_FREE = phoneNumberType11 = new PhoneNumberType();
            PREMIUM_RATE = phoneNumberType = new PhoneNumberType();
            SHARED_COST = phoneNumberType4 = new PhoneNumberType();
            VOIP = phoneNumberType7 = new PhoneNumberType();
            PERSONAL_NUMBER = phoneNumberType5 = new PhoneNumberType();
            PAGER = phoneNumberType2 = new PhoneNumberType();
            UAN = phoneNumberType9 = new PhoneNumberType();
            VOICEMAIL = phoneNumberType3 = new PhoneNumberType();
            UNKNOWN = phoneNumberType8 = new PhoneNumberType();
            $VALUES = new PhoneNumberType[]{phoneNumberType10, phoneNumberType12, phoneNumberType6, phoneNumberType11, phoneNumberType, phoneNumberType4, phoneNumberType7, phoneNumberType5, phoneNumberType2, phoneNumberType9, phoneNumberType3, phoneNumberType8};
        }

        public static PhoneNumberType valueOf(String string) {
            return (PhoneNumberType)Enum.valueOf(PhoneNumberType.class, (String)string);
        }

        public static PhoneNumberType[] values() {
            return (PhoneNumberType[])$VALUES.clone();
        }
    }

    public static final class ValidationResult
    extends Enum<ValidationResult> {
        private static final /* synthetic */ ValidationResult[] $VALUES;
        public static final /* enum */ ValidationResult INVALID_COUNTRY_CODE;
        public static final /* enum */ ValidationResult INVALID_LENGTH;
        public static final /* enum */ ValidationResult IS_POSSIBLE;
        public static final /* enum */ ValidationResult IS_POSSIBLE_LOCAL_ONLY;
        public static final /* enum */ ValidationResult TOO_LONG;
        public static final /* enum */ ValidationResult TOO_SHORT;

        public static {
            ValidationResult validationResult;
            ValidationResult validationResult2;
            ValidationResult validationResult3;
            ValidationResult validationResult4;
            ValidationResult validationResult5;
            ValidationResult validationResult6;
            IS_POSSIBLE = validationResult6 = new ValidationResult();
            IS_POSSIBLE_LOCAL_ONLY = validationResult = new ValidationResult();
            INVALID_COUNTRY_CODE = validationResult4 = new ValidationResult();
            TOO_SHORT = validationResult5 = new ValidationResult();
            INVALID_LENGTH = validationResult3 = new ValidationResult();
            TOO_LONG = validationResult2 = new ValidationResult();
            $VALUES = new ValidationResult[]{validationResult6, validationResult, validationResult4, validationResult5, validationResult3, validationResult2};
        }

        public static ValidationResult valueOf(String string) {
            return (ValidationResult)Enum.valueOf(ValidationResult.class, (String)string);
        }

        public static ValidationResult[] values() {
            return (ValidationResult[])$VALUES.clone();
        }
    }

}

