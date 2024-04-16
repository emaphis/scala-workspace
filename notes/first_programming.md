# DevInsideYou - Your First Programming Language

Notes from the videos - may transfer to more permanent and organized notes

## Part 3 - Exploring is the new learning

scope, val, lazy val, def, var in Scala

''' scala

{
    {
        println("a scope")
    }

    val aScope = { println("a scope") }   // scopes can be named
    // sorta like a function but val's are executed in place
    // scopes return last expression

    val scope2  = {
        printlin("inscope2")
        1337
    }  // return 1337
}

'''

// val      is a value (stored in memory)

// def      is a definition (ontlh the computation is stored)

// lazy val is value that behaves first like def then a val

// var      is a memory location that store vals and allows them to be updated later

## Part 4 - if expressions can be complicated

'if' expressions control which scope gets executed based on a boolean expresson and returns a value which could be unit.

'if' expression can return 'Any' type

## Part 5 - Introduction to Type Systems

Type are proof the program is using data correctly.

Int, Boolean, Char, String, Unit, Any

Literals: 1337, true, 't', "True", {}

'type' definitions - 'type A = B'

Progress: If an expression is well-type (it compiles) it either evaluates or it is already a value.

Preservation: If an expression is well-type and it evaluates the result will have the same type.

## Part 6 - (Sub)routines

A way to define scopes for later use.

lambda functions, default arguments, named parameters

'''scala

def fun(a: Int = 3, b: String = "3") = { println(a,b) }

val fun = (a: Int, b: String) => println(a,b)

'''

## Part 7.1 - Recursion

methods that call themselves

recursive mothods must declare a return type

recursive methods must hava a base case

### sbt plugins

For more control of program execution

projects\plugins.sbt

addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")

> reStart, reStop, reStatus, ~reStart
