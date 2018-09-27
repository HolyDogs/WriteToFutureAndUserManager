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
		// 6.֪ͨ�ͻ�����ͼƬ��ʽ�򿪷��͹�ȥ������
		response.setHeader("Content-Type", "image/jpeg");
		// 1.���ڴ��д���һ��ͼƬ
		BufferedImage image = new BufferedImage(60, 30,
				BufferedImage.TYPE_INT_RGB);
		// 2.��ͼƬ��д����
		Graphics g = image.getGraphics();
		// �豳��ɫ
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 60, 30);
		// 3.����д�����ݵ���ɫ������
		g.setColor(Color.RED);
		g.setFont(new Font(null, Font.BOLD, 20));
		// 4.��ͼƬ��д����
		String num = MakeNum.makeNum();
		//��仰���ǰ�������ɵ���ֵ�����浽session
		request.getSession().setAttribute("checkcode", num); 
		g.drawString(num, 0, 20);
		// 5.��д�����ݵ�ͼƬ����������
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