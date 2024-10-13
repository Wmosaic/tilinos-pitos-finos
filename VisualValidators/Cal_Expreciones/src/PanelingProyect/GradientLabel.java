package PanelingProyect;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GradientLabel extends JPanel {
   private Color[] colors;
   private float[] fractions;
   private double angle;
   private GradientType gradientType;

   public enum GradientType {
      LINEAR, RADIAL
   }

   public GradientLabel(Color color1, Color color2, double angle) {
      this(new Color[]{color1, color2}, new float[]{0.0f, 1.0f}, angle, GradientType.LINEAR);
   }

   public GradientLabel(Color[] colors, float[] fractions, double angle, GradientType gradientType) {
      this.colors = colors;
      this.fractions = fractions;
      this.angle = angle;
      this.gradientType = gradientType;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      int width = getWidth();
      int height = getHeight();

      switch (gradientType) {
         case LINEAR:
            double radians = Math.toRadians(angle);
            double x1 = width * Math.cos(radians);
            double y1 = height * Math.sin(radians);

            LinearGradientPaint angleGradient = new LinearGradientPaint(
                    new Point2D.Double(0, 0),
                    new Point2D.Double(x1, y1),
                    fractions,
                    colors
            );
            g2d.setPaint(angleGradient);
            g2d.fillRect(0, 0, width, height);
            break;

         case RADIAL:
            RadialGradientPaint radialGradient = new RadialGradientPaint(
                    new Point2D.Double((double) width / 2, (double) height / 2), // Centro del degradado
                    (float) Math.min(width, height) / 2, // Radio del degradado
                    fractions,
                    colors
            );

            g2d.setPaint(radialGradient);
            g2d.fillRect(0, 0, width, height);
            break;

         // Puedes añadir más casos aquí para otros tipos de degradado
      }
   }
}