
import CalculatorCorba.CalculatorEnginePOA;
import org.omg.CORBA.ORB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arthit
 */
public class CalculatorImpl  extends CalculatorEnginePOA{

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
        
    
    @Override
    public double plus(double val1, double val2) {
      
        return val1+val2;
        
    }

    @Override
    public double subtract(double val1, double val2) {
        
        return val1-val2;
    }

    @Override
    public double multiply(double val1, double val2) {
       
        
        return val1*val2;
    }

    @Override
    public double divide(double val1, double val2) {
        
        
        return val1/val2;
       
    }

    @Override
    public void shutdown() {
       
        orb.shutdown(false);
        
        
    }
    
    
    
    
}
