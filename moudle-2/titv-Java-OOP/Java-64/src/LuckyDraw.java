import java.util.HashSet;
import java.util.Set;

public class LuckyDraw {
    Set<String> ballotBox = new HashSet<String>();

    public LuckyDraw() {
    }

    public boolean addVote(String value) {
        return ballotBox.add(value);
    }
    public  boolean removeVote(String value) {
        return  ballotBox.remove(value );
    }

    public boolean checkVoteExists(String value){
        return  ballotBox.contains(value)  ;
    }

    public void remoteAllVote() {
         this.ballotBox.clear();
    }

    public  int getQuantity(){
        return  ballotBox.size();
    }



    int choice = 0;
    do{
        System.out.println("----------------------------------");
        System.out.println("MENU: ");
        System.out.println("1. Thêm mã số dự thưởng");
        System.out.println("2. Xóa mã số dự thưởng");
        System.out.println("3. Kiểm tra mã số dự thưởng có tồn tại không");
        System.out.println("4. Xóa tất cả các phiếu dự thưởng");
        System.out.println("5. Số lượng  phiêu dự thưởng");
        System.out.println("6. Rút thăm trúng thưởng");
        System.out.println("0. Thoát khỏi chương trình");

    } while(choice!=0);
}
