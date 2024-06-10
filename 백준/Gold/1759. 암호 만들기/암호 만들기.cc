#include <iostream>
#include <algorithm>
using namespace std;
int l, c;
char arr[30];
char password[30];

void recursive(int start, int depth){
    if (depth == l){
        int cnt = 0; // 자음 숫자를 세는 변수
        bool flagA = false, flagB = false; // 모음과 자음의 상태를 판별하는 변수
        for(int i = 0; i < l; i++){
            if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i'
                || password[i] == 'o' || password[i] == 'u')
                flagA = true;
            else{
                cnt++;
                if (cnt >= 2) // 자음이 2개 이상일때
                    flagB = true;
            }
        }
        if (flagA && flagB){ // 두 상태를 모두 만족시킬때
            for(int i = 0; i < l ; i++){
                cout << password[i];
            }
            cout << '\n';
            return;
        }
    }

    for(int i = start; i < c; i++){
    password[depth] = arr[i];
    recursive(i + 1 , depth + 1);
    }
    
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> l >> c; // l -> 암호 자리 수 c -> 주어진 문자 개수
    for(int i = 0; i < c; i++){
        cin >> arr[i];
    }
    sort(arr, arr + c);
    recursive(0,0);
    return 0;
}