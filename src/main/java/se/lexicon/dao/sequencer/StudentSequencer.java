package se.lexicon.dao.sequencer;

public class StudentSequencer {

    private static int studentSequencer;

    public static int nextStudentId(){
        return ++studentSequencer;
    }
    public static int getStudentSequencer (){
        return studentSequencer;
    }
}

