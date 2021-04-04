public class Prime100 {
    public static void main(String[] args) {

        System.out.println("-----100~200-----");
        int num = 0;

        Outer:for(int i = 3; i < 100; i++){
            for(int j = 2; j < i; j++){
                if(i % j == 0) continue Outer;
            }

            System.out.print(i + " ");
            num++;
            if(num < 10){
                continue;
            }
            System.out.println();

            num = 0;
        }
    }
}
