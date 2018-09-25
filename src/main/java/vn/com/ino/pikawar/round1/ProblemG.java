package vn.com.ino.pikawar.round1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.com.ino.pikawar.round1.g.Graph;
import vn.com.ino.pikawar.round1.g.Vertex;

/**
 * @author HieuNH5
 * 
 *         Công ty Fsoft cho Việt nghỉ làm đi du lịch.
 * 
 *         Việt là 1 người tiết kiệm nên anh ta muốn sử dụng chi phí thấp nhất
 *         để đi du lịch. Anh ta xuất phát từ tỉnh X và muốn đến tỉnh Y với chi
 *         phí đi lại là thấp nhất.
 * 
 *         Việt có một danh sách cùng chi phí đi lại giữa 2 tỉnh bất kì. Hãy tìm
 *         ra 1 lộ trình đi lại sao cho chi phí đi lại của Việt là thấp nhất
 * 
 *         Nếu có nhiều hơn 1 lộ trình, hãy chỉ ra lộ trình có thứ tự từ điển
 *         theo tên các tỉnh đã chuẩn hóa là nhỏ nhất (giả thiết luôn luôn có ít
 *         nhất 1 lộ trình)
 * 
 *         Ví dụ lộ trình từ A đến B và A đến C có chi phí là bằng nhau, thì lựa
 *         chọn lộ trình từ A đến B
 * 
 *         Ví dụ:
 * 
 * 
 * 
 *         Với bản đồ đi lại như bên dưới, nếu Việt muốn đi từ Bắc Giang tới Hà
 *         Nội, thì lộ trình anh ta nên đi là Bắc Giang -> Bắc Ninh -> Hà Nội
 *         (với tổng chi phí là 34000). Mặc dù có đường đi thẳng từ Bắc Giang
 *         tới Hà Nội, nhưng đường đi này tốn tới 60000đ. Cũng có 1 lộ trình
 *         khác là Bắc Giang -> Thái Nguyên -> Hà Nội cũng tốn chi phí 34000,
 *         nhưng lộ trình này có thứ tự từ điển đứng sau lộ trình Bắc Giang ->
 *         Bắc Ninh -> Hà Nội
 * 
 * 
 *         Input/output:
 * 
 *         [input] string X
 * 
 *         thành phố mà Việt xuất phát [input] string Y
 * 
 *         thành phố mà Việt muốn đến
 * 
 *         [input] list of path
 * 
 *         mỗi phần từ trong danh sách gồm 3 xâu kí tự: tỉnh xuất phát (xâu kí
 *         tự gồm các kí tự a-zA-Z và dấu cách), tỉnh kết thúc (xâu kí tự gồm
 *         các kí tự a-zA-Z và dấu cách), chi phí đi lại (1 chiều) giữa 2 tỉnh
 *         này (chi phí là số nguyên dương khác 0).
 * 
 *         Giả thiết dữ liệu đầu vào là đúng, ko có trường hợp tỉnh xuất phát và
 *         kết thúc giống nhau. Trong bộ dữ liệu ko có tên các tỉnh mà khi chuẩn
 *         hóa thì giống nhau (ví dụ "Ha noi" và "HA NOI")
 * 
 *         Giả sử số thành phố khác nhau là nhỏ hơn 100. Danh sách các đường đi
 *         là nhỏ hơn 1000
 * 
 *         [output] string
 * 
 *         Thể hiện lộ trình mà Việt nên đi theo format "{X;X1;X2,...;Y}". Lộ
 *         trình xuất phát từ tỉnh X, và kết thúc tại tỉnh Y với chi phí đi lại
 *         là nhỏ nhất và có thứ tự từ điển khi đã chuẩn hóa là nhỏ nhất
 * 
 *         Các tỉnh xuất hiện trong lộ trình của Việt nên được chuẩn hóa (viết
 *         hoa chữ cái đầu của mỗi từ, các chữ còn lại viết thường. Ví dụ "bAc
 *         giAng" thì chuẩn hóa thành "Bac Giang"
 * 
 */

public class ProblemG {

	String travelPath(String start, String end, String[][] paths) {
		// get all cities
		Graph g = new Graph();
		Set<String> cities = new HashSet<String>();
		for (String[] path : paths) {
			cities.add(path[0]);
			cities.add(path[1]);
		}
		for (String city : cities) {
			List<Vertex> neighbors = new ArrayList<Vertex>();
			for (String[] path : paths) {
				if (city.equals(path[0])) {
					neighbors.add(new Vertex(path[1], Integer.parseInt(path[2])));
				}
				if (city.equals(path[1])) {
					neighbors.add(new Vertex(path[0], Integer.parseInt(path[2])));
				}
			}
			g.addVertex(city, neighbors);
		}
		List<String> shortestPaths = g.getShortestPath(start, end);
		String result = start;
		for (int i = shortestPaths.size() - 1; i >= 0; i--) {
			result += ";" + shortestPaths.get(i);
		}
		return result;
	}

}
