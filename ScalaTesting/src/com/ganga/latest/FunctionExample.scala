package com.ganga.latest

object FunctionExample {

  def main(args: Array[String]) {
    //Anonymous function
    var inc = (x:Int) => x+x
    var mul = (x: Int, y: Int) => x*y
    var userDir = () => { System.getProperty("user.dir") }
    println(inc(4))
    println(mul(4,5))
    println(userDir())
    //Nested function
   // println( factorial1(9) )
    //Higher-order function
   // println( apply( layout, 10) )
    //calling function with default values
   // println("Sum is "+addInt())
    //Recursion
    /*for(i <- 1 to 10)
    {
      println("Factorial of "+i+" := "+factorial(i))
    }*/
 
    //call-by-name
     //delayed(getTime())
    // Function with Named arguments
    //val c = getTime(b=5,a=10)
   // println(c)
    
    //variable Arguments
   // printStrings("Ganga","Malli","Gayathri")
     }
  
  def getTime() = {
    println("Getting time in nano seconds")
     System.nanoTime()
  }
  def getTime(a:Int,b:Int) : Int ={
    println("Getting time in nano seconds")
     return a+b
  }
  
  def delayed(t: => Long) ={
    println("In delayed method")
    println("Param: "+t)
  }
  
  def printStrings(args:String*) = {
    var i :Int =0;
    for(arg <- args)
    {
      println("Args value ["+i+"] = "+arg)
      i = i+1;
    }
  }
  
  def factorial(n: Int) :Int = {
    if(n <= 1){
      1
    }
    else
    n*factorial(n-1)
  }
  
  def addInt(a:Int = 5,b:Int =9): Int=
  {
    var sum:Int =0;
    sum = a+b;
    return sum
  }
  def apply(f: Int => String, v: Int) = f(v)

   def layout[A](x: A) = "[" + x.toString() + "]"
   
   def factorial1(i:Int):Int ={
    def fact(i:Int,b:Int):Int = {
      if (i <= 1)
            b
         else
            fact(i - 1, i * b)
      }
      fact(i, 1)
    }
  
}