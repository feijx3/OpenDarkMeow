/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nValueClassRepresentation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/ValueClassRepresentation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,51:1\n1563#2:52\n1634#2,3:53\n*S KotlinDebug\n*F\n+ 1 ValueClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/ValueClassRepresentation\n*L\n23#1:52\n23#1:53,3\n*E\n"})
public abstract class ValueClassRepresentation<Type extends RigidTypeMarker> {
    private ValueClassRepresentation() {
    }

    public abstract boolean containsPropertyWithName(@NotNull Name var1);

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(@NotNull Function1<? super Type, ? extends Other> transform) {
        ValueClassRepresentation valueClassRepresentation;
        Intrinsics.checkNotNullParameter(transform, "transform");
        ValueClassRepresentation valueClassRepresentation2 = this;
        if (valueClassRepresentation2 instanceof InlineClassRepresentation) {
            valueClassRepresentation = new InlineClassRepresentation<RigidTypeMarker>(((InlineClassRepresentation)this).getUnderlyingPropertyName(), (RigidTypeMarker)transform.invoke(((InlineClassRepresentation)this).getUnderlyingType()));
        } else if (valueClassRepresentation2 instanceof MultiFieldValueClassRepresentation) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = ((MultiFieldValueClassRepresentation)this).getUnderlyingPropertyNamesToTypes();
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Pair pair = (Pair)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                Name name = (Name)pair.component1();
                RigidTypeMarker type = (RigidTypeMarker)pair.component2();
                collection.add(TuplesKt.to(name, transform.invoke(type)));
            }
            List list = (List)destination$iv$iv;
            valueClassRepresentation = new MultiFieldValueClassRepresentation(list);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return valueClassRepresentation;
    }

    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

