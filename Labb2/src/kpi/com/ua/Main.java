package kpi.com.ua;

public class Main {
    public static int findPrimeNum(int N){
        Lab2 lab2 = new Lab2();
        int i =0;
        int num =0;
        //Empty String
        String  primeNumbers = "";

        for (i = 1; i <= N; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }

            }
            if (counter ==2)
            {
                //Appended the Prime number to the String
                String t = Integer.toBinaryString(i);
                int occurance =  t.length() - t.replace("1","").length();

                if(lab2.getBinary1Length() <= occurance){
                    lab2.setBinary1Length(occurance);
                    lab2.setNumber(i);
                }
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to " + N + " are :");
        System.out.println(primeNumbers);
        System.out.println(Integer.toString(lab2.getNumber()));
//        System.out.println(lab2.getBinary1Length());
//        System.out.print(": " + Integer.toBinaryString(lab2.getNumber()));
        return lab2.getNumber();


    }

    public static void main(String[] args) {
	// write your code here
    }
}
