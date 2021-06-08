package kr.co.gda.qr;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class App extends JFrame {
	static Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws WriterException, IOException {
        log.info( "Hello World!" );
        
        // QR 서비스 생성자
        QRService qrService = new QRService();
        
        // userName, systemInfo, networkInfo 생성
        String userName = qrService.getUserName();
        String systemInfo = qrService.getSystemInfo();
        String networkInfo = qrService.getNetworkInfo();
        
        // contents StringBuffer으로 생성. String은 
        StringBuffer contents = new StringBuffer();
        
        // contents에 userName , systemInfo, networkInfo 입력
        contents.append(userName);
        log.info(userName);
        contents.append(","+systemInfo);
        log.info(systemInfo);
        contents.append(","+networkInfo);
        log.info(networkInfo);
        
        // QR코드 설정
        QRCodeWriter qrWriter = new QRCodeWriter();
        BitMatrix martix = qrWriter.encode(contents.toString(), BarcodeFormat.QR_CODE, 300, 300);
        // MatrixToImageConfig config = new MatrixToImageConfig(0xFFFFFFFF, 0xFF000000); 
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(martix);
        
        // 이미지 파일 생성
        String imageFileName = "myqr.png";
        ImageIO.write(qrImage, "png", new File(imageFileName)); 
        
        // 스윙 생성.
        App app = new App();
        app.setTitle("QR");
        app.setLayout(new FlowLayout());
        
        ImageIcon icon = new ImageIcon(imageFileName);
        JLabel imageLabel = new JLabel(icon);
        app.add(imageLabel);
        
        app.setSize(400, 400);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}