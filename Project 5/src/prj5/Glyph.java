package prj5;

/**
* @author Avni Trasi (avnitrasi)
* @version 2019.04.15
* @author James Livingston (jamesrliving)
* @version 2019.04.15
* @author Oliver Luo (luooc)
* @version 2019.04.15
* @author Sabrina Lesser (brinalesser)
* @version 2019.04.15
*/

public class Glyph
{
    private String text;
    private int[] likes;
    private int[] dislikes;
    
    public Glyph(String text, int[] likes, int[] dislikes)
    {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
