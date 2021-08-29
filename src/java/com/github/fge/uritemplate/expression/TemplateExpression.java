/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.List
 */
package com.github.fge.uritemplate.expression;

import com.github.fge.uritemplate.expression.ExpressionType;
import com.github.fge.uritemplate.expression.URITemplateExpression;
import com.github.fge.uritemplate.vars.specs.VariableSpec;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class TemplateExpression
implements URITemplateExpression {
    public final ExpressionType expressionType;
    public final List<VariableSpec> variableSpecs;

    public TemplateExpression(ExpressionType expressionType, List<VariableSpec> list) {
        this.expressionType = expressionType;
        this.variableSpecs = ImmutableList.copyOf(list);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (TemplateExpression.class != object.getClass()) {
            return false;
        }
        TemplateExpression templateExpression = (TemplateExpression)object;
        ExpressionType expressionType = this.expressionType;
        ExpressionType expressionType2 = templateExpression.expressionType;
        boolean bl = false;
        if (expressionType == expressionType2) {
            boolean bl2 = this.variableSpecs.equals(templateExpression.variableSpecs);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    public int hashCode() {
        return 31 * this.expressionType.hashCode() + this.variableSpecs.hashCode();
    }
}

