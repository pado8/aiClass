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
	public int strike;
	public int ball;

	void ran() {
		Random random = new Random();
		randomNumbers.clear();
		while (randomNumbers.size() < 3) {
			int num = random.nextInt(9) + 1;
			randomNumbers.add(num);
		}

		System.out.println("중복 없는 난수 3개: " + randomNumbers);
	}

	void userNum() {
		userNumbers.clear();
		Scanner s = new Scanner(System.in);
		System.out.println("숫자 3개를 입력하세요. (중복 없이 입력해주세요.)");

		while (userNumbers.size() < 3) {
			int num = s.nextInt();

			if (num < 1 || num > 9) {
				System.out.println("1~9 사이의 숫자를 입력하세요.");
				continue;
			}

			if (userNumbers.contains(num)) {
				System.out.println("이미 입력한 숫자입니다. 다시 입력하세요.");
				continue;
			}

			userNumbers.add(num);
		}

		System.out.println("사용자가 입력한 숫자 3개 (입력 순서 유지): " + userNumbers);
	}

	void check() {
		List<Integer> randomList = new ArrayList<>(randomNumbers);
		strike = 0;
		ball = 0;
		for (int i = 0; i < randomList.size(); i++) {
			if (randomList.get(i) == userNumbers.get(i)) {
				strike++;
			}
			for (int j = 0; j < userNumbers.size(); j++) {

				if (randomList.get(i) == userNumbers.get(j)) {
					ball++;
				}
			}
		}
	}
}

public class Test0317 {

	public static void main(String[] args) {
		BaseBall b = new BaseBall();

		b.ran();
		b.userNum();
		b.check();
		for (;;) {
			if (b.strike == 3) {
				System.out.println("스트라이크 = " + b.strike);
				System.out.println("모두 맞히셨습니다. 축하합니다!");
				break;
			} else {
				System.out.println("스트라이크 = " + b.strike);
				System.out.println("볼 = " + (b.ball - b.strike));
				System.out.println("틀렸습니다. 다시 맞혀 보세요.");
				b.userNum();
				b.check();
			}
		}
	}

}
