// Lesson 15 - Try This

/*
 TRY THIS Rewrite each of the following functions as anonymous functions; use
 your concise notation at your discretion.
*/

// 1
def multiply(s: String, n: Int): Int = s.length * n
def multiply1 = {(s: String, n: Int) => s.length * n}

multiply("hello", 5)  == 25
multiply1("hello", 5) == 25

// 2
def toDouble(n: Int): Double = n.toDouble
def toDouble1: Int => Double = _.toDouble

toDouble(5)  == 5.0
toDouble1(5) == 5.0

// 3
def concat(s1: String, s2: String): String = s1 + s2
def concat1: (String, String) => String = _ + _

concat("hello ", "world")  == "hello world"
concat1("hello ", "world") == "hello world"

// 4
def inverseConcat(s1: String, s2: String): String = s2 + s1
def inverseConcat1 = (s1: String, s2: String) =>  s2 + s1

inverseConcat("world", "hello ")  == "hello world"
inverseConcat1("world", "hello ") == "hello world"

// 5
def myLongFunc(s: String): String = {
    val length = s.length
    s.reverse * length
}

def myLongFunc1 = (s: String) => {
    val length = s.length
    s.reverse * length
}

myLongFunc("hello ")  == " olleh olleh olleh olleh olleh olleh"
myLongFunc1("hello ") == " olleh olleh olleh olleh olleh olleh"

myLongFunc1("hello ")
