package kr.co.gda.qr;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class QRService {
	public String getUserName() {
		return "goodee";
	}
	
	public String getSystemInfo() {
		// String은 불변이기 때문에 변할 수 있는 StringBuffer로 sf 만듬.
		StringBuffer sf = new StringBuffer();
		// s 생성. system.getProperty()은 자바가 실행되는 곳의 정보를 얻어오거나 운영체제의 정보를 가져올때 사용.
		/* - getProperty 주요 검색어 -		 * 
		 * java.home: java를 설치한 디렉토리
		 * java.class.path: java 클래스 경로
		 * os.name: 운영체제 이름
		 * os.arch: 운영체제 아키텍쳐
		 * os.version: 운영체제 버전 정보
		 * user.name: 사용자 계정
		 * user.home: 사용자 홈 디렉토리
		 * user.dir 현재 디렉토리		 * 
		 */
		// 운영체제 이름정보 가져오기
		String s = System.getProperty("os.name");		
		// sf에 , + 운영체제 이름정보 입력
		sf.append(s);
		// 운영체제 버전 정보 가져오기
		s = System.getProperty("os.version");
		//sf에 , + 운영체제 버전 정보 입력
		sf.append(","+s);
		// sf값 반환
		return sf.toString();
	}
	
	public String  getNetworkInfo() throws UnknownHostException {
		// sf StringBuffer로 생성
		StringBuffer sf = new StringBuffer();
		// InetAddress 자바에서 IP주소를 표현할 때 사용하는 클래스,getLocalHost는 주소 찾기
		InetAddress address = InetAddress.getLocalHost();
		// s에 호스트 이름 삽입. getHostName은 호스트 이름을 문자열로 반환하는 메서드
		String s = address.getHostName();
		//sf에 호스트이름 입력
		sf.append(s);
		// s에 IP주소 삽입. getHostAddress는 IP주소를 반환하는 메서드
		s = address.getHostAddress();
		// sf에 , + IP주소 삽입 
		sf.append(","+s);
		// sf값 반환
		return sf.toString();
	}
}