public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int r = 0;
        int n3 = 0;
         if ( n1 > n2) {
             n3 = n1;
             n1=n2;
             n2=n3;
         }
        for ( int n = n1; n <= n2; n++) {
            if ((n%a==0) && ( n%b != 0))  r++;
        }
        return r;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int a = num;
        if ( a == 1) return 1;
        int r = 1;
        for (int i = 2; i <=num; i++) {
            for (int j = 1;j <=i;j++) {
                r+=1;
                if ( r==num) return i;
            }
        }
        return num;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int s = 0;
        int a = num;
        for ( int i=1; i<=cnt; i++){
            s=s+a;
            a=a*d+1;
        }
        return s;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int s = 1;
        if  (n == 1) return 1;
        for ( int t= 2; t<=n; t++) {
            int y = 1;
            for (int d = 2; d <= t; d++) y = y * d;
            s = s + y;
        }
        return s;
    }
}
