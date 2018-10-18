public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno != 0) {
      numerator = nume;
      denominator = deno;
    this.reduce();
    }
    else {
      numerator = 0;
      denominator = 1;
    }
}

  public double getValue(){
    return numerator / (double)denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator,numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator == other.getNumerator() && denominator == other.getDenominator());
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    this.reduce();
    if (numerator == 0) {
      return "0";
    }
    if (denominator == 1) {
      return "" + numerator;
    }
    return "" + numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
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

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int originalNumerator = numerator;
    numerator /= gcd(numerator,denominator);
    denominator /= gcd(originalNumerator,denominator);
    if (denominator < 0) {
        denominator *= -1;
        numerator *= -1;
    }
    if (denominator == 0) {
        reciprocal();
    }
}
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int outputTop = this.numerator * other.numerator;
    int outputBot = this.denominator * other.denominator;
    RationalNumber output = new RationalNumber(outputTop,outputBot);
    return output;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
     return new RationalNumber(this.getNumerator() * other.getDenominator(), this.getDenominator() * other.getNumerator());
 }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int outputTop = this.numerator * other.denominator + other.numerator * this.denominator;
    int outputBot = this.denominator * other.denominator;
    RationalNumber output = new RationalNumber(outputTop,outputBot);
    return output;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int outputTop = this.numerator * other.denominator - other.numerator * this.denominator;
    int outputBot = this.denominator * other.denominator;
    RationalNumber output = new RationalNumber(outputTop,outputBot);
    return output;
  }
}
