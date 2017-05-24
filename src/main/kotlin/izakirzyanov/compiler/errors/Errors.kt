package izakirzyanov.compiler.errors

import izakirzyanov.compiler.ast.Op
import izakirzyanov.compiler.ast.Type

sealed class CompileError(message: String, val line: Int, val column: Int) : Exception(message) {

    class SyntaxError(message: String, line: Int, column: Int) :
            CompileError("syntax error - $message.", line, column)

    class VariableIsAlreadyDefinedInThisScope(name: String, line: Int, column: Int) :
            CompileError("variable \"$name\" is already defined in this scope.", line, column)

    class VariableTypeMismatch(name: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("for variable \"$name\": inferred type is \"$actual\", expected is \"$expected\".", line, column)

    class VariableIsNotDefined(name: String, line: Int, column: Int) :
            CompileError("variable \"$name\" is used but not defined.", line, column)



    class FunctionIsAlreadyDefined(name: String, line: Int, column: Int) :
            CompileError("function \"$name\" is already defined.", line, column)

    class FunctionIsNotDefined(name: String, line: Int, column: Int) :
            CompileError("function \"$name\" is called but not defined.", line, column)

    class WrongNumberOfArguments(name: String, actual: Int, expected: Int, line: Int, column: Int) :
            CompileError("function \"$name\" has \"$expected\" arguments but is called with \"$actual\" arguments.", line, column)

    class ArgumentTypeMismatch(name: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("in call of function \"$name\" expected \"$expected\" type but actually passed \"$actual\" as argument.", line, column)

    class FunctionMayNotReturnValue(func: String, line: Int, column: Int) :
            CompileError("function \"$func\" may not return value somewhere but should.", line, column)

    class ReturnTypeMismatch(func: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("function \"$func\" returns \"$actual\" but expected \"$expected\".", line, column)

    class DeadCodeAfterReturn(line: Int, column: Int) :
            CompileError("dead code after this return.", line, column)



    class IfConditionMustBeBoolean(type: Type, line: Int, column: Int) :
            CompileError("if-condition must have \"bool\" but actually have \"$type\".", line, column)

    class LoopConditionMustBeBoolean(type: Type, line: Int, column: Int) :
            CompileError("while-condition must have \"bool\" but actually have \"$type\".", line, column)

    class TypeMismatchInBinaryOperator(op: Op, ltype: Type, rtype: Type, expr: String, line: Int, column: Int) :
            CompileError("binary operator \"$op\" is not defined for the pair (\"$ltype\",\"$rtype\") in expression \"$expr\" .", line, column)

    class TypeMismatchInUnaryOperator(op: Op, type: Type, expr: String, line: Int, column: Int) :
            CompileError("unary operator \"$op\" is not defined for type \"$type\" which expression \"$expr\" is.", line, column)



    class MainFunctionIsMissed :
            CompileError("file should contain main function with signature \"fun main(): void\"", 1, 1)

    class MainFunctionWrongSignature(actual: String, line: Int, column: Int) :
            CompileError("Main function should have signature \"fun main(): void\", but actually has \"$actual\"", line, column)



    class ConstructorTypeMismatch(name: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("constructor for the variable \"$name\" has \"$actual\" type but expected \"$expected\".", line, column)

    class VariableIsNotArray(name: String, type: Type, line: Int, column: Int) :
            CompileError("variable \"$name\" is not array, it has type \"$type\".", line, column)

    class WriteIsNotDefinedForNonPrimitiveTypes(type: Type, line: Int, column: Int) :
            CompileError("write and writeln are defined only for primitive types but the argument has type \"$type\".", line, column)

    class ReservedCanNotBeUsedAsName(name: String, line: Int, column: Int) :
            CompileError("\"$name\" is reserved word; you can not use it as variable name.", line, column)


    override fun toString(): String {
        return "Compiling ERROR at [$line:$column]: $message"
    }
}


