
import easyDBCorba.dbEngine;
import easyDBCorba.dbEngineHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arthit
 */
public class easyDBCorbaClient {
    
    static dbEngine myDBlmpl;
    
    public static void main(String[] args) {
        
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader  stdin = new BufferedReader(reader);
        try {
            //create and initialize the ORB
            ORB orb = ORB.init(args,null);
            
            //get the root naming context
            
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            //Use NamingContextExt instead of NameingContext.this is part of the
            //Interoperable naming Service.
            
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            //resolve the Object Reference in Naming
            
            String name = "easyDB";
            
            myDBlmpl = dbEngineHelper.narrow(ncRef.resolve_str(name));
            
            ////**************** main responding ****
            
            String choice = "0",number ="",salary="";
            
            while(Integer.parseInt(choice) != 9){
            
                    System.out.println("******Please choose Menu**********");
                    System.out.print("1.Show\n");
                    System.out.print("2.set Salary\n");
                    System.out.print("9.Exit\n");
                     System.out.println("*************************");
                    System.out.print("Choice:");
                    choice  = stdin.readLine();
                    switch(Integer.parseInt(choice)){
                        
                        case 1:{
                            System.out.print("Input Number of Person: ");
                            number = stdin.readLine();
                            System.out.println("Show data number: " + number );
                            System.out.println("Name: "+myDBlmpl.getName(Integer.parseInt(number)));
                            System.out.println("Salary: "+myDBlmpl.getSalary(Integer.parseInt(number)));
                            break;
                        }
                        case 2:{
                            System.out.print("Input Number of Person: ");
                            number = stdin.readLine();
                            System.out.print("Input salary: ");
                            salary = stdin.readLine();
                              System.out.println("Number:"+number);
                            System.out.println("Salary:"+salary);
                            myDBlmpl.setSalary(Integer.parseInt(number),Double.parseDouble(salary));
                            System.out.println("Set new salary OK.");
                            break;
                                    
                        }
                        
                        default:{
                            
                            System.out.println("Input is not valid");
                        }
                        
                    }
                    //end switch
            
        }
            
            
            
        } catch (Exception e) {
            
            System.err.println("ERROR:"+e);
            e.printStackTrace(System.out);
        }
        
    }
    
}
