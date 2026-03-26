// A partial function that only matches on strings
val pfs: PartialFunction[Matchable, String] =
    case s:String => "YES"

// A partial function that only matches on doubles
val pfd: PartialFunction[Matchable, String] =
    case d:Double => "YES"

// A partial function that matches on strings or doubles
val pfsd = pfs.orElse(pfd)


def tryPF(
    x: Matchable, f: PartialFunction[Matchable,String] ): String =
  try f(x)
  catch case _: MatchError => "ERROR!"

assert(tryPF("Hello", pfs) == "YES")
assert(tryPF(1.0, pfs) == "ERROR!")
assert(tryPF("str", pfsd) == "YES")
assert(tryPF(3.142, pfs)  == "ERROR!")
assert(tryPF(3.142, pfd)  == "YES")
assert(tryPF(3.142, pfsd) == "YES")
assert(tryPF(2, pfs)      == "ERROR!")
assert(tryPF(2, pfd)      == "ERROR!")
assert(tryPF(2, pfsd)     == "ERROR!")

assert(pfs.isDefinedAt("str")  == true)
assert(pfd.isDefinedAt("str")  == false)
assert(pfsd.isDefinedAt("str") == true)
assert(pfs.isDefinedAt(3.142)  == false)
assert(pfd.isDefinedAt(3.142)  == true)
assert(pfsd.isDefinedAt(3.142) == true)
assert(pfs.isDefinedAt(2)      == false)
assert(pfd.isDefinedAt(2)      == false)
assert(pfsd.isDefinedAt(2)     == false)


// Lift the partial function to a total function that returns an Option
val fs = pfs.lift

assert(fs("str")  == Some("YES"))
assert(fs(3.142) == None)

// Unlift the total function back to a partial function
val pfs2 = fs.unlift

assert(pfs2("str")  == "YES")
assert(tryPF(3.142, pfs2) == "ERROR!")
