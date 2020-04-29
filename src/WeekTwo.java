import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class WeekTwo {
    static Random randomNum = new Random();

    static String []rice = {"white","brown","none","all"};
    static String [] meat ={ "chicken", "steak", "carnidas", "chorizo", "sofritas", "veggie meat", "none", "all"};
    static String[]beans = {"pinto", "black", "none", "all"};
    static String[]salsa = {"mild", "medium", "hot", "none", "all"};
    static String[]veggies = {"lettuce", "fajita veggies", "none", "all"};

    static String[]additionals = {"cheese","fuac","queso","sour"};

    //Create empty list for 25 burritos
    static List<String> tempBurritos= new ArrayList<String>();
    static Hashtable<String, List<String>> Burritos = new Hashtable<String, List<String>>();


    public static void main(String[] args) {
        //Assemble 25 burritos.
        for(int i=1;i<=25;i++){
            int count = generate_ingredients();

            tempBurritos.add(select_ingredients (rice));
            tempBurritos.add(select_ingredients (meat));
            tempBurritos.add(select_ingredients (beans));
            tempBurritos.add(select_ingredients (salsa));
            tempBurritos.add(select_ingredients (veggies));

            if(count>5){
                int tempArraySize = 9 - count+5;
                for(int j = 0; j<tempArraySize;j++){
                    String  tempIngradient = select_ingredients (additionals);
                    if(tempBurritos.contains(tempIngradient)){
                        tempBurritos.add(tempIngradient);
                    }
                    else{
                        j--;
                    }
                }
            }
            Burritos.put("Burrito "+i, tempBurritos);
        }

        System.out.println(Burritos.get("Burrito 1").get(0));
    }
    static int generate_ingredients(){
        int max=9; int min=5;
        return min + randomNum.nextInt(max);
    }

    static String  select_ingredients (String[]ingradient)
    {
        int max=ingradient.length; int min=0;
        int selected_ingradient_index =  min + randomNum.nextInt(max);
        return ingradient[selected_ingradient_index];
    }
}
