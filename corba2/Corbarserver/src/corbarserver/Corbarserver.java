/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbarserver;

import HelloApp.Hello;
import HelloApp.HelloHelper;
import java.io.IOException;
import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author lenovo
 */
public class Corbarserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
//           try {
//               
//               Runtime.getRuntime().exec("orbd -ORBInitialPort 900 -ORBInitialHost 192.168.1.13");
//               
//           } catch (Exception e) {
//                System.err.println("ERROR: " + e);
//                e.printStackTrace(System.out);

//           }
           
           
           
           Scanner myObj = new Scanner(System.in);  // Create a Scanner object
           //create and initialize the ORB //// get reference to tootpoa  // activate the POAManager
          
           
           
           ORB orb = ORB.init(args,null);
           POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
           rootpoa.the_POAManager().activate();
           
           //create servant and register it with the ORB
           HelloServant helloobj = new HelloServant();
           System.out.print("Enter message :");
           helloobj.setMassge(myObj.nextLine());
           helloobj.setORB(orb);
           
           //get object reference from the servant
           org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloobj);
           Hello href = HelloHelper.narrow(ref);
           
           org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
           NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
           
           NameComponent path[] = ncRef.to_name("ABC3");
           ncRef.rebind(path,href);
           
           System.out.println("Hello Server ready and waiting...");
        
           for(;;){
               orb.run();
           }
     
    } 
        
      catch (Exception e) {
         System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
          
     
        System.out.println("HelloServer Exiting...");
    }
    
}
