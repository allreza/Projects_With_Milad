import java.util.Scanner;

public class Main
{
    static short n;
 
    public static void main(String args[])
    {
        Scanner _input = new Scanner(System.in);
        n = _input.nextShort();

        if(n%2 == 0 || n <= 3)
        return;

        ShapeShow();
    }

    public static void ShapeShow()
    {
        boundryCreator();
        betweenCreator('u');
        midLineCreator();
        betweenCreator('d');
        boundryCreator();
    }

    public static void boundryCreator()
    {
        for(short i = 0; i < n; i++)
        {
            System.out.print('*');
            System.out.print(' ');
        }
        System.out.print('\n');
    }

    public static void betweenCreator(char position)
    {
        for(short i = 0; i < ((n-3)/2);i++)
        {
            if(position == 'u')
            {
            //First star
            System.out.print('*');

            betweenCreatorInner("ds",i);
            
            //Second star
            System.out.print('*');
            
            betweenCreatorInner("ub",i);

            //Third star
            System.out.print('*');
            
            betweenCreatorInner("db",i);

            //Fourth star
            System.out.print('*');
            
            betweenCreatorInner("ub",i);

            //Fifth star
            System.out.print('*');
            
            betweenCreatorInner("ds",i);

            //Sixth star
            System.out.println('*');
            }
            else if(position == 'd')
            {
                //First star
                System.out.print('*');

                betweenCreatorInner("us",i);
            
                //Second star
                System.out.print('*');
            
                betweenCreatorInner("db",i);

                //Third star
                System.out.print('*');
            
                betweenCreatorInner("ub",i);

                //Fourth star
                System.out.print('*');
            
                betweenCreatorInner("db",i);

                //Fifth star
                System.out.print('*');
            
                betweenCreatorInner("us",i);

                //Sixth star
                System.out.println('*');
            }
            else {return;}
        }
    }

    public static void betweenCreatorInner(String direction, short i)
    {
        switch(direction)
        {
            case "us":
            for(short j = (short)(((n-3)/2) - (i+1)); j >0; j--)
                System.out.print(' ');
            break;

            case "ds":
            for(short j = 0; j < i; j++)
                System.out.print(' ');
            break;

            case "ub":
            for(short k = (short)(n-4-(2*i)); k > 0; k--)
            System.out.print(' ');
            break;

            case "db":
            for(short j = 0; j < (2*i)+1; j++)
                System.out.print(' ');
            break;

            default:
            return;
        }
    }

    public static void midLineCreator()
    {
        //First star
        System.out.print('*');
        for(short i = 0; i < ((n-3)/2);i++)
        {
            System.out.print(' ');
        }

        //Second star
        System.out.print('*');
        for(short i = 0; i < ((n-2));i++)
        {
            System.out.print(' ');
        }

        //Third star
        System.out.print('*');
        for(short i = 0; i < ((n-3)/2);i++)
        {
            System.out.print(' ');
        }
        //Fourth star
        System.out.println('*');
    }
}