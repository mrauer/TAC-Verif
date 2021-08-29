/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.AssetManager
 *  android.util.Log
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.ui.scan.ScanPresenterImpl$checkExpirationAndDo$lambda-1$
 *  com.ingroupe.verify.anticovid.ui.scan.ScanPresenterImpl$checkExpirationAndDo$lambda-1$$inlined
 *  com.ingroupe.verify.anticovid.ui.scan.ScanPresenterImpl$checkExpirationAndDo$lambda-1$$inlined$loadFromAsset
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.scan;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.auth0.android.jwt.JWTPayload;
import com.google.android.material.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.auth.JWTUtils;
import com.ingroupe.verify.anticovid.auth.JWTUtils$Companion$decodeJWTAndUpdatePrefs$$inlined$loadFromAsset$1;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfType;
import com.ingroupe.verify.anticovid.service.document.DccService;
import com.ingroupe.verify.anticovid.service.document.DocOfflineService;
import com.ingroupe.verify.anticovid.service.document.DocOfflineService$Companion$WhenMappings;
import com.ingroupe.verify.anticovid.service.document.StaticDataService;
import com.ingroupe.verify.anticovid.service.document.enums.ErrorDocEnum;
import com.ingroupe.verify.anticovid.service.document.model.DocumentDataResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentErrorsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticDccResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;
import com.ingroupe.verify.anticovid.synchronization.elements.Blacklist;
import com.ingroupe.verify.anticovid.ui.scan.-$$Lambda$ScanPresenterImpl$HKmgv29g8ZLsbrs4QiD7mVTEoOY;
import com.ingroupe.verify.anticovid.ui.scan.ScanPresenter;
import com.ingroupe.verify.anticovid.ui.scan.ScanPresenterImpl$checkExpirationAndDo$lambda-1$;
import com.ingroupe.verify.anticovid.ui.scan.ScanView;
import dalvik.annotation.SourceDebugExtension;
import dgca.verifier.app.decoder.model.GreenCertificate;
import dgca.verifier.app.decoder.model.RecoveryStatement;
import dgca.verifier.app.decoder.model.Test;
import dgca.verifier.app.decoder.model.Vaccination;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nScanPresenterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanPresenterImpl.kt\ncom/ingroupe/verify/anticovid/ui/scan/ScanPresenterImpl\n+ 2 Utils.kt\ncom/ingroupe/verify/anticovid/common/Utils$Companion\n*L\n1#1,86:1\n130#2,15:87\n*S KotlinDebug\n*F\n+ 1 ScanPresenterImpl.kt\ncom/ingroupe/verify/anticovid/ui/scan/ScanPresenterImpl\n*L\n55#1:87,15\n*E\n")
public final class ScanPresenterImpl
implements ScanPresenter {
    public final ScanView view;

    public ScanPresenterImpl(ScanView scanView) {
        Intrinsics.checkNotNullParameter((Object)scanView, (String)"view");
        this.view = scanView;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public DocumentResult checkDcc(String var1_1, Context var2_2) {
        block18 : {
            block17 : {
                Intrinsics.checkNotNullParameter((Object)var1_1, (String)"qrCode");
                Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                Intrinsics.checkNotNullParameter((Object)var1_1, (String)"encodedDcc");
                Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                var3_3 = new ArrayList();
                var4_4 = new LinkedHashMap();
                var5_5 = new ArrayList();
                Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
                var6_6 = ((Activity)var2_2).getPreferences(0);
                var7_7 = var6_6 == null ? null : var6_6.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                var8_8 = var7_7 != null;
                var9_9 = var8_8 != false ? "TACV_DCC_ANDROID_OT" : "TACV_DCC_ANDROID_LITE";
                var10_10 = var9_9;
                try {
                    var11_11 = StaticDataService.getDcc(var1_1, var2_2, (Map<String, String>)var4_4);
                    var12_12 = var11_11.dcc;
                    var13_13 = var12_12 == null ? null : var12_12.getTests();
                    if (var13_13 == null) break block17;
                    var14_14 = DocumentStaticDccResult.DccType.DCC_TEST;
                    ** GOTO lbl33
                }
                catch (Exception v0) {
                    DocOfflineService.writeStat(var2_2, (Map<String, String>)var4_4, "", var10_10, ErrorDocEnum.ERR03.getMessage(), false, false);
                    return null;
                }
            }
            var47_15 = var12_12 == null ? null : var12_12.getRecoveryStatements();
            if (var47_15 == null) break block18;
            var14_14 = DocumentStaticDccResult.DccType.DCC_RECOVERY;
            ** GOTO lbl33
        }
        var48_16 = var12_12 == null ? null : var12_12.getVaccinations();
        if (var48_16 != null) {
            var14_14 = DocumentStaticDccResult.DccType.DCC_VACCINATION;
lbl33: // 3 sources:
            var15_17 = var14_14;
        } else {
            var15_17 = null;
        }
        var16_18 = var15_17 == null ? -1 : DocOfflineService$Companion$WhenMappings.$EnumSwitchMapping$0[var15_17.ordinal()];
        var17_19 = "";
        if (var16_18 != 1) {
            if (var16_18 != 2) {
                if (var16_18 != 3) {
                    var23_21 = var20_20 = var17_19;
                } else {
                    var43_22 = var11_11.dcc;
                    Intrinsics.checkNotNull((Object)var43_22);
                    var44_23 = var43_22.getRecoveryStatements();
                    Intrinsics.checkNotNull(var44_23);
                    var20_20 = ((RecoveryStatement)var44_23.get(0)).getCertificateIdentifier();
                    var45_24 = var11_11.dcc;
                    Intrinsics.checkNotNull((Object)var45_24);
                    var46_25 = var45_24.getRecoveryStatements();
                    Intrinsics.checkNotNull(var46_25);
                    var23_21 = ((RecoveryStatement)var46_25.get(0)).getCountryOfVaccination();
                    DccService.getDccRecovery(var11_11, (Map<String, String>)var4_4, var2_2);
                }
            } else {
                var39_26 = var11_11.dcc;
                Intrinsics.checkNotNull((Object)var39_26);
                var40_27 = var39_26.getTests();
                Intrinsics.checkNotNull(var40_27);
                var20_20 = ((Test)var40_27.get(0)).getCertificateIdentifier();
                var41_28 = var11_11.dcc;
                Intrinsics.checkNotNull((Object)var41_28);
                var42_29 = var41_28.getTests();
                Intrinsics.checkNotNull(var42_29);
                var23_21 = ((Test)var42_29.get(0)).getCountryOfVaccination();
                DccService.getDccTest(var11_11, (Map<String, String>)var4_4, var2_2);
            }
        } else {
            var18_30 = var11_11.dcc;
            Intrinsics.checkNotNull((Object)var18_30);
            var19_31 = var18_30.getVaccinations();
            Intrinsics.checkNotNull(var19_31);
            var20_20 = ((Vaccination)var19_31.get(0)).getCertificateIdentifier();
            var21_32 = var11_11.dcc;
            Intrinsics.checkNotNull((Object)var21_32);
            var22_33 = var21_32.getVaccinations();
            Intrinsics.checkNotNull(var22_33);
            var23_21 = ((Vaccination)var22_33.get(0)).getCountryOfVaccination();
            DccService.getDccVaccination(var11_11, (Map<String, String>)var4_4, var2_2);
        }
        var3_3.add((Object)var4_4);
        var25_34 = DocOfflineService.getHashDcc(var20_20, var23_21);
        var27_35 = Blacklist.isBlacklisted(var2_2, Blacklist.BlacklistType.BLACKLIST_DCC, var25_34);
        var28_36 = Blacklist.isHashDuplicate(var25_34, var2_2);
        if (var27_35) {
            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"context");
            var29_37 = ((Activity)var2_2).getPreferences(0);
            var30_38 = var29_37 == null ? null : var29_37.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
            var31_39 = false;
            if (var30_38 != null) {
                var31_39 = true;
            }
            if (var31_39) {
                var4_4.put((Object)"blacklist", (Object)Blacklist.Message.BLACKLIST_OT.name());
            } else {
                var4_4.put((Object)"blacklist", (Object)Blacklist.Message.BLACKLIST_LITE.name());
            }
        } else if (var28_36) {
            var4_4.put((Object)"duplicate", (Object)Blacklist.Message.DUPLICATE.name());
        }
        if (var15_17 != null && (var33_40 = var15_17.getText()) != null) {
            var17_19 = var33_40;
        }
        DocOfflineService.writeStat(var2_2, (Map<String, String>)var4_4, var17_19, var10_10, "", var27_35, var28_36);
        var34_41 = new DocumentDataResult(var11_11, (ArrayList<Map<String, String>>)var3_3);
        var35_42 = var15_17 == null ? null : var15_17.getText();
        return new DocumentResult(var34_41, (ArrayList<DocumentErrorsResult>)var5_5, var35_42);
    }

    @Override
    public void checkExpirationAndDo(SharedViewModel sharedViewModel, Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter((Object)((Object)sharedViewModel), (String)"model");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(function0, (String)"lmbd");
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
        Constants$SavedItems constants$SavedItems = Constants$SavedItems.CONF_NAME;
        String string = constants$SavedItems.getText();
        String string2 = "conf.json";
        String string3 = sharedPreferences.getString(string, string2);
        if (string3 == null) {
            string3 = string2;
        }
        Constants$SavedItems constants$SavedItems2 = Constants$SavedItems.CONF_DATE_EXP;
        Date date = new Date(sharedPreferences.getLong(constants$SavedItems2.getText(), 0L));
        boolean bl = Intrinsics.areEqual((Object)string3, (Object)string2);
        boolean bl2 = true;
        if (!bl && date.before(new Date())) {
            String string4;
            String string5;
            SharedPreferences.Editor editor;
            block11 : {
                Intrinsics.checkNotNullExpressionValue((Object)sharedPreferences, (String)"sharedPref");
                Intrinsics.checkNotNullParameter((Object)sharedPreferences, (String)"sharedPref");
                editor = sharedPreferences.edit();
                editor.putString(constants$SavedItems.getText(), string2);
                editor.putLong(constants$SavedItems2.getText(), 0L);
                editor.remove(Constants$SavedItems.CURRENT_TOKEN.getText());
                string5 = Constants$SavedItems.CURRENT_SIREN.getText();
                try {
                    string4 = new JWT("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqUG0zZ1BzUlZaMWRRUmhHOG1HMGhFN3Jlb2ZXTTNINzJCV1RtajdJcFd3In0.eyJleHAiOjE2ODUxODU5MDYsImlhdCI6MTYyMjExMzkwNiwianRpIjoiOTdjODgyM2EtNjlhZS00NzA4LWE4N2UtNzYxM2NhNGU3ODU5IiwiaXNzIjoiaHR0cHM6Ly9hdXRoLm1lc3NlcnZpY2VzLmluZ3JvdXBlLmNvbS9hdXRoL3JlYWxtcy9QSU5HIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImVhMWY1NWVlLTUxMGMtNGMxNi05MWQ4LTE1MjI4OGJhZDViYSIsInR5cCI6IkJlYXJlciIsImF6cCI6InRhY3YtY2xpZW50LWxpdGUiLCJzZXNzaW9uX3N0YXRlIjoiNjk5ODExY2YtODFlZS00ZmNkLTk4NDctY2FkMGJmYjZhOTdiIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJST0xFX1ZFUklGWV9DT05UUk9MXzJERE9DX0wxIiwiUk9MRV9WRVJJRllfQ09OVFJPTF8yRERPQ19CMiIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUgb2ZmbGluZV9hY2Nlc3MiLCJzaXJlbiI6IjAwMDAwMDAwMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidGFjdi1tb2JpbGUtbGl0ZSIsImdpdmVuX25hbWUiOiIiLCJmYW1pbHlfbmFtZSI6IiJ9.mpfrIP8ayElTm7yoVayCF11oYrDQEnauk9hbbVBw8idAiE6OsMlWNloZtUbbnwrJZsMX3_NoEyzkiB3HNbxyhPWp7eRZ7qhn8XjZVgg6sVytXqcVZo9R5-Q9JftMKv7JelsY3PsaOo5x-pYOX30ancPRjd78TeenorGopsVN_LLRLQpenfgjjgwx-srZnLa-TFYTcbSvXozfJT7uk5CHyz_MIFLM7pl9Zdt66yTGBkLIyOLFsV5vPeH5SYvgRNDYdxZy4XMo6Gyfz0lAI9Xfcjs20NBoOQMV4JREH4Z-IcJJXeszC9QeA1-tRmxujqIRuyvBal7msLy7Zimd2q7i3Q").getClaim("siren").asString();
                    if (string4 != null) break block11;
                }
                catch (Exception exception) {
                    Log.d((String)"jwtUtils", (String)"Exception occurred: ", (Throwable)exception);
                }
                string4 = "000000000";
            }
            editor.putString(string5, string4);
            editor.putBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), bl2);
            editor.apply();
        } else {
            bl2 = false;
            string2 = string3;
        }
        ConfResult confResult = sharedViewModel.configuration;
        if (confResult != null) {
            Object object;
            ArrayList<ConfType> arrayList;
            ArrayList<ConfType> arrayList2 = confResult.getTypes();
            if (arrayList2 != null) {
                arrayList2.clear();
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
            ConfResult confResult2 = (ConfResult)object;
            if (confResult2 != null && (arrayList = confResult2.getTypes()) != null) {
                confResult.setTypes(arrayList);
            }
        }
        if (bl2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.P.mCancelable = false;
            String string6 = context.getString(2131820740);
            builder.P.mTitle = string6;
            String string7 = context.getString(2131820739);
            builder.P.mMessage = string7;
            builder.setPositiveButton((CharSequence)context.getString(2131820575), (DialogInterface.OnClickListener)new -$$Lambda$ScanPresenterImpl$HKmgv29g8ZLsbrs4QiD7mVTEoOY(context, function0));
            AlertDialog alertDialog = builder.create();
            Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(context)\n                .setCancelable(false)\n                .setTitle(context.getString(R.string.popup_licence_expired_title))\n                .setMessage(context.getString(R.string.popup_licence_expired_text))\n                .setPositiveButton(context.getString(R.string.action_ok)) { dialog, _ ->\n                    dialog.dismiss()\n                    (context as MainActivity).changeMode(true)\n                    lmbd()\n                }\n                .create()");
            alertDialog.show();
            return;
        }
        function0.invoke();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean checkQrCode(String string, Context context, SharedViewModel sharedViewModel) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"qrCode");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)sharedViewModel), (String)"model");
        Intrinsics.checkNotNullParameter((Object)string, (String)"token");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)((Object)sharedViewModel), (String)"model");
        try {
            JWT jWT = new JWT(string);
            if (!JWTUtils.checkSignature(string)) return false;
            if (jWT.isExpired(10L)) {
                return false;
            }
            Claim claim = jWT.getClaim("realm_access");
            Intrinsics.checkNotNullExpressionValue((Object)claim, (String)"jwt.getClaim(\"realm_access\")");
            Map map = claim.asObject(Map.class);
            Object object = null;
            Object object2 = map == null ? null : map.get((Object)"roles");
            if (!(object2 instanceof ArrayList)) {
                return false;
            }
            if (!((Collection)object2).containsAll((Collection)R.style.listOf((Object)"ROLE_TACV_CONTROL_OT"))) {
                return false;
            }
            String string2 = jWT.getClaim("siren").asString();
            if (string2 == null) {
                return false;
            }
            SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
            try {
                InputStream inputStream = context.getAssets().open("confOT.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new JWTUtils$Companion$decodeJWTAndUpdatePrefs$$inlined$loadFromAsset$1().type;
                Object object3 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
                object = object3;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            sharedViewModel.configuration = (ConfResult)object;
            if (sharedPreferences == null) {
                return true;
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Constants$SavedItems.CONF_NAME.getText(), "confOT.json");
            String string3 = Constants$SavedItems.CONF_DATE_EXP.getText();
            Date date = jWT.payload.exp;
            long l2 = date == null ? 0L : date.getTime();
            editor.putLong(string3, l2);
            editor.putString(Constants$SavedItems.CURRENT_TOKEN.getText(), string);
            editor.putString(Constants$SavedItems.CURRENT_SIREN.getText(), string2);
            editor.putBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), true);
            editor.apply();
            return true;
        }
        catch (Exception exception) {
            Log.d((String)"jwtUtils", (String)"Exception occurred: ", (Throwable)exception);
        }
        return false;
    }

    @Override
    public void on2dDocDetected(Context context, String string) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)string, (String)"result2DDoc");
        try {
            this.view.showResult(DocOfflineService.getDocumentBy2DDoc(string, context));
            return;
        }
        catch (Exception exception) {
            Log.e((String)"Scan2DDocP", (String)"KO :", (Throwable)exception);
            this.view.showErrorMessage(2131820626, 2131820628);
            return;
        }
    }
}

