/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\npropertiesConventionUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 propertiesConventionUtil.kt\norg/jetbrains/kotlin/load/java/PropertiesConventionUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n774#2:103\n865#2,2:104\n*S KotlinDebug\n*F\n+ 1 propertiesConventionUtil.kt\norg/jetbrains/kotlin/load/java/PropertiesConventionUtilKt\n*L\n90#1:103\n90#1:104,2\n*E\n"})
public final class PropertiesConventionUtilKt {
    @Nullable
    public static final Name propertyNameByGetMethodName(@NotNull Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Name name = PropertiesConventionUtilKt.propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        if (name == null) {
            name = PropertiesConventionUtilKt.propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null);
        }
        return name;
    }

    @Nullable
    public static final Name propertyNameBySetMethodName(@NotNull Name methodName, boolean withIsPrefix) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return PropertiesConventionUtilKt.propertyNameFromAccessorMethodName$default(methodName, "set", false, withIsPrefix ? "is" : null, 4, null);
    }

    @NotNull
    public static final List<Name> propertyNamesBySetMethodName(@NotNull Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Name[] nameArray = new Name[]{PropertiesConventionUtilKt.propertyNameBySetMethodName(methodName, false), PropertiesConventionUtilKt.propertyNameBySetMethodName(methodName, true)};
        return CollectionsKt.listOfNotNull(nameArray);
    }

    private static final Name propertyNameFromAccessorMethodName(Name methodName, String prefix, boolean removePrefix, String addPrefix) {
        if (methodName.isSpecial()) {
            return null;
        }
        String string = methodName.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(string, "getIdentifier(...)");
        String identifier = string;
        if (!StringsKt.startsWith$default(identifier, prefix, false, 2, null)) {
            return null;
        }
        if (identifier.length() == prefix.length()) {
            return null;
        }
        char c2 = identifier.charAt(prefix.length());
        boolean bl2 = 'a' <= c2 ? c2 < '{' : false;
        if (bl2) {
            return null;
        }
        if (addPrefix != null) {
            if (_Assertions.ENABLED && !removePrefix) {
                String string2 = "Assertion failed";
                throw new AssertionError((Object)string2);
            }
            return Name.identifier(addPrefix + StringsKt.removePrefix(identifier, (CharSequence)prefix));
        }
        if (!removePrefix) {
            return methodName;
        }
        String name = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(identifier, (CharSequence)prefix), true);
        if (!Name.isValidIdentifier(name)) {
            return null;
        }
        return Name.identifier(name);
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String string, boolean bl2, String string2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = true;
        }
        if ((n2 & 8) != 0) {
            string2 = null;
        }
        return PropertiesConventionUtilKt.propertyNameFromAccessorMethodName(name, string, bl2, string2);
    }

    @NotNull
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String string = name.asString();
        Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
        String nameAsString = string;
        if (JvmAbi.isGetterName(nameAsString)) {
            return CollectionsKt.listOfNotNull(PropertiesConventionUtilKt.propertyNameByGetMethodName(name));
        }
        if (JvmAbi.isSetterName(nameAsString)) {
            return PropertiesConventionUtilKt.propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }
}

