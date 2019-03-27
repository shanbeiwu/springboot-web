package com.example.springboot.tools;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 创建二维码工具类，用于生成二维码
 */
public class CreatQRCode {

    /**
     * 创建二维码
     * @param qrData  生成二维码中要存储的信息
     * @param path  二维码图片存储路径
     * @return boolean
     */
    public static boolean creatQrcode(@NotNull String qrData, @NotNull String path) {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');//设置纠错等级（分为L, M, H三个等级）
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其他字符
        qrcode.setQrcodeVersion(7);//版本

        try{
            //设置一下二维码的像素
            int width = 67 + 12 * (7 - 1);
            int height = 67 + 12 * (7 - 1);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //绘图
            Graphics2D gs = bufferedImage.createGraphics();
            gs.setBackground(Color.white);
            gs.setColor(Color.BLACK);
            gs.clearRect(0, 0, width, height);//清楚一下画板内容

            //设置下偏移量，如果不加偏移量，有时会导致出错
            int pixoff = 2;

            byte[] bytes = qrData.getBytes("utf-8");
            if (bytes.length > 0 && bytes.length < 120) {
                boolean[][] s = qrcode.calQrcode(bytes);
                for (int i = 0; i < s.length; i++) {
                    for (int j = 0; j < s.length; j++) {
                        if (s[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            }
            gs.dispose();
            bufferedImage.flush();
            ImageIO.write(bufferedImage, "png", new File(path));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }
    }

    /**
     * 解析二维码
     * @param imgPath 图片路径
     * @return String 二维码内容
     */
    public String decoderQRCode(@NotNull String imgPath) {
        //QRCode 二维码图片文件
        File imageFile = new File(imgPath);
        BufferedImage bufferedImage = null;
        String content = null;
        try {
            bufferedImage = ImageIO.read(imageFile);
            QRCodeDecoder decoder = new QRCodeDecoder();
            content = new String(decoder.decode(new TwoDimensionCodeImage(bufferedImage)), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error:" + e.getMessage());
        } catch (DecodingFailedException e) {
            System.out.println("error:" + e.getMessage());
            e.printStackTrace();
        }
        return content;
    }

    private class TwoDimensionCodeImage implements QRCodeImage {
        //bufferedImage作用将一幅图片加载到内存中
        BufferedImage bufferedImage;
        public TwoDimensionCodeImage(BufferedImage bufferedImage) {
            this.bufferedImage = bufferedImage;
        }

        @Override
        public int getWidth() {
            return bufferedImage.getWidth();//返回像素宽度
        }

        @Override
        public int getHeight() {
            return bufferedImage.getHeight();//返回像素高度
        }

        @Override
        public int getPixel(int i, int i1) {
            return bufferedImage.getRGB(i, i1);//得到长宽值，即像素值，i， i1代表像素值
        }
    }
}
