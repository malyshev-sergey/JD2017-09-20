package by.it.malyshev.jd02_10;

import by.it.malyshev.jd02_09.manual.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class TaskA_PojoToJsonAndBackAgain {

    public static void main(String[] args) {

        Gendata gene = new Gendata() {
            {
                Geocoord g = new Geocoord(46.9983, 7.4513);
                STRmarkers strs = new STRmarkers(12, 24, 14, 12, 12, 15, 12, 12, 13, 14, 13, 30);
                Haplotype h = new Haplotype(strs, "L51-, Z2103+");
                Person p = new Person("Archibald Volf", "Adam Volf", "Switzerland", g, h, "N22223");
                this.add(p);
                g = new Geocoord(53.8423, 11.4642);
                strs = new STRmarkers(13, 23, 14, 13, 11, 16, 13, 14, 15, 11, 14, 31);
                h = new Haplotype(strs, "L23+, L51+, Z2103-");
                p = new Person("Andreas Knopf", "Martin Knopf", "Germany", g, h, "322223");
                this.add(p);
            }
        };

        //маршаллизация
        Type gendataType = new TypeToken<Gendata>() { }.getType();
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(gene, gendataType);
        System.out.print(json);

        //демаршаллизация
        Gendata gene2 = gson.fromJson(json, Gendata.class);
        System.out.print("\n\ngene2=" + gene2.toString());
    }


}
