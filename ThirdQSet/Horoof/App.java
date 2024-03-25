import java.util.*;
public class App {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a=s.nextLine(); 
        System.out.println(f(a));    
    }
    public static int f(String a)
    {
       int n=a.length();
       int x=0;
       String b="";
       int fl=0;
       for(int i=0;i<n-1;i++)
       {
          if(a.charAt(i)==a.charAt(i+1))
          {
            x=a.charAt(i);
            for(int j=0;j<n;j++)
            {
              if(a.charAt(j)!=a.charAt(i))b+=a.charAt(j);
              
            }
          fl=1;
          break;        
          }
 
       }
     if(fl==1)return x+f(b);
     return 0;
    }

}
