package izakirzyanov.compiler.ast

sealed class TypeNode : ASTNode() {
    object Bool : TypeNode()
    object Integer : TypeNode()
}

fun String.toTypeNode(): TypeNode {
    return when (this) {
        "bool" -> TypeNode.Bool
        "int" -> TypeNode.Integer
        else -> throw RuntimeException("SHOULDN'T BE HERE. PARSER SHOULDN'T PARSE YOUR CODE. $this IS NOT A TYPE. HOW YOU DID THIS?")
    }
}
