package tr.org.linux.kamp.sezarCrypt;

import java.util.Scanner;

public class SezarCrypt {
	public static void main(String[] args) {
		
	String str=new String();
	
	Scanner sc= new Scanner(System.in);
	System.out.println("Anahtar değerini giriniz:");
	int key=sc.nextInt();
	sc.nextLine();	//next() kullandıktan sonra hata vermemesi için.  \n ile alakalıymış
					//nextInt() yazıp enter yapınca sayıdan sonra \n gönderir. yeni bir giriş bekler.
	System.out.println("Metninizi giriniz:");
	String metin=sc.nextLine();   //nextLine boşluğu da alır. next boşluk görünce durur.
	
	System.out.println("Lütfen yapmak istediğiniz işlemi seçin.\nŞifreleme için 1:\n Çözümleme için 2:");
	int choose=sc.nextInt();
	sc.nextLine();
	switch(choose) {
	case 1:
		 System.out.println(encrypt(metin, key));
		 break;
	case 2:
		System.out.println(encrypt(metin, -key));
		break;
	
	default:System.out.println("yanlış giriş yaptınız");
		}
	}
	public static String encrypt(String str, int key) {
		String result="";
		for (int i=0;i<str.length();i++) {
			if(key < 0) key = 26-(-key%26);
			if (!Character.isLetter(str.charAt(i))) {
				result+=(char)(str.charAt(i));
				
			}
			else if (Character.isUpperCase(str.charAt(i)+key))
			result+=(char)('A'+(str.charAt(i)+key-'A')%26);
			else if (Character.isLowerCase(str.charAt(i)+key))
				result+=(char)('a'+(str.charAt(i)+key-'a')%26);
			
		
		}
		return result;
	}
}
