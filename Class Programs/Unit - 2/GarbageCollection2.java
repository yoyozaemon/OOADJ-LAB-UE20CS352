package garbagecollection2;
public class GarbageCollection2
{
	int n;
	int y;
	
	GarbageCollection2(int x,int y)
	{
		n=x;
		this.y=y;
	}
	
	
        public void finalize()
            {
                System.out.println("finalize method overriden");
           }
    
        public static void main(String[] args)
            {
                GarbageCollection2 m;
            m = new GarbageCollection2(10,29);

                // Calling finalize method Explicitly.
               m.finalize();
                //m.finalize();
                m = null;

                // Requesting JVM to call Garbage Collector method
                System.out.println("Before GC");
                System.gc();
                System.out.println("Main Completes");
            }
            // Here overriding finalize method
        
    
    
/*    // extra example
    
    public static void main(String args[]){  
        /* Here we are intentionally assigning a null 
         * value to a reference so that the object becomes
         * non reachable
         */
	//GarbageCollection2 obj=new GarbageCollection2();  
	//obj=null;  
		
        /* Here we are intentionally assigning reference a 
         * to the another reference b to make the object referenced
         * by b unusable.
         */
	/*GarbageCollection2 a = new GarbageCollection2();
	GarbageCollection2 b = new GarbageCollection2();
	b = a;
	System.gc();  
   }  
   protected void finalize() throws Throwable
   {
        System.out.println("Garbage collection is performed by JVM");
   }*/
}
