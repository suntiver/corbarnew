package CalculatorCorba;


/**
* CalculatorCorba/CalculatorEngineOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalculatorCorba.idl
* Friday, May 3, 2019 12:08:51 PM ICT
*/

public interface CalculatorEngineOperations 
{

  //Perform the calculations:plus/subtract/multiply/divide
  double plus (double val1, double val2);
  double subtract (double val1, double val2);
  double multiply (double val1, double val2);
  double divide (double val1, double val2);

  //The Server EXITS when the Client prompts it to do so
  void shutdown ();
} // interface CalculatorEngineOperations