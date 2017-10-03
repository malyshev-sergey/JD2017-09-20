package by.it.meshchenko.jd01_02;

public class ComplexNumber {
    private double real;
    private double imgr;

    public ComplexNumber(double real, double imgr){
        this.real = real;
        this.imgr = imgr;
    }

    public String toString(){
        String strReal = real != 0 ? Double.toString(real) : "";
        String strImgr = imgr != 0 ? (imgr > 0 ?
                ("i*" + Double.toString(imgr)) : ("-i*" + Double.toString(-imgr))) : "";
        return (real != 0 && imgr > 0) ? (strReal + "+" + strImgr) : (strReal + strImgr);

    }
}
