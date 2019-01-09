package com.ganga.latest

class Ganga(x: Int, y: Int) {

  def testing(str: String) {
    val a: Int = 12;
    val b: Int = 24;
    val c = a + b;
    println("print sum is " + c)
    println("I am only one person " + str)
  }

  def multification() {
    println(x * y)
  }
  def percentage(a: Int, y: Int): Int = {
    val c = (a / y) % 100;
    return c;
  }
  def testLoop() {
    val arr = Array(12, 78, 90, 45);
    for (i <- 0 to (arr.length - 1) if arr(i) != 45; if arr(i) > 55) {
      println(arr(i))
    }
    var j = 9;
    while (j > 0) {
      println("values are " + j)
      j = j - 1;
    }
  }
  def testSwitch(x:Int){
   
  }
}
object BasicExample {
  def main(args: Array[String]) {
    val g = new Ganga(33, 3);
    g.testing("Gopi")
    val ga = g.percentage(33, 3);
    println(ga)
    g.multification();
    g.testLoop;
  }
}