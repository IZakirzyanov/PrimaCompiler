package izakirzyanov.compiler.scope

import izakirzyanov.compiler.ast.Type
import java.util.*

class Scope {
    private val scopesStack: ArrayList<MutableMap<String, Type>> = ArrayList()
    init {
        scopesStack.add(HashMap<String, Type>())
    }

    fun enterScope() {
        scopesStack.add(HashMap(scopesStack.last()))
    }

    fun leaveScope() {
        scopesStack.removeAt(scopesStack.lastIndex)
    }

    fun putVariableWithCheck(name: String, type: Type): Boolean {
        if (scopesStack.last()[name] != null) {
            return false
        }
        scopesStack.last()[name] = type
        return true
    }

    fun putVariableWithOverride(name: String, type: Type) {
        scopesStack.last()[name] = type
    }

    fun definedInTheLastScope(name: String): Boolean {
        if (scopesStack.last().containsKey(name) && !scopesStack[scopesStack.lastIndex - 1].containsKey(name)) {
            return true
        }
        return false
    }

    operator fun get(name: String): Type? {
        return scopesStack.last()[name]
    }
}