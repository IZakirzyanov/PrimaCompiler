package izakirzyanov.compiler.errors

import izakirzyanov.compiler.ast.Type

sealed class CompileError(message: String, val line: Int, val column: Int) : Exception(message) {

    class SyntaxError(message: String, line: Int, column: Int) :
            CompileError("syntax error - $message.", line, column)

    class VariableIsAlreadyDefinedInThisScope(name: String, line: Int, column: Int) :
            CompileError("variable \"$name\" is already defined in this scope.", line, column)

    class FunctionIsAlreadyDefined(name: String, line: Int, column: Int) :
            CompileError("function \"$name\" is already defined.", line, column)

    class DuplicatedArgument(name: String, line: Int, column: Int) :
            CompileError("argument \"$name\" is defined more than once.", line, column)

    class ReturnTypeMismatch(func: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("The function \"$func\" returns \"$actual\" but expected \"$expected\".", line, column)

    class VariableTypeMismatch(name: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("The variable \"$name\" has \"$actual\" type but expected \"$expected\".", line, column)

    class VariableIsNotDefined(name: String, line: Int, column: Int) :
            CompileError("variable \"$name\" is used but not defined.", line, column)

    class IfConditionMustBeBoolean(type: Type, line: Int, column: Int) :
            CompileError("while-condition must have \"bool\" but actually have \"$type\".", line, column)

    class WhileConditionMustBeBoolean(type: Type, line: Int, column: Int) :
            CompileError("while-condition must have \"bool\" but actually have \"$type\".", line, column)

    class FunctionIsNotDefined(name: String, line: Int, column: Int) :
            CompileError("function \"$name\" is called but not defined.", line, column)

    class WrongNumberOfArguments(name: String, actual: Int, expected: Int, line: Int, column: Int) :
            CompileError("function \"$name\" has \"$expected\" arguments but is called with \"$actual\" arguments.", line, column)

    class ArgumentTypeMismatch(name: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("the variable \"$name\" has \"$actual\" type but expected \"$expected\".", line, column)

    class DeadCodeAfterReturn(line: Int, column: Int) :
            CompileError("dead code after this return.", line, column)

    class FunctionMayNotReturnValue(func: String, line: Int, column: Int) :
            CompileError("function \"$func\" may not return value somewhere but should.", line, column)

    override fun toString(): String {
        return "Compiling ERROR at [$line:$column]: $message"
    }
}


