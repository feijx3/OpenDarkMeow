/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.internal;

import com.viaversion.viaversion.libs.gson.internal.GsonPreconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

public final class GsonTypes {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private GsonTypes() {
        throw new UnsupportedOperationException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type ownerType, Class<?> rawType, Type ... typeArguments) {
        return new ParameterizedTypeImpl(ownerType, rawType, typeArguments);
    }

    public static GenericArrayType arrayOf(Type componentType) {
        return new GenericArrayTypeImpl(componentType);
    }

    public static WildcardType subtypeOf(Type bound) {
        Type[] upperBounds = bound instanceof WildcardType ? ((WildcardType)bound).getUpperBounds() : new Type[]{bound};
        return new WildcardTypeImpl(upperBounds, EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type bound) {
        Type[] lowerBounds = bound instanceof WildcardType ? ((WildcardType)bound).getLowerBounds() : new Type[]{bound};
        return new WildcardTypeImpl(new Type[]{Object.class}, lowerBounds);
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class c2 = (Class)type;
            return c2.isArray() ? new GenericArrayTypeImpl(GsonTypes.canonicalize(c2.getComponentType())) : c2;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType p2 = (ParameterizedType)type;
            return new ParameterizedTypeImpl(p2.getOwnerType(), (Class)p2.getRawType(), p2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            GenericArrayType g2 = (GenericArrayType)type;
            return new GenericArrayTypeImpl(g2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            WildcardType w2 = (WildcardType)type;
            return new WildcardTypeImpl(w2.getUpperBounds(), w2.getLowerBounds());
        }
        return type;
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type rawType = parameterizedType.getRawType();
            GsonPreconditions.checkArgument(rawType instanceof Class);
            return (Class)rawType;
        }
        if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType)type).getGenericComponentType();
            return Array.newInstance(GsonTypes.getRawType(componentType), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            Type[] bounds = ((WildcardType)type).getUpperBounds();
            assert (bounds.length == 1);
            return GsonTypes.getRawType(bounds[0]);
        }
        String className = type == null ? "null" : type.getClass().getName();
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
    }

    private static boolean equal(Object a2, Object b2) {
        return Objects.equals(a2, b2);
    }

    public static boolean equals(Type a2, Type b2) {
        if (a2 == b2) {
            return true;
        }
        if (a2 instanceof Class) {
            return a2.equals(b2);
        }
        if (a2 instanceof ParameterizedType) {
            if (!(b2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType pa = (ParameterizedType)a2;
            ParameterizedType pb = (ParameterizedType)b2;
            return GsonTypes.equal(pa.getOwnerType(), pb.getOwnerType()) && pa.getRawType().equals(pb.getRawType()) && Arrays.equals(pa.getActualTypeArguments(), pb.getActualTypeArguments());
        }
        if (a2 instanceof GenericArrayType) {
            if (!(b2 instanceof GenericArrayType)) {
                return false;
            }
            GenericArrayType ga2 = (GenericArrayType)a2;
            GenericArrayType gb2 = (GenericArrayType)b2;
            return GsonTypes.equals(ga2.getGenericComponentType(), gb2.getGenericComponentType());
        }
        if (a2 instanceof WildcardType) {
            if (!(b2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wa = (WildcardType)a2;
            WildcardType wb = (WildcardType)b2;
            return Arrays.equals(wa.getUpperBounds(), wb.getUpperBounds()) && Arrays.equals(wa.getLowerBounds(), wb.getLowerBounds());
        }
        if (a2 instanceof TypeVariable) {
            if (!(b2 instanceof TypeVariable)) {
                return false;
            }
            TypeVariable va2 = (TypeVariable)a2;
            TypeVariable vb2 = (TypeVariable)b2;
            return Objects.equals(va2.getGenericDeclaration(), vb2.getGenericDeclaration()) && va2.getName().equals(vb2.getName());
        }
        return false;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class)type).getName() : type.toString();
    }

    private static Type getGenericSupertype(Type context, Class<?> rawType, Class<?> supertype) {
        if (supertype == rawType) {
            return context;
        }
        if (supertype.isInterface()) {
            Class<?>[] interfaces = rawType.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; ++i2) {
                if (interfaces[i2] == supertype) {
                    return rawType.getGenericInterfaces()[i2];
                }
                if (!supertype.isAssignableFrom(interfaces[i2])) continue;
                return GsonTypes.getGenericSupertype(rawType.getGenericInterfaces()[i2], interfaces[i2], supertype);
            }
        }
        if (!rawType.isInterface()) {
            while (rawType != Object.class) {
                Class<?> rawSupertype = rawType.getSuperclass();
                if (rawSupertype == supertype) {
                    return rawType.getGenericSuperclass();
                }
                if (supertype.isAssignableFrom(rawSupertype)) {
                    return GsonTypes.getGenericSupertype(rawType.getGenericSuperclass(), rawSupertype, supertype);
                }
                rawType = rawSupertype;
            }
        }
        return supertype;
    }

    private static Type getSupertype(Type context, Class<?> contextRawType, Class<?> supertype) {
        if (context instanceof WildcardType) {
            Type[] bounds = ((WildcardType)context).getUpperBounds();
            assert (bounds.length == 1);
            context = bounds[0];
        }
        GsonPreconditions.checkArgument(supertype.isAssignableFrom(contextRawType));
        return GsonTypes.resolve(context, contextRawType, GsonTypes.getGenericSupertype(context, contextRawType, supertype));
    }

    public static Type getArrayComponentType(Type array) {
        return array instanceof GenericArrayType ? ((GenericArrayType)array).getGenericComponentType() : ((Class)array).getComponentType();
    }

    public static Type getCollectionElementType(Type context, Class<?> contextRawType) {
        Type collectionType = GsonTypes.getSupertype(context, contextRawType, Collection.class);
        if (collectionType instanceof ParameterizedType) {
            return ((ParameterizedType)collectionType).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type context, Class<?> contextRawType) {
        if (Properties.class.isAssignableFrom(contextRawType)) {
            return new Type[]{String.class, String.class};
        }
        Type mapType = GsonTypes.getSupertype(context, contextRawType, Map.class);
        if (mapType instanceof ParameterizedType) {
            ParameterizedType mapParameterizedType = (ParameterizedType)mapType;
            return mapParameterizedType.getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type resolve(Type context, Class<?> contextRawType, Type toResolve) {
        return GsonTypes.resolve(context, contextRawType, toResolve, new HashMap());
    }

    /*
     * Unable to fully structure code
     */
    private static Type resolve(Type context, Class<?> contextRawType, Type toResolve, Map<TypeVariable<?>, Type> visitedTypeVariables) {
        block8: {
            block12: {
                block11: {
                    block10: {
                        block9: {
                            resolving = null;
                            while (toResolve instanceof TypeVariable) {
                                typeVariable = (TypeVariable)toResolve;
                                previouslyResolved = visitedTypeVariables.get(typeVariable);
                                if (previouslyResolved != null) {
                                    return previouslyResolved == Void.TYPE ? toResolve : previouslyResolved;
                                }
                                visitedTypeVariables.put(typeVariable, Void.TYPE);
                                if (resolving == null) {
                                    resolving = typeVariable;
                                }
                                if ((toResolve = GsonTypes.resolveTypeVariable(context, contextRawType, typeVariable)) != typeVariable) continue;
                                break block8;
                            }
                            if (!(toResolve instanceof Class) || !((Class)toResolve).isArray()) break block9;
                            original = (Class)toResolve;
                            componentType = original.getComponentType();
                            toResolve = GsonTypes.equal(componentType, newComponentType = GsonTypes.resolve(context, contextRawType, componentType, visitedTypeVariables)) != false ? original : GsonTypes.arrayOf(newComponentType);
                            break block8;
                        }
                        if (!(toResolve instanceof GenericArrayType)) break block10;
                        original = (GenericArrayType)toResolve;
                        componentType = original.getGenericComponentType();
                        toResolve = GsonTypes.equal(componentType, newComponentType = GsonTypes.resolve(context, contextRawType, componentType, visitedTypeVariables)) != false ? original : GsonTypes.arrayOf(newComponentType);
                        break block8;
                    }
                    if (!(toResolve instanceof ParameterizedType)) break block11;
                    original = (ParameterizedType)toResolve;
                    ownerType = original.getOwnerType();
                    newOwnerType = GsonTypes.resolve(context, contextRawType, ownerType, visitedTypeVariables);
                    ownerChanged = GsonTypes.equal(newOwnerType, ownerType) == false;
                    args = original.getActualTypeArguments();
                    argsChanged = false;
                    length = args.length;
                    for (t = 0; t < length; ++t) {
                        resolvedTypeArgument = GsonTypes.resolve(context, contextRawType, args[t], visitedTypeVariables);
                        if (GsonTypes.equal(resolvedTypeArgument, args[t])) continue;
                        if (!argsChanged) {
                            args = (Type[])args.clone();
                            argsChanged = true;
                        }
                        args[t] = resolvedTypeArgument;
                    }
                    toResolve = ownerChanged != false || argsChanged != false ? GsonTypes.newParameterizedTypeWithOwner(newOwnerType, (Class)original.getRawType(), args) : original;
                    break block8;
                }
                if (!(toResolve instanceof WildcardType)) break block8;
                original = (WildcardType)toResolve;
                originalLowerBound = original.getLowerBounds();
                originalUpperBound = original.getUpperBounds();
                if (originalLowerBound.length != 1) break block12;
                lowerBound = GsonTypes.resolve(context, contextRawType, originalLowerBound[0], visitedTypeVariables);
                if (lowerBound == originalLowerBound[0]) ** GOTO lbl-1000
                toResolve = GsonTypes.supertypeOf(lowerBound);
                break block8;
            }
            if (originalUpperBound.length == 1 && (upperBound = GsonTypes.resolve(context, contextRawType, originalUpperBound[0], visitedTypeVariables)) != originalUpperBound[0]) {
                toResolve = GsonTypes.subtypeOf(upperBound);
            } else lbl-1000:
            // 2 sources

            {
                toResolve = original;
            }
        }
        if (resolving != null) {
            visitedTypeVariables.put(resolving, toResolve);
        }
        return toResolve;
    }

    private static Type resolveTypeVariable(Type context, Class<?> contextRawType, TypeVariable<?> unknown) {
        Class<?> declaredByRaw = GsonTypes.declaringClassOf(unknown);
        if (declaredByRaw == null) {
            return unknown;
        }
        Type declaredBy = GsonTypes.getGenericSupertype(context, contextRawType, declaredByRaw);
        if (declaredBy instanceof ParameterizedType) {
            int index = GsonTypes.indexOf(declaredByRaw.getTypeParameters(), unknown);
            return ((ParameterizedType)declaredBy).getActualTypeArguments()[index];
        }
        return unknown;
    }

    private static int indexOf(Object[] array, Object toFind) {
        int length = array.length;
        for (int i2 = 0; i2 < length; ++i2) {
            if (!toFind.equals(array[i2])) continue;
            return i2;
        }
        throw new NoSuchElementException();
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class)genericDeclaration : null;
    }

    static void checkNotPrimitive(Type type) {
        GsonPreconditions.checkArgument(!(type instanceof Class) || !((Class)type).isPrimitive());
    }

    public static boolean requiresOwnerType(Type rawType) {
        if (rawType instanceof Class) {
            Class rawTypeAsClass = (Class)rawType;
            return !Modifier.isStatic(rawTypeAsClass.getModifiers()) && rawTypeAsClass.getDeclaringClass() != null;
        }
        return false;
    }

    private static final class WildcardTypeImpl
    implements WildcardType,
    Serializable {
        private final Type upperBound;
        private final Type lowerBound;
        private static final long serialVersionUID = 0L;

        public WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {
            GsonPreconditions.checkArgument(lowerBounds.length <= 1);
            GsonPreconditions.checkArgument(upperBounds.length == 1);
            if (lowerBounds.length == 1) {
                Objects.requireNonNull(lowerBounds[0]);
                GsonTypes.checkNotPrimitive(lowerBounds[0]);
                GsonPreconditions.checkArgument(upperBounds[0] == Object.class);
                this.lowerBound = GsonTypes.canonicalize(lowerBounds[0]);
                this.upperBound = Object.class;
            } else {
                Objects.requireNonNull(upperBounds[0]);
                GsonTypes.checkNotPrimitive(upperBounds[0]);
                this.lowerBound = null;
                this.upperBound = GsonTypes.canonicalize(upperBounds[0]);
            }
        }

        @Override
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override
        public Type[] getLowerBounds() {
            Type[] typeArray;
            if (this.lowerBound != null) {
                Type[] typeArray2 = new Type[1];
                typeArray = typeArray2;
                typeArray2[0] = this.lowerBound;
            } else {
                typeArray = EMPTY_TYPE_ARRAY;
            }
            return typeArray;
        }

        public boolean equals(Object other) {
            return other instanceof WildcardType && GsonTypes.equals(this, (WildcardType)other);
        }

        public int hashCode() {
            return (this.lowerBound != null ? 31 + this.lowerBound.hashCode() : 1) ^ 31 + this.upperBound.hashCode();
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + GsonTypes.typeToString(this.lowerBound);
            }
            if (this.upperBound == Object.class) {
                return "?";
            }
            return "? extends " + GsonTypes.typeToString(this.upperBound);
        }
    }

    private static final class GenericArrayTypeImpl
    implements GenericArrayType,
    Serializable {
        private final Type componentType;
        private static final long serialVersionUID = 0L;

        public GenericArrayTypeImpl(Type componentType) {
            Objects.requireNonNull(componentType);
            this.componentType = GsonTypes.canonicalize(componentType);
        }

        @Override
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object o2) {
            return o2 instanceof GenericArrayType && GsonTypes.equals(this, (GenericArrayType)o2);
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return GsonTypes.typeToString(this.componentType) + "[]";
        }
    }

    private static final class ParameterizedTypeImpl
    implements ParameterizedType,
    Serializable {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;
        private static final long serialVersionUID = 0L;

        public ParameterizedTypeImpl(Type ownerType, Class<?> rawType, Type ... typeArguments) {
            Objects.requireNonNull(rawType);
            if (ownerType == null && GsonTypes.requiresOwnerType(rawType)) {
                throw new IllegalArgumentException("Must specify owner type for " + rawType);
            }
            this.ownerType = ownerType == null ? null : GsonTypes.canonicalize(ownerType);
            this.rawType = GsonTypes.canonicalize(rawType);
            this.typeArguments = (Type[])typeArguments.clone();
            int length = this.typeArguments.length;
            for (int t2 = 0; t2 < length; ++t2) {
                Objects.requireNonNull(this.typeArguments[t2]);
                GsonTypes.checkNotPrimitive(this.typeArguments[t2]);
                this.typeArguments[t2] = GsonTypes.canonicalize(this.typeArguments[t2]);
            }
        }

        @Override
        public Type[] getActualTypeArguments() {
            return (Type[])this.typeArguments.clone();
        }

        @Override
        public Type getRawType() {
            return this.rawType;
        }

        @Override
        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object other) {
            return other instanceof ParameterizedType && GsonTypes.equals(this, (ParameterizedType)other);
        }

        private static int hashCodeOrZero(Object o2) {
            return o2 != null ? o2.hashCode() : 0;
        }

        public int hashCode() {
            return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ ParameterizedTypeImpl.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            int length = this.typeArguments.length;
            if (length == 0) {
                return GsonTypes.typeToString(this.rawType);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (length + 1));
            stringBuilder.append(GsonTypes.typeToString(this.rawType)).append("<").append(GsonTypes.typeToString(this.typeArguments[0]));
            for (int i2 = 1; i2 < length; ++i2) {
                stringBuilder.append(", ").append(GsonTypes.typeToString(this.typeArguments[i2]));
            }
            return stringBuilder.append(">").toString();
        }
    }
}

