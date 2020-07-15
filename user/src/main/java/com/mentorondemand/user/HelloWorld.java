package com.mentorondemand.user;

public class HelloWorld{

    public static void main(String []args){
       String s="aaccbbabcaca";
       //Divide two string by length aabcc | cabba
       //Swap the string and concat cabbaaabcc
       //delete the similar character in midle cabbaaabcc => cabbbcc => cacc
       //print the length of final string
       while(s.charAt(0)==s.charAt(s.length()-1)){
            
             char val=s.charAt(0);
             System.out.println(val);
             while(s.){
            	 System.out.println("in re");
                 s=s.replaceFirst(String.valueOf(s.charAt(0)),"");
                 System.out.println(s);
             }
             while(s.charAt(s.length()-1)==val){
            	 System.out.println("In sub");
                 s=s.substring(0,s.length()-1);
                 System.out.println(s);
             }
             
       }
      
       System.out.println(s);
       System.out.println(s.length());
     
    }
    
//    aabcccabba
//    
//    aabcc | cabba
//    
//    cabba aabcc
//    
//    abcccabb
//    acccab
//    acab
//    
//    
//   cabbaaabcc
//   cabbbcc
//   cacc
   
   
    
    
    
    
    
    
}
