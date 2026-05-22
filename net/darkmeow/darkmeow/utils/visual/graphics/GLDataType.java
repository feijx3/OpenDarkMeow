/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.visual.graphics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/GLDataType;", "", "glEnum", "", "size", "<init>", "(Ljava/lang/String;III)V", "getGlEnum", "()I", "getSize", "GL_BYTE", "GL_UNSIGNED_BYTE", "GL_SHORT", "GL_UNSIGNED_SHORT", "GL_INT", "GL_UNSIGNED_INT", "GL_FLOAT", "DarkMeow"})
public final class GLDataType
extends Enum<GLDataType> {
    private final int glEnum;
    private final int size;
    public static final /* enum */ GLDataType GL_BYTE = new GLDataType(5120, 1);
    public static final /* enum */ GLDataType GL_UNSIGNED_BYTE = new GLDataType(5121, 1);
    public static final /* enum */ GLDataType GL_SHORT = new GLDataType(5122, 2);
    public static final /* enum */ GLDataType GL_UNSIGNED_SHORT = new GLDataType(5123, 2);
    public static final /* enum */ GLDataType GL_INT = new GLDataType(5124, 4);
    public static final /* enum */ GLDataType GL_UNSIGNED_INT = new GLDataType(5125, 4);
    public static final /* enum */ GLDataType GL_FLOAT = new GLDataType(5126, 4);
    private static final /* synthetic */ GLDataType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private GLDataType(int glEnum, int size) {
        this.glEnum = glEnum;
        this.size = size;
    }

    public final int getGlEnum() {
        return this.glEnum;
    }

    public final int getSize() {
        return this.size;
    }

    public static GLDataType[] values() {
        return (GLDataType[])$VALUES.clone();
    }

    public static GLDataType valueOf(String value) {
        return Enum.valueOf(GLDataType.class, value);
    }

    @NotNull
    public static EnumEntries<GLDataType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = gLDataTypeArray = new GLDataType[]{GLDataType.GL_BYTE, GLDataType.GL_UNSIGNED_BYTE, GLDataType.GL_SHORT, GLDataType.GL_UNSIGNED_SHORT, GLDataType.GL_INT, GLDataType.GL_UNSIGNED_INT, GLDataType.GL_FLOAT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

