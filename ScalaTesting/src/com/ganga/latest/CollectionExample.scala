package com.ganga.latest

import scala.collection.mutable.MutableList
import scala.collection.mutable.Set
import scala.collection.mutable.Map
object CollectionExample {
  def main(args: Array[String]) {
    //val ex = new ListExample()
    // val ex = new Setexample()
//    val ex = new MapExample()
    val ex = new Tupleexample()
    ex.call
  }
}

class ListExample {
  var values = MutableList("gangadhar", "mallikarjuna", "gayathri")
  var empty: List[Nothing] = List()
  def call() {
    val nameList = "jahnavi"::("gannavi"::("gopi jithendra"::("ganesh kumar"::Nil)))
    //var family = values ::: nameList
    //println(family)
    //println(values)
    values+="Narasimham"
    values.+=("Koteswari")
    values.apply(3)
    println(values.contains("gangadhar"))
    println(values)
    
    values.foreach(e => println(e.toUpperCase()))
    
    values.sortWith((x,y) => x.length() > y.length())
    
    values.sortBy((x:String) => (x.charAt(1),x.charAt(0)))
    
    values.foreach(println(_))
    
    var g:Array[String]=values.toArray;
    
    println(values)
  }
}

class Setexample {
  var s:Set[Int] = Set(1,3,6,4)
  def call(){
    println(s.head)
    val s1=Set(1,6,3,4)
    val s2 = s++s1
    s2.+=(56)
    s2.-=(9)
    println(s2)
    
    println(s.equals(s1))
    
    var k:Iterator[Int]=s2.iterator
    while(k.hasNext)
      println(k.next)
  }
}

class MapExample {
  var map:Map[Int,String]=Map(1 -> "Gangadhar",2 -> "Mallikarjuna",3 -> "Gayathri")
  var map1:Map[Int,String]=Map(6 -> "Gangadhar",7 -> "Mallikarjuna",8 -> "Gayathri")
  
  def call(){
    map += (4 -> "Gopi")
    var k:Iterable[String] = map.values
    var k1:Iterator[String] = k.iterator
    while(k1.hasNext){
      println(k1.next)
    }
    println(map)
    var map2=map++map1
    println(map2)
    
    map2.keys.foreach{
      i => print("key =" + i)
      println("Value = " +map2(i))
    }
    var f = map2.keys.filter(_%2 == 0)
    println(f.toString)
  }
}

class Tupleexample {
  val t = (1,"gangadhr",72000.32,2,"Mallikarjuna",32000)
  def call(){
    println("Sum of the elemets "+t._1+" "+t._4)
  t.productIterator.foreach{ i =>println("Value = " + i )}
  }
}