/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.AssetManager
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.widget.SwitchCompat
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.fragment.app.FragmentActivity
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  com.ingroupe.verify.anticovid.MainActivity
 *  com.ingroupe.verify.anticovid.SettingsChildFragment
 *  com.ingroupe.verify.anticovid.SettingsChildFragment$onViewCreated$lambda-8$lambda-7$lambda-5$lambda-4$
 *  com.ingroupe.verify.anticovid.SettingsChildFragment$onViewCreated$lambda-8$lambda-7$lambda-5$lambda-4$$inlined
 *  com.ingroupe.verify.anticovid.SettingsChildFragment$onViewCreated$lambda-8$lambda-7$lambda-5$lambda-4$$inlined$loadFromAsset
 *  com.ingroupe.verify.anticovid.SettingsChildFragment$onViewCreated$lambda-8$lambda-7$lambda-5$lambda-4$$inlined$loadFromAsset$1
 *  com.ingroupe.verify.anticovid.common.SharedViewModel
 *  com.ingroupe.verify.anticovid.databinding.SettingsMainBinding
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.SettingsChildFragment;
import com.ingroupe.verify.anticovid.SettingsChildFragment$onViewCreated$lambda-8$lambda-7$lambda-5$lambda-4$;
import com.ingroupe.verify.anticovid.common.-$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.databinding.SettingsMainBinding;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$SettingsChildFragment$az1ZepHNOkIhmdiO5LDJcDXCEDo
implements View.OnClickListener {
    public final /* synthetic */ SharedPreferences f$0;
    public final /* synthetic */ AlertDialog f$1;
    public final /* synthetic */ SettingsChildFragment f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ -$$Lambda$SettingsChildFragment$az1ZepHNOkIhmdiO5LDJcDXCEDo(SharedPreferences sharedPreferences, AlertDialog alertDialog, SettingsChildFragment settingsChildFragment, Context context) {
        this.f$0 = sharedPreferences;
        this.f$1 = alertDialog;
        this.f$2 = settingsChildFragment;
        this.f$3 = context;
    }

    public final void onClick(View view) {
        String string;
        String string2;
        Context context;
        SharedPreferences.Editor editor;
        SharedPreferences sharedPreferences;
        AlertDialog alertDialog;
        SettingsChildFragment settingsChildFragment;
        block5 : {
            sharedPreferences = this.f$0;
            alertDialog = this.f$1;
            settingsChildFragment = this.f$2;
            context = this.f$3;
            Intrinsics.checkNotNullParameter((Object)alertDialog, (String)"$dialogDeactivateOTMode");
            Intrinsics.checkNotNullParameter((Object)settingsChildFragment, (String)"this$0");
            Intrinsics.checkNotNullParameter((Object)context, (String)"$c");
            Intrinsics.checkNotNullParameter((Object)sharedPreferences, (String)"sharedPref");
            editor = sharedPreferences.edit();
            editor.putString(Constants$SavedItems.CONF_NAME.getText(), "conf.json");
            editor.putLong(Constants$SavedItems.CONF_DATE_EXP.getText(), 0L);
            editor.remove(Constants$SavedItems.CURRENT_TOKEN.getText());
            string2 = Constants$SavedItems.CURRENT_SIREN.getText();
            try {
                string = new JWT("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqUG0zZ1BzUlZaMWRRUmhHOG1HMGhFN3Jlb2ZXTTNINzJCV1RtajdJcFd3In0.eyJleHAiOjE2ODUxODU5MDYsImlhdCI6MTYyMjExMzkwNiwianRpIjoiOTdjODgyM2EtNjlhZS00NzA4LWE4N2UtNzYxM2NhNGU3ODU5IiwiaXNzIjoiaHR0cHM6Ly9hdXRoLm1lc3NlcnZpY2VzLmluZ3JvdXBlLmNvbS9hdXRoL3JlYWxtcy9QSU5HIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImVhMWY1NWVlLTUxMGMtNGMxNi05MWQ4LTE1MjI4OGJhZDViYSIsInR5cCI6IkJlYXJlciIsImF6cCI6InRhY3YtY2xpZW50LWxpdGUiLCJzZXNzaW9uX3N0YXRlIjoiNjk5ODExY2YtODFlZS00ZmNkLTk4NDctY2FkMGJmYjZhOTdiIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJST0xFX1ZFUklGWV9DT05UUk9MXzJERE9DX0wxIiwiUk9MRV9WRVJJRllfQ09OVFJPTF8yRERPQ19CMiIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUgb2ZmbGluZV9hY2Nlc3MiLCJzaXJlbiI6IjAwMDAwMDAwMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidGFjdi1tb2JpbGUtbGl0ZSIsImdpdmVuX25hbWUiOiIiLCJmYW1pbHlfbmFtZSI6IiJ9.mpfrIP8ayElTm7yoVayCF11oYrDQEnauk9hbbVBw8idAiE6OsMlWNloZtUbbnwrJZsMX3_NoEyzkiB3HNbxyhPWp7eRZ7qhn8XjZVgg6sVytXqcVZo9R5-Q9JftMKv7JelsY3PsaOo5x-pYOX30ancPRjd78TeenorGopsVN_LLRLQpenfgjjgwx-srZnLa-TFYTcbSvXozfJT7uk5CHyz_MIFLM7pl9Zdt66yTGBkLIyOLFsV5vPeH5SYvgRNDYdxZy4XMo6Gyfz0lAI9Xfcjs20NBoOQMV4JREH4Z-IcJJXeszC9QeA1-tRmxujqIRuyvBal7msLy7Zimd2q7i3Q").getClaim("siren").asString();
                if (string != null) break block5;
            }
            catch (Exception exception) {
                Log.d((String)"jwtUtils", (String)"Exception occurred: ", (Throwable)exception);
            }
            string = "000000000";
        }
        editor.putString(string2, string);
        editor.putBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), true);
        editor.apply();
        SharedViewModel sharedViewModel = settingsChildFragment.model;
        Object object = null;
        if (sharedViewModel != null) {
            try {
                InputStream inputStream = context.getAssets().open("conf.json");
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"context.assets.open(fileName)");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                Type type = new SettingsChildFragment$onViewCreated$lambda-8$lambda-7$lambda-5$lambda-4$.inlined.loadFromAsset.1().type;
                Object object2 = new Gson().fromJson((Reader)inputStreamReader, type);
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"Gson().fromJson(isr, itemType)");
                inputStream.close();
                inputStreamReader.close();
                object = object2;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            sharedViewModel.configuration = (ConfResult)object;
            SettingsMainBinding settingsMainBinding = settingsChildFragment._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding);
            settingsMainBinding.constraintLayoutToken.setVisibility(8);
            ((MainActivity)context).changeMode(true);
            SharedPreferences.Editor editor2 = sharedPreferences.edit();
            editor2.putBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), true);
            editor2.apply();
            SettingsMainBinding settingsMainBinding2 = settingsChildFragment._binding;
            Intrinsics.checkNotNull((Object)settingsMainBinding2);
            settingsMainBinding2.switchTutoResult.setChecked(true);
            FragmentActivity fragmentActivity = settingsChildFragment.getActivity();
            Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
            String string3 = settingsChildFragment.getString(2131820803);
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getString(R.string.settings_change_saved)");
            Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"text");
            fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo((Activity)fragmentActivity, string3, 0));
            alertDialog.dismiss();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"model");
        throw null;
    }
}

