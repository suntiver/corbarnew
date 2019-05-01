/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbarclient;

import HelloApp.Hello;
import HelloApp.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author lenovo
 */
public class CorbarClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   try {
  
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Hello hellobj = (Hello) HelloHelper.narrow(ncRef.resolve_str("ABC3"));
            
            System.out.println("Welcome to system:");
            String r = hellobj.hellomaessage();
            System.out.println("The message is:"+r);
            System.out.println("-----------------");

       
       } catch (Exception e) {
            System.out.println("Exception"+e);
       }
    }
    
}
