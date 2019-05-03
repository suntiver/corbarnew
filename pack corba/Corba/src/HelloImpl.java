import HelloApp.HelloPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author Arthit
 */
public class HelloImpl extends HelloPOA{
    
    private ORB orb;
    
    public void setORB(ORB orb_val){
        orb = orb_val;
    }
    
    
    @Override
    public String sayHello() {
       
        return "Hello world";
    }

    @Override
    public void shutdown() {
        
        orb.shutdown(false);
  
    }
    
}