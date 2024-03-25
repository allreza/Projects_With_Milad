import java.util.*;
public class App {
  private static int minn=100000;
  public static void main(String[] args){
      
      Scanner s=new Scanner(System.in);
      int n=s.nextInt(),m=s.nextInt();  
      int [][]a=new int[n][m];
      int cnt=1,x1=0,y1=0,x2=0,y2=0;
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
        {
         a[i][j]=s.nextInt();
         if(a[i][j]==2)
         {
          if(cnt==1)
          {
            x1=i;
            y1=j;
            cnt=2;
          }
          else if(cnt==2){
            x2=i;
            y2=j;
          }
         }
        }
      }
      f(a, 0, 0, n, m,1,x1,y1,x2,y2,0);
      System.out.println(minn);
    }
  public static void f(int [][]a,int i,int j,int n,int m,int cnt,int x1,int y1,int x2,int y2,int fl)
  {
      if(i>=n||j<0||i<0||j>=m||a[i][j]==0||a[i][j]==-1)
      {
        return;
      }
      if(i==n-1&&j==m-1)
      {
        //System.out.println(cnt);
        if(minn>cnt)minn=cnt;
        return;
      }
      else
      {
        if(a[i][j]==1)
        {
          a[i][j]=-1;
          f(a,i+1,j,n,m,cnt+1,x1,y1,x2,y2,fl);
          f(a,i-1,j,n,m,cnt+1,x1,y1,x2,y2,fl);
          f(a,i,j+1,n,m,cnt+1,x1,y1,x2,y2,fl);
          f(a,i,j-1,n,m,cnt+1,x1,y1,x2,y2,fl);

          a[i][j]=1;
        }
        if(a[i][j]==2&&fl==1)
        {
          a[i][j]=-1;
          f(a,i+1,j,n,m,cnt+1,x1,y1,x2,y2,fl);
          f(a,i-1,j,n,m,cnt+1,x1,y1,x2,y2,fl);
          f(a,i,j+1,n,m,cnt+1,x1,y1,x2,y2,fl);
          f(a,i,j-1,n,m,cnt+1,x1,y1,x2,y2,fl);
          a[i][j]=2;
        } 
        if(a[i][j]==2&&fl==0)
        {
          if(i==x1&&j==y1)
          {
            f(a,x2,y2,n,m,cnt,x1,y1,x2,y2,1);               
          }
          else if(i==x2&&j==y2)
          {
            f(a,x1,y1,n,m,cnt,x1,y1,x2,y2,1);               

          }
        }   
      }
  }
} 
