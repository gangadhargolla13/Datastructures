package com.ganga.scala

object ScalaFunctions {

  def main(args : Array[String]){
    println("Return value "+addInt(10,17))
  }
  
  def addInt(a:Int,b:Int) : Int = {
    var sum:Int = 0
    sum = a+b
    return sum
  }
}