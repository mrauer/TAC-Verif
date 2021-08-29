/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.github.fge.jsonschema.keyword.digest.helpers.IdentityDigester
 *  com.github.fge.jsonschema.keyword.digest.helpers.SimpleDigester
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.fge.jsonschema.library;

import com.github.fge.Frozen;
import com.github.fge.Thawed;
import com.github.fge.jackson.NodeType;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.SyntaxChecker;
import com.github.fge.jsonschema.keyword.digest.Digester;
import com.github.fge.jsonschema.keyword.digest.helpers.IdentityDigester;
import com.github.fge.jsonschema.keyword.digest.helpers.SimpleDigester;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.keyword.validator.ReflectionKeywordValidatorFactory;
import com.github.fge.jsonschema.library.Keyword;
import com.github.fge.jsonschema.messages.JsonSchemaConfigurationBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;

public final class KeywordBuilder
implements Thawed<Keyword> {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaConfigurationBundle.class);
    public Digester digester;
    public final String name;
    public SyntaxChecker syntaxChecker;
    public KeywordValidatorFactory validatorFactory;

    public KeywordBuilder(Keyword keyword) {
        this.name = keyword.name;
        this.syntaxChecker = keyword.syntaxChecker;
        this.digester = keyword.digester;
        this.validatorFactory = keyword.validatorFactory;
    }

    public KeywordBuilder(String string) {
        BUNDLE.checkNotNull(string, "nullName");
        this.name = string;
    }

    private static NodeType checkType(NodeType nodeType) {
        BUNDLE.checkNotNull(nodeType, "nullType");
        return nodeType;
    }

    private static /* varargs */ NodeType[] checkTypes(NodeType ... arrnodeType) {
        int n = arrnodeType.length;
        for (int i = 0; i < n; ++i) {
            NodeType nodeType = arrnodeType[i];
            BUNDLE.checkNotNull(nodeType, "nullType");
        }
        return arrnodeType;
    }

    public Keyword freeze() {
        MessageBundle messageBundle = BUNDLE;
        boolean bl = this.syntaxChecker != null;
        Object[] arrobject = new Object[]{this.name};
        messageBundle.checkArgumentPrintf(bl, "noChecker", arrobject);
        boolean bl2 = this.validatorFactory == null || this.digester != null;
        Object[] arrobject2 = new Object[]{this.name};
        messageBundle.checkArgumentPrintf(bl2, "malformedKeyword", arrobject2);
        return new Keyword(this);
    }

    public KeywordBuilder withDigester(Digester digester) {
        MessageBundle messageBundle = BUNDLE;
        Object[] arrobject = new Object[]{this.name};
        messageBundle.checkNotNullPrintf(digester, "nullDigester", arrobject);
        this.digester = digester;
        return this;
    }

    public /* varargs */ KeywordBuilder withIdentityDigester(NodeType nodeType, NodeType ... arrnodeType) {
        this.digester = new IdentityDigester(this.name, KeywordBuilder.checkType(nodeType), KeywordBuilder.checkTypes(arrnodeType));
        return this;
    }

    public /* varargs */ KeywordBuilder withSimpleDigester(NodeType nodeType, NodeType ... arrnodeType) {
        this.digester = new SimpleDigester(this.name, KeywordBuilder.checkType(nodeType), KeywordBuilder.checkTypes(arrnodeType));
        return this;
    }

    public KeywordBuilder withSyntaxChecker(SyntaxChecker syntaxChecker) {
        MessageBundle messageBundle = BUNDLE;
        Object[] arrobject = new Object[]{this.name};
        messageBundle.checkNotNullPrintf(syntaxChecker, "nullSyntaxChecker", arrobject);
        this.syntaxChecker = syntaxChecker;
        return this;
    }

    public KeywordBuilder withValidatorClass(Class<? extends KeywordValidator> class_) {
        this.validatorFactory = new ReflectionKeywordValidatorFactory(this.name, class_);
        return this;
    }

    public KeywordBuilder withValidatorFactory(KeywordValidatorFactory keywordValidatorFactory) {
        this.validatorFactory = keywordValidatorFactory;
        return this;
    }
}

