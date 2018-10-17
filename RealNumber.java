
public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  public double add(RealNumber other){
     return this.getValue() + other.getValue();
  }

  /*
  *Return the product of this and the other
  */
  public double multiply(RealNumber other){
    return this.getValue() * other.getValue();
  }

  /*
  *Return the this divided by the other
  */
  public double divide(RealNumber other){
    return this.getValue() / other.getValue();
  }

  /*
  *Return the this minus the other
  */
  public double subtract(RealNumber other){
    return this.getValue() + -1 * other.getValue();
  }


  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+value;
  }
}
