import java.util.*;
public class App {
    private static int index=0;
    private static int[]element;
    public static void main(String[] args){
       Scanner s=new Scanner(System.in);
       String z;
       z=s.nextLine();

       String []x=z.split(" ");
       int n=toInt(x[0]);
       int host=toInt(x[1]);
      //define int array of speed   
       int []a=new int[x.length-2];
       for(int i=2;i<x.length;i++)
       {
           x[i]=x[i].replace("[", "");
           x[i]=x[i].replace("]", "");
           a[i-2]=toInt(x[i]);
       }
       //----
       
       String A="";
       for(int i=1;i<=n;i++)
       {
         
         if(i!=host)A+=Integer.toString(i); 
      }
      String X=Integer.toString(host);
      
      element=new int[fact(n-1)];
       f("",A,n-1,X);
      sort(element);
       for(int i=0;i<element.length;i++)
       {
        System.out.println(element[i]);
       }
       int minIndex=0;
       int valMin=a[0];
       for(int i=0;i<a.length;i++)
       {
         if(valMin>a[i])
         {
            minIndex=i;
            valMin=a[i];
         }
       }
       System.out.println(element[minIndex]+" is the fastest path!");
      
      }
    
   public static void f(String a,String b,int len,String host)
   {
     if(a.length()==len)
     {
      //System.out.println(host+a);
       element[index]=toInt(host+a);
       index+=1;
      return;
     }
     for(int i=0;i<b.length();i++)
     {
          if(a.indexOf(b.charAt(i))==-1)
          {
               f(a+b.charAt(i),b,len,host);
          }
     }

   }
   public static int toInt(String x)
   {
    int s=0;
    int n=x.length()-1;
    
    for(int i=0;i<=n;i++)
    {
       s+=(x.charAt(i)-48)*(power(n-i));

    }
    return s;
   }

public static int power(int x)
{
   int p=1;
   while(x>0)
   {
     p*=10;
     x--;
   }
   return p;
}
public static void sort(int[]x)
{
  for(int i=0;i<x.length;i++)
  {
     for(int j=0;j<i;j++)
     {
       if(x[j]>x[i])
       {
        int t=x[i];
        x[i]=x[j];
        x[j]=t;
       }
     }

  }

}
public static int fact(int x)
{
 if(x==0||x==1)return 1;
 return x*fact(x-1);
}

} 
