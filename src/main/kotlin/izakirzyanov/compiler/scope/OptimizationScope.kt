package izakirzyanov.compiler.scope

import izakirzyanov.compiler.ast.Type
import java.util.*

class OptimizationScope {

    data class ConstantInfo<out T>(val value: T, val type: Type, val lused: Int, val rused: Int)

    private val scopesStack: ArrayList<MutableMap<String, ConstantInfo<*>>> = ArrayList()

    init {
        scopesStack.add(HashMap<String, ConstantInfo<*>>())
    }

    fun beginNewScope() {
        scopesStack.add(HashMap())
    }

    fun endScope() {
        scopesStack.removeAt(scopesStack.lastIndex)
    }

    fun <T> putVariableWithOverride(name: String, type: Type, value: T) {
        scopesStack.last()[name] = ConstantInfo(value, type, 0, 0)
    }

    fun getValue(name: String) : Any {
        return scopesStack.findLast { it.containsKey(name) }!![name]!!.value!!
    }

    fun isGlobal(name: String): Boolean {
        return scopesStack.findLast { it.containsKey(name) } == scopesStack.first()
    }
}