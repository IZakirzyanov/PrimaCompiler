package izakirzyanov.compiler.errors

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import java.util.*

class SyntaxErrorListener : BaseErrorListener() {

    val errors = ArrayList<CompileError>()
    var hasErrors = false
        get() = !errors.isEmpty()


    override fun syntaxError(
            recognizer: Recognizer<*, *>?,
            offendingSymbol: Any?,
            line: Int,
            charPositionInLine: Int,
            msg: String?,
            e: RecognitionException?
    ) {
        errors.add(CompileError.SyntaxError(msg as String, line, charPositionInLine))
    }
}