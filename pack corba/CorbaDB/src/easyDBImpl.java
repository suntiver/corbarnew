
import easyDBCorba.dbEnginePOA;
import org.omg.CORBA.ORB;


public class easyDBImpl extends dbEnginePOA{

    private ORB orb;

    String  nameUser[] ={"Jakkarin","Sasipa","Kanyarat","Piranan"};
    double salaryUser[] = {70000,50000,30000,40000};

    public void setOrb(ORB orb_value) {
        this.orb = orb_value;
    }
    
    
    @Override
    public String getName(int no) {
        return nameUser[no-1];  //input  1  = [1-0] = Jakkarin
    }

    @Override
    public double getSalary(int no) {
        return salaryUser[no-1];
    }
    @Override
    public void setSalary(int no, double newSalary) {
       
        salaryUser[no-1] = newSalary;
    }
    
    
    
}
