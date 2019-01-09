package com.ganga.scala

import java.io._


object SingleTone {

  def main(args : Array[String]){
    val point = new Exampleval1(10, 20);
    printPoint

      def printPoint{
         println ("Point x location : " + point.x);
         println ("Point y location : " + point.y);
      }
  }
}

class Exampleval1 (var xc: Int, var yc: Int) {
  var x: Int = xc;
   var y: Int = yc;
   
   def move(dx: Int, dy: Int) {
      x = x + dx;
      y = y + dy;
      println ("Point x location : " + x);
      println ("Point y location : " + y);
   }
}