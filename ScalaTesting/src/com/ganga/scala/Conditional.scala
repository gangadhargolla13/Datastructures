package com.ganga.scala

object Conditional {

  def main(args : Array[String]){
    var x : Int =10;
    if(x > 20){
      println("x value is smaller than 20")
    }else{
      println("y value is bigger than 20");
    }
    
    var a = 0;
    var b = 0;
    val numList = List(1,2,3,4,5,6,7,8,9,10);
    /*for(a <- 1 until 3; b <- 1 to 3){
      println("value of a "+a)
      println("value of b "+b)
    }*/
    /*for( a <- numList if a != 3; if a < 8){
      println(a)
      
    }*/
    
    var retVal = for{ a <- numList if a != 3; if a < 8 }yield a
    for( a <- retVal){
         println( "Value of a: " + a );
      }
  }
}