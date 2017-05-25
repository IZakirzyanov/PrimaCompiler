# Prima language Compiler
##### v. 0.6

## Features

- kotlin-like syntax (but, e.g., with semicolons)
- primitive `int`,`bool` and `str` types
- arrays
- primitive operators: 
    - `+`, `-`, `*`, `/`, `%` - `(int, int) -> int`
    - `==`, `!=` - `((T, T) -> bool)`
    - `<`, `<=`, `>`, `>=` - `((int, int) -> bool)` 
    - `&&`, `||` - `((bool, bool) -> bool)`
    - `+` - `(str, str) -> str)`
- `if`, `if-else`, `while` and `for` control-flow statements 
- `readInt`, `readBool`, `readStr`, `write` and `writeln` pre-built functions
- `nop` 
- user-defined functions (without overloading)
- JVM as target platform (JAVA class is generated)
- constant folding and constant propagation optimizations
- dead code elimination optimization

## Build
The project can be built with gradle

## Some details about the specification
Source file name should be in form `[name].prima`.
 
Output class file will be named `[name].class` with class `[name]` inside.
Use `java [name]` to run it

Primitive type variable's declaration syntax (all variables are mutable): `var N:T = EXPR`.
All variables must be initialized in the declaration.

Array variable's declaration syntax: `var N:T[] = T[size]`, where `T: Primitive | T[]`.
Default value for an array of `int` is `0`, for array of `bool` is `false`. For an array
of str default value is not set: if you try to get uninitialized value of such array
it is undefined behavior (NPE from JVM actually :) ).

Function's declaration syntax: `fun [main]([N1]:[T1], ... ,[Nn]:[Tn]): type {}`.

`for` structure: `for( (VAR_DECLARATION|VAR_ASSIGNMENT)?; expr; VAR_ASSIGNMENT?)`

Entry point should be `fun main(): void`.

## Examples
Fast power computation:
```kotlin
fun main(): void {
    writeln(binpow(readInt(), readInt()));
}

fun binpow(a: int, n: int): int {
    var res: int = 1;
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

Some arrays stuff:
```kotlin
fun main(): void {
	var tenOfTenOfTen: int[][] = int[ten()][10];
	for (var i: int = 0; i < 10; i = i + 1) {
        tenOfTenOfTen[i] = tenOfTen();
    }
    tenOfTenOfTen[1][2] = 5;
    writeln(tenOfTenOfTen[1][2]);
}

fun ten(): int {
	return 10;
}

fun tenOfTen(): int[] {
	var tenOfTen: int[] = int[ten()];
    for (var i: int = 0; i < 10; i = i + 1) {
        tenOfTen[i] = 10;
    }
	return tenOfTen;
}
```

More examples are in `examples` folder.