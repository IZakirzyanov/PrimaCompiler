package izakirzyanov.compiler

fun main(args: Array<String>) {
    val compiler = Compiler()
    val AST = compiler.parse("sample2.prima")
    compiler.checkAndInferTypes(AST)
    val i = 1
}
