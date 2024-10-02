import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> listStudent = new LinkedList<String>();
        listStudent.offer("Dong");
        listStudent.offer("Long");
        listStudent.offer("Tuan");
        listStudent.offer("Khang");

        while ((true)){
            String name = listStudent.poll(); // lấy ra mà xóa. peek thì lấy ra nhung không xóa
            if(name ==null){
                break;
            }
            System.out.println(name);
        }
    }
}
