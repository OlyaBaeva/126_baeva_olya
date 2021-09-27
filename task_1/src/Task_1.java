public class Task_1 implements Task_1_base {
    @Override
    public int subtask_1_if(int first, int second, int third) {
        // Вычислить и вернуть минимальный из трех полученных аргументов (first, second, third)
        // ------------------------------------------------------------------------------------
        if (first < second) {
            second = first;
        }
        if (second < third) {
            third = second;
        }
        return third;
    }

    @Override
    public boolean subtask_2_if(int year) {
        // Проверить, является ли год, переданный в параметре year, високосным.
        // Високосный год - это год, кратный четырем, но не кратный 100, либо кратный 400
        // -------------------------------------------------------------------

        if (((year % 4 == 0) && (year % 100 != 0))|(year % 400 == 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        // Проверить, лежит ли точка с координатами (x, y) внутри невырожденного квадрата
        // со сторонами, параллельными осям координат, левый верхний угол которого имеет
        // координаты (left_up_x, left_up_y), ширина которого width, высота height.
        // Точка на границе считается не лежащей внутри.
        // В качестве результата вернуть:
        // 0 - не лежит
        // 1 - лежит
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double d = 0.000001;
        if ((width < d) | (height < d)) {
            return 2;
        }
        if ((x-left_up_x > d)&&(left_up_x+width-x > d)&&(y-(left_up_y-height) > d)&&(left_up_y-y >d)) return 1;
        else return 0;
    }

    @Override
    public int subtask_4_if(double x0, double y0, double k, double b) {
        // Проверить, как расположена точка с координатами (x0, y0)
        // относительно прямой y = kx + b
        // В качестве результата вернуть:
        // 0 - лежит выше прямой
        // 1 - лежит ниже прямой
        // 2 - лежит на прямой
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double d = 0.000001;
        double y = k * x0 + b;
        if (y0 - y > d) {
            return 0;
        }
        else if (y - y0 > d) {
            return 1;
        }
        else {
            return 2;
        }
    }

    @Override
    public String subtask_5_switch(int day_od_week) {
        // По номеру дня недели day_od_week вернуть его название на русском языке, записанное
        // с большой буквы. Дни едели отсчитываются с единицы. Если номер задан некорректно,
        // вернуть строку "Ошибка"
        // ------------------------------------------------------------------------------------
        switch (day_od_week) {
            case 1:
                return "Понедельник";
            break;
            case 2:
                return "Вторник";
            break;
            case 3:
                return "Среда";
            break;
            case 4:
                return "Четверг";
            break;
            case 5:
                return "Пятница";
            break;
            case 6:
                return "Суббота";
            break;
            case 7:
                return "Воскресенье";
            break;
            default:
                return "Ошибка";
            break;
        }
    }

    @Override
    public String subtask_6_switch(int direction) {
        // По заданному направлению direction вернуть его название:
        // 1 - север
        // 2 - юг
        // 3 - запад
        // 4 - восток
        // Во всех остальных случаях вернуть пустую строку
        // ------------------------------------------------------------------------------------
        switch (direction) {
            case 1:
                return "север";
            break;
            case 2:
                return "юг";
            break;
            case 3:
                return "запад";
            break;
            case 4:
                return "восток";
            break;
            default:
                return " ";
            break;
        }
    }

    @Override
    public int subtask_7_if(double vx, double vy, double vz, double speed, double time, double wall) {
        // Проверить, достигнет ли снаряд, летяший из точки (0, 0, 0)
        // в направлении (vx, vy, vz) со скоростью speed стены, параллельной плоскости OYZ,
        // имеющей координату x равной wall, за время time
        // 0 - не достигнет
        // 1 - достигнет
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double d = 0.000001;
        if (vx == 0) return 2;
        if (time - (wall/vx) > d){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int subtask_8_if(double k1, double b1, double k2, double b2) {
        // Проверить, как друг относительно друга располагаются прямые y = k1*x + b1 и
        // y = k2*x + b2. Вернуть
        // 1 - если параллельны
        // 2 - если пересекаются
        // 3 - если совпадают
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double d = 0.000001;
        if ((Math.abs(k1 - k2) < d) && (Math.abs(b1 - b2) < d)) {
            return 3;
        }
        else if ((Math.abs(k1 - k2) < d) && (Math.abs(b1 - b2) > d)) {
            return 1;
        }
        else {
            return 2;
        }
    }
}


