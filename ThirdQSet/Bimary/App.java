import java.util.*;
public class App {
    public static void main(String[] args){
      
      Scanner s=new Scanner(System.in);
       String x="";
       int n=0,m=0;
       while(true)
       {
         String in=s.nextLine();
         String []b=in.split(",");
         m=b.length;
         n+=1;
         x+=in;
         if(in.charAt(in.length()-1)=='}')break;         
       }
       int X=s.nextInt(),Y=s.nextInt();
       x=x.replace("{","").replace("}", "").replace(" ", "");
       String []input=x.split(",");
       int [][]a=new int[n][m];
       int cnt=0;
       for(int i=0;i<n;i++)
       {
         for(int j=0;j<m;j++)
         {
           a[i][j]=toInt(input[cnt]);
           cnt++;
         }
       }
       f(a,n,m,X,Y,a[X][Y]/10);
      for(int i=0;i<a.length;i++)
      {
         for(int j=0;j<a[i].length;j++)
         {
            System.out.print(a[i][j]+" ");
         }    
         System.out.println();     
      }   
      
      


      }
    
    public static void f(int [][]a,int n,int m,int x,int y,int d)
    {
      if(x>=n||y>=m||x<0||y<0)return;
      if(a[x][y]/10==d)
      {
         a[x][y]=50+d*10;
            
      if(x-1>=0&&a[x-1][y]/10==d)
      {
        f(a,n,m,x-1,y,d);
      }
      if(x+1<n&&a[x+1][y]/10==d)
      {
        f(a,n,m,x+1,y,d);
      }
      if(y-1>=0&&a[x][y-1]/10==d)
      {
        f(a,n,m,x,y-1,d);
      }
      if(y+1<m&&a[x][y+1]/10==d)
      {
        f(a,n,m,x,y+1,d);
      }
     }
     else return;  
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

} 
