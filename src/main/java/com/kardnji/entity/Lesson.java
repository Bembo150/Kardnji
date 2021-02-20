package com.kardnji.entity;

import java.util.ArrayList;

public class Lesson {
    String name;

    ArrayList<Kard> kards;

    public Lesson (String name, ArrayList<Kard> kards) {
        this.name = name;
        this.kards = kards;
    }
    
    public String getName() {
        return name;
    }

    public ArrayList<Kard> getKards() {
        return kards;
    }

    @Override
    public String toString() {
        String output = "Lesson "+name + "{\n";
        for (Kard k : kards) {
            output += k.toString() + "\n";
        }
        return output + "}";
    }
}
