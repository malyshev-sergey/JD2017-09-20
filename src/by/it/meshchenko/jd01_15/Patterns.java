package by.it.meshchenko.jd01_15;

public interface Patterns {
    // TaskA
    String comm1Start = "/\\*.+";       // /* text...
    String comm1End = ".*\\*/";         // text... */
    String comm1Full = "/\\*.+\\*/";      // /* text... */
    String comm2Full = "//.+";      // // text...

    //TaskC
    String cdStr = "cd .+";      // cd jd01_15
    String dirStr = "dir";      // dir
}
