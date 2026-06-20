// To try out a while, type the following into a file named printargs.scala:
@main def m4(args: String*): Unit =
  var i = 0
  while i < args.length do
    if i != 0 then
      print(" ")
    print(args(i))
    i += 1
    println()
    