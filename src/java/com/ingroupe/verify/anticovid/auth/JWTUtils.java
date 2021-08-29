/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.security.KeyFactory
 *  java.security.PublicKey
 *  java.security.Signature
 *  java.security.spec.KeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  java.util.Date
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.ingroupe.verify.anticovid.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.ingroupe.verify.anticovid.common.Constants$SavedItems;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

public final class JWTUtils {
    public static Signature publicSignature;

    public static final boolean checkSignature(String string) {
        if (publicSignature == null) {
            publicSignature = Signature.getInstance((String)"SHA256withRSA");
            byte[] arrby = Base64.decode((String)"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwIuUARi7SBc6lbWaXtacxh8EVvVhstPtMDLt+ygg9qluzEcR1uArXAQpH2fuFO6I1dK3JCIvObyaLgDwUd2je2UUJepcXCXHQPxz5FjtjCFQIwPboGNjNjjZkx7zp83/RoglpmHUMxYwilZBeGTpO3eE6CcIRtb33VNV926MGJ76vJgM1PVRwIT1LRBYJV6+zjZ71wECSIsAmN8wjIm6yxJcLTy+nE2x4HGV1Bd78rdNg13BlrgjaimJ9cTVW3t24jtjIevZCEG0MW3GtqpZRKpxn30SBAyd7ogwXnIjKzCP2VbgR5XGN8WcWdfVg70HyQTtBWl2VLPSjAZhUJjSqQIDAQAB", (int)2);
            PublicKey publicKey = KeyFactory.getInstance((String)"RSA").generatePublic((KeySpec)new X509EncodedKeySpec(arrby));
            Intrinsics.checkNotNullExpressionValue((Object)publicKey, (String)"getInstance(\"RSA\").generatePublic(X509EncodedKeySpec(asn))");
            Signature signature = publicSignature;
            if (signature != null) {
                signature.initVerify(publicKey);
            }
        }
        Object[] arrobject = StringsKt__IndentKt.split$default((CharSequence)string, (String[])new String[]{"."}, (boolean)false, (int)0, (int)6).toArray((Object[])new String[0]);
        Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
        String[] arrstring = (String[])arrobject;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)arrstring[0]);
        stringBuilder.append('.');
        stringBuilder.append((Object)arrstring[1]);
        String string2 = stringBuilder.toString();
        Charset charset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue((Object)charset, (String)"defaultCharset()");
        Objects.requireNonNull((Object)string2, (String)"null cannot be cast to non-null type java.lang.String");
        byte[] arrby = string2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)arrby, (String)"(this as java.lang.String).getBytes(charset)");
        byte[] arrby2 = Base64.decode((String)arrstring[2], (int)10);
        Intrinsics.checkNotNullExpressionValue((Object)arrby2, (String)"decode(tokenParts[2], Base64.URL_SAFE or Base64.NO_WRAP)");
        Signature signature = publicSignature;
        if (signature != null) {
            signature.update(arrby);
        }
        Signature signature2 = publicSignature;
        if (signature2 == null) {
            return false;
        }
        return signature2.verify(arrby2);
    }

    public static final int daysBeforeExpiration(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        long l3 = (JWTUtils.getDateExpiration(context) - new Date().getTime()) / (long)86400000;
        if (l3 < 0L) {
            return 0;
        }
        return (int)l3;
    }

    public static final long getDateExpiration(Context context) {
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(Constants$SavedItems.CONF_DATE_EXP.getText(), 0L);
    }

    public static final boolean isModeOT(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(0);
        String string = sharedPreferences == null ? null : sharedPreferences.getString(Constants$SavedItems.CURRENT_TOKEN.getText(), null);
        boolean bl = false;
        if (string != null) {
            bl = true;
        }
        return bl;
    }
}

