public class gcdchecker{
  private static int gcd(int a, int b){
    a = Math.abs(a);
    b = Math.abs(b);
    int themax = Math.max(a,b);
    int themin = Math.min(a,b);
    int differ = themax - themin;
    if (themin % differ == 0) {
      return differ;
    }
    return gcd(themin,differ);
  }
  public static void main(String[] args) {
    System.out.print(gcd(15,20));
    System.out.print(gcd(18,60));
    System.out.print(gcd(16,38));
    }
  }
