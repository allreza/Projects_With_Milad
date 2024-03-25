import java.util.*;
public class App {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String a;
        a=s.nextLine();
        int n=a.length();
        boolean flj=false;
        boolean flm=false;
        boolean flp=false;
        boolean flt=false;
        for(int i=0;i<n;i++)
        {
          for(int j=i;j<n;j++)
          {
              for(int k=j+1;k<n;k++)
              {
                 for(int w=k+1;w<n;w++)
                 {
                     String x="",y="",z="";
                     for(int t=i;t<=j;t++)x+=a.charAt(t);
                     for(int t=j+1;t<=k;t++)y+=a.charAt(t);
                     for(int t=k+1;t<=w;t++)z+=a.charAt(t);
                      int x1=to(x);
                      int y1=to(y);
                      int z1=to(z);
                      if(x1+y1==z1)flj=true;
                      if(x1*y1==z1)flp=true;
                      if(x1-y1==z1||y1-x1==z1)flm=true;
                      if((y1!=0&&x1/y1==z1&&x1%y1==0)||(x1!=0&&y1/x1==z1&&y1%x1==0))flt=true;
               //      System.out.println(x1+" "+y1+" "+z1);
                 }
              }
               
          }
        
        }
         System.out.println("+ : "+(flj?"True":"False"));
         System.out.println("- : "+(flm?"True":"False"));
         System.out.println("* : "+(flp?"True":"False"));
         System.out.println("/ : "+(flt?"True":"False"));
    
      }
      public static int to(String x)
      {
       int s=0;
       int n=x.length()-1;
       int p=1;
       for(int i=n;i>=0;i--)
       {
          s+=(x.charAt(n-i)-48)*p;
          p*=10;

       }
       return s;
      }

      public static void f(String a,String b,int cnt)
      {
      if(cnt==3)
      {
        System.out.println(b);
        return;
      }
       int n=a.length();
       for(int i=0;i<n;i++)
       {     
            String y="";
            for(int j=i+1;j<n;j++)
            {
              y+=a.charAt(j);
            }
            f(y,b+a.charAt(i),cnt+1);
       }
      }

} 
