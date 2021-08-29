/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.inputmethod.InputMethodManager
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelStoreOwner
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  dalvik.annotation.SourceDebugExtension
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 *  java.util.Stack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.common.FeatureChildFragment;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import dalvik.annotation.SourceDebugExtension;
import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SourceDebugExtension(value="SMAP\nFeatureFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFragment.kt\ncom/ingroupe/verify/anticovid/common/FeatureFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,270:1\n1#2:271\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ'\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H&\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH&\u00a2\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b&\u0010\u0004R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00102\u00a8\u00065"}, d2={"Lcom/ingroupe/verify/anticovid/common/FeatureFragment;", "Landroidx/fragment/app/Fragment;", "", "onResume", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "tag", "", "Ljava/io/Serializable;", "args", "createFragment", "(Ljava/lang/String;[Ljava/io/Serializable;)Landroidx/fragment/app/Fragment;", "", "getLayoutId", "()I", "getFirstTag", "()Ljava/lang/String;", "bundle", "", "force", "popToTag", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "initFeatureFragment", "Ljava/util/Stack;", "tagStack", "Ljava/util/Stack;", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "currentFragment", "Lcom/ingroupe/verify/anticovid/common/FeatureChildFragment;", "forceReplace", "Z", "currentBundle", "Landroid/os/Bundle;", "currentTag", "Ljava/lang/String;", "tagToPop", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public abstract class FeatureFragment
extends Fragment {
    public Bundle currentBundle;
    public FeatureChildFragment currentFragment;
    public String currentTag = "NO_FRAGMENT";
    public boolean forceReplace;
    public Stack<String> tagStack;
    public String tagToPop;

    public static /* synthetic */ void popToTag$default(FeatureFragment featureFragment, String string, Bundle bundle, boolean bl, int n2, Object object) {
        n2 & 2;
        if ((n2 & 4) != 0) {
            bl = false;
        }
        featureFragment.popToTag(string, null, bl);
    }

    public static boolean replaceFragment$default(FeatureFragment featureFragment, String string, Serializable[] arrserializable, View view, int n2, Object object) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter((Object)string, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)arrserializable, (String)"args");
        if (Intrinsics.areEqual((Object)string, (Object)featureFragment.currentTag) && !featureFragment.forceReplace) {
            StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Fragment ");
            stringBuilder.append((Object)featureFragment.currentTag);
            stringBuilder.append(" is already present");
            Log.d((String)"FRAGMENTS", (String)stringBuilder.toString());
            if (featureFragment.currentFragment == null && featureFragment.isAdded()) {
                Fragment fragment2 = featureFragment.getChildFragmentManager().findFragmentByTag(featureFragment.currentTag);
                boolean bl = fragment2 instanceof FeatureChildFragment;
                FeatureChildFragment featureChildFragment = null;
                if (bl) {
                    featureChildFragment = (FeatureChildFragment)fragment2;
                }
                featureFragment.currentFragment = featureChildFragment;
                if (featureChildFragment != null) {
                    featureChildFragment.featureFragment = featureFragment;
                }
            }
            featureFragment.initFeatureFragment();
            return false;
        }
        if (!featureFragment.isAdded()) {
            return false;
        }
        Fragment fragment3 = featureFragment.getChildFragmentManager().findFragmentByTag(string);
        boolean bl = false;
        if (fragment3 == null) {
            bl = true;
        }
        if ((fragment = featureFragment.getChildFragmentManager().findFragmentByTag(string)) == null) {
            fragment = featureFragment.createFragment(string, arrserializable);
        }
        Intrinsics.checkNotNullExpressionValue((Object)fragment, (String)"childFragmentManager.findFragmentByTag(tag) ?: createFragment(tag, args)");
        BackStackRecord backStackRecord = new BackStackRecord(featureFragment.getChildFragmentManager());
        int n3 = featureFragment.getLayoutId();
        if (n3 != 0) {
            backStackRecord.doAddOp(n3, fragment, string, 2);
            Intrinsics.checkNotNullExpressionValue((Object)backStackRecord, (String)"childFragmentManager.beginTransaction().replace(getLayoutId(), fragment, tag)");
            if (bl) {
                if (backStackRecord.mAllowAddToBackStack) {
                    backStackRecord.mAddToBackStack = true;
                    backStackRecord.mName = string;
                } else {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
            }
            backStackRecord.commitInternal(true);
            featureFragment.currentTag = string;
            Stack<String> stack = featureFragment.tagStack;
            if (stack != null) {
                stack.add((Object)string);
                boolean bl2 = fragment instanceof FeatureChildFragment;
                FeatureChildFragment featureChildFragment = null;
                if (bl2) {
                    featureChildFragment = (FeatureChildFragment)fragment;
                }
                featureFragment.currentFragment = featureChildFragment;
                if (featureChildFragment != null) {
                    featureChildFragment.featureFragment = featureFragment;
                }
                featureFragment.initFeatureFragment();
                FragmentActivity fragmentActivity = featureFragment.getActivity();
                if (fragmentActivity == null) {
                    return bl;
                }
                fragmentActivity.invalidateOptionsMenu();
                return bl;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
            throw null;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public abstract Fragment createFragment(String var1, Serializable[] var2);

    public abstract String getFirstTag();

    public abstract int getLayoutId();

    public final void initFeatureFragment() {
        FragmentActivity fragmentActivity;
        Window window;
        FragmentActivity fragmentActivity2;
        int n2;
        FeatureChildFragment featureChildFragment;
        Integer n3;
        FragmentActivity fragmentActivity3;
        FragmentActivity fragmentActivity4;
        FeatureChildFragment featureChildFragment2 = this.currentFragment;
        String string = featureChildFragment2 == null ? null : featureChildFragment2.getTitle();
        if (string != null && (fragmentActivity3 = this.getActivity()) != null) {
            fragmentActivity3.setTitle((CharSequence)string);
        }
        if ((featureChildFragment = this.currentFragment) != null && (n3 = featureChildFragment.getTitleId()) != null && (n2 = n3.intValue()) != 0 && (fragmentActivity2 = this.getActivity()) != null) {
            fragmentActivity2.setTitle((CharSequence)fragmentActivity2.getString(n2));
        }
        if (this.currentFragment != null && (fragmentActivity = this.getActivity()) != null && (window = fragmentActivity.getWindow()) != null) {
            window.setSoftInputMode(16);
        }
        if ((fragmentActivity4 = this.getActivity()) == null) {
            return;
        }
        MainActivity mainActivity = (MainActivity)fragmentActivity4;
        View view = mainActivity.findViewById(16908290);
        if (view != null) {
            Object object = mainActivity.getSystemService("input_method");
            Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager)object).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        Serializable serializable = bundle == null ? null : bundle.getSerializable("CURRENT_TAG");
        String string = serializable instanceof String ? (String)serializable : null;
        this.currentTag = string;
        Serializable serializable2 = bundle == null ? null : bundle.getSerializable("TAG_STACK");
        Stack stack = serializable2 instanceof Stack ? (Stack)serializable2 : null;
        if (stack == null) {
            stack = new Stack();
        }
        this.tagStack = stack;
        if (stack.isEmpty()) {
            Stack<String> stack2 = this.tagStack;
            if (stack2 != null) {
                stack2.add((Object)"NO_FRAGMENT");
            } else {
                Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                throw null;
            }
        }
        if (Intrinsics.areEqual((Object)"NO_FRAGMENT", (Object)this.currentTag)) {
            FeatureFragment.replaceFragment$default(this, this.getFirstTag(), new Serializable[0], null, 4, null);
            return null;
        }
        FragmentActivity fragmentActivity = this.getActivity();
        SharedViewModel sharedViewModel = fragmentActivity == null ? null : (SharedViewModel)new ViewModelProvider((ViewModelStoreOwner)fragmentActivity).get(SharedViewModel.class);
        if (sharedViewModel != null) {
            if (sharedViewModel.reloadConfiguration) {
                Log.d((String)"FeatureFragment", (String)"reloadConfiguration");
                sharedViewModel.reloadConfiguration = false;
                sharedViewModel.configuration = null;
                Stack<String> stack3 = this.tagStack;
                if (stack3 != null) {
                    if (stack3.contains((Object)"actionChoice")) {
                        FeatureFragment.popToTag$default(this, "actionChoice", null, false, 6, null);
                        return null;
                    }
                    String string2 = this.currentTag;
                    if (string2 == null) {
                        string2 = this.getFirstTag();
                    }
                    FeatureFragment.replaceFragment$default(this, string2, new Serializable[0], null, 4, null);
                    return null;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                throw null;
            }
            String string3 = this.currentTag;
            if (string3 == null) {
                string3 = this.getFirstTag();
            }
            FeatureFragment.replaceFragment$default(this, string3, new Serializable[0], null, 4, null);
            return null;
        }
        throw new Exception("Invalid Activity");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter((Object)menuItem, (String)"item");
        FeatureChildFragment featureChildFragment = this.currentFragment;
        if (featureChildFragment == null) {
            return true;
        }
        return featureChildFragment.onOptionsItemSelected(menuItem);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onResume() {
        block7 : {
            Log.d((String)"FeatureFragment", (String)"check Current Tag");
            var2_1 = this.tagToPop;
            if (var2_1 == null) break block7;
            var3_2 = this.tagStack;
            if (var3_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                throw null;
            }
            if (var3_2.isEmpty()) ** GOTO lbl-1000
            var4_3 = this.tagStack;
            if (var4_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                throw null;
            }
            if (Intrinsics.areEqual((Object)var4_3.peek(), (Object)var2_1)) {
                var5_4 = this.tagStack;
                if (var5_4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
                    throw null;
                }
                if (Intrinsics.areEqual((Object)var5_4.peek(), (Object)var2_1)) {
                    var6_5 = this.getChildFragmentManager().findFragmentByTag(this.currentTag);
                    var7_6 = this.currentBundle;
                    if (var7_6 != null && var6_5 != null) {
                        var6_5.setArguments(var7_6);
                    }
                }
            } else lbl-1000: // 2 sources:
            {
                this.popToTag(var2_1, this.currentBundle, true);
            }
            this.tagToPop = null;
            this.currentBundle = null;
            this.forceReplace = false;
        }
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)bundle, (String)"outState");
        bundle.putSerializable("CURRENT_TAG", (Serializable)this.currentTag);
        Stack<String> stack = this.tagStack;
        if (stack != null) {
            bundle.putSerializable("TAG_STACK", stack);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"tagStack");
        throw null;
    }

    /*
     * Exception decompiling
     */
    public final void popToTag(String var1, Bundle var2, boolean var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl148 : RETURN : trying to set 1 previously set to 0
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

