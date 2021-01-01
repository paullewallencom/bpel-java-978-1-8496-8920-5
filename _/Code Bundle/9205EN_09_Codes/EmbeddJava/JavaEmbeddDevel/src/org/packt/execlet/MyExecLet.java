package org.packt.execlet;

import com.collaxa.cube.engine.ext.bpel.v1.nodes.BPELXExecLet;
import com.oracle.bpel.client.BPELFault;


public class MyExecLet extends BPELXExecLet {
    public MyExecLet() {
        super();
    }


    @Override
    public void addAuditTrailEntry(String string) {
        System.out.println(string);            
    }

    @Override
    public void addAuditTrailEntry(String string, Object object) {
        System.out.println("String value: " + string);
        if (object != null)
            System.out.println("Object value: " + object.toString());
        else
            System.out.println("Object value: NULL");
    }

    @Override
    public void addAuditTrailEntry(Throwable throwable) {
        throwable.printStackTrace();
    }
    
    @Override
    public void execute() throws BPELFault {
        super.execute();

/**
 * Below is the code we use in the BPEL_and_Java_2_0 BPEL process
 * Java_Embedding1 activity
 */         
/*        //get request data  
        String input_date= ((XMLElement)getVariableData("inputVariable","payload","/client:process/client:input_date")).getTextContent();  
          
        //parse it to the date  
        SimpleDateFormat sdf_input = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");  
        Date dt= new Date();  
          
        try {  
            dt= sdf_input.parse(input_date);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
          
        //now format it to the new date  
        SimpleDateFormat sdf = new SimpleDateFormat("E");  
        String dateStr = sdf.format(dt);          
          
        //assign it to response variable  
        setVariableData("outputVariable", "payload", "/client:processResponse/client:day_of_date", dateStr); 
*/
/*
try {       
    java.util.Hashtable env = new java.util.Hashtable();       
    // WebLogic Server 10.x connection details       
    env.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );       
    env.put(javax.naming.Context.PROVIDER_URL, "t3://localhost:7001");       
    javax.naming.Context context = new javax.naming.InitialContext( env );       
           
    Object obj= context.lookup("ExchangeATM_EJB#org.packt.ejb.atm.ExchATM_EJBRemote");       
   
    if (obj != null)     
    {             
      org.packt.ejb.atm.ExchATM_EJBRemote atmBean= (org.packt.ejb.atm.ExchATM_EJBRemote)obj;            
      
      double exchMoney=atmBean.exchangeMoney(525.8, "USD");      
        
      addAuditTrailEntry("You receive " + exchMoney + " EUR.");         
   
    }     
     
} catch (javax.naming.NamingException e) {       
    addAuditTrailEntry(e);       
}  
*/

/*
//ora:format
String input_txt= "test";
java.text.MessageFormat mfmt= new java.text.MessageFormat("At {0, time} on {0,date} the BPEL was intatiated with the following input parameter: {1}.");

Object[] objs = {new java.util.Date(), input_txt};
        
String result= mfmt.format(objs);

addAuditTrailEntry("Fmt msg: " + result);
*/       

/* //setting the BPEL variable data
String input_txt_from_var= (String)getVariableData("Input_Txt_Var");

StringBuilder sb = new StringBuilder();
for (int i = input_txt_from_var.length() - 1; i >= 0; i--)
  sb.append(input_txt_from_var.charAt(i));        

addAuditTrailEntry("Operation: " + sb.toString());      

setVariableData("outputVariable","payload","/client:processResponse/client:clientResponseMsg", sb.toString());  */
        
/*
//auditing

addAuditTrailEntry("Start processing the Java Embedding activity");

//test
//Object input_obj= "12";        
//Object input_obj= "abc";        
Object input_obj= getVariableData("Input_Txt_Var");        
addAuditTrailEntry("Input data", input_obj);

try {
    Double whatNumber = Double.parseDouble((String)input_obj);
    addAuditTrailEntry("Number is:", whatNumber);
} catch (NumberFormatException nfe) {
    addAuditTrailEntry("Not a number ?");
    addAuditTrailEntry(nfe);
} */
        
    long prc_id= getInstanceId();
    String prc_title= getTitle();
    String prc_creator= getCreator();
  
    addAuditTrailEntry("Debug: |" +  prc_id + "| |"  + prc_title + "| |" + prc_creator);
  
    if (prc_id > 0)  
        setVariableData("outputVariable", "payload", "/client:processResponse/client:prc_inst_id", prc_id);
    if (prc_title != null)
        setVariableData("outputVariable", "payload", "/client:processResponse/client:prc_inst_title", prc_title);
    if (prc_creator != null)
        setVariableData("outputVariable", "payload", "/client:processResponse/client:prc_inst_creator", prc_creator);
  
    String prc_status= getStatus();
    
    if (prc_status != null)  
        setVariableData("outputVariable", "payload", "/client:processResponse/client:prc_status", prc_status);
        
        
    }
  
    
    public static void main(String[] args) {
        MyExecLet test= new MyExecLet();
        test.execute();
        
        
    }

}
