package adventOfCode;

import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.ArrayList;

public class A2020 {

	public static void main(String[] args) {
		
		ArrayList<String> passwords = importFile("passwords.txt");

		
		int[] report = {1078,
				1109,
				1702,
				1293,
				1541,
				1422,
				1679,
				1891,
				1898,
				1455,
				1540,
				1205,
				1971,
				1582,
				1139,
				1438,
				1457,
				1725,
				1907,
				1872,
				1101,
				1403,
				1557,
				1597,
				1619,
				1974,
				1287,
				292,
				1647,
				1444,
				1241,
				879,
				1761,
				1067,
				1178,
				1510,
				1110,
				1233,
				1121,
				1299,
				1796,
				1124,
				1768,
				1466,
				1871,
				1279,
				1344,
				1485,
				1258,
				1179,
				1147,
				492,
				1234,
				1843,
				1421,
				1819,
				1964,
				1671,
				1793,
				1302,
				1731,
				1886,
				1686,
				1150,
				1806,
				1960,
				1841,
				1936,
				1845,
				1520,
				1779,
				1102,
				1323,
				1892,
				1742,
				1941,
				1395,
				1525,
				1165,
				715,
				1829,
				1448,
				1906,
				1191,
				1981,
				1115,
				1716,
				1644,
				1310,
				1836,
				1105,
				1517,
				1790,
				1950,
				1741,
				1256,
				1467,
				1677,
				1372,
				1838,
				1637,
				1143,
				1763,
				1222,
				1291,
				1835,
				1602,
				1927,
				1933,
				1952,
				1692,
				1662,
				1967,
				1791,
				1984,
				1176,
				1324,
				1460,
				1416,
				562,
				1862,
				1273,
				1518,
				1535,
				1093,
				1977,
				1923,
				1246,
				1570,
				1674,
				1861,
				1811,
				1431,
				47,
				1158,
				1912,
				1322,
				1062,
				1407,
				1528,
				1068,
				1868,
				1997,
				1930,
				959,
				1676,
				1759,
				2000,
				1993,
				1722,
				1738,
				1264,
				1361,
				1542,
				1187,
				1735,
				1405,
				1745,
				1753,
				1833,
				1493,
				1311,
				1547,
				1180,
				1553,
				1513,
				1812,
				1951,
				1948,
				1834,
				1925,
				1726,
				1326,
				1931,
				1962,
				1947,
				1173,
				1633,
				1901,
				1781,
				1483,
				1789,
				1417,
				1929,
				1859,
				1760,
				1347,
				1996,
				1328,
				1798,
				1230,
				1298,
				1877,
				1840,
				1607,
				1253,
				1057,
				1650,
				1171,
				1593};
		System.out.println("Day one part 1 answer: " + findNums(report));
		System.out.println("Day one part 2 answer: " + findNums3(report));
		System.out.println("Day two part 1 answer: " + findPasswords(passwords));
		

	}
	
	
	//Day one
	public static int findNums(int[] report) {
		for (int i = 0; i < report.length; i++) {
			for (int j = i; j < report.length; j++) {
				if (report[i] + report[j] == 2020) {
					int ans = report[i] * report[j];
					return ans;
				}
			}
		}
		return -1;
	}
	
	public static int findNums3(int[] report) {
		for (int i = 0; i < report.length; i++) {
			for (int j = i; j < report.length; j++) {
				for (int x = j; x < report.length; x++) {
					if (report[i] + report[j] + report[x] == 2020) {
						int ans = report[i] * report[j] * report[x];
						return ans;
					}
				}
				
			}
		}
		return -1;
	}
	
	//Day two
	public static int findPasswords(ArrayList<String> p) {
		int num = 0;
		for (int i = 0; i < p.size(); i++) {
			int min = 0;
			int max = 0;
			
			if (p.get(i).charAt(1) != '-') {
				min = ((p.get(i).charAt(0) - 48) * 10) + p.get(i).charAt(1) - 48;
				
			} else {
				min = p.get(i).charAt(0) - 48;
			}
			if (p.get(i).charAt(p.get(i).indexOf('-') + 2) != ' ') {
				max = ((p.get(i).charAt(p.get(i).indexOf('-') + 1) - 48) * 10) + p.get(i).charAt(p.get(i).indexOf('-') + 2) - 48;
				
			} else {
				max = p.get(i).charAt(p.get(i).indexOf('-') + 1) - 48;
			}
			
			char c = p.get(i).charAt(p.get(i).indexOf(' ') + 1);
			int count = 0;
			for (int j = 7; j < p.get(i).length(); j++) {
				if (p.get(i).charAt(j) == c) {
					count++;
				}
			}
			if (count >= min && count <= max) {
				num++;
			}
		}
		return num;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Copied this from other replits to get an Array of the passwords because I don't know how to do it myself
	
	public static ArrayList<String> importFile(String fileName){
		ArrayList<String> words = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return words;
	}
	
	

}
