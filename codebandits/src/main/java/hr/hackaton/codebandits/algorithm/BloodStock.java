package hr.hackaton.codebandits.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BloodStock {

    private List<Integer> list;

    public BloodStock(int o_minus, int o_plus, int a_minus, int a_plus, int b_minus, int b_plus, int AB_minus, int AB_plus) {
        list = new ArrayList<>();
        list.add(o_minus);
        list.add(o_plus);
        list.add(a_minus);
        list.add(a_plus);
        list.add(b_minus);
        list.add(b_plus);
        list.add(AB_minus);
        list.add(AB_plus);
    }

    public BloodStock() {
        list = new ArrayList<>();
    }

    public List<Integer> getList() {
        return list;
    }

    public void addElement(int element) {
        list.add(element);
    }


}
