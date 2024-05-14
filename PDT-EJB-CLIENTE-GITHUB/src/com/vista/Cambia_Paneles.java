package com.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Cambia_Paneles {
	  //
  private JPanel container;
  private JPanel content;


  /**
   * Constructor de clase
   */
  public Cambia_Paneles(JPanel container, JPanel content) {
      this.container = container;
      this.content = content;
      this.container.removeAll();
      this.container.revalidate();
      this.container.repaint();
      
      this.container.add(this.content, BorderLayout.CENTER);
      this.container.revalidate();
      this.container.repaint();
  }

}
