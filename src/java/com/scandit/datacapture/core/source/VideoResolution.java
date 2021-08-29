/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class VideoResolution
extends Enum<VideoResolution> {
    public static final /* enum */ VideoResolution AUTO;
    public static final /* enum */ VideoResolution FULL_HD;
    public static final /* enum */ VideoResolution HD;
    public static final /* enum */ VideoResolution UHD4K;
    private static final /* synthetic */ VideoResolution[] a;

    public static {
        VideoResolution videoResolution;
        VideoResolution videoResolution2;
        VideoResolution videoResolution3;
        VideoResolution videoResolution4;
        HD = videoResolution2 = new VideoResolution();
        FULL_HD = videoResolution3 = new VideoResolution();
        AUTO = videoResolution = new VideoResolution();
        UHD4K = videoResolution4 = new VideoResolution();
        a = new VideoResolution[]{videoResolution2, videoResolution3, videoResolution, videoResolution4};
    }

    public static VideoResolution valueOf(String string) {
        return (VideoResolution)Enum.valueOf(VideoResolution.class, (String)string);
    }

    public static VideoResolution[] values() {
        return (VideoResolution[])a.clone();
    }
}

