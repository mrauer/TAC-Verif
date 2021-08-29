/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0004J>\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004\u00a8\u0006\u001e"}, d2={"Ldgca/verifier/app/decoder/model/Person;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "standardisedFamilyName", "familyName", "standardisedGivenName", "givenName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldgca/verifier/app/decoder/model/Person;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStandardisedGivenName", "getStandardisedFamilyName", "getFamilyName", "getGivenName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dgca-decoder_release"}, k=1, mv={1, 5, 1})
public final class Person
implements Serializable {
    private final String familyName;
    private final String givenName;
    private final String standardisedFamilyName;
    private final String standardisedGivenName;

    public Person(@JsonProperty(value="fnt") String string, @JsonProperty(value="fn") String string2, @JsonProperty(value="gnt") String string3, @JsonProperty(value="gn") String string4) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"standardisedFamilyName");
        this.standardisedFamilyName = string;
        this.familyName = string2;
        this.standardisedGivenName = string3;
        this.givenName = string4;
    }

    public static /* synthetic */ Person copy$default(Person person, String string, String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = person.standardisedFamilyName;
        }
        if ((n2 & 2) != 0) {
            string2 = person.familyName;
        }
        if ((n2 & 4) != 0) {
            string3 = person.standardisedGivenName;
        }
        if ((n2 & 8) != 0) {
            string4 = person.givenName;
        }
        return person.copy(string, string2, string3, string4);
    }

    public final String component1() {
        return this.standardisedFamilyName;
    }

    public final String component2() {
        return this.familyName;
    }

    public final String component3() {
        return this.standardisedGivenName;
    }

    public final String component4() {
        return this.givenName;
    }

    public final Person copy(@JsonProperty(value="fnt") String string, @JsonProperty(value="fn") String string2, @JsonProperty(value="gnt") String string3, @JsonProperty(value="gn") String string4) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"standardisedFamilyName");
        return new Person(string, string2, string3, string4);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        Person person = (Person)object;
        if (!Intrinsics.areEqual((Object)this.standardisedFamilyName, (Object)person.standardisedFamilyName)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.familyName, (Object)person.familyName)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.standardisedGivenName, (Object)person.standardisedGivenName)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.givenName, (Object)person.givenName);
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final String getStandardisedFamilyName() {
        return this.standardisedFamilyName;
    }

    public final String getStandardisedGivenName() {
        return this.standardisedGivenName;
    }

    public int hashCode() {
        int n2 = 31 * this.standardisedFamilyName.hashCode();
        String string = this.familyName;
        int n3 = string == null ? 0 : string.hashCode();
        int n4 = 31 * (n2 + n3);
        String string2 = this.standardisedGivenName;
        int n5 = string2 == null ? 0 : string2.hashCode();
        int n6 = 31 * (n4 + n5);
        String string3 = this.givenName;
        int n7 = string3 == null ? 0 : string3.hashCode();
        return n6 + n7;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Person(standardisedFamilyName=");
        stringBuilder.append(this.standardisedFamilyName);
        stringBuilder.append(", familyName=");
        stringBuilder.append((Object)this.familyName);
        stringBuilder.append(", standardisedGivenName=");
        stringBuilder.append((Object)this.standardisedGivenName);
        stringBuilder.append(", givenName=");
        stringBuilder.append((Object)this.givenName);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

