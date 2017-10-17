package by.it.mustaphin.calc;

public class Runner {
    public static void main(String[] args) {
        Var varD1 = new VarD(4);
        Var varD2 = new VarD(6);
        varD1.assignment("scalAddScal", varD1.add(varD2));
        varD1.assignment("scalDivScal", varD1.div(varD2));
        varD1.assignment("scalMulScal", varD1.mul(varD2));
        varD1.assignment("scalSubScal", varD1.sub(varD2));
        VarV varV1 = new VarV(new double[]{1.8, 2.7, 3.6, 4.5});
        VarV varV2 = new VarV(new double[]{2.0, 3.0, 4.0, 5.0});
        varD1.assignment("vecAddVec", varV1.add(varV2));
        varD1.assignment("vecDivVec", varV1.div(varV2));
        varD1.assignment("vecMulVec", varV1.mul(varV2));
        varD1.assignment("vecSubVec", varV1.sub(varV2));
        varD1.assignment("scalAddVec", varD1.add(varV2));
        varD1.assignment("scalDivVec", varD1.div(varV2));
        varD1.assignment("scalMulVec", varD1.mul(varV2));
        varD1.assignment("scalSubVec", varD1.sub(varV2));
        varD1.assignment("vecAddScal", varV2.add(varD2));
        varD1.assignment("vecDivScal", varV2.div(varD2));
        varD1.assignment("vecMulScal", varV2.mul(varD2));
        varD1.assignment("vecSubScal", varV2.sub(varD2));
        VarM varM1 = new VarM("{{1, 2.6, 3}, {5, 6, 7.1}}");
        VarM varM2 = new VarM(new double[][]{{5, 6, 7}, {8, 9, 11}});
        varD1.assignment("matAddMat", varM1.add(varM2));
        varD1.assignment("matDivMat", varM1.div(varM2));
        varD1.assignment("matMulMat", varM1.mul(varM2));
        varD1.assignment("matSubMat", varM1.sub(varM2));
        varD1.assignment("matAddVec", varM1.add(varV2));
        varD1.assignment("matDivVec", varM1.div(varV1));
        varD1.assignment("matMulVec", varM1.mul(varV2));
        varD1.assignment("matSubVec", varM1.sub(varV1));
        varD1.assignment("matAddScal", varM1.add(varD1));
        varD1.assignment("matDivScal", varM1.div(varD2));
        varD1.assignment("matMulScal", varM1.mul(varD1));
        varD1.assignment("matSubScal", varM1.sub(varD2));
        new Parser().parse();
    }
}
