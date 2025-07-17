import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken()); // 유저 정보 개수
        int f = Integer.parseInt(st.nextToken());

        Map<String, List<String>> userMap = new HashMap<>();
        for (int i = 0; i < u; i++) {
            String userInfo = br.readLine();
            String userName;
            List<String> groups = new ArrayList<>();

            // 유저명 파싱 로직 (이 부분은 사용자 이름 해석에 따라 다르게 동작)
            int firstDelimiterIndex = -1;
            int spaceIndex = userInfo.indexOf(" ");
            int commaIndex = userInfo.indexOf(",");

            if (spaceIndex != -1 && (commaIndex == -1 || spaceIndex < commaIndex)) {
                firstDelimiterIndex = spaceIndex;
            } else if (commaIndex != -1) {
                firstDelimiterIndex = commaIndex;
            }

            if (firstDelimiterIndex != -1) {
                userName = userInfo.substring(0, firstDelimiterIndex);
                String remainingInfo = userInfo.substring(firstDelimiterIndex + 1).trim();

                if (!remainingInfo.isEmpty()) {
                    String[] groupParts = remainingInfo.split(",");
                    for (String group : groupParts) {
                        groups.add(group.trim());
                    }
                }
            } else {
                userName = userInfo.trim();
            }

            groups.add(0, userName); // 사용자 자신의 이름을 항상 그룹에 추가 (맨 앞에)
            userMap.put(userName, groups);
        }

        Map<String, List<String>> fileMap = new HashMap<>();
        for(int i = 0; i < f; i++) {
            String fileLine = br.readLine();
            st = new StringTokenizer(fileLine);
            String file = st.nextToken();
            String permission = st.nextToken();
            String owner = st.nextToken();
            String ownerGroup = st.nextToken();

            List<String> fileList = new ArrayList<>();
            fileList.add(owner);
            fileList.add(ownerGroup);
            fileList.add(getPermission(permission.charAt(0)));
            fileList.add(getPermission(permission.charAt(1)));
            fileList.add(getPermission(permission.charAt(2)));
            fileMap.put(file, fileList);
        }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");

            String user = parts[0];
            String file = parts[1];
            String task = parts[2];

            List<String> fileInfos = fileMap.get(file);
            if (fileInfos == null) { // 파일이 존재하지 않는 경우
                System.out.println(0);
                continue;
            }

            String owner = fileInfos.get(0);
            String ownerGroup = fileInfos.get(1);
            String ownerPerm = fileInfos.get(2);
            String groupPerm = fileInfos.get(3);
            String otherPerm = fileInfos.get(4);

            String userPermission = "";

            List<String> userGroups = userMap.get(user); // 쿼리하는 유저의 그룹 리스트를 가져옴

            if (user.equals(owner)) { // 1. 쿼리 유저가 파일의 소유자인 경우
                userPermission = ownerPerm;
            } else if (userGroups != null && userGroups.contains(ownerGroup)) { // 2. 쿼리 유저가 소유 그룹에 속한 경우 (null 체크 필수)
                userPermission = groupPerm;
            } else { // 3. 그 외 (기타 사용자)
                userPermission = otherPerm;
            }

            if (userPermission.contains(task)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    public static String getPermission(char c) {
        if (c == '0') return ".";
        else if (c == '1') return "X";
        else if (c == '2') return "W";
        else if (c == '3') return "XW";
        else if (c == '4') return "R";
        else if (c == '5') return "RX";
        else if (c == '6') return "RW";
        else return "RWX";
    }
}