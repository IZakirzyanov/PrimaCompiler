package izakirzyanov.compiler.errors

open class CompileError(message: String): Exception(message) {
}

class SyntaxError(message: String): CompileError("Syntax error: $message.")