package izakirzyanov.compiler

fun main(args: Array<String>) {
    val compiler = Compiler()
    if (args.size != 1) {
        System.err.println("specify the path to input [name].prima file")
        System.exit(1)
    }
    compiler.compile(args[0])
}
