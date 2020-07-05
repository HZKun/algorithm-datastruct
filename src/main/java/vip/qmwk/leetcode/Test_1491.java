package vip.qmwk.leetcode;

public class Test_1491
{


    public static void main(String[] args) {
        int[] salary  = {1000,2000,3000};
        System.out.println(average(salary ));
    }

    public static double average(int[] salary) {
        if(salary == null || salary.length <= 2){
            return 0;
        }

        int max = salary[0], min = salary[0];
        int sum = 0;
        for (int i =  0; i < salary.length; i++) {
            sum += salary[i];
            if(max < salary[i]){
                max = salary[i];
            }
            if(min > salary[i]){
                min = salary[i];
            }
        }
        return (sum - max - min) / (salary.length - 2d);
    }
}
