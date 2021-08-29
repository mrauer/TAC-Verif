/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.common.graphic;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Channel
extends Enum<Channel> {
    public static final /* enum */ Channel A;
    public static final /* enum */ Channel B;
    public static final /* enum */ Channel G;
    public static final /* enum */ Channel R;
    public static final /* enum */ Channel U;
    public static final /* enum */ Channel V;
    public static final /* enum */ Channel Y;
    private static final /* synthetic */ Channel[] a;

    public static {
        Channel channel;
        Channel channel2;
        Channel channel3;
        Channel channel4;
        Channel channel5;
        Channel channel6;
        Channel channel7;
        Y = channel7 = new Channel();
        U = channel4 = new Channel();
        V = channel2 = new Channel();
        R = channel = new Channel();
        G = channel3 = new Channel();
        B = channel5 = new Channel();
        A = channel6 = new Channel();
        a = new Channel[]{channel7, channel4, channel2, channel, channel3, channel5, channel6};
    }

    public static Channel valueOf(String string) {
        return (Channel)Enum.valueOf(Channel.class, (String)string);
    }

    public static Channel[] values() {
        return (Channel[])a.clone();
    }
}

