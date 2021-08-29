/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.BasicPermission
 *  java.security.Permission
 *  java.util.StringTokenizer
 */
package org.bouncycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

public class ProviderConfigurationPermission
extends BasicPermission {
    public final String actions;
    public final int permissionMask;

    public ProviderConfigurationPermission(String string, String string2) {
        super(string, string2);
        this.actions = string2;
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.toLowerCase(string2), " ,");
        int n2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String string3 = stringTokenizer.nextToken();
            if (string3.equals((Object)"threadlocalecimplicitlyca")) {
                n2 |= 1;
                continue;
            }
            if (string3.equals((Object)"ecimplicitlyca")) {
                n2 |= 2;
                continue;
            }
            if (string3.equals((Object)"threadlocaldhdefaultparams")) {
                n2 |= 4;
                continue;
            }
            if (string3.equals((Object)"dhdefaultparams")) {
                n2 |= 8;
                continue;
            }
            if (string3.equals((Object)"acceptableeccurves")) {
                n2 |= 16;
                continue;
            }
            if (string3.equals((Object)"additionalecparameters")) {
                n2 |= 32;
                continue;
            }
            if (!string3.equals((Object)"all")) continue;
            n2 |= 63;
        }
        if (n2 != 0) {
            this.permissionMask = n2;
            return;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ProviderConfigurationPermission) {
            ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission)((Object)object);
            return this.permissionMask == providerConfigurationPermission.permissionMask && this.getName().equals((Object)providerConfigurationPermission.getName());
        }
        return false;
    }

    public String getActions() {
        return this.actions;
    }

    public int hashCode() {
        return this.getName().hashCode() + this.permissionMask;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission)) {
            return false;
        }
        if (!this.getName().equals((Object)permission.getName())) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission)permission;
        int n2 = this.permissionMask;
        int n3 = providerConfigurationPermission.permissionMask;
        int n4 = n2 & n3;
        boolean bl = false;
        if (n4 == n3) {
            bl = true;
        }
        return bl;
    }
}

