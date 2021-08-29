/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.AssetManager
 *  android.util.Log
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.ui.result.ResultScanPresenterImpl$reloadConf$
 *  com.ingroupe.verify.anticovid.ui.result.ResultScanPresenterImpl$reloadConf$$inlined
 *  com.ingroupe.verify.anticovid.ui.result.ResultScanPresenterImpl$reloadConf$$inlined$loadFromAsset
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.ingroupe.verify.anticovid.ui.result;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.common.Constants$GlobalValidity;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.common.model.ResultData;
import com.ingroupe.verify.anticovid.common.model.ResultScan;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfField;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfGroup;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfInfo;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfStatic;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfType;
import com.ingroupe.verify.anticovid.service.document.model.DocumentDataResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentErrorsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentFieldResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentSignatureResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStatic2ddocResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticDccResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticFieldsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;
import com.ingroupe.verify.anticovid.ui.result.ResultScanPresenter;
import com.ingroupe.verify.anticovid.ui.result.ResultScanPresenterImpl$reloadConf$;
import com.ingroupe.verify.anticovid.ui.result.ResultScanView;
import dalvik.annotation.SourceDebugExtension;
import dgca.verifier.app.decoder.model.GreenCertificate;
import dgca.verifier.app.decoder.model.Person;
import dgca.verifier.app.decoder.model.RecoveryStatement;
import dgca.verifier.app.decoder.model.Test;
import dgca.verifier.app.decoder.model.Vaccination;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

@SourceDebugExtension(value="SMAP\nResultScanPresenterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResultScanPresenterImpl.kt\ncom/ingroupe/verify/anticovid/ui/result/ResultScanPresenterImpl\n+ 2 Utils.kt\ncom/ingroupe/verify/anticovid/common/Utils$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,416:1\n130#2,15:417\n1#3:432\n1849#4,2:433\n1849#4,2:435\n1849#4:437\n1849#4,2:438\n1850#4:440\n1849#4:441\n1849#4,2:442\n1850#4:444\n1849#4,2:445\n1849#4,2:447\n1849#4,2:449\n*S KotlinDebug\n*F\n+ 1 ResultScanPresenterImpl.kt\ncom/ingroupe/verify/anticovid/ui/result/ResultScanPresenterImpl\n*L\n34#1:417,15\n65#1:433,2\n83#1:435,2\n140#1:437\n149#1:438,2\n140#1:440\n202#1:441\n208#1:442,2\n202#1:444\n356#1:445,2\n377#1:447,2\n395#1:449,2\n*E\n")
public final class ResultScanPresenterImpl
implements ResultScanPresenter {
    public final ResultScanView view;

    public ResultScanPresenterImpl(ResultScanView resultScanView) {
        this.view = resultScanView;
    }

    public static /* synthetic */ void addResultByValue$default(ResultScanPresenterImpl resultScanPresenterImpl, String string, String string2, ResultScan resultScan, boolean bl, boolean bl2, int n2) {
        boolean bl3 = (n2 & 8) != 0 ? false : bl;
        boolean bl4 = (n2 & 16) != 0 ? false : bl2;
        resultScanPresenterImpl.addResultByValue(string, string2, resultScan, bl3, bl4);
    }

    /*
     * Exception decompiling
     */
    public final void addResultByValue(String var1, String var2, ResultScan var3, boolean var4, boolean var5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl108 : ALOAD : trying to set 1 previously set to 0
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

    @Override
    public void prepareErrorResult(ResultScan resultScan, ArrayList<DocumentErrorsResult> arrayList, Context context) {
        Intrinsics.checkNotNullParameter((Object)resultScan, (String)"resultScan");
        Intrinsics.checkNotNullParameter(arrayList, (String)"errors");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        ResultData resultData = new ResultData();
        resultData.setFormat("Check_global_2");
        String string = context.getString(2131820772);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"context.getString(R.string.result_invalid)");
        resultData.setValue(string);
        resultScan.datas.add((Object)resultData);
        for (DocumentErrorsResult documentErrorsResult : arrayList) {
            boolean bl;
            boolean bl2;
            ResultData resultData2 = new ResultData();
            resultData2.isGroupHeader = bl = true;
            String string2 = context.getString(2131820758);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"context.getString(R.string.result_anomaly)");
            resultData2.setLabel(string2);
            resultScan.datas.add((Object)resultData2);
            String string3 = documentErrorsResult.getDocumentNumber();
            if (string3 == null || (bl2 = string3.length() > 0 ? bl : false) != bl) {
                bl = false;
            }
            if (bl) {
                ResultData resultData3 = new ResultData();
                String string4 = context.getString(2131820776);
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"context.getString(R.string.result_parameter)");
                resultData3.setLabel(string4);
                String string5 = documentErrorsResult.getDocumentNumber();
                Intrinsics.checkNotNull((Object)string5);
                resultData3.setValue(string5);
                resultData3.setFormat("Format_3");
                resultScan.datas.add((Object)resultData3);
            }
            ResultData resultData4 = new ResultData();
            String string6 = context.getString(2131820774);
            Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"context.getString(R.string.result_message)");
            resultData4.setLabel(string6);
            String string7 = documentErrorsResult.getMessage();
            Intrinsics.checkNotNull((Object)string7);
            resultData4.setValue(string7);
            resultData4.setFormat("Check_3");
            resultScan.datas.add((Object)resultData4);
        }
    }

    @Override
    public void prepareResult(ResultScan resultScan, String string, DocumentDataResult documentDataResult, ConfResult confResult, Context context, boolean bl) {
        ArrayList<Map<String, String>> arrayList;
        ArrayList<ConfType> arrayList2;
        ConfType confType;
        ResultData resultData;
        Intrinsics.checkNotNullParameter((Object)resultScan, (String)"resultScan");
        Intrinsics.checkNotNullParameter((Object)documentDataResult, (String)"documentDataResult");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        ResultScan resultScan2 = new ResultScan();
        DocumentStaticResult documentStaticResult = documentDataResult.getStatic();
        if (documentStaticResult != null) {
            DocumentSignatureResult documentSignatureResult;
            String string2;
            if (documentStaticResult instanceof DocumentStatic2ddocResult) {
                ArrayList<DocumentFieldResult> arrayList3;
                DocumentStaticFieldsResult documentStaticFieldsResult;
                ArrayList<DocumentFieldResult> arrayList4;
                DocumentStaticFieldsResult documentStaticFieldsResult2;
                ArrayList<DocumentFieldResult> arrayList5;
                DocumentStatic2ddocResult documentStatic2ddocResult = (DocumentStatic2ddocResult)documentStaticResult;
                DocumentStaticFieldsResult documentStaticFieldsResult3 = documentStatic2ddocResult.getHeader();
                if (documentStaticFieldsResult3 != null && (arrayList5 = documentStaticFieldsResult3.getFields()) != null) {
                    this.prepareStaticResultDatas(arrayList5, "static.header", resultScan2);
                }
                if ((documentStaticFieldsResult = documentStatic2ddocResult.getMessage()) != null && (arrayList4 = documentStaticFieldsResult.getFields()) != null) {
                    this.prepareStaticResultDatas(arrayList4, "static.message", resultScan2);
                }
                if ((documentStaticFieldsResult2 = documentStatic2ddocResult.getAnnexe()) != null && (arrayList3 = documentStaticFieldsResult2.getFields()) != null) {
                    this.prepareStaticResultDatas(arrayList3, "static.annexe", resultScan2);
                }
            } else if (documentStaticResult instanceof DocumentStaticDccResult) {
                List<RecoveryStatement> list;
                GreenCertificate greenCertificate;
                List<Vaccination> list2;
                DocumentStaticDccResult documentStaticDccResult;
                RecoveryStatement recoveryStatement;
                Vaccination vaccination;
                List<Test> list3;
                Test test;
                GreenCertificate greenCertificate2;
                DocumentStaticDccResult documentStaticDccResult2 = (DocumentStaticDccResult)documentStaticResult;
                GreenCertificate greenCertificate3 = documentStaticDccResult2.dcc;
                if (greenCertificate3 == null) {
                    documentStaticDccResult = documentStaticDccResult2;
                } else {
                    String string3;
                    String string4;
                    String string5 = greenCertificate3.getDateOfBirth();
                    documentStaticDccResult = documentStaticDccResult2;
                    ResultScanPresenterImpl.addResultByValue$default(this, string5, "dateOfBirth", resultScan2, true, false, 16);
                    String string6 = greenCertificate3.getPerson().getGivenName();
                    if (string6 == null) {
                        string4 = null;
                    } else {
                        String string7 = string6.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue((Object)string7, (String)"(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)");
                        string4 = string7;
                    }
                    ResultScanPresenterImpl.addResultByValue$default(this, string4, "givenName", resultScan2, false, false, 24);
                    String string8 = greenCertificate3.getPerson().getFamilyName();
                    if (string8 == null) {
                        string3 = null;
                    } else {
                        String string9 = string8.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue((Object)string9, (String)"(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)");
                        string3 = string9;
                    }
                    ResultScanPresenterImpl.addResultByValue$default(this, string3, "familyName", resultScan2, false, false, 24);
                }
                GreenCertificate greenCertificate4 = documentStaticDccResult.dcc;
                if (greenCertificate4 != null && (list3 = greenCertificate4.getTests()) != null && (test = (Test)list3.get(0)) != null) {
                    this.addResultByValue(test.getDateTimeOfCollection(), "dateTimeOfCollection", resultScan2, true, true);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getDisease(), "disease", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getTestName(), "testName", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getTestNameAndManufacturer(), "testNameAndManufacturer", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getTestingCentre(), "testingCentre", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getCountryOfVaccination(), "countryOfVaccination", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getCertificateIssuer(), "certificateIssuer", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, test.getCertificateIdentifier(), "certificateIdentifier", resultScan2, false, false, 24);
                }
                if ((greenCertificate = documentStaticDccResult.dcc) != null && (list2 = greenCertificate.getVaccinations()) != null && (vaccination = (Vaccination)list2.get(0)) != null) {
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getDateOfVaccination(), "dateOfVaccination", resultScan2, true, false, 16);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getMedicinalProduct(), "medicinalProduct", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getDisease(), "disease", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getVaccine(), "vaccine", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getManufacturer(), "manufacturer", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getCountryOfVaccination(), "countryOfVaccination", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getCertificateIssuer(), "certificateIssuer", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, vaccination.getCertificateIdentifier(), "certificateIdentifier", resultScan2, false, false, 24);
                }
                if ((greenCertificate2 = documentStaticDccResult.dcc) != null && (list = greenCertificate2.getRecoveryStatements()) != null && (recoveryStatement = (RecoveryStatement)list.get(0)) != null) {
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getDateOfFirstPositiveTest(), "dateOfFirstPositiveTest", resultScan2, true, false, 16);
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getCertificateValidFrom(), "certificateValidFrom", resultScan2, true, false, 16);
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getCertificateValidUntil(), "certificateValidUntil", resultScan2, true, false, 16);
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getDisease(), "disease", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getCountryOfVaccination(), "countryOfVaccination", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getCertificateIssuer(), "certificateIssuer", resultScan2, false, false, 24);
                    ResultScanPresenterImpl.addResultByValue$default(this, recoveryStatement.getCertificateIdentifier(), "certificateIdentifier", resultScan2, false, false, 24);
                }
            }
            if ((documentSignatureResult = documentStaticResult.getSignature()) != null && (string2 = documentSignatureResult.getStatus()) != null) {
                ResultData resultData2 = new ResultData();
                resultData2.setName("static.signature.status");
                resultData2.setLabel("static.signature.status");
                resultData2.setValue(string2);
                resultData2.isStatic = true;
                DocumentSignatureResult documentSignatureResult2 = documentStaticResult.getSignature();
                Boolean bl2 = documentSignatureResult2 == null ? null : documentSignatureResult2.isValid();
                resultData2.isSignatureValid = bl2;
                resultScan2.datas.add((Object)resultData2);
            }
        }
        if ((arrayList = documentDataResult.getDynamic()) != null && arrayList.size() > 0) {
            Object object = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"it[0]");
            Map map = (Map)object;
            for (String string10 : map.keySet()) {
                String string11 = (String)map.get((Object)string10);
                if (string11 == null || Intrinsics.areEqual((Object)"", (Object)string11)) continue;
                ResultData resultData3 = new ResultData();
                resultData3.setName(Intrinsics.stringPlus((String)"dynamic.", (Object)string10));
                resultData3.setLabel(string10);
                resultData3.setValue(string11);
                if (Intrinsics.areEqual((Object)string11, (Object)"")) break;
                resultScan2.datas.add((Object)resultData3);
            }
        }
        if (confResult == null || (arrayList2 = confResult.getTypes()) == null) {
            confType = null;
        } else {
            Object object2;
            block64 : {
                for (Object object2 : arrayList2) {
                    if (!StringsKt__IndentKt.equals((String)((ConfType)object2).getResourceType(), (String)string, (boolean)false)) continue;
                    break block64;
                }
                object2 = null;
            }
            confType = (ConfType)object2;
        }
        if (confType == null) {
            Object object3;
            ArrayList<ConfStatic> arrayList6;
            block65 : {
                arrayList6 = confResult == null ? null : confResult.getConfStatic();
                Intrinsics.checkNotNull(arrayList6);
                for (Object object3 : resultScan2.datas) {
                    if (!Intrinsics.areEqual((Object)((ResultData)object3).name, (Object)"static.signature.status")) continue;
                    break block65;
                }
                object3 = null;
            }
            ResultData resultData4 = (ResultData)object3;
            if (resultData4 != null) {
                ResultData resultData5 = new ResultData();
                resultData5.setLabel(resultData4.label);
                resultData5.setValue(resultData4.value);
                resultData5.position = resultData4.position;
                resultData5.withBackground = resultData4.withBackground;
                resultData5.isGroupHeader = resultData4.isGroupHeader;
                resultData5.setName(resultData4.name);
                resultData5.isStatic = resultData4.isStatic;
                resultData5.isSignatureValid = resultData4.isSignatureValid;
                resultData5.setFormat("Check_global_2");
                Boolean bl3 = resultData5.isSignatureValid;
                if (bl3 != null && bl3.booleanValue()) {
                    resultData5.setFormat("Check_global_1");
                }
                resultScan.datas.add((Object)resultData5);
            }
            for (ConfStatic confStatic : arrayList6) {
                ResultData resultData6 = new ResultData();
                String string12 = confStatic.getLabel();
                if (string12 != null) {
                    resultData6.setLabel(string12);
                }
                resultData6.isGroupHeader = true;
                resultScan.datas.add((Object)resultData6);
                for (ResultData resultData7 : resultScan2.datas) {
                    if (!StringsKt__IndentKt.startsWith$default((String)resultData7.name, (String)Intrinsics.stringPlus((String)"static.", (Object)confStatic.getName()), (boolean)false, (int)2)) continue;
                    if (Intrinsics.areEqual((Object)resultData7.name, (Object)"static.signature.status")) {
                        String string13 = context.getString(2131820773);
                        Intrinsics.checkNotNullExpressionValue((Object)string13, (String)"context.getString(R.string.result_label_signature)");
                        resultData7.setLabel(string13);
                        resultData7.setFormat("Check_3");
                        Boolean bl4 = resultData7.isSignatureValid;
                        if (bl4 != null && bl4.booleanValue()) {
                            resultData7.setFormat("Check_1");
                        }
                    } else {
                        resultData7.setFormat("Format_1");
                    }
                    resultScan.datas.add((Object)resultData7);
                }
            }
        } else {
            Object object4;
            block66 : {
                for (Object object4 : resultScan2.datas) {
                    if (!Intrinsics.areEqual((Object)((ResultData)object4).name, (Object)"dynamic.validityStatus")) continue;
                    break block66;
                }
                object4 = null;
            }
            ResultData resultData8 = (ResultData)object4;
            if (resultData8 != null) {
                Map<String, String> map;
                String string14;
                resultScan2.datas.remove((Object)resultData8);
                resultData8.setFormat("Check_global_2");
                ConfInfo confInfo = confType.getInformation();
                if (confInfo != null && (map = confInfo.getValidityValuesFormat()) != null && (string14 = (String)map.get((Object)resultData8.value)) != null) {
                    resultData8.setFormat(string14);
                }
                Object[] arrobject = new String[]{"2D-DOC_B2", "2D-DOC_L1", DocumentStaticDccResult.DccType.DCC_VACCINATION.getText(), DocumentStaticDccResult.DccType.DCC_RECOVERY.getText(), DocumentStaticDccResult.DccType.DCC_TEST.getText()};
                if (ArraysKt___ArraysJvmKt.contains((Iterable)ArraysKt___ArraysJvmKt.listOf((Object[])arrobject), (Object)confType.getResourceType())) {
                    Object object52;
                    block67 : {
                        for (Object object52 : resultScan2.datas) {
                            if (!Intrinsics.areEqual((Object)((ResultData)object52).name, (Object)"dynamic.validityGlobal")) continue;
                            break block67;
                        }
                        object52 = null;
                    }
                    ResultData resultData9 = (ResultData)object52;
                    String string15 = resultData9 == null ? null : resultData9.value;
                    if (Intrinsics.areEqual((Object)string15, (Object)Constants$GlobalValidity.OK.getText())) {
                        resultData8.setFormat("Check_global_1");
                    } else if (Intrinsics.areEqual((Object)string15, (Object)Constants$GlobalValidity.INFO.getText())) {
                        resultData8.setFormat("Check_global_info");
                    } else if (Intrinsics.areEqual((Object)string15, (Object)Constants$GlobalValidity.KO.getText())) {
                        resultData8.setFormat("Check_global_2");
                    }
                }
                if (!bl) {
                    if (Intrinsics.areEqual((Object)resultData8.format, (Object)"Check_global_2")) {
                        String string16 = context.getString(2131820772);
                        Intrinsics.checkNotNullExpressionValue((Object)string16, (String)"context.getString(R.string.result_invalid)");
                        resultData8.setValue(string16);
                    } else if (Intrinsics.areEqual((Object)resultData8.format, (Object)"Check_global_1")) {
                        String string17 = context.getString(2131820797);
                        Intrinsics.checkNotNullExpressionValue((Object)string17, (String)"context.getString(R.string.result_valid)");
                        resultData8.setValue(string17);
                    }
                }
                resultScan.datas.add((Object)resultData8);
            }
            ArrayList<ConfGroup> arrayList7 = confType.getGroups();
            if (arrayList7 != null) {
                for (ConfGroup confGroup : arrayList7) {
                    ArrayList<ConfField> arrayList8;
                    ResultData resultData10 = new ResultData();
                    String string18 = confGroup.getLabelGroup();
                    if (string18 != null) {
                        resultData10.setLabel(string18);
                    }
                    resultData10.isGroupHeader = true;
                    if (!Intrinsics.areEqual((Object)confGroup.getShowGroupName(), (Object)Boolean.FALSE)) {
                        resultScan.datas.add((Object)resultData10);
                    }
                    if ((arrayList8 = confGroup.getFields()) == null) continue;
                    for (ConfField confField : arrayList8) {
                        Object object62;
                        block68 : {
                            for (Object object62 : resultScan2.datas) {
                                if (!Intrinsics.areEqual((Object)((ResultData)object62).name, (Object)confField.getName())) continue;
                                break block68;
                            }
                            object62 = null;
                        }
                        ResultData resultData11 = (ResultData)object62;
                        if (resultData11 != null && !StringsKt__IndentKt.isBlank((CharSequence)resultData11.value)) {
                            String string19;
                            resultScan2.datas.remove((Object)resultData11);
                            String string20 = confField.getLabel();
                            if (string20 != null) {
                                resultData11.setLabel(string20);
                            }
                            String string21 = confField.getDefaultFormat();
                            if (string21 != null) {
                                resultData11.setFormat(string21);
                            }
                            Map<String, String> map = confField.getValuesFormat();
                            if (map != null && (string19 = (String)map.get((Object)resultData11.value)) != null) {
                                resultData11.setFormat(string19);
                            }
                            resultScan.datas.add((Object)resultData11);
                            continue;
                        }
                        Log.w((String)"ResultScanP", (String)Intrinsics.stringPlus((String)"Donn\u00e9es de contr\u00f4le absente ou vide : ", (Object)confField.getName()));
                    }
                }
            }
        }
        ArrayList arrayList9 = new ArrayList();
        Iterator iterator = resultScan.datas.iterator();
        int n2 = 0;
        block10 : do {
            resultData = null;
            while (iterator.hasNext()) {
                ResultData resultData12 = (ResultData)iterator.next();
                if (resultData12.isGroupHeader) {
                    if (resultData != null) {
                        arrayList9.add((Object)resultData);
                    }
                    resultData = resultData12;
                    n2 = 0;
                    continue;
                }
                if (Intrinsics.areEqual((Object)resultData12.format, (Object)"Hidden_1")) continue;
                if (n2 % 2 == 1) {
                    resultData12.withBackground = true;
                }
                ++n2;
                continue block10;
            }
            break;
        } while (true);
        if (resultData != null) {
            arrayList9.add(resultData);
        }
        for (ResultData resultData13 : arrayList9) {
            resultScan.datas.remove((Object)resultData13);
        }
    }

    public final void prepareStaticResultDatas(ArrayList<DocumentFieldResult> arrayList, String string, ResultScan resultScan) {
        for (DocumentFieldResult documentFieldResult : arrayList) {
            ResultData resultData = new ResultData();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append('.');
            String string2 = documentFieldResult.getName();
            Intrinsics.checkNotNull((Object)string2);
            stringBuilder.append(string2);
            resultData.setName(stringBuilder.toString());
            String string3 = documentFieldResult.getLabel();
            Intrinsics.checkNotNull((Object)string3);
            resultData.setLabel(string3);
            String string4 = documentFieldResult.getValue();
            Intrinsics.checkNotNull((Object)string4);
            resultData.setValue(string4);
            resultData.isStatic = true;
            resultScan.datas.add((Object)resultData);
        }
    }

    @Override
    public void reloadConf(SharedViewModel sharedViewModel, Context context) {
        ConfResult confResult;
        Object object;
        Intrinsics.checkNotNullParameter((Object)((Object)sharedViewModel), (String)"model");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
        String string = Constants$SavedItems.CONF_NAME.getText();
        String string2 = "conf.json";
        String string3 = sharedPreferences.getString(string, string2);
        if (string3 != null) {
            string2 = string3;
        }
        try {
            InputStream inputStream = context.getAssets().open(string2);
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            Type type = new TypeToken<ConfResult>(){}.type;
            object = new Gson().fromJson((Reader)inputStreamReader, type);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Gson().fromJson(isr, itemType)");
            inputStream.close();
            inputStreamReader.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            object = null;
        }
        sharedViewModel.configuration = confResult = (ConfResult)object;
        Utils.Companion.sortConf(confResult);
    }
}

