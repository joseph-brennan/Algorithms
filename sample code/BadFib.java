import java.math.BigInteger;
import java.util.Scanner;

public class BadFib
{
  public static BigInteger count = BigInteger.ZERO;

  public static void main(String[] args)
  {
    int n;
    System.out.print("Enter n for which you want Fib(n) computed: ");
    Scanner keys = new Scanner( System.in );
    n = keys.nextInt();

    System.out.println("Fib at that n is " + fib(n) );
    System.out.println("Took " + count + " adds");

  }

  private static BigInteger fib( int n )
  {
    if( n == 0 )
      return BigInteger.ONE;
    else if( n == 1 )
      return BigInteger.ONE;
    else
    {
      count = count.add( BigInteger.ONE );
      return fib( n-1 ).add( fib( n-2 ) );
    }

  }

}
