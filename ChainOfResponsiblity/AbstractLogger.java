/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsiblity;

public abstract class AbstractLogger {
   public static int EMPLOYEE = 1;
   public static int STUDENT = 2; 
   public static int DEPT = 3; 

   protected int level;

   //next element in chain or responsibility
   protected AbstractLogger nextLogger;

   public void setNextLogger(AbstractLogger nextLogger){
      this.nextLogger = nextLogger;
   }

   public void logMessage(int level, String message,Object obj ){
          System.out.println("le"+level+ obj.getClass());
      if(this.level== level){
       
         Add(obj);
      }
      if(nextLogger !=null){
         nextLogger.logMessage(level, message,obj);
      }
   }

   abstract protected void Add(Object obj );
	
}