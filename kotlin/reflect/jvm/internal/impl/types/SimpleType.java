/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public abstract class SimpleType
extends UnwrappedType
implements SimpleTypeMarker,
TypeArgumentListMarker {
    public SimpleType() {
        super(null);
    }

    @Override
    @NotNull
    public abstract SimpleType replaceAttributes(@NotNull TypeAttributes var1);

    @Override
    @NotNull
    public abstract SimpleType makeNullableAsSpecified(boolean var1);

    @NotNull
    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder $this$toString_u24lambda_u240 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        for (AnnotationDescriptor annotation : this.getAnnotations()) {
            String[] stringArray = new String[]{"[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, annotation, null, 2, null), "] "};
            StringsKt.append($this$toString_u24lambda_u240, stringArray);
        }
        $this$toString_u24lambda_u240.append(this.getConstructor());
        if (!((Collection)this.getArguments()).isEmpty()) {
            CollectionsKt.joinTo$default(this.getArguments(), $this$toString_u24lambda_u240, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (this.isMarkedNullable()) {
            $this$toString_u24lambda_u240.append("?");
        }
        return stringBuilder.toString();
    }
}

