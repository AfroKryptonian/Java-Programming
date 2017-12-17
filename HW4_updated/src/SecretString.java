/**
 * 
 */


/**
 * 
 * @author David Chukwuma & David Mawazo Andrew ID: dchukwue, dmawazo On my
 *         honor, as a Carnegie-Mellon Rwanda student, I have neither given nor
 *         received unauthorized assistance on this work.
 * 
 */
public class SecretString
{
    private String phrase = new String("");
    private String displayedPhrase = new String("");
    private String secretString;
    private Boolean clstatus = false;

    public SecretString()
    {

        setPhrase("Java is Great!");
        setDisplayedPhrase();
    }

    public SecretString(String phrase)
    {

        setPhrase(phrase);
        setDisplayedPhrase();
    }

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase(String phrase_)
    {
        phrase = phrase_;
    }

    public String getDisplayedPhrase()
    {
        return secretString;
    }

    public void setDisplayedPhrase()
    {
        secretString = makeDisplayString(phrase);
    }

    public String makeDisplayString(String phrase)
    {
        displayedPhrase = phrase.replaceAll("[A-Za-z]", "_");

        return displayedPhrase;
    }

    public Boolean checkLetters(String str)
    {
        int length = str.length();
        String letter = "";

        phrase = phrase.toLowerCase();

        for (int i = 0; i < length; i++)
        {
            letter = str.substring(i, i + 1);

            if (phrase.contains(letter))
            {
                clstatus = true;

            }

            else
            {
                clstatus = false;
                break;
            }
        }

        return clstatus;
    }

    public Boolean checkPhrase(String str)
    {
        String tempphrase = phrase.replaceAll("(\\s|\\p{Punct})", "");
        String tempstr = str.replaceAll("(\\s|\\p{Punct})", "");

        Boolean status = false;

        if (tempphrase.equalsIgnoreCase(tempstr))
        {
            status = true;
        }

        return status;
    }

    public Boolean revealPhrase(String str)
    {

        if (checkPhrase(str))
        {
            secretString = phrase;
            return true;

        } else
        {

            return false;
        }
    }

    public void revealLetters(String str)
    {
        int length = str.length();
        char letter = 'x';

        if (checkLetters(str))
        {
            for (int i = 0; i < length; i++)
            {
                letter = str.charAt(i);
                int temp = 0;

                for (int j = 0; j < phrase.length(); j++)
                {

                    if (phrase.charAt(j) == letter)
                    {
                        secretString = secretString.substring(0, j) + letter
                                + secretString.substring(j + 1, phrase.length());
                        temp++;

                    }

                }
                System.out.println("There are " + temp + "\"" + letter + "\"s");
            }
        }

        else
        {
            System.out.println("Try again! " + str + " is not in the secret");
        }
    }

    public Boolean hasGameFinished()
    {
        Boolean status = false;
        int count = 0;

        String letter = "_";

        for (int j = 0; j < secretString.length(); j++)
        {
            if (secretString.substring(j, j + 1).equals(letter))
            {
                count++;
                break;

            }

        }

        if (count == 0)
        {
            status = true;
        }

        return status;
    }

    public String toString()
    {
        return secretString;
    }

}
