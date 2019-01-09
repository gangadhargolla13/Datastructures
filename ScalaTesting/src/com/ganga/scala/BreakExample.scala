package com.ganga.scala

import scala.util.control._
object BreakExample {

  def main(args :Array[String]){
    var breaks = new Breaks;
    var a = 0
    var numlimit = List(1,2,3,4,5,6,7)
    for(a <- numlimit){
      println("a value is "+a)
      if(a == 4){
        breaks.break();
      }
    }
    println("out of break operation")
  }
}