package com.ganga.scala.example

import scala.collection.mutable.SortedSet
import scala.collection.immutable.HashSet


object Setexample {

  def main(arg:Array[String]){
    //setAdd()
    //sortSet()
    hashSet()
    var m = new SequenceEx()
    m.seqEx();
  }
  
  def setAdd(){
    var set1 = Set(12,3,44,98,56);
    println("starting step")
    println(set1)
    for(i <- set1){
      println(i)
    }
    println("above all operations")
    set1 +=100;
    set1 -=44
    set1.foreach((va:Int)=> println(va))
    println("size of operation "+set1.size)
    println(set1.contains(3))
  }
  
  def sortSet(){
    var sort = SortedSet(12,4,67);
    sort.foreach((s:Int)=>println(s))
  }
  
  def hashSet(){
    var hash=HashSet(12,48,90,"master")
    
      var hash1:HashSet[String] = new HashSet()
    hash1 +="ganga"
      hash +="malli"
      for(n<- hash1)
      println(n)
  }
}

class SequenceEx{
  def seqEx(){
    var n:Seq[Int] = Seq(43,67,90,2,56);
    n.foreach((s:Int)=>println(s))
    println(n.isEmpty)
    println(n.endsWith(Seq(67,2)))
  }
}