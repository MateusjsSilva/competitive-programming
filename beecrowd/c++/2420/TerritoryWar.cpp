#include <stdio.h>

int main() 
{
    int N;
    scanf("%d", &N);

    int sections[N];
    int total_sum = 0;
    
    for (int i = 0; i < N; i++) {
        scanf("%d", &sections[i]);
        total_sum += sections[i];
    }

    if (total_sum % 2 != 0) {
        return 1;
    }

    int half_sum = total_sum / 2;
    int current_sum = 0;

    for (int k = 0; k < N; k++) {
        current_sum += sections[k];
        if (current_sum == half_sum) {
            printf("%d\n", k + 1);
            return 0;
        }
    }

    return 1;
}