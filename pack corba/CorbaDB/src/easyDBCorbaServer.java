
import easyDBCorba.dbEngine;
import easyDBCorba.dbEngineHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arthit
 */
public class easyDBCorbaServer {
    public static void main(String[] args) {
        try {
             //create and initialize the ORB
             ORB orb = ORB.init(args,null);
             
             //get reference to rootpoa & activate the POAManager
             POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
             rootpoa.the_POAManager().activate();
             
             //create servant and register it with the ORB
             easyDBImpl myDB = new easyDBImpl();
             myDB.setOrb(orb);
             
             //get object reference from the servant
             org.omg.CORBA.Object ref = rootpoa.servant_to_reference(myDB);
             
             dbEngine href =  dbEngineHelper.narrow(ref);
             
             //get the root naming context
             //NameService invokers the name service
             org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
             
             //Use NamingContextExt which is part  of the Interoperable
             //Naming Service(INS) specification
             
             NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
             
             //bind the Object Reference in Naming
             
             String name = "easyDB";
             NameComponent path[] = ncRef.to_name(name);
             ncRef.rebind(path, ref);
             
            System.out.println("Easy Database By CORBA Server ready...");  
            //wait for invocations from clients
            orb.run();
             
             
        } catch (Exception e) {
            System.err.println("Error: "+e);
            e.printStackTrace(System.out);
        }
        
        System.out.println("Calculator Server Exiting....");
    }
}
