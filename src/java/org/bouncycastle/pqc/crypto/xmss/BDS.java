/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.Set
 *  java.util.Stack
 *  java.util.TreeMap
 *  org.bouncycastle.asn1.ASN1ObjectIdentifier
 *  org.bouncycastle.pqc.crypto.xmss.HashTreeAddress
 *  org.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
 *  org.bouncycastle.pqc.crypto.xmss.LTreeAddress
 *  org.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder
 *  org.bouncycastle.pqc.crypto.xmss.OTSHashAddress
 *  org.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.pqc.crypto.xmss.BDSTreeHash;
import org.bouncycastle.pqc.crypto.xmss.HashTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.LTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlus;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusParameters;
import org.bouncycastle.pqc.crypto.xmss.WOTSPlusPublicKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import org.bouncycastle.pqc.crypto.xmss.XMSSNode;

public final class BDS
implements Serializable {
    public List<XMSSNode> authenticationPath;
    public int index;
    public int k;
    public Map<Integer, XMSSNode> keep;
    public transient int maxIndex;
    public Map<Integer, LinkedList<XMSSNode>> retain;
    public XMSSNode root;
    public Stack<XMSSNode> stack;
    public final List<BDSTreeHash> treeHashInstances;
    public final int treeHeight;
    public boolean used;
    public transient WOTSPlus wotsPlus;

    public BDS(BDS bDS) {
        Stack stack;
        ArrayList arrayList;
        this.wotsPlus = new WOTSPlus(bDS.wotsPlus.params);
        this.treeHeight = bDS.treeHeight;
        this.k = bDS.k;
        this.root = bDS.root;
        this.authenticationPath = arrayList = new ArrayList();
        arrayList.addAll(bDS.authenticationPath);
        this.retain = new TreeMap();
        for (Integer n2 : bDS.retain.keySet()) {
            this.retain.put((Object)n2, (Object)((LinkedList)((LinkedList)bDS.retain.get((Object)n2)).clone()));
        }
        this.stack = stack = new Stack();
        stack.addAll(bDS.stack);
        this.treeHashInstances = new ArrayList();
        Iterator iterator = bDS.treeHashInstances.iterator();
        while (iterator.hasNext()) {
            this.treeHashInstances.add(((BDSTreeHash)iterator.next()).clone());
        }
        this.keep = new TreeMap(bDS.keep);
        this.index = bDS.index;
        this.maxIndex = bDS.maxIndex;
        this.used = bDS.used;
    }

    public BDS(BDS bDS, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ArrayList arrayList;
        int n2;
        Stack stack;
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(aSN1ObjectIdentifier));
        this.treeHeight = bDS.treeHeight;
        this.k = bDS.k;
        this.root = bDS.root;
        this.authenticationPath = arrayList = new ArrayList();
        arrayList.addAll(bDS.authenticationPath);
        this.retain = new TreeMap();
        for (Integer n3 : bDS.retain.keySet()) {
            this.retain.put((Object)n3, (Object)((LinkedList)((LinkedList)bDS.retain.get((Object)n3)).clone()));
        }
        this.stack = stack = new Stack();
        stack.addAll(bDS.stack);
        this.treeHashInstances = new ArrayList();
        Iterator iterator = bDS.treeHashInstances.iterator();
        while (iterator.hasNext()) {
            this.treeHashInstances.add(((BDSTreeHash)iterator.next()).clone());
        }
        this.keep = new TreeMap(bDS.keep);
        this.index = n2 = bDS.index;
        this.maxIndex = bDS.maxIndex;
        this.used = bDS.used;
        if (this.authenticationPath != null) {
            if (this.retain != null) {
                if (this.stack != null) {
                    if (this.treeHashInstances != null) {
                        if (Nat576.isIndexValid(this.treeHeight, n2)) {
                            return;
                        }
                        throw new IllegalStateException("index in BDS state out of bounds");
                    }
                    throw new IllegalStateException("treeHashInstances == null");
                }
                throw new IllegalStateException("stack == null");
            }
            throw new IllegalStateException("retain == null");
        }
        throw new IllegalStateException("authenticationPath == null");
    }

    public BDS(BDS bDS, byte[] arrby, byte[] arrby2, OTSHashAddress oTSHashAddress) {
        Stack stack;
        ArrayList arrayList;
        this.wotsPlus = new WOTSPlus(bDS.wotsPlus.params);
        this.treeHeight = bDS.treeHeight;
        this.k = bDS.k;
        this.root = bDS.root;
        this.authenticationPath = arrayList = new ArrayList();
        arrayList.addAll(bDS.authenticationPath);
        this.retain = new TreeMap();
        for (Integer n2 : bDS.retain.keySet()) {
            this.retain.put((Object)n2, (Object)((LinkedList)((LinkedList)bDS.retain.get((Object)n2)).clone()));
        }
        this.stack = stack = new Stack();
        stack.addAll(bDS.stack);
        this.treeHashInstances = new ArrayList();
        Iterator iterator = bDS.treeHashInstances.iterator();
        while (iterator.hasNext()) {
            this.treeHashInstances.add(((BDSTreeHash)iterator.next()).clone());
        }
        this.keep = new TreeMap(bDS.keep);
        this.index = bDS.index;
        this.maxIndex = bDS.maxIndex;
        this.used = false;
        this.nextAuthenticationPath(arrby, arrby2, oTSHashAddress);
    }

    public BDS(WOTSPlus wOTSPlus, int n2, int n3, int n4) {
        int n5;
        this.wotsPlus = wOTSPlus;
        this.treeHeight = n2;
        this.maxIndex = n4;
        this.k = n3;
        if (n3 <= n2 && n3 >= 2 && (n5 = n2 - n3) % 2 == 0) {
            this.authenticationPath = new ArrayList();
            this.retain = new TreeMap();
            this.stack = new Stack();
            this.treeHashInstances = new ArrayList();
            for (int i2 = 0; i2 < n5; ++i2) {
                this.treeHashInstances.add((Object)new BDSTreeHash(i2));
            }
            this.keep = new TreeMap();
            this.index = 0;
            this.used = false;
            return;
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public final void initialize(byte[] arrby, byte[] arrby2, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull((Object)oTSHashAddress, (String)"otsHashAddress == null");
        LTreeAddress lTreeAddress = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress)).build();
        HashTreeAddress hashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress)).build();
        for (int i2 = 0; i2 < 1 << this.treeHeight; ++i2) {
            int n2;
            int n3;
            OTSHashAddress.Builder builder = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress);
            builder.otsAddress = i2;
            builder.chainAddress = oTSHashAddress.chainAddress;
            builder.hashAddress = oTSHashAddress.hashAddress;
            oTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)builder.withKeyAndMask(oTSHashAddress.keyAndMask)).build();
            WOTSPlus wOTSPlus = this.wotsPlus;
            wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(arrby2, oTSHashAddress), arrby);
            WOTSPlusPublicKeyParameters wOTSPlusPublicKeyParameters = this.wotsPlus.getPublicKey(oTSHashAddress);
            LTreeAddress.Builder builder2 = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress.layerAddress)).withTreeAddress(lTreeAddress.treeAddress);
            builder2.lTreeAddress = i2;
            builder2.treeHeight = lTreeAddress.treeHeight;
            builder2.treeIndex = lTreeAddress.treeIndex;
            lTreeAddress = (LTreeAddress)((LTreeAddress.Builder)builder2.withKeyAndMask(lTreeAddress.keyAndMask)).build();
            XMSSNode xMSSNode = Nat576.lTree(this.wotsPlus, wOTSPlusPublicKeyParameters, lTreeAddress);
            HashTreeAddress.Builder builder3 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.layerAddress)).withTreeAddress(hashTreeAddress.treeAddress);
            builder3.treeIndex = i2;
            hashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)builder3.withKeyAndMask(hashTreeAddress.keyAndMask)).build();
            while (!this.stack.isEmpty() && (n3 = ((XMSSNode)this.stack.peek()).height) == (n2 = xMSSNode.height)) {
                int n4;
                int n5;
                int n6;
                int n7 = i2 / (1 << n2);
                if (n7 == 1) {
                    this.authenticationPath.add((Object)xMSSNode);
                }
                if (n7 == 3 && (n4 = xMSSNode.height) < this.treeHeight - this.k) {
                    int n8;
                    BDSTreeHash bDSTreeHash = (BDSTreeHash)this.treeHashInstances.get(n4);
                    bDSTreeHash.tailNode = xMSSNode;
                    bDSTreeHash.height = n8 = xMSSNode.height;
                    if (n8 == bDSTreeHash.initialHeight) {
                        bDSTreeHash.finished = true;
                    }
                }
                if (n7 >= 3 && (n7 & 1) == 1 && (n5 = xMSSNode.height) >= (n6 = this.treeHeight) - this.k && n5 <= n6 - 2) {
                    if (this.retain.get((Object)n5) == null) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add((Object)xMSSNode);
                        this.retain.put((Object)xMSSNode.height, (Object)linkedList);
                    } else {
                        ((LinkedList)this.retain.get((Object)xMSSNode.height)).add((Object)xMSSNode);
                    }
                }
                HashTreeAddress.Builder builder4 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.layerAddress)).withTreeAddress(hashTreeAddress.treeAddress);
                builder4.treeHeight = hashTreeAddress.treeHeight;
                builder4.treeIndex = (hashTreeAddress.treeIndex - 1) / 2;
                HashTreeAddress hashTreeAddress2 = (HashTreeAddress)((HashTreeAddress.Builder)builder4.withKeyAndMask(hashTreeAddress.keyAndMask)).build();
                XMSSNode xMSSNode2 = Nat576.randomizeHash(this.wotsPlus, (XMSSNode)this.stack.pop(), xMSSNode, (XMSSAddress)hashTreeAddress2);
                XMSSNode xMSSNode3 = new XMSSNode(1 + xMSSNode2.height, xMSSNode2.getValue());
                HashTreeAddress.Builder builder5 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.layerAddress)).withTreeAddress(hashTreeAddress2.treeAddress);
                builder5.treeHeight = 1 + hashTreeAddress2.treeHeight;
                builder5.treeIndex = hashTreeAddress2.treeIndex;
                hashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)builder5.withKeyAndMask(hashTreeAddress2.keyAndMask)).build();
                xMSSNode = xMSSNode3;
            }
            this.stack.push((Object)xMSSNode);
        }
        this.root = (XMSSNode)this.stack.pop();
    }

    public final void nextAuthenticationPath(byte[] arrby, byte[] arrby2, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull((Object)oTSHashAddress, (String)"otsHashAddress == null");
        if (!this.used) {
            int n2 = this.index;
            if (n2 <= this.maxIndex - 1) {
                int n3;
                int n4;
                block24 : {
                    int n5 = this.treeHeight;
                    for (n3 = 0; n3 < n5; ++n3) {
                        if ((1 & n2 >> n3) != 0) {
                            continue;
                        }
                        break block24;
                    }
                    n3 = 0;
                }
                if ((1 & this.index >> n3 + 1) == 0 && n3 < this.treeHeight - 1) {
                    this.keep.put((Object)n3, this.authenticationPath.get(n3));
                }
                LTreeAddress lTreeAddress = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress)).build();
                HashTreeAddress hashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress)).build();
                if (n3 == 0) {
                    OTSHashAddress.Builder builder = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress);
                    builder.otsAddress = this.index;
                    builder.chainAddress = oTSHashAddress.chainAddress;
                    builder.hashAddress = oTSHashAddress.hashAddress;
                    oTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)builder.withKeyAndMask(oTSHashAddress.keyAndMask)).build();
                    WOTSPlus wOTSPlus = this.wotsPlus;
                    wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(arrby2, oTSHashAddress), arrby);
                    WOTSPlusPublicKeyParameters wOTSPlusPublicKeyParameters = this.wotsPlus.getPublicKey(oTSHashAddress);
                    LTreeAddress.Builder builder2 = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(lTreeAddress.layerAddress)).withTreeAddress(lTreeAddress.treeAddress);
                    builder2.lTreeAddress = this.index;
                    builder2.treeHeight = lTreeAddress.treeHeight;
                    builder2.treeIndex = lTreeAddress.treeIndex;
                    LTreeAddress lTreeAddress2 = (LTreeAddress)((LTreeAddress.Builder)builder2.withKeyAndMask(lTreeAddress.keyAndMask)).build();
                    XMSSNode xMSSNode = Nat576.lTree(this.wotsPlus, wOTSPlusPublicKeyParameters, lTreeAddress2);
                    this.authenticationPath.set(0, (Object)xMSSNode);
                    n4 = 0;
                } else {
                    int n6;
                    HashTreeAddress.Builder builder = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.layerAddress)).withTreeAddress(hashTreeAddress.treeAddress);
                    builder.treeHeight = n6 = n3 - 1;
                    builder.treeIndex = this.index >> n3;
                    HashTreeAddress hashTreeAddress2 = (HashTreeAddress)((HashTreeAddress.Builder)builder.withKeyAndMask(hashTreeAddress.keyAndMask)).build();
                    WOTSPlus wOTSPlus = this.wotsPlus;
                    wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(arrby2, oTSHashAddress), arrby);
                    XMSSNode xMSSNode = Nat576.randomizeHash(this.wotsPlus, (XMSSNode)this.authenticationPath.get(n6), (XMSSNode)this.keep.get((Object)n6), (XMSSAddress)hashTreeAddress2);
                    XMSSNode xMSSNode2 = new XMSSNode(1 + xMSSNode.height, xMSSNode.getValue());
                    this.authenticationPath.set(n3, (Object)xMSSNode2);
                    this.keep.remove((Object)n6);
                    for (int i2 = 0; i2 < n3; ++i2) {
                        Object object;
                        List<XMSSNode> list;
                        if (i2 < this.treeHeight - this.k) {
                            list = this.authenticationPath;
                            object = ((BDSTreeHash)this.treeHashInstances.get((int)i2)).tailNode;
                        } else {
                            list = this.authenticationPath;
                            object = ((LinkedList)this.retain.get((Object)i2)).removeFirst();
                        }
                        list.set(i2, object);
                    }
                    int n7 = Math.min((int)n3, (int)(this.treeHeight - this.k));
                    int n8 = 0;
                    do {
                        n4 = 0;
                        if (n8 >= n7) break;
                        int n9 = 1 + this.index + 3 * (1 << n8);
                        if (n9 < 1 << this.treeHeight) {
                            BDSTreeHash bDSTreeHash = (BDSTreeHash)this.treeHashInstances.get(n8);
                            bDSTreeHash.tailNode = null;
                            bDSTreeHash.height = bDSTreeHash.initialHeight;
                            bDSTreeHash.nextIndex = n9;
                            bDSTreeHash.initialized = true;
                            bDSTreeHash.finished = false;
                        }
                        ++n8;
                    } while (true);
                }
                while (n4 < this.treeHeight - this.k >> 1) {
                    Iterator iterator = this.treeHashInstances.iterator();
                    BDSTreeHash bDSTreeHash = null;
                    while (iterator.hasNext()) {
                        BDSTreeHash bDSTreeHash2 = (BDSTreeHash)iterator.next();
                        if (bDSTreeHash2.finished || !bDSTreeHash2.initialized || bDSTreeHash != null && bDSTreeHash2.getHeight() >= bDSTreeHash.getHeight() && (bDSTreeHash2.getHeight() != bDSTreeHash.getHeight() || bDSTreeHash2.nextIndex >= bDSTreeHash.nextIndex)) continue;
                        bDSTreeHash = bDSTreeHash2;
                    }
                    if (bDSTreeHash != null) {
                        Stack<XMSSNode> stack = this.stack;
                        WOTSPlus wOTSPlus = this.wotsPlus;
                        if (!bDSTreeHash.finished && bDSTreeHash.initialized) {
                            OTSHashAddress.Builder builder = (OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.layerAddress)).withTreeAddress(oTSHashAddress.treeAddress);
                            builder.otsAddress = bDSTreeHash.nextIndex;
                            builder.chainAddress = oTSHashAddress.chainAddress;
                            builder.hashAddress = oTSHashAddress.hashAddress;
                            OTSHashAddress oTSHashAddress2 = (OTSHashAddress)((OTSHashAddress.Builder)builder.withKeyAndMask(oTSHashAddress.keyAndMask)).build();
                            LTreeAddress.Builder builder3 = (LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(oTSHashAddress2.layerAddress)).withTreeAddress(oTSHashAddress2.treeAddress);
                            builder3.lTreeAddress = bDSTreeHash.nextIndex;
                            LTreeAddress lTreeAddress3 = (LTreeAddress)builder3.build();
                            HashTreeAddress.Builder builder4 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress2.layerAddress)).withTreeAddress(oTSHashAddress2.treeAddress);
                            builder4.treeIndex = bDSTreeHash.nextIndex;
                            HashTreeAddress hashTreeAddress3 = (HashTreeAddress)builder4.build();
                            wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(arrby2, oTSHashAddress2), arrby);
                            XMSSNode xMSSNode = Nat576.lTree(wOTSPlus, wOTSPlus.getPublicKey(oTSHashAddress2), lTreeAddress3);
                            while (!stack.isEmpty() && ((XMSSNode)stack.peek()).height == xMSSNode.height && ((XMSSNode)stack.peek()).height != bDSTreeHash.initialHeight) {
                                HashTreeAddress.Builder builder5 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.layerAddress)).withTreeAddress(hashTreeAddress3.treeAddress);
                                builder5.treeHeight = hashTreeAddress3.treeHeight;
                                builder5.treeIndex = (hashTreeAddress3.treeIndex - 1) / 2;
                                HashTreeAddress hashTreeAddress4 = (HashTreeAddress)((HashTreeAddress.Builder)builder5.withKeyAndMask(hashTreeAddress3.keyAndMask)).build();
                                XMSSNode xMSSNode3 = Nat576.randomizeHash(wOTSPlus, (XMSSNode)stack.pop(), xMSSNode, (XMSSAddress)hashTreeAddress4);
                                XMSSNode xMSSNode4 = new XMSSNode(1 + xMSSNode3.height, xMSSNode3.getValue());
                                HashTreeAddress.Builder builder6 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress4.layerAddress)).withTreeAddress(hashTreeAddress4.treeAddress);
                                builder6.treeHeight = 1 + hashTreeAddress4.treeHeight;
                                builder6.treeIndex = hashTreeAddress4.treeIndex;
                                hashTreeAddress3 = (HashTreeAddress)((HashTreeAddress.Builder)builder6.withKeyAndMask(hashTreeAddress4.keyAndMask)).build();
                                xMSSNode = xMSSNode4;
                            }
                            XMSSNode xMSSNode5 = bDSTreeHash.tailNode;
                            if (xMSSNode5 == null) {
                                bDSTreeHash.tailNode = xMSSNode;
                            } else if (xMSSNode5.height == xMSSNode.height) {
                                HashTreeAddress.Builder builder7 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.layerAddress)).withTreeAddress(hashTreeAddress3.treeAddress);
                                builder7.treeHeight = hashTreeAddress3.treeHeight;
                                builder7.treeIndex = (hashTreeAddress3.treeIndex - 1) / 2;
                                HashTreeAddress hashTreeAddress5 = (HashTreeAddress)((HashTreeAddress.Builder)builder7.withKeyAndMask(hashTreeAddress3.keyAndMask)).build();
                                XMSSNode xMSSNode6 = Nat576.randomizeHash(wOTSPlus, bDSTreeHash.tailNode, xMSSNode, (XMSSAddress)hashTreeAddress5);
                                bDSTreeHash.tailNode = xMSSNode = new XMSSNode(1 + bDSTreeHash.tailNode.height, xMSSNode6.getValue());
                                HashTreeAddress.Builder builder8 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress5.layerAddress)).withTreeAddress(hashTreeAddress5.treeAddress);
                                builder8.treeHeight = 1 + hashTreeAddress5.treeHeight;
                                builder8.treeIndex = hashTreeAddress5.treeIndex;
                                ((HashTreeAddress.Builder)builder8.withKeyAndMask(hashTreeAddress5.keyAndMask)).build();
                            } else {
                                stack.push((Object)xMSSNode);
                            }
                            if (bDSTreeHash.tailNode.height == bDSTreeHash.initialHeight) {
                                bDSTreeHash.finished = true;
                            } else {
                                bDSTreeHash.height = xMSSNode.height;
                                bDSTreeHash.nextIndex = 1 + bDSTreeHash.nextIndex;
                            }
                        } else {
                            throw new IllegalStateException("finished or not initialized");
                        }
                    }
                    ++n4;
                }
                this.index = 1 + this.index;
                return;
            }
            throw new IllegalStateException("index out of bounds");
        }
        throw new IllegalStateException("index already used");
    }
}

