public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int type[];
        type = new int[size];
        type[0] = a0;
        for (int i = 1; i < size; i++) {
            type[i] = type[i - 1] + d;
        }
        return type;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int type[];
        type = new int[size];
        type[0] = 1;
        if (size==1) return type;
        type[1] = 1;
        if (size == 2) return type;
        int S = 2;
        for (int i = 2; i < size; i++) {
            type[i] = S;
            S = S + type[i];
        }
        return type;

    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int type[];
        type = new int[size];
        type[0] = 0;
        if (size==1) return type;
        type[1] = 1;
        if (size ==2) return type;
        for (int i = 2; i < size; i++) {
            type[i] = type[i - 1] + type[i - 2];
        }
        return type;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int m = data[0];
        if (data.length==1) return m;
        for (int i = 1; i < data.length; i++) {
            if (m < data[i]) m = data[i];
        }
        return m;
    }


    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int m = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] % k == 0) m = data[i];
        }
        for (int i = 0; i < data.length; i++) {
            if ((data[i] % k == 0) && (m < data[i])) m = data[i];
        }
        return m;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        int type[];
        int t;
        type = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            type[i] = arr1[i];
        }
        for (int i = arr1.length ; i < arr1.length + arr2.length; i++) {
            type[i] = arr2[i-arr1.length];
        }
        for (int i = 0; i < type.length; i++) {
            for (int j = i + 1; j < type.length; j++) {
                if (type[j] < type[i]) {
                    t = type[i];
                    type[i] = type[j];
                    type[j] = t;
                }
            }
        }
        return type;
    }


    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        int type[];
        type = new int[arr1.length + arr2.length];
        int j = 0;
        int k = 0;
        int t = 0;
        if (arr1.length==0) return arr2;
        if (arr2.length==0) return arr1;
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (k >= arr1.length) {
                type[i] = arr2[j];
                j += 1;
                continue;
            }
            if (j >= arr2.length) {
                type[i] = arr1[k];
                k += 1;
                continue;
            }
            if (arr1[k] > arr2[j]) {
                type[i] = arr2[j];
                j += 1;
            } else {
                type[i] = arr1[k];
                k += 1;
            }
        }
        return type;
    }
}

