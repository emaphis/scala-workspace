/*
    Listing 4.1 Marking an exam

    1 You compute the average score for all the questions: (1.5 + 2 + 2.5) / 3 is 2.
    2 You scale the average score from 1 to 10. Considering that the maximum score
    possible for each question is 3, then you can rescale it as follows: 2 * 10 / 3 is about
    6.6.
    3 You round 6.6 up to the closest integer and obtain 7.
 */

def markExam1(q1: Double, q2: Double, q3: Double) =
  Math.round(((q1 + q2 + q3) / 3) * 10 / 3)

markExam1(1.5, 2.0, 2.5) == 7


/** Listing 4.2 Marking an exam—a more readable version */
def markExam2(q1: Double, q2: Double, q3: Double) =
  val avgScore = (q1 + q2 + q3) / 3
  val scaledScore = avgScore * 10 / 3
  Math.round(scaledScore)

markExam2(1.5, 2.0, 2.5) == 7


/** Listing 4.3 Keeping track of the mark statistics */
var marksSum = 0
var marksCount = 0

def averageMark: Double =
  marksSum.toDouble / marksCount

def markExam(q1: Double, q2: Double, q3: Double): Int = {
  val avgScore = (q1 + q2 + q3) / 3
  val scaledScore = avgScore * 10 / 3
  val mark = Math.round(scaledScore).toInt

  marksSum += mark
  marksCount += 1
  mark
}

markExam(1.5, 2.0, 2.5)
markExam(2.0, 1.5, 2.5)
markExam(1.5, 2.5, 2.0)
averageMark == 7.0
