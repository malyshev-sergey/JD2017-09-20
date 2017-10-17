package by.it.mustaphin.calc;

public class Runner {
    public static void main(String[] args) {
        StoreData sd = new StoreData();
        Var varD1 = new VarD(4);
        Var varD2 = new VarD(6);
        sd.store("scalAddScal", varD1.add(varD2));
        sd.store("scalDivScal", varD1.div(varD2));
        sd.store("scalMulScal", varD1.mul(varD2));
        sd.store("scalSubScal", varD1.sub(varD2));
        VarV varV1 = new VarV(new double[]{1.8, 2.7, 3.6, 4.5});
        VarV varV2 = new VarV(new double[]{2.0, 3.0, 4.0, 5.0});
        sd.store("vecAddVec", varV1.add(varV2));
        sd.store("vecDivVec", varV1.div(varV2));
        sd.store("vecMulVec", varV1.mul(varV2));
        sd.store("vecSubVec", varV1.sub(varV2));
        sd.store("scalAddVec", varD1.add(varV2));
        sd.store("scalDivVec", varD1.div(varV2));
        sd.store("scalMulVec", varD1.mul(varV2));
        sd.store("scalSubVec", varD1.sub(varV2));
        sd.store("vecAddScal", varV2.add(varD2));
        sd.store("vecDivScal", varV2.div(varD2));
        sd.store("vecMulScal", varV2.mul(varD2));
        sd.store("vecSubScal", varV2.sub(varD2));
        VarM varM1 = new VarM("{{1, 2.6, 3}, {5, 6, 7.1}}");
        VarM varM2 = new VarM(new double[][]{{5, 6, 7}, {8, 9, 11}});
        sd.store("matAddMat", varM1.add(varM2));
        sd.store("matDivMat", varM1.div(varM2));
        sd.store("matMulMat", varM1.mul(varM2));
        sd.store("matSubMat", varM1.sub(varM2));
        sd.store("matAddVec", varM1.add(varV2));
        sd.store("matDivVec", varM1.div(varV1));
        sd.store("matMulVec", varM1.mul(varV2));
        sd.store("matSubVec", varM1.sub(varV1));
        sd.store("matAddScal", varM1.add(varD1));
        sd.store("matDivScal", varM1.div(varD2));
        sd.store("matMulScal", varM1.mul(varD1));
        sd.store("matSubScal", varM1.sub(varD2));
//        sd.sortvar();
        Parser parser = new Parser();
        parser.parse(sd);
    }
}
