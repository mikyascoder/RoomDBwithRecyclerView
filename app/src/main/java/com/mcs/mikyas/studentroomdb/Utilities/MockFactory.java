package com.mcs.mikyas.studentroomdb.Utilities;

import com.mcs.mikyas.studentroomdb.Model.Student;

import java.util.ArrayList;

public class MockFactory {
    public static ArrayList<Student> getstudents() {
        ArrayList<Student> output = new ArrayList<>();
        output.add(new Student("Shannon", "Harlan", "161718"));
        output.add(new Student("Bryanna", "Rodden", "261718"));
        output.add(new Student("Velda ", "Bridgett", "361718"));
        output.add(new Student("Sandie", "Morant", "461718"));
        output.add(new Student("Hayley", "Morant", "561718"));
        output.add(new Student("Irma", "raul", "661718"));
        output.add(new Student("skate","derik","761718"));
        output.add(new Student("hawnda", "peter", "861718"));
        output.add(new Student("Lucius", "raul", "961718"));
        output.add(new Student("Velda", "Varlan", "1061718"));
        output.add(new Student("Morant", "hwanda", "111718"));
        return output;
    }
}
