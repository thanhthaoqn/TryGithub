import java.util.Scanner;

public class _13_bt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon: ");
        int so = sc.nextInt();
        switch (so){
            case 1:
                System.out.println("Tim ten");
                break;
             case 2:
                System.out.println("Tim tac gia");
                break;
             case 3:
                System.out.println("Tim nha xuat ban");
                break;
             case 4:
                System.out.println("Tim tieu de");
                break;
            default:
                System.out.println("Phim bam khong hop le");
                break;
        }
    }
    
}
