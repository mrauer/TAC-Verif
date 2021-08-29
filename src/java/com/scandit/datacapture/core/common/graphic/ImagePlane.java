/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package com.scandit.datacapture.core.common.graphic;

import com.scandit.datacapture.core.common.graphic.Channel;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.nio.ByteBuffer;

@DjinniGenerated
public final class ImagePlane {
    public final Channel channel;
    public final ByteBuffer data;
    public final int pixelStride;
    public final int rowStride;
    public final int subsamplingX;
    public final int subsamplingY;

    public ImagePlane(Channel channel, int n2, int n3, int n4, int n5, ByteBuffer byteBuffer) {
        this.channel = channel;
        this.subsamplingX = n2;
        this.subsamplingY = n3;
        this.rowStride = n4;
        this.pixelStride = n5;
        this.data = byteBuffer;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final ByteBuffer getData() {
        return this.data;
    }

    public final int getPixelStride() {
        return this.pixelStride;
    }

    public final int getRowStride() {
        return this.rowStride;
    }

    public final int getSubsamplingX() {
        return this.subsamplingX;
    }

    public final int getSubsamplingY() {
        return this.subsamplingY;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImagePlane{channel=");
        stringBuilder.append((Object)this.channel);
        stringBuilder.append(",subsamplingX=");
        stringBuilder.append(this.subsamplingX);
        stringBuilder.append(",subsamplingY=");
        stringBuilder.append(this.subsamplingY);
        stringBuilder.append(",rowStride=");
        stringBuilder.append(this.rowStride);
        stringBuilder.append(",pixelStride=");
        stringBuilder.append(this.pixelStride);
        stringBuilder.append(",data=");
        stringBuilder.append((Object)this.data);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

