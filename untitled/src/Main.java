import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 10;
        int counter = 0;
        String islemler = "1:Kuyruk Oluştur\n2:Kuyrugu yazdir\n3:Kuyrugu temizle";
        boolean bitsinMi = false;
        ZiyaretciKuyrugu ziyaretciKuyrugu = new ZiyaretciKuyrugu();
        while (bitsinMi==false){
            System.out.println(islemler);
            System.out.print("Bir islem sayisi girin: ");
            Scanner scanner = new Scanner(System.in);
            int secenek = scanner.nextInt();
            switch (secenek){
                case 1:
                    while (counter<N){
                        System.out.print("Lutfen isminizi giriniz: ");
                        Scanner scanner1 = new Scanner(System.in);
                        String ziyaretci = scanner1.nextLine();
                        if (ziyaretciKuyrugu.checkNames(ziyaretci)){
                            ziyaretciKuyrugu.enequeue(ziyaretci);
                            counter++;
                        }else System.out.println("Girdiginiz isimde bir ziyaretci zaten var. Baska isim girin.");
                    }
                    break;
                case 2:
                    ziyaretciKuyrugu.writedownVisitors();
                    break;
                case 3:
                    if (ziyaretciKuyrugu.front==null){
                        System.out.println("WARNING!There is no one to remove.");
                        break;
                    }
                    counter=10;
                    while (counter>0){
                        ziyaretciKuyrugu.dequeue();
                        counter--;
                    }
                    bitsinMi=true;
                    break;
            }
        }

    }

}