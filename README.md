# Prima language Compiler
##### v. 0.1

## Features

- kotlin-like syntax (but, e.g., with semicolons)
- `int`,`bool` and `str` types
- primitive operators: 
    - `+`, `-`, `*`, `/`, `%` - `(int, int) -> int`
    - `==`, `!=` - `((T, T) -> bool)`
    - `<`, `<=`, `>`, `>=` - `((int, int) -> bool)` 
    - `&&`, `||` - `((bool, bool) -> bool)`
    - `+` - `(str, str) -> str)`
- `if`, `if-else` and `while` control-flow statements 
- `readInt`, `readBool`, `readStr`, `write` and `writeln` pre-built functions
- `nop` 
- user-defined functions (without overloading)
- JVM as target platform (JAVA class is generated)

## Build
The project can be built with gradle

## Some details about specification
Source file name should be in form `[name].prima`.
 
Output class file will be named `[name].class` with class `[name]` inside.
Use `java [name]` to run it

Variable's declaration syntax (all variables are mutable): `var N:T = EXPR`. 

Function's declaration syntax: `fun [main]([N1]:[T1], ... ,[Nn]:[Tn]): type {}`.

Entry point should be `fun main(): void`.

## Examples
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

Some string stuff:
```kotlin
fun main(): void {
	greetings();
	var name: str = getName();
	if (name == "Ilya") {
		writeln("Hello, master!");
	} else {
		writeln("Hello, " + name + "!");
	}
}

fun greetings(): void {
	writeln("What is your name?");
}

fun getName(): str {
	return readStr();
}
```