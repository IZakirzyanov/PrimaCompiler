package izakirzyanov.compiler

import izakirzyanov.compiler.ast.ASTPrimaVisitor
import izakirzyanov.compiler.ast.ProgramNode
import izakirzyanov.compiler.errors.SyntaxErrorListener
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

class Compiler {

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

    fun compile(fileName: String) {
        if (!fileName.endsWith(".prima")) {
            System.err.println("file name should be \"[name].prima\"")
        }
        val program = parse(fileName)
        val errors = program.checkForErrorsAndTypes()
        if (errors.isNotEmpty()) {
            errors.forEach { System.err.println(it) }
        } else {
            File(fileName.dropLast(6) + ".class").writeBytes(program.getByteCode(fileName.dropLast(6)))
        }
    }
}