/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class JavaLoadingKt {
    public static final boolean isObjectMethodInInterface(@NotNull JavaMember $this$isObjectMethodInInterface) {
        Intrinsics.checkNotNullParameter($this$isObjectMethodInInterface, "<this>");
        return $this$isObjectMethodInInterface.getContainingClass().isInterface() && $this$isObjectMethodInInterface instanceof JavaMethod && JavaLoadingKt.isObjectMethod((JavaMethod)$this$isObjectMethodInInterface);
    }

    /*
     * Unable to fully structure code
     */
    private static final boolean isObjectMethod(JavaMethod method) {
        block6: {
            var1_1 = method.getName().asString();
            switch (var1_1.hashCode()) {
                case 147696667: {
                    if (!var1_1.equals("hashCode")) {
                        ** break;
                    }
                    ** GOTO lbl12
                }
                case -1295482945: {
                    if (var1_1.equals("equals")) break;
                    ** break;
                }
                case -1776922004: {
                    if (!var1_1.equals("toString")) ** break;
lbl12:
                    // 2 sources

                    v0 = method.getValueParameters().isEmpty();
                    break block6;
                }
            }
            v0 = JavaLoadingKt.isMethodWithOneObjectParameter(method);
            break block6;
lbl16:
            // 4 sources

            v0 = false;
        }
        return v0;
    }

    private static final boolean isMethodWithOneObjectParameter(JavaMethod method) {
        List<JavaValueParameter> parameters = method.getValueParameters();
        JavaValueParameter javaValueParameter = CollectionsKt.singleOrNull(parameters);
        JavaType javaType = javaValueParameter != null ? javaValueParameter.getType() : null;
        JavaClassifierType javaClassifierType = javaType instanceof JavaClassifierType ? (JavaClassifierType)javaType : null;
        if (javaClassifierType == null) {
            return false;
        }
        JavaClassifierType type = javaClassifierType;
        JavaClassifier classifier = type.getClassifier();
        if (classifier instanceof JavaClass) {
            FqName classFqName = ((JavaClass)classifier).getFqName();
            return classFqName != null && Intrinsics.areEqual(classFqName.asString(), "java.lang.Object");
        }
        return false;
    }
}

