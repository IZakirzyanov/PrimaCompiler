package izakirzyanov.compiler.ast

sealed class Type {
    abstract fun toJVMType(): String

    object Bool : Type() {
        override fun toJVMType(): String {
            return "Z"
        }

        override fun toString(): String {
            return "bool"
        }
    }

    object Integer : Type() {
        override fun toJVMType(): String {
            return "I"
        }

        override fun toString(): String {
            return "int"
        }
    }

    object Void : Type() {
        override fun toJVMType(): String {
            return "V"
        }

        override fun toString(): String {
            return "void"
        }
    }

    object Unknown : Type() {
        override fun toJVMType(): String {
            throw RuntimeException("SHOULD NOT BE HERE! TYPE ERRORS MUST BE CAPTURED BEFORE")
        }

        override fun toString(): String {
            return "UNKNOWN"
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
