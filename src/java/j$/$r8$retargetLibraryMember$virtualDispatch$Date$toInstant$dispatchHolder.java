/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Date
 */
package j$;

import j$.a;
import j$.time.Instant;
import java.util.Date;

public class $r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder {
    public static Instant toInstant(Date date) {
        if (date instanceof a) {
            return ((a)date).a();
        }
        return Instant.M(date.getTime());
    }
}

