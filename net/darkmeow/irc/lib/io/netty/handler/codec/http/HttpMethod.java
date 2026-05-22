/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpUtil;
import net.darkmeow.irc.lib.io.netty.util.AsciiString;
import net.darkmeow.irc.lib.io.netty.util.internal.MathUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public class HttpMethod
implements Comparable<HttpMethod> {
    private static final String GET_STRING = "GET";
    private static final String POST_STRING = "POST";
    public static final HttpMethod OPTIONS = new HttpMethod("OPTIONS");
    public static final HttpMethod GET = new HttpMethod("GET");
    public static final HttpMethod HEAD = new HttpMethod("HEAD");
    public static final HttpMethod POST = new HttpMethod("POST");
    public static final HttpMethod PUT = new HttpMethod("PUT");
    public static final HttpMethod PATCH = new HttpMethod("PATCH");
    public static final HttpMethod DELETE = new HttpMethod("DELETE");
    public static final HttpMethod TRACE = new HttpMethod("TRACE");
    public static final HttpMethod CONNECT = new HttpMethod("CONNECT");
    private static final EnumNameMap<HttpMethod> methodMap = new EnumNameMap(new EnumNameMap.Node<HttpMethod>(OPTIONS.toString(), OPTIONS), new EnumNameMap.Node<HttpMethod>(GET.toString(), GET), new EnumNameMap.Node<HttpMethod>(HEAD.toString(), HEAD), new EnumNameMap.Node<HttpMethod>(POST.toString(), POST), new EnumNameMap.Node<HttpMethod>(PUT.toString(), PUT), new EnumNameMap.Node<HttpMethod>(PATCH.toString(), PATCH), new EnumNameMap.Node<HttpMethod>(DELETE.toString(), DELETE), new EnumNameMap.Node<HttpMethod>(TRACE.toString(), TRACE), new EnumNameMap.Node<HttpMethod>(CONNECT.toString(), CONNECT));
    private final AsciiString name;

    public static HttpMethod valueOf(String name) {
        if (name == GET_STRING) {
            return GET;
        }
        if (name == POST_STRING) {
            return POST;
        }
        HttpMethod result = methodMap.get(name);
        return result != null ? result : new HttpMethod(name);
    }

    public HttpMethod(String name) {
        name = ObjectUtil.checkNonEmptyAfterTrim(name, "name");
        int index = HttpUtil.validateToken(name);
        if (index != -1) {
            throw new IllegalArgumentException("Illegal character in HTTP Method: 0x" + Integer.toHexString(name.charAt(index)));
        }
        this.name = AsciiString.cached(name);
    }

    public String name() {
        return this.name.toString();
    }

    public AsciiString asciiName() {
        return this.name;
    }

    public int hashCode() {
        return this.name().hashCode();
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (!(o2 instanceof HttpMethod)) {
            return false;
        }
        HttpMethod that = (HttpMethod)o2;
        return this.name().equals(that.name());
    }

    public String toString() {
        return this.name.toString();
    }

    @Override
    public int compareTo(HttpMethod o2) {
        if (o2 == this) {
            return 0;
        }
        return this.name().compareTo(o2.name());
    }

    private static final class EnumNameMap<T> {
        private final Node<T>[] values;
        private final int valuesMask;

        EnumNameMap(Node<T> ... nodes) {
            this.values = new Node[MathUtil.findNextPositivePowerOfTwo(nodes.length)];
            this.valuesMask = this.values.length - 1;
            for (Node<T> node : nodes) {
                int i2 = EnumNameMap.hashCode(node.key) & this.valuesMask;
                if (this.values[i2] != null) {
                    throw new IllegalArgumentException("index " + i2 + " collision between values: [" + this.values[i2].key + ", " + node.key + ']');
                }
                this.values[i2] = node;
            }
        }

        T get(String name) {
            Node<T> node = this.values[EnumNameMap.hashCode(name) & this.valuesMask];
            return node == null || !node.key.equals(name) ? null : (T)node.value;
        }

        private static int hashCode(String name) {
            return name.hashCode() >>> 6;
        }

        private static final class Node<T> {
            final String key;
            final T value;

            Node(String key, T value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}

