package diproj.signups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum People {
    instance;

    private List<Person> ppl = new ArrayList<>();

    private People(){}

    public List<Person> getModel(){
        return ppl;
    }
}