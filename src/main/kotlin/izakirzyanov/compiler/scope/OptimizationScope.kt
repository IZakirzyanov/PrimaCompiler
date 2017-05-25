package izakirzyanov.compiler.scope

import izakirzyanov.compiler.ast.Type
import java.util.*

class OptimizationScope {

    data class ConstantInfo(val value: Any, val type: Type, val lused: Int, val rused: Int)

    private val scopesStack: ArrayList<MutableMap<String, ConstantInfo>> = ArrayList()

    init {
        scopesStack.add(HashMap<String, ConstantInfo>())
    }

    fun beginNewScope() {
        scopesStack.add(HashMap())
    }

    fun endScope() {
        scopesStack.removeAt(scopesStack.lastIndex)
    }

    fun putVariableWithOverride(name: String, type: Type, value: Any) {
        scopesStack.last()[name] = ConstantInfo(value, type, 0, 0)
    }

    fun getValue(name: String) : ConstantInfo? {
        return scopesStack.findLast { it.containsKey(name) }?.get(name)
    }

    fun isGlobal(name: String): Boolean {
        return scopesStack.findLast { it.containsKey(name) } == scopesStack.first()
    }
}