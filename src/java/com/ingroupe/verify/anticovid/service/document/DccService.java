/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.preference.PreferenceManager
 *  android.util.Log
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.ingroupe.verify.anticovid.service.document;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.common.Constants$GlobalValidity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.Constants$SpecificList;
import com.ingroupe.verify.anticovid.common.Constants$SpecificValues;
import com.ingroupe.verify.anticovid.service.barcode.enums.ErrorBarcodeEnum;
import com.ingroupe.verify.anticovid.service.document.BarcodeService;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticDccResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$getSpecificList$itemType$1;
import dgca.verifier.app.decoder.model.GreenCertificate;
import dgca.verifier.app.decoder.model.Test;
import j$.time.OffsetDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

public abstract class DccService
extends BarcodeService {
    /*
     * Exception decompiling
     */
    public static final void getDccRecovery(DocumentStaticDccResult var0, Map<String, String> var1, Context var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl353 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final void getDccTest(DocumentStaticDccResult var0, Map<String, String> var1_1, Context var2_2) {
        block34 : {
            block40 : {
                block39 : {
                    block35 : {
                        block37 : {
                            block38 : {
                                block36 : {
                                    block32 : {
                                        block33 : {
                                            Intrinsics.checkNotNullParameter(var1_1, (String)"mappedDynamicData");
                                            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                                            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                                            var3_3 = ((Activity)var2_2).getPreferences(0);
                                            var4_4 = null;
                                            var5_5 = var3_3 == null ? null : var3_3.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                                            var6_6 = var5_5 != null;
                                            var7_7 = Constants$GlobalValidity.KO.getText();
                                            var8_8 = var2_2.getString(2131820772);
                                            Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_invalid)");
                                            var9_9 = var0.dcc;
                                            if (var9_9 == null || (var10_10 = var9_9.getTests()) == null || (var11_11 = (Test)var10_10.get(0)) == null) break block32;
                                            var12_14 = var11_11.getDateTimeOfCollection();
                                            try {
                                                var4_4 = OffsetDateTime.parse(var12_14, DateTimeFormatter.ISO_DATE_TIME);
                                            }
                                            catch (Exception v0) {}
                                            var14_15 = OffsetDateTime.now();
                                            if (var11_11.getTestNameAndManufacturer() == null) ** GOTO lbl-1000
                                            var76_16 = var11_11.getTestNameAndManufacturer();
                                            Intrinsics.checkNotNull((Object)var76_16);
                                            var77_17 = Constants$SpecificList.TEST_MANUFACTURER;
                                            Intrinsics.checkNotNullParameter((Object)"testNameAndManufacturer", (String)"field");
                                            Intrinsics.checkNotNullParameter((Object)var76_16, (String)"value");
                                            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                                            Intrinsics.checkNotNullParameter((Object)var77_17, (String)"slEnum");
                                            Intrinsics.checkNotNullParameter(var1_1, (String)"mappedDynamicData");
                                            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                                            Intrinsics.checkNotNullParameter((Object)var77_17, (String)"svEnum");
                                            Intrinsics.checkNotNullParameter((Object)var76_16, (String)"key");
                                            var78_18 = PreferenceManager.getDefaultSharedPreferences((Context)var2_2);
                                            Intrinsics.checkExpressionValueIsNotNull((Object)var78_18, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
                                            var79_19 = var78_18.getString(var77_17.getText(), "{}");
                                            var80_20 = new Gson().fromJson(var79_19, new SynchronisationUtils$getSpecificList$itemType$1().type);
                                            Intrinsics.checkNotNullExpressionValue((Object)var80_20, (String)"gson.fromJson(jsonMap, itemType)");
                                            var81_21 = (String)((Map)var80_20).get((Object)var76_16);
                                            if (var81_21 != null) {
                                                var1_1.put((Object)"testNameAndManufacturer", (Object)var81_21);
                                                var83_22 = true;
                                            } else {
                                                var1_1.put((Object)"testNameAndManufacturer", (Object)var76_16);
                                                var83_22 = false;
                                            }
                                            if (var83_22) {
                                                var15_23 = true;
                                            } else lbl-1000: // 2 sources:
                                            {
                                                var15_23 = false;
                                            }
                                            var16_24 = var11_11.getTypeOfTest();
                                            Objects.requireNonNull((Object)var16_24, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                            var18_25 = BarcodeService.isValuePresent("typeOfTest", StringsKt__IndentKt.trim((CharSequence)var16_24).toString(), var2_2, Constants$SpecificList.TEST_PCR, var1_1);
                                            var19_26 = var11_11.getTypeOfTest();
                                            Objects.requireNonNull((Object)var19_26, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                            var21_27 = BarcodeService.isValuePresent("typeOfTest", StringsKt__IndentKt.trim((CharSequence)var19_26).toString(), var2_2, Constants$SpecificList.TEST_ANTIGENIC, var1_1);
                                            if (!var6_6) break block33;
                                            if (var0.hasValidSignature && var4_4 != null) {
                                                if (!var18_25 && !var21_27) {
                                                    var7_7 = Constants$GlobalValidity.KO.getText();
                                                    var8_8 = var2_2.getString(2131820789);
                                                    Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_type_not_valid)");
                                                } else if (var18_25) {
                                                    var72_28 = var11_11.getTestResult();
                                                    Objects.requireNonNull((Object)var72_28, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                                    if (Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var72_28).toString(), (Object)"260415000")) {
                                                        var7_7 = Constants$GlobalValidity.INFO.getText();
                                                        var8_8 = var2_2.getString(2131820787);
                                                        Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_pcr_negative_info)");
                                                    } else {
                                                        var74_29 = var11_11.getTestResult();
                                                        Objects.requireNonNull((Object)var74_29, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                                        if (Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var74_29).toString(), (Object)"260373001")) {
                                                            var7_7 = Constants$GlobalValidity.INFO.getText();
                                                            var8_8 = var2_2.getString(2131820788);
                                                            Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_pcr_positive_info)");
                                                        }
                                                    }
                                                } else if (var21_27) {
                                                    if (var15_23) {
                                                        var68_30 = var11_11.getTestResult();
                                                        Objects.requireNonNull((Object)var68_30, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                                        if (Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var68_30).toString(), (Object)"260415000")) {
                                                            var7_7 = Constants$GlobalValidity.INFO.getText();
                                                            var8_8 = var2_2.getString(2131820780);
                                                            Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_antigenic_negative_info)");
                                                        } else {
                                                            var70_31 = var11_11.getTestResult();
                                                            Objects.requireNonNull((Object)var70_31, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                                            if (Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var70_31).toString(), (Object)"260373001")) {
                                                                var7_7 = Constants$GlobalValidity.INFO.getText();
                                                                var8_8 = var2_2.getString(2131820782);
                                                                Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_antigenic_positive_info)");
                                                            }
                                                        }
                                                    } else {
                                                        var64_32 = var11_11.getTestResult();
                                                        Objects.requireNonNull((Object)var64_32, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                                        if (Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var64_32).toString(), (Object)"260415000")) {
                                                            var7_7 = Constants$GlobalValidity.INFO.getText();
                                                            var8_8 = var2_2.getString(2131820779);
                                                            Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_antigenic_negative_fr_info)");
                                                        } else {
                                                            var66_33 = var11_11.getTestResult();
                                                            Objects.requireNonNull((Object)var66_33, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                                            if (Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var66_33).toString(), (Object)"260373001")) {
                                                                var7_7 = Constants$GlobalValidity.INFO.getText();
                                                                var8_8 = var2_2.getString(2131820781);
                                                                Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.result_test_antigenic_positive_fr_info)");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                var7_7 = Constants$GlobalValidity.KO.getText();
                                                var8_8 = var2_2.getString(2131820661);
                                                Intrinsics.checkNotNullExpressionValue((Object)var8_8, (String)"context.getString(R.string.invalid_dcc_signature)");
                                            }
                                            if (var4_4 != null) {
                                                var53_34 = OffsetDateTime.from(var4_4);
                                                var54_35 = var53_34.until(var14_15, ChronoUnit.HOURS);
                                                var56_36 = var53_34.plusHours(var54_35).until(var14_15, ChronoUnit.MINUTES);
                                                if (ChronoUnit.HOURS.between(var4_4, var14_15) <= 96L) {
                                                    var63_37 = new Object[]{var54_35, var56_36};
                                                    var61_38 = var2_2.getString(2131820770, var63_37);
                                                } else {
                                                    var58_39 = new Object[2];
                                                    var59_40 = 24;
                                                    var58_39[0] = var54_35 / var59_40;
                                                    var58_39[1] = var54_35 % var59_40;
                                                    var61_38 = var2_2.getString(2131820769, var58_39);
                                                }
                                                Intrinsics.checkNotNullExpressionValue((Object)var61_38, (String)"if (ChronoUnit.HOURS.between(date, currentDate) <= 96) {\n                            context.getString(\n                                R.string.result_duration_hours_minutes,\n                                hours,\n                                minutes\n                            )\n                        } else {\n                            context.getString(\n                                R.string.result_duration_days_hours,\n                                hours / 24,\n                                hours % 24\n                            )\n                        }");
                                                var1_1.put((Object)"samplingDuration", (Object)var61_38);
                                            }
                                            var45_41 = var11_11.getTestResult();
                                            Objects.requireNonNull((Object)var45_41, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                            DccService.getString("testResult", StringsKt__IndentKt.trim((CharSequence)var45_41).toString(), var2_2, var1_1);
                                            var47_42 = var11_11.getTypeOfTest();
                                            Objects.requireNonNull((Object)var47_42, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                            DccService.getString("testType", StringsKt__IndentKt.trim((CharSequence)var47_42).toString(), var2_2, var1_1);
                                            DccService.getString("disease", var11_11.getDisease(), var2_2, var1_1);
                                            var49_43 = var11_11.getCountryOfVaccination();
                                            Intrinsics.checkNotNullParameter((Object)var49_43, (String)"value");
                                            var50_44 = new Locale("FR", var49_43).getDisplayCountry();
                                            Intrinsics.checkNotNullExpressionValue((Object)var50_44, (String)"Locale(\"FR\", value).displayCountry");
                                            if (StringsKt__IndentKt.equals((String)var49_43, (String)var50_44, (boolean)true)) {
                                                Log.i((String)"OperationService", (String)ErrorBarcodeEnum.ERR05.getMessage());
                                            }
                                            var1_1.put((Object)"countryOfVaccination", (Object)var50_44);
                                            break block34;
                                        }
                                        if (var4_4 == null || !var0.hasValidSignature || !var18_25 && !var21_27) break block32;
                                        var22_45 = var11_11.getTestResult();
                                        Objects.requireNonNull((Object)var22_45, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                                        if (!Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var22_45).toString(), (Object)"260415000")) break block35;
                                        if (!var18_25) break block36;
                                        var42_46 = ChronoUnit.HOURS.between(var4_4, var14_15);
                                        var44_47 = BarcodeService.getSV(var2_2, Constants$SpecificValues.TEST_NEGATIVE_PCR_END_HOUR);
                                        var24_12 = var7_7;
                                        var25_13 = var8_8;
                                        if (var42_46 < (long)var44_47) break block37;
                                        break block38;
                                    }
                                    var24_12 = var7_7;
                                    var25_13 = var8_8;
                                    ** GOTO lbl-1000
                                }
                                var24_12 = var7_7;
                                var25_13 = var8_8;
                            }
                            if (!var21_27 || ChronoUnit.HOURS.between(var4_4, var14_15) >= (long)BarcodeService.getSV(var2_2, Constants$SpecificValues.TEST_NEGATIVE_ANTIGENIC_END_HOUR)) break block39;
                        }
                        var35_48 = Constants$GlobalValidity.OK.getText();
                        var36_49 = var2_2.getString(2131820797);
                        Intrinsics.checkNotNullExpressionValue((Object)var36_49, (String)"context.getString(R.string.result_valid)");
                        ** GOTO lbl189
                    }
                    var24_12 = var7_7;
                    var25_13 = var8_8;
                }
                var26_50 = var11_11.getTestResult();
                Objects.requireNonNull((Object)var26_50, (String)"null cannot be cast to non-null type kotlin.CharSequence");
                if (!Intrinsics.areEqual((Object)StringsKt__IndentKt.trim((CharSequence)var26_50).toString(), (Object)"260373001")) ** GOTO lbl-1000
                if (!var18_25) break block40;
                var37_51 = BarcodeService.getSV(var2_2, Constants$SpecificValues.TEST_POSITIVE_PCR_START_DAY);
                var38_52 = BarcodeService.getSV(var2_2, Constants$SpecificValues.TEST_POSITIVE_PCR_END_DAY);
                var39_53 = ChronoUnit.DAYS.between(var4_4, var14_15);
                var41_54 = (long)var37_51 <= var39_53 && var39_53 <= (long)var38_52;
                if (var41_54) ** GOTO lbl-1000
            }
            if (var21_27) {
                var30_55 = BarcodeService.getSV(var2_2, Constants$SpecificValues.TEST_POSITIVE_ANTIGENIC_START_DAY);
                var31_56 = BarcodeService.getSV(var2_2, Constants$SpecificValues.TEST_POSITIVE_ANTIGENIC_END_DAY);
                var32_57 = ChronoUnit.DAYS.between(var4_4, var14_15);
                var34_58 = (long)var30_55 <= var32_57 && var32_57 <= (long)var31_56;
                ** if (!var34_58) goto lbl-1000
            }
            ** GOTO lbl-1000
lbl-1000: // 2 sources:
            {
                var35_48 = Constants$GlobalValidity.OK.getText();
                var36_49 = var2_2.getString(2131820797);
                Intrinsics.checkNotNullExpressionValue((Object)var36_49, (String)"context.getString(R.string.result_valid)");
lbl189: // 2 sources:
                var7_7 = var35_48;
                var8_8 = var36_49;
                ** GOTO lbl194
            }
lbl-1000: // 4 sources:
            {
                var7_7 = var24_12;
                var8_8 = var25_13;
            }
        }
        var1_1.put((Object)"validityGlobal", (Object)var7_7);
        var1_1.put((Object)"validityStatus", (Object)var8_8);
    }

    /*
     * Exception decompiling
     */
    public static final void getDccVaccination(DocumentStaticDccResult var0, Map<String, String> var1, Context var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public static final void getString(String var0, String var1, Context var2, Map<String, String> var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl80 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }
}

