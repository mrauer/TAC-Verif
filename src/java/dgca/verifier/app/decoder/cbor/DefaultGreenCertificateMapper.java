/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonFactory
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.core.JsonToken
 *  com.fasterxml.jackson.databind.DeserializationConfig
 *  com.fasterxml.jackson.databind.DeserializationContext
 *  com.fasterxml.jackson.databind.DeserializationFeature
 *  com.fasterxml.jackson.databind.JavaType
 *  com.fasterxml.jackson.databind.JsonDeserializer
 *  com.fasterxml.jackson.databind.Module
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
 *  com.fasterxml.jackson.databind.deser.DefaultDeserializationContext$Impl
 *  com.fasterxml.jackson.databind.exc.MismatchedInputException
 *  com.fasterxml.jackson.databind.module.SimpleDeserializers
 *  com.fasterxml.jackson.databind.module.SimpleModule
 *  com.fasterxml.jackson.databind.type.ClassKey
 *  com.fasterxml.jackson.databind.type.ClassStack
 *  com.fasterxml.jackson.databind.type.TypeBindings
 *  com.fasterxml.jackson.databind.type.TypeFactory
 *  com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper
 *  dgca.verifier.app.decoder.cbor.DefaultGreenCertificateMapper$1
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.util.HashMap
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package dgca.verifier.app.decoder.cbor;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.ClassStack;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;
import com.upokecenter.cbor.CBORObject;
import dgca.verifier.app.decoder.cbor.DefaultGreenCertificateMapper;
import dgca.verifier.app.decoder.model.GreenCertificate;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public final class DefaultGreenCertificateMapper
extends CBORMapper {
    public DefaultGreenCertificateMapper() {
        SimpleModule simpleModule = new SimpleModule();
        JsonDeserializer<String> jsonDeserializer = new JsonDeserializer<String>(){

            public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
                if (jsonParser == null) {
                    return null;
                }
                String string = jsonParser.getValueAsString();
                if (string == null) {
                    return null;
                }
                return kotlin.text.StringsKt__IndentKt.trim((java.lang.CharSequence)string).toString();
            }
        };
        simpleModule._checkNotNull(String.class, "type to register deserializer for");
        simpleModule._checkNotNull((Object)jsonDeserializer, "deserializer");
        if (simpleModule._deserializers == null) {
            simpleModule._deserializers = new SimpleDeserializers();
        }
        SimpleDeserializers simpleDeserializers = simpleModule._deserializers;
        Objects.requireNonNull((Object)simpleDeserializers);
        ClassKey classKey = new ClassKey(String.class);
        if (simpleDeserializers._classMappings == null) {
            simpleDeserializers._classMappings = new HashMap();
        }
        simpleDeserializers._classMappings.put((Object)classKey, (Object)jsonDeserializer);
        this.registerModule((Module)simpleModule);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public GreenCertificate readValue(CBORObject cBORObject) {
        JsonParser jsonParser;
        Object object;
        block15 : {
            Intrinsics.checkNotNullParameter((Object)cBORObject, (String)"cborObject");
            byte[] arrby = cBORObject.EncodeToBytes();
            this._assertNotNull("src", (Object)arrby);
            jsonParser = ((ObjectMapper)this)._jsonFactory.createParser(arrby);
            JavaType javaType = ((ObjectMapper)this)._typeFactory._fromAny(null, GreenCertificate.class, TypeFactory.EMPTY_BINDINGS);
            try {
                JsonToken jsonToken;
                int n2;
                DeserializationConfig deserializationConfig = ((ObjectMapper)this)._deserializationConfig;
                DefaultDeserializationContext.Impl impl = new DefaultDeserializationContext.Impl((DefaultDeserializationContext.Impl)((ObjectMapper)this)._deserializationContext, deserializationConfig, jsonParser);
                DeserializationConfig deserializationConfig2 = ((ObjectMapper)this)._deserializationConfig;
                int n3 = deserializationConfig2._parserFeaturesToChange;
                if (n3 != 0) {
                    jsonParser.overrideStdFeatures(deserializationConfig2._parserFeatures, n3);
                }
                if ((n2 = deserializationConfig2._formatReadFeaturesToChange) != 0) {
                    jsonParser.overrideFormatFeatures(deserializationConfig2._formatReadFeatures, n2);
                }
                if ((jsonToken = jsonParser.currentToken()) == null) {
                    jsonToken = jsonParser.nextToken();
                    if (jsonToken == null) throw new MismatchedInputException(jsonParser, "No content to map due to end-of-input", javaType);
                }
                if (jsonToken == JsonToken.VALUE_NULL) {
                    object = this._findRootDeserializer((DeserializationContext)impl, javaType).getNullValue((DeserializationContext)impl);
                } else {
                    JsonToken jsonToken2 = JsonToken.END_ARRAY;
                    object = null;
                    if (jsonToken != jsonToken2) {
                        if (jsonToken == JsonToken.END_OBJECT) {
                            object = null;
                        } else {
                            object = impl.readRootValue(jsonParser, javaType, this._findRootDeserializer((DeserializationContext)impl, javaType), null);
                            impl.checkUnresolvedObjectId();
                        }
                    }
                }
                if (!deserializationConfig.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) break block15;
                this._verifyNoTrailingTokens(jsonParser, (DeserializationContext)impl, javaType);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    if (jsonParser == null) throw throwable2;
                    try {
                        jsonParser.close();
                        throw throwable2;
                    }
                    catch (Throwable throwable3) {
                        throwable.addSuppressed(throwable3);
                    }
                    throw throwable2;
                }
            }
        }
        jsonParser.close();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"readValue(bytes, GreenCertificate::class.java)");
        return (GreenCertificate)object;
    }
}

