package com.ganga.scala

object CollectionTest {

  def main(args:Array[String]){
    var fruites:List[String] =  List("apple","mango","bannana");
    var fruit = "apple":: ("orange" ::("pine apple" :: Nil))
    
    var fruit2 = "guvva" :: ("water melon" :: Nil)

    var fruit3 = fruit ::: fruit2
   // println(fruit3)
    var value = List.fill(4)(2)
    println(value)
   /* var ste : String = ""
      for(ste <- fruit){
        println(ste)
      }
    if(!fruit.isEmpty){
      println("list is not empty")
    }
    println(fruit.head)*/
  }
}