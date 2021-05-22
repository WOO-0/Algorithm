import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 회의실 배정 문제 - 동시에 회의가 열릴 수 있도록 최대한 많은 활동을 선택하는 문제
// 

class Meeting implements Comparable<Meeting> {
    int st;
    int ft;

    Meeting(int _st, int _ft) {
        this.st = _st;
        this.ft = _ft;
    }

    @Override
    public int compareTo(Meeting o) {
        // TODO Auto-generated method stub
        int v1 = this.ft;
        int v2 = o.ft;
        if (v1 > v2) {
            return 1;
        } else if (v1 < v2)
            return -1;
        else
            return 0;
    }

}

public class MeetingRoom {
    public static void main(String args[]) {
        List<Meeting> M = new ArrayList<Meeting>();
        M.add(new Meeting(0, 0));
        M.add(new Meeting(1, 4));
        M.add(new Meeting(3, 5));
        M.add(new Meeting(1, 6));
        M.add(new Meeting(5, 7));
        M.add(new Meeting(3, 8));
        M.add(new Meeting(5, 9));
        M.add(new Meeting(6, 10));
        M.add(new Meeting(8, 11));
        M.add(new Meeting(2, 13));
        M.add(new Meeting(12, 14));

        greedy(M);
    }

    // 탐욕 기법을 적용한 반복 알고리즘
    static void greedy(List<Meeting> M) {
        // A: 활동들의 집합
        // S: 선택된 활동(회의)들의 집합
        // si: 시작시간, fi: 종료시간
        Collections.sort(M);
        Meeting S = M.get(1);
        for (int i = 1; i < M.size(); i++) {
            System.out.println(M.get(i).ft);
            S = M.get(i);
            for (int j = i + 1; j < M.size(); j++) {
                if (S.ft >= M.get(j).st) {
                    M.remove(j);
                    j -= 1;
                }
            }
        }
    }
}