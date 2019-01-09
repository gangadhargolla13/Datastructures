package com.java.newfeature;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BasicStreams {
 static List<Employee> employeeList=
      Arrays.asList(new Employee("Tom Jones", 45), 
                    new Employee("Harry Major", 25),
                    new Employee("Ethan Hardy", 65),
                    new Employee("Nancy Smith", 15),
                    new Employee("Deborah Sprightly", 29));
 public static void main(String args[]){
   List<Employee> filteredList = employeeList.stream()
                        .limit(2)
                        .collect(toList());
  // filteredList.forEach(System.out::println);
   
   List<Employee> filteredList1 = employeeList.stream().filter((Employee e) -> e.getAge() > 32).collect(toList());
   //filteredList1.forEach(System.out::println);
   //employeeList.stream().peek((Employee e) -> e.getAge() + 4).forEach(action);
   
   Map<String,Integer> map = new HashMap<>();
   map.put("Ganga", 123);
   map.put("Ganga1", 123);
   map.put("Ganga2", 123);
   
   System.out.println(map.computeIfAbsent("ganga", k -> new Integer(5)));
   System.out.println(map);
 } 
}