/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReadKotlinClassHeaderAnnotationVisitor
implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static boolean IGNORE_OLD_METADATA;
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS;
    private int[] metadataVersionArray = null;
    private String extraString = null;
    private int extraInt = 0;
    private String packageName = null;
    private String[] data = null;
    private String[] strings = null;
    private String[] incompatibleData = null;
    private KotlinClassHeader.Kind headerKind = null;
    private String[] serializedIrFields = null;

    @Nullable
    public KotlinClassHeader createHeaderWithDefaultMetadataVersion() {
        return this.createHeader(MetadataVersion.INSTANCE);
    }

    @Nullable
    public KotlinClassHeader createHeader(MetadataVersion metadataVersionFromLanguageVersion) {
        if (this.headerKind == null || this.metadataVersionArray == null) {
            return null;
        }
        MetadataVersion metadataVersion = new MetadataVersion(this.metadataVersionArray, (this.extraInt & 8) != 0);
        if (!metadataVersion.isCompatible(metadataVersionFromLanguageVersion)) {
            this.incompatibleData = this.data;
            this.data = null;
        } else if (this.shouldHaveData() && this.data == null) {
            return null;
        }
        byte[] serializedIr = null;
        if (this.serializedIrFields != null) {
            serializedIr = BitEncoding.decodeBytes(this.serializedIrFields);
        }
        return new KotlinClassHeader(this.headerKind, metadataVersion, this.data, this.incompatibleData, this.strings, this.extraString, this.extraInt, this.packageName, serializedIr);
    }

    private boolean shouldHaveData() {
        return this.headerKind == KotlinClassHeader.Kind.CLASS || this.headerKind == KotlinClassHeader.Kind.FILE_FACADE || this.headerKind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Override
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement source) {
        FqName fqName;
        if (classId == null) {
            ReadKotlinClassHeaderAnnotationVisitor.$$$reportNull$$$0(0);
        }
        if (source == null) {
            ReadKotlinClassHeaderAnnotationVisitor.$$$reportNull$$$0(1);
        }
        if ((fqName = classId.asSingleFqName()).equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new KotlinMetadataArgumentVisitor();
        }
        if (fqName.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME)) {
            return new KotlinSerializedIrArgumentVisitor();
        }
        if (IGNORE_OLD_METADATA) {
            return null;
        }
        if (this.headerKind != null) {
            return null;
        }
        KotlinClassHeader.Kind newKind = HEADER_KINDS.get(classId);
        if (newKind != null) {
            this.headerKind = newKind;
            return new OldDeprecatedAnnotationArgumentVisitor();
        }
        return null;
    }

    @Override
    public void visitEnd() {
    }

    static /* synthetic */ int[] access$402(ReadKotlinClassHeaderAnnotationVisitor x0, int[] x1) {
        x0.metadataVersionArray = x1;
        return x1;
    }

    static /* synthetic */ String[] access$802(ReadKotlinClassHeaderAnnotationVisitor x0, String[] x1) {
        x0.data = x1;
        return x1;
    }

    static /* synthetic */ String[] access$902(ReadKotlinClassHeaderAnnotationVisitor x0, String[] x1) {
        x0.strings = x1;
        return x1;
    }

    static /* synthetic */ String[] access$1002(ReadKotlinClassHeaderAnnotationVisitor x0, String[] x1) {
        x0.serializedIrFields = x1;
        return x1;
    }

    static {
        try {
            IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        }
        catch (AccessControlException e2) {
            IGNORE_OLD_METADATA = false;
        }
        HEADER_KINDS = new HashMap<ClassId, KotlinClassHeader.Kind>();
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        Object[] objectArray;
        Object[] objectArray2 = new Object[3];
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[0] = "classId";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[0] = "source";
                break;
            }
        }
        objectArray[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objectArray[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }

    private static abstract class CollectStringArrayAnnotationVisitor
    implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings = new ArrayList<String>();

        @Override
        public void visit(@Nullable Object value) {
            if (value instanceof String) {
                this.strings.add((String)value);
            }
        }

        @Override
        public void visitEnum(@NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (enumClassId == null) {
                CollectStringArrayAnnotationVisitor.$$$reportNull$$$0(0);
            }
            if (enumEntryName == null) {
                CollectStringArrayAnnotationVisitor.$$$reportNull$$$0(1);
            }
        }

        @Override
        public void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                CollectStringArrayAnnotationVisitor.$$$reportNull$$$0(2);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId) {
            if (classId == null) {
                CollectStringArrayAnnotationVisitor.$$$reportNull$$$0(3);
            }
            return null;
        }

        @Override
        public void visitEnd() {
            this.visitEnd(this.strings.toArray(new String[0]));
        }

        protected abstract void visitEnd(@NotNull String[] var1);

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumClassId";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumEntryName";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classLiteralValue";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classId";
                    break;
                }
            }
            objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitEnum";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitClassLiteral";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitAnnotation";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }

    private class KotlinSerializedIrArgumentVisitor
    implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private KotlinSerializedIrArgumentVisitor() {
        }

        @Override
        public void visit(@Nullable Name name, @Nullable Object value) {
        }

        @Override
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                KotlinSerializedIrArgumentVisitor.$$$reportNull$$$0(0);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            String string;
            String string2 = string = name != null ? name.asString() : null;
            if ("b".equals(string)) {
                return this.serializedIrArrayVisitor();
            }
            return null;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] result) {
                    if (result == null) {
                        1.$$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$1002(ReadKotlinClassHeaderAnnotationVisitor.this, result);
                }

                private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
                }
            };
        }

        @Override
        public void visitEnum(@Nullable Name name, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (enumClassId == null) {
                KotlinSerializedIrArgumentVisitor.$$$reportNull$$$0(1);
            }
            if (enumEntryName == null) {
                KotlinSerializedIrArgumentVisitor.$$$reportNull$$$0(2);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            if (classId == null) {
                KotlinSerializedIrArgumentVisitor.$$$reportNull$$$0(3);
            }
            return null;
        }

        @Override
        public void visitEnd() {
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classLiteralValue";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumClassId";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumEntryName";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classId";
                    break;
                }
            }
            objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitClassLiteral";
                    break;
                }
                case 1: 
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitEnum";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitAnnotation";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }

    private class OldDeprecatedAnnotationArgumentVisitor
    implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private OldDeprecatedAnnotationArgumentVisitor() {
        }

        @Override
        public void visit(@Nullable Name name, @Nullable Object value) {
            if (name == null) {
                return;
            }
            String string = name.asString();
            if ("version".equals(string)) {
                if (value instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.access$402(ReadKotlinClassHeaderAnnotationVisitor.this, (int[])value);
                }
            } else if ("multifileClassName".equals(string)) {
                ReadKotlinClassHeaderAnnotationVisitor.this.extraString = value instanceof String ? (String)value : null;
            }
        }

        @Override
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                OldDeprecatedAnnotationArgumentVisitor.$$$reportNull$$$0(0);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            String string;
            String string2 = string = name != null ? name.asString() : null;
            if ("data".equals(string) || "filePartClassNames".equals(string)) {
                return this.dataArrayVisitor();
            }
            if ("strings".equals(string)) {
                return this.stringsArrayVisitor();
            }
            return null;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] data) {
                    if (data == null) {
                        1.$$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$802(ReadKotlinClassHeaderAnnotationVisitor.this, data);
                }

                private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
                }
            };
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] data) {
                    if (data == null) {
                        2.$$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$902(ReadKotlinClassHeaderAnnotationVisitor.this, data);
                }

                private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
                }
            };
        }

        @Override
        public void visitEnum(@Nullable Name name, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (enumClassId == null) {
                OldDeprecatedAnnotationArgumentVisitor.$$$reportNull$$$0(1);
            }
            if (enumEntryName == null) {
                OldDeprecatedAnnotationArgumentVisitor.$$$reportNull$$$0(2);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            if (classId == null) {
                OldDeprecatedAnnotationArgumentVisitor.$$$reportNull$$$0(3);
            }
            return null;
        }

        @Override
        public void visitEnd() {
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classLiteralValue";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumClassId";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumEntryName";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classId";
                    break;
                }
            }
            objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitClassLiteral";
                    break;
                }
                case 1: 
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitEnum";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitAnnotation";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }

    private class KotlinMetadataArgumentVisitor
    implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private KotlinMetadataArgumentVisitor() {
        }

        @Override
        public void visit(@Nullable Name name, @Nullable Object value) {
            if (name == null) {
                return;
            }
            String string = name.asString();
            if ("k".equals(string)) {
                if (value instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.headerKind = KotlinClassHeader.Kind.getById((Integer)value);
                }
            } else if ("mv".equals(string)) {
                if (value instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.access$402(ReadKotlinClassHeaderAnnotationVisitor.this, (int[])value);
                }
            } else if ("xs".equals(string)) {
                if (value instanceof String && !((String)value).isEmpty()) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.extraString = (String)value;
                }
            } else if ("xi".equals(string)) {
                if (value instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.extraInt = (Integer)value;
                }
            } else if ("pn".equals(string) && value instanceof String && !((String)value).isEmpty()) {
                ReadKotlinClassHeaderAnnotationVisitor.this.packageName = (String)value;
            }
        }

        @Override
        public void visitClassLiteral(@Nullable Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                KotlinMetadataArgumentVisitor.$$$reportNull$$$0(0);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name) {
            String string;
            String string2 = string = name != null ? name.asString() : null;
            if ("d1".equals(string)) {
                return this.dataArrayVisitor();
            }
            if ("d2".equals(string)) {
                return this.stringsArrayVisitor();
            }
            return null;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] result) {
                    if (result == null) {
                        1.$$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$802(ReadKotlinClassHeaderAnnotationVisitor.this, result);
                }

                private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
                }
            };
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] result) {
                    if (result == null) {
                        2.$$$reportNull$$$0(0);
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$902(ReadKotlinClassHeaderAnnotationVisitor.this, result);
                }

                private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
                }
            };
        }

        @Override
        public void visitEnum(@Nullable Name name, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (enumClassId == null) {
                KotlinMetadataArgumentVisitor.$$$reportNull$$$0(1);
            }
            if (enumEntryName == null) {
                KotlinMetadataArgumentVisitor.$$$reportNull$$$0(2);
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name, @NotNull ClassId classId) {
            if (classId == null) {
                KotlinMetadataArgumentVisitor.$$$reportNull$$$0(3);
            }
            return null;
        }

        @Override
        public void visitEnd() {
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classLiteralValue";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumClassId";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "enumEntryName";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "classId";
                    break;
                }
            }
            objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitClassLiteral";
                    break;
                }
                case 1: 
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitEnum";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visitAnnotation";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }
}

