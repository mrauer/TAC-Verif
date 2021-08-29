/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.util.Locale
 *  java.util.Objects
 */
package com.github.fge.jsonschema.keyword.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import com.github.fge.jsonschema.messages.JsonSchemaConfigurationBundle;
import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.load.MessageBundles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Objects;

public class ReflectionKeywordValidatorFactory
implements KeywordValidatorFactory {
    private static final MessageBundle BUNDLE = MessageBundles.getBundle(JsonSchemaConfigurationBundle.class);
    private static final String ERRMSG = "failed to build keyword validator";
    private final Constructor<? extends KeywordValidator> constructor;

    public ReflectionKeywordValidatorFactory(String string, Class<? extends KeywordValidator> class_) {
        try {
            this.constructor = class_.getConstructor(new Class[]{JsonNode.class});
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            MessageBundle messageBundle = BUNDLE;
            Object[] arrobject = new Object[]{string, class_.getCanonicalName()};
            Objects.requireNonNull((Object)messageBundle);
            throw new IllegalArgumentException(messageBundle.printf(Locale.getDefault(), "noAppropriateConstructor", arrobject));
        }
    }

    @Override
    public KeywordValidator getKeywordValidator(JsonNode jsonNode) throws ProcessingException {
        try {
            KeywordValidator keywordValidator = (KeywordValidator)this.constructor.newInstance(new Object[]{jsonNode});
            return keywordValidator;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new ProcessingException(ERRMSG, (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ProcessingException(ERRMSG, (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new ProcessingException(ERRMSG, (Throwable)instantiationException);
        }
    }
}

