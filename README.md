# Prima language Compiler
##### v. 0.1

## Features

- `int` and `bool` types
- primitive operators: 
    - `+`, `-`, `*`, `/`, `%` - `(int, int) -> int`
    - `==`, `!=` - `((int, int) -> bool)` or `((bool, bool) -> bool)`
    - `<`, `<=`, `>`, `>=` - `((int, int) -> bool)` 
    - `&&`, `||` - `((bool, bool) -> bool)`
- `if`, `if-else` and `while` control-flow statements 
- `readInt`, `readBool`, `write` and `writeln` pre-built functions
- user-defined functions (without overloading)
- JVM as target platform (JAVA class is generated)

## Build
The project can be built with gradle

## Some details about specification
Source file name should be in form `[name].prima`.
 
Output class file will be named `[name].class` with class `[name]` inside.
Use `java [name]` to run it

Variable's declaration syntax: `[name]:[type] = [expr]`. 

Function's declaration syntax: `fun [main]([arg1]:[type1], ... ,[argN]:[typeN]): type {}`.

Entry point should be `fun main(): void`.

## Example
Fast power computation:
```kotlin
fun main(): void {
    writeln(binpow(readInt(), readInt()));
}

fun binpow(a: int, n: int): int {
    res: int = 1;
    while (n > 0) {
        if (n % 2 == 1) {
            res = res * a;
        }
        a = a * a;
        n= n / 2;
    }
    return res;
}
```