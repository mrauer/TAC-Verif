/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.text.Annotation
 *  android.text.SpannableString
 *  android.text.SpannedString
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.style.ClickableSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.UnderlineSpan
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$addLinktoTextView
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$addLinktoTextView$clickableSpan
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$$inlined
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$$inlined$sortBy
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$$inlined
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$$inlined$sortBy
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$lambda-5$
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$lambda-5$$inlined
 *  com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$lambda-5$$inlined$sortBy
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.Locale
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.R;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$;
import com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$;
import com.ingroupe.verify.anticovid.common.Utils$Companion$sortConf$lambda-6$lambda-5$;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfField;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfGroup;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfStatic;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfType;
import dalvik.annotation.SourceDebugExtension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class Utils {
    public static final Companion Companion = new Companion(null);
    public static boolean UserAskedCameraPermissionBefore;
    public static Toast currentTextToast;
    public static Toast currentViewToast;

    /*
     * Exception performing whole class analysis.
     */
    @SourceDebugExtension(value="SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/ingroupe/verify/anticovid/common/Utils$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n13536#2,2:225\n1849#3:227\n1000#3,2:228\n1849#3:230\n1000#3,2:231\n1850#3:233\n1850#3:234\n1000#3,2:235\n1#4:237\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/ingroupe/verify/anticovid/common/Utils$Companion\n*L\n74#1:225,2\n83#1:227\n84#1:228,2\n85#1:230\n86#1:231,2\n85#1:233\n83#1:234\n89#1:235,2\n*E\n")
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void addLinktoTextView(TextView textView, int n3, int n4, Context context) {
            Intrinsics.checkNotNullParameter((Object)textView, (String)"textView");
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            SpannedString spannedString = (SpannedString)context.getText(n3);
            SpannableString spannableString = new SpannableString((CharSequence)spannedString);
            Annotation[] arrannotation = (Annotation[])spannedString.getSpans(0, spannedString.length(), Annotation.class);
            ClickableSpan clickableSpan2 = new ClickableSpan(context, n4){
                public final /* synthetic */ Context $context;
                public final /* synthetic */ int $linkId;
                {
                    this.$context = context;
                    this.$linkId = n3;
                }

                public void onClick(android.view.View view) {
                    Intrinsics.checkNotNullParameter((Object)view, (String)"widget");
                    android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse((String)this.$context.getString(this.$linkId)));
                    Context context = this.$context;
                    context.startActivity(intent, null);
                }

                public void updateDrawState(android.text.TextPaint textPaint) {
                    Intrinsics.checkNotNullParameter((Object)textPaint, (String)"ds");
                    textPaint.setUnderlineText(false);
                }
            };
            if (arrannotation != null) {
                Annotation annotation2;
                block4 : {
                    for (Annotation annotation2 : arrannotation) {
                        if (!Intrinsics.areEqual((Object)annotation2.getValue(), (Object)"link")) {
                            continue;
                        }
                        break block4;
                    }
                    annotation2 = null;
                }
                if (annotation2 != null) {
                    spannableString.setSpan((Object)clickableSpan2, spannedString.getSpanStart((Object)annotation2), spannedString.getSpanEnd((Object)annotation2), 33);
                    spannableString.setSpan((Object)new ForegroundColorSpan(context.getColor(2131034221)), spannedString.getSpanStart((Object)annotation2), spannedString.getSpanEnd((Object)annotation2), 0);
                    spannableString.setSpan((Object)new UnderlineSpan(), spannedString.getSpanStart((Object)annotation2), spannedString.getSpanEnd((Object)annotation2), 0);
                }
            }
            textView.setText((CharSequence)spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        public final Resources getLocalizedResources(Context context, Locale locale) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Configuration configuration = context.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue((Object)configuration, (String)"context.resources.configuration");
            Configuration configuration2 = new Configuration(configuration);
            configuration2.setLocale(locale);
            Resources resources = context.createConfigurationContext(configuration2).getResources();
            Intrinsics.checkNotNullExpressionValue((Object)resources, (String)"localizedContext.resources");
            return resources;
        }

        public final void sortConf(ConfResult confResult) {
            ArrayList<ConfType> arrayList;
            if (confResult != null && (arrayList = confResult.getTypes()) != null) {
                for (ConfType confType : arrayList) {
                    ArrayList<ConfGroup> arrayList2;
                    ArrayList<ConfGroup> arrayList3 = confType.getGroups();
                    if (arrayList3 != null && arrayList3.size() > 1) {
                        R.style.sortWith(arrayList3, }
                }
            }
        }
        java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
        
        