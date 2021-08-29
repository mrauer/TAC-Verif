/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment$onCodeScanned
 *  com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment$onCodeScanned$1
 *  com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment$onCodeScanned$4
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.Objects
 *  java.util.Set
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.ingroupe.verify.anticovid.ui.scan;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.R;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.camera.DataCaptureManager;
import com.ingroupe.verify.anticovid.camera.ScanViewModel;
import com.ingroupe.verify.anticovid.common.-$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.FeatureFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;
import com.ingroupe.verify.anticovid.ui.scan.-$$Lambda$ScanChildFragment$5WUoL4jvi-v2iV8UR00yDa6FBjA;
import com.ingroupe.verify.anticovid.ui.scan.-$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk;
import com.ingroupe.verify.anticovid.ui.scan.-$$Lambda$ScanChildFragment$yxDyaMRhxuAIptJsEuNfAa-mm9M;
import com.ingroupe.verify.anticovid.ui.scan.ScanChildFragment;
import com.ingroupe.verify.anticovid.ui.scan.ScanPresenter;
import com.ingroupe.verify.anticovid.ui.scan.ScanPresenterImpl;
import com.ingroupe.verify.anticovid.ui.scan.ScanView;
import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureProxyAdapter;
import com.scandit.datacapture.barcode.data.Barcode;
import com.scandit.datacapture.barcode.data.BarcodeProxyAdapter;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeBarcode;
import com.scandit.datacapture.barcode.ui.overlay.BarcodeCaptureOverlay;
import com.scandit.datacapture.barcode.ui.overlay.BarcodeCaptureOverlay$Companion$a;
import com.scandit.datacapture.barcode.ui.overlay.BarcodeCaptureOverlayProxyAdapter;
import com.scandit.datacapture.core.capture.DataCaptureContext;
import com.scandit.datacapture.core.capture.DataCaptureContextProxyAdapter;
import com.scandit.datacapture.core.common.geometry.Anchor;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.module.ui.control.ControlLayout;
import com.scandit.datacapture.core.internal.module.ui.control.TorchButton;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusPresenter;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.NativeDataCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.overlay.ViewBasedDataCaptureOverlay;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeRectangularViewfinder;
import com.scandit.datacapture.core.internal.sdk.ui.viewfinder.NativeViewfinder;
import com.scandit.datacapture.core.source.Camera;
import com.scandit.datacapture.core.source.FrameSource;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.core.ui.DataCaptureView;
import com.scandit.datacapture.core.ui.DataCaptureViewProxyAdapter;
import com.scandit.datacapture.core.ui.control.TorchSwitchControl;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderLineStyle;
import com.scandit.datacapture.core.ui.viewfinder.RectangularViewfinderStyle;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import dalvik.annotation.SourceDebugExtension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@SourceDebugExtension(value="SMAP\nScanChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanChildFragment.kt\ncom/ingroupe/verify/anticovid/ui/scan/ScanChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,313:1\n1#2:314\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b@\u0010!J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\"\u0010!J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0016\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020(H\u0016\u00a2\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u000100H\u0016\u00a2\u0006\u0004\b2\u00103R\u0016\u00104\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00105R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006A"}, d2={"Lcom/ingroupe/verify/anticovid/ui/scan/ScanChildFragment;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "Lcom/ingroupe/verify/anticovid/ui/scan/ScanView;", "Lcom/ingroupe/verify/anticovid/camera/ScanViewModel$ResultListener;", "", "getTitle", "()Ljava/lang/String;", "", "getTitleId", "()Ljava/lang/Integer;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "createOptionsMenu", "(Landroid/view/Menu;)V", "Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "showNavigation", "()Lcom/ingroupe/verify/anticovid/MainActivity$NavigationIcon;", "onResume", "()V", "onPause", "Landroid/view/MenuItem;", "item", "", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Lcom/ingroupe/verify/anticovid/service/document/model/DocumentResult;", "response", "showResult", "(Lcom/ingroupe/verify/anticovid/service/document/model/DocumentResult;)V", "title", "message", "showErrorMessage", "(II)V", "Lcom/scandit/datacapture/barcode/data/Barcode;", "barcodeResult", "onCodeScanned", "(Lcom/scandit/datacapture/barcode/data/Barcode;)V", "isShowingPopup", "Z", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "model", "Lcom/ingroupe/verify/anticovid/common/SharedViewModel;", "Lcom/ingroupe/verify/anticovid/camera/ScanViewModel;", "viewModel", "Lcom/ingroupe/verify/anticovid/camera/ScanViewModel;", "isCallingWS", "Lcom/ingroupe/verify/anticovid/ui/scan/ScanPresenter;", "presenter", "Lcom/ingroupe/verify/anticovid/ui/scan/ScanPresenter;", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class ScanChildFragment
extends FeatureChildFragment
implements ScanView,
ScanViewModel.ResultListener {
    public static final /* synthetic */ int $r8$clinit;
    public boolean isCallingWS;
    public boolean isShowingPopup;
    public SharedViewModel model;
    public ScanPresenter presenter;
    public ScanViewModel viewModel;

    @Override
    public void createOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter((Object)menu, (String)"menu");
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        MenuInflater menuInflater = fragmentActivity.getMenuInflater();
        if (menuInflater == null) {
            return;
        }
        menuInflater.inflate(2131558402, menu);
    }

    @Override
    public String getTitle() {
        return "Scan du 2D-Doc";
    }

    @Override
    public Integer getTitleId() {
        return 2131820843;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onCodeScanned(Barcode barcode) {
        if (this.isCallingWS || this.isShowingPopup) return;
        Symbology symbology = barcode.a.a.getSymbology();
        Intrinsics.checkNotNullExpressionValue((Object)((Object)symbology), (String)"_0");
        if (symbology != Symbology.DATA_MATRIX) {
            TextView textView;
            int n2;
            Boolean bl;
            Context context;
            Boolean bl2;
            this.isCallingWS = true;
            Context context2 = this.getContext();
            if (context2 == null) {
                bl2 = null;
            } else {
                Intrinsics.checkNotNullParameter((Object)context2, (String)"context");
                SharedPreferences sharedPreferences = ((Activity)context2).getPreferences(0);
                String string = sharedPreferences == null ? null : sharedPreferences.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                boolean bl3 = string != null;
                bl2 = bl3;
            }
            Boolean bl4 = Boolean.FALSE;
            Symbology symbology2 = barcode.a.a.getSymbology();
            Intrinsics.checkNotNullExpressionValue((Object)((Object)symbology2), (String)"_0");
            if (symbology2 == Symbology.QR && barcode.getData() != null && (context = this.getContext()) != null) {
                FragmentActivity fragmentActivity;
                SharedViewModel sharedViewModel;
                String string = barcode.getData();
                Intrinsics.checkNotNull((Object)string);
                Intrinsics.checkNotNullParameter((Object)"^HC[0-9]:", (String)"pattern");
                Pattern pattern = Pattern.compile((String)"^HC[0-9]:");
                Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"Pattern.compile(pattern)");
                Intrinsics.checkNotNullParameter((Object)pattern, (String)"nativePattern");
                Intrinsics.checkNotNullParameter((Object)string, (String)"input");
                if (pattern.matcher((CharSequence)string).find()) {
                    DocumentResult documentResult;
                    ScanPresenter scanPresenter = this.presenter;
                    if (scanPresenter == null) {
                        documentResult = null;
                    } else {
                        String string2 = barcode.getData();
                        Intrinsics.checkNotNull((Object)string2);
                        documentResult = scanPresenter.checkDcc(string2, context);
                    }
                    if (documentResult != null) {
                        ScanPresenter scanPresenter2 = this.presenter;
                        if (scanPresenter2 == null) {
                            return;
                        }
                        SharedViewModel sharedViewModel2 = this.model;
                        if (sharedViewModel2 != null) {
                            scanPresenter2.checkExpirationAndDo(sharedViewModel2, context, new Function0<Unit>(this, documentResult){
                                public final /* synthetic */ DocumentResult $dcc;
                                public final /* synthetic */ ScanChildFragment this$0;
                                {
                                    this.this$0 = scanChildFragment;
                                    this.$dcc = documentResult;
                                    super(0);
                                }

                                public Object invoke() {
                                    this.this$0.showResult(this.$dcc);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                        throw null;
                    }
                }
                if ((sharedViewModel = (fragmentActivity = this.getActivity()) == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class)) == null) throw new Exception("Invalid Activity");
                this.model = sharedViewModel;
                ScanPresenter scanPresenter = this.presenter;
                if (scanPresenter == null) {
                    bl4 = null;
                } else {
                    String string3 = barcode.getData();
                    Intrinsics.checkNotNull((Object)string3);
                    SharedViewModel sharedViewModel3 = this.model;
                    if (sharedViewModel3 != null) {
                        bl4 = scanPresenter.checkQrCode(string3, context, sharedViewModel3);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException((String)"model");
                        throw null;
                    }
                }
            }
            if (!Intrinsics.areEqual((Object)bl4, (Object)(bl = Boolean.TRUE))) {
                this.isCallingWS = false;
                FragmentActivity fragmentActivity = this.getActivity();
                Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                String string = this.getString(2131820798);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(R.string.scan_not_2ddoc)");
                Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                Intrinsics.checkNotNullParameter((Object)string, (String)"text");
                fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo((Activity)fragmentActivity, string, 0));
                ScanViewModel scanViewModel = this.viewModel;
                if (scanViewModel == null) {
                    return;
                }
                scanViewModel.resumeScanning();
                return;
            }
            if (Intrinsics.areEqual((Object)bl2, (Object)bl)) {
                Context context3 = this.getContext();
                if (context3 == null) {
                    return;
                }
                this.isCallingWS = false;
                Activity activity = (Activity)context3;
                Object[] arrobject = new Object[1];
                Intrinsics.checkNotNullParameter((Object)context3, (String)"context");
                SharedPreferences sharedPreferences = activity.getPreferences(0);
                long l2 = sharedPreferences == null ? 0L : sharedPreferences.getLong(Constants$SavedItems.CONF_DATE_EXP.getText(), 0L);
                long l3 = (l2 - new Date().getTime()) / (long)86400000;
                int n3 = l3 < 0L ? 0 : (int)l3;
                arrobject[0] = n3;
                String string = this.getString(2131820801, arrobject);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(R.string.scan_toast_ot_mode_updated, JWTUtils.daysBeforeExpiration(c))");
                Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
                Intrinsics.checkNotNullParameter((Object)string, (String)"text");
                activity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo(activity, string, 1));
                ScanViewModel scanViewModel = this.viewModel;
                if (scanViewModel == null) {
                    return;
                }
                scanViewModel.resumeScanning();
                return;
            }
            this.isShowingPopup = true;
            View view = LayoutInflater.from((Context)this.getContext()).inflate(2131492981, null, false);
            Button button = (Button)view.findViewById(n2 = 2131296360);
            if (button == null || (TextView)view.findViewById(n2 = 2131296824) == null || (textView = (TextView)view.findViewById(n2 = 2131296825)) == null || (TextView)view.findViewById(n2 = 2131296826) == null || (TextView)view.findViewById(n2 = 2131296827) == null) throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n2)));
            ScrollView scrollView = (ScrollView)view;
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)this.getActivity(), 2131886082));
            AlertController.AlertParams alertParams = builder.P;
            alertParams.mView = scrollView;
            alertParams.mViewLayoutResId = 0;
            AlertDialog alertDialog = builder.create();
            Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(\n            ContextThemeWrapper(\n                activity,\n                R.style.AlertDialogCustom\n            )\n        )\n            .setView(bindingOTModeDialog.root)\n            .create()");
            alertDialog.show();
            Object[] arrobject = new Object[1];
            Context context4 = this.requireContext();
            Intrinsics.checkNotNullExpressionValue((Object)context4, (String)"requireContext()");
            Intrinsics.checkNotNullParameter((Object)context4, (String)"context");
            SharedPreferences sharedPreferences = ((Activity)context4).getPreferences(0);
            long l4 = sharedPreferences == null ? 0L : sharedPreferences.getLong(Constants$SavedItems.CONF_DATE_EXP.getText(), 0L);
            long l5 = (l4 - new Date().getTime()) / (long)86400000;
            int n4 = l5 < 0L ? 0 : (int)l5;
            arrobject[0] = n4;
            textView.setText((CharSequence)this.getString(2131820742, arrobject));
            alertDialog.setOnDismissListener((DialogInterface.OnDismissListener)new -$$Lambda$ScanChildFragment$yxDyaMRhxuAIptJsEuNfAa-mm9M(this));
            button.setOnClickListener((View.OnClickListener)new -$$Lambda$ScanChildFragment$5WUoL4jvi-v2iV8UR00yDa6FBjA(alertDialog));
            return;
        }
        String string = barcode.getData();
        Intrinsics.checkNotNull((Object)string);
        if (string.length() >= 23) {
            String string4 = barcode.getData();
            Intrinsics.checkNotNull((Object)string4);
            if (!Intrinsics.areEqual((Object)string4.subSequence(20, 22), (Object)"B2")) {
                String string5 = barcode.getData();
                Intrinsics.checkNotNull((Object)string5);
                if (!Intrinsics.areEqual((Object)string5.subSequence(20, 22), (Object)"L1")) {
                    this.isCallingWS = false;
                    FragmentActivity fragmentActivity = this.getActivity();
                    Objects.requireNonNull((Object)fragmentActivity, (String)"null cannot be cast to non-null type android.app.Activity");
                    String string6 = this.getString(2131820799);
                    Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"getString(R.string.scan_not_2ddoc_B2_L1)");
                    Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
                    Intrinsics.checkNotNullParameter((Object)string6, (String)"text");
                    fragmentActivity.runOnUiThread((Runnable)new -$$Lambda$Utils$Companion$gOq9Lmt3MfopHcebK2r7KQQXwlo((Activity)fragmentActivity, string6, 0));
                    ScanViewModel scanViewModel = this.viewModel;
                    if (scanViewModel == null) {
                        return;
                    }
                    scanViewModel.resumeScanning();
                    return;
                }
            }
        }
        this.isCallingWS = true;
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel == null) throw new Exception("Invalid Activity");
        this.model = sharedViewModel;
        Context context = this.getContext();
        if (context == null) {
            return;
        }
        ScanPresenter scanPresenter = this.presenter;
        if (scanPresenter == null) {
            return;
        }
        SharedViewModel sharedViewModel4 = this.model;
        if (sharedViewModel4 != null) {
            scanPresenter.checkExpirationAndDo(sharedViewModel4, context, new Function0<Unit>(this, context, barcode){
                public final /* synthetic */ Barcode $barcodeResult;
                public final /* synthetic */ Context $c;
                public final /* synthetic */ ScanChildFragment this$0;
                {
                    this.this$0 = scanChildFragment;
                    this.$c = context;
                    this.$barcodeResult = barcode;
                    super(0);
                }

                public Object invoke() {
                    ScanPresenter scanPresenter = this.this$0.presenter;
                    if (scanPresenter != null) {
                        Context context = this.$c;
                        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"c");
                        String string = this.$barcodeResult.getData();
                        Intrinsics.checkNotNull((Object)string);
                        scanPresenter.on2dDocDetected(context, string);
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"model");
        throw null;
    }

    public void onCreate(Bundle bundle) {
        Fragment.super.onCreate(bundle);
        this.viewModel = (ScanViewModel)new ViewModelProvider((ViewModelStoreOwner)this).get(ScanViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        if (this.presenter == null) {
            this.presenter = new ScanPresenterImpl(this);
        }
        DataCaptureView.Companion companion = DataCaptureView.Companion;
        Context context = this.requireContext();
        Intrinsics.checkNotNullExpressionValue((Object)context, (String)"requireContext()");
        ScanViewModel scanViewModel = this.viewModel;
        DataCaptureContext dataCaptureContext = scanViewModel == null ? null : scanViewModel.dataCaptureManager.dataCaptureContext;
        Objects.requireNonNull((Object)companion);
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        DataCaptureView dataCaptureView = new DataCaptureView(context, dataCaptureContext, null, 0.0f, 12);
        dataCaptureView.setLogoAnchor(Anchor.BOTTOM_LEFT);
        Context context2 = this.requireContext();
        Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"requireContext()");
        TorchSwitchControl torchSwitchControl = new TorchSwitchControl(context2);
        Bitmap bitmap = TorchSwitchControl.a(2131165281);
        Intrinsics.checkNotNullParameter((Object)bitmap, (String)"value");
        boolean bl = Intrinsics.areEqual((Object)torchSwitchControl.c, (Object)bitmap);
        boolean bl2 = true;
        if (bl ^ bl2) {
            torchSwitchControl.c = bitmap;
            TorchButton torchButton = torchSwitchControl.b;
            torchButton.b(torchButton.a);
        }
        Bitmap bitmap2 = TorchSwitchControl.a(2131165280);
        Intrinsics.checkNotNullParameter((Object)bitmap2, (String)"value");
        if (bl2 ^ Intrinsics.areEqual((Object)torchSwitchControl.e, (Object)bitmap2)) {
            torchSwitchControl.e = bitmap2;
            TorchButton torchButton = torchSwitchControl.b;
            torchButton.b(torchButton.a);
        }
        Intrinsics.checkNotNullParameter((Object)torchSwitchControl, (String)"control");
        ControlLayout controlLayout = dataCaptureView.g;
        Objects.requireNonNull((Object)((Object)controlLayout));
        Intrinsics.checkNotNullParameter((Object)torchSwitchControl, (String)"control");
        controlLayout.b.add((Object)torchSwitchControl);
        TorchButton torchButton = torchSwitchControl.b;
        torchButton.setLayoutParams((ViewGroup.LayoutParams)ControlLayout.e);
        FrameSource frameSource = controlLayout.c;
        if (!(frameSource instanceof Camera)) {
            frameSource = null;
        }
        torchButton.a((Camera)frameSource);
        controlLayout.addView((View)torchButton);
        ScanViewModel scanViewModel2 = this.viewModel;
        BarcodeCapture barcodeCapture = scanViewModel2 == null ? null : scanViewModel2.dataCaptureManager.barcodeCapture;
        Intrinsics.checkNotNull((Object)barcodeCapture);
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"mode");
        BarcodeCaptureOverlay$Companion$a barcodeCaptureOverlay$Companion$a = BarcodeCaptureOverlay$Companion$a.a;
        Intrinsics.checkNotNullParameter((Object)barcodeCapture, (String)"mode");
        Intrinsics.checkNotNullParameter((Object)((Object)barcodeCaptureOverlay$Companion$a), (String)"lazyMessage");
        DataCaptureContext dataCaptureContext2 = barcodeCapture.a;
        DataCaptureContext dataCaptureContext3 = dataCaptureView.getDataCaptureContext();
        if (dataCaptureContext2 == null || dataCaptureContext3 == null || !(bl2 ^ Intrinsics.areEqual((Object)dataCaptureContext2.g.b, (Object)dataCaptureContext3.g.b))) {
            bl2 = false;
        }
        if (!bl2) {
            View view;
            BarcodeCaptureOverlay barcodeCaptureOverlay = new BarcodeCaptureOverlay(barcodeCapture, null);
            Intrinsics.checkNotNullParameter((Object)barcodeCaptureOverlay, (String)"overlay");
            Intrinsics.checkNotNullParameter((Object)barcodeCaptureOverlay, (String)"overlay");
            DataCaptureViewProxyAdapter dataCaptureViewProxyAdapter = dataCaptureView.v;
            Objects.requireNonNull((Object)dataCaptureViewProxyAdapter);
            Intrinsics.checkNotNullParameter((Object)barcodeCaptureOverlay, (String)"overlay");
            NativeDataCaptureOverlay nativeDataCaptureOverlay = barcodeCaptureOverlay.c.a;
            dataCaptureViewProxyAdapter.b.put(Reflection.getOrCreateKotlinClass(NativeDataCaptureOverlay.class), null, nativeDataCaptureOverlay, barcodeCaptureOverlay);
            dataCaptureViewProxyAdapter.a.addOverlay(nativeDataCaptureOverlay);
            dataCaptureView.d.add((Object)barcodeCaptureOverlay);
            if (barcodeCaptureOverlay instanceof ViewBasedDataCaptureOverlay && dataCaptureView.indexOfChild(view = (View)barcodeCaptureOverlay) == -1) {
                dataCaptureView.addView(view, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
                ((ViewBasedDataCaptureOverlay)((Object)barcodeCaptureOverlay))._setDataCaptureView(dataCaptureView);
            }
            RectangularViewfinderStyle rectangularViewfinderStyle = RectangularViewfinderStyle.SQUARE;
            RectangularViewfinderLineStyle rectangularViewfinderLineStyle = RectangularViewfinderLineStyle.LIGHT;
            Intrinsics.checkNotNullParameter((Object)((Object)rectangularViewfinderStyle), (String)"style");
            Intrinsics.checkNotNullParameter((Object)((Object)rectangularViewfinderLineStyle), (String)"lineStyle");
            NativeRectangularViewfinder nativeRectangularViewfinder = NativeRectangularViewfinder.createForStyles(rectangularViewfinderStyle, rectangularViewfinderLineStyle);
            Intrinsics.checkNotNullExpressionValue((Object)nativeRectangularViewfinder, (String)"NativeRectangularViewfin\u2026rStyles(style, lineStyle)");
            Intrinsics.checkNotNullParameter((Object)nativeRectangularViewfinder, (String)"impl");
            int n2 = 2 & 2;
            GuavaMapMakerProxyCache guavaMapMakerProxyCache = null;
            if (n2 != 0) {
                guavaMapMakerProxyCache = ProxyCacheKt.a;
            }
            Intrinsics.checkNotNullParameter((Object)nativeRectangularViewfinder, (String)"_NativeRectangularViewfinder");
            Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
            NativeViewfinder nativeViewfinder = nativeRectangularViewfinder.asViewfinder();
            Intrinsics.checkNotNullExpressionValue((Object)nativeViewfinder, (String)"_NativeRectangularViewfinder.asViewfinder()");
            nativeRectangularViewfinder.setColor(R.style.toNativeColor((int)this.requireActivity().getColor(2131034222)));
            barcodeCaptureOverlay.c.b.setViewfinder(nativeViewfinder);
            BarcodeCaptureOverlayProxyAdapter barcodeCaptureOverlayProxyAdapter = barcodeCaptureOverlay.c;
            Objects.requireNonNull((Object)barcodeCaptureOverlayProxyAdapter);
            NativeBrush nativeBrush = new NativeBrush(R.style.toNativeColor((int)0), R.style.toNativeColor((int)-1), 3.0f);
            barcodeCaptureOverlayProxyAdapter.b.setBrushForRecognizedBarcodes(nativeBrush);
            return dataCaptureView;
        }
        throw new IllegalStateException("This overlay's mode and view are attached to different data capture contexts!".toString());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter((Object)menuItem, (String)"item");
        if (menuItem.getItemId() == 2131296318) {
            FeatureFragment featureFragment = this.featureFragment;
            if (featureFragment != null) {
                FeatureFragment.replaceFragment$default(featureFragment, "tutorialScanHelp", new Serializable[0], null, 4, null);
            }
            return true;
        }
        return false;
    }

    public void onPause() {
        this.mCalled = true;
        ScanViewModel scanViewModel = this.viewModel;
        if (scanViewModel != null) {
            scanViewModel.listener = null;
        }
        if (scanViewModel != null) {
            scanViewModel.dataCaptureManager.barcodeCapture.e.b.setEnabled(false);
        }
        ScanViewModel scanViewModel2 = this.viewModel;
        if (scanViewModel2 == null) {
            return;
        }
        Camera camera = scanViewModel2.dataCaptureManager.camera;
        if (camera == null) {
            return;
        }
        camera.switchToDesiredState(FrameSourceState.OFF);
    }

    public void onResume() {
        this.mCalled = true;
        Log.d((String)"Scan", (String)"onResume");
        this.isCallingWS = false;
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            Camera camera;
            this.model = sharedViewModel;
            sharedViewModel.currentResponse = null;
            ScanViewModel scanViewModel = this.viewModel;
            if (scanViewModel != null) {
                scanViewModel.listener = this;
            }
            if (scanViewModel != null && (camera = scanViewModel.dataCaptureManager.camera) != null) {
                camera.switchToDesiredState(FrameSourceState.ON);
            }
            if (!this.isCallingWS) {
                ScanViewModel scanViewModel2 = this.viewModel;
                if (scanViewModel2 == null) {
                    return;
                }
                scanViewModel2.resumeScanning();
            }
            return;
        }
        throw new Exception("Invalid Activity");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)view, (String)"view");
        this.isCallingWS = false;
    }

    @Override
    public void showErrorMessage(int n2, int n3) {
        Log.e((String)"Scan", (String)"showErrorMessage");
        this.isCallingWS = false;
        Context context = this.getContext();
        if (context == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String string = this.getResources().getString(n2);
        builder.P.mTitle = string;
        String string2 = this.getResources().getString(n3);
        AlertController.AlertParams alertParams = builder.P;
        alertParams.mMessage = string2;
        -$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk -$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk = new -$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk(this);
        alertParams.mNegativeButtonText = "OK";
        alertParams.mNegativeButtonListener = -$$Lambda$ScanChildFragment$b91oYr4J6e7YGgC9GhKPpPdLzgk;
        AlertDialog alertDialog = builder.create();
        Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(context).setTitle(getString(title)).setMessage(\n                getString(\n                    message\n                )\n            )\n                .setNegativeButton(\"OK\") { dialog, _ -> dialog.dismiss()\n                    viewModel?.resumeScanning()\n                }.create()");
        alertDialog.show();
    }

    @Override
    public MainActivity.NavigationIcon showNavigation() {
        return MainActivity.NavigationIcon.BACK;
    }

    @Override
    public void showResult(DocumentResult documentResult) {
        Intrinsics.checkNotNullParameter((Object)documentResult, (String)"response");
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            this.model = sharedViewModel;
            sharedViewModel.currentResponse = documentResult;
            new Date();
            SharedViewModel sharedViewModel2 = this.model;
            if (sharedViewModel2 != null) {
                Boolean bl;
                sharedViewModel2.resultAlreadyViewed = Boolean.FALSE;
                FragmentActivity fragmentActivity2 = this.getActivity();
                SharedPreferences sharedPreferences = fragmentActivity2 == null ? null : fragmentActivity2.getPreferences(0);
                boolean bl2 = true;
                Boolean bl3 = sharedPreferences == null ? null : Boolean.valueOf((boolean)sharedPreferences.getBoolean(Constants$SavedItems.SHOW_RESULT_TUTO.getText(), bl2));
                if (Intrinsics.areEqual((Object)bl3, (Object)(bl = Boolean.TRUE))) {
                    Boolean bl4;
                    Context context = this.getContext();
                    if (context == null) {
                        bl4 = null;
                    } else {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        SharedPreferences sharedPreferences2 = ((Activity)context).getPreferences(0);
                        String string = sharedPreferences2 == null ? null : sharedPreferences2.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
                        if (string == null) {
                            bl2 = false;
                        }
                        bl4 = bl2;
                    }
                    if (Intrinsics.areEqual(bl4, (Object)bl)) {
                        FeatureFragment featureFragment = this.featureFragment;
                        if (featureFragment == null) {
                            return;
                        }
                        FeatureFragment.replaceFragment$default(featureFragment, "tutorialOT", new Serializable[0], null, 4, null);
                        return;
                    }
                    FeatureFragment featureFragment = this.featureFragment;
                    if (featureFragment == null) {
                        return;
                    }
                    FeatureFragment.replaceFragment$default(featureFragment, "tutorialResult2DDoc", new Serializable[0], null, 4, null);
                    return;
                }
                FeatureFragment featureFragment = this.featureFragment;
                if (featureFragment == null) {
                    return;
                }
                FeatureFragment.replaceFragment$default(featureFragment, "resultScanF", new Serializable[0], null, 4, null);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"model");
            throw null;
        }
        throw new Exception("Invalid Activity");
    }
}

