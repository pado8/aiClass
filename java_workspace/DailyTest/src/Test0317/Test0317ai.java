package Test0317;

import java.util.*;

class BaseBall {
    private Set<Integer> randomNumbers = new HashSet<>();
    private List<Integer> userNumbers = new ArrayList<>();
    public int strike;
    public int ball;

    void ran() {
        Random random = new Random();
        randomNumbers.clear();
        while (randomNumbers.size() < 3) {
            int num = random.nextInt(9) + 1;
            randomNumbers.add(num);
        }
        System.out.println("\n새로운 난수 생성 완료!");
    }

    boolean userNum() {
        userNumbers.clear();
        Scanner s = new Scanner(System.in);
        System.out.println("\n숫자 3개를 입력하세요. (중복 없이 입력해주세요.)");
        System.out.println("게임을 종료하려면 'exit', 새로운 게임을 시작하려면 'new'를 입력하세요.");

        while (userNumbers.size() < 3) {
            String input = s.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("게임을 종료합니다.");
                return false; // 게임 종료 신호 반환
            } else if (input.equalsIgnoreCase("new")) {
                System.out.println("새로운 게임을 시작합니다!");
                return true; // 새로운 게임 시작 신호 반환
            }

            try {
                int num = Integer.parseInt(input);
                if (num < 1 || num > 9) {
                    System.out.println("1~9 사이의 숫자를 입력하세요.");
                    continue;
                }

                if (userNumbers.contains(num)) {
                    System.out.println("이미 입력한 숫자입니다. 다시 입력하세요.");
                    continue;
                }

                userNumbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자, 'exit' 또는 'new'만 입력하세요.");
            }
        }

        System.out.println("사용자가 입력한 숫자 3개 (입력 순서 유지): " + userNumbers);
        return false; // 정상 진행
    }

    void check() {
        List<Integer> randomList = new ArrayList<>(randomNumbers);
        strike = 0;
        ball = 0;

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i).equals(userNumbers.get(i))) {
                strike++;
            }
            for (int j = 0; j < userNumbers.size(); j++) {
                if (randomList.get(i).equals(userNumbers.get(j)) && i != j) {
                    ball++;
                }
            }
        }
    }
}

public class Test0317ai {
    public static void main(String[] args) {
        BaseBall b = new BaseBall();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            b.ran(); // 새로운 난수 생성
            if (!b.userNum()) {
                break; // 'exit' 입력 시 게임 종료
            }

            while (true) {
                b.check();

                if (b.strike == 3) {
                    System.out.println("\n스트라이크 = " + b.strike);
                    System.out.println("모두 맞히셨습니다. 축하합니다!");
                    break;
                } else {
                    System.out.println("\n스트라이크 = " + b.strike);
                    System.out.println("볼 = " + b.ball);
                    System.out.println("틀렸습니다. 다시 맞혀 보세요.");
                    
                    boolean restart = b.userNum();
                    if (restart) {
                        break; // 'new' 입력 시 게임을 새로 시작
                    } else if (b.strike == 3) {
                        break;
                    }
                }
            }
        }
        System.out.println("게임이 종료되었습니다.");
        scanner.close();
    }
}
