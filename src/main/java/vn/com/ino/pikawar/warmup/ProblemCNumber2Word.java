package vn.com.ino.pikawar.warmup;

/**
 * @author HieuNH5
 *
 *         Viết chương trình chuyển đổi chuỗi số thành lời việt Rule chung :
 * 
 *         Chuỗi output là chữ thường , giữa các từ cách nhau đúng 1 khoảng
 *         trắng ( space ) Giả định dữ liệu nhập luôn đúng Giả định số lớn nhất
 *         là 15 số : 999 999 999 999 999
 * 
 *         Các trường hợp đặc biệt :
 * 
 *         Case 1 :"mười/mươi". Do ko có dấu nên case này dễ xử lý hơn bình
 *         thường "10" ==>"muoi" "12"==> "muoi hai" "22"==>" hai mươi hai"
 * 
 *         Case 2 : "khong tram" Rule : Nếu số hàng trăm bằng 0 , và đằng trước
 *         có số liệu ,thì luôn phải có đệm "khong tram" Ví dụ : "10000001" ==>
 *         muoi trieu khong tram le mot
 * 
 *         Case 3 : "le" Rule : Nếu số hàng chục =0 và đằng trước có số liệu thì
 *         luôn phải đệm "le" Ví dụ : "10000000000001" ==> muoi ngan ty khong
 *         tram le mot
 * 
 *         Case 4 : "bon/tu" Rule : ( Nếu số hàng chục liền kề trước đó <2 thì
 *         số 4 ở hàng đơn vị đọc là bốn , các trường hợp còn lại đọc là "tư" )
 * 
 *         "14" ==> "muoi bon"
 * 
 *         "24" ==> "hai muoi tu"
 * 
 *         "114" ==> "mot tram muoi bon"
 * 
 *         "224"==>"hai tram hai muoi tu­"
 * 
 *         "204" ==> "hai tram le bon"
 * 
 *         Case 5 : "nam/lam" Rule : ( Nếu số hàng chục liền kề trước đó <1 thì
 *         số 5 ở hàng đơn vị đọc là "năm", các trường hợp còn lại đọc là "lăm"
 *         )
 * 
 *         "15" ==> "muoi lam" "24" ==> "ha5 muoi lam"
 * 
 *         "115" ==> "mot tram muoi lam"
 * 
 *         "225"==>"hai tram hai muoi lam­"
 * 
 *         "205"==> "hai tram le nam"
 */
public class ProblemCNumber2Word {
	String[] numbers = { "khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin" };

	String convert(String number) {
		// 999 999 999 999 999
		return sixDigit(number);
	}

	String sixDigit(String number) {
		String result = " ";
		int n = Integer.parseInt(number);
		int firstThreeDigit = n / 1000;

		int tram = firstThreeDigit / 100;
		int chuc = (firstThreeDigit % 100) / 10;
		int donvi = (firstThreeDigit % 10);
		if (tram > 0) {
			result += numbers[tram] + " tram ";
		}
		if (chuc > 0) {
			if (chuc == 1) {
				result += " muoi ";
			} else
				result += numbers[chuc] + " chuc ";
		}
		if (donvi > 0) {
			result += numbers[donvi];
		}
		if (firstThreeDigit > 0)
			result += " ngan ";
		int lastThreeDigit = n % 1000;
		result += threeDigit(lastThreeDigit + "", firstThreeDigit > 0);
		return result.replaceAll("\\s{2,}", " ").trim();
	}

	String threeDigit(String number, boolean f) {
		String result = " ";
		int n = Integer.parseInt(number);
		int tram = n / 100;
		int chuc = (n % 100) / 10;
		int donvi = (n % 10);
		if (tram > 0) {
			result += numbers[tram] + " tram ";
			if (chuc > 0) {
				if (chuc == 1) {
					result += " muoi ";
				} else {
					result += numbers[chuc] + " muoi ";
				}
				if (donvi > 0) {
					if (chuc >= 1 && donvi == 5) {
						result += " lam ";
					} else {
						result += numbers[donvi];
					}
				}
			} else {
				if (donvi > 0) {
					result += " le ";
					result += numbers[donvi];
				}
			}
		} else {
			if (f) {
				result += " khong tram ";
			}
			if (chuc > 0) {
				if (chuc == 1) {
					result += " muoi ";
				} else {
					result += numbers[chuc] + " muoi ";
				}
				if (donvi > 0) {
					if (chuc >= 1 && donvi == 5) {
						result += " lam ";
					} else {
						result += numbers[donvi];
					}
				}
			} else {
				result += numbers[donvi];
			}
		}
		return result.replaceAll("\\s{2,}", " ").trim();
	}
}
