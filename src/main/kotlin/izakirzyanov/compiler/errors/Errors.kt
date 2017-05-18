package izakirzyanov.compiler.errors

import izakirzyanov.compiler.ast.Type

sealed class CompileError(message: String, val line: Int, val column: Int) : Exception(message) {

    class SyntaxError(message: String, line: Int, column: Int) : CompileError("syntax error - $message.", line, column)
    class VariableIsAlreadyDefinedInThisScope(name: String, line: Int, column: Int) : CompileError("variable \"$name\" is already defined in this scope.", line, column)
    class FunctionIsAlreadyDefined(name: String, line: Int, column: Int) : CompileError("function \"$name\" is already defined.", line, column)
    class DuplicatedArgument(name: String, line: Int, column: Int) : CompileError("argument \"$name\" is defined more than once.", line, column)
    class ReturnTypeMismatch(func: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("The function \"$func\" returns \"$actual\" but expected \"$expected\".", line, column)
    class VariableTypeMismatch(name: String, actual: Type, expected: Type, line: Int, column: Int) :
            CompileError("The variable \"$name\" has \"$actual\" type but expected \"$expected\".", line, column)

    override fun toString(): String {
        return "Compiling ERROR at [$line:$column]: $message"
    }
}


