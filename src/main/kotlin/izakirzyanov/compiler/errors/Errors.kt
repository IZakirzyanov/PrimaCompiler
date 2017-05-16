package izakirzyanov.compiler.errors

open class CompileError(message: String, val line: Int, val column: Int): Exception(message) {
    override fun toString(): String {
        return "Compile error at [$line:$column]: $message"
    }
}

class SyntaxError(message: String, line: Int, column: Int): CompileError("syntax error - $message.", line, column)