/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;

public final class NameResolverImpl
implements NameResolver {
    @NotNull
    private final ProtoBuf.StringTable strings;
    @NotNull
    private final ProtoBuf.QualifiedNameTable qualifiedNames;

    public NameResolverImpl(@NotNull ProtoBuf.StringTable strings, @NotNull ProtoBuf.QualifiedNameTable qualifiedNames) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }

    @Override
    @NotNull
    public String getString(int index) {
        String string = this.strings.getString(index);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override
    @NotNull
    public String getQualifiedClassName(int index) {
        Triple<List<String>, List<String>, Boolean> triple = this.traverseIds(index);
        List<String> packageFqNameSegments = triple.component1();
        List<String> relativeClassNameSegments = triple.component2();
        String className = CollectionsKt.joinToString$default(relativeClassNameSegments, ".", null, null, 0, null, null, 62, null);
        return packageFqNameSegments.isEmpty() ? className : CollectionsKt.joinToString$default(packageFqNameSegments, "/", null, null, 0, null, null, 62, null) + '/' + className;
    }

    @Override
    public boolean isLocalClassName(int index) {
        return this.traverseIds(index).getThird();
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int startingIndex) {
        int index = startingIndex;
        LinkedList<String> packageNameSegments = new LinkedList<String>();
        LinkedList<String> relativeClassNameSegments = new LinkedList<String>();
        boolean local = false;
        while (index != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName proto = this.qualifiedNames.getQualifiedName(index);
            String shortName = this.strings.getString(proto.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind2 = proto.getKind();
            Intrinsics.checkNotNull(kind2);
            switch (WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
                case 1: {
                    relativeClassNameSegments.addFirst(shortName);
                    break;
                }
                case 2: {
                    packageNameSegments.addFirst(shortName);
                    break;
                }
                case 3: {
                    relativeClassNameSegments.addFirst(shortName);
                    local = true;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            index = proto.getParentQualifiedName();
        }
        return new Triple<List<String>, List<String>, Boolean>(packageNameSegments, relativeClassNameSegments, local);
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                nArray[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

