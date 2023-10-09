// Lesson 9 - Quick Check

/*
Quick Check 9.1 Import the package java.sql.Date into your scope and create an
alias called “SqlDate.
*/

import java.sql.{Date as SqlDate}


/*
Quick Check 9.2 Create a new package in an sbt project, called my.quick.check.
Add two files to it:

     TestA.scala contains a class called TestA.
     TestB.scala contains a class called TestB.
*/

import my.quick.check.{TestA, TestB}

val testa = new TestA()
val testb = new TestB()
