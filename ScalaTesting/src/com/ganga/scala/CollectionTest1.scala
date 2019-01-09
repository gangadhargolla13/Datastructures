package com.ganga.scala

object CollectionTest1 {

  def main(args : Array[String]){
    var s : Set[Int] = Set();
    var s1 : Set[Int] = Set(1,2,3,4)  // val s1 = Set(1,2,3,4)
    println("the head of set is "+s1.head)
    var s2 = Set(5,7)
    println(s1++s2)
    println(s1.max)
  }
}