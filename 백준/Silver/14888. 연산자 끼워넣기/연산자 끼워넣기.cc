#include <iostream>
using namespace std;
int n;
int arr[13];
int operators[4];
int max_num = -1000000001;
int min_num = 1000000001;

void calculate(int result, int idx){
    if (idx == n){
        if (result > max_num) max_num = result;
        if (result < min_num) min_num = result;
        return;
    }
    for(int i = 0; i < 4; i++){
        if (operators[i] > 0){ // 횟수 체크
            operators[i]--;
            if (i == 0) calculate(result + arr[idx] , idx + 1); // plus
            else if (i == 1) calculate(result - arr[idx] , idx + 1); // minus
            else if (i == 2) calculate(result * arr[idx] , idx + 1); // mul
            else calculate(result / arr[idx] , idx + 1); // div
            operators[i]++;
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++) cin >> arr[i];
    for(int i = 0; i < 4; i++) cin >> operators[i];
    calculate(arr[0] , 1); // 1부터 시작해야하는 이유 -> arr의 두번째 인덱스부터 연산해야 하므로
    cout << max_num << '\n' << min_num;
    return 0;
}