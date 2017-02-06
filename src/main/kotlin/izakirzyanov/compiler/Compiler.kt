package izakirzyanov.compiler

import izakirzyanov.compiler.ast.ASTNode
import izakirzyanov.compiler.ast.ASTPrimaVisitor
import izakirzyanov.compiler.errors.SyntaxErrorListener
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream

class Compiler public constructor(){

    fun parse(fileName: String): ASTNode {
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
        val visitor = ASTPrimaVisitor()
        val AST = visitor.visit(context)
        return AST
    }

}