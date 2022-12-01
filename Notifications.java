public class Notifications 
{ 
  public static boolean isFieldEmpty(String str)
  {
    return str == null || str.equals(" ");
  }

  public static void ifUppercasePresent(String str)
  {
    int count = 0;
    String convert = "";
    for (int c = 0; c < str.length(); c++)
      {
        if (Character.isUpperCase(str.charAt(c)) == true)
        {
          count = 1;
          convert = str.toLowerCase();
        }
        else
        {
          count = 0;
        }
      }
    if (count == 1)
    {
      System.out.println(" ");
      System.out.println("An error was detected with the format of " + str + ". The new format is saved " + convert);
    }
  }

  public static void ifLetterinNumber(String str)
  {
    int count = 0;
    for (int c = 0; c < str.length(); c++)
      {
        if (Character.isDigit(str.charAt(c)) == false)
        {
          count = 1;
        }
        else
        {
          count = 0;
        }
      }
    if (count == 1)
    {
       System.out.println(" ");
      System.out.println("An error was detected with the data entered. Please resubmit.");
    }
  }
}