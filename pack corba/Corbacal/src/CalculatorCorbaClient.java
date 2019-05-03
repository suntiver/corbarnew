
import CalculatorCorba.CalculatorEngine;
import CalculatorCorba.CalculatorEngineHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class CalculatorCorbaClient {
    
    static  CalculatorEngine  casioImpl;
    static final float  number1 = 567.89f;
    static final float  number2 = 123.45f;
    public static void main(String[] args) {
        try {
            
            //create and initialize the ORB
            ORB orb = ORB.init(args,null);
            
            //get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            //use NamingContextExt replace NamingContext is part of service
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            //search object that refered
            String name = "casioCalculator";
            casioImpl = CalculatorEngineHelper.narrow(ncRef.resolve_str(name));
            System.out.print("****Testing casio Calculator by CORBA with the real number 567.89 and 123.45 **** \n");
            System.out.println("567.89+123.45 = " + casioImpl.plus(number1,number2));
            System.out.println("567.89-123.45 = " + casioImpl.subtract(number1,number2));
            System.out.println("567.89*123.45 = " + casioImpl.multiply(number1,number2));
            System.out.println("567.89/123.45 = " + casioImpl.divide(number1,number2));
            
            
            
        } catch (Exception e) {
            
            System.err.println("ERROR:"+e);
            e.printStackTrace(System.out);
        }
    }
    
}
