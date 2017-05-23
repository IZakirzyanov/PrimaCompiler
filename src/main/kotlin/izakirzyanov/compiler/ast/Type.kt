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

    object Str : Type() {
        override fun toJVMType(): String {
            return "Ljava/lang/String;"
        }

        override fun toString(): String {
            return "str"
        }
    }

    class Arr<out T: Type>(val type: T) : Type() {
        override fun toJVMType(): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun toString(): String {
            return type.toString() + "[]"
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

    val isPrimitive: Boolean
        get() =
        this == Integer || this == Bool
}

fun String.toTypeNode(): Type {
    return when (this) {
        "bool" -> Type.Bool
        "int" -> Type.Integer
        "void" -> Type.Void
        "str" -> Type.Str
        else -> {
            if (this.endsWith("[]")) {
                Type.Arr(this.dropLast(2).toTypeNode())
            } else {
                throw RuntimeException("SHOULDN'T BE HERE. PARSER SHOULDN'T PARSE YOUR CODE. $this IS NOT A TYPE. HOW YOU DID THIS?")
            }
        }
    }
}