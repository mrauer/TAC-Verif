/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.preference.PreferenceManager
 *  android.util.Base64
 *  android.view.ContextThemeWrapper
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.google.gson.Gson
 *  com.ingroupe.verify.anticovid.MainActivity
 *  com.ingroupe.verify.anticovid.databinding.PopupSynchronizationNeededBinding
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$saveSynchronization
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$saveSynchronization$2
 *  com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils$saveSynchronization$3
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.security.PublicKey
 *  java.security.cert.X509Certificate
 *  java.util.Date
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  kotlinx.coroutines.CoroutineDispatcher
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 */
package com.ingroupe.verify.anticovid.synchronization;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.gson.Gson;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.Constants$Criticity;
import com.ingroupe.verify.anticovid.common.Constants$SpecificList;
import com.ingroupe.verify.anticovid.common.Constants$SpecificValues;
import com.ingroupe.verify.anticovid.common.Constants$Step;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.databinding.PopupSynchronizationNeededBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncBlacklist;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncBlacklistMessage;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncMessage;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncPeriod;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncSpecificValues;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncTutorial;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncValidity;
import com.ingroupe.verify.anticovid.synchronization.-$$Lambda$SynchronisationUtils$CuVaixEl5WrIw9RkpoHKJdoFUCI;
import com.ingroupe.verify.anticovid.synchronization.-$$Lambda$SynchronisationUtils$TEVauuPq2d-ihMT9UBGTJtfJ7tg;
import com.ingroupe.verify.anticovid.synchronization.-$$Lambda$SynchronisationUtils$p-yKyUvtD_B4tKuBP5MtPRuX_48;
import com.ingroupe.verify.anticovid.synchronization.ConfServiceUtils;
import com.ingroupe.verify.anticovid.synchronization.SynchronisationUtils;
import com.ingroupe.verify.anticovid.synchronization.elements.Blacklist;
import com.ingroupe.verify.anticovid.synchronization.elements.CertificateDcc;
import com.ingroupe.verify.anticovid.synchronization.elements.PublicKey2ddoc;
import dalvik.annotation.SourceDebugExtension;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@SourceDebugExtension(value="SMAP\nSynchronisationUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SynchronisationUtils.kt\ncom/ingroupe/verify/anticovid/synchronization/SynchronisationUtils\n+ 2 ContextUtils.kt\norg/jetbrains/anko/ContextUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequestKt\n*L\n1#1,247:1\n45#2:248\n45#2:249\n45#2:250\n45#2:251\n45#2:252\n45#2:253\n45#2:256\n1#3:254\n33#4:255\n*S KotlinDebug\n*F\n+ 1 SynchronisationUtils.kt\ncom/ingroupe/verify/anticovid/synchronization/SynchronisationUtils\n*L\n77#1:248\n113#1:249\n138#1:250\n144#1:251\n149#1:252\n169#1:253\n103#1:256\n230#1:255\n*E\n")
public final class SynchronisationUtils {
    public static final SynchronisationUtils INSTANCE = new SynchronisationUtils();

    public final void checkStep(Context context, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        int n2 = this.getCurrentStep(context);
        if (n2 != 1) {
            if (n2 != 2 && n2 != 3) {
                return;
            }
            if (context instanceof MainActivity) {
                MainActivity mainActivity = (MainActivity)context;
                String string = context.getString(2131820822);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"context.getString(R.string.snackbar_sync_needed_line_1)");
                mainActivity.showSnackBar("SNACKBAR_CERT", string, null, Constants$Criticity.CRITICAL, (View.OnClickListener)new -$$Lambda$SynchronisationUtils$p-yKyUvtD_B4tKuBP5MtPRuX_48(context));
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
                Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
                long l2 = sharedPreferences.getLong("HIDE_SYNC_WARNING_DATE", new Date(0L).getTime());
                boolean bl2 = TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - l2) <= 60L;
                if (!bl2 && bl) {
                    this.showPopup(context, true);
                    return;
                }
            }
        } else if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity)context;
            String string = context.getString(2131820822);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"context.getString(R.string.snackbar_sync_needed_line_1)");
            mainActivity.showSnackBar("SNACKBAR_CERT", string, null, Constants$Criticity.INFO, (View.OnClickListener)new -$$Lambda$SynchronisationUtils$TEVauuPq2d-ihMT9UBGTJtfJ7tg(context));
        }
    }

    public final int getCurrentStep(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        long l2 = this.getPeriodSinceLastSynch(context);
        if (l2 < this.getStep(context, Constants$Step.CERT_STEP_1)) {
            return 0;
        }
        if (l2 < this.getStep(context, Constants$Step.CERT_STEP_2)) {
            return 1;
        }
        if (l2 < this.getStep(context, Constants$Step.CERT_STEP_3)) {
            return 2;
        }
        return 3;
    }

    public final Date getDateLastSynchronization(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
        return new Date(sharedPreferences.getLong("LAST_SYNC_DATE_V1_8_1", 0L));
    }

    public final long getPeriodSinceLastSynch(Context context) {
        Date date = this.getDateLastSynchronization(context);
        return TimeUnit.MILLISECONDS.toHours(new Date().getTime() - date.getTime());
    }

    public final long getStep(Context context, Constants$Step constants$Step) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
        return sharedPreferences.getLong(constants$Step.getText(), constants$Step.getDefault());
    }

    public final boolean isSyncNeeded(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return this.getStep(context, Constants$Step.CERT_FREQUENCY) < this.getPeriodSinceLastSynch(context);
    }

    public final void saveSynchronization(SyncResult syncResult, Context context, SyncListener syncListener, ConfServiceUtils.ConfServiceListener confServiceListener, String string, boolean bl) {
        Boolean bl2;
        Long l2;
        Long l3;
        String string2;
        SyncMessage syncMessage;
        SyncBlacklistMessage syncBlacklistMessage;
        SyncMessage syncMessage2;
        String string3;
        SyncPeriod syncPeriod;
        SyncBlacklistMessage syncBlacklistMessage2;
        SyncPeriod syncPeriod2;
        String string4;
        SyncMessage syncMessage3;
        SyncBlacklistMessage syncBlacklistMessage3;
        Long l4;
        SyncBlacklistMessage syncBlacklistMessage4;
        SyncBlacklistMessage syncBlacklistMessage5;
        String string5;
        SyncMessage syncMessage4;
        String string6;
        SyncSpecificValues syncSpecificValues;
        SyncMessage syncMessage5;
        String string7;
        SyncSpecificValues syncSpecificValues2;
        SyncMessage syncMessage6;
        SyncBlacklistMessage syncBlacklistMessage6;
        String string8;
        SyncBlacklistMessage syncBlacklistMessage7;
        String string9;
        SyncMessage syncMessage7;
        List<String> list;
        List<String> list2;
        SyncMessage syncMessage8;
        String string10;
        SyncBlacklistMessage syncBlacklistMessage8;
        String string11;
        String string12;
        SyncMessage syncMessage9;
        Long l5;
        SyncBlacklistMessage syncBlacklistMessage9;
        SyncBlacklistMessage syncBlacklistMessage10;
        SyncMessage syncMessage10;
        SyncBlacklistMessage syncBlacklistMessage11;
        Long l6;
        SyncPeriod syncPeriod3;
        SyncMessage syncMessage11;
        SyncPeriod syncPeriod4;
        SyncSpecificValues syncSpecificValues3;
        SyncBlacklistMessage syncBlacklistMessage12;
        String string13;
        SyncMessage syncMessage12;
        String string14;
        String string15;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)syncListener, (String)"listener");
        Intrinsics.checkNotNullParameter((Object)confServiceListener, (String)"serviceListener");
        Intrinsics.checkNotNullParameter((Object)string, (String)"tag");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        Intrinsics.checkExpressionValueIsNotNull((Object)sharedPreferences, (String)"PreferenceManager.getDef\u2026ltSharedPreferences(this)");
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        if (syncResult != null && (syncPeriod = syncResult.getPeriod()) != null && (l4 = syncPeriod.getFrequency()) != null) {
            long l7 = l4;
            editor.putLong(Constants$Step.CERT_FREQUENCY.getText(), l7);
        }
        if (syncResult != null && (syncPeriod2 = syncResult.getPeriod()) != null && (l3 = syncPeriod2.getStep1()) != null) {
            long l8 = l3;
            editor.putLong(Constants$Step.CERT_STEP_1.getText(), l8);
        }
        if (syncResult != null && (syncPeriod4 = syncResult.getPeriod()) != null && (l2 = syncPeriod4.getStep2()) != null) {
            long l9 = l2;
            editor.putLong(Constants$Step.CERT_STEP_2.getText(), l9);
        }
        if (syncResult != null && (syncPeriod3 = syncResult.getPeriod()) != null && (l6 = syncPeriod3.getStep3()) != null) {
            long l10 = l6;
            editor.putLong(Constants$Step.CERT_STEP_3.getText(), l10);
        }
        if (syncResult != null && (syncSpecificValues = syncResult.getSpecificValues()) != null) {
            SyncValidity syncValidity;
            Integer n2;
            Integer n3;
            SyncValidity syncValidity2;
            SyncValidity syncValidity3;
            Integer n4;
            Integer n5;
            Integer n6;
            SyncValidity syncValidity4;
            Integer n7;
            Integer n8;
            Integer n9;
            Integer n10;
            Integer n11;
            Integer n12;
            Integer n13;
            SyncValidity syncValidity5;
            Map<String, String> map;
            SyncValidity syncValidity6;
            SyncValidity syncValidity7;
            SyncValidity syncValidity8;
            SyncValidity syncValidity9;
            SyncValidity syncValidity10;
            SyncValidity syncValidity11;
            SyncValidity syncValidity12 = syncSpecificValues.getValidity();
            if (syncValidity12 != null && (n2 = syncValidity12.getRecoveryEndDay()) != null) {
                int n14 = n2;
                editor.putInt(Constants$SpecificValues.RECOVERY_END_DAY.getText(), n14);
            }
            if ((syncValidity6 = syncSpecificValues.getValidity()) != null && (n5 = syncValidity6.getRecoveryStartDay()) != null) {
                int n15 = n5;
                editor.putInt(Constants$SpecificValues.RECOVERY_START_DAY.getText(), n15);
            }
            if ((syncValidity2 = syncSpecificValues.getValidity()) != null && (n9 = syncValidity2.getTestNegativeAntigenicEndHour()) != null) {
                int n16 = n9;
                editor.putInt(Constants$SpecificValues.TEST_NEGATIVE_ANTIGENIC_END_HOUR.getText(), n16);
            }
            if ((syncValidity3 = syncSpecificValues.getValidity()) != null && (n10 = syncValidity3.getTestNegativePcrEndHour()) != null) {
                int n17 = n10;
                editor.putInt(Constants$SpecificValues.TEST_NEGATIVE_PCR_END_HOUR.getText(), n17);
            }
            if ((syncValidity = syncSpecificValues.getValidity()) != null && (n11 = syncValidity.getTestNegativePrimoAntigenicEndHour()) != null) {
                int n18 = n11;
                editor.putInt(Constants$SpecificValues.TEST_NEGATIVE_PRIMO_ANTIGENIC_END_HOUR.getText(), n18);
            }
            if ((syncValidity8 = syncSpecificValues.getValidity()) != null && (n3 = syncValidity8.getTestNegativePrimoPcrEndHour()) != null) {
                int n19 = n3;
                editor.putInt(Constants$SpecificValues.TEST_NEGATIVE_PRIMO_PCR_END_HOUR.getText(), n19);
            }
            if ((syncValidity5 = syncSpecificValues.getValidity()) != null && (n4 = syncValidity5.getTestPositiveAntigenicEndDay()) != null) {
                int n20 = n4;
                editor.putInt(Constants$SpecificValues.TEST_POSITIVE_ANTIGENIC_END_DAY.getText(), n20);
            }
            if ((syncValidity7 = syncSpecificValues.getValidity()) != null && (n6 = syncValidity7.getTestPositiveAntigenicStartDay()) != null) {
                int n21 = n6;
                editor.putInt(Constants$SpecificValues.TEST_POSITIVE_ANTIGENIC_START_DAY.getText(), n21);
            }
            if ((syncValidity11 = syncSpecificValues.getValidity()) != null && (n8 = syncValidity11.getTestPositivePcrEndDay()) != null) {
                int n22 = n8;
                editor.putInt(Constants$SpecificValues.TEST_POSITIVE_PCR_END_DAY.getText(), n22);
            }
            if ((syncValidity4 = syncSpecificValues.getValidity()) != null && (n13 = syncValidity4.getTestPositivePcrStartDay()) != null) {
                int n23 = n13;
                editor.putInt(Constants$SpecificValues.TEST_POSITIVE_PCR_START_DAY.getText(), n23);
            }
            if ((syncValidity9 = syncSpecificValues.getValidity()) != null && (n12 = syncValidity9.getVaccineDelay()) != null) {
                int n24 = n12;
                editor.putInt(Constants$SpecificValues.VACCINE_DELAY.getText(), n24);
            }
            if ((syncValidity10 = syncSpecificValues.getValidity()) != null && (n7 = syncValidity10.getVaccineDelayJanssen()) != null) {
                int n25 = n7;
                editor.putInt(Constants$SpecificValues.VACCINE_DELAY_JANSSEN.getText(), n25);
            }
            if ((map = syncSpecificValues.getTestAntigenicList()) != null) {
                editor.putString(Constants$SpecificList.TEST_ANTIGENIC.getText(), gson.toJson(map));
            }
            Map<String, String> map2 = syncSpecificValues.getTestPcrList();
            if (map2 != null) {
                editor.putString(Constants$SpecificList.TEST_PCR.getText(), gson.toJson(map2));
            }
            Map<String, String> map3 = syncSpecificValues.getTestManufacturerList();
            if (map3 != null) {
                editor.putString(Constants$SpecificList.TEST_MANUFACTURER.getText(), gson.toJson(map3));
            }
            Map<String, String> map4 = syncSpecificValues.getVaccineManufacturerList();
            if (map4 != null) {
                editor.putString(Constants$SpecificList.VACCINE_MANUFACTURER.getText(), gson.toJson(map4));
            }
            Map<String, String> map5 = syncSpecificValues.getVaccineMedicalProductList();
            if (map5 != null) {
                editor.putString(Constants$SpecificList.VACCINE_MEDICAL_PRODUCT.getText(), gson.toJson(map5));
            }
            Map<String, String> map6 = syncSpecificValues.getVaccineProphylaxisList();
            if (map6 != null) {
                editor.putString(Constants$SpecificList.VACCINE_PROPHYLAXIS.getText(), gson.toJson(map6));
            }
        }
        editor.putLong("LAST_SYNC_DATE_V1_8_1", new Date().getTime());
        editor.apply();
        Map<String, String> map = syncResult == null ? null : syncResult.getCertificatesDCC();
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.ingroupe.verify.CERTIFICATE_FILE_KEY", 0);
        int n26 = map == null ? 0 : map.size();
        if (n26 > 50) {
            SharedPreferences.Editor editor2 = sharedPreferences2.edit();
            editor2.clear();
            if (map != null) {
                for (String string16 : map.keySet()) {
                    byte[] arrby = Base64.decode((String)((String)map.get((Object)string16)), (int)2);
                    Intrinsics.checkNotNullExpressionValue((Object)arrby, (String)"decoded");
                    editor2.putString(string16, new String(arrby, Charsets.UTF_8));
                }
            }
            editor2.apply();
            CertificateDcc.certificateDccMap.clear();
        }
        Map<String, String> map7 = syncResult == null ? null : syncResult.getCertificates2DDoc();
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences.Editor editor3 = context.getSharedPreferences("com.ingroupe.verify.PUBLIC_KEY_FILE_KEY", 0).edit();
        editor3.clear();
        if (map7 != null) {
            for (String string17 : map7.keySet()) {
                editor3.putString(string17, (String)map7.get((Object)string17));
            }
        }
        editor3.apply();
        PublicKey2ddoc.publicKey2DDocMap.clear();
        SyncTutorial syncTutorial = syncResult == null || (syncSpecificValues2 = syncResult.getSpecificValues()) == null ? null : syncSpecificValues2.getTutorial();
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.ingroupe.verify.TUTORIAL_KEY", 0);
        Locale locale = Locale.FRENCH;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue((Object)configuration, (String)"context.resources.configuration");
        Configuration configuration2 = new Configuration(configuration);
        configuration2.setLocale(locale);
        Resources resources = context.createConfigurationContext(configuration2).getResources();
        Intrinsics.checkNotNullExpressionValue((Object)resources, (String)"localizedContext.resources");
        String string18 = resources.getString(2131820849);
        Intrinsics.checkNotNullExpressionValue((Object)string18, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(R.string.tuto_result_lite_key)");
        Locale locale2 = Locale.ENGLISH;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Configuration configuration3 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue((Object)configuration3, (String)"context.resources.configuration");
        Configuration configuration4 = new Configuration(configuration3);
        configuration4.setLocale(locale2);
        Resources resources2 = context.createConfigurationContext(configuration4).getResources();
        Intrinsics.checkNotNullExpressionValue((Object)resources2, (String)"localizedContext.resources");
        String string19 = resources2.getString(2131820849);
        Intrinsics.checkNotNullExpressionValue((Object)string19, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(R.string.tuto_result_lite_key)");
        SharedPreferences.Editor editor4 = sharedPreferences3.edit();
        if (syncTutorial != null && (string5 = syncTutorial.getLiteFR()) != null) {
            editor4.putString(string18, string5);
        }
        if (syncTutorial != null && (string11 = syncTutorial.getLiteEN()) != null) {
            editor4.putString(string19, string11);
        }
        editor4.apply();
        SyncBlacklist syncBlacklist = syncResult == null ? null : ((syncSpecificValues3 = syncResult.getSpecificValues()) == null ? null : syncSpecificValues3.getBlacklist());
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences4 = context.getSharedPreferences("com.ingroupe.verify.BLACKLIST_KEY", 0);
        Utils.Companion companion = Utils.Companion;
        Resources resources3 = companion.getLocalizedResources(context, Locale.FRENCH);
        Blacklist.Message message = Blacklist.Message.BLACKLIST_LITE;
        String string20 = resources3.getString(message.getKeyTitle());
        Intrinsics.checkNotNullExpressionValue((Object)string20, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(Message.BLACKLIST_LITE.keyTitle)");
        String string21 = companion.getLocalizedResources(context, Locale.FRENCH).getString(message.getKeyDetail());
        Intrinsics.checkNotNullExpressionValue((Object)string21, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(Message.BLACKLIST_LITE.keyDetail)");
        String string22 = companion.getLocalizedResources(context, locale2).getString(message.getKeyTitle());
        Intrinsics.checkNotNullExpressionValue((Object)string22, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(Message.BLACKLIST_LITE.keyTitle)");
        String string23 = companion.getLocalizedResources(context, locale2).getString(message.getKeyDetail());
        Intrinsics.checkNotNullExpressionValue((Object)string23, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(Message.BLACKLIST_LITE.keyDetail)");
        Resources resources4 = companion.getLocalizedResources(context, Locale.FRENCH);
        Blacklist.Message message2 = Blacklist.Message.BLACKLIST_OT;
        String string24 = resources4.getString(message2.getKeyTitle());
        Intrinsics.checkNotNullExpressionValue((Object)string24, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(Message.BLACKLIST_OT.keyTitle)");
        String string25 = companion.getLocalizedResources(context, Locale.FRENCH).getString(message2.getKeyDetail());
        Intrinsics.checkNotNullExpressionValue((Object)string25, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(Message.BLACKLIST_OT.keyDetail)");
        String string26 = companion.getLocalizedResources(context, locale2).getString(message2.getKeyTitle());
        Intrinsics.checkNotNullExpressionValue((Object)string26, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(Message.BLACKLIST_OT.keyTitle)");
        String string27 = companion.getLocalizedResources(context, locale2).getString(message2.getKeyDetail());
        Intrinsics.checkNotNullExpressionValue((Object)string27, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(Message.BLACKLIST_OT.keyDetail)");
        Resources resources5 = companion.getLocalizedResources(context, Locale.FRENCH);
        Blacklist.Message message3 = Blacklist.Message.DUPLICATE;
        String string28 = resources5.getString(message3.getKeyTitle());
        Intrinsics.checkNotNullExpressionValue((Object)string28, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(Message.DUPLICATE.keyTitle)");
        String string29 = companion.getLocalizedResources(context, Locale.FRENCH).getString(message3.getKeyDetail());
        Intrinsics.checkNotNullExpressionValue((Object)string29, (String)"Utils.getLocalizedResources(context, Locale.FRENCH).getString(Message.DUPLICATE.keyDetail)");
        String string30 = companion.getLocalizedResources(context, locale2).getString(message3.getKeyTitle());
        Intrinsics.checkNotNullExpressionValue((Object)string30, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(Message.DUPLICATE.keyTitle)");
        String string31 = companion.getLocalizedResources(context, locale2).getString(message3.getKeyDetail());
        Intrinsics.checkNotNullExpressionValue((Object)string31, (String)"Utils.getLocalizedResources(context, Locale.ENGLISH).getString(Message.DUPLICATE.keyDetail)");
        Gson gson2 = new Gson();
        SharedPreferences.Editor editor5 = sharedPreferences4.edit();
        editor5.clear();
        if (syncBlacklist != null && (syncBlacklistMessage2 = syncBlacklist.getMessages()) != null && (syncMessage2 = syncBlacklistMessage2.getBlacklistLite()) != null && (string13 = syncMessage2.getTitleFR()) != null) {
            editor5.putString(string20, string13);
        }
        if (syncBlacklist != null && (syncBlacklistMessage12 = syncBlacklist.getMessages()) != null && (syncMessage12 = syncBlacklistMessage12.getBlacklistLite()) != null && (string15 = syncMessage12.getDetailFR()) != null) {
            editor5.putString(string21, string15);
        }
        if (syncBlacklist != null && (syncBlacklistMessage10 = syncBlacklist.getMessages()) != null && (syncMessage6 = syncBlacklistMessage10.getBlacklistLite()) != null && (string8 = syncMessage6.getTitleEN()) != null) {
            editor5.putString(string22, string8);
        }
        if (syncBlacklist != null && (syncBlacklistMessage4 = syncBlacklist.getMessages()) != null && (syncMessage11 = syncBlacklistMessage4.getBlacklistLite()) != null && (string3 = syncMessage11.getDetailEN()) != null) {
            editor5.putString(string23, string3);
        }
        if (syncBlacklist != null && (syncBlacklistMessage7 = syncBlacklist.getMessages()) != null && (syncMessage8 = syncBlacklistMessage7.getBlacklistOT()) != null && (string14 = syncMessage8.getTitleFR()) != null) {
            editor5.putString(string24, string14);
        }
        if (syncBlacklist != null && (syncBlacklistMessage11 = syncBlacklist.getMessages()) != null && (syncMessage4 = syncBlacklistMessage11.getBlacklistOT()) != null && (string6 = syncMessage4.getDetailFR()) != null) {
            editor5.putString(string25, string6);
        }
        if (syncBlacklist != null && (syncBlacklistMessage6 = syncBlacklist.getMessages()) != null && (syncMessage = syncBlacklistMessage6.getBlacklistOT()) != null && (string2 = syncMessage.getTitleEN()) != null) {
            editor5.putString(string26, string2);
        }
        if (syncBlacklist != null && (syncBlacklistMessage8 = syncBlacklist.getMessages()) != null && (syncMessage7 = syncBlacklistMessage8.getBlacklistOT()) != null && (string9 = syncMessage7.getDetailEN()) != null) {
            editor5.putString(string27, string9);
        }
        if (syncBlacklist != null && (syncBlacklistMessage = syncBlacklist.getMessages()) != null && (syncMessage5 = syncBlacklistMessage.getDuplicate()) != null && (string7 = syncMessage5.getTitleFR()) != null) {
            editor5.putString(string28, string7);
        }
        if (syncBlacklist != null && (syncBlacklistMessage3 = syncBlacklist.getMessages()) != null && (syncMessage3 = syncBlacklistMessage3.getDuplicate()) != null && (string4 = syncMessage3.getDetailFR()) != null) {
            editor5.putString(string29, string4);
        }
        if (syncBlacklist != null && (syncBlacklistMessage9 = syncBlacklist.getMessages()) != null && (syncMessage10 = syncBlacklistMessage9.getDuplicate()) != null && (string10 = syncMessage10.getTitleEN()) != null) {
            editor5.putString(string30, string10);
        }
        if (syncBlacklist != null && (syncBlacklistMessage5 = syncBlacklist.getMessages()) != null && (syncMessage9 = syncBlacklistMessage5.getDuplicate()) != null && (string12 = syncMessage9.getDetailEN()) != null) {
            editor5.putString(string31, string12);
        }
        if (syncBlacklist != null && (bl2 = syncBlacklist.getDuplicateActivate()) != null) {
            editor5.putBoolean("DUPLICATE_ACTIVATE", bl2.booleanValue());
        }
        if (syncBlacklist != null && (l5 = syncBlacklist.getDuplicateRetentionPeriod()) != null) {
            editor5.putLong("DUPLICATE_RETENTION_PERIOD", l5.longValue());
        }
        if (syncBlacklist != null && (list2 = syncBlacklist.getBlacklistDCC()) != null) {
            editor5.putString(Blacklist.BlacklistType.BLACKLIST_DCC.getText(), gson2.toJson(list2));
        }
        if (syncBlacklist != null && (list = syncBlacklist.getBlacklist2DDOC()) != null) {
            editor5.putString(Blacklist.BlacklistType.BLACKLIST_2DDOC.getText(), gson2.toJson(list));
        }
        editor5.apply();
        if (context instanceof MainActivity) {
            ((MainActivity)context).hideSnackBar("SNACKBAR_CERT");
        }
        syncListener.onSynchronizationDone();
        CoroutineDispatcher coroutineDispatcher = Dispatchers.Default;
        CoroutineScope coroutineScope = R.style.CoroutineScope((CoroutineContext)coroutineDispatcher);
        saveSynchronization.2 var203_158 = new saveSynchronization.2(context, confServiceListener, string, bl, null);
        R.style.launch$default((CoroutineScope)coroutineScope, null, null, (Function2)var203_158, (int)3, null);
        CoroutineScope coroutineScope2 = R.style.CoroutineScope((CoroutineContext)coroutineDispatcher);
        saveSynchronization.3 var206_160 = new saveSynchronization.3(context, confServiceListener, string, bl, null);
        R.style.launch$default((CoroutineScope)coroutineScope2, null, null, (Function2)var206_160, (int)3, null);
    }

    public final void showPopup(Context context, boolean bl) {
        TextView textView;
        TextView textView2;
        CheckBox checkBox;
        int n2;
        TextView textView3;
        View view = LayoutInflater.from((Context)context).inflate(2131492982, null, false);
        Button button = (Button)view.findViewById(n2 = 2131296360);
        if (button != null && (checkBox = (CheckBox)view.findViewById(n2 = 2131296378)) != null && (textView2 = (TextView)view.findViewById(n2 = 2131296833)) != null && (textView = (TextView)view.findViewById(n2 = 2131296834)) != null && (textView3 = (TextView)view.findViewById(n2 = 2131296835)) != null) {
            ScrollView scrollView = (ScrollView)view;
            PopupSynchronizationNeededBinding popupSynchronizationNeededBinding = new PopupSynchronizationNeededBinding(scrollView, button, checkBox, textView2, textView, textView3);
            Intrinsics.checkNotNullExpressionValue((Object)popupSynchronizationNeededBinding, (String)"inflate(LayoutInflater.from(context))");
            AlertDialog alertDialog = new AlertDialog.Builder((Context)new ContextThemeWrapper(context, 2131886082)).setView((View)scrollView).create();
            if (bl) {
                checkBox.setVisibility(0);
            } else {
                checkBox.setVisibility(8);
            }
            alertDialog.show();
            button.setOnClickListener((View.OnClickListener)new -$$Lambda$SynchronisationUtils$CuVaixEl5WrIw9RkpoHKJdoFUCI(popupSynchronizationNeededBinding, context, alertDialog));
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
    }

    public static interface SyncListener {
        public void onSynchronizationDone();
    }

}

