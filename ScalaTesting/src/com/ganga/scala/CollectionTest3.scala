package com.ganga.scala


object CollectionTest3 {

  def main(args :Array[String]){
    var map : Map[String,Int] = Map("ganga" -> 1,"malli" -> 2)
    println(map.keys)
    
    map.keys.foreach{ i => 
      print( "Key = " + i )
      println(" Value = " + map(i) )}
  }
}