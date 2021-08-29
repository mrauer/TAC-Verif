/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InvalidClassException
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;

public class XMSSUtil$CheckingStream
extends ObjectInputStream {
    public static final Set components;
    public boolean found = false;
    public final Class mainClass;

    public static {
        HashSet hashSet = new HashSet();
        components = hashSet;
        hashSet.add((Object)"java.util.TreeMap");
        hashSet.add((Object)"java.lang.Integer");
        hashSet.add((Object)"java.lang.Number");
        hashSet.add((Object)"org.bouncycastle.pqc.crypto.xmss.BDS");
        hashSet.add((Object)"java.util.ArrayList");
        hashSet.add((Object)"org.bouncycastle.pqc.crypto.xmss.XMSSNode");
        hashSet.add((Object)"[B");
        hashSet.add((Object)"java.util.LinkedList");
        hashSet.add((Object)"java.util.Stack");
        hashSet.add((Object)"java.util.Vector");
        hashSet.add((Object)"[Ljava.lang.Object;");
        hashSet.add((Object)"org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
    }

    public XMSSUtil$CheckingStream(Class class_, InputStream inputStream) throws IOException {
        super(inputStream);
        this.mainClass = class_;
    }

    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        block5 : {
            block4 : {
                block2 : {
                    block3 : {
                        if (this.found) break block2;
                        if (!objectStreamClass.getName().equals((Object)this.mainClass.getName())) break block3;
                        this.found = true;
                        break block4;
                    }
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
                if (!components.contains((Object)objectStreamClass.getName())) break block5;
            }
            return super.resolveClass(objectStreamClass);
        }
        throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
    }
}

