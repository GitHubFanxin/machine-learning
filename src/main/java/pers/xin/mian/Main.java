package pers.xin.mian;

import pers.xin.Experiment.ExperimentDriver;
import pers.xin.Experiment.FormatSummary;
import swjtu.ml.filter.supervised.*;

/**
 * Created by xin on 2017/4/19.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int maxIterate=20;
        int swarmSize=20;
        double inertialWeight = 0.5;
        int psoTimes=3;
        String m_FSALgorithm = RSFSAID2.class.getName();
        String[] classifiers =new String[] {weka.classifiers.trees.J48.class.getName()};

//        classifiers = new String[] {weka.classifiers.trees.J48.class.getName()
//                ,weka.classifiers.trees.RandomForest.class.getName()
//                ,weka.classifiers.bayes.NaiveBayes.class.getName()
//                ,weka.classifiers.functions.LibSVM.class.getName()};
        FormatSummary.setParamNames(new String[]{"delta","alpha","beta"});
        double[][] interval = new double[][]{{0,1},{0,1},{0,1}};
        int[] precision = new int[]{2,2,2};

        String dataFilePath="/Users/xin/Desktop/Experiment/DataSet/test";
        String outputpath="/Users/xin/Desktop/Experiment/Result/test";

        ExperimentDriver driver = new ExperimentDriver();
        driver.setClassifiers(classifiers);
        driver.setFSALgorithm(m_FSALgorithm);
        driver.setPSO(swarmSize,maxIterate,inertialWeight,psoTimes);
        driver.setInterval(interval);
        driver.setPrecision(precision);
        driver.setDataFilePath(dataFilePath);
        driver.setOutputPath(outputpath);

        driver.run();
    }
}
