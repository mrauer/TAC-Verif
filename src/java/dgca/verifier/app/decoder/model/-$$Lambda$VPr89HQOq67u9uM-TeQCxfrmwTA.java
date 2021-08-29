/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package dgca.verifier.app.decoder.model;

import j$.time.OffsetDateTime;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

public final class -$$Lambda$VPr89HQOq67u9uM-TeQCxfrmwTA
implements TemporalQuery {
    public static final /* synthetic */ -$$Lambda$VPr89HQOq67u9uM-TeQCxfrmwTA INSTANCE;

    public static /* synthetic */ {
        INSTANCE = new -$$Lambda$VPr89HQOq67u9uM-TeQCxfrmwTA();
    }

    @Override
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return OffsetDateTime.from(temporalAccessor);
    }
}

