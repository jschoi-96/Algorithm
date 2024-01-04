접근 방법
1. 시간만큼 loop을 돌면서, 특정 시간일 때 조건을 체크한다.
2. 공격 받는 시간이 아닐 때는, 초당 회복량만큼 회복을 하며 최대 체력을 넘을 수 없다.
3. t초 연속으로 회복을 하는데 성공하면, 추가 회복을 한다.

문제에서 놓쳤던 부분은, 최대 체력을 넘을 때 continue를 해서 그냥 건너뛰어 줬는데,
그렇게 하면 안되고 그런 경우에 최대 체력으로 재설정 해주니 문제가 해결됐다

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int len = attacks.length - 1;
        int time = attacks[len][0];
        int attack_idx = 0;
        
        int check = 0; // 연속으로 t초 이상 회복할 때 체크하는 변수
        int temp_health = health;
        
        for(int i = 0; i <= time; i++){
            if (i == attacks[attack_idx][0]) { // 몬스터 공격 시간일 때
                temp_health -= attacks[attack_idx][1]; // 피해량만큼 빼줌
                attack_idx++;
                check = 0; // 공격을 받으면 연속시간 초기화 
            }
            
            else {
               if (temp_health + bandage[1] > health) {
                   temp_health = health;
               }
                
               else {
                   temp_health += bandage[1];
                   check++;
                   if (check == bandage[0]) {
                       temp_health += bandage[2];
                       check = 0; // 연속 시간 초기화
                   }
               }
               
            }
            //System.out.println("i: " + i + " health: " + temp_health);
            if (temp_health <= 0) return -1;
        }
        return temp_health;
    }
}
