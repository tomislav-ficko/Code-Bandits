package hr.hackaton.codebandits.algorithm;


import hr.hackaton.codebandits.entity.Person;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.IOException;
import java.util.*;

public class Algorithm {

    // min stock of blood
    private static BloodStock oMin;
    // max stock of blood
    private static BloodStock oMax;
    // optimal stock of blood
    private static BloodStock oZ;
    // stock of blood on the beginning of (i+1) week
    private static List<BloodStock> zI;
    // spent stock of blood for every week
    private static BloodStock p;
    // interval
    private static BloodStock r;
    //stock of donated blood by blood types on the end of the week
    private static List<BloodStock> sI;

    private static Map<Integer, List<Integer>> tableForCompatibilty;


    public static void main(String[] args) {
        initialize();
        BloodStock z = new BloodStock(88, 177, 71, 145, 60, 36, 13, 26);
        BloodStock s = corecctionBloodStock(z);
        System.out.println(s.getList().toString());
    }
    
    public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);
        return dist;
    }




    public static void initialize() {
        oMin = new BloodStock(38, 115, 46, 100, 38, 23, 8, 16);
        oMax = new BloodStock(78, 240, 96, 210, 82, 50, 18, 36);
        oZ = new BloodStock(58, 177, 71, 155, 60, 36, 13, 26);
        p = new BloodStock(35, 105, 42, 91, 35, 21, 7, 14);
        List<Integer> listMax = oMax.getList();
        List<Integer> listMin = oMin.getList();
        r = new BloodStock(listMax.get(0) - listMin.get(0),
                listMax.get(1) - listMin.get(1),
                listMax.get(2) - listMin.get(2),
                listMax.get(3) - listMin.get(3),
                listMax.get(4) - listMin.get(4),
                listMax.get(5) - listMin.get(5),
                listMax.get(6) - listMin.get(6),
                listMax.get(7) - listMin.get(7)
        );
        zI = new ArrayList<>();
        sI = new ArrayList<>();

        tableForCompatibilty = new HashMap<>();

        tableForCompatibilty.put(0, Arrays.asList(0)); //0 minus
        tableForCompatibilty.put(1, Arrays.asList(0, 1)); // 0 plus
        tableForCompatibilty.put(2, Arrays.asList(0, 2)); // A minus
        tableForCompatibilty.put(3, Arrays.asList(0, 1, 2, 3)); // A plus
        tableForCompatibilty.put(4, Arrays.asList(0, 4)); // B minus
        tableForCompatibilty.put(5, Arrays.asList(0, 1, 4, 5)); // B plus
        tableForCompatibilty.put(6, Arrays.asList(0, 2, 4, 6)); // AB minus
        tableForCompatibilty.put(7, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)); //AB plus


    }




    public List<Person> getDonatorsWeek(List<Person> users, BloodStock z0) {
        zI.add(z0);
        // zadana funkcija gubitka minimalna

        BloodStock z1 = new BloodStock();

        for (int weekCounter = 0; weekCounter < 4; weekCounter++) {
            for (int i = 0; i <= 7; i++) {
                z1.addElement(zI.get(weekCounter).getList().get(i) + sI.get(weekCounter).getList().get(i) - p.getList().get(i));
                BloodStock newZI = corecctionBloodStock(zI.get(weekCounter));
                int lossSum = 0;
                for (int bloodType = 0; bloodType <= 7; bloodType++) {
                    lossSum += lossFunction(bloodType, newZI.getList().get(bloodType));
                }

            }
        }

        try (RecordReader recordReader = new CSVRecordReader(0, ',')) {
            recordReader.initialize(new FileSplit(
                    new ClassPathResource("test.txt").getFile()));


            DataSetIterator iterator = new RecordReaderDataSetIterator(
                    recordReader, 150);
            DataSet allData = iterator.next();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MultiLayerConfiguration configuration
                = new NeuralNetConfiguration.Builder()
                .iterations(1000)
                .activation(Activation.TANH)
                .weightInit(WeightInit.XAVIER)
                .learningRate(0.1)
                .regularization(true).l2(0.0001)
                .list()
                .layer(0, new DenseLayer.Builder().nIn(3).nOut(3).build())
                .layer(1, new DenseLayer.Builder().nIn(3).nOut(3).build())
                .layer(2, new OutputLayer.Builder(
                        LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .activation(Activation.SOFTMAX)
                        .nIn(3).nOut(3).build())
                .backprop(true).pretrain(false)
                .build();

        return null;
    }

    public int lossFunction(int bloodType, int stock) {


        int rValue = r.getList().get(bloodType);
        int oMinValue = oMin.getList().get(bloodType);
        int oMaxValue = oMax.getList().get(bloodType);

        // TODO this should be value of how much there is certain blood
        int x = stock;
        if (x <= oMinValue) {
            return 35 + (oMinValue - x) * 200 / rValue;

        } else if (oMinValue < x && x <= (rValue / 3) + oMinValue) {
            return (oMinValue + rValue / 3 - x) * 100 / rValue;

        } else if (rValue / 3 * oMinValue < x && x <= (2 * rValue / 3) + oMinValue) {
            return 0;

        } else if ((2 * rValue / 3) + oMinValue < x && x <= oMaxValue) {
            return (x - 2 * rValue / 3 - oMinValue) * 100 / rValue;

        } else {
            return 35 + (x - oMaxValue) * 200 / rValue;
        }
    }

    public static BloodStock corecctionBloodStock(BloodStock z) {
        List zList = z.getList();
        List minList = oMin.getList();
        List maxList = oMax.getList();
        List oList = oZ.getList();
        List<BloodStock> zNew = new ArrayList<>();
        zNew.addAll(zList);
        for (int i = 0; i <= 7; i++) {
            if ((int) zList.get(i) < (int) minList.get(i) || (int) zList.get(i) > (int) maxList.get(i)) {
                System.out.println("done");
                return z;
            }
        }

        for (int i = 0; i <= 7; i++) {
            // if there is less blood than optimal
            System.out.println( zList.get(i) + " - " +  oList.get(i));
            if ((int) zList.get(i) < (int) oList.get(i)) {
                for (int j = 7; j >= 0; j++) {
                    int amountToGive = (int) zList.get(j) - (int) oList.get(j);
                    System.out.println(amountToGive);
                    if (canDonate(i, j) && amountToGive > 0) {
                        zList.set(j, (int) zList.get(j) - amountToGive);
                        zList.set(i, (int) zList.get(i) + amountToGive);
                        if ((int) zList.get(i) >= (int) oList.get(i)) {
                            //break loop
                            j = 7;
                        }
                    }
                }
            }
        }

        return z;
    }

    private static boolean canDonate(int bloodKey, int bloodValue) {
        //check bloodTypes
        List<Integer> values = tableForCompatibilty.get(bloodKey);

        if (values.contains(bloodValue)) {
            return true;
        }

        return false;
    }

}
