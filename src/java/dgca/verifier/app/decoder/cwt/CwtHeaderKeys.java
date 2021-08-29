/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.cwt;

import com.upokecenter.cbor.CBORObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class CwtHeaderKeys {
    public final CBORObject value;

    public CwtHeaderKeys(int n2, DefaultConstructorMarker defaultConstructorMarker) {
        CBORObject cBORObject = CBORObject.FromObject(n2);
        Intrinsics.checkNotNullExpressionValue((Object)cBORObject, (String)"FromObject(value)");
        this.value = cBORObject;
    }
}

