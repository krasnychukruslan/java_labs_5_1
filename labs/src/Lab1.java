import java.util.ArrayList;
import java.util.List;

public class Lab1 {

    private static float average(List<String> array){
        float sum = 0;
        for (String item: array ){
            sum += item.length();
        }
        return sum/array.size();
    }

    public static List findLessAverage(List<String> array){
        float average = Lab1.average(array);

        ArrayList result = new ArrayList();
        for(String item: array){
            if (item.length() < average){
                System.out.println(item);
                result.add(item);
            }
        }
        return result;
    }
}
