/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbarserver;

import HelloApp.HelloPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author lenovo
 */
public class HelloServant  extends HelloPOA{
//    private String massage ="\nHello Word  sent message from server  !\n";
    private  String massage;
    private ORB orb;
    public  void setORB(ORB orb_val){

       this.orb = orb_val;
    }

    public void setMassge(String massage) {
        this.massage = massage;
    }
    
        
  
    public String hellomaessage() {
       return  massage;
    }


    public void hellomaessage(String newHellomaessage) {
        
        massage = newHellomaessage;
        
    }
}
