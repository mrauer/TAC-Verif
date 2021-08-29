/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.preference.PreferenceManager
 *  android.util.Log
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod$itemType
 *  com.ingroupe.verify.anticovid.common.model.StatsPeriod$Companion$getStatsPeriod$itemType$1
 *  com.ingroupe.verify.anticovid.service.document.DatamatrixService
 *  com.ingroupe.verify.anticovid.service.document.model.DocumentStatic2ddocResult
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList$itemType
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList$itemType$1
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$reportVerifEvent
 *  com.ingroupe.verify.anticovid.synchronization.elements.Analytics$reportVerifEvent$1
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Objects
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt__IndentKt
 *  kotlinx.coroutines.CoroutineDispatcher
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  org.bouncycastle.util.encoders.Hex
 */
package com.ingroupe.verify.anticovid.service.document;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.common.Constants$GlobalValidity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.Constants$SpecificList;
import com.ingroupe.verify.anticovid.common.Constants$SpecificValues;
import com.ingroupe.verify.anticovid.common.model.StatsDay;
import com.ingroupe.verify.anticovid.common.model.StatsPeriod;
import com.ingroupe.verify.anticovid.service.barcode.Barcode2DDocService;
import com.ingroupe.verify.anticovid.service.document.DatamatrixService;
import com.ingroupe.verify.anticovid.service.document.StaticDataService;
import com.ingroupe.verify.anticovid.service.document.database.DocumentLoader;
import com.ingroupe.verify.anticovid.service.document.database.entity.ConfigBarcode2DDoc;
import com.ingroupe.verify.anticovid.service.document.enums.ErrorDocEnum;
import com.ingroupe.verify.anticovid.service.document.model.DocumentDataResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentErrorsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentFieldResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentSignatureResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStatic2ddocResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticFieldsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import com.ingroupe.verify.anticovid.synchronization.elements.Analytics;
import com.ingroupe.verify.anticovid.synchronization.elements.Blacklist;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.Period;
import j$.time.format.DateTimeFormatter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.util.encoders.Hex;

public abstract class DocOfflineService {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final DocumentResult getDocumentBy2DDoc(String var0, Context var1_1) {
        block88 : {
            block72 : {
                block76 : {
                    block86 : {
                        block77 : {
                            block87 : {
                                block78 : {
                                    block85 : {
                                        block81 : {
                                            block83 : {
                                                block84 : {
                                                    block82 : {
                                                        block80 : {
                                                            block79 : {
                                                                block75 : {
                                                                    block74 : {
                                                                        block73 : {
                                                                            block56 : {
                                                                                block65 : {
                                                                                    block71 : {
                                                                                        block63 : {
                                                                                            block70 : {
                                                                                                block69 : {
                                                                                                    block66 : {
                                                                                                        block68 : {
                                                                                                            block67 : {
                                                                                                                block64 : {
                                                                                                                    block58 : {
                                                                                                                        block62 : {
                                                                                                                            block61 : {
                                                                                                                                block60 : {
                                                                                                                                    block59 : {
                                                                                                                                        block57 : {
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var0, (String)"encoded2DDoc");
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                                            var2_2 = new ArrayList();
                                                                                                                                            var3_3 = new ArrayList();
                                                                                                                                            var4_4 = new LinkedHashMap();
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var0, (String)"encoded2DDoc");
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                                            try {
                                                                                                                                                var196_5 = Barcode2DDocService.getBarcode2DDoc(var0, var1_1);
                                                                                                                                                var197_6 = var196_5.getHeader();
                                                                                                                                                var198_7 = var197_6 == null ? null : var197_6.getFields();
                                                                                                                                                if (var198_7 != null && (var200_9 = (var199_8 = var196_5.getMessage()) == null ? null : var199_8.type) != null && (var202_11 = (var201_10 = var196_5.getMessage()) == null ? null : var201_10.label) != null) {
                                                                                                                                                    var203_12 = var196_5.getMessage();
                                                                                                                                                    var204_13 = var203_12 == null ? null : var203_12.getFields();
                                                                                                                                                }
                                                                                                                                                ** GOTO lbl-1000
                                                                                                                                            }
                                                                                                                                            catch (Exception var5_27) {
                                                                                                                                                Log.e((String)"StaticDataService", (String)ErrorDocEnum.ERR02.getMessage(), (Throwable)var5_27);
                                                                                                                                                ** GOTO lbl-1000
                                                                                                                                            }
                                                                                                                                            if (var204_13 != null) {
                                                                                                                                                var205_14 = true;
                                                                                                                                            } else lbl-1000: // 2 sources:
                                                                                                                                            {
                                                                                                                                                var205_14 = false;
                                                                                                                                            }
                                                                                                                                            if (var205_14) {
                                                                                                                                                var206_15 = new DocumentFieldResult(null, null, null, 7);
                                                                                                                                                var206_15.setName("00");
                                                                                                                                                var206_15.setLabel("Type de document");
                                                                                                                                                var207_16 = var196_5.getMessage();
                                                                                                                                                Intrinsics.checkNotNull((Object)var207_16);
                                                                                                                                                var206_15.setValue(var207_16.label);
                                                                                                                                                var208_17 = var196_5.getHeader();
                                                                                                                                                Intrinsics.checkNotNull((Object)var208_17);
                                                                                                                                                var209_18 = var208_17.getFields();
                                                                                                                                                if (var209_18 != null) {
                                                                                                                                                    var209_18.add(0, (Object)var206_15);
                                                                                                                                                }
                                                                                                                                                var210_19 = var196_5.getHeader();
                                                                                                                                                if (var210_19 != null) {
                                                                                                                                                    var211_20 = new ArrayList();
                                                                                                                                                    var212_21 = var210_19.getFields();
                                                                                                                                                    if (var212_21 != null) {
                                                                                                                                                        for (DocumentFieldResult var216_23 : var212_21) {
                                                                                                                                                            if (R.style.contains((Object[])StaticDataService.headersUsed, (Object)var216_23.getName())) continue;
                                                                                                                                                            var211_20.add((Object)var216_23);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    var210_19.setFields((ArrayList<DocumentFieldResult>)var211_20);
                                                                                                                                                }
                                                                                                                                                var214_24 = new DocumentSignatureResult(null, null, 3);
                                                                                                                                                var214_24.setValid(var196_5.hasValidSignature);
                                                                                                                                                var215_25 = var196_5.hasValidSignature != false ? 2131820797 : 2131820772;
                                                                                                                                                var214_24.setStatus(var1_1.getString(var215_25));
                                                                                                                                                var196_5.setSignature(var214_24);
                                                                                                                                                var7_26 = var196_5;
                                                                                                                                            } else lbl-1000: // 2 sources:
                                                                                                                                            {
                                                                                                                                                var7_26 = null;
                                                                                                                                            }
                                                                                                                                            var8_28 = var7_26 == null ? null : ((var195_29 = var7_26.getMessage()) == null ? null : var195_29.type);
                                                                                                                                            if (!Intrinsics.areEqual(var8_28, (Object)"B2")) break block56;
                                                                                                                                            Intrinsics.checkNotNullParameter(var7_26, (String)"static2ddoc");
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var4_4, (String)"mappedDynamicData");
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                                            var104_30 = ((Activity)var1_1).getPreferences(0);
                                                                                                                                            var105_31 = var104_30 == null ? null : var104_30.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                                                                                                                                            var106_32 = var105_31 != null;
                                                                                                                                            if (var7_26.hasValidSignature) break block57;
                                                                                                                                            var128_33 = Constants$GlobalValidity.KO.getText();
                                                                                                                                            var129_34 = var1_1.getString(2131820660);
                                                                                                                                            Intrinsics.checkNotNullExpressionValue((Object)var129_34, (String)"context.getString(R.string.invalid_2ddoc_signature)");
                                                                                                                                            var9_35 = var7_26;
                                                                                                                                            break block58;
                                                                                                                                        }
                                                                                                                                        var107_61 = var7_26.getMessage();
                                                                                                                                        var108_62 = var107_61 == null ? null : var107_61.getFields();
                                                                                                                                        var109_63 = DatamatrixService.getField(var108_62, (String)"F4");
                                                                                                                                        var110_64 = var7_26.getMessage();
                                                                                                                                        var111_65 = var110_64 == null ? null : var110_64.getFields();
                                                                                                                                        var112_66 = DatamatrixService.getField(var111_65, (String)"F5");
                                                                                                                                        var113_67 = var7_26.getMessage();
                                                                                                                                        var114_68 = var113_67 == null ? null : var113_67.getFields();
                                                                                                                                        var9_35 = var7_26;
                                                                                                                                        var115_69 = DatamatrixService.getField(var114_68, (String)"F6");
                                                                                                                                        var116_70 = var106_32;
                                                                                                                                        if (var109_63 == null) break block59;
                                                                                                                                        var118_72 = "context.packageName";
                                                                                                                                        var186_54 = Constants$SpecificList.TEST_PCR;
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)"F4", (String)"field");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var109_63, (String)"value");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var186_54, (String)"slEnum");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var4_4, (String)"mappedDynamicData");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var186_54, (String)"svEnum");
                                                                                                                                        Intrinsics.checkNotNullParameter((Object)var109_63, (String)"key");
                                                                                                                                        var119_73 = var112_66;
                                                                                                                                        var187_55 = PreferenceManager.getDefaultSharedPreferences((Context)var1_1);
                                                                                                                                        Intrinsics.checkExpressionValueIsNotNull((Object)var187_55, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
                                                                                                                                        var188_56 = var187_55.getString(var186_54.getText(), "{}");
                                                                                                                                        var189_57 = new Gson();
                                                                                                                                        var117_71 = "{}";
                                                                                                                                        var190_58 = var189_57.fromJson(var188_56, new SynchronisationUtils.getSpecificList.itemType.1().type);
                                                                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var190_58, (String)"gson.fromJson(jsonMap, itemType)");
                                                                                                                                        var191_59 = (String)((Map)var190_58).get((Object)var109_63);
                                                                                                                                        if (var191_59 != null) {
                                                                                                                                            var4_4.put((Object)"F4", (Object)var191_59);
                                                                                                                                            var193_60 = true;
                                                                                                                                        } else {
                                                                                                                                            var4_4.put((Object)"F4", (Object)var109_63);
                                                                                                                                            var193_60 = false;
                                                                                                                                        }
                                                                                                                                        if (!var193_60) break block60;
                                                                                                                                        var120_74 = true;
                                                                                                                                        break block61;
                                                                                                                                    }
                                                                                                                                    var117_71 = "{}";
                                                                                                                                    var118_72 = "context.packageName";
                                                                                                                                    var119_73 = var112_66;
                                                                                                                                }
                                                                                                                                var120_74 = false;
                                                                                                                            }
                                                                                                                            if (var109_63 == null) ** GOTO lbl-1000
                                                                                                                            var178_48 = Constants$SpecificList.TEST_ANTIGENIC;
                                                                                                                            Intrinsics.checkNotNullParameter((Object)"F4", (String)"field");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var109_63, (String)"value");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var178_48, (String)"slEnum");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var4_4, (String)"mappedDynamicData");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var178_48, (String)"svEnum");
                                                                                                                            Intrinsics.checkNotNullParameter((Object)var109_63, (String)"key");
                                                                                                                            var179_49 = PreferenceManager.getDefaultSharedPreferences((Context)var1_1);
                                                                                                                            Intrinsics.checkExpressionValueIsNotNull((Object)var179_49, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
                                                                                                                            var180_50 = var179_49.getString(var178_48.getText(), var117_71);
                                                                                                                            var181_51 = new Gson().fromJson(var180_50, new SynchronisationUtils.getSpecificList.itemType.1().type);
                                                                                                                            Intrinsics.checkNotNullExpressionValue((Object)var181_51, (String)"gson.fromJson(jsonMap, itemType)");
                                                                                                                            var182_52 = (String)((Map)var181_51).get((Object)var109_63);
                                                                                                                            if (var182_52 != null) {
                                                                                                                                var4_4.put((Object)"F4", (Object)var182_52);
                                                                                                                                var184_53 = true;
                                                                                                                            } else {
                                                                                                                                var4_4.put((Object)"F4", (Object)var109_63);
                                                                                                                                var184_53 = false;
                                                                                                                            }
                                                                                                                            if (var184_53) {
                                                                                                                                var121_75 = true;
                                                                                                                            } else lbl-1000: // 2 sources:
                                                                                                                            {
                                                                                                                                var121_75 = false;
                                                                                                                            }
                                                                                                                            var122_76 = var119_73;
                                                                                                                            var123_77 = Intrinsics.stringPlus((String)"@string/dynamic_B2F5.", (Object)var122_76);
                                                                                                                            var124_78 = var1_1.getPackageName();
                                                                                                                            Intrinsics.checkNotNullExpressionValue((Object)var124_78, (String)var118_72);
                                                                                                                            var125_79 = var1_1.getResources().getIdentifier(var123_77, "string", var124_78);
                                                                                                                            if (var125_79 != 0) {
                                                                                                                                var176_47 = var1_1.getString(var125_79);
                                                                                                                                Intrinsics.checkNotNullExpressionValue((Object)var176_47, (String)"context.getString(resId)");
                                                                                                                                var4_4.put((Object)"F5", (Object)var176_47);
                                                                                                                            }
                                                                                                                            if (!var116_70) break block62;
                                                                                                                            if (var109_63 != null && var122_76 != null && var115_69 != null) {
                                                                                                                                if (!var120_74 && !var121_75) {
                                                                                                                                    var164_36 = Constants$GlobalValidity.KO.getText();
                                                                                                                                    var165_37 = var1_1.getString(2131820789);
                                                                                                                                    Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"context.getString(R.string.result_test_type_not_valid)");
                                                                                                                                } else if (Intrinsics.areEqual((Object)var122_76, (Object)"X")) {
                                                                                                                                    var164_36 = Constants$GlobalValidity.KO.getText();
                                                                                                                                    var165_37 = var1_1.getString(2131820601);
                                                                                                                                    Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"context.getString(R.string.dynamic_B2F5_X)");
                                                                                                                                } else if (Intrinsics.areEqual((Object)var122_76, (Object)"I")) {
                                                                                                                                    var164_36 = Constants$GlobalValidity.KO.getText();
                                                                                                                                    var165_37 = var1_1.getString(2131820598);
                                                                                                                                    Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"context.getString(R.string.dynamic_B2F5_I)");
                                                                                                                                } else if (var121_75) {
                                                                                                                                    if (Intrinsics.areEqual((Object)var122_76, (Object)"N")) {
                                                                                                                                        var164_36 = Constants$GlobalValidity.INFO.getText();
                                                                                                                                        var165_37 = var1_1.getString(2131820780);
                                                                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"context.getString(R.string.result_test_antigenic_negative_info)");
                                                                                                                                    } else {
                                                                                                                                        var164_36 = Constants$GlobalValidity.INFO.getText();
                                                                                                                                        var165_37 = var1_1.getString(2131820782);
                                                                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"context.getString(R.string.result_test_antigenic_positive_info)");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    var164_36 = Constants$GlobalValidity.INFO.getText();
                                                                                                                                    if (Intrinsics.areEqual((Object)var122_76, (Object)"N")) {
                                                                                                                                        var165_37 = var1_1.getString(2131820787);
                                                                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"{\n                                    context.getString(R.string.result_test_pcr_negative_info)\n                                }");
                                                                                                                                    } else {
                                                                                                                                        var165_37 = var1_1.getString(2131820788);
                                                                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"{\n                                    context.getString(R.string.result_test_pcr_positive_info)\n                                }");
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                var164_36 = Constants$GlobalValidity.KO.getText();
                                                                                                                                var165_37 = var1_1.getString(2131820660);
                                                                                                                                Intrinsics.checkNotNullExpressionValue((Object)var165_37, (String)"context.getString(R.string.invalid_2ddoc_signature)");
                                                                                                                            }
                                                                                                                            var166_38 = var165_37;
                                                                                                                            var128_33 = var164_36;
                                                                                                                            if (var115_69 != null) {
                                                                                                                                var167_39 = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).parse(var115_69);
                                                                                                                                var168_40 = new Date();
                                                                                                                                if (var167_39 != null) {
                                                                                                                                    var169_41 = (int)((var168_40.getTime() - var167_39.getTime()) / (long)60000);
                                                                                                                                    var170_42 = var169_41 / 60;
                                                                                                                                    var171_43 = var169_41 % 60;
                                                                                                                                    if (var170_42 <= 96) {
                                                                                                                                        var175_46 = new Object[]{var170_42, var171_43};
                                                                                                                                        var173_45 = var1_1.getString(2131820770, var175_46);
                                                                                                                                    } else {
                                                                                                                                        var172_44 = new Object[]{var170_42 / 24, var170_42 % 24};
                                                                                                                                        var173_45 = var1_1.getString(2131820769, var172_44);
                                                                                                                                    }
                                                                                                                                    Intrinsics.checkNotNullExpressionValue((Object)var173_45, (String)"if(hours <= 96) {\n                                    context.getString(R.string.result_duration_hours_minutes, hours, minutes)\n                                } else {\n                                    context.getString(R.string.result_duration_days_hours, hours/24, hours%24)\n                                }");
                                                                                                                                    var4_4.put((Object)"samplingDuration", (Object)var173_45);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            var129_34 = var166_38;
                                                                                                                            break block58;
                                                                                                                        }
                                                                                                                        if (var109_63 == null || var122_76 == null || var115_69 == null) break block63;
                                                                                                                        if (var120_74 || var121_75) break block64;
                                                                                                                        var128_33 = Constants$GlobalValidity.KO.getText();
                                                                                                                        var129_34 = var1_1.getString(2131820772);
                                                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var129_34, (String)"context.getString(R.string.result_invalid)");
                                                                                                                    }
                                                                                                                    var127_80 = "validityStatus";
                                                                                                                    var130_81 = "validityGlobal";
                                                                                                                    break block65;
                                                                                                                }
                                                                                                                var133_82 = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH).parse(var115_69);
                                                                                                                var134_83 = new Date();
                                                                                                                if (!Intrinsics.areEqual((Object)var122_76, (Object)"N")) break block66;
                                                                                                                if (!var120_74) break block67;
                                                                                                                var159_84 = var134_83.getTime();
                                                                                                                Intrinsics.checkNotNull((Object)var133_82);
                                                                                                                var161_85 = var159_84 - var133_82.getTime();
                                                                                                                var163_86 = Constants$SpecificValues.TEST_NEGATIVE_PCR_END_HOUR;
                                                                                                                var127_80 = "validityStatus";
                                                                                                                var137_87 = "PreferenceManager.getDef\u2026ltSharedPreferences(this)";
                                                                                                                var135_88 = "svEnum";
                                                                                                                var136_89 = "context.getString(R.string.result_invalid)";
                                                                                                                var126_90 = var4_4;
                                                                                                                if (var161_85 <= 3600000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var163_86, (String)"svEnum", (Context)var1_1, (String)"context", (Constants$SpecificValues)var163_86, (String)"svEnum", (Context)var1_1, (String)var137_87).getInt(var163_86.getText(), var163_86.getDefault())) ** GOTO lbl-1000
                                                                                                                break block68;
                                                                                                            }
                                                                                                            var135_88 = "svEnum";
                                                                                                            var136_89 = "context.getString(R.string.result_invalid)";
                                                                                                            var126_90 = var4_4;
                                                                                                            var127_80 = "validityStatus";
                                                                                                            var137_87 = "PreferenceManager.getDef\u2026ltSharedPreferences(this)";
                                                                                                        }
                                                                                                        if (!var121_75) break block69;
                                                                                                        var154_91 = var134_83.getTime();
                                                                                                        Intrinsics.checkNotNull((Object)var133_82);
                                                                                                        var156_92 = var154_91 - var133_82.getTime();
                                                                                                        var158_93 = Constants$SpecificValues.TEST_NEGATIVE_ANTIGENIC_END_HOUR;
                                                                                                        if (var156_92 <= 3600000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var158_93, (String)var135_88, (Context)var1_1, (String)"context", (Constants$SpecificValues)var158_93, (String)var135_88, (Context)var1_1, (String)var137_87).getInt(var158_93.getText(), var158_93.getDefault())) ** GOTO lbl-1000
                                                                                                        break block69;
                                                                                                    }
                                                                                                    var135_88 = "svEnum";
                                                                                                    var136_89 = "context.getString(R.string.result_invalid)";
                                                                                                    var126_90 = var4_4;
                                                                                                    var127_80 = "validityStatus";
                                                                                                    var137_87 = "PreferenceManager.getDef\u2026ltSharedPreferences(this)";
                                                                                                }
                                                                                                if (!Intrinsics.areEqual((Object)var122_76, (Object)"P")) ** GOTO lbl-1000
                                                                                                if (!var120_74) break block70;
                                                                                                var146_94 = var134_83.getTime();
                                                                                                Intrinsics.checkNotNull((Object)var133_82);
                                                                                                var148_95 = var146_94 - var133_82.getTime();
                                                                                                var150_96 = Constants$SpecificValues.TEST_POSITIVE_PCR_START_DAY;
                                                                                                if (var148_95 >= 86400000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var150_96, (String)var135_88, (Context)var1_1, (String)"context", (Constants$SpecificValues)var150_96, (String)var135_88, (Context)var1_1, (String)var137_87).getInt(var150_96.getText(), var150_96.getDefault()) && (var151_97 = var134_83.getTime() - var133_82.getTime()) < 86400000L * (long)(1 + GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)(var153_98 = Constants$SpecificValues.TEST_POSITIVE_PCR_END_DAY), (String)var135_88, (Context)var1_1, (String)"context", (Constants$SpecificValues)var153_98, (String)var135_88, (Context)var1_1, (String)var137_87).getInt(var153_98.getText(), var153_98.getDefault()))) ** GOTO lbl-1000
                                                                                            }
                                                                                            if (var121_75) {
                                                                                                var138_99 = var134_83.getTime();
                                                                                                Intrinsics.checkNotNull((Object)var133_82);
                                                                                                var140_100 = var138_99 - var133_82.getTime();
                                                                                                var142_101 = Constants$SpecificValues.TEST_POSITIVE_ANTIGENIC_START_DAY;
                                                                                                ** if (var140_100 < 86400000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var142_101, (String)var135_88, (Context)var1_1, (String)"context", (Constants$SpecificValues)var142_101, (String)var135_88, (Context)var1_1, (String)var137_87).getInt((String)var142_101.getText(), (int)var142_101.getDefault()) || (var143_102 = var134_83.getTime() - var133_82.getTime()) >= 86400000L * (long)(1 + GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)(var145_103 = Constants$SpecificValues.TEST_POSITIVE_ANTIGENIC_END_DAY), (String)var135_88, (Context)var1_1, (String)"context", (Constants$SpecificValues)var145_103, (String)var135_88, (Context)var1_1, (String)var137_87).getInt((String)var145_103.getText(), (int)var145_103.getDefault()))) goto lbl-1000
                                                                                            }
                                                                                            ** GOTO lbl-1000
lbl-1000: // 4 sources:
                                                                                            {
                                                                                                var128_33 = Constants$GlobalValidity.OK.getText();
                                                                                                var129_34 = var1_1.getString(2131820797);
                                                                                                Intrinsics.checkNotNullExpressionValue((Object)var129_34, (String)"context.getString(R.string.result_valid)");
                                                                                                ** GOTO lbl285
                                                                                            }
lbl-1000: // 3 sources:
                                                                                            {
                                                                                                var128_33 = Constants$GlobalValidity.KO.getText();
                                                                                                var129_34 = var1_1.getString(2131820772);
                                                                                                Intrinsics.checkNotNullExpressionValue((Object)var129_34, (String)var136_89);
                                                                                            }
                                                                                            break block71;
                                                                                        }
                                                                                        var126_90 = var4_4;
                                                                                        var127_80 = "validityStatus";
                                                                                        var128_33 = Constants$GlobalValidity.KO.getText();
                                                                                        var129_34 = var1_1.getString(2131820772);
                                                                                        Intrinsics.checkNotNullExpressionValue((Object)var129_34, (String)"context.getString(R.string.result_invalid)");
                                                                                    }
                                                                                    var130_81 = "validityGlobal";
                                                                                    var4_4 = var126_90;
                                                                                }
                                                                                var4_4.put((Object)var130_81, (Object)var128_33);
                                                                                var4_4.put((Object)var127_80, (Object)var129_34);
                                                                                break block72;
                                                                            }
                                                                            var9_35 = var7_26;
                                                                            if (!Intrinsics.areEqual((Object)var8_28, (Object)"L1")) break block72;
                                                                            var42_104 = var9_35;
                                                                            Intrinsics.checkNotNullParameter(var42_104, (String)"static2ddoc");
                                                                            Intrinsics.checkNotNullParameter((Object)var4_4, (String)"mappedDynamicData");
                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"context");
                                                                            var43_105 = ((Activity)var1_1).getPreferences(0);
                                                                            var44_106 = var43_105 == null ? null : var43_105.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                                                                            var45_107 = var44_106 != null;
                                                                            if (var42_104.hasValidSignature) break block73;
                                                                            var65_108 = Constants$GlobalValidity.KO.getText();
                                                                            var66_109 = var1_1.getString(2131820660);
                                                                            Intrinsics.checkNotNullExpressionValue((Object)var66_109, (String)"context.getString(R.string.invalid_2ddoc_signature)");
                                                                            var50_110 = "validityStatus";
                                                                            break block74;
                                                                        }
                                                                        var46_111 = var42_104.getMessage();
                                                                        var47_112 = var46_111 == null ? null : var46_111.getFields();
                                                                        var48_113 = DatamatrixService.getField(var47_112, (String)"LA");
                                                                        var49_114 = Intrinsics.stringPlus((String)"@string/dynamic_L1LA.", (Object)var48_113);
                                                                        var50_110 = "validityStatus";
                                                                        var51_115 = var1_1.getPackageName();
                                                                        Intrinsics.checkNotNullExpressionValue((Object)var51_115, (String)"context.packageName");
                                                                        var52_116 = var1_1.getResources().getIdentifier(var49_114, "string", var51_115);
                                                                        if (var52_116 != 0) {
                                                                            var102_117 = var1_1.getString(var52_116);
                                                                            Intrinsics.checkNotNullExpressionValue((Object)var102_117, (String)"context.getString(resId)");
                                                                            var4_4.put((Object)"LA", (Object)var102_117);
                                                                        }
                                                                        var54_119 = (var53_118 = var42_104.getMessage()) == null ? null : var53_118.getFields();
                                                                        var55_120 = DatamatrixService.getField(var54_119, (String)"L9");
                                                                        if (!var45_107) break block75;
                                                                        if (Intrinsics.areEqual((Object)var48_113, (Object)"TE")) {
                                                                            var65_108 = Constants$GlobalValidity.INFO.getText();
                                                                            var66_109 = var1_1.getString(2131820795);
                                                                            Intrinsics.checkNotNullExpressionValue((Object)var66_109, (String)"context.getString(R.string.result_vaccine_cycle_completed_info)");
                                                                        } else {
                                                                            var65_108 = Constants$GlobalValidity.KO.getText();
                                                                            var66_109 = var1_1.getString(2131820796);
                                                                            Intrinsics.checkNotNullExpressionValue((Object)var66_109, (String)"context.getString(R.string.result_vaccine_cycle_improper)");
                                                                        }
                                                                        var96_121 = Period.between(LocalDate.parse(var55_120, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now());
                                                                        var97_122 = var96_121.getMonths() + 12 * var96_121.getYears();
                                                                        if (var97_122 > 0) {
                                                                            var101_123 = new Object[]{var97_122, var96_121.getDays()};
                                                                            var99_124 = var1_1.getString(2131820771, var101_123);
                                                                        } else {
                                                                            var98_125 = new Object[]{var96_121.getDays()};
                                                                            var99_124 = var1_1.getString(2131820768, var98_125);
                                                                        }
                                                                        Intrinsics.checkNotNullExpressionValue((Object)var99_124, (String)"if(months > 0) {\n                            context.getString(R.string.result_duration_months_days, months, period.days)\n                    } else {\n                            context.getString(R.string.result_duration_days, period.days)\n                    }");
                                                                        var4_4.put((Object)"vaccinationDuration", (Object)var99_124);
                                                                    }
                                                                    var13_126 = true;
                                                                    var12_127 = var42_104;
                                                                    var67_128 = "validityGlobal";
                                                                    var10_129 = var4_4;
                                                                    var11_130 = var1_1;
                                                                    var64_131 = var50_110;
                                                                    break block76;
                                                                }
                                                                var56_132 = var42_104.getMessage();
                                                                var57_133 = var56_132 == null ? null : var56_132.getFields();
                                                                var58_134 = DatamatrixService.getField(var57_133, (String)"L5");
                                                                var59_135 = var42_104.getMessage();
                                                                var60_136 = var59_135 == null ? null : var59_135.getFields();
                                                                var61_137 = DatamatrixService.getField(var60_136, (String)"L8");
                                                                if (var58_134 == null || var61_137 == null || var55_120 == null || var48_113 == null) break block77;
                                                                var70_138 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(var55_120);
                                                                var71_139 = new Date();
                                                                var72_140 = Integer.parseInt((String)var61_137);
                                                                if (!Intrinsics.areEqual((Object)var48_113, (Object)"TE")) break block78;
                                                                if (var72_140 != 1) break block79;
                                                                var90_141 = var58_134.toUpperCase(Locale.ROOT);
                                                                Intrinsics.checkNotNullExpressionValue((Object)var90_141, (String)"(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)");
                                                                if (!StringsKt__IndentKt.contains$default((CharSequence)var90_141, (CharSequence)"JANSSEN", (boolean)false, (int)2)) break block79;
                                                                var91_142 = var71_139.getTime();
                                                                Intrinsics.checkNotNull((Object)var70_138);
                                                                var93_143 = var91_142 - var70_138.getTime();
                                                                var95_144 = Constants$SpecificValues.VACCINE_DELAY_JANSSEN;
                                                                var73_145 = "context.getString(R.string.result_invalid)";
                                                                var77_146 = "(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)";
                                                                var74_147 = "context.getString(R.string.result_valid)";
                                                                var75_148 = "JANSSEN";
                                                                var12_127 = var42_104;
                                                                var76_149 = var72_140;
                                                                var64_131 = var50_110;
                                                                var62_150 = "validityGlobal";
                                                                var63_151 = var4_4;
                                                                if (var93_143 <= 86400000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var95_144, (String)"svEnum", (Context)var1_1, (String)"context", (Constants$SpecificValues)var95_144, (String)"svEnum", (Context)var1_1, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)").getInt(var95_144.getText(), var95_144.getDefault())) break block80;
                                                                var13_126 = true;
                                                                break block81;
                                                            }
                                                            var74_147 = "context.getString(R.string.result_valid)";
                                                            var75_148 = "JANSSEN";
                                                            var12_127 = var42_104;
                                                            var76_149 = var72_140;
                                                            var62_150 = "validityGlobal";
                                                            var63_151 = var4_4;
                                                            var73_145 = "context.getString(R.string.result_invalid)";
                                                            var64_131 = var50_110;
                                                            var77_146 = "(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)";
                                                        }
                                                        if (var76_149 != 1) break block82;
                                                        var84_152 = var58_134.toUpperCase(Locale.ROOT);
                                                        Intrinsics.checkNotNullExpressionValue((Object)var84_152, (String)var77_146);
                                                        if (StringsKt__IndentKt.contains$default((CharSequence)var84_152, (CharSequence)var75_148, (boolean)false, (int)2)) break block82;
                                                        var85_153 = var71_139.getTime();
                                                        Intrinsics.checkNotNull((Object)var70_138);
                                                        var87_154 = var85_153 - var70_138.getTime();
                                                        var89_155 = Constants$SpecificValues.VACCINE_DELAY;
                                                        var78_156 = true;
                                                        if (var87_154 > 86400000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var89_155, (String)"svEnum", (Context)var1_1, (String)"context", (Constants$SpecificValues)var89_155, (String)"svEnum", (Context)var1_1, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)").getInt(var89_155.getText(), var89_155.getDefault())) break block83;
                                                        break block84;
                                                    }
                                                    var78_156 = true;
                                                }
                                                if (var76_149 < 2) break block85;
                                                var79_157 = var71_139.getTime();
                                                Intrinsics.checkNotNull((Object)var70_138);
                                                var81_158 = var79_157 - var70_138.getTime();
                                                var83_159 = Constants$SpecificValues.VACCINE_DELAY;
                                                if (var81_158 <= 86400000L * (long)GeneratedOutlineSupport.outline5((Context)var1_1, (String)"context", (Constants$SpecificValues)var83_159, (String)"svEnum", (Context)var1_1, (String)"context", (Constants$SpecificValues)var83_159, (String)"svEnum", (Context)var1_1, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)").getInt(var83_159.getText(), var83_159.getDefault())) break block85;
                                            }
                                            var13_126 = var78_156;
                                        }
                                        var65_108 = Constants$GlobalValidity.OK.getText();
                                        var11_130 = var1_1;
                                        var66_109 = var11_130.getString(2131820797);
                                        Intrinsics.checkNotNullExpressionValue((Object)var66_109, (String)var74_147);
                                        break block86;
                                    }
                                    var11_130 = var1_1;
                                    var13_126 = var78_156;
                                    break block87;
                                }
                                var12_127 = var42_104;
                                var62_150 = "validityGlobal";
                                var63_151 = var4_4;
                                var11_130 = var1_1;
                                var73_145 = "context.getString(R.string.result_invalid)";
                                var64_131 = var50_110;
                                var13_126 = true;
                            }
                            var65_108 = Constants$GlobalValidity.KO.getText();
                            var66_109 = var11_130.getString(2131820772);
                            Intrinsics.checkNotNullExpressionValue((Object)var66_109, (String)var73_145);
                            break block86;
                        }
                        var12_127 = var42_104;
                        var62_150 = "validityGlobal";
                        var63_151 = var4_4;
                        var11_130 = var1_1;
                        var64_131 = var50_110;
                        var13_126 = true;
                        var65_108 = Constants$GlobalValidity.KO.getText();
                        var66_109 = var11_130.getString(2131820660);
                        Intrinsics.checkNotNullExpressionValue((Object)var66_109, (String)"context.getString(R.string.invalid_2ddoc_signature)");
                    }
                    var67_128 = var62_150;
                    var10_129 = var63_151;
                }
                var10_129.put((Object)var67_128, (Object)var65_108);
                var10_129.put((Object)var64_131, (Object)var66_109);
                break block88;
            }
            var10_129 = var4_4;
            var11_130 = var1_1;
            var12_127 = var9_35;
            var13_126 = true;
        }
        var14_160 = var12_127;
        var16_162 = var14_160 == null || (var15_161 = var14_160.getMessage()) == null ? null : var15_161.type;
        if (var16_162 == null || (var17_163 = DocumentLoader.configBarcode2DDoc) == null) {
            var20_164 = null;
        } else {
            block55 : {
                for (Object var19_167 : var17_163) {
                    if (!Intrinsics.areEqual((Object)((ConfigBarcode2DDoc)var19_167).getDocumentTypeCode(), (Object)var16_162)) continue;
                    break block55;
                }
                var19_167 = null;
            }
            var20_164 = (ConfigBarcode2DDoc)var19_167;
        }
        var21_165 = var20_164;
        var2_2.add((Object)var10_129);
        var23_168 = (String)ArraysKt___ArraysJvmKt.getOrNull((List)StringsKt__IndentKt.split$default((CharSequence)var0, (String[])new String[]{"\u001f"}, (boolean)false, (int)0, (int)6), (int)0);
        var24_169 = "";
        var25_170 = var23_168 == null ? var24_169 : DocOfflineService.toSha256(var23_168);
        var27_171 = Blacklist.isBlacklisted(var11_130, Blacklist.BlacklistType.BLACKLIST_2DDOC, var25_170);
        var28_172 = Blacklist.isHashDuplicate(var25_170, var11_130);
        if (var27_171) {
            Intrinsics.checkNotNullParameter((Object)var11_130, (String)"context");
            var37_173 = ((Activity)var11_130).getPreferences(0);
            var38_174 = var37_173 == null ? null : var37_173.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
            var39_175 = var38_174 != null ? var13_126 : false;
            if (var39_175) {
                var10_129.put((Object)"blacklist", (Object)Blacklist.Message.BLACKLIST_OT.name());
            } else {
                var10_129.put((Object)"blacklist", (Object)Blacklist.Message.BLACKLIST_LITE.name());
            }
        } else if (var28_172) {
            var10_129.put((Object)"duplicate", (Object)Blacklist.Message.DUPLICATE.name());
        }
        Intrinsics.checkNotNullParameter((Object)var11_130, (String)"context");
        var29_176 = ((Activity)var11_130).getPreferences(0);
        var30_177 = var29_176 == null ? null : var29_176.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
        if (var30_177 == null) {
            var13_126 = false;
        }
        var31_178 = var13_126 != false ? "TACV_2DDOC_ANDROID_OT" : "TACV_2DDOC_ANDROID_LITE";
        var32_179 = var31_178;
        if (var21_165 != null && (var33_180 = var21_165.getResourceType()) != null) {
            var24_169 = var33_180;
        }
        DocOfflineService.writeStat(var1_1, (Map<String, String>)var10_129, var24_169, var32_179, "", var27_171, var28_172);
        var34_181 = new DocumentDataResult((DocumentStaticResult)var14_160, (ArrayList<Map<String, String>>)var2_2);
        if (var21_165 == null) {
            var35_182 = null;
            return new DocumentResult(var34_181, (ArrayList<DocumentErrorsResult>)var3_3, var35_182);
        }
        var35_182 = var21_165.getResourceType();
        return new DocumentResult(var34_181, (ArrayList<DocumentErrorsResult>)var3_3, var35_182);
    }

    public static final String getHashDcc(String string, String string2) {
        Objects.requireNonNull((Object)string2, (String)"null cannot be cast to non-null type kotlin.CharSequence");
        String string3 = StringsKt__IndentKt.trim((CharSequence)string2).toString();
        Objects.requireNonNull((Object)string3, (String)"null cannot be cast to non-null type java.lang.String");
        String string4 = string3.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)");
        Objects.requireNonNull((Object)string, (String)"null cannot be cast to non-null type kotlin.CharSequence");
        return DocOfflineService.toSha256(Intrinsics.stringPlus((String)string4, (Object)StringsKt__IndentKt.trim((CharSequence)string).toString()));
    }

    public static final String toSha256(String string) {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-256");
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull((Object)string, (String)"null cannot be cast to non-null type java.lang.String");
        byte[] arrby = string.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)arrby, (String)"(this as java.lang.String).getBytes(charset)");
        byte[] arrby2 = messageDigest.digest(arrby);
        Intrinsics.checkNotNullExpressionValue((Object)arrby2, (String)"getInstance(\"SHA-256\").digest(\n                input.toByteArray()\n            )");
        byte[] arrby3 = Hex.encode((byte[])arrby2, (int)0, (int)arrby2.length);
        Intrinsics.checkNotNullExpressionValue((Object)arrby3, (String)"encode(hash)");
        return new String(arrby3, charset);
    }

    public static final void writeStat(Context context, Map<String, String> map, String string, String string2, String string3, boolean bl, boolean bl2) {
        String string4;
        StringBuffer stringBuffer = new StringBuffer();
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        String string5 = context.getSharedPreferences("com.ingroupe.verify.LOCAL_STAT_KEY", 0).getString("STATS_PERIOD", "");
        StatsPeriod statsPeriod = new StatsPeriod();
        if (!Intrinsics.areEqual((Object)string5, (Object)"")) {
            Gson gson = new Gson();
            new LinkedHashMap();
            Object object = gson.fromJson(string5, new StatsPeriod.Companion.getStatsPeriod.itemType.1().type);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"gson.fromJson(jsonMap, itemType)");
            Map map2 = (Map)object;
            Intrinsics.checkNotNullParameter((Object)map2, (String)"<set-?>");
            statsPeriod.map = map2;
        }
        LocalDate localDate = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue((Object)localDate, (String)"now()");
        StatsDay statsDay = statsPeriod.getStatsDay(localDate);
        String string6 = (String)map.get((Object)"validityGlobal");
        Constants$GlobalValidity constants$GlobalValidity = Constants$GlobalValidity.KO;
        String string7 = Intrinsics.areEqual((Object)string6, (Object)constants$GlobalValidity.getText()) ? "false" : (Intrinsics.areEqual((Object)string6, (Object)Constants$GlobalValidity.OK.getText()) ? "true" : (Intrinsics.areEqual((Object)string6, (Object)Constants$GlobalValidity.INFO.getText()) ? "null" : "false"));
        if (bl2) {
            statsDay.nbDuplicate = 1 + statsDay.nbDuplicate;
        } else {
            String string8 = (String)map.get((Object)"validityGlobal");
            if (Intrinsics.areEqual((Object)string8, (Object)constants$GlobalValidity.getText())) {
                statsDay.nbR = 1 + statsDay.nbR;
            } else if (Intrinsics.areEqual((Object)string8, (Object)Constants$GlobalValidity.OK.getText())) {
                statsDay.nbG = 1 + statsDay.nbG;
            } else if (Intrinsics.areEqual((Object)string8, (Object)Constants$GlobalValidity.INFO.getText())) {
                statsDay.nbB = 1 + statsDay.nbB;
            } else {
                statsDay.nbR = 1 + statsDay.nbR;
            }
            statsDay.nbTotal = 1 + statsDay.nbTotal;
        }
        statsPeriod.cleanOldStatsAndSave(context);
        stringBuffer.append(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        stringBuffer.append("|");
        stringBuffer.append(string7);
        stringBuffer.append("|");
        if (bl) {
            stringBuffer.append("Blacklist");
        }
        if (bl2) {
            stringBuffer.append("Doublon");
        }
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(string2);
        stringBuffer.append("|");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
        String string9 = "000000000";
        if (sharedPreferences != null && (string4 = sharedPreferences.getString(Constants$SavedItems.CURRENT_SIREN.getText(), null)) != null) {
            string9 = string4;
        }
        stringBuffer.append(string9);
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(string);
        stringBuffer.append("|");
        stringBuffer.append(string3);
        stringBuffer.append("|");
        Analytics analytics = Analytics.INSTANCE;
        String string10 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string10, (String)"stat.toString()");
        Analytics analytics2 = analytics;
        synchronized (analytics2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string10, (String)"verifEvent");
            R.style.launch$default((CoroutineScope)R.style.CoroutineScope((CoroutineContext)Dispatchers.IO), null, null, (Function2)new Analytics.reportVerifEvent.1(context, string10, null), (int)3, null);
            return;
        }
    }
}

