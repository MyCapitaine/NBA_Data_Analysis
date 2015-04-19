package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Enum.Season;

import com.kmno4.common.Config;

import javax.swing.JComboBox;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MatchSelectionPanel extends JPanel {
	JPanel seasonPanel;
	JLabel 
	    lb_firstSeason,
		lb_secondSeason,
		lb_thirdSeason,
		lblNewLabel_1,
		lb_vs;
	JComboBox<String> 
	    comboBox,
	    comboBox_1;
	
	public MatchSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(22, 75, 186, 27);
		add(comboBox);
		
		
		seasonPanel = new JPanel();
		seasonPanel.setBounds(0, 0, 800, 45);
		seasonPanel.setBackground(new Color(0, 0, 0, 0));
		seasonPanel.setLayout(new GridLayout(1, 0));
		lb_firstSeason = new JLabel("12_13", JLabel.LEFT);
		seasonPanel.add(lb_firstSeason);
		lb_secondSeason = new JLabel("13_14", JLabel.LEFT);
		seasonPanel.add(lb_secondSeason);
		lb_thirdSeason = new JLabel("14_15", JLabel.LEFT);
		seasonPanel.add(lb_thirdSeason);
		add(seasonPanel);
		lb_firstSeason.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeSeason(Season.season12_13);
			}
		});
		lb_secondSeason.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeSeason(Season.season13_14);
			}
		});
		lb_thirdSeason.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeSeason(Season.season14_15);
			}
		});
		
		lblNewLabel_1 = new JLabel("日历");
		lblNewLabel_1.setIcon(Config.SCHEDULE);
		lblNewLabel_1.setBounds(660, 66, 98, 43);
		add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(275, 75, 164, 27);
		add(comboBox_1);
		
		lb_vs = new JLabel("VS");
		lb_vs.setBounds(213, 79, 61, 16);
		add(lb_vs);
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(Config.MATCH_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
	}
	
	private void changeSeason(Season season) {
		//MainFrame.mainFrame.topTabPanel.refreshMatchTable();
		//TODO
	}
	
}
