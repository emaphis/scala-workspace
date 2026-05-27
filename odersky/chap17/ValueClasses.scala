// Chapter 17
// Scala’s Hierarchy

// 17.4 Defining your own value classes
//must have exactly one parameter, and it must have nothing
//inside it except defs

//object ValueClasses:

class Dollars(val amount: Int) extends AnyVal:
  override def toString: String = "$" + amount

class SwissFrancs(val amount: Int) extends AnyVal:
  override def toString = s"$amount CHF"


// Avoiding a types monoculture

def title(text: String, anchor: String, style: String): String =
  s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"



// The compiler can be more helpful if you define a tiny type for each do main concept.

class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal


def title2(text: Text, anchor: Anchor, style: Style): Html =
  Html(
    s"<a id='${anchor.value}'>" +
      s"<h1 class='${style.value}'>" +
      text.value +
      "</h1></a>"
  )




object ValueClasses:
  
  def main(args: Array[String]): Unit = {
    val money = Dollars(1_000_000)
    val francs = SwissFrancs(2_000_000)
    //val dollars: Dollars = SwissFrancs(1000)
    title("chap:vcls", "bold", "Value Classes")
    
    // out of order
    //title2(Anchor("chap:vcls"), Style("bold"), Text("Value Classes"))
    title2( Text("Value Classes"), Anchor("chap:vcls"), Style("bold"))
  }
