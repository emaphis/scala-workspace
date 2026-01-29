// Step 5. Loop with while; decide with if


@main def m3(args: String*) =
    var i = 0
    while i < args.length do
        println(args(i))
        i += 1

