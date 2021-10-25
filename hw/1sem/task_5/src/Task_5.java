import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> type= new ArrayList<Integer>();
        if (data.size() == 0) return type;
        for (int i=0;i < data.size();i++){
            int r=data.get(i);
          if ((data.get(i)%k==0)&&(data.get(i)%n!=0)) {
              type.add(r);
              //System.out.println(" k = "+k+" n = "+ n+ " r = "+r);
          }
        }
        return type;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        int a = size;
        ArrayList<Integer> type= new ArrayList<Integer>();
        int r = 1;
        type.add(r);
        if (a==1) return type;
        for ( int i =2;i<=size;i++){
            for (int j =1;j<=i;j++){
                r+=1;
                type.add(i);
                if (r==size) return type;
            }

        }
        return type;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
       HashSet<Integer> type = new HashSet<Integer>();
       for (int i:s1)
           for (int j:s2){
               if (i==j) type.add(i);
           }
       return type;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        HashSet<Integer> type = new HashSet<Integer>();
        for (int i:s1) type.add(i);
        for (int i:s2) type.add(i);
        return type;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> type= new HashSet<Integer>();
            for (int j:s2){
                if (!s1.contains(j)) type.add(j);
            }
        return type;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> type = new HashSet<Integer>();
        for (int i:s1) if (!s2.contains(i)) type.add(i);
        for (int j:s2) if (!s1.contains(j)) type.add(j);
        return type;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String,Double> type = new HashMap<>();
        double r;
        for (int i =0;i < data.size();i++) {
            r = 0;
            for(int j=0;j< data.size(); j++) {
                if (data.get(i) == data.get(j)) r++;
            }
            type.put(data.get(i), r/data.size()*100);
        }
        return type;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String,Double> type = new HashMap<>();
        double min1,max1,mean1;
        min1=data.get(0);
        max1=data.get(0);
        mean1=0;
        for (int i=0;i<data.size();i++){
            if (min1>data.get(i)) min1=data.get(i);
            if (max1<data.get(i)) max1=data.get(i);
            mean1+=data.get(i);
        }
        mean1=mean1/data.size();
        type.put("mean",mean1);
        type.put("max",max1);
        type.put("min",min1);
        return type;
    }
}
