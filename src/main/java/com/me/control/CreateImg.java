package com.me.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.me.utils.MakeNum;


@WebServlet("/createImg")
public class CreateImg extends HttpServlet {
      
    /**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.createImg(request, response);
	}

	public void createImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 6.通知客户机以图片方式打开发送过去的数据
		response.setHeader("Content-Type", "image/jpeg");
		// 1.在内存中创建一副图片
		BufferedImage image = new BufferedImage(60, 30,
				BufferedImage.TYPE_INT_RGB);
		// 2.向图片上写数据
		Graphics g = image.getGraphics();
		// 设背景色
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 60, 30);
		// 3.设置写入数据的颜色和字体
		g.setColor(Color.RED);
		g.setFont(new Font(null, Font.BOLD, 20));
		// 4.向图片上写数据
		String num = MakeNum.makeNum();
		//这句话就是把随机生成的数值，保存到session
		request.getSession().setAttribute("checkcode", num); 
		g.drawString(num, 0, 20);
		// 5.把写好数据的图片输出给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}