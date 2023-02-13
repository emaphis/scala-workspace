object TwoDimensionalDigit {
  val Zero: TwoDimensionalString =
    TwoDimensionalString( // format: off // format: off
      top    = " _ ",
      middle = "| |",
      bottom = "|_|"
    ) // format: on // format: on

  val One: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = "   ",
      middle = "  |",
      bottom = "  |"
    ) // format: on

  val Two: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = " _|",
      bottom = "|_ "
    ) // format: on

  val Three: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = " _|",
      bottom = " _|"
    ) // format: on

  val Four: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = "   ",
      middle = "|_|",
      bottom = "  |"
    ) // format: on

  val Five: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = "|_ ",
      bottom = " _|"
    ) // format: on

  val Six: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = "|_ ",
      bottom = "|_|"
    ) // format: on

  val Seven: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = "  |",
      bottom = "  |"
    ) // format: on

  val Eight: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = "|_|",
      bottom = "|_|"
    ) // format: on

  val Nine: TwoDimensionalString =
    TwoDimensionalString( // format: off
      top    = " _ ",
      middle = "|_|",
      bottom = " _|"
    ) // format: on

  def apply(digit: Int): TwoDimensionalString = digit match {
    case 0 => Zero
    case 1 => One
    case 2 => Two
    case 3 => Three
    case 4 => Four
    case 5 => Five
    case 6 => Six
    case 7 => Seven
    case 8 => Eight
    case 9 => Nine
    case _ => TwoDimensionalString.QuestionMarks
  }
}