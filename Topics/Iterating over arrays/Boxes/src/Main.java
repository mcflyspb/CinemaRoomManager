import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String output = "Incompatible";
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int z1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        int z2 = input.nextInt();

        List<Integer> box1 = new ArrayList<>();
        box1.add(x1);
        box1.add(y1);
        box1.add(z1);

        List<Integer> box2 = new ArrayList<>();
        box2.add(x2);
        box2.add(y2);
        box2.add(z2);

        Collections.sort(box1);
        Collections.sort(box2);

        if (box1.get(0) < box2.get(0) && box1.get(1) < box2.get(1) && box1.get(2) < box2.get(2)) {
            output = "Box 1 < Box 2";
        }
        if (box1.get(0) > box2.get(0) && box1.get(1) > box2.get(1) && box1.get(2) > box2.get(2)) {
            output = "Box 1 > Box 2";
        }
        System.out.println(output);
    }
}