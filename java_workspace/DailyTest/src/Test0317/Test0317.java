package Test0317;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class BaseBall {
    private Set<Integer> randomNumbers = new HashSet<>();
    private List<Integer> userNumbers = new ArrayList<>();
    private int strike;
    private int ball;

    public void ran() {
        randomNumbers.clear();
        Random random = new Random();
        while (randomNumbers.size() < 3) {
            int num = random.nextInt(9) + 1;
            randomNumbers.add(num);
        }
        // System.out.println("중복 없는 난수 3개 (정답) : " + randomNumbers);
    }

    public void setUserNumbers(List<Integer> numbers) {
        userNumbers = numbers;
    }

    public void check() {
        List<Integer> randomList = new ArrayList<>(randomNumbers);
        strike = 0;
        ball = 0;
        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i).equals(userNumbers.get(i))) {
                strike++;
            }
            for (int j = 0; j < userNumbers.size(); j++) {
                if (randomList.get(i).equals(userNumbers.get(j))) {
                    ball++;
                }
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

public class Test0317 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            BaseBall b = new BaseBall();
            b.ran();

            while (true) {
                System.out.println("숫자 3개를 입력하세요. 예시: 1,2,3 또는 1 2 3 (중복 없이 입력해주세요.)");
                System.out.println("게임 종료: exit, 새로운 게임 시작: new");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("게임을 종료합니다.");
                    scanner.close();
                    return;
                }
                if (input.equalsIgnoreCase("new")) {
                    System.out.println("새로운 게임을 시작합니다.");
                    break;
                }

                String[] tokens = input.split("[,\\s]+");
                if (tokens.length != 3) {
                    System.out.println("숫자 3개를 정확히 입력해주세요. 예시: 1,2,3 또는 1 2 3");
                    continue;
                }

                List<Integer> userNums = new ArrayList<>();
                boolean valid = true;
                for (String token : tokens) {
                    try {
                        int num = Integer.parseInt(token);
                        if (num < 1 || num > 9) {
                            System.out.println("1~9 사이의 숫자를 입력하세요.");
                            valid = false;
                            break;
                        }
                        if (userNums.contains(num)) {
                            System.out.println("중복된 숫자는 입력할 수 없습니다.");
                            valid = false;
                            break;
                        }
                        userNums.add(num);
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해주세요. 예시: 1,2,3 또는 1 2 3");
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    continue;
                }

                b.setUserNumbers(userNums);
                b.check();

                if (b.getStrike() == 3) {
                    System.out.println("스트라이크 = " + b.getStrike());
                    System.out.println("모두 맞히셨습니다. 축하합니다!");
                    break;
                } else {
                    System.out.println("스트라이크 = " + b.getStrike());
                    System.out.println("볼 = " + (b.getBall() - b.getStrike()));
                    System.out.println("틀렸습니다. 다시 맞혀 보세요.");
                }
            }

            System.out.println("새 게임을 시작하려면 new, 종료하려면 exit를 입력하세요.");
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (command.equalsIgnoreCase("new")) {
                System.out.println("새로운 게임을 시작합니다.");
                continue;
            } else {
                System.out.println("알 수 없는 명령어입니다. 게임을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}
