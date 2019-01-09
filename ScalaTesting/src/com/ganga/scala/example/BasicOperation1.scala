package com.ganga.scala.example

object BasicOperation1 {

  def main(args: Array[String]) {
     var e = new Example(23,56);
     e.move(34, 67)
     e.validate(12)
  }
}

class Example(val x: Int, val y: Int) {
  var xx: Int = x;
  var yy: Int = y;

  def move(dx: Int, dy: Int){
    xx = dx + xx;
    yy = dy + yy;
    println(xx + "---" + yy)
    try{
      var mm = xx/0;
    }catch{
      case ex: ArithmeticException =>{
        println("you caught exception")
        //throw new ArithmeticException();
      }
    }finally{
      println("I am very good person")
    }
  }
  var aa = Array(23,56,89,98);
  for(y <- aa){
    println(y)
  }
  
  for(i <- 0 to (aa.length -1)){
    println("Element values "+aa(i));
  }
  @throws(classOf[InvalidAgeException])  
    def validate(age:Int){  
        if(age<18){  
            throw new InvalidAgeException("Not eligible")  
        }else{  
            println("You are eligible")  
        }  
    }  
}

class InvalidAgeException(s:String) extends Exception(s){
  
}
