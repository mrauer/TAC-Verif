/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.ASN1Set
 *  org.bouncycastle.asn1.DLSequence
 *  org.bouncycastle.asn1.DLSet
 */
package org.bouncycastle.asn1;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLSet;

public class DLFactory {
    public static final ASN1Sequence EMPTY_SEQUENCE = new DLSequence();
    public static final ASN1Set EMPTY_SET = new DLSet();
}

