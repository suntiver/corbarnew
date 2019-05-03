import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
public class HelloServer{
	public static void main(String args[]){
		try{
				ORB orb = ORB.init(args, null);
				//get rootpoa address and call POA Manager
				POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
				rootpoa.the_POAManager().activate();
			
				//create usage part and register with ORB
				HelloImpl helloImpl = new HelloImpl();
				helloImpl.setORB(orb);
				//get address from usage
				org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
				Hello href = HelloHelper.narrow(ref);
				//get root naming
				//NameService call usage name
				org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
				//define service part
				NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
				//combine object and name
				String name = "Hello";
				NameComponent path[] = ncRef.to_name( name );
				ncRef.rebind(path, href);
				System.out.println("HelloServer ready and waiting ...");
				//wait request from client
				orb.run();
		   } catch (Exception e) {
				System.err.println("ERROR: " + e);
				e.printStackTrace(System.out);
		   }
				System.out.println("HelloServer Exiting ...");
		   }
}
