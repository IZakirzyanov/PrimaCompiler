package izakirzyanov.compiler

import izakirzyanov.compiler.ast.Type
import java.util.*
import kotlin.collections.ArrayList

class Scope {
    private val scopesStack: ArrayList<MutableMap<String, Pair<Type, Int>>> = ArrayList()
    private val reserved: ArrayList<String> = ArrayList()
    var varNums: Int = 1

    init {
        scopesStack.add(HashMap<String, Pair<Type, Int>>())
        reserved.addAll(listOf("int", "void", "bool", "str", "write", "writeln", "read", "readInt", "readBool", "readStr"))
    }

    fun beginNewScope() {
        scopesStack.add(HashMap())
    }

    fun endScope() {
        scopesStack.removeAt(scopesStack.lastIndex)
    }

    fun resetVarNums() {
        varNums = 0
    }

    fun putVariableWithOverride(name: String, type: Type) {
        scopesStack.last()[name] = type to varNums++
    }

    fun definedInTheLastScope(name: String): Boolean {
        if (scopesStack.last().containsKey(name)) {
            return true
        }
        return false
    }

    fun getType(name: String): Type? {
        return scopesStack.findLast { it.containsKey(name) }?.get(name)?.first
    }

    fun getVarNum(name: String): Int {
        return scopesStack.findLast { it.containsKey(name) }!![name]!!.second
    }

    fun isGlobal(name: String): Boolean {
        return scopesStack.findLast { it.containsKey(name) } == scopesStack.first()
    }

    fun isReserved(name: String): Boolean {
        return reserved.contains(name)
    }
}