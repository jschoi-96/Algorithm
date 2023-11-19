import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> answer = new ArrayList<>();
        
        Map<String, Integer> playerMap = new HashMap<>();
        // 플레이어와 등수를 저장하는 해쉬 맵
        
        for(int i = 0; i < players.length; i++){
            playerMap.put(players[i], i);
        }
        
        for(String calling : callings) {
            int move_index = playerMap.get(calling); // 3
            int front_index = move_index - 1; // 2
            String player = players[front_index];
            
            players[front_index] = calling;
            players[move_index] = player;
            
            
            //playerMap.put(calling, front_index);
            //playerMap.put(player, move_index);
        }
        return players;
    }
}
