package com.ganga.scala.example

object Basiceexample {
   def main(args : Array[String]){
     println("gangadhar");
     var x : Int =0;
     while(x<5){
       if(x==4){
         println("matched value is 4");
       }
       println("master "+x);
       x = x +1;
     }
     var aa = Array(12,34,56);
     for(y <- aa){
       println(y);
     }
     
     var total=0;
     for(i <- 0 to (aa.length-1)){
       total += aa(i);
     }
     println(total)
   }
}