// To try out a while, type the following into a file named printargs.scala:
@main def m3(args: String*): Unit =
  var i = 0
  while i < args.length do
    println(args(i))
    i += 1
