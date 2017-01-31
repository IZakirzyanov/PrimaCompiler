package izakirzyanov.compiler

import izakirzyanov.compiler.errors.SyntaxErrorListener
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream

class Compiler public constructor(){

    fun parse(fileName: String) {
        val stream = ANTLRFileStream(fileName)
        val lexer = PrimaLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = PrimaParser(tokens)
        val syntaxErrorListener = SyntaxErrorListener()
        parser.addErrorListener(syntaxErrorListener)
        val context = parser.program()
        if (syntaxErrorListener.hasErrors) {
            for (error in syntaxErrorListener.errors) {
                System.err.println(error.message)
                System.exit(1)
            }
        }

    }

}