package izakirzyanov.compiler.scope

import izakirzyanov.compiler.ast.Type
import java.util.*

class OptimizationScope {

    data class varInfo(val value: Any?, val type: Type, var lused: Int, var rused: Int, var useInPropagation: Boolean)

    private val scopesStack: ArrayList<MutableMap<String, varInfo>> = ArrayList()

    init {
        scopesStack.add(HashMap<String, varInfo>())
    }

    fun beginNewScope() {
        scopesStack.add(HashMap())
    }

    fun endScope() {
        scopesStack.removeAt(scopesStack.lastIndex)
    }

    fun putIfNotExist(name: String, type: Type, value: Any?) {
        //global vars aren't used in propagation by default
        if (scopesStack.last()[name] == null) {
            if (scopesStack.size == 1) {
                scopesStack.last()[name] = varInfo(value, type, 0, 0, false)
            } else {
                scopesStack.last()[name] = varInfo(value, type, 0, 0, true)
            }
        }
    }

    fun removeIfExist(name: String) {
        scopesStack.findLast { it.containsKey(name) }?.remove(name)
    }

    fun getValue(name: String) : varInfo? {
        return scopesStack.findLast { it.containsKey(name) }?.get(name)
    }

    fun isGlobal(name: String): Boolean {
        return scopesStack.findLast { it.containsKey(name) } == scopesStack.first()
    }

    fun removeAllUpdatedVars() {
        for (scope in scopesStack) {
            scope.entries.removeIf{e -> e.value.lused > 0}
        }
    }
}