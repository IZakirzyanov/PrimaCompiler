package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.expr.ExprNode

sealed class Type {
    abstract fun toJVMType(): String

    fun getPrimitiveType(): Type {
        return when (this) {
            is Arr<*> -> this.type.getPrimitiveType()
            else -> this
        }
    }

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

    class Arr<out T : Type>(val type: T) : Type() {
        override fun toJVMType(): String {
            return "[" + type.toJVMType()
        }

        companion object {
            fun buildArrType(type: Type, depth: Int): Type {
                var _type = type
                for (i in 1..depth) {
                    _type = Arr(type)
                }
                return _type
            }

            fun buildArrCall(name: String, indices: List<ExprNode>): String {
                return name + indices.map { "[" + it.ctx.text + "]" }.joinToString { "" }
            }
        }

        fun getArrayDepth(): Int {
            var depth = 0
            var curType: Type = this
            while (curType is Arr<*>) {
                curType = curType.type
                depth++
            }
            return depth
        }

        fun getSubType(indices: List<ExprNode>): Type {
            var type: Type = this
            indices.forEach {
                if (type is Arr<*>) {
                    type = (type as Arr<*>).type
                } else {
                    throw RuntimeException("SHOULDN'T BE HERE! TOO MUCH GETTERS")
                }
            }
            return type
        }

        override fun equals(other: Any?): Boolean {
            return this.toString() == other.toString()
        }

        override fun toString(): String {
            return type.toString() + "[]"
        }

        override fun hashCode(): Int {
            return type.hashCode()
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
        this == Integer || this == Bool || this == Str
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