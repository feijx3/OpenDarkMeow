/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class ErrorTypeKind
extends Enum<ErrorTypeKind> {
    @NotNull
    private final String debugMessage;
    private final boolean isUnresolved;
    public static final /* enum */ ErrorTypeKind UNRESOLVED_TYPE = new ErrorTypeKind("Unresolved type for %s", true);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_TYPE_PARAMETER_TYPE = new ErrorTypeKind("Unresolved type parameter type", true);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_CLASS_TYPE = new ErrorTypeKind("Unresolved class %s", true);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_JAVA_CLASS = new ErrorTypeKind("Unresolved java class %s", true);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_DECLARATION = new ErrorTypeKind("Unresolved declaration %s", true);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_KCLASS_CONSTANT_VALUE = new ErrorTypeKind("Unresolved type for %s (arrayDimensions=%s)", true);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_TYPE_ALIAS = new ErrorTypeKind("UNRESOLVED_TYPE_ALIAS", 6, "Unresolved type alias %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind RETURN_TYPE = new ErrorTypeKind("RETURN_TYPE", 7, "Return type for %s cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind RETURN_TYPE_FOR_FUNCTION = new ErrorTypeKind("RETURN_TYPE_FOR_FUNCTION", 8, "Return type for function cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind RETURN_TYPE_FOR_PROPERTY = new ErrorTypeKind("RETURN_TYPE_FOR_PROPERTY", 9, "Return type for property %s cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind RETURN_TYPE_FOR_CONSTRUCTOR = new ErrorTypeKind("RETURN_TYPE_FOR_CONSTRUCTOR", 10, "Return type for constructor %s cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind IMPLICIT_RETURN_TYPE_FOR_FUNCTION = new ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_FUNCTION", 11, "Implicit return type for function %s cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind IMPLICIT_RETURN_TYPE_FOR_PROPERTY = new ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_PROPERTY", 12, "Implicit return type for property %s cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR = new ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR", 13, "Implicit return type for property accessor %s cannot be resolved", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT = new ErrorTypeKind("ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT", 14, "%s() return type", false, 2, null);
    public static final /* enum */ ErrorTypeKind RECURSIVE_TYPE = new ErrorTypeKind("RECURSIVE_TYPE", 15, "Recursive type", false, 2, null);
    public static final /* enum */ ErrorTypeKind RECURSIVE_TYPE_ALIAS = new ErrorTypeKind("RECURSIVE_TYPE_ALIAS", 16, "Recursive type alias %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind RECURSIVE_ANNOTATION_TYPE = new ErrorTypeKind("RECURSIVE_ANNOTATION_TYPE", 17, "Recursive annotation's type", false, 2, null);
    public static final /* enum */ ErrorTypeKind CYCLIC_UPPER_BOUNDS = new ErrorTypeKind("CYCLIC_UPPER_BOUNDS", 18, "Cyclic upper bounds", false, 2, null);
    public static final /* enum */ ErrorTypeKind CYCLIC_SUPERTYPES = new ErrorTypeKind("CYCLIC_SUPERTYPES", 19, "Cyclic supertypes", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE = new ErrorTypeKind("UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE", 20, "Cannot infer a lambda context receiver type", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNINFERRED_LAMBDA_PARAMETER_TYPE = new ErrorTypeKind("UNINFERRED_LAMBDA_PARAMETER_TYPE", 21, "Cannot infer a lambda parameter type", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNINFERRED_TYPE_VARIABLE = new ErrorTypeKind("UNINFERRED_TYPE_VARIABLE", 22, "Cannot infer a type variable %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind RESOLUTION_ERROR_TYPE = new ErrorTypeKind("RESOLUTION_ERROR_TYPE", 23, "Resolution error type (%s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_EXPECTED_TYPE = new ErrorTypeKind("ERROR_EXPECTED_TYPE", 24, "Error expected type", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_DATA_FLOW_TYPE = new ErrorTypeKind("ERROR_DATA_FLOW_TYPE", 25, "Error type for data flow", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_WHILE_RECONSTRUCTING_BARE_TYPE = new ErrorTypeKind("ERROR_WHILE_RECONSTRUCTING_BARE_TYPE", 26, "Failed to reconstruct type %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNABLE_TO_SUBSTITUTE_TYPE = new ErrorTypeKind("UNABLE_TO_SUBSTITUTE_TYPE", 27, "Unable to substitute type (%s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind DONT_CARE = new ErrorTypeKind("DONT_CARE", 28, "Special DONT_CARE type", false, 2, null);
    public static final /* enum */ ErrorTypeKind STUB_TYPE = new ErrorTypeKind("STUB_TYPE", 29, "Stub type %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind FUNCTION_PLACEHOLDER_TYPE = new ErrorTypeKind("FUNCTION_PLACEHOLDER_TYPE", 30, "Function placeholder type (arguments: %s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind TYPE_FOR_COMPILER_EXCEPTION = new ErrorTypeKind("TYPE_FOR_COMPILER_EXCEPTION", 31, "Error type for a compiler exception while analyzing %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_FLEXIBLE_TYPE = new ErrorTypeKind("ERROR_FLEXIBLE_TYPE", 32, "Error java flexible type with id %s. (%s..%s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_RAW_TYPE = new ErrorTypeKind("ERROR_RAW_TYPE", 33, "Error raw type %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS = new ErrorTypeKind("TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS", 34, "Inconsistent type %s (parameters.size = %s, arguments.size = %s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind ILLEGAL_TYPE_RANGE_FOR_DYNAMIC = new ErrorTypeKind("ILLEGAL_TYPE_RANGE_FOR_DYNAMIC", 35, "Illegal type range for dynamic type %s..%s", false, 2, null);
    public static final /* enum */ ErrorTypeKind CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER = new ErrorTypeKind("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER", 36, "Unknown type parameter %s. Please try recompiling module containing \"%s\"", false, 2, null);
    public static final /* enum */ ErrorTypeKind CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME = new ErrorTypeKind("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME", 37, "Couldn't deserialize type parameter %s in %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind INCONSISTENT_SUSPEND_FUNCTION = new ErrorTypeKind("INCONSISTENT_SUSPEND_FUNCTION", 38, "Inconsistent suspend function type in metadata with constructor %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNEXPECTED_FLEXIBLE_TYPE_ID = new ErrorTypeKind("UNEXPECTED_FLEXIBLE_TYPE_ID", 39, "Unexpected id of a flexible type %s. (%s..%s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNKNOWN_TYPE = new ErrorTypeKind("UNKNOWN_TYPE", 40, "Unknown type", false, 2, null);
    public static final /* enum */ ErrorTypeKind NO_TYPE_SPECIFIED = new ErrorTypeKind("NO_TYPE_SPECIFIED", 41, "No type specified for %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NO_TYPE_FOR_LOOP_RANGE = new ErrorTypeKind("NO_TYPE_FOR_LOOP_RANGE", 42, "Loop range has no type", false, 2, null);
    public static final /* enum */ ErrorTypeKind NO_TYPE_FOR_LOOP_PARAMETER = new ErrorTypeKind("NO_TYPE_FOR_LOOP_PARAMETER", 43, "Loop parameter has no type", false, 2, null);
    public static final /* enum */ ErrorTypeKind MISSED_TYPE_FOR_PARAMETER = new ErrorTypeKind("MISSED_TYPE_FOR_PARAMETER", 44, "Missed a type for a value parameter %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER = new ErrorTypeKind("MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER", 45, "Missed a type argument for a type parameter %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind PARSE_ERROR_ARGUMENT = new ErrorTypeKind("PARSE_ERROR_ARGUMENT", 46, "Error type for parse error argument %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind STAR_PROJECTION_IN_CALL = new ErrorTypeKind("STAR_PROJECTION_IN_CALL", 47, "Error type for star projection directly passing as a call type argument", false, 2, null);
    public static final /* enum */ ErrorTypeKind PROHIBITED_DYNAMIC_TYPE = new ErrorTypeKind("PROHIBITED_DYNAMIC_TYPE", 48, "Dynamic type in a not allowed context", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT = new ErrorTypeKind("NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT", 49, "Not an annotation type %s in the annotation context", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNIT_RETURN_TYPE_FOR_INC_DEC = new ErrorTypeKind("UNIT_RETURN_TYPE_FOR_INC_DEC", 50, "Unit type returned by inc or dec", false, 2, null);
    public static final /* enum */ ErrorTypeKind RETURN_NOT_ALLOWED = new ErrorTypeKind("RETURN_NOT_ALLOWED", 51, "Return not allowed", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNRESOLVED_PARCEL_TYPE = new ErrorTypeKind("Unresolved 'Parcel' type", true);
    public static final /* enum */ ErrorTypeKind KAPT_ERROR_TYPE = new ErrorTypeKind("KAPT_ERROR_TYPE", 53, "Kapt error type", false, 2, null);
    public static final /* enum */ ErrorTypeKind SYNTHETIC_ELEMENT_ERROR_TYPE = new ErrorTypeKind("SYNTHETIC_ELEMENT_ERROR_TYPE", 54, "Error type for synthetic element", false, 2, null);
    public static final /* enum */ ErrorTypeKind AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE = new ErrorTypeKind("AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE", 55, "Error type in ad hoc resolve for lighter classes", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_EXPRESSION_TYPE = new ErrorTypeKind("ERROR_EXPRESSION_TYPE", 56, "Error expression type", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_RECEIVER_TYPE = new ErrorTypeKind("ERROR_RECEIVER_TYPE", 57, "Error receiver type for %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_CONSTANT_VALUE = new ErrorTypeKind("ERROR_CONSTANT_VALUE", 58, "Error constant value %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind EMPTY_CALLABLE_REFERENCE = new ErrorTypeKind("EMPTY_CALLABLE_REFERENCE", 59, "Empty callable reference", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNSUPPORTED_CALLABLE_REFERENCE_TYPE = new ErrorTypeKind("UNSUPPORTED_CALLABLE_REFERENCE_TYPE", 60, "Unsupported callable reference type %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind TYPE_FOR_DELEGATION = new ErrorTypeKind("TYPE_FOR_DELEGATION", 61, "Error delegation type for %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNAVAILABLE_TYPE_FOR_DECLARATION = new ErrorTypeKind("UNAVAILABLE_TYPE_FOR_DECLARATION", 62, "Type is unavailable for declaration %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_TYPE_PARAMETER = new ErrorTypeKind("ERROR_TYPE_PARAMETER", 63, "Error type parameter", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_TYPE_PROJECTION = new ErrorTypeKind("ERROR_TYPE_PROJECTION", 64, "Error type projection", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_SUPER_TYPE = new ErrorTypeKind("ERROR_SUPER_TYPE", 65, "Error super type", false, 2, null);
    public static final /* enum */ ErrorTypeKind SUPER_TYPE_FOR_ERROR_TYPE = new ErrorTypeKind("SUPER_TYPE_FOR_ERROR_TYPE", 66, "Supertype of error type %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_PROPERTY_TYPE = new ErrorTypeKind("ERROR_PROPERTY_TYPE", 67, "Error property type", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_CLASS = new ErrorTypeKind("ERROR_CLASS", 68, "Error class", false, 2, null);
    public static final /* enum */ ErrorTypeKind TYPE_FOR_ERROR_TYPE_CONSTRUCTOR = new ErrorTypeKind("TYPE_FOR_ERROR_TYPE_CONSTRUCTOR", 69, "Type for error type constructor (%s)", false, 2, null);
    public static final /* enum */ ErrorTypeKind INTERSECTION_OF_ERROR_TYPES = new ErrorTypeKind("INTERSECTION_OF_ERROR_TYPES", 70, "Intersection of error types %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind CANNOT_COMPUTE_ERASED_BOUND = new ErrorTypeKind("CANNOT_COMPUTE_ERASED_BOUND", 71, "Cannot compute erased upper bound of a type parameter %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_FOUND_UNSIGNED_TYPE = new ErrorTypeKind("NOT_FOUND_UNSIGNED_TYPE", 72, "Unsigned type %s not found", false, 2, null);
    public static final /* enum */ ErrorTypeKind ERROR_ENUM_TYPE = new ErrorTypeKind("ERROR_ENUM_TYPE", 73, "Not found the corresponding enum class for given enum entry %s.%s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NO_RECORDED_TYPE = new ErrorTypeKind("NO_RECORDED_TYPE", 74, "Not found recorded type for %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_FOUND_DESCRIPTOR_FOR_FUNCTION = new ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_FUNCTION", 75, "Descriptor not found for function %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_FOUND_DESCRIPTOR_FOR_CLASS = new ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_CLASS", 76, "Cannot build class type, descriptor not found for builder %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER = new ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER", 77, "Cannot build type parameter type, descriptor not found for builder %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNMAPPED_ANNOTATION_TARGET_TYPE = new ErrorTypeKind("UNMAPPED_ANNOTATION_TARGET_TYPE", 78, "Type for unmapped Java annotation target to Kotlin one", false, 2, null);
    public static final /* enum */ ErrorTypeKind UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT = new ErrorTypeKind("UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT", 79, "Unknown type for an array element of a java annotation argument", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION = new ErrorTypeKind("NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION", 80, "No fqName for annotation %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind NOT_FOUND_FQNAME = new ErrorTypeKind("NOT_FOUND_FQNAME", 81, "No fqName for %s", false, 2, null);
    public static final /* enum */ ErrorTypeKind TYPE_FOR_GENERATED_ERROR_EXPRESSION = new ErrorTypeKind("TYPE_FOR_GENERATED_ERROR_EXPRESSION", 82, "Type for generated error expression", false, 2, null);
    private static final /* synthetic */ ErrorTypeKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ErrorTypeKind(String debugMessage, boolean isUnresolved) {
        this.debugMessage = debugMessage;
        this.isUnresolved = isUnresolved;
    }

    /* synthetic */ ErrorTypeKind(String string, int n2, String string2, boolean bl2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        this(string2, bl2);
    }

    @NotNull
    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public final boolean isUnresolved() {
        return this.isUnresolved;
    }

    public static ErrorTypeKind[] values() {
        return (ErrorTypeKind[])$VALUES.clone();
    }

    public static ErrorTypeKind valueOf(String value) {
        return Enum.valueOf(ErrorTypeKind.class, value);
    }

    static {
        $VALUES = errorTypeKindArray = new ErrorTypeKind[]{ErrorTypeKind.UNRESOLVED_TYPE, ErrorTypeKind.UNRESOLVED_TYPE_PARAMETER_TYPE, ErrorTypeKind.UNRESOLVED_CLASS_TYPE, ErrorTypeKind.UNRESOLVED_JAVA_CLASS, ErrorTypeKind.UNRESOLVED_DECLARATION, ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE, ErrorTypeKind.UNRESOLVED_TYPE_ALIAS, ErrorTypeKind.RETURN_TYPE, ErrorTypeKind.RETURN_TYPE_FOR_FUNCTION, ErrorTypeKind.RETURN_TYPE_FOR_PROPERTY, ErrorTypeKind.RETURN_TYPE_FOR_CONSTRUCTOR, ErrorTypeKind.IMPLICIT_RETURN_TYPE_FOR_FUNCTION, ErrorTypeKind.IMPLICIT_RETURN_TYPE_FOR_PROPERTY, ErrorTypeKind.IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR, ErrorTypeKind.ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT, ErrorTypeKind.RECURSIVE_TYPE, ErrorTypeKind.RECURSIVE_TYPE_ALIAS, ErrorTypeKind.RECURSIVE_ANNOTATION_TYPE, ErrorTypeKind.CYCLIC_UPPER_BOUNDS, ErrorTypeKind.CYCLIC_SUPERTYPES, ErrorTypeKind.UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE, ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, ErrorTypeKind.UNINFERRED_TYPE_VARIABLE, ErrorTypeKind.RESOLUTION_ERROR_TYPE, ErrorTypeKind.ERROR_EXPECTED_TYPE, ErrorTypeKind.ERROR_DATA_FLOW_TYPE, ErrorTypeKind.ERROR_WHILE_RECONSTRUCTING_BARE_TYPE, ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, ErrorTypeKind.DONT_CARE, ErrorTypeKind.STUB_TYPE, ErrorTypeKind.FUNCTION_PLACEHOLDER_TYPE, ErrorTypeKind.TYPE_FOR_COMPILER_EXCEPTION, ErrorTypeKind.ERROR_FLEXIBLE_TYPE, ErrorTypeKind.ERROR_RAW_TYPE, ErrorTypeKind.TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS, ErrorTypeKind.ILLEGAL_TYPE_RANGE_FOR_DYNAMIC, ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, ErrorTypeKind.UNEXPECTED_FLEXIBLE_TYPE_ID, ErrorTypeKind.UNKNOWN_TYPE, ErrorTypeKind.NO_TYPE_SPECIFIED, ErrorTypeKind.NO_TYPE_FOR_LOOP_RANGE, ErrorTypeKind.NO_TYPE_FOR_LOOP_PARAMETER, ErrorTypeKind.MISSED_TYPE_FOR_PARAMETER, ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER, ErrorTypeKind.PARSE_ERROR_ARGUMENT, ErrorTypeKind.STAR_PROJECTION_IN_CALL, ErrorTypeKind.PROHIBITED_DYNAMIC_TYPE, ErrorTypeKind.NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT, ErrorTypeKind.UNIT_RETURN_TYPE_FOR_INC_DEC, ErrorTypeKind.RETURN_NOT_ALLOWED, ErrorTypeKind.UNRESOLVED_PARCEL_TYPE, ErrorTypeKind.KAPT_ERROR_TYPE, ErrorTypeKind.SYNTHETIC_ELEMENT_ERROR_TYPE, ErrorTypeKind.AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE, ErrorTypeKind.ERROR_EXPRESSION_TYPE, ErrorTypeKind.ERROR_RECEIVER_TYPE, ErrorTypeKind.ERROR_CONSTANT_VALUE, ErrorTypeKind.EMPTY_CALLABLE_REFERENCE, ErrorTypeKind.UNSUPPORTED_CALLABLE_REFERENCE_TYPE, ErrorTypeKind.TYPE_FOR_DELEGATION, ErrorTypeKind.UNAVAILABLE_TYPE_FOR_DECLARATION, ErrorTypeKind.ERROR_TYPE_PARAMETER, ErrorTypeKind.ERROR_TYPE_PROJECTION, ErrorTypeKind.ERROR_SUPER_TYPE, ErrorTypeKind.SUPER_TYPE_FOR_ERROR_TYPE, ErrorTypeKind.ERROR_PROPERTY_TYPE, ErrorTypeKind.ERROR_CLASS, ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, ErrorTypeKind.ERROR_ENUM_TYPE, ErrorTypeKind.NO_RECORDED_TYPE, ErrorTypeKind.NOT_FOUND_DESCRIPTOR_FOR_FUNCTION, ErrorTypeKind.NOT_FOUND_DESCRIPTOR_FOR_CLASS, ErrorTypeKind.NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER, ErrorTypeKind.UNMAPPED_ANNOTATION_TARGET_TYPE, ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, ErrorTypeKind.NOT_FOUND_FQNAME, ErrorTypeKind.TYPE_FOR_GENERATED_ERROR_EXPRESSION};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

