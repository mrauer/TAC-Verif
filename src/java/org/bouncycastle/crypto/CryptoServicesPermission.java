/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Permission
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
package org.bouncycastle.crypto;

import java.security.Permission;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CryptoServicesPermission
extends Permission {
    public final Set<String> actions;

    public CryptoServicesPermission(String string) {
        HashSet hashSet;
        super(string);
        this.actions = hashSet = new HashSet();
        hashSet.add((Object)string);
    }

    public boolean equals(Object object) {
        if (object instanceof CryptoServicesPermission) {
            CryptoServicesPermission cryptoServicesPermission = (CryptoServicesPermission)((Object)object);
            if (this.actions.equals(cryptoServicesPermission.actions)) {
                return true;
            }
        }
        return false;
    }

    public String getActions() {
        return this.actions.toString();
    }

    public int hashCode() {
        return this.actions.hashCode();
    }

    public boolean implies(Permission permission) {
        if (permission instanceof CryptoServicesPermission) {
            CryptoServicesPermission cryptoServicesPermission = (CryptoServicesPermission)permission;
            if (this.getName().equals((Object)cryptoServicesPermission.getName())) {
                return true;
            }
            if (this.actions.containsAll(cryptoServicesPermission.actions)) {
                return true;
            }
        }
        return false;
    }
}

