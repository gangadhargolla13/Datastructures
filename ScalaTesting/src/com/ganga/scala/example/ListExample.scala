package com.ganga.scala.example

import scala.collection.immutable.Map
import scala.collection.mutable.HashMap

object ListExample {
  def main(arg: Array[String]) {
    var ll = new Example12()
    ll.adding()
    ll.adding1()
    ll.hash1()
  }

}

class Example12 {
  def adding() {
    var ll = List(12, 43, 90, 67, 6, 34, 42)
    println(ll)
    var l = ll.sorted
    println(l)
  }

  def adding1() {
    var map = Map("A" -> "Ganesh", "B" -> "Gopi")
    var map1: Map[String, String] = Map.empty[String, String]
    var map2 = map + ("c" -> "jahnavi")
    println(map2)
    
  }
  
  def hash1(){
    var hashMap = HashMap("A"->"Apple","B"->"Ball","C"->"Cat") 
    hashMap.foreach{
      case(key,value) => println(key+"= "+value)
    }
    
  }
}