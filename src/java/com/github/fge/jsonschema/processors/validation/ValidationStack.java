/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.JsonNodeFactory
 *  com.github.fge.jackson.jsonpointer.JsonPointer
 *  com.github.fge.jsonschema.core.report.ProcessingMessage
 *  com.github.fge.jsonschema.core.tree.JsonTree
 *  com.github.fge.jsonschema.core.tree.SchemaTree
 *  com.github.fge.jsonschema.processors.data.FullData
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.util.ArrayDeque
 *  java.util.Deque
 *  java.util.Iterator
 */
package com.github.fge.jsonschema.processors.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.ref.JsonRef;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.tree.JsonTree;
import com.github.fge.jsonschema.core.tree.SchemaTree;
import com.github.fge.jsonschema.processors.data.FullData;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public final class ValidationStack {
    private final String errmsg;
    private JsonPointer pointer = null;
    private Deque<SchemaURI> schemaURIs = null;
    private final Deque<Element> validationQueue = new ArrayDeque();

    public ValidationStack(String string) {
        this.errmsg = string;
    }

    private ProcessingMessage validationLoopMessage(FullData fullData) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        Iterator iterator = this.schemaURIs.iterator();
        while (iterator.hasNext()) {
            arrayNode.add(((SchemaURI)iterator.next()).toString());
        }
        return fullData.newMessage().put("domain", "validation").setMessage(this.errmsg).putArgument("alreadyVisited", (Object)new SchemaURI(fullData.getSchema(), null)).putArgument("instancePointer", (Object)this.pointer.toString()).put("validationPath", (JsonNode)arrayNode);
    }

    public void pop() {
        this.schemaURIs.removeLast();
        if (!this.schemaURIs.isEmpty()) {
            return;
        }
        Element element = (Element)this.validationQueue.removeLast();
        this.pointer = element.pointer;
        this.schemaURIs = element.schemaURIs;
    }

    public void push(FullData fullData) throws ProcessingException {
        ArrayDeque arrayDeque;
        JsonPointer jsonPointer = fullData.getInstance().getPointer();
        SchemaURI schemaURI = new SchemaURI(fullData.getSchema(), null);
        if (jsonPointer.equals((Object)this.pointer)) {
            if (!this.schemaURIs.contains((Object)schemaURI)) {
                this.schemaURIs.addLast((Object)schemaURI);
                return;
            }
            throw new ProcessingException(this.validationLoopMessage(fullData));
        }
        this.validationQueue.addLast((Object)new Element(this.pointer, this.schemaURIs, null));
        this.pointer = jsonPointer;
        this.schemaURIs = arrayDeque = new ArrayDeque();
        arrayDeque.addLast((Object)schemaURI);
    }

    public static final class Element {
        private final JsonPointer pointer;
        private final Deque<SchemaURI> schemaURIs;

        private Element(JsonPointer jsonPointer, Deque<SchemaURI> deque) {
            this.pointer = jsonPointer;
            this.schemaURIs = deque;
        }

        public /* synthetic */ Element(JsonPointer jsonPointer, Deque deque, 1 var3_3) {
            this(jsonPointer, (Deque<SchemaURI>)deque);
        }
    }

    public static final class SchemaURI {
        private final JsonRef locator;
        private final JsonPointer pointer;

        private SchemaURI(SchemaTree schemaTree) {
            this.locator = schemaTree.getContext();
            this.pointer = schemaTree.getPointer();
        }

        public /* synthetic */ SchemaURI(SchemaTree schemaTree, 1 var2_2) {
            this(schemaTree);
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (this == object) {
                return true;
            }
            if (SchemaURI.class != object.getClass()) {
                return false;
            }
            SchemaURI schemaURI = (SchemaURI)object;
            boolean bl = this.locator.equals(schemaURI.locator);
            boolean bl2 = false;
            if (bl) {
                boolean bl3 = this.pointer.equals((Object)schemaURI.pointer);
                bl2 = false;
                if (bl3) {
                    bl2 = true;
                }
            }
            return bl2;
        }

        public int hashCode() {
            return this.locator.hashCode() ^ this.pointer.hashCode();
        }

        public String toString() {
            URI uRI;
            try {
                uRI = new URI(null, null, this.pointer.toString());
            }
            catch (URISyntaxException uRISyntaxException) {
                throw new RuntimeException("How did I get there??", (Throwable)uRISyntaxException);
            }
            return this.locator.toURI().resolve(uRI).toString();
        }
    }

}

