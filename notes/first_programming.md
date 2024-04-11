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
