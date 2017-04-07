package br.ufc.petti.certificadosflisol.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ufc.petti.certificadosflisol.entity.Participante;

public class GenerateImage {

	public static void drawName(Participante participante, String pathToModel, String pathToOutFile) throws IOException{
		
		BufferedImage bfImage = ImageIO.read(new File(pathToModel));
		Graphics g = bfImage.getGraphics();
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		g.setColor(Color.BLACK);
		
		String text = participante.getNome(); 
		
		FontMetrics fm = g.getFontMetrics();
		int x = bfImage.getWidth()/2 - fm.stringWidth(text)/2;
		
		g.drawString(text, x, 1020);
		g.dispose();
		
		ImageIO.write(bfImage, "jpg", new File(pathToOutFile));
		
	}
	
}
