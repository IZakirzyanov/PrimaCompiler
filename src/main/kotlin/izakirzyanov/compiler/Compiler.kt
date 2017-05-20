package izakirzyanov.compiler

import izakirzyanov.compiler.ast.ASTNode
import izakirzyanov.compiler.ast.ASTPrimaVisitor
import izakirzyanov.compiler.ast.ProgramNode
import izakirzyanov.compiler.errors.SyntaxErrorListener
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ConsoleErrorListener

class Compiler public constructor(){

    fun parse(fileName: String): ProgramNode {
        val stream = ANTLRFileStream(fileName)
        val lexer = PrimaLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = PrimaParser(tokens)
        val syntaxErrorListener = SyntaxErrorListener()
        parser.removeErrorListeners()
        parser.addErrorListener(syntaxErrorListener)
        val context = parser.program()
        if (syntaxErrorListener.hasErrors) {
            syntaxErrorListener.errors.forEach { System.err.println(it) }
            System.exit(1)
        }
        val visitor = ASTPrimaVisitor()
        val AST = visitor.visit(context) as ProgramNode
        return AST
    }

    fun checkAndInferTypes(AST: ProgramNode) {
        val errors = AST.checkForErrorsAndTypes()
        if (!errors.isEmpty()) {
            errors.forEach { System.err.println(it) }
            System.exit(1)
        }
    }

}