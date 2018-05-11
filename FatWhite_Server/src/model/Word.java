package model;

public class Word {
	private String word;
	private String soundmark;
	private String translation;
	private String sentence;
    private int importance;

    public String get_word(){
        return word;
    }
    public void set_word(String word){ this.word = word; }

    public String get_soundmark(){
        return soundmark;
    }
    public void set_soundmark(String soundmark){
        this.soundmark = soundmark;
    }

    public String get_translation(){
        return translation;
    }
    public void set_translation(String translation){
        this.translation = translation;
    }

    public String get_sentence(){
        return sentence;
    }
    public void set_sentence(String sentence){
        this.sentence = sentence;
    }

    public int get_importance(){
        return importance;
    }
    public void set_importance(int importance){
        this.importance = importance;
    }
}
