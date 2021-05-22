import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 0-1 knapsack
//  - 배낭에 물건을 통째로 담아야 하는 문제
//  - 물건을 쪼갤 수 없는 경우임
//  - 탐욕적 알고리즘으로 최적해를 구할 수 없음 / 완전 검색을 사용해야 함
// Fractional Knapsack
//  - 물건을 부분적으로 담는 것이 허용됨
//  - 물건을 쪼갤 수 있는 경우
//  - 물건이 쪼개어진 만큼 가치도 나뉘어짐

class Bag implements Comparable<Bag> {
    int weight;
    int value;

    Bag(int _weight, int _value) {
        this.weight = _weight;
        this.value = _value;
    }

    @Override
    public int compareTo(Bag b) {
        // TODO Auto-generated method stub
        int v1 = this.value / this.weight;
        int v2 = b.value / b.weight;
        if (v1 > v2) {
            return 1;
        } else if (v1 < v2)
            return -1;
        else
            return 0;
    }
}

public class Knapsak {
    public static void main(String args[]) {
        Bag bag[] = new Bag[3];
        bag[0] = new Bag(5,50);
        bag[1] = new Bag(20,140);
        bag[2] = new Bag(10,60);
        Arrays.sort(bag);
        func(bag);
    }

    static void func(Bag bag[]) {
        int total = 0;
        int weight = 30;
        while (weight > 0) {
            int max = 0;
            for (int i = 0; i < bag.length; i++) {
                if ((bag[max].value / bag[max].weight) < (bag[i].value / bag[i].weight)) {
                    max = i;
                }
            }
            if (weight > bag[max].weight) {
                weight -= bag[max].weight;
                total += bag[max].value;
            } else {
                total += (bag[max].value / bag[max].weight) * weight;
                weight = 0;
            }
            bag[max].weight = -1;
        }
        System.out.println(total);
    }
}