package vn.com.ino.pikawar.roundfinal;

import java.util.Arrays;

/**
 * @author HieuNH5
 *
 *         Năm 2050, Việt Nam thành công đưa rô bốt lên thám hiểm sao Hỏa
 * 
 *         Nhiệm vụ của robot là cắm cờ vào 1 mục tiêu xác định trên sao Hỏa
 * 
 *         Bề mặt sao Hỏa lồi lõm, mấp mô ko đều, có nhiều hố sâu. Robot ko được
 *         đi vào các hố sâu, mỗi lần di chuyển từ vùng đất thấp lên vùng đất
 *         cao rô bốt tốn gấp đôi năng lượng so với di chuyển từ vùng đất cao
 *         xuống vùng đất thấp
 * 
 *         Giả sử rô bốt di chuyển từ vùng đất có độ cao X đến vùng đất có độ
 *         cao Y, sẽ tốn (X-Y) năng lượng nếu X>=Y, và tốn 2*(Y-X) năng lượng
 *         nếu X<Y
 * 
 *         Bề mặt sao Hỏa được thể hiện bằng một ma trận hình chữ nhật. Mỗi ô
 *         trong ma trận chứa 1 số nguyên thể hiện độ cao của vùng đất, bằng -1
 *         nếu là hố sâu và rô bôt không thể di chuyển vào. Cho trước vị trí
 *         xuất phát và vị trí kết thúc của rô bốt, hãy tính toán số năng lượng
 *         tối thiểu mà rô bốt cần sử dụng để đến được đích. Biết rằng rô bốt
 *         chỉ có thể di chuyển ngang hoặc dọc, ko thể di chuyển chéo (ví dụ từ
 *         ô (0, 0) thì chỉ có thể sang ô (0,1) và (1, 0), ko thể đến đc ô
 *         (1,1))
 * 
 *         Ví dụ: robot cần đi từ điểm (0, 0) tới điểm (2,2) trong 1 bản đồ như
 *         hình dưới đây:
 * 
 * 
 * 
 *         thì rô bốt cần đi từ (0, 0) -> (1, 0) (tốn năng lượng là (4-3)*2=2);
 *         từ (1, 0) -> (2, 0) (tốn năng lượng là 4-2=2), từ (2,0) -> (2, 1)
 *         (tốn năng lượng là (5-2)*2=6), từ (2,0)->(2,1) (tốn năng lượng là
 *         5-4=1)
 * 
 *         Tổng năng lượng mà rô bốt sử dụng là: 2 + 2 + 6 + 1 = 11
 * 
 *         Input/output:
 * 
 *         Input:
 * 
 *         ma trận 2 chiều chứa số nguyên. Kích thước mỗi chiều ma trận nhỏ hơn
 *         100 2 mảng mỗi mảng chứa 2 số nguyên thể hiện tọa độ xuất phát và kết
 *         thúc của robot (chỉ số trong ma trận được đếm từ 0). Đảm bảo ô xuất
 *         phát và ô đích không phải là hố sâu Output:
 * 
 *         Số nguyên thể hiện năng lượng ít nhất mà rô bốt sử dụng để đến đc
 *         đích Trường hợp không đến được đích, giá trị trả về sẽ là -1
 *
 */
public class ProblemE {

	int robotPath(int[][] marsMap, int[] startPoint, int[] endPoint) {
		int[] x = { -1, 0, 1, 0 };
		int[] y = { 0, -1, 0, 1 };
		int x_length = marsMap.length;
		int y_length = marsMap[0].length;

		// Ý tưởng: Từ vị trí bắt đầu loang rộng vừa tạo ma trận vừa tạo
		// dijikstra ở điểm đó

		// khởi tạo tất cả các đỉnh chưa gán nhãn,fmin = MaxInt,
		// fmin[startPoint] = 0
		// start dijikstra
		// tìm đỉnh chưa gán nhãn có fmin nhỏ nhất
		// nếu u = null kết thúc dijikstra
		// gán nhãn u
		// với mỗi đỉnh v kề u có marsMap[v] != -1, tính năng lượng từ u sang v:
		// E(u,v)
		// nếu fmin[v] > E(u,v) + fmin(u) => fmin[v] = E(u,v) + fmin(u);
		// trace[v] = u
		// end dijikstra
		// return fmin[endPoint] == maxInt ? -1 : fmin[endPoint]

		// array to store min energy from start point
		int[][] fmin = new int[marsMap.length][marsMap[0].length];
		for (int[] a : fmin) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
		fmin[startPoint[0]][startPoint[1]] = 0;

		boolean[][] fixed = new boolean[marsMap.length][marsMap[0].length];
		// run dijikstra
		do {
			int minEnergy = Integer.MAX_VALUE;
			int[] nextPoint = null;
			for (int i = 0; i < fmin.length; i++) {
				for (int j = 0; j < fmin[0].length; j++) {
					if (!fixed[i][j] && fmin[i][j] < minEnergy) {
						minEnergy = fmin[i][j];
						nextPoint = new int[] { i, j };
					}
				}
			}
			// not found
			if (nextPoint == null) {
				break;
			}
			fixed[nextPoint[0]][nextPoint[1]] = true;
			// lan rong
			for (int i = 0; i < 4; i++) {
				int x1 = nextPoint[0] + x[i];
				int y1 = nextPoint[1] + y[i];
				if (x1 < 0 || x1 >= x_length) {
					continue;
				}
				if (y1 < 0 || y1 >= y_length) {
					continue;
				}
				if (marsMap[x1][y1] == -1) {
					continue;
				}
				int tmp = getEnergy(marsMap[nextPoint[0]][nextPoint[1]], marsMap[x1][y1]);
				if (fmin[x1][y1] > tmp + fmin[nextPoint[0]][nextPoint[1]]) {
					fmin[x1][y1] = tmp + fmin[nextPoint[0]][nextPoint[1]];
				}
			}

		} while (true);

		return fmin[endPoint[0]][endPoint[1]] == Integer.MAX_VALUE ? -1 : fmin[endPoint[0]][endPoint[1]];
	}

	int getEnergy(int x, int y) {
		if (y > x) {
			return 2 * (y - x);
		}
		return x - y;
	}

}
