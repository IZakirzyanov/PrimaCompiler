package izakirzyanov.compiler.ast

sealed class Type {
    object Bool : Type() {
        override fun toString(): String {
            return "bool"
        }
    }

    object Integer : Type() {
        override fun toString(): String {
            return "int"
        }
    }

    object Void : Type() {
        override fun toString(): String {
            return "void"
        }
    }
}

fun String.toTypeNode(): Type {
    return when (this) {
        "bool" -> Type.Bool
        "int" -> Type.Integer
        "void" -> Type.Void
        else -> throw RuntimeException("SHOULDN'T BE HERE. PARSER SHOULDN'T PARSE YOUR CODE. $this IS NOT A TYPE. HOW YOU DID THIS?")
    }
}
