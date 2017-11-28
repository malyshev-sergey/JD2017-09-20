package by.it.govor.jd02_10.taskA;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
class TestClass {
    private int int2 = 0;
    private int int3 = 0;
    private String name;

     TestClass(String name, int int2, int int3) {
    this.int2=int2;
    this.int3=int3;
    this.name= name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "DevPOJO{" +
                "\n int1=" + int3 +
                "\n int2="+int2+
                ",\nname='" + name + '\'' +"\n}";
    }


}
