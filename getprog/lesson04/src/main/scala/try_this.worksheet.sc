/*
    TRY THIS Modify your markExam function to keep track of both the lowest and
    the highest mark computed so far
*/

var marksSum = 0
var marksCount = 0
var marksMin = 100
var marksMax = -100

def averageMark: Double =
  marksSum.toDouble / marksCount

def findMarksMin(mark: Int) =
    if (mark < marksMin) marksMin = mark

def findMarksMax(mark: Int) =
    if (mark > marksMax) marksMax = mark

def markExam(q1: Double, q2: Double, q3: Double): Int = {
  val avgScore = (q1 + q2 + q3) / 3
  val scaledScore = avgScore * 10 / 3
  val mark = Math.round(scaledScore).toInt

  findMarksMin(mark)
  findMarksMax(mark)
  marksSum += mark
  marksCount += 1
  mark
}

// Tests
markExam(1.5, 2.0, 2.5)
markExam(2.0, 1.5, 2.5)
markExam(1.5, 2.5, 2.0)
markExam(1.5, 3.5, 1.0)
averageMark == 7.0
marksMin
marksMax
