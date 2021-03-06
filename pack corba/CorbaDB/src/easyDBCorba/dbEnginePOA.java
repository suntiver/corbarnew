package easyDBCorba;


/**
* easyDBCorba/dbEnginePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from easyDBCorba.idl
* Friday, May 3, 2019 1:42:33 PM ICT
*/

public abstract class dbEnginePOA extends org.omg.PortableServer.Servant
 implements easyDBCorba.dbEngineOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getName", new java.lang.Integer (0));
    _methods.put ("getSalary", new java.lang.Integer (1));
    _methods.put ("setSalary", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  //variber no is number
       case 0:  // easyDBCorba/dbEngine/getName
       {
         int no = in.read_long ();
         String $result = null;
         $result = this.getName (no);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // easyDBCorba/dbEngine/getSalary
       {
         int no = in.read_long ();
         double $result = (double)0;
         $result = this.getSalary (no);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // easyDBCorba/dbEngine/setSalary
       {
         int no = in.read_long ();
         double newSalary = in.read_double ();
         this.setSalary (no, newSalary);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:easyDBCorba/dbEngine:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public dbEngine _this() 
  {
    return dbEngineHelper.narrow(
    super._this_object());
  }

  public dbEngine _this(org.omg.CORBA.ORB orb) 
  {
    return dbEngineHelper.narrow(
    super._this_object(orb));
  }


} // class dbEnginePOA
