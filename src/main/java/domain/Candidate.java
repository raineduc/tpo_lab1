package domain;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
    private String name;
    private List<Characteristics> characteristics;

    public Candidate(String name) {
        this.name = name;
        characteristics = new ArrayList<>();
    }

    public Candidate(String name, List<Characteristics> characteristics) {
        this.name = name;
        this.characteristics = characteristics;
    }

    public String getName() {
        return name;
    }

    public List<Characteristics> getCharacteristics() {
        return characteristics;
    }
}
