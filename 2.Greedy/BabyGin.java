// 완전 검색이 아닌 방법으로 Baby-Gin 문제 풀기
// 6개의 숫자를 6자리 정수값으로 입력되며 카운트 배열에 저장됨 -> count 배열: 0~9 까지의 숫자의 빈도수를 저장하는 배열
// - Counts 배열의 각 원소를 체크하여 run과 triplet 및 baby-gin 여부 판단
// - run과 triplet 중 가능한 것 조사 -> 조사에 사용한 데이터 삭제 -> run과 triplet 중 가능한 것 조사
public class BabyGin {
    public static void main(String args[]) {
        String input = "345345";
        int arr[] = new int[10];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - '0']++;
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1)
                cnt += 1;
            else
                cnt = 0;

            if (cnt == 3) {
                cnt = 0;
                for (int j = i; j > i - 3; j--) {
                    arr[j]--;
                }
                i -= 3;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 3) {
                arr[i] -= 3;
                i -= 1;
            }
        }

        boolean chk = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                break;
        }
        if (chk)
            System.out.println("Baby Gin 입니다.");
        else
            System.out.println("Baby Gin이 아닙니다.");
    }
}