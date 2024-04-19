#include <iostream>
using namespace std;
int n;
string board[66];

void recursive(int y, int x, int n){
    if (n == 1) {
        cout << board[y][x];
        return;
    }
    
    bool zero = true, one = true;
    for(int i = y; i < y + n; i++){
        for(int j = x; j < x + n; j++){
            if (board[i][j] == '0')
                one = false;
            else 
                zero = false;
        }
    }

    if (zero){
        cout << '0';
        return;
    }

    else if (one){
        cout << '1';
        return;
    }

    else{
        cout << "(";
        recursive(y, x, n/2);
        recursive(y , x + n/2 , n/2);
        recursive(y + n/2 , x , n/2);
        recursive(y + n/2, x + n/2, n/2);
        cout << ")";
    }
}

int main(){
    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> board[i];

    recursive(0, 0, n);
}
