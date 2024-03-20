public class MyWord {

    public String _word;
    public int _wordCount;

    public MyWord()
    {
    }

    public MyWord(String inWord,int inCount) {
        _word = inWord;
        _wordCount = inCount;
    }

    public void print()
    {
        System.out.println(this._word+"    "+this._wordCount);
    }
}
