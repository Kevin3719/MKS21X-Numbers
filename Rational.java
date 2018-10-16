public class Rational extends Real{
  private int top;
  private int bot;

  public Rational() {
    top = 0;
    bot = 0;
  }
  public Rational(int numa, int numb) {
    top = numa;
    bot = numb;
  }
  public int getTop() {
    return top;
  }
  public int getBot() {
    return bot;
  }
  public String toString() {
    return "top: " + top + "bot" + bot;
  }
  public boolean isBigger(Rational d) {
    return true;
  }
}
