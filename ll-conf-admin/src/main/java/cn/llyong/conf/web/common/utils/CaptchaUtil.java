package cn.llyong.conf.web.common.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-04
 * @time: 2:04 下午
 * @version: 1.0
 */
public class CaptchaUtil {

    /**
     * 验证码图片的长和宽
     */
    private int weight = 100;
    private int height = 40;
    /**
     * 用来保存验证码的文本内容
     */
    private String text;
    private Random r = new Random();
    //private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};   //字体数组

    private String[] fontNames = {"Georgia"};
    /**
     * 验证码数组
     */
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    /**
     * 获取随机的颜色
     *
     * @return
     */
    private Color randomColor() {
        int r = this.r.nextInt(225);
        int g = this.r.nextInt(225);
        int b = this.r.nextInt(225);
        return new Color(r, g, b);
    }

    /**
     * 获取随机字体
     *
     * @return
     */
    private Font randomFont() {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        //随机获取字体的样式，0是无样式，1是加粗，2是斜体，3是加粗加斜体
        int style = r.nextInt(4);
        //随机获取字体的大小
        int size = r.nextInt(10) + 20;
        //返回一个随机的字体
        return new Font(fontName, style, size);
    }

    /**
     * 获取随机字符
     *
     * @return
     */
    private char randomChar() {
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 画干绕线，防止被计算机自动解析
     *
     * @param image
     */
    private void drawLine(BufferedImage image) {
        //干绕线数量
        int num = r.nextInt(10);
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = r.nextInt(weight);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(weight);
            int y2 = r.nextInt(height);
            g.setColor(randomColor());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 创建图片
     *
     * @return
     */
    private BufferedImage createImage() {
        //创建图片缓冲区
        BufferedImage image = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置背景色随机
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, weight, height);
        //返回一个图片
        return image;
    }

    public BufferedImage getImage() {
        BufferedImage image = createImage();
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        StringBuilder sb = new StringBuilder();
        //画四个字符即可
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            //定义字符的x坐标
            float x = i * 1.0F * weight / 4;
            g.setFont(randomFont());
            g.setColor(randomColor());
            g.drawString(s, x, height - 5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    /**
     * 获取验证码文本
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     * //将验证码图片写出的方法
     *
     * @param image
     * @param out
     * @throws IOException
     */
    public void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

}
