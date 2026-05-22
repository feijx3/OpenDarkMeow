/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream$MapMultiConsumer
 *  xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream$MapMultiDoubleConsumer
 *  xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream$MapMultiIntConsumer
 *  xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream$MapMultiLongConsumer
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream;
import xyz.wagyourtail.jvmdg.version.Stub;

@NestMembers(value={J_U_S_Stream.MapMultiDoubleConsumer.class, J_U_S_Stream.MapMultiLongConsumer.class, J_U_S_Stream.MapMultiIntConsumer.class, J_U_S_Stream.MapMultiConsumer.class})
public class J_U_S_Stream {
    private static final Class<?> REF_PIPELINE;

    @Stub
    public static <T> List<T> toList(Stream<T> stream) {
        List<Object> unsafeList = Arrays.asList(stream.toArray());
        if (REF_PIPELINE.isAssignableFrom(stream.getClass())) {
            return Collections.unmodifiableList(unsafeList);
        }
        return Collections.unmodifiableList(new ArrayList<Object>(unsafeList));
    }

    static {
        try {
            REF_PIPELINE = Class.forName("java.util.stream.ReferencePipeline");
        }
        catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }
}

