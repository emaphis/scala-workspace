// Lesson 5  - CONDITIONAL CONSTRUCTS AND LOOPS

// 5.1 If-else construct

/// Listing 5.1 Categorizing the day of the week
def categorizeDayOfWeek(n: Int) =
    if (n == 1 || n == 7)
        "weekend"
    else if (n > 1 && n < 7)
        "weekday"
    else
        "unknown"

categorizeDayOfWeek(1)
categorizeDayOfWeek(4)


/// Listing 5.2 Labeling a number
def label(n: Int) =
    val ret =   // if is an expression, not a statement
        if (n == 0) "neutral"
        else if (n < 0) "negative"
        else "positive"
    ret

label(-10)
label(0)
label(7)


// 5.2 While loop

/// Repeating a message
def echo5a(msg: String) =
    println(msg)
    println(msg)
    println(msg)
    println(msg)
    println(msg)

echo5a("hello a")


/// Listing 5.3 Repeating using a while loop
def echo5b(msg: String) =
    var i = 1
    while (i <= 5)
        println(msg)
        i += 1

echo5b("Hello b")


// 5.3 For loop

/// Listing 5.4 Repeating using a for loop
def echo5c(msg: String) =
    for (i <- 1 to 5)
        println(msg)

echo5c("Hello c")
