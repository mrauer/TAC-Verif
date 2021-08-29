/*
 * Decompiled with CFR 0.0.
 */
package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.rainbow.Layer;

public class RainbowPrivateKey
extends ASN1Object {
    public byte[] b1;
    public byte[] b2;
    public byte[][] invA1;
    public byte[][] invA2;
    public Layer[] layers;
    public ASN1ObjectIdentifier oid;
    public ASN1Integer version;
    public byte[] vi;

    public RainbowPrivateKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.oid = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        }
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence)aSN1Sequence.getObjectAt(1);
        this.invA1 = new byte[aSN1Sequence2.size()][];
        for (int i2 = 0; i2 < aSN1Sequence2.size(); ++i2) {
            this.invA1[i2] = ((ASN1OctetString)aSN1Sequence2.getObjectAt((int)i2)).string;
        }
        this.b1 = ((ASN1OctetString)((ASN1Sequence)aSN1Sequence.getObjectAt((int)2)).getObjectAt((int)0)).string;
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence)aSN1Sequence.getObjectAt(3);
        this.invA2 = new byte[aSN1Sequence3.size()][];
        for (int i3 = 0; i3 < aSN1Sequence3.size(); ++i3) {
            this.invA2[i3] = ((ASN1OctetString)aSN1Sequence3.getObjectAt((int)i3)).string;
        }
        this.b2 = ((ASN1OctetString)((ASN1Sequence)aSN1Sequence.getObjectAt((int)4)).getObjectAt((int)0)).string;
        this.vi = ((ASN1OctetString)((ASN1Sequence)aSN1Sequence.getObjectAt((int)5)).getObjectAt((int)0)).string;
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence)aSN1Sequence.getObjectAt(6);
        byte[][][][] arrarrby = new byte[aSN1Sequence4.size()][][][];
        byte[][][][] arrarrby2 = new byte[aSN1Sequence4.size()][][][];
        byte[][][] arrarrby3 = new byte[aSN1Sequence4.size()][][];
        byte[][] arrarrby4 = new byte[aSN1Sequence4.size()][];
        for (int i4 = 0; i4 < aSN1Sequence4.size(); ++i4) {
            ASN1Sequence aSN1Sequence5 = (ASN1Sequence)aSN1Sequence4.getObjectAt(i4);
            ASN1Sequence aSN1Sequence6 = (ASN1Sequence)aSN1Sequence5.getObjectAt(0);
            arrarrby[i4] = new byte[aSN1Sequence6.size()][][];
            for (int i5 = 0; i5 < aSN1Sequence6.size(); ++i5) {
                ASN1Sequence aSN1Sequence7 = (ASN1Sequence)aSN1Sequence6.getObjectAt(i5);
                arrarrby[i4][i5] = new byte[aSN1Sequence7.size()][];
                for (int i6 = 0; i6 < aSN1Sequence7.size(); ++i6) {
                    arrarrby[i4][i5][i6] = ((ASN1OctetString)aSN1Sequence7.getObjectAt((int)i6)).string;
                }
            }
            ASN1Sequence aSN1Sequence8 = (ASN1Sequence)aSN1Sequence5.getObjectAt(1);
            arrarrby2[i4] = new byte[aSN1Sequence8.size()][][];
            for (int i7 = 0; i7 < aSN1Sequence8.size(); ++i7) {
                ASN1Sequence aSN1Sequence9 = (ASN1Sequence)aSN1Sequence8.getObjectAt(i7);
                arrarrby2[i4][i7] = new byte[aSN1Sequence9.size()][];
                for (int i8 = 0; i8 < aSN1Sequence9.size(); ++i8) {
                    arrarrby2[i4][i7][i8] = ((ASN1OctetString)aSN1Sequence9.getObjectAt((int)i8)).string;
                }
            }
            ASN1Sequence aSN1Sequence10 = (ASN1Sequence)aSN1Sequence5.getObjectAt(2);
            arrarrby3[i4] = new byte[aSN1Sequence10.size()][];
            for (int i9 = 0; i9 < aSN1Sequence10.size(); ++i9) {
                arrarrby3[i4][i9] = ((ASN1OctetString)aSN1Sequence10.getObjectAt((int)i9)).string;
            }
            arrarrby4[i4] = ((ASN1OctetString)aSN1Sequence5.getObjectAt((int)3)).string;
        }
        int n2 = this.vi.length - 1;
        this.layers = new Layer[n2];
        int n3 = 0;
        while (n3 < n2) {
            Layer layer;
            byte[] arrby = this.vi;
            byte by = arrby[n3];
            int n4 = n3 + 1;
            this.layers[n3] = layer = new Layer(by, arrby[n4], Nat576.convertArray(arrarrby[n3]), Nat576.convertArray(arrarrby2[n3]), Nat576.convertArray(arrarrby3[n3]), Nat576.convertArray(arrarrby4[n3]));
            n3 = n4;
        }
    }

    public RainbowPrivateKey(short[][] arrs, short[] arrs2, short[][] arrs3, short[] arrs4, int[] arrn, Layer[] arrlayer) {
        this.version = new ASN1Integer(1L);
        this.invA1 = Nat576.convertArray(arrs);
        this.b1 = Nat576.convertArray(arrs2);
        this.invA2 = Nat576.convertArray(arrs3);
        this.b2 = Nat576.convertArray(arrs4);
        byte[] arrby = new byte[arrn.length];
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            arrby[i2] = (byte)arrn[i2];
        }
        this.vi = arrby;
        this.layers = arrlayer;
    }

    @Override
    public ASN1Primitive toASN1Primitive() {
        byte[][] arrby;
        byte[][] arrby2;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        ASN1Primitive aSN1Primitive = this.version;
        if (aSN1Primitive == null) {
            aSN1Primitive = this.oid;
        }
        aSN1EncodableVector.add(aSN1Primitive);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(10);
        for (int i2 = 0; i2 < (arrby = this.invA1).length; ++i2) {
            aSN1EncodableVector2.add(new DEROctetString(arrby[i2]));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector(10);
        aSN1EncodableVector3.add(new DEROctetString(this.b1));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector(10);
        for (int i3 = 0; i3 < (arrby2 = this.invA2).length; ++i3) {
            aSN1EncodableVector4.add(new DEROctetString(arrby2[i3]));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector(10);
        aSN1EncodableVector5.add(new DEROctetString(this.b2));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector5));
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector(10);
        aSN1EncodableVector6.add(new DEROctetString(this.vi));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector6));
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector(10);
        for (int i4 = 0; i4 < this.layers.length; ++i4) {
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector(10);
            byte[][][] arrby3 = Nat576.convertArray(this.layers[i4].coeff_alpha);
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector(10);
            for (int i5 = 0; i5 < arrby3.length; ++i5) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector(10);
                for (int i6 = 0; i6 < arrby3[i5].length; ++i6) {
                    aSN1EncodableVector10.add(new DEROctetString(arrby3[i5][i6]));
                }
                aSN1EncodableVector9.add(new DERSequence(aSN1EncodableVector10));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector9));
            byte[][][] arrby4 = Nat576.convertArray(this.layers[i4].coeff_beta);
            ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector(10);
            for (int i7 = 0; i7 < arrby4.length; ++i7) {
                ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector(10);
                for (int i8 = 0; i8 < arrby4[i7].length; ++i8) {
                    aSN1EncodableVector12.add(new DEROctetString(arrby4[i7][i8]));
                }
                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector11));
            byte[][] arrby5 = Nat576.convertArray(this.layers[i4].coeff_gamma);
            ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector(10);
            for (int i9 = 0; i9 < arrby5.length; ++i9) {
                aSN1EncodableVector13.add(new DEROctetString(arrby5[i9]));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector13));
            aSN1EncodableVector8.add(new DEROctetString(Nat576.convertArray(this.layers[i4].coeff_eta)));
            aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector8));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector7));
        return new DERSequence(aSN1EncodableVector);
    }
}

