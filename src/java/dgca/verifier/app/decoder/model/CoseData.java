/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Objects
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\r\u001a\u00020\t8\u0006@\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0016\u0010\u000b\u00a8\u0006\u0019"}, d2={"Ldgca/verifier/app/decoder/model/CoseData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()[B", "component2", "cbor", "kid", "copy", "([B[B)Ldgca/verifier/app/decoder/model/CoseData;", "", "toString", "()Ljava/lang/String;", "[B", "getKid", "getCbor", "<init>", "([B[B)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class CoseData {
    private final byte[] cbor;
    private final byte[] kid;

    public CoseData(byte[] arrby, byte[] arrby2) {
        Intrinsics.checkNotNullParameter((Object)arrby, (String)"cbor");
        this.cbor = arrby;
        this.kid = arrby2;
    }

    public /* synthetic */ CoseData(byte[] arrby, byte[] arrby2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            arrby2 = null;
        }
        this(arrby, arrby2);
    }

    public static /* synthetic */ CoseData copy$default(CoseData coseData, byte[] arrby, byte[] arrby2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            arrby = coseData.cbor;
        }
        if ((n2 & 2) != 0) {
            arrby2 = coseData.kid;
        }
        return coseData.copy(arrby, arrby2);
    }

    public final byte[] component1() {
        return this.cbor;
    }

    public final byte[] component2() {
        return this.kid;
    }

    public final CoseData copy(byte[] arrby, byte[] arrby2) {
        Intrinsics.checkNotNullParameter((Object)arrby, (String)"cbor");
        return new CoseData(arrby, arrby2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        Class class_ = object == null ? null : object.getClass();
        if (!Intrinsics.areEqual(CoseData.class, (Object)class_)) {
            return false;
        }
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type dgca.verifier.app.decoder.model.CoseData");
        CoseData coseData = (CoseData)object;
        if (!Arrays.equals((byte[])this.cbor, (byte[])coseData.cbor)) {
            return false;
        }
        byte[] arrby = this.kid;
        if (arrby != null) {
            byte[] arrby2 = coseData.kid;
            if (arrby2 == null) {
                return false;
            }
            if (!Arrays.equals((byte[])arrby, (byte[])arrby2)) {
                return false;
            }
        } else if (coseData.kid != null) {
            return false;
        }
        return true;
    }

    public final byte[] getCbor() {
        return this.cbor;
    }

    public final byte[] getKid() {
        return this.kid;
    }

    public int hashCode() {
        int n2 = 31 * Arrays.hashCode((byte[])this.cbor);
        byte[] arrby = this.kid;
        int n3 = arrby == null ? 0 : Arrays.hashCode((byte[])arrby);
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"CoseData(cbor=");
        stringBuilder.append(Arrays.toString((byte[])this.cbor));
        stringBuilder.append(", kid=");
        stringBuilder.append(Arrays.toString((byte[])this.kid));
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

