package izakirzyanov.compiler.ast


interface Op {
    interface BinOp : Op
    interface UnOp : Op
    interface IntOp : Op
    interface BoolOp : Op
    interface EqualityOp : IntOp, BoolOp
    interface CmpOp : IntOp

    object Mult : BinOp, IntOp {
        override fun toString(): String {
            return "*"
        }
    }

    object Plus : BinOp, IntOp {
        override fun toString(): String {
            return "+"
        }
    }

    object Minus : BinOp, IntOp {
        override fun toString(): String {
            return "-"
        }
    }

    object Div : BinOp, IntOp {
        override fun toString(): String {
            return "/"
        }
    }

    object Mod : BinOp, IntOp {
        override fun toString(): String {
            return "%"
        }
    }

    object UnPlus : UnOp, IntOp {
        override fun toString(): String {
            return "+"
        }
    }

    object UnMinus : UnOp, IntOp {
        override fun toString(): String {
            return "-"
        }
    }

    object And : BinOp, BoolOp {
        override fun toString(): String {
            return "&&"
        }
    }

    object Or : BinOp, BoolOp {
        override fun toString(): String {
            return "||"
        }
    }

    object Not : UnOp, BoolOp {
        override fun toString(): String {
            return "!"
        }
    }

    object EQ : BinOp, EqualityOp {
        override fun toString(): String {
            return "=="
        }
    }

    object NE : BinOp, EqualityOp {
        override fun toString(): String {
            return "!="
        }
    }

    object LT : BinOp, CmpOp {
        override fun toString(): String {
            return "<"
        }
    }

    object LE : BinOp, CmpOp {
        override fun toString(): String {
            return "<="
        }
    }

    object GT : BinOp, CmpOp {
        override fun toString(): String {
            return ">"
        }
    }

    object GE : BinOp, CmpOp {
        override fun toString(): String {
            return ">="
        }
    }
}

fun String.toUnOp(): Op.UnOp {
    return when (this) {
        "+" -> Op.UnPlus
        "-" -> Op.UnMinus
        "!" -> Op.Not
        else -> throw RuntimeException("SHOULDN'T BE HERE. $this is not an unary operator")
    }
}

fun String.toBinOp(): Op.BinOp {
    return when (this) {
        "+" -> Op.Plus
        "-" -> Op.Minus
        "*" -> Op.Mult
        "/" -> Op.Div
        "%" -> Op.Mod
        "&&" -> Op.And
        "||" -> Op.Or
        "==" -> Op.EQ
        "!=" -> Op.NE
        "<" -> Op.LT
        "<=" -> Op.LE
        ">" -> Op.GT
        ">=" -> Op.GE
        else -> throw RuntimeException("SHOULDN'T BE HERE. $this is not a binary operator")
    }
}