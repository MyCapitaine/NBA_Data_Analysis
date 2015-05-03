package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class PlayerDetailPanel extends JPanel {
	private PlayerDetailPanel playerDetailPanel;
	private PlayerDetailFrame playerDetailFrame;
	private DataPanel dataPanel;
	private TableGroup seasonAvgData, seasonSumData, recentData;
	private JLabel seasonLabel, avgLabel, sumLabel, recentLabel;
	private PlayerPO playerPO;
	
	private static final int PADDING = 5;
	private static final int 
	    DATA_PANEL_HEIGHT = 240,
	    SEASON_AVG_DATA_TABLE_HEIGHT = 120,
	    SEASON_SUM_DATA_TABLE_HEIGHT = SEASON_AVG_DATA_TABLE_HEIGHT,
	    RECENT_DATA_TABLE_HEIGHT = 160,
	    SEASON_LABEL_HEIGHT = 30,
	    AVG_LABEL_HEIGHT = 15,
	    SUM_LABEL_HEIGHT = AVG_LABEL_HEIGHT,
	    RECENT_LABEL_HEIGHT = 30;
	
	public PlayerDetailPanel(PlayerPO p, PlayerDetailFrame f) {
		playerPO = p;
		playerDetailFrame = f;
		playerDetailPanel = this;
		setBounds(0, 0, playerDetailFrame.getWidth(), playerDetailFrame.getHeight());
		setLayout(null);
		
		dataPanel = new DataPanel(playerPO);
		dataPanel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
		add(dataPanel);
		
		seasonLabel = new JLabel("赛季数据", JLabel.LEFT);
		seasonLabel.setOpaque(true);
		seasonLabel.setFont(new Font("default", 0, 13));
		seasonLabel.setBackground(Color.black);
		seasonLabel.setForeground(Color.white);
		seasonLabel.setBounds(
				PADDING, dataPanel.getY() + dataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		add(seasonLabel);
		
		avgLabel = new JLabel("赛季场均", JLabel.LEFT);
		avgLabel.setOpaque(true);
		avgLabel.setFont(new Font("default", 0, 11));
		avgLabel.setBackground(Color.gray);
		avgLabel.setForeground(Color.white);
		avgLabel.setBounds(
				PADDING, seasonLabel.getY() + seasonLabel.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, AVG_LABEL_HEIGHT);
		add(avgLabel);
		
		seasonAvgData = new TableGroup();
		TableFactory.createTable(
				seasonAvgData, playerDetailFrame,
				TableContentTransfer.transferPlayerAvgInfo(playerPO),
				Config.UI_WIDTH - PADDING * 2, SEASON_AVG_DATA_TABLE_HEIGHT,
				PADDING, avgLabel.getY() + avgLabel.getHeight());
		paintTable(seasonAvgData.table);
		
		sumLabel = new JLabel("赛季总计", JLabel.LEFT);
		sumLabel.setOpaque(true);
		sumLabel.setFont(new Font("default", 0, 11));
		sumLabel.setBackground(Color.gray);
		sumLabel.setForeground(Color.white);
		sumLabel.setBounds(
				PADDING, seasonAvgData.jsp.getY() + seasonAvgData.jsp.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, SUM_LABEL_HEIGHT);
		add(sumLabel);
		
		seasonSumData = new TableGroup();
		TableFactory.createTable(
				seasonSumData, playerDetailFrame,
				TableContentTransfer.transferPlayerTotalInfo(playerPO),
				Config.UI_WIDTH - PADDING * 2, SEASON_SUM_DATA_TABLE_HEIGHT,
				PADDING, sumLabel.getY() + sumLabel.getHeight());
		paintTable(seasonSumData.table);
		
		recentLabel= new JLabel("最近五场比赛", JLabel.LEFT);
		recentLabel.setFont(new Font("default", 0, 13));
		recentLabel.setBackground(Color.black);
		recentLabel.setForeground(Color.white);
		recentLabel.setOpaque(true);
		recentLabel.setBounds(
				PADDING, seasonSumData.jsp.getY() + seasonSumData.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, RECENT_LABEL_HEIGHT);
		add(recentLabel);
		
		recentData = new TableGroup();
		TableFactory.createTable(
				recentData, playerDetailFrame,
				TableContentTransfer.transferPlayerRecentGameInfo(playerPO),
				Config.UI_WIDTH - PADDING * 2, RECENT_DATA_TABLE_HEIGHT,
				PADDING, recentLabel.getY() + recentLabel.getHeight());
		paintTable(recentData.table);
		
	}
	
	private void paintTable(JTable table) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if(row == 0) setBackground(new Color(0, 0, 0, 90));
				else if(row % 2 != 0) setBackground(new Color(0, 0, 0, 40));
				else setBackground(new Color(0, 0, 0, 0));
				
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
			
		};
		
		table.setDefaultRenderer(Object.class, dtcr);
	}
	
	private static final int
	    HEAD_LABEL_WIDTH = 140,
	    HEAD_LABEL_X = 20,
	    INFO_WIDTH = 500
	    ;
	private static final String PLAYER_DETAIL_TOP_BG = "images/player_detail_bg.png";
	class DataPanel extends JPanel {
		public JLabel bgLabel;
		public JLabel headLabel, teamLabel;
		public JLabel 
		    ballNum,
		    name;
		public JLabel
		    info1, info2, info3, info4, info5, info6;
		
		
		public DataPanel(PlayerPO p) {
			setLayout(null);
			bgLabel = new JLabel();
			PlayerDetailPanel.fillLabel(PLAYER_DETAIL_TOP_BG, bgLabel, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT, playerDetailPanel.getBackground());
			bgLabel.setBounds(0, 0, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
			add(bgLabel);
			
			headLabel = new JLabel();
			PlayerDetailPanel.fillLabel(p.getActionURL(), headLabel, HEAD_LABEL_WIDTH, DATA_PANEL_HEIGHT, playerDetailPanel.getBackground());
			headLabel.setBounds(HEAD_LABEL_X, 0, HEAD_LABEL_WIDTH, DATA_PANEL_HEIGHT);
			add(headLabel);
			
			
			ballNum = new JLabel(p.getNumber());
			name = new JLabel(p.getName());
			
			info1 = new JLabel(p.getHeight() + "/" + p.getWeight());
			add(info1);
			info2 = new JLabel(p.getBirth());
			add(info2);
			info3 = new JLabel(p.getPosition());
			add(info3);
			info4 = new JLabel(p.getExp());
			add(info4);

			teamLabel = new JLabel();
			
		}
	}
	
	public static void fillLabel(String url, JLabel label, int width, int height, Color bg) {
		Image i = null;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		try {
			i = ImageIO.read(new File(url));
		} catch(IOException e) {
			e.printStackTrace();
		}
		bi.getGraphics().drawImage(i, 0, 0, width, height, bg, null);
		label.setIcon(new ImageIcon((Image)bi));
	}
}
