package cn.swust.functest.datajudge;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.swust.functest.RegularTextField;
import cn.swust.functest.moneyjudge.ChangeMoneyFrameV3.moneyType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author 阿文
 *日期增加程序
 *1.无法分辨闰年的问题
 *2.对于年月,月份没有判断真伪
 *3.对于输入错误不会报错
 *4.每个月都是30天
 */
public class datejudgeV1 extends JFrame{
	private String nyear;
	private String nmonth;
	private String nday;
	private static final long serialVersionUID = 1L;
	RegularTextField yearSide;
	RegularTextField monthSide;
	RegularTextField daySide;
	JLabel result,year,month,day;//关于结果的显现
	
	public datejudgeV1(){
		 
			setTitle("功能测试3_求解2天后的日期");
			getContentPane().setLayout(null);//设置格式清空
			
			JLabel label = new JLabel("功能测试1—日期的增加");
			label.setForeground(Color.BLUE);
			label.setBounds(10, 31, 200, 18);
			getContentPane().add(label);//frame 是个窗口, getContentPane是获取窗口的面板, 然后把 label add到面板中
			
			JLabel label_1 = new JLabel("V1");
			label_1.setForeground(Color.RED);
			label_1.setFont(new Font("Arial", Font.BOLD, 22));
			label_1.setBounds(188, 10, 72, 18);
			getContentPane().add(label_1);
			
			JLabel lblA = new JLabel("年输入：");
			lblA.setBounds(10, 65, 54, 18);
			getContentPane().add(lblA);
			
			JLabel lblB = new JLabel("月输入：");
			lblB.setBounds(10, 109, 54, 18);
			getContentPane().add(lblB);
			
			JLabel lblC = new JLabel("日输入：");
			lblC.setBounds(10, 154, 54, 18);
			getContentPane().add(lblC);
			//《《《《《《《
			JLabel lblE = new JLabel("年：");
			lblE.setBounds(286, 65, 54, 18);
			getContentPane().add(lblE);
			
			JLabel lblF = new JLabel("月：");
			lblF.setBounds(286, 109, 54, 18);
			getContentPane().add(lblF);
			
			JLabel lblG = new JLabel("日：");
			lblG.setBounds(286, 154, 54, 18);
			getContentPane().add(lblG);
			//《《《《《《《
			 yearSide = new RegularTextField();
			yearSide.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
						monthSide.requestFocusInWindow();
					} 
				}
			});
			yearSide.setRegularText("");
			yearSide.setName("yearSide");
			yearSide.setColumns(10);
			yearSide.setBounds(74, 63, 93, 24);
			getContentPane().add(yearSide);
			//《《《《《《
			monthSide = new RegularTextField();
			monthSide.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
						daySide.requestFocusInWindow();
					} 
				}
			});
			
			monthSide.setRegularText("");
			monthSide.setName("monthSide");
			monthSide.setColumns(10);
			monthSide.setBounds(74, 107, 93, 24);
			getContentPane().add(monthSide);
			//《《《《《《《
			daySide = new RegularTextField();
			daySide.setRegularText("");
			daySide.setName("daySide");
			daySide.setColumns(10);
			daySide.setBounds(74, 152, 93, 24);
			
			daySide.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {//回车
						yearSide.requestFocusInWindow();//焦点的变换
					} 
				}
			});
			getContentPane().add(daySide);
			//《《《《《《《《
			JButton judgeBtn = new JButton("日期转换");
			judgeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			judgeBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					showResult();				
				}
			});
			judgeBtn.setName("judgeBtn");
			judgeBtn.setBounds(179, 105, 93, 27);
			getContentPane().add(judgeBtn);
			//《《《《《《按键
			result = new JLabel("结果：");
			result.setVisible(false);
			result.setName("result");
			result.setDisplayedMnemonic(KeyEvent.VK_ENTER);
			result.setBounds(286, 31, 187, 18);
			getContentPane().add(result);
			
			year = new JLabel("年：");
			year.setVisible(false);
			year.setName("number");
			year.setDisplayedMnemonic(KeyEvent.VK_ENTER);
			year.setBounds(286, 65, 54, 18);
			getContentPane().add(year);
			
			month = new JLabel("月：");
			month.setVisible(false);
			month.setName("number");
			month.setDisplayedMnemonic(KeyEvent.VK_ENTER);
			month.setBounds(286, 109, 54, 18);
			getContentPane().add(month);
			
			day = new JLabel("日：");
			day.setVisible(false);
			day.setName("number");
			day.setDisplayedMnemonic(KeyEvent.VK_ENTER);
			day.setBounds(286, 154, 54, 18);
			getContentPane().add(day);
		}
	
		public interface dateType{//接口
			int Errordate = 0;
			int exist = 1;
			int error = 2;
		}
		
		public int check() {
			int year,month,day;
				year = Integer.parseInt(yearSide.getText());//从区域中拿去数值
				month = Integer.parseInt(monthSide.getText());
				day = Integer.parseInt(daySide.getText());
			int a[]= {0,30,30,30,30,30,30,30,30,30,30,30,30};
					day=day+2;
					if(day>a[month])
					{day=day-a[month];month=month+1;}
					if(month>12)
					{year=year+1;month=1;}
					nyear=String.valueOf(year);
					nmonth=String.valueOf(month);
					nday=String.valueOf(day);
					return dateType.exist;
		}
		
		private void showResult()
		{
			int iresult = check();//通过这个函数来判断它的实际类型
			switch (iresult)
			{//通过接口来判别类型
			case dateType.exist:
				result.setText("结果：日期显示如下");
				result.setForeground(Color.BLUE);
				result.setVisible(true);//显现窗口
				year.setText("年    "+nyear);
				year.setForeground(Color.black);
				year.setVisible(true);//显现窗口
				month.setText("月  "+nmonth);
				month.setForeground(Color.black);
				month.setVisible(true);//显现窗口
				day.setText("日  "+nday);
				day.setForeground(Color.black);
				day.setVisible(true);//显现窗口
				break;
	
			}
		}
		
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		datejudgeV1 frame = new datejudgeV1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 250);
		frame.setVisible(true); 
	}

}
