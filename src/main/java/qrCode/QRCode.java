package qrCode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class QRCode {
    static char[] lowerArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] upperArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] numberArr = "0123456789".toCharArray();


    public static String shuffle(char[] str) {
        List<Character> characters = new ArrayList<Character>();
        for (char c : str) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(str.length);
        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    public static String makePassword(int n, boolean Upper, boolean Lower, boolean Digit) {
        if (!(Upper | Lower | Digit) || n > 62)
            return "";
        char str[] = new char[n];
        int i = 0;
        List<Character> upperCase = new ArrayList<Character>();
        if (Upper && i < n) {
            for (char c : upperArr) {
                upperCase.add(c);
            }
            int x = (int) (Math.random() * upperCase.size());
            str[i++] = upperCase.remove(x);
        }
        List<Character> lowerCase = new ArrayList<Character>();
        if (Lower && i < n) {
            for (char c : lowerArr) {
                lowerCase.add(c);
            }
            int x = (int) (Math.random() * lowerCase.size());
            str[i++] = lowerCase.remove(x);
        }
        List<Character> numbers = new ArrayList<Character>();
        if (Digit && i < n) {
            for (char c : numberArr) {
                numbers.add(c);
            }
            int x = (int) (Math.random() * numbers.size());
            str[i++] = numbers.remove(x);
        }
        int ran = 0;
        while (i < n) {
            int at = (int) Math.ceil(Math.random() * 3);
            if (Lower && at < 2 && 0 < lowerCase.size()) {
                int x = (int) (Math.random() * lowerCase.size());
                str[i++] = lowerCase.remove(x);
            } else if (Upper && at == 2 && 0 < upperCase.size()) {
                int x = (int) (Math.random() * upperCase.size());
                str[i++] = upperCase.remove(x);
            } else if (Digit && 0 < numbers.size()) {
                int x = (int) (Math.random() * numbers.size());
                str[i++] = numbers.remove(x);
            }
            ran++;
        }
        return shuffle(str);
    }

    public static void main(String[] args) {
        String data = makePassword(16, true, true, true);
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);

//        try {
//            BufferedImage bufferedImage = createQR(data, charset, hashMap, 200, 200);
//        } catch (UnsupportedEncodingException | WriterException e) {
//            e.printStackTrace();
//        }

    }


    private static BufferedImage createQR(String data, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap, int width, int height) throws UnsupportedEncodingException, WriterException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, width, height);
        return MatrixToImageWriter.toBufferedImage(matrix);
    }


    public static String decodeQRImage(BufferedImage bufferedImage) throws NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
        return new MultiFormatReader().decode(binaryBitmap).getText();
    }
}
