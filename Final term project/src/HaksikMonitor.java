import java.util.*;

class Menu {
    String name;
    int totalQuantity;
    int remainingQuantity;

    public Menu(String name, int totalQuantity) {
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.remainingQuantity = totalQuantity;
    }

    public void decreaseQuantity(String source) {
        if (remainingQuantity > 0) {
            remainingQuantity--;
            System.out.println("[" + source + "] " + name + " 수량 1개 차감됨. (남은 수량: " + remainingQuantity + ")");
        } else {
            System.out.println("⚠ " + name + " 품절입니다!");
        }
    }

    @Override
    public String toString() {
        return name + " - 남은 수량: " + remainingQuantity + "/" + totalQuantity;
    }
}

public class HaksikMonitor {
    static Map<Integer, Menu> menuMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static int menuId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 학식 수량 모니터링 시스템 ===");
            System.out.println("1. 메뉴 등록");
            System.out.println("2. 메뉴 보기");
            System.out.println("3. 학식 수령(수량 차감)");
            System.out.println("4. 종료");
            System.out.print("선택 > ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerMenu();
                case 2 -> showMenus();
                case 3 -> consumeMenu();
                case 4 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void registerMenu() {
        System.out.print("메뉴 이름 입력: ");
        String name = scanner.nextLine();
        System.out.print("총 수량 입력: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        menuMap.put(menuId, new Menu(name, qty));
        System.out.println("✅ 메뉴 등록 완료 (ID: " + menuId + ")");
        menuId++;
    }

    private static void showMenus() {
        System.out.println("\n📋 등록된 메뉴:");
        if (menuMap.isEmpty()) {
            System.out.println("없음");
            return;
        }
        for (var entry : menuMap.entrySet()) {
            System.out.println("ID " + entry.getKey() + " → " + entry.getValue());
        }
    }

    private static void consumeMenu() {
        showMenus();
        System.out.print("수령할 메뉴 ID 입력: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("수단 입력 (식권기/밀케어): ");
        String source = scanner.nextLine();

        Menu menu = menuMap.get(id);
        if (menu != null) {
            menu.decreaseQuantity(source);
        } else {
            System.out.println("해당 ID의 메뉴가 없습니다.");
        }
    }
}
