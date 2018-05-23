package hr.hackaton.codebandits.algorithm;

import hr.hackaton.codebandits.BloodType;
import hr.hackaton.codebandits.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    public List<User> getDonatorsWeek(List<User> users, BloodStock z0) {
        zI.add(z0);
        // zadana funkcija gubitka minimalna

        BloodStock z1 = new BloodStock();

        for (int weekCounter = 0; weekCounter < 4; weekCounter++) {
            for (int i = 0; i <= 7; i++) {
                z1.addElement(zI.get(weekCounter).getList().get(i) + sI.get(weekCounter).getList().get(i) - p.getList().get(i));
                BloodStock newZI = corecctionBloodStock(zI.get(weekCounter));
                int lossSum = 0;
                for(int bloodType = 0; bloodType <= 7; bloodType++) {
                    lossSum += lossFunction(bloodType, newZI.getList().get(bloodType));
                }

            }
        }
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

    public BloodStock corecctionBloodStock(BloodStock z) {
        return null;
    }

}
